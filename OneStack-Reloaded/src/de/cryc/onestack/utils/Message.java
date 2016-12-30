/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.utils;

import de.cryc.onestack.main.OneStack;
import org.bukkit.Bukkit;
import org.bukkit.Instrument;
import org.bukkit.Note;
import org.bukkit.entity.Player;

/**
 *
 * @author Marc
 */
public class Message {
    
    public static void sendMessage(String message){
        Bukkit.broadcastMessage(OneStack.prefix + message);
        for(Player all : Bukkit.getOnlinePlayers()){
            all.playNote(all.getLocation(), Instrument.PIANO, Note.flat(0, Note.Tone.G));
        }
    }
    
}
