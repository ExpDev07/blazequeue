package com.github.expdev07.blazequeue.bungeecord.queue.service;

import com.github.expdev07.blazequeue.bungeecord.queue.BlazeQueue;
import com.github.expdev07.blazequeue.bungeecord.queue.priority.provider.PermissionPriority;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.*;

/**
 * Blaze's out-of-the-box implementation of a {@link QueueService}. It stores everything in-memory and should suffice
 * for most usages, but at times, you might want to create your own implementation if, e.g, you'd like the queues to
 * be saved to and retrieved from an external database (MySQL, Redis, etc).
 */
public class BlazeQueueService implements QueueService {

    /**
     * The queues for each server.
     */
    private Map<String, Queue<ProxiedPlayer>> queues = new HashMap<>();

    /**
     * Constructs a new {@link BlazeQueueService}.
     */
    public BlazeQueueService() {

    }

    /**
     * Constructs a new {@link BlazeQueueService} and creates a {@link Queue queue} for every server registered to
     * the provided {@link ProxyServer proxy}.
     */
    public BlazeQueueService(ProxyServer proxy) {
        // Create queues for every server registered to the proxy.
        this.registerQueues(proxy.getServers().keySet());
    }

    /**
     * Gets the provided server's queue or an empty one if the server does not have a queue.
     *
     * @param server The server
     * @return Queue
     */
    @Override
    public Queue<ProxiedPlayer> getQueue(String server) {
        // Find the queue or just return an empty one if lookup fails.
        return queues.getOrDefault(server, new LinkedList<>());
    }

    /**
     * Sets the queue for the provided server.
     *
     * @param server The server
     * @param queue The queue
     */
    public void setQueue(String server, Queue<ProxiedPlayer> queue) {
        queues.put(server, queue);
    }

    /**
     * Registers a {@link Queue queue} for each of the provided servers.
     *
     * @param servers The servers
     */
    protected void registerQueues(Set<String> servers) {
        // Just loop through the servers and individually assign a queue to each.
        for (String server : servers) {
            System.out.println("Registering a queue for \"" + server + "\".");
            this.setQueue(server, new BlazeQueue(new PermissionPriority()));
        }
    }

}
