package upodev;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;

public class EventListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (Main.isEnabled && Main.isActive) {
            e.setKeepExperience(true);
        }
    }
}