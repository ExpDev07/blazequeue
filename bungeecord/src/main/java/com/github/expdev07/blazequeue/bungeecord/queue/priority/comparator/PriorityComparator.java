package com.github.expdev07.blazequeue.bungeecord.queue.priority.comparator;

import com.github.expdev07.blazequeue.bungeecord.queue.priority.provider.PriorityProvider;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.Comparator;

/**
 * An implementation of {@link Comparator} that compares the priorities of two {@link ProxiedPlayer players} using a
 * {@link PriorityProvider provider}.
 */
public class PriorityComparator implements Comparator<ProxiedPlayer> {

    /**
     * The provider for priorities.
     */
    private PriorityProvider provider;

    /**
     * Constructs a new {@link PriorityComparator} with the provided {@link PriorityProvider}.
     *
     * @param provider Provider for priorities.
     */
    public PriorityComparator(PriorityProvider provider) {
        this.provider = provider;
    }

    /**
     * Runs the comparison between the {@link ProxiedPlayer players'} priorities.
     *
     * @param o1 Player 1
     * @param o2 Player 2
     * @return Result of the comparison
     */
    @Override
    public int compare(ProxiedPlayer o1, ProxiedPlayer o2) {
        // Do a simple comparison of the player's priorities using the priority provider.
        // TODO: 9/07/2019 - Needs testing, could be it has to be reversed for wanted effects.
        return provider.getPriority(o1) - provider.getPriority(o2);
    }

}
