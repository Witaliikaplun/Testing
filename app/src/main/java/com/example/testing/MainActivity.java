package com.example.testing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et1;
    EditText et2;
    public static final String APP_PREFERENCES = "mysettings";
    SharedPreferences sharedPreferences;
    SaveValuesHelper saveValuesHelper;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        TextView tv1 = findViewById(R.id.tv1);
        TextView tv2 = findViewById(R.id.tv2);
        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSub = findViewById(R.id.btn_sub);
        Button btnDiv = findViewById(R.id.btn_div);
        Button btnMul = findViewById(R.id.btn_mul);
        Calculator calculator = new Calculator();
        sharedPreferences = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        saveValuesHelper = new SaveValuesHelper(sharedPreferences);
        Values valuesfirst = saveValuesHelper.readValues();

        et1.setText(valuesfirst.getFirstOperand());
        et2.setText(valuesfirst.getSecondOperand());

        btnAdd.setOnClickListener(view -> {
            tv1.setText("+");
            tv2.setText(String.valueOf(calculator.add(Integer.parseInt(et1.getText().toString()),
                    Integer.parseInt(et2.getText().toString()))));
        });

        btnSub.setOnClickListener(view -> {
            tv1.setText("-");
            tv2.setText(String.valueOf(calculator.subtract(Integer.parseInt(et1.getText().toString()),
                    Integer.parseInt(et2.getText().toString()))));
        });

        btnDiv.setOnClickListener(view -> {
            tv1.setText("/");
            tv2.setText(String.valueOf(calculator.divide(Integer.parseInt(et1.getText().toString()),
                    Integer.parseInt(et2.getText().toString()))));
        });

        btnMul.setOnClickListener(view -> {
            tv1.setText("*");
            tv2.setText(String.valueOf(calculator.multiply(Integer.parseInt(et1.getText().toString()),
                    Integer.parseInt(et2.getText().toString()))));
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Values values = new Values();
        values.setFirstOperand(et1.getText().toString());
        values.setSecondOperand(et2.getText().toString());
        saveValuesHelper.saveValues(values);
    }
}