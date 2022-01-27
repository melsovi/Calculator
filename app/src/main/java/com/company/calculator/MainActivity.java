package com.company.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.FileReader;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Double firstVar;
    private Double secondVar;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.tv_result);
    }

    public void onNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.btn_null:
                setNumber("0");
                break;
            case R.id.btn_clear:
                tvResult.setText("0");
                firstVar = 0.0;
                secondVar = 0.0;
                break;
        }
    }

    private void setNumber(String number) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else if (isOperationClick) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.btn_plus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;
            case R.id.btn_equal:
                secondVar = Double.parseDouble(tvResult.getText().toString());
                Double result = 0.0;
                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        break;
                    case "/":
                        result = firstVar / secondVar;
                        break;
                    case "X":
                        result = firstVar * secondVar;
                        break;
                    case "-":
                        result = firstVar - secondVar;
                        break;
                }
                tvResult.setText(result.toString());
                break;
            case R.id.btn_split:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;
            case R.id.btn_mltplct:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;
            case R.id.btn_minus:
                firstVar = Double.parseDouble(tvResult.getText().toString());
                isOperationClick = true;
                operation = "-";
                break



                        ;
        }
    }
}