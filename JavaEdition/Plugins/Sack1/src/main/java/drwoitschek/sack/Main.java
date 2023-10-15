package drwoitschek.sack;

import drwoitschek.sack.commands.SackCommand;
import drwoitschek.sack.commands.SackRezepteLoader;
import drwoitschek.sack.listeners.JoinListener;
import drwoitschek.sack.listeners.QuitListener;
import drwoitschek.sack.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        new Config();
        new SackRezepteLoader().registerRecipies();

        Bukkit.getLogger().fine("Sack Plugin by Dr. Woitschek wird aktiviert");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§6Sack Plugin by Dr. Woitschek wird aktiviert");
        Bukkit.getConsoleSender().sendMessage(" ");

        listenerRegistration();
        commandRegistration();
        // recipeRegistration();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().fine("Sack Plugin by Dr. Woitschek wird deaktiviert");
        Bukkit.getConsoleSender().sendMessage(" ");
        Bukkit.getConsoleSender().sendMessage("§6Sack Plugin by Dr. Woitschek wird deaktiviert");
        Bukkit.getConsoleSender().sendMessage(" ");
    }

    private void listenerRegistration() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
    }

    private void commandRegistration() {
        getCommand("sack").setExecutor(new SackCommand());
    }

}
