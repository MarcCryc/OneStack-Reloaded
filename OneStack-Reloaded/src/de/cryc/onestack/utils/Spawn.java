/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.utils;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

/**
 *
 * @author Marc
 */
public class Spawn {

    public static Location getLoc(String spawnname) {
        File ordner = new File("plugins/OneStack/Spawns");
        File file = new File("plugins/OneStack/Spawns/" + spawnname);
        if (!ordner.exists()) {
            Bukkit.broadcastMessage(
                    "§cDer angegebene Spawn konnte nicht gefunden werden!");
        }
        if (!file.exists()) {
            Bukkit.broadcastMessage(
                     "§cDer angegebene Spawn konnte nicht gefunden werden!");
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        double x = cfg.getDouble("X");
        double y = cfg.getDouble("Y");
        double z = cfg.getDouble("Z");
        double yaw = cfg.getDouble("YAW");
        double pitch = cfg.getDouble("PITCH");
        String weltname = cfg.getString("WELTNAME");

        World w = Bukkit.getWorld(weltname);

        Location loc = new Location(w, x, y, z, (float) yaw, (float) pitch);

        return loc;
    }

    public static void setSpawn(String spawnname, Location loc) {
        File ordner = new File("plugins/OneStack/Spawns");
        File file = new File("plugins/OneStack/Spawns/" + spawnname);
        if (!ordner.exists()) {
            ordner.mkdir();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);

        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        String name = loc.getWorld().getName();
        double yaw = loc.getYaw();
        double pitch = loc.getPitch();

        cfg.set("X", Double.valueOf(x));
        cfg.set("Y", Double.valueOf(y));
        cfg.set("Z", Double.valueOf(z));
        cfg.set("YAW", Double.valueOf(yaw));
        cfg.set("PITCH", Double.valueOf(pitch));
        cfg.set("WELTNAME", name);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
