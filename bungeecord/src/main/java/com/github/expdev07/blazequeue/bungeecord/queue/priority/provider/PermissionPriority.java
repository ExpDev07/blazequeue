package com.github.expdev07.blazequeue.bungeecord.queue.priority.provider;

import com.github.expdev07.blazequeue.bungeecord.queue.priority.Priority;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * A {@link PriorityProvider} that bases the priority on permissions.
 *
 * <b>Note:</b> can be expensive due to the nature of how all the {@link ProxiedPlayer player's} permissions
 * needs to be looked through.
 */
public class PermissionPriority implements PriorityProvider {

    /**
     * Prefix of the permission.
     */
    private static final String PERMISSION_PREFIX = "blazequeue.priority";

    @Override
    public int getPriority(ProxiedPlayer player) {
        // Players with "bypass" permission should effectively be able to bypass the queue and therefor should have
        // the highest priority possible.
        if (player.hasPermission(PERMISSION_PREFIX + ".bypass")) {
            return Priority.HIGHEST;
        }
        return 0;
    }

}
