/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.cryc.onestack.events;

import de.cryc.onestack.countdown.CountDownOverEvent;
import de.cryc.onestack.countdown.CountDownTickEvent;
import de.cryc.onestack.main.OneStack;
import de.cryc.onestack.utils.GameState;
import de.cryc.onestack.utils.Message;
import de.cryc.onestack.utils.TeamManager;
import java.util.concurrent.TimeUnit;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

/**
 *
 * @author Marc
 */
public class CountdownListener implements Listener {

    @EventHandler
    public void onLobbyTick(CountDownTickEvent e) {
        if (e.getCountDownName().equalsIgnoreCase("Lobby")) {
            if (e.getSeconds() == 60) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 30) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 15) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 10) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 5) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 4) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 3) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 2) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 1) {
                Message.sendMessage("Das Spiel beginnt in §e" + e.getSeconds() + "§7 Sekunde");
            }
        }
    }

    @EventHandler
    public void onRestartTick(CountDownTickEvent e) {
        if (e.getCountDownName().equalsIgnoreCase("Restart")) {

            if (e.getSeconds() == 15) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 10) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 5) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 4) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 3) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 2) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunden");
            }
            if (e.getSeconds() == 1) {
                Message.sendMessage("Das Spiel stoppt in §4" + e.getSeconds() + "§7 Sekunde");
            }
        }
    }

    @EventHandler
    public void onIngameTick(CountDownTickEvent e) {
        if (e.getCountDownName().equalsIgnoreCase("Ingame")) {

            long minutes = TimeUnit.SECONDS.toMinutes(e.getSeconds());

            for (Player all : Bukkit.getOnlinePlayers()) {
                if (!(minutes == 0L)) {
                    sendActionBar(all, "§8[§e" + minutes + " Minute/n§8]");
                } else {
                    sendActionBar(all, "§8[§e" + e.getSeconds() + " Sekunde/n§8]");
                }
            }
        }
    }

    public static void sendActionBar(Player player, String message) {
        PlayerConnection connect = ((CraftPlayer) player).getHandle().playerConnection;

        IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + message + "\"}");
        PacketPlayOutChat packet = new PacketPlayOutChat(chat, (byte) 2);

        connect.sendPacket(packet);
    }

    @EventHandler
    public void onEndLobby(CountDownOverEvent e) {
        if (e.getCountdownName().equalsIgnoreCase("Lobby")) {
            OneStack.ingamecountdown.start();
            OneStack.state = GameState.INGAME;
            
            
            Message.sendMessage("§eDas Spiel startet nun!");

            for(Player all : Bukkit.getOnlinePlayers()){
                all.getInventory().clear();
            }
            TeamManager.randomTeam();
            
        }

    }

    @EventHandler
    public void onEndIngame(CountDownOverEvent e) {
        if (e.getCountdownName().equalsIgnoreCase("Ingame")) {
            OneStack.restartcountdown.start();
            OneStack.state = GameState.RESTART;
            Message.sendMessage("§cEs konnte sich niemand als Sieger beweisen!");
        }

    }

    @EventHandler
    public void onEndRestart(CountDownOverEvent e) {
        if (e.getCountdownName().equalsIgnoreCase("Restart")) {
            OneStack.restartcountdown.start();
            Message.sendMessage("§4RESTART!");
        }

    }
}
