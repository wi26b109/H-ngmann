package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Haengmann {
    static final int GARTEN = 0;
    static final int TIERE = 1;
    static final int PFLANZEN = 2;
    static final int ZELDA = 3;
    static final int HARRY_POTTER = 4;
    static final int POKEMON = 5;
    static final int SPIDERMAN = 6;
    static final int EIGENE = 7;
    static final int LEICHT = 0;
    static final int MITTEL = 1;
    static final int SCHWER = 2;
    static final int NORMAL_LEBEN = 8;
    static final int RESERVE = 20;
    static final int MAX_BUCHSTABEN = 26;
    static final int STUFEN = 5;
    static final String DATEI = "eigene_woerter.txt";
    static final String[] THEMEN = {"Garten", "Tiere", "Pflanzen", "Zelda",
            "Harry Potter", "Pokemon", "Spider-Man", "Eigene Woerter"};
    static final int[] HART_LEBEN = {11, 9, 6};
    static final String ROT = "\u001B[31m";
    static final String GRUEN = "\u001B[32m";
    static final String GELB = "\u001B[33m";
    static final String RESET = "\u001B[0m";
    static Wort[] woerter;
    static int anzahlWoerter;
    static final Random ZUFALL = new Random();

    record Wort(String text, int thema) {
    }

    public static void main(String[] args) {
        woerter = new Wort[RESERVE + 40];
        ladeEingeneWoerter();
        fuegeStartWoerterEin();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== GALGENMAENNCHEN 123 ===");
        boolean weiter = true;
        while (weiter) {
            int thema = waehleThema(scanner);
            if (thema == EIGENE && !hatThema(EIGENE)) {
                System.out.println("Es gibt noch keine eigenen Woerter.");
                continue;
            }
            if (thema == -1) {
                fuegeEigenesWortHinzu(scanner);
                continue;
            }
            int schwierigkeit = waehleSchwierigkeit(scanner, thema);
            int lebensmodus = waehleLebensmodus(scanner);
            spieleRunde(scanner, thema, schwierigkeit, lebensmodus);
            weiter = leseJaNein(scanner, "Nochmal spielen? (j/n): ");
        }
        speichereEigeneWoerter();
        System.out.println("Danke fuers Spielen!");
    }

    static int waehleThema(Scanner scanner) {
        System.out.println("\nThema waehlen:");
        for (int i = 0; i < THEMEN.length; i++) {
            System.out.println((i + 1) + " - " + THEMEN[i]);
        }
        System.out.println("9 - Eigenes Wort hinzufuegen");
        while (true) {
            int auswahl = leseZahl(scanner, "Auswahl: ");
            if (auswahl >= 1 && auswahl <= THEMEN.length) {
                return auswahl - 1;
            }
            if (auswahl == 9) {
                return -1;
            }
            System.out.println("Bitte eine Zahl von 1 bis 8 oder 9 eingeben.");
        }
    }

    static int waehleSchwierigkeit(Scanner scanner, int thema) {
        while (true) {
            System.out.println("\nSchwierigkeit: 1 - Leicht, 2 - Mittel, 3 - Schwer");
            int schwierigkeitswahl = leseZahl(scanner, "Auswahl: ") - 1;
            if (schwierigkeitswahl >= LEICHT && schwierigkeitswahl <= SCHWER
                    && hatSchwierigkeit(thema, schwierigkeitswahl)) {
                return schwierigkeitswahl;
            }
            if (schwierigkeitswahl >= LEICHT && schwierigkeitswahl <= SCHWER) {
                System.out.println("Dafuer gibt es in diesem Thema kein Wort.");
            } else {
                System.out.println("Ungueltige Schwierigkeit.");
            }
        }
    }

    static int waehleLebensmodus(Scanner scanner) {
        while (true) {
            System.out.println("Lebensmodus: 1 - Normal (8 Leben), 2 - Hart (11/9/6 Leben)");
            int auswahl = leseZahl(scanner, "Auswahl: ");
            if (auswahl == 1 || auswahl == 2) {
                return auswahl;
            }
            System.out.println("Bitte 1 oder 2 eingeben.");
        }
    }

    static void spieleRunde(Scanner scanner, int thema, int schwierigkeit, int lebensmodus) {
        Wort wort = zieheWort(thema, schwierigkeit);
        int maxLeben = lebensmodus == 1 ? NORMAL_LEBEN : HART_LEBEN[schwierigkeit];
        int fehler = 0;
        boolean[] geraten = new boolean[MAX_BUCHSTABEN];
        System.out.println("\n--- " + THEMEN[thema] + " ---");
        while (fehler < maxLeben && !istVollstaendig(wort.text(), geraten)) {
            zeichneLeben(thema, fehler, maxLeben);
            System.out.println("Wort: " + zeigeWort(wort.text(), geraten));
            System.out.println("Geratene Buchstaben: " + zeigeGeratene(geraten));
            String eingabe = leseEingabe(scanner, "Buchstabe oder ganzes Wort: ");
            if (eingabe.length() == 0) {
                System.out.println("Bitte etwas eingeben.");
            } else if (enthaeltUmlaut(eingabe)) {
                System.out.println("Bitte ae, oe, ue oder ss statt Umlauten und ß verwenden.");
            } else if (eingabe.length() == 1) {
                fehler += rateBuchstabe(eingabe.charAt(0), wort.text(), geraten);
            } else {
                if (eingabe.equals(wort.text())) {
                    markiereAlle(wort.text(), geraten);
                } else {
                    fehler += 2;
                    System.out.println("Falsches Wort! Das kostet 2 Leben.");
                }
            }
        }
        zeichneLeben(thema, fehler, maxLeben);
        if (istVollstaendig(wort.text(), geraten)) {
            System.out.println(GRUEN + "Gewonnen! Das Wort war " + wort.text() + "." + RESET);
        } else {
            System.out.println(ROT + "Verloren! Das Wort war " + wort.text() + "." + RESET);
        }
    }

    static int rateBuchstabe(char buchstabe, String wort, boolean[] geraten) {
        int index = buchstabe - 'A';
        if (index < 0 || index >= MAX_BUCHSTABEN) {
            System.out.println("Bitte nur Buchstaben von A bis Z verwenden.");
            return 0;
        }
        if (geraten[index]) {
            System.out.println("Diesen Buchstaben hast du schon geraten.");
            return 0;
        }
        geraten[index] = true;
        if (wort.indexOf(buchstabe) >= 0) {
            System.out.println(GRUEN + "Richtig!" + RESET);
            return 0;
        }
        System.out.println(ROT + "Falsch!" + RESET);
        return 1;
    }

    static Wort zieheWort(int thema, int schwierigkeit) {
        int anzahlPassend = 0;
        for (int i = 0; i < anzahlWoerter; i++) {
            if (woerter[i].thema() == thema
                    && bestimmeSchwierigkeit(woerter[i].text()) == schwierigkeit) {
                anzahlPassend++;
            }
        }
        int ziel = ZUFALL.nextInt(anzahlPassend);
        for (int i = 0; i < anzahlWoerter; i++) {
            if (woerter[i].thema() == thema
                    && bestimmeSchwierigkeit(woerter[i].text()) == schwierigkeit) {
                if (ziel == 0) {
                    return woerter[i];
                }
                ziel--;
            }
        }
        return woerter[0];
    }

    static int bestimmeSchwierigkeit(String wort) {
        int schwierigkeitsstufe;
        if (wort.length() <= 5) {
            schwierigkeitsstufe = LEICHT;
        } else if (wort.length() <= 8) {
            schwierigkeitsstufe = MITTEL;
        } else {
            schwierigkeitsstufe = SCHWER;
        }
        if (schwierigkeitsstufe < SCHWER
                && (wort.indexOf('J') >= 0 || wort.indexOf('Q') >= 0
                || wort.indexOf('X') >= 0 || wort.indexOf('Y') >= 0)) {
            schwierigkeitsstufe++;
        }
        return schwierigkeitsstufe;
    }

    static void zeichneLeben(int thema, int fehler, int maxLeben) {
        int stufe = fehler * STUFEN / maxLeben;
        if (stufe > STUFEN) {
            stufe = STUFEN;
        }
        System.out.print("Leben: ");
        if (thema == ZELDA) {
            for (int i = 0; i < STUFEN; i++) {
                System.out.print(i < STUFEN - stufe ? ROT + "♥ " + RESET : "♡ ");
            }
        } else if (thema == POKEMON) {
            System.out.print(GRUEN + "[" + balken(STUFEN - stufe) + "]" + RESET);
        } else if (thema == HARRY_POTTER) {
            System.out.print(stufe < STUFEN ? "Patronus " + "(Stufe " + (STUFEN - stufe) + ")" : "Dementor");
        } else if (thema == SPIDERMAN) {
            System.out.print("Faden: " + (stufe < STUFEN ? "##########".substring(stufe * 2) : "gerissen"));
        } else {
            System.out.print("Blume: " + (stufe < STUFEN ? "*****".substring(stufe) : "verwelkt"));
        }
        System.out.println();
    }

    static String balken(int gefuellt) {
        String text = "";
        for (int i = 0; i < STUFEN; i++) {
            text += i < gefuellt ? "█" : "░";
        }
        return text;
    }

    static String zeigeWort(String wort, boolean[] geraten) {
        String anzeige = "";
        for (int i = 0; i < wort.length(); i++) {
            char buchstabe = wort.charAt(i);
            anzeige += istGeraten(buchstabe, geraten) ? buchstabe + " " : "_ ";
        }
        return anzeige;
    }

    static String zeigeGeratene(boolean[] geraten) {
        String text = "";
        for (int i = 0; i < MAX_BUCHSTABEN; i++) {
            if (geraten[i]) {
                text += (char) ('A' + i) + " ";
            }
        }
        return text.length() == 0 ? "-" : text;
    }

    static boolean istVollstaendig(String wort, boolean[] geraten) {
        for (int i = 0; i < wort.length(); i++) {
            if (!istGeraten(wort.charAt(i), geraten)) {
                return false;
            }
        }
        return true;
    }

    static boolean istGeraten(char buchstabe, boolean[] geraten) {
        return buchstabe >= 'A' && buchstabe <= 'Z' && geraten[buchstabe - 'A'];
    }

    static void markiereAlle(String wort, boolean[] geraten) {
        for (int i = 0; i < wort.length(); i++) {
            if (wort.charAt(i) >= 'A' && wort.charAt(i) <= 'Z') {
                geraten[wort.charAt(i) - 'A'] = true;
            }
        }
    }

    static void fuegeEigenesWortHinzu(Scanner scanner) {
        String wort = leseEingabe(scanner, "Eigenes Wort: ");
        wort = ersetzeUmlaute(wort);
        if (wort.length() == 0 || !istNurBuchstaben(wort)) {
            System.out.println("Das Wort darf nur aus Buchstaben bestehen.");
            return;
        }
        fuegeWortEin(new Wort(wort, EIGENE));
        speichereEigeneWoerter();
        System.out.println("Wort gespeichert.");
    }

    static String ersetzeUmlaute(String text) {
        return text.toUpperCase().replace("Ä", "AE").replace("Ö", "OE")
                .replace("Ü", "UE").replace("ß", "SS").trim();
    }

    static boolean istNurBuchstaben(String text) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) < 'A' || text.charAt(i) > 'Z') {
                return false;
            }
        }
        return true;
    }

    static boolean enthaeltUmlaut(String text) {
        return text.indexOf('ä') >= 0 || text.indexOf('ö') >= 0 || text.indexOf('ü') >= 0
                || text.indexOf('Ä') >= 0 || text.indexOf('Ö') >= 0 || text.indexOf('Ü') >= 0
                || text.indexOf('ß') >= 0;
    }

    static boolean hatSchwierigkeit(int thema, int schwierigkeit) {
        for (int i = 0; i < anzahlWoerter; i++) {
            if (woerter[i].thema() == thema
                    && bestimmeSchwierigkeit(woerter[i].text()) == schwierigkeit) {
                return true;
            }
        }
        return false;
    }

    static boolean hatThema(int thema) {
        for (int i = 0; i < anzahlWoerter; i++) {
            if (woerter[i].thema() == thema) {
                return true;
            }
        }
        return false;
    }

    static void fuegeStartWoerterEin() {
        String[] texte = {"ROSE", "MAEHEN", "SCHUBKARRE", "HUND", "KATZE", "SCHILDKROETE",
                "EICHE", "SONNENBLUME", "LOEWENZAHN", "LINK", "GANONDORF", "MASTER Schwert",
                "HOGWARTS", "PATRONUS", "DUMBLEDORE", "PIKACHU", "GLURAK", "SCHIGGY",
                "SPINNENNETZ", "PARKER", "NEWYORK"};
        int[] themen = {GARTEN, GARTEN, GARTEN, TIERE, TIERE, TIERE, PFLANZEN, PFLANZEN,
                PFLANZEN, ZELDA, ZELDA, ZELDA, HARRY_POTTER, HARRY_POTTER, HARRY_POTTER,
                POKEMON, POKEMON, POKEMON, SPIDERMAN, SPIDERMAN, SPIDERMAN};
        for (int i = 0; i < texte.length; i++) {
            fuegeWortEin(new Wort(ersetzeUmlaute(texte[i]), themen[i]));
        }
    }

    static void fuegeWortEin(Wort wort) {
        if (anzahlWoerter == woerter.length) {
            Wort[] groesser = new Wort[woerter.length * 2];
            for (int i = 0; i < woerter.length; i++) {
                groesser[i] = woerter[i];
            }
            woerter = groesser;
        }
        woerter[anzahlWoerter] = wort;
        anzahlWoerter++;
    }

    static void ladeEingeneWoerter() {
        try {
            Scanner datei = new Scanner(new File(DATEI));
            while (datei.hasNextLine()) {
                String wort = ersetzeUmlaute(datei.nextLine());
                if (istNurBuchstaben(wort) && wort.length() > 0) {
                    fuegeWortEin(new Wort(wort, EIGENE));
                }
            }
            datei.close();
        } catch (FileNotFoundException e) {
            // Die Datei entsteht automatisch beim ersten gespeicherten eigenen Wort.
        }
    }

    static void speichereEigeneWoerter() {
        try {
            PrintWriter datei = new PrintWriter(DATEI);
            for (int i = 0; i < anzahlWoerter; i++) {
                if (woerter[i].thema() == EIGENE) {
                    datei.println(woerter[i].text());
                }
            }
            datei.close();
        } catch (FileNotFoundException e) {
            System.out.println("Eigene Woerter konnten nicht gespeichert werden.");
        }
    }

    static int leseZahl(Scanner scanner, String aufforderung) {
        while (true) {
            System.out.print(aufforderung);
            String eingabe = scanner.nextLine().trim();
            try {
                return Integer.parseInt(eingabe);
            } catch (NumberFormatException e) {
                System.out.println("Bitte eine Zahl eingeben.");
            }
        }
    }

    static String leseEingabe(Scanner scanner, String aufforderung) {
        System.out.print(aufforderung);
        return scanner.nextLine().trim().toUpperCase();
    }

    static boolean leseJaNein(Scanner scanner, String aufforderung) {
        while (true) {
            String eingabe = leseEingabe(scanner, aufforderung);
            if (eingabe.equals("J") || eingabe.equals("JA")) {
                return true;
            }
            if (eingabe.equals("N") || eingabe.equals("NEIN")) {
                return false;
            }
            System.out.println("Bitte j oder n eingeben.");
        }
    }
}
