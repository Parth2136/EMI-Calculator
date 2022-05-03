package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.example.emicalculator.R;

public class MainActivity extends AppCompatActivity  {
    Button calculate;
    TextView result;
    EditText pe, ne, re;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate =  findViewById(R.id.button);
        result =  findViewById(R.id.textView);
        pe = findViewById(R.id.editText);
        ne = findViewById(R.id.editText2);
        re = findViewById(R.id.editText3);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Double p = Double.parseDouble(pe.getText().toString());
                Double n = Double.parseDouble(ne.getText().toString());
                Double r = Double.parseDouble(re.getText().toString());
                Double rate= (r/1200);
                Double res = (p * rate * Math.pow(1 + rate, n) / Math.pow(1 + rate, n) - 1);
                result.setText("EMI = "+String.valueOf(res));
            }
        });
    }
}