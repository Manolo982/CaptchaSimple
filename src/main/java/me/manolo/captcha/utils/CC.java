package me.manolo.captcha.utils;

import org.bukkit.ChatColor;

public class CC {
    

    public static String translate(String in){
        return ChatColor.translateAlternateColorCodes('&', in);
    }

}
