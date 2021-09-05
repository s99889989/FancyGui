package com.daxton.fancygui;



import com.daxton.fancygui.config.FileConfig;
import org.bukkit.Bukkit;

import static com.daxton.fancygui.config.FileConfig.languageConfig;

public class DependPlugins {

    public static boolean depend(){

        FancyGui fancyGui = FancyGui.fancyGui;

        if (Bukkit.getServer().getPluginManager().getPlugin("FancyCore") != null && Bukkit.getPluginManager().isPluginEnabled("FancyCore")){
            //設定檔
            FileConfig.execute();
            fancyGui.getLogger().info(languageConfig.getString("LogMessage.LoadFancyCore"));
        }else {
            fancyGui.getLogger().severe("*** FancyCore is not installed or not enabled. ***");
            fancyGui.getLogger().severe("*** FancyMarket will be disabled. ***");
            return false;
        }

        return true;
    }

}
