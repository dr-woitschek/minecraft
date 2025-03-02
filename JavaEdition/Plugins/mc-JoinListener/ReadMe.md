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
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinListener/Bilder/IntelliJ_IDEA_01.jpg)

- In unserer Main Java Class müssen wir den `JoinListener` registrieren.<br/>Hierzu benötigen wir nachfolgenden Zeilen:
  ```
  PluginManager pluginManager = Bukkit.getPluginManager();
  pluginManager.registerEvents(new JoinListener(), this);
  ```

  Der entsprechender `import`-Befehl darf nicht fehlen:
  ```
  import dr.woitschek.mc1.listener.JoinListener;
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinListener/Bilder/IntelliJ_IDEA_02.jpg)

- Über den `Play`-Button können wir das Testen
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-JoinListener/Bilder/IntelliJ_IDEA_03.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
