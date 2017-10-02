package net.skaizdoesmc.orenotifier.api;

import net.skaizdoesmc.orenotifier.Orenotifier;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import static net.skaizdoesmc.orenotifier.api.NotifierType.CHAT;

/**
 * Created by skaizdoesmc on 1.10.2017.
 */
public class PlayerOreNotifyEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private Player player;
    private boolean cancelled;

    public PlayerOreNotifyEvent(Player p) {
        player = p;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public NotifierType getNotifierType() {
        String type = Orenotifier.getInstance().getConfig().getString("notifiertype");

        if(type == "actionbar"){
            return NotifierType.ACTIONBAR;
        }else
        if(type == "chat"){
            return NotifierType.CHAT;
        }else
        if(type == "title"){
            return NotifierType.TITLE;
        }else if(type == "subtitle"){
            return NotifierType.SUBTITLE;
        }else{
            return null;
        }


    }

    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean b) {


        cancelled = b;
    }
}
