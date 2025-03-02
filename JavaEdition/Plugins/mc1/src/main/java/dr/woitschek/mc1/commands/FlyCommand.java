package dr.woitschek.mc1.commands;

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
