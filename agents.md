# agents.md – Anweisungen für KI-Assistenten

## Projekt

Galgenmännchen-Spiel für die Konsole in Java. Details siehe `readme.md` und `features.md`.

## Harte Regeln

- Strukturierte Programmierung in Java: Methoden, Schleifen, `if`/`switch`
- Erlaubt: nur eindimensionale Arrays (**keine 2D-Arrays**), `String`, `Scanner`, `Random` bzw. `Math.random()`, Records oder einfache Klassen
- **Verboten:** Vererbung, Interfaces, abstrakte Klassen, Collections (`List`, `ArrayList`, `Map`, `Set` usw.), Streams, Lambdas, Generics und andere höhere Java-Features
- Keine externen Bibliotheken, kein Framework, keine GUI. Nur Konsole.

## Code-Stil

- Sprache im Spiel (Ausgaben, Wörter): Deutsch
- Namen von Variablen und Methoden: Deutsch oder Englisch, aber im ganzen Projekt einheitlich
- Kleine Methoden mit einer klaren Aufgabe (z. B. `waehleThema()`, `zeichneLeben(...)`, `pruefeEingabe(...)`)
- Keine Magic Numbers: Leben, Array-Größen und Menünummern als Konstanten (`static final`)
- Kurze Kommentare, die erklären, *warum* etwas so gemacht wird

## Datenstruktur

- Wörter: `record Wort(String text, int thema)` und ein eindimensionales Array `Wort[] woerter` mit Zähler `anzahlWoerter`
- Themen: `String[] THEMEN` (Namen fürs Menü) und Konstanten für die Nummern (7 Themen: Garten, Tiere, Pflanzen, Zelda, Harry Potter, Pokémon, Spider-Man; z. B. `GARTEN = 0` bis `SPIDERMAN = 6`, `EIGENE = 7`). Zum Ziehen eines Wortes das Array durchlaufen und nur Wörter mit passendem Thema und passender Schwierigkeit berücksichtigen.
- Eigene Wörter: werden als `Wort` mit Thema `EIGENE` im selben Array `woerter` gespeichert. Das Array startet mit Platz für alle eingebauten Wörter plus Reserve (z. B. 20) und wird bei Bedarf verdoppelt: neues Array anlegen, Einträge per Schleife kopieren, Variable neu zuweisen. Keine Collections.
- Speicherung: Datei `eigene_woerter.txt`, ein Wort pro Zeile. Beim Start einlesen (`Scanner` auf `File`), beim Hinzufügen oder Beenden schreiben (`PrintWriter`). Dateifehler mit einfachem `try/catch` abfangen und eine Meldung ausgeben.
- Geratene Buchstaben: `boolean[]` oder `char[]` mit festem Platz

## Schwierigkeit

- Die Schwierigkeit gehört zum **Wort**: Einstufung automatisch per Methode `bestimmeSchwierigkeit(String wort)`: bis 5 Buchstaben = leicht, 6 bis 8 = mittel, ab 9 = schwer
- Ein Wort mit j, q, x oder y zählt eine Stufe schwerer (maximal schwer)
- Beim Ziehen eines Wortes nur Wörter nehmen, die zur gewählten Schwierigkeit passen. Gibt es keines, eine Meldung ausgeben und eine andere Stufe anbieten.
- Zwei Lebensmodi, vom Spieler wählbar:
  - Normal: `static final int NORMAL_LEBEN = 8` für alle Stufen
  - Hart: Leben je Stufe in einem Array `HART_LEBEN = {11, 9, 6}` (leicht, mittel, schwer)
- Lebensanzeige: Grafik hat feste Stufen. Stufe = `fehler * STUFEN / maxLeben` (Ganzzahl-Division)

## Schreibweise

- Keine Umlaute und kein ß in Wörtern: ä = ae, ö = oe, ü = ue, ß = ss
- Methode `ersetzeUmlaute(String text)` für eigene Wörter beim Hinzufügen
- Gibt der Spieler ä, ö, ü oder ß beim Raten ein, einen Hinweis zur Schreibweise ausgeben (nicht als Wortversuch werten)
- Wörter intern in Großbuchstaben speichern und vergleichen

## Konsole

- Ausgabe in UTF-8, Umlaute und Symbole (♥ ♡ █ ░) müssen korrekt erscheinen
- ANSI-Farben nur über Konstanten (z. B. `ROT = "\u001B[31m"`, `RESET = "\u001B[0m"`)

## Arbeitsweise

- Immer zuerst kurz den Plan nennen, dann den Code liefern
- Pro Schritt nur ein Feature aus `features.md` umsetzen
- Code muss kompilieren und ohne Zusatzdateien laufen
- Bei Unsicherheit nachfragen, statt ein verbotenes Feature zu benutzen
