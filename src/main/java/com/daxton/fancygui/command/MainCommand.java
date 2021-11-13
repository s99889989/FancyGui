package com.daxton.fancygui.command;



import com.daxton.fancygui.FancyGui;
import com.daxton.fancygui.gui.FancyGuiMain;
import com.daxton.fancygui.task.ModMenu;
import com.daxton.fancygui.task.Reload;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import static com.daxton.fancygui.config.FileConfig.languageConfig;

public class MainCommand implements CommandExecutor {

    public static BukkitRunnable bukkitRunnable;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args){

        if(sender instanceof Player){
            Player player = (Player) sender;

            if(args.length == 2) {
                if(args[0].equalsIgnoreCase("gui")){
                    FancyGuiMain.openCustom(player, args[1]);
                    return true;
                }
            }

        }

        if(sender instanceof Player && !sender.isOp()){
            return true;
        }

        //重新讀取設定
        if(args.length == 1) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(args[0].equalsIgnoreCase("test1")){
                    ModMenu.openMenuTest(player);
                }
                if(args[0].equalsIgnoreCase("test2")){
                    bukkitRunnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            ModMenu.hubShow(player);
                        }
                    };
                    bukkitRunnable.runTaskTimer(FancyGui.fancyGui, 0, 20);
                }
                if(args[0].equalsIgnoreCase("test20")){
                    bukkitRunnable.cancel();
                    ModMenu.hubHide(player);
                }
                if(args[0].equalsIgnoreCase("test3")){
                    ModMenu.renderPlayer(player);
                }
                if(args[0].equalsIgnoreCase("test30")){
                    ModMenu.unRenderPlayer(player);
                }
            }

            if(args[0].equalsIgnoreCase("reload")){
                //重新讀取的一些程序
                Reload.execute();

                if(sender instanceof Player){
                    Player player = (Player) sender;
                    player.sendMessage(languageConfig.getString("OpMessage.Reload")+"");
                }
                FancyGui.fancyGui.getLogger().info(languageConfig.getString("LogMessage.Reload"));
            }


        }
        if(args.length == 2) {
            if(sender instanceof Player){
                if(args[0].equalsIgnoreCase("modgui")){
                    Player player = (Player) sender;
                    ModMenu.open(player, args[1]);
                }
            }
        }

        return true;
    }

}
