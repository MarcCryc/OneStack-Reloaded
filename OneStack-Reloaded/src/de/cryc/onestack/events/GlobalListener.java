/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.events;

import de.cryc.onestack.main.OneStack;
import de.cryc.onestack.utils.GameState;
import de.cryc.onestack.utils.TeamManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 *
 * @author Marc
 */
public class GlobalListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (OneStack.state == GameState.LOBBY) {
            TeamManager.register();
            TeamManager.giveTeamItem(p);
            e.setJoinMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel betreten! §8[§e" + Bukkit.getOnlinePlayers().size() + "§8/§e8§8]");
            if (Bukkit.getOnlinePlayers().size() == 1) {
                OneStack.lobbycountdown.start();
            }

        } else if (OneStack.state == GameState.INGAME) {
            e.setJoinMessage(null);
        } else if (OneStack.state == GameState.RESTART) {
            e.setJoinMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel betreten!");
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        int onlinezahl = Bukkit.getOnlinePlayers().size() - 1;
        if (OneStack.state == GameState.LOBBY) {
            e.setQuitMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel verlassen! §8[§e" + onlinezahl + "§8/§e8§8]");
        } else if (OneStack.state == GameState.INGAME) {
            e.setQuitMessage(null);
        } else if (OneStack.state == GameState.RESTART) {
            e.setQuitMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel verlassen!");
        }

    }

    @EventHandler
    public void onKick(PlayerKickEvent e) {
        Player p = e.getPlayer();
        int onlinezahl = Bukkit.getOnlinePlayers().size() - 1;
        if (OneStack.state == GameState.LOBBY) {
            e.setLeaveMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel verlassen! §8[§e" + onlinezahl + "§8/§e8§8]");
        } else if (OneStack.state == GameState.INGAME) {
            e.setLeaveMessage(null);
        } else if (OneStack.state == GameState.RESTART) {
            e.setLeaveMessage(OneStack.prefix + "§e" + p.getName() + " §7hat das Spiel verlassen!");
        }

    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e) {
        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {

        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {

        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        if (OneStack.state == GameState.LOBBY) {
            e.setCancelled(true);
        } else if (OneStack.state == GameState.INGAME) {
            e.setCancelled(false);
        } else if (OneStack.state == GameState.RESTART) {
            e.setCancelled(true);
        }

    }
}
