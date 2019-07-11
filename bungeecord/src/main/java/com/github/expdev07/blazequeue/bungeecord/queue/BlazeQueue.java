package com.github.expdev07.blazequeue.bungeecord.queue;

import com.github.expdev07.blazequeue.bungeecord.queue.priority.comparator.PriorityComparator;
import com.github.expdev07.blazequeue.bungeecord.queue.priority.provider.PriorityProvider;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.PriorityQueue;

/**
 * A queue implementation using {@link PriorityQueue} where the priorities can be defined through a
 * {@link PriorityProvider provider}.
 */
public class BlazeQueue extends PriorityQueue<ProxiedPlayer> {

    /**
     * Constructs a new {@link BlazeQueue} with the initial capacity of 11 and the given {@link PriorityProvider}.
     *
     * @param provider Provider for priorities.
     */
    public BlazeQueue(PriorityProvider provider) {
        super(new PriorityComparator(provider));
    }

    /**
     * Constructs a new {@link BlazeQueue} with the provided initial capacity and {@link PriorityProvider}.
     *
     * @param initialCapacity Capacity
     * @param provider Provider for priorities.
     */
    public BlazeQueue(int initialCapacity, PriorityProvider provider) {
        super(initialCapacity, new PriorityComparator(provider));
    }

}
