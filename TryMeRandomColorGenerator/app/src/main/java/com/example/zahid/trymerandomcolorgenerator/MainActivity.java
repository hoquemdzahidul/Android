package com.example.zahid.trymerandomcolorgenerator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button tryMeButton;
    private View windowView;
    private int[] colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colors = new int[]{Color.RED , Color.GRAY , Color.GREEN , Color.BLACK , Color.YELLOW , Color.BLUE, Color.CYAN , Color.MAGENTA , Color.MAGENTA };
        tryMeButton = findViewById(R.id.tryMeButton);
        windowView = findViewById(R.id.windowView);
        windowView.setBackgroundColor(Color.RED);
        tryMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int colorArrayLength = colors.length;
                int randomNumber = random.nextInt(colorArrayLength);
                windowView.setBackgroundColor(colors[randomNumber]);
            }
        });
    }
}
