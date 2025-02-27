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
     ```

     java 22.0.2 2024-07-16
     Java(TM) SE Runtime Environment (build 22.0.2+9-70)
     Java HotSpot(TM) 64-Bit Server VM (build 22.0.2+9-70, mixed mode, sharing)

     ```

---


---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
