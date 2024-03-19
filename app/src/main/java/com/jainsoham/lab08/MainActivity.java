package com.jainsoham.lab08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    DrawView drawView;
    SeekBar seekBar;
    ConstraintLayout layout;
    Button pauseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawView = findViewById(R.id.drawView);
        seekBar = findViewById(R.id.seekbar);
        layout = findViewById(R.id.activity_main_layout);
        pauseButton = findViewById(R.id.pauseButton);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                drawView.setdXcircle(progress);
                drawView.setdYcircle(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                lastProgress = seekBar.getProgress();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Snackbar snackbar = Snackbar.make(layout, "Circle speed changed to " + seekBar.getProgress(), Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO",
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                seekBar.setProgress(lastProgress);
                            }
                        }
                );
                snackbar.show();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawView.getIsPaused()) {
                    drawView.resume();
                } else {
                    drawView.pause();
                }
            }
        });
    }
}