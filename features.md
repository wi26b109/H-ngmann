# Features

## Umgesetzt / geplant für die Abgabe

1. ✅ **Themenauswahl:** Garten, Tiere, Pflanzen, Zelda, Harry Potter, Pokémon, Spider-Man
2. ✅ **Zufälliges Wort:** Das Spiel wählt ein zufälliges Wort aus dem gewählten Thema
3. ✅ **Raten per Buchstabe oder ganzem Wort:** Eingabe mit 1 Zeichen = Buchstabe, sonst Wortversuch (falsches Wort kostet 2 Leben)
4. ✅ **Themenspezifische Lebensanzeige:**
   1. Zelda: Herzen
   2. Harry Potter: Patronus wird schwächer, am Ende ein Dementor
   3. Spider-Man: Faden reißt Stück für Stück
   4. Pokémon: HP-Balken
   5. Garten / Tiere / Pflanzen: verwelkende Blume
5. ✅ **Drei Schwierigkeitsgrade (Leicht, Mittel, Schwer):** Der Grad bestimmt, welche Wörter vorkommen:
   1. Leicht: kurze Wörter (bis 5 Buchstaben)
   2. Mittel: mittellange Wörter (6 bis 8 Buchstaben)
   3. Schwer: lange Wörter (ab 9 Buchstaben)
   4. Wörter mit seltenen Buchstaben (j, q, x, y) zählen eine Stufe schwerer
   5. Die Einstufung berechnet das Programm automatisch mit `length()`, auch bei eigenen Wörtern
   6. **Lebensmodus (beide Varianten wählbar):**
      - **Normal:** immer 8 Leben, nur die Wörter werden schwerer
      - **Hart:** Die Leben sinken mit der Schwierigkeit (Leicht 11, Mittel 9, Schwer 6) und die Wörter werden schwerer
   7. Die Lebensanzeige passt sich an: Die Grafik hat feste Stufen, die Stufe wird aus dem Anteil der Fehler berechnet (`fehler * STUFEN / maxLeben`)
6. ✅ **Eigene Wörter hinzufügen (unbegrenzt):**
   1. Menüpunkt "Eigenes Wort hinzufügen"
   2. Das Array wächst automatisch: Ist es voll, wird ein doppelt so großes Array angelegt und die Wörter werden per Schleife kopiert (keine Collection nötig)
   3. Die Wörter werden in der Datei `eigene_woerter.txt` gespeichert (ein Wort pro Zeile) und beim Start wieder geladen
   4. Eigene Wörter bilden ein eigenes Thema und können auch mit Schwierigkeit und Lebensanzeige gespielt werden
7. ✅ **Anzeige der bereits geratenen Buchstaben**
8. ✅ **Gewonnen/Verloren-Meldung** und "Nochmal spielen?"
9. ✅ **Farbige Ausgabe** mit ANSI-Codes (z. B. rote Herzen, grüner HP-Balken)
10. ✅ **Eingabeprüfung:** Ungültige Eingaben und schon geratene Buchstaben werden abgefangen, Groß-/Kleinschreibung ist egal
11. ✅ **Schreibweise ohne Sonderzeichen:** Alle Wörter werden mit ae, oe, ue und ss geschrieben (ä = ae, ö = oe, ü = ue, ß = ss). Eigene Wörter werden beim Hinzufügen automatisch umgewandelt. Gibt der Spieler ä, ö, ü oder ß ein, erscheint ein Hinweis auf die Schreibweise.

## Ideen für später

12. Punktestand über mehrere Runden
13. Zwei-Spieler-Modus
14. Weitere Sprachen (Polnisch, Türkisch, Kroatisch)
15. Grafische Oberfläche mit Bildern und Buttons
