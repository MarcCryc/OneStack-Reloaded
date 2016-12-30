/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.main;

import de.cryc.onestack.countdown.Countdown;
import de.cryc.onestack.events.CountdownListener;
import de.cryc.onestack.events.GlobalListener;
import de.cryc.onestack.events.LobbyListener;
import de.cryc.onestack.events.ShopListener;
import de.cryc.onestack.utils.GameState;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Marc
 */
public class OneStack extends JavaPlugin {

    public static String prefix = "§8[§bOneStack§8] §7";
    public static String noperm = prefix + "§cDu hast keine Berechtigung für diese Aktion!";

    public static Countdown lobbycountdown;
    public static Countdown ingamecountdown;
    public static Countdown restartcountdown;

    public static GameState state;

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde erfolgreich §ageladen§7!");
        register();
        state = GameState.LOBBY;
        lobbycountdown = new Countdown(15, "Lobby", this);
        ingamecountdown = new Countdown(70, "Ingame", this);
        restartcountdown = new Countdown(15, "Restart", this);

//Dieses Plugin war für play.FlumblMC.de!
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "Das Plugin wurde §4gestoppt§7!");
    }

    public void register() {
        this.getServer().getPluginManager().registerEvents(new GlobalListener(), this);
        this.getServer().getPluginManager().registerEvents(new ShopListener(), this);
        this.getServer().getPluginManager().registerEvents(new LobbyListener(), this);
        this.getServer().getPluginManager().registerEvents(new CountdownListener(), this);
    }

}
