package com.example.控件;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
/*
* 使用方法：
*   创建dialog.xml
* View dialod = getLayoutInflater.inflate(R.id.xxx)
*   AlertDialog.Builder builder=new AlertDialog.Builder(this);构建Dialog
*   setIcon：图标
*   setTitle:标题
*   setMessage():消息
*   setView():设置自定义View
*   creat():创建
*   show():显示
*   setPositiveButton():确定按钮
*   setNegativeButton():取消按钮
*   setNeutralButton():中间按钮
* */
public class AlertDialogActivity extends AppCompatActivity {
    String TAG="Dialog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void xianshi(View view) {
        View dialogview = getLayoutInflater().inflate(R.layout.dialog, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_1)
                .setTitle("测试")
                .setMessage("今天天气如何")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: 点击了确定");
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: 点击了取消");
                    }
                })
                .setNeutralButton("中间", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Log.d(TAG, "onClick: 点击了中间");
                    }
                })
                .setView(dialogview)
                .create()
                .show();
    }

    public void next(View view) {
        Intent intent=new Intent(AlertDialogActivity.this,PopupWindowActivity.class);
        startActivity(intent);
    }
}