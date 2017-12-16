package com.example.zahid.mediaplayer;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     private MediaPlayer mediaPlayer;
     private Button playButton;
     private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.mSeekBar);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                int duration  = mediaPlayer.getDuration();
                String mDuration = String.valueOf(duration / 1000);
                Toast.makeText(getApplicationContext() , "Duration " + mDuration , Toast.LENGTH_LONG).show();
            }
        });
        mediaPlayer = MediaPlayer.create(getApplicationContext() , R.raw.habib);
        seekBar.setMax(mediaPlayer.getDuration());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(b)
                {
                    mediaPlayer.seekTo(i);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying())
                {
                    pauseMusic();
                }else{
                    startMusic();
                }
            }
        });
    }
    void pauseMusic()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.pause();
            playButton.setText("Play !!!");
            playButton.setBackgroundColor(Color.GREEN);

        }
    }
    void startMusic()
    {
        if (mediaPlayer != null)
        {
            mediaPlayer.start();
            playButton.setText("Pause !!!");

            playButton.setBackgroundColor(Color.RED);
        }
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null && mediaPlayer.isPlaying())
        {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}
