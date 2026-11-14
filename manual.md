# Bedienungsanleitung – Galgenmaennchen 123

## Spiel starten

1. Öffne das Projekt in IntelliJ IDEA.
2. Starte die Klasse `Haengmann` in `src/main/java/Haengmann.java`.
3. Die Anwendung läuft in der Konsole. Gib deine Auswahl ein und bestätige sie mit der Eingabetaste.

## Eine Runde spielen

1. Wähle im Themenmenü eine Zahl von `1` bis `8`.
   - `1` bis `7` sind die eingebauten Themen.
   - `8` sind eigene Wörter.
   - Mit `9` kannst du ein eigenes Wort hinzufügen.
2. Wähle eine Schwierigkeit:
   - `1` = Leicht
   - `2` = Mittel
   - `3` = Schwer
3. Wähle den Lebensmodus:
   - `1` = Normal mit 8 Leben
   - `2` = Hart mit 11, 9 oder 6 Leben
4. Rate anschließend einzelne Buchstaben oder das ganze Wort.
   - Ein einzelner Buchstabe kostet bei einem falschen Tipp ein Leben.
   - Ein falscher ganzer Wortversuch kostet zwei Leben.
   - Bereits geratene Buchstaben werden nicht noch einmal gewertet.
5. Du gewinnst, wenn alle Buchstaben aufgedeckt sind. Du verlierst, wenn keine Leben mehr übrig sind.
6. Nach der Runde kannst du mit `j` oder `ja` eine neue Runde starten. Mit `n` oder `nein` beendest du das Spiel.

## Eigene Wörter

Wähle im Hauptmenü `9`, gib ein Wort ein und bestätige es. Umlaute werden automatisch umgewandelt:

- `ä` → `AE`
- `ö` → `OE`
- `ü` → `UE`
- `ß` → `SS`

Das Wort wird in `eigene_woerter.txt` gespeichert und steht beim nächsten Programmstart wieder zur Verfügung.

## Hinweise

- Verwende bei Wörtern nur Buchstaben.
- Wenn ein Wort mit Umlaut geraten werden soll, verwende die Schreibweise mit `AE`, `OE`, `UE` oder `SS`.
- Die Lebensanzeige hängt vom gewählten Thema ab und wird nach jedem Fehler aktualisiert.
