package com.lamnguyen.valentine.components.fragment;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lamnguyen.valentine.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class LetterFrag extends Fragment {
    private TextView text;
    private ImageView bubble;

    private Animator animatorText, animatorBubble;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_letter, container, false);
        this.init(view);
        addAnimator();
        return view;
    }

    private void init(View view) {
        this.text = view.findViewById(R.id.main_text);
        this.bubble = view.findViewById(R.id.bubble);
    }

    private void addAnimator(){
        animatorBubble = AnimatorInflater.loadAnimator(this.getContext(), R.animator.letter_fly);
        animatorBubble.setStartDelay(8500);
        animatorBubble.setTarget(this.bubble);

        animatorText = AnimatorInflater.loadAnimator(this.getContext(), R.animator.letter_fly);
        animatorText.setStartDelay(8500);
        animatorText.setTarget(this.text);
    }

    public void startAnimator(){
        this.animatorBubble.start();
        this.animatorText.start();
    }
}