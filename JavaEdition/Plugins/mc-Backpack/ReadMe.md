**Minecraft Java Plugin**

---

**Backpack**

- Wir fügen eine `Java Class` mit dem Namen `backpack.Backpack` hinzu.
- In die neu erstellte Java Class fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.Bukkit;
  import org.bukkit.inventory.Inventory;
  import dr.woitschek.mc1.utils.Base64;
  import java.io.IOException;
  import java.util.UUID;
  
  public class Backpack {
      private final UUID uuid;
      private final Inventory inventory;
  
      public Backpack(UUID uuid) {
          this.uuid = uuid;
          this.inventory = Bukkit.createInventory(null, 27 /* vielfaches von 9 */, "Backpack");
      }
  
      public Backpack(UUID uuid, String base64) throws IOException {
          this.uuid = uuid;
          this.inventory = Bukkit.createInventory(null, 27 /* vielfaches von 9 */, "Backpack");
          this.inventory.setContents(Base64.itemStackArrayFromBase64(base64));
      }
  
      public UUID getUuid() {
          return uuid;
      }
  
      public Inventory getInventory() {
          return inventory;
      }
  
      public String toBase64() {
          return Base64.itemStackArrayToBase64(inventory.getContents());
      }
  }
  ```

- Wir fügen eine `Java Class` mit dem Namen `backpack.BackpackManager` hinzu.
- In die neu erstellte Java Class fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.inventory.ItemStack;
  import dr.woitschek.mc1.Mc1;
  import dr.woitschek.mc1.utils.Base64;
  import dr.woitschek.mc1.utils.Config;
  import java.io.IOException;
  import java.util.*;
  
  public class BackpackManager {
      private final Map<UUID, Backpack> map;
  
      public BackpackManager() {
          map = new HashMap<>();
  
          load();
      }
  
      public Backpack getBackpack(UUID uuid) {
          if(map.containsKey(uuid)) {
              return map.get(uuid);
          }
  
          Backpack backpack = new Backpack(uuid);
          map.put(uuid, backpack);
          return backpack;
      }
  
      public void setBackpack(UUID uuid, Backpack backpack) {
          map.put(uuid, backpack);
      }
  
      private void load() {
          Config config = Mc1.getInstance().getConfiguration();
  
          List<String> uuids = config.getConfig().getStringList("backpacks");
  
          uuids.forEach(s -> {
              UUID uuid = UUID.fromString(s);
              String base64 = config.getConfig().getString("backpack." + s);
  
              try {
                  map.put(uuid, new Backpack(uuid, base64));
              } catch (IOException e) {
                  e.printStackTrace();
              }
          });
      }
  
      public void save() {
          Config config = Mc1.getInstance().getConfiguration();
  
          List<String> uuids = new ArrayList<>();
  
          for (UUID uuid : map.keySet()) {
              uuids.add(uuid.toString());
          }
  
          config.getConfig().set("backpacks", uuids);
          map.forEach((uuid, backpack) -> config.getConfig().set("backpack." + uuid.toString(), backpack.toBase64()));
      }
  }
  ```

- Wir fügen eine `Java Class` mit dem Namen `commands.SackCommand` hinzu.
- In die neu erstellte Java Class fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.inventory.ItemStack;
  import dr.woitschek.mc1.Mc1;
  import dr.woitschek.mc1.utils.Base64;
  import dr.woitschek.mc1.utils.Config;
  import java.io.IOException;
  import java.util.*;
  
  public class SackCommand implements CommandExecutor {
  
      @Override
      public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
  
          if(!(sender instanceof Player)) {
              return true;
          }
  
          Player player = (Player) sender;
  
          Backpack backpack = Mc1.getInstance().getBackpackManager().getBackpack(player.getUniqueId());
  
          player.openInventory(backpack.getInventory());
          return true;
      }
  }
  ```

- Wir fügen eine `Java Class` mit dem Namen `utils.Base64` hinzu.
- In die neu erstellte Java Class fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.inventory.ItemStack;
  import org.bukkit.util.io.BukkitObjectInputStream;
  import org.bukkit.util.io.BukkitObjectOutputStream;
  import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;
  
  import java.io.ByteArrayInputStream;
  import java.io.ByteArrayOutputStream;
  import java.io.IOException;
  
  public class Base64 {
      public static ItemStack[] itemStackArrayFromBase64(String data) throws IOException {
          try {
              ByteArrayInputStream inputStream = new ByteArrayInputStream(Base64Coder.decodeLines(data));
              BukkitObjectInputStream dataInput = new BukkitObjectInputStream(inputStream);
              ItemStack[] items = new ItemStack[dataInput.readInt()];
  
              // Read the serialized inventory
              for (int i = 0; i < items.length; i++) {
                  items[i] = (ItemStack) dataInput.readObject();
              }
  
              dataInput.close();
              return items;
          } catch (ClassNotFoundException e) {
              throw new IOException("Unable to decode class type.", e);
          }
      }
  
      public static String itemStackArrayToBase64(ItemStack[] items) throws IllegalStateException {
          try {
              ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
              BukkitObjectOutputStream dataOutput = new BukkitObjectOutputStream(outputStream);
  
              // Write the size of the inventory
              dataOutput.writeInt(items.length);
  
              // Save every element in the list
              for (ItemStack item : items) {
                  dataOutput.writeObject(item);
              }
  
              // Serialize that array
              dataOutput.close();
              return Base64Coder.encodeLines(outputStream.toByteArray());
          } catch (Exception e) {
              throw new IllegalStateException("Unable to save item stacks.", e);
          }
      }
  }
  ```

