/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.utils;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

/**
 *
 * @author Marc
 */
public class TeamManager {

    public static ArrayList<String> teamblue = new ArrayList<String>();
    public static ArrayList<String> teamred = new ArrayList<String>();

    public static void register() {

        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

        Team red = board.getTeam("red");
        if (red == null) {
            red = board.registerNewTeam("red");
        }
        red.setPrefix("§cROT §8| §c");

        Team none = board.getTeam("none");
        if (none == null) {
            none = board.registerNewTeam("none");
        }
        none.setPrefix("§9-- §8| §9");

        Team blue = board.getTeam("blue");
        if (blue == null) {
            blue = board.registerNewTeam("blue");
        }
        blue.setPrefix("§9BLAU §8| §9");

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (teamred.contains(all.getName())) {
                red.addPlayer(all);
            } else if (teamblue.contains(all.getName())) {
                blue.addPlayer(all);
            } else {
                none.addPlayer(all);
            }
            all.setScoreboard(board);
        }

    }

    public static void giveTeamItem(Player p) {

        ItemStack item = new ItemStack(Material.BED, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bWähle dein Team");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7Hier kannst du dein Team wählen!");
        meta.setLore(lore);
        item.setItemMeta(meta);
        p.getInventory().setItem(0, item);
    }

    public static void randomTeam() {

        for (Player all : Bukkit.getOnlinePlayers()) {
            if (!teamblue.contains(all.getName()) && !teamred.contains(all.getName())) {
                if (teamred.size() < 4) {
                    teamred.add(all.getName());

                } else if (teamblue.size() < 4) {
                    teamblue.add(all.getName());
                }

            }

        }
        TeamManager.register();
    }
}
