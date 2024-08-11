package me.manolo.captcha.manager;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.manolo.captcha.utils.CC;
import me.manolo.captcha.utils.Utils;

public class MenuManager {

    public static void refill(Inventory inv){
        for(int i =0;i<inv.getSize();i++){
            ItemStack fill = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)3);
            ItemMeta fillM=fill.getItemMeta();

            fillM.setDisplayName(CC.translate("&7 "));

            fill.setItemMeta(fillM);
            inv.setItem(i, fill);
        }
    }
    
    public static void menuCaptcha(Player player){
        Inventory inv = Bukkit.createInventory(null, 27,CC.translate("&7Captcha Menu"));
        ItemStack clickMe = new ItemStack(Material.STAINED_GLASS_PANE,1,(short) 5);
        ItemMeta meta = clickMe.getItemMeta();
        meta.setDisplayName(CC.translate("&aClick Me"));
        refill(inv);
        clickMe.setItemMeta(meta);
        inv.setItem(Utils.randomInteger(0, 26), clickMe);


        player.openInventory(inv);
    }
}
