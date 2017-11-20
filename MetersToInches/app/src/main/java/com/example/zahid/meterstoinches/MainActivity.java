package com.example.zahid.meterstoinches;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText meterEditText;
    private Button convertButton;
    private TextView resultTextView;
    private  Button clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        meterEditText = findViewById(R.id.meterEditText);
        resultTextView = findViewById(R.id.resultTextView);
        convertButton = findViewById(R.id.convertButton);
        clearButton = findViewById(R.id.clearButton);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double multipler = 39.37;
                double result = 0.0;
                double takenInputAsMeter;

                if(meterEditText.getText().toString().equals(""))
                {

                    resultTextView.setText(R.string.error_message_for_empty_input);
                    resultTextView.setTextColor(Color.RED);
                }else {
                     takenInputAsMeter = Double.parseDouble(String.valueOf(meterEditText.getText()));
                    result = multipler * takenInputAsMeter;
                    resultTextView.setText(String.format("%.2f" , result) + " inches");
                    resultTextView.setTextColor(Color.BLUE);
                }


            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                meterEditText.setText("");
                resultTextView.setText("");
            }
        });
    }
}
