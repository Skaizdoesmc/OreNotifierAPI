package net.skaizdoesmc.orenotifier.api;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 * Created by skaizdoesmc on 2.10.2017.
 */
public class ExampleUsage implements Listener {

    @EventHandler
    public void onNotify(PlayerOreNotifyEvent e){

        Player p = e.getPlayer();
        if(e.getNotifierType() == NotifierType.ACTIONBAR) {
            if (p.isOp()) {
                p.sendMessage("§aThis message will only appear when using ActionBar as notifier type.");
            }
        }


    }


}
