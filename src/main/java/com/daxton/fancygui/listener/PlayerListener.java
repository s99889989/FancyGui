package com.daxton.fancygui.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    @EventHandler//當玩家登入
    public void onPlayerJoin(PlayerJoinEvent event){

    }



    @EventHandler//當玩家登出
    public void onPlayerQuit(PlayerQuitEvent event){

    }

    @EventHandler//當使用背包時
    public void onInventoryClick(InventoryClickEvent event){
        //FancyGui.fancyGui.getLogger().info("打開背包");
    }

}
