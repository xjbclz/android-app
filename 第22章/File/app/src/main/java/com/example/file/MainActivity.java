package com.example.file;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPrivateFile();
        createPrivateCacheFile();

        createExternalPublicFile();

        createExternalPrivateFile();
        createExternalCacheFile();

        accessStorageManager();
    }

    public void createPrivateFile(){
        String fileName = "private.txt";
        String content = "private";

        File file = new File(getFilesDir(), fileName);
        Log.v("file", "file=" + file.getAbsolutePath());

        try {
            //FileOutputStream fos = new FileOutputStream(file);

            FileOutputStream fos = openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_LONG);
        }
    }

    public void createPrivateCacheFile(){
        String fileName = "cache.txt";
        String content = "cache";

        File file = new File(getCacheDir(), fileName);
        Log.v("file", "file=" + file.getAbsolutePath());

        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(content.getBytes());
            fos.close();
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_LONG);
        }

    }

    public boolean isExternalStorageWR() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    public void createExternalPublicFile(){
        String fileName = "public.txt";
        String content = "public";

        if (isExternalStorageWR()){
            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),fileName);
            Log.v("file", "file=" + file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(content.getBytes());
                fos.close();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_LONG);
            }
        }
    }

    public void createExternalPrivateFile(){
        String fileName = "private.txt";
        String content = "private";

        if (isExternalStorageWR()){
            File file = new File(getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS),fileName);
            Log.v("file", "file=" + file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(content.getBytes());
                fos.close();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_LONG);
            }
        }
    }

    public void createExternalCacheFile(){
        String fileName = "cache.txt";
        String content = "cache";

        if (isExternalStorageWR()){
            File file = new File(getExternalCacheDir().getAbsolutePath(),fileName);
            Log.v("file", "file=" + file.getAbsolutePath());

            try {
                FileOutputStream fos = new FileOutputStream(file);
                fos.write(content.getBytes());
                fos.close();
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "创建文件失败", Toast.LENGTH_LONG);
            }
        }
    }

    public void accessStorageManager(){
        int request_code = 1;
        StorageManager sm = (StorageManager)getSystemService(Context.STORAGE_SERVICE);
        StorageVolume volume = sm.getPrimaryStorageVolume();
        Intent intent = volume.createAccessIntent(Environment.DIRECTORY_PICTURES);
        startActivityForResult(intent, request_code);
    }
}
