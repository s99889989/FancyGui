package com.daxton.fancygui.listener;

import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.api.FancyModPlayer;
import com.daxton.fancygui.api.event.PlayerClickButtonEvent;
import com.daxton.fancygui.api.event.PlayerCloseModGui;
import com.daxton.fancygui.api.event.PlayerInputEndEvent;
import com.daxton.fancygui.api.event.PlayerOpenModGui;
import com.daxton.fancygui.manager.GuiManager;
import com.daxton.fancygui.task.ModMenu;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class PlayerListener implements Listener {

    @EventHandler//當玩家點擊按鈕
    public void onButton(PlayerClickButtonEvent event){
        Player player = event.getPlayer();
//        player.sendMessage("按下按鈕: "+event.getButton_id());
//        event.getAction_list().forEach(s -> player.sendMessage(s));

    }

    @EventHandler//當玩家修改輸入值
    public void onInput(PlayerInputEndEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        GuiManager.player_mod_data.get(uuid).text_field_value_map = event.getMessage_map();
    }
    @EventHandler//當玩家開啟ModGUI
    public void openGui(PlayerOpenModGui event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        GuiManager.player_mod_data.get(uuid).bukkitRunnable = new BukkitRunnable() {
            @Override
            public void run() {
                ModMenu.upDataMenu(player, GuiManager.player_mod_data.get(uuid).gui_path);
            }
        };
        GuiManager.player_mod_data.get(uuid).bukkitRunnable.runTaskTimer(FancyGui.fancyGui, 20, 20);
    }
    @EventHandler//當玩家關閉ModGUI
    public void closeGui(PlayerCloseModGui event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        if(GuiManager.player_mod_data.get(uuid).bukkitRunnable != null){
            if(!GuiManager.player_mod_data.get(uuid).bukkitRunnable.isCancelled()){
                GuiManager.player_mod_data.get(uuid).bukkitRunnable.cancel();
            }
        }
    }

    @EventHandler//當玩家登入
    public void onPlayerJoin(PlayerJoinEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();

        FancyModPlayer fancyModPlayer = new FancyModPlayer(player);
        fancyModPlayer.sendFirst();
        GuiManager.player_mod_data.putIfAbsent(uuid, fancyModPlayer);

    }

    @EventHandler//當玩家登出
    public void onPlayerQuit(PlayerQuitEvent event){
        Player player = event.getPlayer();
        UUID uuid = player.getUniqueId();
        GuiManager.player_mod_data.remove(uuid);

    }

    @EventHandler//當使用背包時
    public void onInventoryClick(InventoryClickEvent event){

    }

    @EventHandler
    public void onSneak(PlayerToggleSneakEvent event){
        Player player = event.getPlayer();
        if(event.isSneaking()){
            //ModMenu.openMenuPath(player, "mod_menu/ExampleMenu.yml");
            ModMenu.openMenuTest(player);
        }


    }

}
