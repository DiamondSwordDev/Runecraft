/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Greenlock28.RuneCraft;

import java.util.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 *
 * @author LukeSmalley
 */
public class DropListener implements Listener
{
	private Random rand = new Random();
	private String[] droplisttruth = { "[=]", "[<]", "[>]" };
	private String[] droplistentity = { "[P]", "[B]", "[I]" , "[p]" , "[b]" , "[i]" };
	
	
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onBlockBreak(BlockBreakEvent event)
	{
		int type = event.getBlock().getType().getId();
		
		if (type == 17 | type == 18 | type == 31 | type == 37 | type == 38 | type == 81 | type == 106 | type == 111)
		{
			if (rand.nextInt(100) < 5)
			{
				event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new Rune(droplisttruth[rand.nextInt(droplisttruth.length)]).GetRuneItem());
			}
		}
		else if (type == 79 | type == 78)
		{
			if (rand.nextInt(100) < 5)
			{
				event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), new Rune(droplistentity[rand.nextInt(droplistentity.length)]).GetRuneItem());
			}
		}
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onDeath(EntityDeathEvent event)
	{
		if (event.getEntityType() == EntityType.SQUID)
		{
			if (rand.nextInt(100) < 5)
			{
				event.getEntity().getWorld().dropItemNaturally(event.getEntity().getLocation(), new Rune(droplistentity[rand.nextInt(droplistentity.length)]).GetRuneItem());
			}
		}
	}
}
