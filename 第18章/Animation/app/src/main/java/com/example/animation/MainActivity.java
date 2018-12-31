package com.example.animation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameAnimation();
        viewAnimation();

        //textViewSetTranslationX();
        //valueAnimation();

        objectAnimation();
    }

    public void frameAnimation(){
        ImageView frameAnimationView = (ImageView)findViewById(R.id.frame_animation_imageView);
        frameAnimationView.setBackgroundResource(R.drawable.frame_animation);
        AnimationDrawable frameAnimation = (AnimationDrawable)frameAnimationView.getBackground();
        frameAnimation.start();
    }

    public void viewAnimation(){
        TextView textView = (TextView) findViewById(R.id.view_animation_textView);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.view_animation);
        textView.startAnimation(animation);
    }

    public void textViewSetTranslationX(){
        final TextView textView = (TextView) findViewById(R.id.property_animation_textView);
        ValueAnimator animation = ValueAnimator.ofFloat(0f, 200f);
        animation.setDuration(1000);
        animation.start();
        animation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                float animatedValue = (float) updatedAnimation.getAnimatedValue();
                //如下代码是沿X轴方向平移，如果沿Y轴方向平移，则调用setTranslationY函数
                textView.setTranslationX(animatedValue);
            }
        });

//        //如下代码是沿X轴方向平移，如果沿Y轴方向平移，则第二个参数值设为translationY
//        ObjectAnimator animation = ObjectAnimator.ofFloat(textView, "translationX", 200f);
//        animation.setDuration(1000);
//        animation.start();
    }

    public void valueAnimation(){
        final TextView textView = (TextView) findViewById(R.id.property_animation_textView);
        ValueAnimator xmlAnimator = (ValueAnimator)AnimatorInflater.loadAnimator(MainActivity.this,R.animator.value_animation);
        xmlAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate(ValueAnimator updatedAnimation) {
                float animatedValue = (float)updatedAnimation.getAnimatedValue();
                textView.setTranslationX(animatedValue);
            }
        });

        xmlAnimator.start();
    }

    public void objectAnimation(){
        TextView textView = (TextView) findViewById(R.id.property_animation_textView);
        AnimatorSet set = (AnimatorSet)AnimatorInflater.loadAnimator(MainActivity.this, R.animator.object_animation);
        set.setTarget(textView);
        set.start();
    }

    public void goSettings(View v){
        Intent intent=new Intent(this,SettingsActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }
}
