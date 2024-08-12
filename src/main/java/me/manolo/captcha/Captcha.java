package me.manolo.captcha;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.manolo.captcha.listeners.PlayerListeners;



public class Captcha extends JavaPlugin{

    /* 
     *  Implementar otro plus de seguridad, integrando un sistema de palabras 
     *  Despues de que el jugador termine el primer sistema de seguridad,
     *  Se le imprimira una palabra clave en el chat, y el la tendra que 
     *  Replicar(la tendra que escribir identicamente), mientras no termine
     *  De escribir el captcha no podra moverse.
     * 
     */
    @Override
    public void onEnable(){
        Bukkit.getConsoleSender().sendMessage("Plugin iniciando");
        getServer().getPluginManager().registerEvents(new PlayerListeners(this), this);
    }


    @Override
    public void onDisable(){
    }
}
