package com.github.expdev07.blazequeue.bungeecord.queue;

import com.github.expdev07.blazequeue.bungeecord.queue.priority.comparator.PriorityComparator;
import com.github.expdev07.blazequeue.bungeecord.queue.priority.provider.PriorityProvider;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.PriorityQueue;

/**
 * Queue implementation for BlazeQueue.
 */
public class BlazeQueue extends PriorityQueue<ProxiedPlayer> {

    /**
     * Constructs a new {@link BlazeQueue} with the initial capacity of 11 and the provided {@link PriorityProvider}.
     *
     * @param priorityProvider Provider for priorities.
     */
    public BlazeQueue(PriorityProvider priorityProvider) {
        super(new PriorityComparator(priorityProvider));
    }

    /**
     * Constructs a new {@link BlazeQueue} with the provided initial capacity and {@link PriorityProvider}.
     *
     * @param initialCapacity Capacity
     * @param priorityProvider Provider for priorities.
     */
    public BlazeQueue(int initialCapacity, PriorityProvider priorityProvider) {
        super(initialCapacity, new PriorityComparator(priorityProvider));
    }

}
