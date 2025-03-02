package dr.woitschek.mc1.commands;

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
            sender.sendMessage("§6Eine Information!");
            return true;
        }

        sender.sendMessage("§4Diesen Befehl darfst du nicht ausführen!");
        return true;
    }
}
