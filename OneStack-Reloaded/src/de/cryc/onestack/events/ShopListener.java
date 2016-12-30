/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.events;

import de.cryc.onestack.utils.ItemCreateUtil;
import de.cryc.onestack.utils.TeamManager;
import de.cryc.onestack.utils.villager.Merchant;
import de.cryc.onestack.utils.villager.MerchantOffer;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

/**
 *
 * @author Marc
 */
public class ShopListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();
        try {

            if (e.getRightClicked().getType() == EntityType.VILLAGER) {
                e.setCancelled(true);
                Inventory inv = Bukkit.createInventory(null, 27, "Shop");
                inv.setItem(9, ItemCreateUtil.createItemLore(Material.SANDSTONE, 1, 0, "§eBlöcke", "§7Hier findest du alles was du zum Bauen brauchst"));
                inv.setItem(10, ItemCreateUtil.createItemLore(Material.CHAINMAIL_CHESTPLATE, 1, 0, "§bRüstung", "§7Schütze dich vor Gegner!"));
                inv.setItem(11, ItemCreateUtil.createItemLore(Material.STONE_PICKAXE, 1, 0, "§aSpitzhacken", "§7Hilft dir beim Bl�cke abbauen"));
                inv.setItem(12, ItemCreateUtil.createItemLore(Material.GOLD_SWORD, 1, 0, "§cSchwerter", "§7Greife deine Gegner an"));
                inv.setItem(13, ItemCreateUtil.createItemLore(Material.BOW, 1, 0, "§dBögen", "§7Schiesse deine Feinde in den Tod"));
                inv.setItem(14, ItemCreateUtil.createItemLore(Material.APPLE, 1, 0, "§bNahrung", "§7Bist du Hungrig? Esse doch nen Steak"));
                inv.setItem(15, ItemCreateUtil.createItemLore(Material.CHEST, 1, 0, "§5Kisten", "§7Du kannst Resourcen in die Kisten legen."));
                inv.setItem(16, ItemCreateUtil.createItemLore(Material.POTION, 1, 0, "§6Tränke", "§7Hier gibts leckeres zu Trinken"));
                inv.setItem(17, ItemCreateUtil.createItemLore(Material.TNT, 1, 0, "§dSpezial", "§7Geheime Projekte"));

                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§2"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§3"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§4"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§5"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§6"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§7"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§8"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§1"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§2"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§3"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§4"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§5"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§6"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§7"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§8"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§1§9"));
                inv.addItem(ItemCreateUtil.createItem(Material.STAINED_GLASS_PANE, 1, 7, "§2§1"));
                p.openInventory(inv);
            }
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        try {

            if (e.getClickedInventory().getTitle().equalsIgnoreCase("Shop")) {
                e.setCancelled(true);
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§eBlöcke")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");
                    MerchantOffer offer = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), new ItemStack(Material.SANDSTONE, 2));
                    merchant.addOffer(offer);
                    MerchantOffer end = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 7, 0, "§�cBronze"), new ItemStack(Material.ENDER_STONE));
                    merchant.addOffer(end);
                    MerchantOffer iron = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 3, 0, "§7Iron"), new ItemStack(Material.IRON_BLOCK));
                    merchant.addOffer(iron);
                    MerchantOffer glow = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 15, 0, "§cBronze"), new ItemStack(Material.GLOWSTONE, 4));
                    merchant.addOffer(glow);
                    MerchantOffer glas = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 4, 0, "§cBronze"), new ItemStack(Material.GLASS, 1));
                    merchant.addOffer(glas);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bRüstung")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.LEATHER_HELMET);
                    LeatherArmorMeta meta1 = (LeatherArmorMeta) item1.getItemMeta();
                    if (TeamManager.teamblue.contains(p.getName())) {
                        meta1.setColor(Color.BLUE);
                    }
                    if (TeamManager.teamred.contains(p.getName())) {
                        meta1.setColor(Color.RED);
                    }
                    item1.setItemMeta(meta1);

                    MerchantOffer helmet = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), item1);
                    merchant.addOffer(helmet);

                    ItemStack item2 = new ItemStack(Material.LEATHER_LEGGINGS);
                    LeatherArmorMeta meta2 = (LeatherArmorMeta) item2.getItemMeta();
                    if (TeamManager.teamblue.contains(p.getName())) {
                        meta2.setColor(Color.BLUE);
                    }
                    if (TeamManager.teamred.contains(p.getName())) {
                        meta2.setColor(Color.RED);
                    }
                    item2.setItemMeta(meta2);

                    MerchantOffer leggings = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), item2);
                    merchant.addOffer(leggings);

                    ItemStack item3 = new ItemStack(Material.LEATHER_BOOTS);
                    LeatherArmorMeta meta3 = (LeatherArmorMeta) item3.getItemMeta();
                    if (TeamManager.teamblue.contains(p.getName())) {
                        meta3.setColor(Color.BLUE);
                    }
                    if (TeamManager.teamred.contains(p.getName())) {
                        meta3.setColor(Color.RED);
                    }
                    item3.setItemMeta(meta3);

                    MerchantOffer boots = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), item3);
                    merchant.addOffer(boots);

                    ItemStack item4 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta meta4 = item4.getItemMeta();
                    meta4.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta4.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    meta4.setDisplayName("Kettenbrust LvL 1");
                    item4.setItemMeta(meta4);

                    MerchantOffer rusi1 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 1, 0, "§7Iron"), item4);
                    merchant.addOffer(rusi1);

                    ItemStack item5 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta meta5 = item5.getItemMeta();
                    meta5.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta5.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
                    meta5.setDisplayName("Kettenbrust LvL 2");
                    item5.setItemMeta(meta5);

                    MerchantOffer rusi2 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 3, 0, "§7Iron"), item5);
                    merchant.addOffer(rusi2);

                    ItemStack item6 = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
                    ItemMeta meta6 = item6.getItemMeta();
                    meta6.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta6.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
                    meta6.setDisplayName("Kettenbrust LvL 3");
                    item6.setItemMeta(meta6);

                    MerchantOffer rusi3 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 7, 0, "§7Iron"), item6);
                    merchant.addOffer(rusi3);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cSchwerter")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.STICK);
                    ItemMeta meta1 = item1.getItemMeta();
                    meta1.addEnchant(Enchantment.KNOCKBACK, 1, true);
                    meta1.setDisplayName("Knüppel");
                    item1.setItemMeta(meta1);

                    MerchantOffer knock = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 8, 0, "§cBronze"), item1);
                    merchant.addOffer(knock);

                    ItemStack item2 = new ItemStack(Material.GOLD_SWORD);
                    ItemMeta meta2 = item2.getItemMeta();
                    meta2.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
                    meta2.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta2.setDisplayName("Goldschwert LvL 1");
                    item2.setItemMeta(meta2);

                    MerchantOffer lvl1 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 1, 0, "§7Iron"), item2);
                    merchant.addOffer(lvl1);

                    ItemStack item3 = new ItemStack(Material.GOLD_SWORD);
                    ItemMeta meta3 = item3.getItemMeta();
                    meta3.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    meta3.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta3.setDisplayName("Goldschwert LvL 2");
                    item3.setItemMeta(meta3);

                    MerchantOffer lvl2 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 3, 0, "§7Iron"), item3);
                    merchant.addOffer(lvl2);

                    ItemStack item4 = new ItemStack(Material.IRON_SWORD);
                    ItemMeta meta4 = item4.getItemMeta();
                    meta4.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
                    meta4.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta4.addEnchant(Enchantment.KNOCKBACK, 1, true);
                    item4.setItemMeta(meta4);

                    MerchantOffer lvl3 = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 5, 0, "§6Gold"), item4);
                    merchant.addOffer(lvl3);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aSpitzhacken")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.WOOD_PICKAXE);
                    ItemMeta meta1 = item1.getItemMeta();
                    meta1.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta1.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    item1.setItemMeta(meta1);

                    MerchantOffer wood = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 4, 0, "§cBronze"), item1);
                    merchant.addOffer(wood);

                    ItemStack item2 = new ItemStack(Material.STONE_PICKAXE);
                    ItemMeta meta2 = item2.getItemMeta();
                    meta2.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta2.addEnchant(Enchantment.DIG_SPEED, 1, true);
                    item2.setItemMeta(meta2);

                    MerchantOffer stone = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 2, 0, "§7Iron"), item2);
                    merchant.addOffer(stone);

                    ItemStack item3 = new ItemStack(Material.IRON_PICKAXE);
                    ItemMeta meta3 = item3.getItemMeta();
                    meta3.addEnchant(Enchantment.DURABILITY, 1, true);
                    meta3.addEnchant(Enchantment.DIG_SPEED, 3, true);
                    item3.setItemMeta(meta3);

                    MerchantOffer iron = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 1, 0, "§6Gold"), item3);
                    merchant.addOffer(iron);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dBögen")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.BOW);
                    ItemMeta meta1 = item1.getItemMeta();
                    meta1.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    item1.setItemMeta(meta1);

                    MerchantOffer bow1 = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 3, 0, "§6Gold"), item1);
                    merchant.addOffer(bow1);

                    ItemStack item2 = new ItemStack(Material.BOW);
                    ItemMeta meta2 = item2.getItemMeta();
                    meta2.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    meta2.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    item2.setItemMeta(meta2);

                    MerchantOffer bow2 = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 7, 0, "§6Gold"), item2);
                    merchant.addOffer(bow2);

                    ItemStack item3 = new ItemStack(Material.BOW);
                    ItemMeta meta3 = item3.getItemMeta();
                    meta3.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
                    meta3.addEnchant(Enchantment.ARROW_DAMAGE, 1, true);
                    meta3.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
                    item3.setItemMeta(meta3);

                    MerchantOffer bow3 = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 13, 0, "§6Gold"), item3);
                    merchant.addOffer(bow3);

                    ItemStack item4 = new ItemStack(Material.ARROW);
                    ItemMeta meta4 = item4.getItemMeta();

                    item4.setItemMeta(meta4);

                    MerchantOffer Arrow = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 1, 0, "§6Gold"), item4);
                    merchant.addOffer(Arrow);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bNahrung")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.APPLE);
                    ItemMeta meta1 = item1.getItemMeta();

                    item1.setItemMeta(meta1);

                    MerchantOffer apple = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), item1);
                    merchant.addOffer(apple);

                    ItemStack item2 = new ItemStack(Material.GRILLED_PORK);
                    ItemMeta meta2 = item2.getItemMeta();

                    item2.setItemMeta(meta2);

                    MerchantOffer prok = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 2, 0, "§cBronze"), item2);
                    merchant.addOffer(prok);

                    ItemStack item3 = new ItemStack(Material.CAKE);
                    ItemMeta meta3 = item3.getItemMeta();

                    item3.setItemMeta(meta3);

                    MerchantOffer cake = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 1, 0, "§7Iron"), item3);
                    merchant.addOffer(cake);

                    ItemStack item4 = new ItemStack(Material.GOLDEN_APPLE);
                    ItemMeta meta4 = item4.getItemMeta();

                    item4.setItemMeta(meta4);

                    MerchantOffer gap = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 2, 0, "§6Gold"), item4);
                    merchant.addOffer(gap);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§5Kisten")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.CHEST);
                    ItemMeta meta1 = item1.getItemMeta();

                    item1.setItemMeta(meta1);

                    MerchantOffer chest = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 1, 0, "§7Iron"), item1);
                    merchant.addOffer(chest);

                    ItemStack item2 = new ItemStack(Material.ENDER_CHEST);
                    ItemMeta meta2 = item2.getItemMeta();
                    meta2.setDisplayName("Team Kiste");
                    item2.setItemMeta(meta2);

                    MerchantOffer ender = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 1, 0, "§6Gold"), item2);
                    merchant.addOffer(ender);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Tränke")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.POTION, 1, (short) 16341);
                    ItemMeta meta1 = item1.getItemMeta();
                    meta1.setDisplayName("Heilung LvL 1");

                    item1.setItemMeta(meta1);

                    MerchantOffer heal1 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 3, 0, "§7Iron"), item1);
                    merchant.addOffer(heal1);

                    ItemStack item2 = new ItemStack(Material.POTION, 1, (short) 16373);
                    ItemMeta meta2 = item2.getItemMeta();
                    meta2.setDisplayName("Heilung LvL 2");
                    item2.setItemMeta(meta2);

                    MerchantOffer heal2 = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 5, 0, "§7Iron"), item2);
                    merchant.addOffer(heal2);

                    ItemStack item3 = new ItemStack(Material.POTION, 1, (short) 16274);
                    ItemMeta meta3 = item3.getItemMeta();
                    meta3.setDisplayName("Schnelligkeit");

                    item3.setItemMeta(meta3);

                    MerchantOffer fast = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 7, 0, "§7Iron"), item3);
                    merchant.addOffer(fast);

                    ItemStack item4 = new ItemStack(Material.POTION, 1, (short) 8235);
                    ItemMeta meta4 = item4.getItemMeta();
                    meta4.setDisplayName("Sprungkraft");
                    item4.setItemMeta(meta4);

                    MerchantOffer jump = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 16, 0, "§7Iron"), item4);
                    merchant.addOffer(jump);

                    ItemStack item5 = new ItemStack(Material.POTION, 1, (short) 16281);
                    ItemMeta meta5 = item5.getItemMeta();
                    meta5.setDisplayName("Stärke");
                    item5.setItemMeta(meta5);

                    MerchantOffer stark = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 7, 0, "§6Gold"), item5);
                    merchant.addOffer(stark);

                    ItemStack item6 = new ItemStack(Material.POTION, 1, (short) 16281);
                    ItemMeta meta6 = item6.getItemMeta();
                    meta6.setDisplayName("Stärke");
                    item6.setItemMeta(meta6);

                    MerchantOffer inv = new MerchantOffer(ItemCreateUtil.createItem(Material.GOLD_INGOT, 7, 0, "§6Gold"), item5);
                    merchant.addOffer(inv);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§dSpezial")) {
                    Merchant merchant = new Merchant();
                    merchant.setTitle("Villager");

                    ItemStack item1 = new ItemStack(Material.LADDER);
                    ItemMeta meta1 = item1.getItemMeta();

                    item1.setItemMeta(meta1);

                    MerchantOffer ladder = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 1, 0, "§cBronze"), item1);
                    merchant.addOffer(ladder);

                    ItemStack item2 = new ItemStack(Material.WEB);
                    ItemMeta meta2 = item2.getItemMeta();

                    item2.setItemMeta(meta2);

                    MerchantOffer cob = new MerchantOffer(ItemCreateUtil.createItem(Material.CLAY_BRICK, 16, 0, "§cBronze"), item2);
                    merchant.addOffer(cob);

                    ItemStack item3 = new ItemStack(Material.FISHING_ROD);
                    ItemMeta meta3 = item3.getItemMeta();

                    item3.setItemMeta(meta3);

                    MerchantOffer rod = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 5, 0, "§7Iron"), item3);
                    merchant.addOffer(rod);

                    ItemStack item4 = new ItemStack(Material.FLINT_AND_STEEL);
                    ItemMeta meta4 = item4.getItemMeta();

                    item4.setItemMeta(meta4);

                    MerchantOffer flint = new MerchantOffer(ItemCreateUtil.createItem(Material.IRON_INGOT, 7, 0, "§7Iron"), item4);
                    merchant.addOffer(flint);

                    merchant.setCustomer(p);
                    merchant.openTrading(p);
                }
            }
        } catch (Exception es) {
            es.printStackTrace();

        }
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent e) {
        try {
            if (e.getEntity() instanceof Villager) {
                e.setCancelled(true);
            }
        } catch (Exception es) {
            es.printStackTrace();
        }
    }

}
