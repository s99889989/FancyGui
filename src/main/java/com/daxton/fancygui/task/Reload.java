package com.daxton.fancygui.task;

import com.daxton.fancygui.config.FileConfig;

public class Reload {
    //重新讀取的一些任務
    public static void execute(){
        //設定檔
        FileConfig.reload();
        //設置菜單
        MenuSet.execute();
        //設置按鈕
        ButtonSet.execute();
        //定時執行任務
        RunTask.execute();
    }

}
