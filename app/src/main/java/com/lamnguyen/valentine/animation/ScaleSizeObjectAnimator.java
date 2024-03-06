package com.lamnguyen.valentine.animation;


import android.animation.ObjectAnimator;
import android.view.View;

import androidx.annotation.Nullable;

public class ScaleSizeObjectAnimator {
    private ObjectAnimator scaleX, scaleY;
    private float valueFrom, valueTo;
    private long duration;

    private ScaleSizeObjectAnimator(View view, float valueFrom, float valueTo, long duration) {
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        this.duration = duration;
        scaleX = ObjectAnimator.ofFloat(view, "scaleX", valueFrom, valueTo);
        scaleY = ObjectAnimator.ofFloat(view, "scaleY", valueFrom, valueTo);

        setDuration(duration);
    }

    private ScaleSizeObjectAnimator(View view, float valueFrom, float valueTo) {
        this.valueFrom = valueFrom;
        this.valueTo = valueTo;
        scaleX = ObjectAnimator.ofFloat(view, "scaleX", valueFrom, valueTo);
        scaleY = ObjectAnimator.ofFloat(view, "scaleY", valueFrom, valueTo);

        setDuration(1000);
    }

    public static ScaleSizeObjectAnimator init(View view, float valueFrom, float valueTo, long duration) {
        return new ScaleSizeObjectAnimator(view, valueFrom, valueTo, duration);
    }

    public static ScaleSizeObjectAnimator init(View view, float valueFrom, float valueTo) {
        return new ScaleSizeObjectAnimator(view, valueFrom, valueTo);
    }


    private void setDuration(long duration) {
        scaleX.setDuration(duration);
        scaleY.setDuration(duration);
    }

    public void start(){
        scaleX.start();
        scaleY.start();
    }

    public void start(float valueFrom, float valueTo){
        setValue(valueFrom, valueTo);
        this.start();
    }

    private void setValue(float valueFrom, float valueTo) {
        scaleX.setFloatValues(valueFrom, valueTo);
        scaleY.setFloatValues(valueFrom, valueTo);
    }
}
