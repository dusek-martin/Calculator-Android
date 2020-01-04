package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class calculate extends AppCompatActivity {

    TextView twFirstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        twFirstNumber = (TextView) findViewById(R.id.textViewFirstNumber);
    }

    public void writeNumber(android.view.View view){
        twFirstNumber.setText(((Button) view).getText());
    }
    public void clear(android.view.View view){

    }
    public void delete(android.view.View view){

    }
    public void squareRoot(android.view.View view){

    }
    public void negative(android.view.View view){

    }
    public void divide(android.view.View view){

    }
    public void multiply(android.view.View view){

    }
    public void minus(android.view.View view){

    }
    public void writeComma(android.view.View view){

    }
    public void plus(android.view.View view){

    }
    public void equals(android.view.View view){

    }
}
