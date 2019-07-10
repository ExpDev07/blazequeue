package com.github.expdev07.blazequeue.bungeecord.queue.service;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Queue;

/**
 * A service interface for queues.
 */
public interface QueueService {

    /**
     * Gets the provided server's queue.
     *
     * @param server The server
     * @return Queue
     */
    Queue<ProxiedPlayer> getQueue(String server);

}
