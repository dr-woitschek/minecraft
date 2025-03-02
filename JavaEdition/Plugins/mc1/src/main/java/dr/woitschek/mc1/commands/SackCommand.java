package dr.woitschek.mc1.commands;

import dr.woitschek.mc1.backpack.Backpack;
import dr.woitschek.mc1.Mc1;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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