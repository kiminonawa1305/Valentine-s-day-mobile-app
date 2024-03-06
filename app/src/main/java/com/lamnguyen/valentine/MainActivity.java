package com.lamnguyen.valentine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

import com.lamnguyen.valentine.components.fragment.HeartFrag;
import com.lamnguyen.valentine.components.fragment.LetterFrag;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layoutOpen;
    private HeartFrag heartFrag;
    private LetterFrag letterFrag;
    private MediaPlayer music;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
        this.AnimatorOpen();
    }

    private void init() {
        layoutOpen = findViewById(R.id.open);
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment heartFragment = fragmentManager.findFragmentById(R.id.fragment_hearts);
        Fragment letterFragment = fragmentManager.findFragmentById(R.id.fragment_letter);

        if (heartFragment instanceof HeartFrag) {
             this.heartFrag = (HeartFrag) heartFragment;
        }else{
            Log.e("fragment not found", "Eroror fragment not found!");
        }

        if (letterFragment instanceof LetterFrag) {
            this.letterFrag = (LetterFrag) letterFragment;
        }else{
            Log.e("fragment not found", "Eroror fragment not found!");
        }

        music = MediaPlayer.create(this, R.raw.love_story_taylor_swift);
    }

    private void AnimatorOpen() {
        Animator openAnimator = AnimatorInflater.loadAnimator(this, R.animator.open);
        openAnimator.setTarget(this.layoutOpen);

        this.layoutOpen.setOnClickListener(view -> {
            openAnimator.start();
            this.heartFrag.fly();
            this.letterFrag.startAnimator();
            this.music.stop();
            try {
                this.music.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            this.music.start();


        });
    }

}