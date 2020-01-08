package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class calculate extends AppCompatActivity {

    private TextView tvFirstNumber, tvOperation, tvSecondNumber, tvWritedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        tvFirstNumber = (TextView) findViewById(R.id.textViewFirstNumber);
        tvOperation = (TextView) findViewById(R.id.textViewOperation);
        tvSecondNumber = (TextView) findViewById(R.id.textViewSecondNumber);
        tvWritedNumber = (TextView) findViewById(R.id.textViewWritedNumber);
    }

    public void writeNumber(android.view.View view) {
        if (tvOperation.length() > 0) {
            if (tvSecondNumber.getText().toString().length() > 10) return;
            if (tvSecondNumber.getText().toString().contentEquals("0")) {
                if (((Button) view).getText().toString().contentEquals(".")) {
                    tvSecondNumber.append(((Button) view).getText());
                } else {
                    tvSecondNumber.setText(((Button) view).getText());
                }
            } else {
                tvSecondNumber.append(((Button) view).getText());
            }
        } else {
            if (tvFirstNumber.getText().toString().length() > 10) return;
            if (tvFirstNumber.getText().toString().contentEquals("0")) {
                if (((Button) view).getText().toString().contentEquals(".")) {
                    tvFirstNumber.append(((Button) view).getText());
                } else {
                    tvFirstNumber.setText(((Button) view).getText());
                }
            } else {
                tvFirstNumber.append(((Button) view).getText());
            }
        }
    }

    public void clear(android.view.View view) {
        tvFirstNumber.setText("0");
        tvOperation.setText("");
        tvSecondNumber.setText("0");
        tvWritedNumber.setText("0");
    }

    public void delete(android.view.View view) {
        if (tvSecondNumber.getText().toString().length() != 1) {
            tvSecondNumber.setText(tvSecondNumber.getText().toString().substring(0, (tvSecondNumber.getText().toString().length() - 1)));
        } else if (!tvSecondNumber.getText().toString().contentEquals("0")) {
            tvSecondNumber.setText("0");
        } else if (tvFirstNumber.getText().toString().length() != 1) {
            tvFirstNumber.setText(tvFirstNumber.getText().toString().substring(0, (tvFirstNumber.getText().toString().length() - 1)));
        } else if (!tvFirstNumber.getText().toString().contentEquals("0")) {
            tvFirstNumber.setText("0");
        }
    }

    public void negative(android.view.View view) {
        if (tvOperation.length() > 0) {
            tvSecondNumber.setText("-"+tvSecondNumber.getText().toString());
        } else {
            tvFirstNumber.setText("-"+tvFirstNumber.getText().toString());
        }
    }

    public void writeOperation(android.view.View view) {
        if (tvOperation.getText().toString().length() != 0) {
            equals(view);
            tvOperation.setText(((Button) view).getText());
            if (tvWritedNumber.getText().toString().contentEquals("NaN")) {
                tvFirstNumber.setText("0");
            } else {
                tvFirstNumber.setText(tvWritedNumber.getText());
            }
            tvSecondNumber.setText("0");
        } else {
            tvOperation.setText(((Button) view).getText());
        }
    }

    public void equals(android.view.View view) {
        double a = Double.parseDouble(tvFirstNumber.getText().toString());
        double b = Double.parseDouble(tvSecondNumber.getText().toString());
        double e = 0;

        switch (tvOperation.getText().toString()) {
            case "+":
                e = a + b;
                break;
            case "-":
                e = a - b;
                break;
            case "*":
                e = a * b;
                break;
            case "/":
                if (b == 0) {
                    tvWritedNumber.setText("NaN");
                    return;
                }
                e = a / b;
                break;
            case "^":
                e = Math.pow(a, b);
                break;
            default:
                break;
        }
        if (String.valueOf(e).length() > 10 ) {
            tvWritedNumber.setText(String.valueOf(e).substring(0,9));
        } else {
            tvWritedNumber.setText(String.valueOf(e));
        }
    }
}
