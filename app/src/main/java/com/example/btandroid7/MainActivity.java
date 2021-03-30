package com.example.btandroid7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    int option = 1;
    private RadioGroup convertGroup ;
    private EditText edtInput ;
    private EditText edtOutput ;
    private Button btnConvert;
    private TextView history;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        this.convertGroup = (RadioGroup) findViewById(R.id.radioGroup);
        this.edtInput = (EditText) findViewById(R.id.edtInput);
        this.edtOutput = (EditText) findViewById(R.id.edtOutput);
        this. btnConvert = (Button) findViewById(R.id.convert);
        this.history = (TextView) findViewById(R.id.history);


        convertGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                doOnDifficultyLevelChanged(group, checkedId);
            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                DecimalFormat f = new DecimalFormat("##.0");
                if(option == 1) {
                    double input = Double.valueOf(edtInput.getText().toString());
                    edtOutput.setText(f.format(convertFahrenheitToCelsius(input)));
                    history.append("F sang C: " + edtInput.getText() +" -> "  + f.format(convertFahrenheitToCelsius(input)) + "\n");
                }else {
                    double input = Double.valueOf(edtInput.getText().toString());
                    edtOutput.setText(f.format(convertCelsiusToFahrenheit(input)));
                    history.append("C sang F: " + edtInput.getText() +" -> "  + f.format(convertCelsiusToFahrenheit(input))+  "\n");
                }
            }
        });
    }

    private double convertFahrenheitToCelsius(double f){
        double result = (f - 32.0) * 5.0/9.0;
        return result;
    }

    private double convertCelsiusToFahrenheit(double c){
        double result = (c * 9.0/5.0) + 32.0;
        return result;
    }

    private void doOnDifficultyLevelChanged(RadioGroup group, int checkedId) {
        int checkedRadioId = group.getCheckedRadioButtonId();

        if(checkedRadioId== R.id.radioFToC) {
            option = 1;
            edtInput.setText("");
            edtOutput.setText("");
        } else if(checkedRadioId== R.id.radioCToF ) {
            option = 2;
            edtInput.setText("");
            edtOutput.setText("");
        }
    }
}