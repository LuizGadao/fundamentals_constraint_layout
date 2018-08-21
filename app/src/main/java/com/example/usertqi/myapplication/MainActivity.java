package com.example.usertqi.myapplication;

import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View ivGreenBall = findViewById(R.id.greenBall);
        View ivYellowBall = findViewById(R.id.yellowBall);
        View ivblueBall = findViewById(R.id.blueBall);

        ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) ivblueBall.getLayoutParams();
        animatePlanet(ivblueBall, TimeUnit.SECONDS.toMillis(12), params.circleAngle).start();

        params = (ConstraintLayout.LayoutParams) ivGreenBall.getLayoutParams();
        animatePlanet(ivGreenBall, TimeUnit.SECONDS.toMillis(4), params.circleAngle).start();

        params = (ConstraintLayout.LayoutParams) ivYellowBall.getLayoutParams();
        animatePlanet(ivYellowBall, TimeUnit.SECONDS.toMillis(8), params.circleAngle).start();
    }

    private ValueAnimator animatePlanet(final View view, long duration, final float startAngle) {
        ValueAnimator anim = ValueAnimator.ofInt(0, 359);
        anim.setDuration(duration);
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.setRepeatCount(ValueAnimator.INFINITE);
        anim.setInterpolator(new LinearInterpolator());

        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int value = (int) valueAnimator.getAnimatedValue();
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();

                int angle = (int) ((value + startAngle) % 359);
                layoutParams.circleAngle = angle;
                view.setLayoutParams(layoutParams);
            }
        });

        return anim;
    }
}
