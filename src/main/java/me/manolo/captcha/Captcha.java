package me.manolo.captcha;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.manolo.captcha.listeners.PlayerListeners;



public class Captcha extends JavaPlugin{


    @Override
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage("Plugin iniciando");
        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
    }


    @Override
    public void onDisable(){
    }
}
