package de.cryc.onestack.countdown;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;


public class Countdown {

	public int seconds = 2;
	  public int sched = 0;
	  public Plugin plug;
	  public String countdownname;
	  
	  public Countdown(int seconds, String name, Plugin instance)
	  {
	    this.seconds = seconds;
	    this.countdownname = name;
	    this.plug = instance;
	  }
	  
	  public void start()
	  {
	    stop();
	    this.sched = Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plug, new Runnable()
	    {
	      public void run()
	      {
	        Bukkit.getServer().getPluginManager().callEvent(new CountDownTickEvent(Countdown.this.countdownname, Countdown.this.seconds));
	        if (Countdown.this.seconds == 0)
	        {
	          Countdown.this.stop();
	          Bukkit.getServer().getPluginManager().callEvent(new CountDownOverEvent(Countdown.this.countdownname));
	        }
	        Countdown.this.seconds -= 1;
	      }
	    }, 0L, 20L);
	  }
	  
	  public void stop()
	  {
	    try
	    {
	      Bukkit.getScheduler().cancelTask(this.sched);
	    }
	    catch (Exception localException) {}
	    this.sched = 0;
	  }
	}

