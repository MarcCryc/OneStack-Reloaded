/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.utils;

import org.bukkit.entity.Player;

/**
 *
 * @author Marc
 */
public class Teleport {

    public static void teleportToLobby(Player p) {
        p.teleport(Spawn.getLoc("lobby"));
    }

    

}
