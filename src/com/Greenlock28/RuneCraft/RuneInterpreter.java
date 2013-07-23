package com.Greenlock28.RuneCraft;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class RuneInterpreter
{
	public String RuneScript = "";
	public Player invokingPlayer = null;
	public Block invokingBlock = null;
	public ItemStack invokingItem = null;
	
	
	public RuneInterpreter()
	{
		
	}
	
	public RuneInterpreter(String r)
	{
		RuneScript = r;
	}
	
	
	public void ExecuteRuneScript()
	{
		String[] runes = GetScriptRunes();
		
		
	}
	
	public String[] GetScriptRunes()
	{
		String script = "";
		for (int i = 0; i < runescript.length(); i++)
		{
			if (runescript.toCharArray()[i] == '�')
				i++;
			else
				script += runescript.toCharArray()[i];
		}
		
		boolean openbracket = false;
		int runecount = 0;
		for (int i = 0; i < script.length(); i++)
		{
			if (script.toCharArray()[i] == ']')
				runecount++;
		}
		
		String[] runes = new String[runecount];
		int runeindex = 0;
		for (int i = 0; i < script.length(); i++)
		{
			if (script.toCharArray()[i] == '[')
			{
				runes[runeindex] += "[";
			}
			else if (script.toCharArray()[i] == ']')
			{
				runes[runeindex] += "]";
				runeindex++;
			}
			else
			{
				runes[runeindex] += script.toCharArray()[i];
			}
		}
		
		return runes;
	}
}
