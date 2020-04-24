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

    String music1 = "https://sampleswap.org/samples-ghost/PUBLIC%20DOMAIN%20MUSIC/1939%20American%20Folklife%20Lomax%20Recordings/203[kb]jr-lomax-1939-clapping-song_satisfied.mp3.mp3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playCancion = findViewById(R.id.playCancion);
        playCancion.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    playCancion.setImageResource(R.drawable.play);
                } else {
                    mediaPlayer.start();
                    playCancion.setImageResource(R.drawable.pause);
                }
            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(music1);
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
