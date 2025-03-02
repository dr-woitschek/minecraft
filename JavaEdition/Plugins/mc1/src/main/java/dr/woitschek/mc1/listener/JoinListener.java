package dr.woitschek.mc1.listener;

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
