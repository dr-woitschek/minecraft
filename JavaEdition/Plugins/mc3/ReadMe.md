**Minecraft Java Plugin**

---

**Aufbauend auf [mc1 - Hello World](https://github.com/dr-woitschek/minecraft/tree/main/JavaEdition/Plugins/mc1/) und [mc2 - JoinListener](https://github.com/dr-woitschek/minecraft/tree/main/JavaEdition/Plugins/mc2/)**

---

1. Hinzufügen einer `Java Class` mit dem Namen `QuitListener`
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/IntelliJ_IDEA_01.jpg)

2. Code in der neu erstellten `Java Class QuitListener` einfügen:
   ```
   import org.bukkit.entity.Player;
   import org.bukkit.event.EventHandler;
   import org.bukkit.event.Listener;
   import org.bukkit.event.player.PlayerQuitEvent;
   
   public class QuitListener implements Listener {
       @EventHandler
       public void onQuit(PlayerQuitEvent event) {
           Player player = event.getPlayer();
           player.sendMessage("Servus pfüat Gott und auf Wiederseh'n " + player.getName());
       }
   }
   
   ```
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/IntelliJ_IDEA_02.jpg)

3. Code in der `Java Main Class mc1` einfügen:
   ```
   import de.woitschek.mc1.listener.QuitListener;
   ```

   ```
   private void listenerRegistration() {
       PluginManager pluginManager = Bukkit.getPluginManager();
       pluginManager.registerEvents(new JoinListener(), this);
	   pluginManager.registerEvents(new QuitListener(), this);
   }
   ```

   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/IntelliJ_IDEA_03.jpg)
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/IntelliJ_IDEA_04.jpg)

4. Erstelle die Plugin-Jar-Datei mit `Umschalt+F10` neu:
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/IntelliJ_IDEA_05.jpg)

5. kopiere die neu erstellte Plugin-Jar-Datei in das mc-server Plugin Verzeichnis:
   - Quelle: `C:\Users\%username%\work\mc1\target\mc1-1.0-SNAPSHOT.jar`
   - Ziel `C:\Users\%username%\work\mc-server\plugins\mc1-1.0-SNAPSHOT.jar`

6. starte den Minecraft Server neu oder benutzte den Befehl `reload confirm` um die Plugins neu zu laden
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc3/Bilder/ausgabe_start_cmd1.jpg)




---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
