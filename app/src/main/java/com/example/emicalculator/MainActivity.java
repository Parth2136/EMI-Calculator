package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import com.example.emicalculator.R;

public class MainActivity extends AppCompatActivity  {

    EditText amount_edt , int_edt , month_edt;
    Button emi;
    TextView emi_txt , total_txt , extra_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount_edt =findViewById(R.id.amount_edt);
        int_edt =findViewById(R.id.int_edt);
        month_edt =findViewById(R.id.month_edt);
        emi =findViewById(R.id.emi);
        emi_txt =findViewById(R.id.emi_txt);
        total_txt =findViewById(R.id.total_txt);
        extra_txt =findViewById(R.id.extra_txt);

        emi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(amount_edt.getText().toString().isEmpty()) {
                    amount_edt.setError("Enter Amount!!");
                } else if (int_edt.getText().toString().isEmpty()) {
                    int_edt.setError("Enter Intrest!!");
                } else if (month_edt.getText().toString().isEmpty()) {
                    month_edt.setError("Enter Month!!");
                } else {

                    double amt = Double.parseDouble(amount_edt.getText().toString());
                    double rate = Double.parseDouble(int_edt.getText().toString());
                    double month = Double.parseDouble(month_edt.getText().toString());

                    double r = rate / (12 * 100);

                    double cal = 1;

                    for(int i=0; i<month ; i++) {
                        cal *= (1 + r);
                    }

                    double ans =amt * r * (cal / (cal-1));

                    emi_txt.setText("EMI = "+ans);
                    total_txt.setText("Total = "+(ans*month));
                    extra_txt.setText("Intrest Amt = "+(ans*month-amt));

                }
            }
        });

    }
}