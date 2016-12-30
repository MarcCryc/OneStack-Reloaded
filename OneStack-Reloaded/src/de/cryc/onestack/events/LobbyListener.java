/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.events;

import de.cryc.onestack.main.OneStack;
import de.cryc.onestack.utils.TeamManager;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 *
 * @author Marc
 */
public class LobbyListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            
      
        if (e.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bWähle dein Team")) {
            Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§bWähle dein Team");

            ItemStack item = new ItemStack(Material.LAPIS_BLOCK);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§9Blau");
            ArrayList<String> lore = new ArrayList();
            for (String players : TeamManager.teamblue) {
                lore.add("§7" + players);
            }
            meta.setLore(lore);
            item.setItemMeta(meta);

            inv.setItem(0, item);

            ItemStack item2 = new ItemStack(Material.REDSTONE_BLOCK);
            ItemMeta meta2 = item2.getItemMeta();
            meta2.setDisplayName("§cRot");
            ArrayList<String> lore2 = new ArrayList();
            for (String players : TeamManager.teamred) {
                lore2.add("§7" + players);
            }
            meta2.setLore(lore2);
            item2.setItemMeta(meta2);

            inv.setItem(4, item2);

            p.openInventory(inv);

        }
          } catch (Exception se) {
              se.printStackTrace();
        }
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§9Blau")) {
            if (TeamManager.teamblue.size() == 4) {
                p.sendMessage(OneStack.prefix + "§cDu kannst das Team nicht betreten!");
            } else {
                p.closeInventory();
                p.sendMessage(OneStack.prefix + "Du hast das Team §9Blau §7betreten!");
                TeamManager.teamblue.add(p.getName());
                TeamManager.teamred.remove(p.getName());
                TeamManager.register();

            }

        }
        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cRot")) {
            if (TeamManager.teamred.size() == 4) {
                p.sendMessage(OneStack.prefix + "§cDu kannst das Team nicht betreten!");
            } else {
                p.closeInventory();
                p.sendMessage(OneStack.prefix + "Du hast das Team §cRot §7betreten!");
                TeamManager.teamred.add(p.getName());
                TeamManager.teamblue.remove(p.getName());
                TeamManager.register();
            }

        }
    }

}
