package com.github.expdev07.blazequeue.bungeecord.queue.priority.provider;

import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * A interface which provides a way of getting a {@link ProxiedPlayer player's} priority.
 */
public interface PriorityProvider {

    /**
     * Gets the priority of the provided {@link ProxiedPlayer}. In theory, a lower number represents a higher
     * priority (negative values are also allowed).
     *
     * @param player Player to get for
     * @return The priority
     */
    int getPriority(ProxiedPlayer player);

}
