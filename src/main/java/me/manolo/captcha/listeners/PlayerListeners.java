package me.manolo.captcha.listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import me.manolo.captcha.Captcha;
import me.manolo.captcha.manager.MenuManager;
import me.manolo.captcha.utils.CC;

public class PlayerListeners implements Listener{
    
    private Captcha plugin;
    public List<UUID> passed = new ArrayList<>();

    public PlayerListeners(Captcha plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        event.setJoinMessage(null);

        if(!passed.contains(player.getUniqueId())){
           /** taskid = (Runnable) new BukkitRunnable() {

                @Override
                public void run() {
                    MenuManager.menuCaptcha(player);
                }
                
            }.runTaskLater(this.plugin,1L);**/


            plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable() {

                @Override
                public void run() {
                    MenuManager.menuCaptcha(player);
                }
                
           }, 1L);
        }

        /**if(passed.contains(player.getUniqueId())){
            
        }**/
    
    }

    @EventHandler
    public void onQUit(PlayerQuitEvent event){
        if(passed.contains(event.getPlayer().getUniqueId())){
            passed.remove(event.getPlayer().getUniqueId());
        }else{
            return;
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        Player player = (Player) event.getWhoClicked();

        if(event.getCurrentItem().equals(Material.AIR)) return;
        if(event.getCurrentItem() == null) return;

        if(event.getClickedInventory().getTitle().equalsIgnoreCase(CC.translate("&7Captcha Menu"))){
            event.setCancelled(true);
            if(event.getCurrentItem().hasItemMeta()){
                if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(CC.translate("&aClick Me"))){
                    passed.add(player.getUniqueId());
                    player.getOpenInventory().close();
                    plugin.getServer().getScheduler().cancelAllTasks();
                    player.sendMessage(CC.translate("&aHas pasado correctamente el captcha"));
                }else{
                    player.kickPlayer(CC.translate("&aCaptcha Incorrect!"));
                }
            }
        }

    }

    @EventHandler
    public void onCloseInv(InventoryCloseEvent event){
        Player player = (Player)event.getPlayer();
        Inventory inv = event.getInventory();

        if(inv.getTitle().equalsIgnoreCase(CC.translate("&7Captcha Menu"))){
            plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable() {

                @Override
                public void run() {
                    MenuManager.menuCaptcha(player);
                }
                
            }, 1L);
        }
    }

}
