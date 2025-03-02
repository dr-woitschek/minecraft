package dr.woitschek.mc1;

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
