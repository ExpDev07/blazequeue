package com.github.expdev07.blazequeue.bungeecord.queue;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Queue;

/**
 * A container for the queue.
 */
public class QueueContainer {

    /**
     * The queue.
     */
    private Queue<ProxiedPlayer> queue;

    /**
     * Constructs a new {@link QueueContainer} with the provided {@link Queue<ProxiedPlayer>}.
     *
     * @param queue The queue
     */
    public QueueContainer(Queue<ProxiedPlayer> queue) {
        this.queue = queue;
    }

    /**
     * Gets the queue.
     *
     * @return The queue
     */
    public Queue<ProxiedPlayer> getQueue() {
        return queue;
    }

    /**
     * Sets the queue.
     *
     * @param queue The queue
     */
    public void setQueue(Queue<ProxiedPlayer> queue) {
        this.queue = queue;
    }
}
