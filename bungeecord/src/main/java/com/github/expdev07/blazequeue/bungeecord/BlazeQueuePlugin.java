package com.github.expdev07.blazequeue.bungeecord;

import com.github.expdev07.blazequeue.bungeecord.queue.BlazeQueue;
import com.github.expdev07.blazequeue.bungeecord.queue.QueueContainer;
import com.github.expdev07.blazequeue.bungeecord.queue.priority.provider.PermissionPriority;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Main plugin class for BlazeQueue's BungeeCord module.
 */
public class BlazeQueuePlugin extends Plugin {

    /**
     * The container which holds the queue.
     */
    private QueueContainer container;

    /**
     * Called when plugin enables.
     */
    @Override
    public void onEnable() {
        // Create a new queue container with a blaze queue using the permission-based priorities.
        this.container = new QueueContainer(new BlazeQueue(new PermissionPriority()));


    }

    /**
     * Called when plugin disables.
     */
    @Override
    public void onDisable() {

    }

    /**
     * Gets the queue container.
     *
     * @return The queue container
     */
    public QueueContainer getContainer() {
        return container;
    }

}
