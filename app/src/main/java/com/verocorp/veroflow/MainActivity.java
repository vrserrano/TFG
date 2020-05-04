package com.verocorp.veroflow;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import static com.verocorp.veroflow.R.drawable.astronomia;

public class MainActivity extends AppCompatActivity {

    ImageButton playPauseCancion;
    ImageButton siguienteCancion;
    ImageButton anteriorCancion;
    ImageView caratula;
    TextView grupoMusica;
    int posicion = 0;

    SeekBar seekBar3;
    Handler handler;
    Runnable runnable;


    MediaPlayer cancion[] = new MediaPlayer[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playPauseCancion = findViewById(R.id.playCancion);
        siguienteCancion = findViewById(R.id.siguienteCancion);
        anteriorCancion = findViewById(R.id.anteriorCancion);
        caratula = findViewById(R.id.caratula1);
        grupoMusica = findViewById(R.id.grupo);

        handler = new Handler();
        seekBar3 = (SeekBar) findViewById(R.id.seekBar3);


        seekBar3.setOnSeekBarChangeListener(new seekBar3.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged( SeekBar seekBar3, int progress, boolean fromUser) {

            }
             @Override
             public void onStartTrackingTouch( SeekBar seekBar3 ) {

             }
            @Override
            public void onStopTrackingTouch( SeekBar seekBar3) {

            }



        cancion[0] = MediaPlayer.create(this, R.raw.song1);
        cancion[1] = MediaPlayer.create(this, R.raw.song2);

        seekBar3.setMax(MediaPlayer.getDuration());



        };

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
                        cancion[posicion].seekTo(0);
                        posicion++;
                        cancion[posicion].start();

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                            grupoMusica.setText("Grupo: Vicetone");
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                            grupoMusica.setText("Grupo: Picture this");
                        }
                    } else {
                        posicion++;
                        cancion[posicion].seekTo(0);

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                            grupoMusica.setText("Grupo: Vicetone");
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                            grupoMusica.setText("Grupo: Picture this");
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
                        cancion[posicion].seekTo(0);
                        posicion--;

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                            grupoMusica.setText("Grupo: Vicetone");
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                            grupoMusica.setText("Grupo: Picture this");
                        }

                        cancion[posicion].start();
                    } else {
                        posicion--;
                        cancion[posicion].seekTo(0);

                        if (posicion == 0) {
                            caratula.setImageResource(astronomia);
                            grupoMusica.setText("Grupo: Vicetone");
                        } else if (posicion == 1) {
                            caratula.setImageResource(R.drawable.picture);
                            grupoMusica.setText("Grupo: Picture this");
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Fin lista canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}