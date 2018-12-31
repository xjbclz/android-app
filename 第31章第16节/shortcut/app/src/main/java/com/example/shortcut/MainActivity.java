package com.example.shortcut;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

        ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "scIdOpenUrl")
                .setShortLabel(getResources().getString(R.string.shortcut_website))
                .setLongLabel(getResources().getString(R.string.shortcut_long_website))
                .setIcon(Icon.createWithResource(MainActivity.this, R.drawable.ic_website))
                .setIntent(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.baidu.com/")))
                .build();

        shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));

    }
}
