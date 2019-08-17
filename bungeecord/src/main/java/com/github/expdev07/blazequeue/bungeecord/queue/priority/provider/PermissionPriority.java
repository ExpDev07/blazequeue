package com.github.expdev07.blazequeue.bungeecord.queue.priority.provider;

import com.github.expdev07.blazequeue.bungeecord.queue.priority.Priority;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.OptionalInt;

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

        // Find the player's priority by filtering out all the permissions that start with the prefix, then remove the
        // prefix so that just the priority number is left. Turn the strings into integers, sort them, and find the first.
        OptionalInt priority = player.getPermissions().stream()
                .filter(perm -> perm.startsWith(PERMISSION_PREFIX))
                .map(str -> str.replace(PERMISSION_PREFIX, ""))
                .mapToInt(Integer::parseInt)
                .sorted().findFirst();

        // If we couldn't find any priority, just default.
        return priority.isPresent() ? priority.getAsInt() : Priority.NONE;
    }


}
