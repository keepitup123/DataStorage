package com.example.datastorage;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnShared, mbtnFile1, mbtnFile2,mbtnLitePal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnShared = findViewById(R.id.btn_sharedprference);
        mbtnFile1 = findViewById(R.id.btn_file1);
        mbtnFile2 = findViewById(R.id.btn_file2);
        mbtnLitePal = findViewById(R.id.btn_litepal);

        mbtnShared.setOnClickListener(this);
        mbtnFile1.setOnClickListener(this);
        mbtnFile2.setOnClickListener(this);
        mbtnLitePal.setOnClickListener(this);
        //获取外部存储的动态权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        //获取SD卡存储的动态权限  （一般现在不用的SD卡了）
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 2);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;
        switch (v.getId()) {
            case R.id.btn_sharedprference:
                intent = new Intent(MainActivity.this, SharedPeferenceActivity.class);
                break;
            case R.id.btn_file1:
                intent = new Intent(MainActivity.this, FileActivity.class);
                break;
            case R.id.btn_file2:
                intent = new Intent(MainActivity.this, ExtenalFileActivity.class);
                break;
            case R.id.btn_litepal:
                intent = new Intent(MainActivity.this,LitePalActivity.class);
                break;
        }
        startActivity(intent);
    }
}
