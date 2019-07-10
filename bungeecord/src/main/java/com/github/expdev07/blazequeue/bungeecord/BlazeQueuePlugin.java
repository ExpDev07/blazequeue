package com.github.expdev07.blazequeue.bungeecord;

import com.github.expdev07.blazequeue.bungeecord.queue.service.BlazeQueueService;
import com.github.expdev07.blazequeue.bungeecord.queue.service.QueueService;
import net.md_5.bungee.api.plugin.Plugin;

/**
 * Main plugin class for BlazeQueue's BungeeCord module.
 */
public class BlazeQueuePlugin extends Plugin {

    /**
     * The service used for queues.
     */
    private QueueService service;

    /**
     * Called when plugin enables.
     */
    @Override
    public void onEnable() {
        // Use the default implementation that already comes with this plugin.
        this.service = new BlazeQueueService(this.getProxy());
    }

    /**
     * Called when plugin disables.
     */
    @Override
    public void onDisable() {

    }

    /**
     * Gets the queue service.
     *
     * @return The queue service
     */
    public QueueService getService() {
        return service;
    }

    /**
     * Sets the queue service.
     *
     * @param service The new queue service to use
     */
    public void setService(QueueService service) {
        this.service = service;
    }

}
