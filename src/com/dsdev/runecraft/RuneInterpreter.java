package com.dsdev.runecraft;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * This is the interpreter the runs the rune scripts.
 *
 * @author Greenlock28
 */
public class RuneInterpreter {

    public String RuneScript = "";
    public Player invokingPlayer = null;
    public Block invokingBlock = null;
    public ItemStack invokingItem = null;

    public RuneInterpreter() {
    }

    public RuneInterpreter(String r) {
        RuneScript = r;
    }

    public void ExecuteRuneScript() {
        String[] runes = GetScriptRunes();


    }

    public String[] GetScriptRunes() {
        String script = "";
        for (int i = 0; i < RuneScript.length(); i++) {
            if (RuneScript.toCharArray()[i] == '�') {
                i++;
            } else {
                script += RuneScript.toCharArray()[i];
            }
        }

        int runecount = 0;
        for (int i = 0; i < script.length(); i++) {
            if (script.toCharArray()[i] == ']') {
                runecount++;
            }
        }

        String[] runes = new String[runecount];
        int runeindex = 0;
        for (int i = 0; i < script.length(); i++) {
            if (script.toCharArray()[i] == '[') {
                runes[runeindex] += "[";
            } else if (script.toCharArray()[i] == ']') {
                runes[runeindex] += "]";
                runeindex++;
            } else {
                runes[runeindex] += script.toCharArray()[i];
            }
        }

        return runes;
    }
}
