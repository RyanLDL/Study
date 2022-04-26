package com.example.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            Toast.makeText(this,data.getStringExtra("key"),Toast.LENGTH_LONG).show();
        }

    }

    public void next(View view) {

        Bundle bundle=new Bundle();
        bundle.putString("key","哈哈哈");
        Intent intent=new Intent(this,BActivity.class);
        intent.putExtras(bundle);
//        startActivity(intent);
        startActivityForResult(intent,1);
    }

    public void intent(View view) {
        Uri uri=Uri.parse("https://baidu.com");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}