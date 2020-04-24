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

import static com.verocorp.veroflow.R.drawable.astronomia;

public class MainActivity extends AppCompatActivity {

    ImageButton playPauseCancion;
    ImageButton siguienteCancion;
    ImageButton anteriorCancion;
    ImageView caratula;
    int posicion = 0;

    MediaPlayer cancion[] = new MediaPlayer[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseCancion = findViewById(R.id.playCancion);
        siguienteCancion = findViewById(R.id.siguienteCancion);
        anteriorCancion = findViewById(R.id.anteriorCancion);
        caratula = findViewById(R.id.caratula1);

        cancion[0] = MediaPlayer.create(this, R.raw.song1);
        cancion[1] = MediaPlayer.create(this, R.raw.song2);

        //Método para el botón playPause
        playPauseCancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancion[posicion].isPlaying()) {
                    cancion[posicion].pause();
                    playPauseCancion.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                    Toast.makeText(MainActivity.this, "Pause", Toast.LENGTH_SHORT).show();
                } else {
                    cancion[posicion].start();
                    playPauseCancion.setImageResource(R.drawable.ic_pause_black_24dp);
                    Toast.makeText(MainActivity.this, "Play", Toast.LENGTH_SHORT).show();
                }
            }
        });

        siguienteCancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion < cancion.length - 1) {
                    if (cancion[posicion].isPlaying()) {
                        cancion[posicion].pause();
                        posicion++;
                        cancion[posicion].start();

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                        }
                    } else {
                        posicion++;

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Fin lista canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });

        anteriorCancion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (posicion >= 1) {

                    if (cancion[posicion].isPlaying()) {
                        cancion[posicion].pause();

                        playPauseCancion = findViewById(R.id.playCancion);
                        siguienteCancion = findViewById(R.id.siguienteCancion);
                        anteriorCancion = findViewById(R.id.anteriorCancion);
                        posicion--;

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                        }
                        cancion[posicion].start();
                    } else {
                        posicion--;

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Fin lista canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}