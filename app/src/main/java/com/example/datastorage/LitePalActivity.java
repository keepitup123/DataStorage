package com.example.datastorage;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LitePalActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mbtnCreate, mbtnAdd, mbtnUpdate, mbtnDelete, mbtnQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        mbtnAdd = findViewById(R.id.btn_add);
        mbtnCreate = findViewById(R.id.btn_create);
        mbtnDelete = findViewById(R.id.btn_delete);
        mbtnQuery = findViewById(R.id.btn_query);
        mbtnUpdate = findViewById(R.id.btn_update);

        mbtnCreate.setOnClickListener(this);
        mbtnAdd.setOnClickListener(this);
        mbtnUpdate.setOnClickListener(this);
        mbtnDelete.setOnClickListener(this);
        mbtnQuery.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_create:
               // LitePal.getDatabase();
                break;
            case R.id.btn_add:
                break;
            case R.id.btn_update:
                break;
            case R.id.btn_delete:
                break;
            case R.id.btn_query:

        }

    }
}
