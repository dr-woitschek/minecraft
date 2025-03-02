package dr.woitschek.mc1.commands;

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