package com.example.zahid.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView resultTextView;
    private EditText enterAmountEditText;
    private TextView totalBillTextView;
    private SeekBar seekBar;
    private Button calculateButton;
    private TextView seekbarTextView;
    private int seekbarPercentage;
    private float enteredBilFloat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enterAmountEditText = findViewById(R.id.billEditText);
        seekBar = findViewById(R.id.seekBar);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);
        seekbarTextView = findViewById(R.id.seekbarTextView);
        totalBillTextView = findViewById(R.id.totalBillTextView);

        calculateButton.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbarTextView.setText(String.valueOf(seekBar.getProgress()) + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekbarPercentage = seekBar.getProgress();
            }
        });
    }

    @Override
    public void onClick(View view) {
     calculate();
    }
    public void calculate()
    {
        float result  = 0.0f;
        float secondResult = 0.0f;
        if(!enterAmountEditText.getText().toString().equals(""))
        {
            enteredBilFloat = Float.parseFloat(String.valueOf(enterAmountEditText.getText()));
            result = enteredBilFloat * seekbarPercentage / 100;
            resultTextView.setText( "Your tip will be :"+String.valueOf(result) + "$");
            secondResult = enteredBilFloat + result;
            totalBillTextView.setText( "Your total bill will be :"+String.valueOf(secondResult) + "$");
        }else {
            Toast.makeText(MainActivity.this , "", Toast.LENGTH_LONG).show();
        }

    }
}
