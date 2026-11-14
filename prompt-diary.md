# Prompt-Diary

**Autor:** Martha Staniszewski
**Verwendetes Modell:** Claude Sonnet 5.5 (Einstellung: mittel), über claude.ai

Hier steht, welche Prompts ich verwendet habe, was dabei herauskam und was ich daraus gelernt habe.

---

## Eintrag 1 – Ideenfindung (15.10.2026)

**Prompt:** Aufgabenstellung (Projekt mit Java, ohne höhere Features) eingefügt und gebeten, zuerst gemeinsam eine Idee zu finden, die für Programmieranfänger geeignet ist.

**Ergebnis:** Sechs Ideen (Quiz, Text-Adventure, Galgenmännchen, Tic-Tac-Toe, Charades, Haushaltsbuch) mit Hinweis auf die Vorgaben (keine Collections).

**Gelernt:** Die Aufgabenstellung vollständig mitzuschicken hilft, weil die KI die Einschränkungen von Anfang an berücksichtigt.

## Eintrag 2 – Idee auswählen und erweitern

**Prompt:** Ich habe Galgenmännchen gewählt und beschrieben, was ich möchte: mehrere Themen (Zelda, Harry Potter, Pokémon, Garten ...), eigene Wörter, themenspezifische Grafiken, Schwierigkeitsgrade.

**Ergebnis:** Ein Konzept mit 2D-Array für Wörter, Lebensanzeige je Thema und drei Schwierigkeitsgraden. Auch Hinweise auf Stolperfallen (UTF-8, Sonderzeichen).

**Gelernt:** Die KI versteht Ideen besser, wenn ich konkrete Beispiele nenne (z. B. "Patronus wird zum Dementor").

## Eintrag 3 – Website oder Konsole?

**Prompt:** Ich wollte eine Website mit Buttons und habe eine handgezeichnete Skizze hochgeladen.

**Ergebnis:** Die KI wies darauf hin, dass eine Website nicht zu den Vorgaben passt (HTML/JavaScript oder Framework). Ich bleibe bei einer Konsolenanwendung. Die Skizze nutze ich als Vorlage für das Textmenü und schreibe sie als Erweiterung ins `readme.md`.

**Gelernt:** Die KI soll auch Vorgaben prüfen und nicht nur meine Wünsche umsetzen. Das hat mir ein Risiko bei der Abgabe erspart.

## Eintrag 4 – Bilder in der Konsole

**Prompt:** Ich habe gefragt, ob ich in der Konsole Bilder einfügen kann.

**Ergebnis:** Echte Bilder gehen nicht. Stattdessen verwende ich ASCII-Art, Unicode-Symbole und ANSI-Farben.

**Gelernt:** Es lohnt sich, nach den Grenzen der Technik zu fragen, bevor man mit der Umsetzung beginnt.

## Eintrag 5 – Dokumente erstellen

**Prompt:** "Ja, mach das mal" – Erstellung von `readme.md`, `features.md`, `agents.md` und diesem Prompt-Diary.

**Ergebnis:** Die vier Dateien in diesem Ordner.

**Gelernt:** Platzhalter (z. B. Autorenname) muss ich selbst kontrollieren und ausfüllen.

---

## Eintrag 6 – Eigene Wörter ohne Limit

**Prompt:** Ich möchte mehr als 50 eigene Wörter speichern oder beliebig viele hinzufügen können.

**Ergebnis:** Statt eines festen Arrays wächst das Array automatisch (neues, größeres Array, Werte kopieren). Zusätzlich werden die Wörter in `eigene_woerter.txt` gespeichert. `features.md`, `readme.md` und `agents.md` wurden angepasst.

**Gelernt:** Ein Limit lässt sich auch ohne Collections lösen. Wenn sich eine Anforderung ändert, müssen alle Dokumente mit angepasst werden.

---

## Eintrag 7 – Schwierigkeit über die Wörter

