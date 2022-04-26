package com.example.菜单;

import java.util.ArrayList;
import java.util.List;

public class Data {



    private static final Data data=new Data();
    private Data(){}
    public static Data getData(){
        return data;
    }
    List<String> firstactivityList=new ArrayList<>();
    List<String>firstnameList=new ArrayList<>();
    List<String> secondactivityList=new ArrayList<>();
    List<String>secondnameList=new ArrayList<>();
    {   firstactivityList.add("com.example.控件.TestViewActivity");
        firstactivityList.add("com.example.控件.ButtonActivity");
        firstactivityList.add("com.example.控件.EditTextActivity");
        firstactivityList.add("com.example.控件.ImageViewActivity");
        firstactivityList.add("com.example.控件.ProgressBarActivity");
        firstactivityList.add("com.example.控件.NotificationActivity");
        firstactivityList.add("com.example.控件.ToolbarActivity");
        firstactivityList.add("com.example.控件.AlertDialogActivity");
        firstactivityList.add("com.example.控件.PopupWindowActivity");
        firstnameList.add("文本框");
        firstnameList.add("按钮");
        firstnameList.add("输入文本框");
        firstnameList.add("图片");
        firstnameList.add("进度条");
        firstnameList.add("通知");
        firstnameList.add("导航");
        firstnameList.add("对话框");
        firstnameList.add("弹窗");
        secondactivityList.add("com.example.布局.LinearLayoutActivity");
        secondnameList.add("LinearLayout");
        secondactivityList.add("com.example.布局.RelativeLayoutActivity");
        secondnameList.add("RelativeLayout");
        secondnameList.add("FrameLayout");
        secondactivityList.add("com.example.布局.FrameLayoutActivity");
        secondactivityList.add("com.example.布局.TableLayoutActivity");
        secondactivityList.add("com.example.布局.GridLayoutActivity");
        secondactivityList.add("com.example.布局.ConstrainLayoutActivity");
        secondnameList.add("TableLayoutActivity");
        secondnameList.add("GridLayoutActivity");
        secondnameList.add("ConstrainLayoutActivity");
        secondnameList.add("ListView");
        secondactivityList.add("com.example.布局.ListView.ListViewActivity");
        secondactivityList.add("com.example.布局.RecyclerView.RecyclerViewActivity");
        secondnameList.add("RecyclerView");
        secondnameList.add("动画");
        secondactivityList.add("com.example.布局.动画.AnimationActivity");
        secondactivityList.add("com.example.布局.ViewPager.ViewPagerActivity");
        secondnameList.add("ViewPagerActivity");


    }

}
