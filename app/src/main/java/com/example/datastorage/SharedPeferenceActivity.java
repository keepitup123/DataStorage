package com.example.datastorage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SharedPeferenceActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnSave,mbtnShow;
    private EditText metTitle;
    private TextView mtvContent;

//声明对象
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_peference);
        setTitle("SharedPeference");
        mbtnSave = findViewById(R.id.btn_save);
        mbtnShow = findViewById(R.id.btn_show);
        metTitle = findViewById(R.id.ev_content);
        mtvContent = findViewById(R.id.tv_show);

        mbtnSave.setOnClickListener(this);
        mbtnShow.setOnClickListener(this);
//获得SharedPeference 的实例  和获得Edit实例  data为字符串的名字（自定义）后面一个参数为  mode
        sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_save :
                //通过Edit来写
                String input = metTitle.getText().toString();
                editor.putString("name",input);
                editor.apply();

                break;
            case R.id.btn_show:
                //通过Sharedpeference的对象的getString方法  或者信息
                mtvContent.setText(sharedPreferences.getString("name",""));
                break;
        }
    }
}
