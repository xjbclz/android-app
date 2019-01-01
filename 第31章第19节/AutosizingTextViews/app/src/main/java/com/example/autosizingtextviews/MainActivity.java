package com.example.autosizingtextviews;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    int presetSizes[] = {12, 14, 16};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textview);
        //textView.setAutoSizeTextTypeWithDefaults(TextView.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        //textView.setAutoSizeTextTypeUniformWithConfiguration(12, 112, 2, TypedValue.COMPLEX_UNIT_PX);
        textView.setAutoSizeTextTypeUniformWithPresetSizes(presetSizes, TypedValue.COMPLEX_UNIT_PX);
        //TextViewCompat.setAutoSizeTextTypeWithDefaults(textView, TextViewCompat.AUTO_SIZE_TEXT_TYPE_UNIFORM);
        //TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration();
        //TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, 12, 112, 2, TypedValue.COMPLEX_UNIT_PX);
        //TextViewCompat.setAutoSizeTextTypeUniformWithPresetSizes();
    }
}
