package com.daxton.fancygui.task;



public class Start {
    //只在開服時執行的任務
    public static void execute(){
        //設置菜單
        MenuSet.execute();
        //設置按鈕
        ButtonSet.execute();
        //定時執行任務
        RunTask.execute();
    }

}
