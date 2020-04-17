package com.example.lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView wynik;
    private EditText tv1;
    private EditText tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wynik = findViewById(R.id.result);
        tv1 = findViewById(R.id.edit1);
        tv2 = findViewById(R.id.edit2);

        Button buttonOpenActivity2 = findViewById(R.id.bOblicz);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tv1.getText().toString().equals("")
                        || tv2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                } else {

                    int number1 = Integer.parseInt(tv1.getText().toString());
                    int number2 = Integer.parseInt(tv2.getText().toString());

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("n1", number1);
                    intent.putExtra("n2", number2);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == 2) {
                int result = data.getIntExtra("result", 0);
                wynik.setText(tv1.getText().toString() + " + " + tv2.getText().toString() + " = "+ result);
            }
            if (resultCode == 3) {
                int result = data.getIntExtra("result", 0);
                wynik.setText(tv1.getText().toString() + " - " + tv2.getText().toString() + " = "+ result);
            }
            if (resultCode == 4) {
                int result = data.getIntExtra("result", 0);
                wynik.setText(tv1.getText().toString() + " * " + tv2.getText().toString() + " = "+ result);
            }
            if (resultCode == 5) {
                int result = data.getIntExtra("result", 0);
                wynik.setText(tv1.getText().toString() + " / " + tv2.getText().toString() + " = "+ result);
            }
            if (resultCode == RESULT_CANCELED) {
                wynik.setText("Nic nie wybrano");
            }
        }
    }
}