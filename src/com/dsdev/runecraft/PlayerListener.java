package com.dsdev.runecraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * This listens for player related stuff.
 *
 * @author Greenlock28
 */
public class PlayerListener implements Listener
{
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerUse(PlayerInteractEvent event)
	{
		
	}
}
