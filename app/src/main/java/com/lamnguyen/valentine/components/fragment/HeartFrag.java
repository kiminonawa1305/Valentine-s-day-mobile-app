package com.lamnguyen.valentine.components.fragment;


import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.lamnguyen.valentine.R;
import com.lamnguyen.valentine.animation.ScaleSizeObjectAnimator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class HeartFrag extends Fragment {
    private List<Animator> animators;
    private Map<Animator, ScaleSizeObjectAnimator> scaleSizeObjectAnimators;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heart, container, false);
        this.init(view);
        return view;
    }

    private void init(View view) {
        this.animators = new ArrayList<>();
        this.scaleSizeObjectAnimators = new HashMap<>();
        ConstraintLayout constraintLayout = view.findViewById(R.id.layout_display);
        Random random = new Random();
        for (int i = 0; i < constraintLayout.getChildCount(); i++) {
            ImageView heart = (ImageView) constraintLayout.getChildAt(i);

            Animator animator = AnimatorInflater.loadAnimator(this.getContext(), R.animator.fly);
            ScaleSizeObjectAnimator scale = ScaleSizeObjectAnimator.init(heart, 1, random.nextInt(3) + 2, 10000);
            animator.setStartDelay(i * (random.nextInt(3) + 3) * 100);
            animator.setTarget(heart);


            animators.add(animator);
            scaleSizeObjectAnimators.put(animator, scale);
        }
    }

    public void fly() {
        Random random = new Random();
        Collections.shuffle(animators);
        for (Animator animator : animators) {
            animator.start();
            scaleSizeObjectAnimators.get(animator).start(1, random.nextInt(3) + 2);
        }
    }
}