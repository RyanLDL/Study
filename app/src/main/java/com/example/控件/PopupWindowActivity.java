package com.example.控件;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
/* setContentView(View contentView):设置显示的view
*  showAsDropDown(View view):相对某个控件的位置（正下方），无偏移
* showAsDropDown(View view,int xoff,int yoff):有偏移
* setFocusable(boolean focusable):受否获取焦点
* setbackgroundDrawable(Drawable background):背景
* dismiss():关闭弹窗
* setAnimationStyle(int animationStyle):加载动画
* setTonchable(boolean tonchable):触摸使能
* setOutsideTouchable(boolean outsideTouchable):popuwidow外的触摸使能
*
*
*
* */
public class PopupWindowActivity extends AppCompatActivity {
    Button b1,b2,b3;
    String TAG="点击";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window);
    }

    public void click(View view) {
//        PopupWindow popupWindow = new PopupWindow();
        View view1 = getLayoutInflater().inflate(R.layout.popupwidowview, null);
        PopupWindow popupWindow=new PopupWindow(view1, ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        b1=view1.findViewById(R.id.btn1);
        b2=view1.findViewById(R.id.btn2);
        popupWindow.showAsDropDown(view);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.img2));
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 点击第一");
                popupWindow.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: 点击第二");
                popupWindow.dismiss();
            }
        });
    }
}