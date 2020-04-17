package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);



        Intent intent = getIntent();
        final int number1 = intent.getIntExtra("n1", 0);
        final int number2 = intent.getIntExtra("n2", 0);

        String t1=String.valueOf(number1);
        String t2=String.valueOf(number2);


        TextView tv1 = findViewById(R.id.text1);
        tv1.setText(t1);
        TextView tv2 = findViewById(R.id.text2);
        tv2.setText(t2);



        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);
        Button buttonMulti = findViewById(R.id.button_multi);
        Button buttonDiv = findViewById(R.id.button_div);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                setResult(2, resultIntent);
                finish();
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                setResult(3, resultIntent);
                finish();
            }
        });



        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 * number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                setResult(4, resultIntent);
                finish();
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 / number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result", result);

                setResult(5, resultIntent);
                finish();
            }
        });
    }

}