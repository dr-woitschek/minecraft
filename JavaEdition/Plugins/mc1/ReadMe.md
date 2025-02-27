**Minecraft Java Plugin**

---

**Vorbereitungen**

1. [IntelliJ IDEA Community Edition](https://www.jetbrains.com/de-de/idea/download/)
   - Standard-Installation
2. [Minecraft paperMC Server](https://papermc.io/downloads/all)
   - öffne `cmd.exe`
   - erstelle einen Server-Ordner `mkdir C:\Users\%username%\work\mc-server`
   - kopiere die Datei `paper-<versionsnummer>.jar` nach `C:\Users\%username%\work\mc-server`
   - erstelle im Ordner `C:\Users\%username%\work\mc-server` die Datei `start.cmd`
   - Inhalt der Datei `start.cmd`:
     ```
     
     @echo off
     set paper=paper-1.21.1-132.jar
     set folder=C:\Users\%username%\work\mc-server
     title Minecraft Server %paper%
     cd \
     cd "%folder%"
     cls
     java -jar %paper% --nogui
     pause
     
     ```
   - Überprüfe Java:
     - öffne `cmd.exe`
	 - führe den Befehl `java --version` aus, Ausgabe:
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/mc1_01.jpg)

   - starte `start.cmd`, Ausgabe:
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/mc1_02.jpg)

   - bearbeite die Datei `eula.txt`
   - ändere den Eintrag `eula=false` in `eula=true`

   - starte erneut `start.cmd`, Ausgabe:
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/mc1_03.jpg)

---


---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
