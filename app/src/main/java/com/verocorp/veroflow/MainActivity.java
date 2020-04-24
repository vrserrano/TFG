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
    ImageButton playpauseCancion;
    ImageButton siguienteCancion;
    ImageButton anteriorCancion;
    ImageView  caratula;

    MediaPlayer cancion [] = new MediaPlayer[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playpauseCancion = findViewById(R.id.playCancion);
        siguienteCancion = findViewById(R.id.siguienteCancion);
        anteriorCancion = findViewById(R.id.anteriorCancion);
        caratula = findViewById(R.id.caratula1);

        cancion [0] = MediaPlayer.create( this, song1);
        cancion [1] = MediaPlayer.create( this, song2);
        
        playpauseCancion.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playCancion.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                } else if (mediaPlayer.start();){
                    playCancion.setImageResource(R.drawable.ic_pause_black_24dp);
                } else if ( )
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

