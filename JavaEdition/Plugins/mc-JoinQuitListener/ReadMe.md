**Minecraft Java Plugin**

---

**JoinListener**

- Wir fügen eine `Java Class` mit dem Namen `listener.JoinListener` hinzu.
- In die neu erstellte Java Class Info fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.entity.Player;
  import org.bukkit.event.EventHandler;
  import org.bukkit.event.Listener;
  import org.bukkit.event.player.PlayerJoinEvent;
  
  public class JoinListener implements Listener {
      @EventHandler
      public void onJoin(PlayerJoinEvent event) {
          Player player = event.getPlayer();
          player.sendMessage("§3Winke §bWinke §3" + player.getName() + " §b:)");
          org.bukkit.Bukkit.getConsoleSender().sendMessage("§eSpieler: §3" + player.getName() + "§e ist da §3:)");
      }
  }
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_01.jpg)

- In unserer Main Java Class müssen wir den `JoinListener` registrieren. Hierzu benötigen wir nachfolgenden Zeilen:
  ```
  PluginManager pluginManager = Bukkit.getPluginManager();
  pluginManager.registerEvents(new JoinListener(), this);
  ```

  Der entsprechender `import`-Befehl darf nicht fehlen:
  ```
  import dr.woitschek.mc1.listener.JoinListener;
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_02.jpg)

- Über den `Play`-Button können wir das Testen
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_03.jpg)

---

**QuitListener**

- Wir fügen eine `Java Class` mit dem Namen `listener.QuitListener` hinzu.
- In die neu erstellte Java Class Info fügen wir jetzt nachfolgenden Code hinzu:
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
		  org.bukkit.Bukkit.getConsoleSender().sendMessage("§eSpieler: §3" + player.getName() + "§e ist gegangen §3:(");
      }
  }
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_04.jpg)


- In unserer Main Java Class müssen wir den `JoinListener` registrieren. Hierzu benötigen wir nachfolgenden Zeilen:
  ```
  pluginManager.registerEvents(new QuitListener(), this);
  ```

  Der entsprechender `import`-Befehl darf nicht fehlen:
  ```
  import dr.woitschek.mc1.listener.QuitListener;
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_05.jpg)

- Über den `Play`-Button können wir das Testen
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinQuitListener/Bilder/IntelliJ_IDEA_06.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
