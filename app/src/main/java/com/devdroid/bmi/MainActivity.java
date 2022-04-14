package com.devdroid.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llmain;

          edtWeight = findViewById(R.id.edtWeight);
          edtHeightFt = findViewById(R.id.edtHeightFt);
          edtHeightIn = findViewById(R.id.edtHeightIn);
          btnCalculate = findViewById(R.id.btnCalculate);
          txtResult = findViewById(R.id.textResult);
          llmain = findViewById(R.id.llMain);


          btnCalculate.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  int wt = Integer.parseInt( edtWeight.getText().toString() );
                  int ft = Integer.parseInt( edtHeightFt.getText().toString() );
                  int in = Integer.parseInt(edtHeightFt.getText().toString());

                  int totalIn = ft*12 + in;
                  double totalCm = totalIn*2.53;
                  double totalM = totalCm/100;
                  double bmi = wt/(totalM*totalM);

                  if(bmi>25){
                      txtResult.setText("You are Overweight");
                      llmain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                  } else if(bmi<18){
                      txtResult.setText("You are underweight");
                      llmain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                  } else {
                      txtResult.setText("You are Healthy");
                      llmain.setBackgroundColor(getResources().getColor(R.color.colorH));
                  }


              }
          });
    }
}