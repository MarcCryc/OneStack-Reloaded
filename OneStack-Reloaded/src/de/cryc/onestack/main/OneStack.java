/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Marc
 */
public class OneStack extends JavaPlugin{

    public static String prefix = "§8[§bOneStack§8] §7";
    public static String noperm = prefix + "§cDu hast keine Berechtigung für diese Aktion!";
    
    
    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(prefix+"Das Plugin wurde erfolgreich §ageladen§7!");
        register();
        
        //Dieses Plugin war für play.FlumblMC.de!
    }

    @Override
    public void onDisable() {
         Bukkit.getConsoleSender().sendMessage(prefix+"Das Plugin wurde §4gestoppt§7!");
    }
    
    
    
    public void register(){
        
    }
    
    
    
    
    

    
}
