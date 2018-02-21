package com.example.datastorage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExtenalFileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String mFileName = "text.txt";
    private Button mbtnSave, mbtnShow;
    private EditText metTitle;
    private TextView mtvContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extenal_file);
        setTitle("FileDataStorage");
        mbtnSave = findViewById(R.id.btn_save);
        mbtnShow = findViewById(R.id.btn_show);
        metTitle = findViewById(R.id.ev_content);
        mtvContent = findViewById(R.id.tv_show);

        mbtnSave.setOnClickListener(this);
        mbtnShow.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                //传入EditText的文本内容
                save(metTitle.getText().toString());
                break;
            case R.id.btn_show:
                //从存储区拿出给TextView作为内容
                mtvContent.setText(read());
                break;
        }
    }

    /*
            存储数据   首先要在Mainfest中申请权限，同时还要动态声明   这里动态申明放在了MainActivity中
     */
    private void save(String content) {
        FileOutputStream fileOutputStream = null;
        Log.d("save", "---" + content + "---");
        //通过try-catch捕获异常
        try {
            //fileOutputStream = openFileOutput(mFileName,MODE_PRIVATE);
            //在外部存储创建一个文件夹  并判断这个文件夹是否已经存在 否则新建一个  后面一个参数为文件夹名
            File dir = new File(Environment.getExternalStorageDirectory(), "cookies");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //在外部存储创建一个文件  并判断这个文件夹是否已经存在 否则新建一个 ，传入参数为文件夹名与文件名
            File file = new File(dir, mFileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            //实例化  并传入file
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());//通过write方法存入数据  记得先将数据转化为字节数组
        } catch (IOException e) { //文件查找不到也是属于IOException异常的子类 所以 只有catch IOException就可以了
            e.printStackTrace();
        } finally {   //  每次操作完文件都要在最后关闭  同时为了避免出现空指针异常所以进行判断 在finally中操作规范
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
           读取数据
     */
    private String read() {
        FileInputStream fileInputStream = null;
        Log.d("read", "---read:--- ");
        try {  //通过try-catch捕获异常
            //fileInputStream = openFileInput(mFileName); //实例化
            //获取文件所在的完整路径  File.separator 其实就是一个斜杠  等同于   "/cookies"
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+File.separator+"cookies",mFileName);
            fileInputStream = new FileInputStream(file); //传入参数file
            byte[] buff = new byte[1024];       //创建一个字节数组作为缓存接收read（）方法传回的数据
            StringBuilder stringBuffer = new StringBuilder("");      //通过StringBuilder方法拼接字符串
            //  StringBuffer stringBuffer = new StringBuffer("");      //通过StringBuffer方法拼接字符串
            int len = 0;         //read（）方法返回的是一个int型的数据，代表是读取的字节数  为-1时表示读取到最后一个
            while ((len = fileInputStream.read(buff)) > 0) {   //read()方法将读取到的数据存入一个目标字节数组buff  并返回一个int型字节数
                stringBuffer.append(new String(buff, 0, len));//拼接字节  并转化为字符串
            }
            Log.d("read", "---" + stringBuffer.toString() + "---");
            return stringBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {   //  每次操作完文件都要在最后关闭  同时为了避免出现空指针异常所以进行判断 在finally中操作规范
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
