/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.utils;

import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Marc
 */
public class ItemCreateUtil {

    public static ItemStack createItem(Material mat, int amount, int shortid, String name) {

        short s = (short) shortid;
        ItemStack i = new ItemStack(mat, amount, s);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(name);

        i.setItemMeta(meta);
        return i;
    }

    public static ItemStack createItemLore(Material mat, int amount, int shortid, String name, String lore) {
        ArrayList<String> lores = new ArrayList<>();
        lores.add(lore);
        short s = (short) shortid;
        ItemStack i = new ItemStack(mat, amount, s);
        ItemMeta meta = i.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lores);
        i.setItemMeta(meta);
        return i;
    }
}
