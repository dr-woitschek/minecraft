**Minecraft Java Plugin**

---

**Vorbereitungen**

- Download und Standard-Installation von [IntelliJ IDEA Community Edition](https://www.jetbrains.com/de-de/idea/download/)
- Download von [Minecraft paperMC Server](https://papermc.io/downloads/all)
  - Version 1.20.1
- wir erstelle einen Work-Ordner `mkdir C:\Users\%username%\work`

---

**Umgebung einrichten**

- wir starten IntelliJ IDEA Community Edition und installieren das Plugin `Minecraft Development`
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_01.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_02.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_03.jpg)

---

**Erste Schritte**

- Minecraft Server erstellen
  - öffne `cmd.exe`
  - erstelle einen Server-Ordner `mkdir C:\Users\%username%\work\server-1.20.1`
  - kopiere die Datei `paper-<versionsnummer>.jar` nach `C:\Users\%username%\work\server-1.20.1`
  - erstelle im Ordner `C:\Users\%username%\work\server-1.20.1` die Datei `start.cmd`
  - Inhalt der Datei `start.cmd`:
    ```
    
    @echo off
    set paper=paper-1.20.1-196.jar
    set folder=C:\Users\robert\work\server-1.20.1
    title mc-server-%paper%
    cd \
    cd "%folder%"
    cls
    java -jar %paper% --nogui
    pause
    
    ```
  - führe den Befehl `java --version` aus, Ausgabe:
    ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/cmd_java_version.jpg)
  - starte `start.cmd`, Ausgabe:
    ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/ausgabe_start_cmd1.jpg)
  - bearbeite die Datei `eula.txt`
    - ändere die Zeile `eula=false` in `eula=true`
  - starte erneut `start.cmd`, Ausgabe:
    ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/ausgabe_start_cmd2.jpg)
  - mit dem Befehl `stop` wird der Server wieder beendet

- Erstelle ein neues Projekt
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_04.jpg)

- Minecraft Server in das IntelliJ IDEA Community Edition integrieren
  - per Drag&Drop ziehen wir aus dem Windows Explorer den erstellten Minecraft Server Ordner in die IntelliJ IDEA Community Edition hinein.
    ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_05.jpg)
    ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_06.jpg)
  - jetzt verändern wir die Projektstruktur
    - über das `Zahnrad` oder `Strg+Alt+Umschalt+S`
	  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_07.jpg)
    - Im Punkt `Artifatcs` drücken wir das `+`-Zeichen
	  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_08.jpg)
    - Wir ändern den Namen von `unnamed` in unseren Projektnamen, hier `mc1`. Das `Output directory` ändern wir auf das Plugin-Verzeichnis unseres Servers. Zusätzlich ziehen wir das `'mc1' compile output` unter `Available Elements` nach links unter `Output Layout`.
      ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_09.jpg)
    - Anpassen der `Run/Debug Configuration`. Hier fügen wir über das `+`-Zeichen eine `JAR Application` hinzu. Damit der Server benutzbar ist, muss der Wert bei `Path to JAR` angepasst werden, hier wählen wir die entsprechende JAR-Datei. Bei der Option `Program arguments` setzten wir den Parameter `nogui`. Die Option `Working directory` ändern wir auf den Server-Ordner.
    - Beim Punkt `Beforce launch` fügen wir über das `+`-Zeichen ein `Build Artifacts` hinzu. Hier wählen wir unser Projekt aus.
	  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_10.jpg)
	  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_11.jpg)
  - Finaler Test
    - durch `Umschalt+F10` oder das drücken der `Play`-Taste wird das Projekt zu einer Jar-Datei gebaut und der Minecraft Server gestartet.
      ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_12.jpg)
    - In unserem Minecraft Launcher muss ich die entsprechende Version installieren und danach kann ich Minecraft starten. Die derzeitige Version ist `1.20.1`.
      ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/mc01.jpg)
	- Wir fügen einen neuen Server hinzu, Serveradresse `127.0.0.1`.
	  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/mc02.jpg)
      ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/mc03.jpg)
    - Jetzt können wir unserem Server beitreten
      ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/mc04.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
- [https://www.minecraft.net/de-de/eula](https://www.minecraft.net/de-de/eula)
