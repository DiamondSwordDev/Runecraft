/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dsdev.runecraft;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 *
 * @author LukeSmalley
 */
public class PlayerListener implements Listener
{
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerUse(PlayerInteractEvent event)
	{
		
	}
}
