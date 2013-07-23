package com.dsdev.runecraft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RuneCraft extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(new InventoryListener(), this);
		getServer().getPluginManager().registerEvents(new DropListener(), this);
		
		getLogger().info("RuneCraft has been enabled!");
	}
 
	@Override
	public void onDisable()
	{
		getLogger().info("RuneCraft has been disabled!");
	}
	
    @Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if (cmd.getName().equalsIgnoreCase("giverune") && sender instanceof Player && sender.hasPermission("runecraft.giverune"))
		{
			if (args.length < 1)
				return false;
			Player target = (Player)sender;
			target.getInventory().addItem(new Rune(args[0].toString()).GetRuneItem());
		}
		
		return true;
	}
}
