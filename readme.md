# Galgenmännchen – Themen-Edition
# Test

**Autor:** Martha Staniszewski
**Kurs:** Strukturierte Programmierung 1B1
**Aufgabe:** Agentic Programming 1
**Datum:** 15.10.2026

## Beschreibung

Ein Galgenmännchen-Spiel (Hangman) für die Konsole, geschrieben in Java mit strukturierter Programmierung.
Der Spieler wählt ein Thema und einen Schwierigkeitsgrad und errät dann ein gesuchtes Wort,
Buchstabe für Buchstabe oder als ganzes Wort. Jedes Thema hat eine eigene Lebensanzeige:

| Thema | Lebensanzeige |
|---|---|
| Zelda | Herzen `♥ ♥ ♥ ♡ ♡` |
| Harry Potter | Ein Patronus, der mit jedem Fehler schwächer wird und am Ende zum Dementor wird |
| Spider-Man | Ein Spinnenfaden, der Stück für Stück reißt |
| Pokémon | HP-Balken `[██████░░░░]` |
| Garten, Tiere, Pflanzen | Eine Blume, die Blatt für Blatt verwelkt |

Zusätzlich können beliebig viele eigene Wörter hinzugefügt werden. Sie werden in einer Textdatei gespeichert und beim nächsten Start wieder geladen.

## Spielablauf

1. Thema wählen (oder eigene Wörter hinzufügen)
2. Schwierigkeit wählen (Leicht, Mittel, Schwer): je schwerer, desto länger und komplizierter das Wort
3. Lebensmodus wählen: Normal (immer 8 Leben) oder Hart (weniger Leben bei schwereren Wörtern)
4. Buchstaben oder ganze Wörter eingeben
5. Gewinnen (Wort erraten) oder verlieren (keine Leben mehr)
6. Auf Wunsch eine neue Runde starten

## Schreibweise

Umlaute und ß werden ersetzt: ä = ae, ö = oe, ü = ue, ß = ss. Das gilt für alle Wörter und für Eingaben des Spielers.

## KI-Unterstützung

Das Projekt wurde mit Claude Sonnet 5.5 (Einstellung: mittel) geplant. Die verwendeten Prompts stehen im `prompt-diary.md`.

## Technische Vorgaben

Das Projekt hält sich an die Vorgabe der Aufgabe:

- Java, strukturierte Programmierung (Methoden, Schleifen, `if`/`switch`)
- Nur eindimensionale Arrays, `String`, Records oder einfache Klassen (z. B. `record Wort(String text, int thema)`)
- **Keine** Abstraktionen, Vererbung, Collections (`ArrayList`, `HashMap` usw.) oder andere höhere Java-Features
- Ausgabe nur in der Konsole (ASCII-Art, Unicode-Symbole, ANSI-Farben)

## Starten

1. Projekt in IntelliJ IDEA öffnen
2. Dateikodierung auf UTF-8 stellen (Settings → Editor → File Encodings)
3. `Main.java` ausführen

## Dateien

- `readme.md` – diese Beschreibung
- `features.md` – Liste der Features
- `agents.md` – Anweisungen für KI-Assistenten
- `prompt-diary.md` – Tagebuch der verwendeten Prompts

## Mögliche Erweiterungen

- Grafische Oberfläche mit echten Bildern und Buttons (Skizze liegt vor), z. B. als Website
- Weitere Themen und Sprachen (Polnisch, Türkisch, Kroatisch)
- Punktestand über mehrere Runden
- Zwei-Spieler-Modus
