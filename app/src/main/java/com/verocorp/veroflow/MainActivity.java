package com.verocorp.veroflow;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    ImageButton playCancion;
    ImageButton siguienteCancion;
    String song1;
    String song2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playCancion = findViewById(R.id.playCancion);
        playCancion.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playCancion.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                } else {
                    mediaPlayer.start();
                    playCancion.setImageResource(R.drawable.ic_pause_black_24dp);
                }
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {

            mediaPlayer.setDataSource(song1);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Toast.makeText(MainActivity.this, "Media Buffering Complete", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        siguienteCancion = findViewById(R.id.siguienteCancion);
        siguienteCancion.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    siguienteCancion.setImageResource(R.drawable.ic_skip_next_black_24dp);

                } else {
                    mediaPlayer.start();
                    siguienteCancion.setImageResource(R.drawable.pajaros);
                }
            }
        });
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {

            mediaPlayer.setDataSource(song2);
            mediaPlayer.prepareAsync();

            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    Toast.makeText(MainActivity.this, "Media Buffering Complete", Toast.LENGTH_SHORT).show();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

