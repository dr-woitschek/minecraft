**Minecraft Java Plugin**

---

**Commands**
- [commands.Info](#commands.Info)
- [commands.FlyCommand](#commands.FlyCommand)
- [commands.HealthScaleCommand](#commands.HealthScaleCommand)

---

<a name="commands.Info"></a>
- Wir fügen eine `Java Class` mit dem Namen `commands.Info` hinzu.
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_01.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_02.jpg)

- In die neu erstellte Java Class Info fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.command.Command;
  import org.bukkit.command.CommandExecutor;
  import org.bukkit.command.CommandSender;
  import org.bukkit.command.ConsoleCommandSender;
  import org.jetbrains.annotations.NotNull;
  
  public class Info implements CommandExecutor {
      @Override
      public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd,
                               @NotNull String label, @NotNull String[] args) {
          if(sender instanceof ConsoleCommandSender) {
              sender.sendMessage("§3Du bist die Console!");
              return true;
          }
  
          if(sender.hasPermission("info")) {
              sender.sendMessage("§6Eine Information");
              return true;
          }
  
          sender.sendMessage("§4Diesen Befehl darfst du nicht ausführen!");
          return true;
      }
  }
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_03.jpg)

- In unserer Main Java Class müssen wir den Befehl registrieren. Hierzu benötigen wir nachfolgenden Befehl:
  ```
  getCommand("info").setExecutor(new Info());
  ```

  Der entsprechender `import`-Befehl darf nicht fehlen:
  ```
  import dr.woitschek.mc1.commands.Info;
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_04.jpg)

  Zusätzlich müssen wir noch die Datei `plugin.yml` anpassen:
  ```
  commands:
    info:
      description: Eine Information
      aliases:
        - information
        - i
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_05.jpg)

- Über den `Play`-Button können wir das Testen
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_06.jpg)

- Als Spieler sieht das so aus:
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_07.jpg)
  Per Console kann ich dem Spieler `op`-Berechtigung geben:
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_08.jpg)

---

<a name="commands.FlyCommand"></a>
- `FlyCommand`-Beispiel, `Java Class` mit dem Namen `FlyCommand`:
  ```
  import org.bukkit.command.Command;
  import org.bukkit.command.CommandExecutor;
  import org.bukkit.command.CommandSender;
  import org.bukkit.entity.Player;
  import org.jetbrains.annotations.NotNull;
  
  public class FlyCommand implements CommandExecutor {
      @Override
      public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd,
                               @NotNull String label, @NotNull String[] args) {
          if(!(sender instanceof Player)) {
              sender.sendMessage("§4Nur Spieler können diesen Befehl benutzen!");
              return true;
          }
  
          final Player player = (Player) sender;
  
          player.setAllowFlight(true);
          player.setFlying(true);
          player.sendMessage("§aDu kannst jetzt fliegen!");
  
          return true;
      }
  }
  ```

  Main Java Class:
  ```
  getCommand("fly").setExecutor(new FlyCommand());
  ```

  `plugin.yml`-Datei anpassen:
  ```
  ...
  fly:
    description: Damit kann ein Spieler fliegen
    aliases:
      - f
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_09.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_10.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_11.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_12.jpg)

---

<a name="commands.HealthScaleCommand"></a>
- `Gesundheit`-Beispiel, `Java Class` mit dem Namen `HealthScaleCommand`:
  ```
  import org.apache.commons.lang3.StringUtils;
  import org.bukkit.command.Command;
  import org.bukkit.command.CommandExecutor;
  import org.bukkit.command.CommandSender;
  import org.bukkit.entity.Player;
  import org.bukkit.util.StringUtil;
  import org.jetbrains.annotations.NotNull;
  
  public class HealthScaleCommand implements CommandExecutor {
      @Override
      public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd,
                               @NotNull String label, @NotNull String[] args) {
          if(!(sender instanceof Player)) {
              sender.sendMessage("§4Nur Spieler können diesen Befehl benutzen!");
              return true;
          }
  
          final Player player = (Player) sender;
  
          if(args.length < 1) {
              player.sendMessage("§4Du machst was falsch, benutzte /"+ label +" <Anzahl-Herzen>");
              return true;
          }
  
          String herzArgument = args[0];
  
          if (!(StringUtils.isNumeric(herzArgument))) {
              player.sendMessage("§cDu darfst nur Zahlen zwischen 1 und 40 benutzten!");
              return true;
          }
  
          int herzen = Integer.parseInt(herzArgument);
  
          if(herzen <= 0 || herzen > 40) {
              player.sendMessage("§cDu kannst nur zwischen 1 und 40 Herzen haben ;)");
              return true;
          }
  
          player.setHealthScale(herzen);
          player.sendMessage("§aDeine Gesundheit wird auf "+ herzen +" Herzen gesetzt!");
  
          return true;
      }
  }
  ```

  Main Java Class:
  ```
  getCommand("health").setExecutor(new HealthScaleCommand());
  ```

  `plugin.yml`-Datei anpassen:
  ```
  ...
  health:
    description: Deine Gesundheit ist uns wichtig!
    aliases:
      - healthcare
      - gesundheit
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_13.jpg)
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/Level2-Commands/Bilder/IntelliJ_IDEA_14.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://papermc.io/](https://papermc.io/)
