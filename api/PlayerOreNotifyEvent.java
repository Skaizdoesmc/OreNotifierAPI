package net.skaizdoesmc.orenotifier.api;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

/**
 * Created by skaizdoesmc on 1.10.2017.
 */
public class PlayerOreNotifyEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    private boolean cancelled;

    public PlayerOreNotifyEvent() {

    }

    public HandlerList getHandlers() {
        return handlers;
    }


    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean b) {


        cancelled = b;
    }
}
