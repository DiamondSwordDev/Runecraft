package com.Greenlock28.RuneCraft;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EventListener implements Listener
{
	public FileConfiguration config = null;
	public Server serv = null;
	
	public List<String> playersopen = new ArrayList();
	
	private Random rand = new Random();
	private String[] droplisttruth = { "[=]", "[<]", "[>]" };
	private String[] droplistentity = { "[P]", "[B]", "[I]" , "[p]" , "[b]" , "[i]" };
	
	public EventListener(FileConfiguration conf, Server s)
	{
		config = conf;
		serv = s;
	}

	
	
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
	
	
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onPlayerUse(PlayerInteractEvent event)
	{
		Player p = event.getPlayer();
		World w = p.getWorld();
		
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
		{
			if (event.getClickedBlock().getTypeId() == 147 & w.getBlockTypeIdAt(new Location(w, p.getTargetBlock(null, 10).getX(), p.getTargetBlock(null, 10).getY() - 1, p.getTargetBlock(null, 10).getZ())) == 113)
			{
				playersopen.add(event.getPlayer().getName());
				Inventory runetable = event.getPlayer().getServer().createInventory(null, 18, "Rune Table");
				ItemStack button = new ItemStack(Material.EMERALD);
				ItemMeta buttonmeta = button.getItemMeta();
				buttonmeta.setDisplayName("§a(Combine)");
				button.setItemMeta(buttonmeta);
				runetable.setItem(9, button);
				event.getPlayer().openInventory(runetable);
			}
		}
		else if (event.getAction() == Action.RIGHT_CLICK_AIR)
		{
			if (event.getPlayer().getItemInHand().getItemMeta().hasLore() & event.getPlayer().getItemInHand().getItemMeta().getLore().toArray()[0].toString().contains("["))
			{
				RuneInterpreter ri = new RuneInterpreter(event.getPlayer().getItemInHand().getItemMeta().getLore().toArray()[0].toString());
				ri.ExecuteRuneScript();
			}
		}
	}
	
	@EventHandler(priority=EventPriority.NORMAL)
	public void onInventoryClose(InventoryCloseEvent event)
	{
		if (playersopen.contains(event.getPlayer().getName()))
		{
			playersopen.remove(playersopen.indexOf(event.getPlayer().getName()));
			for (ItemStack i : event.getInventory().getContents())
			{
				if (i != null)
				{
					if (i.getTypeId() != 388)
						event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getTargetBlock(null, 10).getLocation(), i);
				}
				//event.getPlayer().getInventory().addItem(i);
			}
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler(priority=EventPriority.NORMAL)
	public void onInventoryClick(InventoryClickEvent event)
	{
		Player p = (Player)event.getWhoClicked();
		
		boolean containsrunes = false;
		for (int i = 0; i < 9; i++)
		{
			if (event.getInventory().getContents()[i] != null)
				containsrunes = true;
		}
		
		
		if (event.getInventory().getTitle().equals("Rune Table") & playersopen.contains(event.getWhoClicked().getName()) & containsrunes & event.getRawSlot() == 9 & event.isShiftClick() != true)
		{
			if (event.getInventory().getContents()[10] == null)
			{
				ItemStack page = new ItemStack(339, 1);
				ItemMeta pagemeta = page.getItemMeta();
				pagemeta.setDisplayName("§fRune Scroll");
				List<String> pagelore = new ArrayList();
				String pagecontents = "";
				for (int i = 0; i < 9; i++)
				{
					if (event.getInventory().getContents()[i] != null)
						pagecontents = pagecontents + event.getInventory().getContents()[i].getItemMeta().getLore().toArray()[0];
				}
				if (!pagecontents.equals(""))
				{
					pagelore.add(pagecontents);
					pagemeta.setLore(pagelore);
				}
				page.setItemMeta(pagemeta);
				event.getInventory().setItem(10, page);
			}
			else
			{
				ItemStack page = event.getInventory().getContents()[10];
				ItemMeta pagemeta = page.getItemMeta();
				List<String> pagelore = new ArrayList();
				String pagecontents = "";
				for (int i = 0; i < 9; i++)
				{
					if (event.getInventory().getContents()[i] != null)
						pagecontents = pagecontents + event.getInventory().getContents()[i].getItemMeta().getLore().toArray()[0];
				}
				if (!pagecontents.equals(""))
				{
					pagelore.add(pagecontents);
					pagemeta.setLore(pagelore);
				}
				page.setItemMeta(pagemeta);
				event.getInventory().setItem(10, page);
			}
			
			event.getInventory().setItem(0, null);
			event.getInventory().setItem(1, null);
			event.getInventory().setItem(2, null);
			event.getInventory().setItem(3, null);
			event.getInventory().setItem(4, null);
			event.getInventory().setItem(5, null);
			event.getInventory().setItem(6, null);
			event.getInventory().setItem(7, null);
			event.getInventory().setItem(8, null);
				
			event.setCursor(null);
			
			ItemStack button = new ItemStack(Material.EMERALD);
			ItemMeta buttonmeta = button.getItemMeta();
			buttonmeta.setDisplayName("§a(Combine)");
			button.setItemMeta(buttonmeta);
			
			event.getInventory().setItem(9, button);
			
			p.updateInventory();
		}
		else if (event.getInventory().getTitle().equals("Rune Table") & playersopen.contains(event.getWhoClicked().getName()) & event.getRawSlot() == 9 & event.isShiftClick() == true)
		{
			event.setResult(Result.DENY);
		}
	}
}















/*@EventHandler(priority=EventPriority.NORMAL)
public void onInventoryClick(InventoryClickEvent event)
{
	Player p = (Player)event.getWhoClicked();
	
	boolean containsrunes = false;
	for (int i = 0; i < 9; i++)
	{
		if (event.getInventory().getContents()[i] != null)
			containsrunes = true;
	}
	
	if (event.getInventory().getTitle().equals("Rune Table") & playersopen.contains(event.getWhoClicked().getName()) & containsrunes)
	{
		if (event.getRawSlot() > -1 & event.getRawSlot() < 9 & event.getAction() == InventoryAction.PLACE_ALL)
		{
			if (event.getInventory().getContents()[9] == null)
			{
				//nothing
			}
			else if (event.getInventory().getContents()[9].getTypeId() == 339)
			{
				ItemStack page = new ItemStack(339, 1);
				ItemMeta pagemeta = page.getItemMeta();
				pagemeta.setDisplayName("§fRune Scroll");
				List<String> pagelore = new ArrayList<String>();
				String pagecontents = "";
				for (int i = 0; i < 9; i++)
				{
					if (event.getInventory().getContents()[i] != null)
						pagecontents = pagecontents + event.getInventory().getContents()[i].getItemMeta().getLore().toArray()[0];
				}
				if (pagecontents != "")
				{
					pagelore.add(pagecontents);
					pagemeta.setLore(pagelore);
				}
				page.setItemMeta(pagemeta);
				event.getInventory().setItem(9, page);
				
				//p.updateInventory();
			}
			else
			{
				ItemStack page = event.getInventory().getItem(9);
				ItemMeta pagemeta = page.getItemMeta();
				List<String> pagelore = new ArrayList<String>();
				String pagecontents = "";
				for (int i = 0; i < 9; i++)
				{
					if (event.getInventory().getContents()[i] != null)
						pagecontents = pagecontents + event.getInventory().getContents()[i].getItemMeta().getLore().toArray()[0];
				}
				if (pagecontents != "")
				{
					pagelore.add(pagecontents);
					pagemeta.setLore(pagelore);
				}
				page.setItemMeta(pagemeta);
				event.getInventory().setItem(9, page);
				
				//p.updateInventory();
			}
		}
		else if (event.getRawSlot() == 9 & event.getAction() == InventoryAction.PICKUP_ALL)
		{
			event.getInventory().setItem(0, null);
			event.getInventory().setItem(1, null);
			event.getInventory().setItem(2, null);
			event.getInventory().setItem(3, null);
			event.getInventory().setItem(4, null);
			event.getInventory().setItem(5, null);
			event.getInventory().setItem(6, null);
			event.getInventory().setItem(7, null);
			event.getInventory().setItem(8, null);
			
			//p.updateInventory();
		}
	}
}*/
