**Minecraft Java Plugin**

---

**Aufbauend auf [mc1 - Hello World](https://github.com/dr-woitschek/minecraft/tree/main/JavaEdition/Plugins/mc1/)**

---

1. Hinzufügen eines `Package` mit dem Namen `listener`
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_01.jpg)
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_02.jpg)

2. Hinzufügen einer `Java Class` mit dem Namen `JoinListener`
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_03.jpg)
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_04.jpg)
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_05.jpg)

3. Code in der neu erstellten `Java Class JoinListener` einfügen:
   ```
   import org.bukkit.entity.Player;
   import org.bukkit.event.EventHandler;
   import org.bukkit.event.Listener;
   import org.bukkit.event.player.PlayerJoinEvent;
   
   public class JoinListener implements Listener {
       @EventHandler
       public void onJoin(PlayerJoinEvent event) {
           Player player = event.getPlayer();
           player.sendMessage("Winke Winke " + player.getName());
       }
   }
   
   ```
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_06.jpg)

4. Code in der `Java Main Class mc1` einfügen:
   ```
   import org.bukkit.plugin.java.JavaPlugin;
   import org.bukkit.Bukkit;
   import org.bukkit.plugin.PluginManager;
   import de.woitschek.mc1.listener.JoinListener;
   ```

   ```
   listenerRegistration();
   ```

   ```
   private void listenerRegistration() {
       PluginManager pluginManager = Bukkit.getPluginManager();
       pluginManager.registerEvents(new JoinListener(), this);
   }
   ```

   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_07.jpg)
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_08.jpg)

5. Erstelle die Plugin-Jar-Datei mit `Umschalt+F10` neu:
   ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc2/Bilder/IntelliJ_IDEA_09.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