**Prompt:** Ich wollte die Schwierigkeit anders lösen: Je länger oder komplizierter ein Wort ist, desto schwerer wird es eingestuft. Die Anzahl der Leben soll gleich bleiben. Das wirkt einheitlicher und weniger kompliziert als unterschiedliche Leben.

**Ergebnis:** Die KI hat die Einstufung der Wörter nach Länge und besonderen Buchstaben eingebaut. Die Leben sind konstant (8). `features.md`, `readme.md` und `agents.md` wurden angepasst.

**Gelernt:** Die KI hatte meine Idee zuerst anders verstanden (weniger Leben bei schweren Wörtern). Wenn etwas nicht zu meiner Vorstellung passt, muss ich es klar sagen. Außerdem habe ich das verwendete Modell im Diary ergänzt.

---

## Eintrag 8 – Beide Schwierigkeits-Varianten und Schreibweise

**Prompt:** Ich möchte beide Varianten (schwerere Wörter und weniger Leben) und Umlaute als ae, oe, ue sowie ß als ss.

**Ergebnis:** Der Spieler wählt jetzt zusätzlich einen Lebensmodus: Normal (immer 8 Leben) oder Hart (11, 9 oder 6 Leben je nach Stufe). Alle Wörter werden ohne Umlaute geschrieben, eigene Wörter werden automatisch umgewandelt. Dateien wurden angepasst.

**Gelernt:** Wenn ich mich nicht entscheiden kann, kann ich die KI bitten, beide Varianten einzubauen. Mit der Schreibweise ae/oe/ue/ss entfallen Probleme mit Sonderzeichen in der Konsole.

---

## Eintrag 9 – Zweidimensionale Arrays prüfen

**Prompt:** Ich habe gefragt, ob ein 2D-Array nicht schon ein höheres Java-Feature ist, weil die Aufgabe das verbietet. (In Eintrag 2 hatte die KI ein 2D-Array für die Wörter vorgeschlagen.)

**Ergebnis:** Ein 2D-Array ist keine Collection und keine Abstraktion, es ist aber ein Grenzfall. Ich verzichte darauf. Stattdessen verwende ich einen Record `Wort(String text, int thema)` und ein eindimensionales Array. Records sind in der Aufgabe ausdrücklich erlaubt. `agents.md` und `readme.md` wurden angepasst.

**Gelernt:** Ich muss Vorschläge der KI selbst gegen die Aufgabenstellung prüfen. Die KI hatte das 2D-Array zuerst als erlaubt bezeichnet.

---

## Eintrag 10 – Dateien auf den neuesten Stand bringen

**Prompt:** Ich habe meine vier Dateien hochgeladen und gebeten, sie mit allem zu vergleichen, was wir besprochen haben, und nur zu ergänzen, was fehlt oder sich geändert hat.

**Ergebnis:** Die Änderung zum Record und zum eindimensionalen Array wurde in `agents.md` und `readme.md` übernommen, und dieser Eintrag und Eintrag 9 wurden im Prompt-Diary ergänzt.

**Gelernt:** Wenn ich Dateien selbst bearbeite, muss ich der KI die aktuelle Version geben, damit nichts überschrieben wird.

---

## Eintrag 11 – Spider-Man als eigenes Thema

**Prompt:** Beim Vergleich der Dateien fiel auf, dass Spider-Man nur als Lebensanzeige vorkam, aber nicht als Thema. Ich habe entschieden, dass Spider-Man ein eigenes Thema sein soll.

**Ergebnis:** Es gibt jetzt sieben Themen (Garten, Tiere, Pflanzen, Zelda, Harry Potter, Pokémon, Spider-Man) plus die eigenen Wörter. `features.md` und `agents.md` wurden angepasst.

**Gelernt:** Beim Vergleichen der Dateien zeigen sich Lücken, die beim Schreiben nicht auffallen.

---

## Noch offen (nach dem Programmieren ergänzen)

- Eintrag 12: Prompt für das Grundgerüst (Menü, Themenwahl)
- Eintrag 13: Prompt für die Lebensanzeigen
- Eintrag 14: Fehler/Probleme und wie sie gelöst wurden
