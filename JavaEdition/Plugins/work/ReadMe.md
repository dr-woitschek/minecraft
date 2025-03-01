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
  - ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_05.jpg)
  - ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/work/Bilder/IntelliJ_IDEA_06.jpg)


---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
- [https://www.minecraft.net/de-de/eula](https://www.minecraft.net/de-de/eula)
