package com.dsdev.runecraft;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Rune
{
	public String Symbol;
	
	public Rune()
	{
		
	}
	
	public Rune(String symbol)
	{
		Symbol = symbol;
	}

	
	
	public ItemStack GetRuneItem()
	{
		if (Symbol.equals("[=]") | Symbol.equals("[<]") | Symbol.equals("[>]") | Symbol.equals("[?]") | Symbol.equals("[#]") | Symbol.equals("[0]") | Symbol.equals("[1]") | Symbol.equals("[2]") | Symbol.equals("[3]") | Symbol.equals("[4]") | Symbol.equals("[5]") | Symbol.equals("[6]") | Symbol.equals("[7]") | Symbol.equals("[8]") | Symbol.equals("[9]"))
		{
			return GetRuneTypeStructure();
		}
		else if (Symbol.equals("[P]") | Symbol.equals("[B]") | Symbol.equals("[I]") | Symbol.equals("[p]") | Symbol.equals("[b]") | Symbol.equals("[i]") | Symbol.equals("[m]") | Symbol.equals("[E]"))
		{
			return GetRuneTypeEvent();
		}
		else if (Symbol.equals("[Mv]") | Symbol.equals("[Ds]"))
		{
			return GetRuneTypeFunction();
		}
		else if (Symbol.equals("[:]"))
		{
			return GetRuneTypeFunction();
		}
		else if (Symbol.equals("[NUL]"))
		{
			return GetRuneNull();
		}
		else
		{
			return GetRuneNull();
		}
	}
	
	
	private ItemStack GetRuneTypeStructure()
	{
		ItemStack runedrop = GetRuneNull();
		List<String> runelore = new ArrayList();
		
		if (Symbol.equals("[=]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fRune of Equality");
			runelore.add("§2[§a=§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[<]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fLesser Rune");
			runelore.add("§2[§a<§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[>]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fGreater Rune");
			runelore.add("§2[§a>§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[?]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fConditional Rune");
			runelore.add("§2[§a?§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[#]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fRune of Travel");
			runelore.add("§2[§a#§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[1]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fFirst Rune");
			runelore.add("§2[§a1§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[2]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fSecond Rune");
			runelore.add("§2[§a2§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[3]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fThird Rune");
			runelore.add("§2[§a3§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[4]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fFourth Rune");
			runelore.add("§2[§a4§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[5]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fFifth Rune");
			runelore.add("§2[§a5§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[6]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fSixth Rune");
			runelore.add("§2[§a6§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[7]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fSeventh Rune");
			runelore.add("§2[§a7§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[8]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEighth Rune");
			runelore.add("§2[§a8§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[9]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fNinth Rune");
			runelore.add("§2[§a9§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[0]"))
		{
			runedrop = new ItemStack(351, 1, (short)10);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fZero Rune");
			runelore.add("§2[§a0§2]");
			runelore.add("§8Structure Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		
		return runedrop;
	}
	
	private ItemStack GetRuneTypeFunction()
	{
		ItemStack runedrop = GetRuneNull();
		
		if (Symbol.equals("[Mv]"))
		{
			runedrop = new ItemStack(351, 1, (short)14);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fMove Function Rune");
			List<String> runelore = new ArrayList();
			runelore.add("§5[§dMv§5]");
			runelore.add("§8Function Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		if (Symbol.equals("[Ds]"))
		{
			runedrop = new ItemStack(351, 1, (short)14);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fDestroy Function Rune");
			List<String> runelore = new ArrayList();
			runelore.add("§5[§dDs§5]");
			runelore.add("§8Function Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		
		return runedrop;
	}
	
	private ItemStack GetRuneTypeEvent()
	{
		ItemStack runedrop = GetRuneNull();
		List<String> runelore = new ArrayList();
		
		if (Symbol.equals("[P]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fRune of the Player");
			runelore.add("§3[§bP§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[B]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fRune of the Block");
			runelore.add("§3[§bB§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[I]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fRune of the Item");
			runelore.add("§3[§bI§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[p]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fPlayer Rune");
			runelore.add("§3[§bp§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[b]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fBlock Rune");
			runelore.add("§3[§bb§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[i]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fItem Rune");
			runelore.add("§3[§bi§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[m]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fMob Rune");
			runelore.add("§3[§bm§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[E]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEventful Rune");
			runelore.add("§3[§bE§3]");
			runelore.add("§8Event Type Rune (Single Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		
		return runedrop;
	}
	
	private ItemStack GetRuneTypeConstant()
	{
		ItemStack runedrop = GetRuneNull();
		List<String> runelore = new ArrayList();
		
		if (Symbol.equals("[en]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEvent Left-Click Null Rune");
			runelore.add("§8[§7en§8]");
			runelore.add("§8Constant Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[eN]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEvent Right-Click Null Rune");
			runelore.add("§8[§7eN§8]");
			runelore.add("§8Constant Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[ep]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEvent Left-Click Player Rune");
			runelore.add("§8[§7ep§8]");
			runelore.add("§8Constant Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		else if (Symbol.equals("[eP]"))
		{
			runedrop = new ItemStack(351, 1, (short)12);
			ItemMeta runemeta = runedrop.getItemMeta();
			runemeta.setDisplayName("§fEvent Right-Click Player Rune");
			runelore.add("§8[§7eP§8]");
			runelore.add("§8Constant Type Rune (Double Glyph)");
			runemeta.setLore(runelore);
			runedrop.setItemMeta(runemeta);
		}
		
		return runedrop;
	}
	
	
	private ItemStack GetRuneNull()
	{
		ItemStack runedrop = new ItemStack(263, 1, (short)1);
		ItemMeta runemeta = runedrop.getItemMeta();
		runemeta.setDisplayName("§fError Null Rune");
		List<String> runelore = new ArrayList();
		runelore.add("§4[§cNUL§4]");
		runelore.add("§8Of Doom Type Rune (Triple Glyph)");
		runemeta.setLore(runelore);
		runedrop.setItemMeta(runemeta);
		return runedrop;
	}
}
