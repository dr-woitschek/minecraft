package dr.woitschek.mc1.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Servus pfüat Gott und auf Wiederseh'n " + player.getName());
        org.bukkit.Bukkit.getConsoleSender().sendMessage("§eSpieler: §3" + player.getName() + "§e ist gegangen §3:(");
    }
}