- Wir fügen eine `Java Class` mit dem Namen `utils.Config` hinzu.
- In die neu erstellte Java Class fügen wir jetzt nachfolgenden Code hinzu:
  ```
  import org.bukkit.configuration.file.YamlConfiguration;
  
  import java.io.File;
  import java.io.IOException;
  
  public class Config {
  
      private final File file;
      private final YamlConfiguration config;
  
      public Config() {
          File dir = new File("./plugins/mc1/");
          if (!dir.exists()) {
              dir.mkdirs();
          }
  
          this.file = new File(dir, "config.yml");
  
          if (!file.exists()) {
              try {
                  file.createNewFile();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
  
          this.config = YamlConfiguration.loadConfiguration(file);
      }
  
      public File getFile() {
          return file;
      }
  
      public YamlConfiguration getConfig() {
          return config;
      }
  
      public void save() {
          try {
              config.save(file);
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }
  ```

- Unsere Main `Java Class` muss mit nachfolgenden Code ergänzt werden, hier einfach alles:
  ```
  import dr.woitschek.mc1.backpack.BackpackManager;
  import dr.woitschek.mc1.commands.FlyCommand;
  import dr.woitschek.mc1.commands.HealthScaleCommand;
  import dr.woitschek.mc1.commands.Info;
  import dr.woitschek.mc1.commands.SackCommand;
  import dr.woitschek.mc1.listener.JoinListener;
  import dr.woitschek.mc1.listener.QuitListener;
  import dr.woitschek.mc1.utils.Config;
  import org.bukkit.Bukkit;
  import org.bukkit.plugin.java.JavaPlugin;
  import org.bukkit.plugin.PluginManager;
  
  public final class Mc1 extends JavaPlugin {
  
      private static Mc1 instance;
  
      private Config config;
      private BackpackManager backpackManager;
  
      @Override
      public void onLoad() {
          instance = this;
          config = new Config();
      }
  
      @Override
      public void onEnable() {
          // Plugin startup logic
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
          org.bukkit.Bukkit.getConsoleSender().sendMessage("         Hallo Welt                                 ");
          org.bukkit.Bukkit.getConsoleSender().sendMessage("                                                    ");
  
          getLogger().info("");
          getLogger().info("Mein Plugin hat den Status 'Enable'");
          getLogger().info("");
  
          // getLogger().warning("Test-Warnung");
  
          getCommand("info").setExecutor(new Info());
          getCommand("fly").setExecutor(new FlyCommand());
          getCommand("health").setExecutor(new HealthScaleCommand());
          getCommand("sack").setExecutor(new SackCommand());
  
          PluginManager pluginManager = Bukkit.getPluginManager();
          pluginManager.registerEvents(new JoinListener(), this);
          pluginManager.registerEvents(new QuitListener(), this);
  
          backpackManager = new BackpackManager();
      }
  
      @Override
      public void onDisable() {
          // Plugin shutdown logic
          getLogger().info("");
          getLogger().info("Mein Plugin hat den Status 'Disable'");
          getLogger().info("");
  
          backpackManager.save();
  
          config.save();
      }
  
      public static Mc1 getInstance() {
          return instance;
      }
  
      public Config getConfiguration() {
          return config;
      }
  
      public BackpackManager getBackpackManager() {
          return backpackManager;
      }
  }
  ```
  ![Screenshot](https://github.com/dr-woitschek/minecraft/blob/main/JavaEdition/Plugins/mc-Backpack/Bilder/IntelliJ_IDEA_01.jpg)

---

_Weitere Informationen_
- [https://www.jetbrains.com/de-de/](https://www.jetbrains.com/de-de/)
- [https://github.com/DerBanko](https://github.com/DerBanko)
