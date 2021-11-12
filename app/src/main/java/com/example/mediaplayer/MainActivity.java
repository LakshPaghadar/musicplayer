package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private MediaPlayer toplay;
    private SeekBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        bar = findViewById(R.id.seekBar);

        // play mediaplayer from local file
        //toplay = MediaPlayer.create(this,R.raw.first);

        //play song from online sites


        bar.setMax(toplay.getDuration());
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 if(fromUser)
                 {
                     toplay.seekTo(progress);
                 }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        //toplay.start();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(toplay.isPlaying())
                {
                    toplay.pause();
                    btn.setText("play");
                }
                else
                {
                    toplay.start();
                    btn.setText("pause");
                }
            }
        });
    }
}