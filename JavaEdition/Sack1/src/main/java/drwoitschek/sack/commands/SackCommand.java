package drwoitschek.sack.commands;

import drwoitschek.sack.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class SackCommand implements CommandExecutor {

    private Inventory inventory;

    public SackCommand() {
        int slots = 9;
        if(Config.contains("command.sack.slots")) {
            slots = (int) Config.get("command.sack.slots");
        } else {
            try {
                Config.set("command.sack.slots", 9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.inventory = Bukkit.createInventory(null, slots, "§5Sack §4| §5Backpack");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player)sender;
            player.openInventory(inventory);
        } else {
            sender.sendMessage("Dieser Befehl kann nur als spieler ausgeführt werden!");
        }
        return false;
    }
}
