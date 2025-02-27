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
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/cmd_java_version.jpg)

   - starte `start.cmd`, Ausgabe:
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/ausgabe_start_cmd1.jpg)

   - bearbeite die Datei `eula.txt`
     - ändere die Zeile `eula=false` in `eula=true`

   - starte erneut `start.cmd`, Ausgabe:
     ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/ausgabe_start_cmd2.jpg)

---

**Let's Go!**

- Starte IntelliJ IDEA Community Edition
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_01.jpg)

- Installiere das Plugin `Minecraft Development`
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_02.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_03.jpg)

- Erstelle ein neues Projekt
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_04.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_05.jpg)

- Hello World Moment
  Mit dem Befehl `org.bukkit.Bukkit.getConsoleSender().sendMessage("")` können Nachrichten in der Minecraft Server Console angezeigt werden.
  Hier ein Beispiel:
  ```
        org.bukkit.Bukkit.getConsoleSender().sendMessage("   ____  ____  ____  ____                           ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("  /\\   \\/\\   \\/\\   \\/\\   \\                  ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage(" /  \\___\\ \\___\\ \\___\\ \\___\\                 ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage(" \\  / __/_/   / /   / /   /                        ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("  \\/_/\\   \\__/\\/___/\\/___/                     ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("    /  \\___\\    /  \\___\\     Plugin Spielplatz  ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("    \\  / __/_mc_\\  /   /      von Dr. Woitschek   ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("     \\/_/\\   \\/\\ \\/___/                        ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("       /  \\__/  \\___\\         Version 1.0        ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("       \\  / _\\  /   /                             ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("        \\/_/\\ \\/___/                             ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("          /  \\___\\                                ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("          \\  /   /                                 ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("           \\/___/                                  ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("                                                    ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("         Hallo Welt !!!                             ");
        org.bukkit.Bukkit.getConsoleSender().sendMessage("                                                    ");

  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc1/Bilder/IntelliJ_IDEA_06.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
- [https://www.minecraft.net/de-de/eula](https://www.minecraft.net/de-de/eula)
