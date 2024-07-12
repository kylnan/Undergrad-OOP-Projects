package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    TextView workspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        workspace = findViewById(R.id.workspace);

    }

    public void numberEvent(View view) {
        if(isNewOp)
            workspace.setText("");
        isNewOp = false;
        String number = workspace.getText().toString();
        switch(view.getId()){
            case R.id.one_button:
                number+= "1";
                break;
            case R.id.two_button:
                number+= "2";
                break;
            case R.id.three_button:
                number+= "3";
                break;
            case R.id.four_button:
                number+= "4";
                break;
            case R.id.five_button:
                number+= "5";
                break;
            case R.id.six_button:
                number+= "6";
                break;
            case R.id.seven_button:
                number+= "7";
                break;
            case R.id.eight_button:
                number+= "8";
                break;
            case R.id.nine_button:
                number+= "9";
                break;
            case R.id.zero_button:
                number+= "0";
                break;

            case R.id.point_button:
                number += ".";
                break;

            case R.id.sign_button:
                if(workspace.getText().toString().equals("")){
                    number = "0";
                }
                else if(workspace.getText().toString().charAt(0) == '-'){
                    number = workspace.getText().toString().replace("-", "");
                }
                else {
                    number = "-"+number;
                }
                break;
        }
        workspace.setText(number);
    }

    public void operatorEvent(View view) {
        isNewOp = true;
        oldNumber = workspace.getText().toString();
        switch (view.getId()) {
            case R.id.sqrt_button:
                op = "sqrt";
                break;
            case R.id.sqre_button:
                op = "^2";
                break;
            case R.id.pow_button:
                op = "^";
                break;
            case R.id.log_button:
                op = "ln";
                break;
            case R.id.div_button:
                op = "/";
                break;
            case R.id.mult_button:
                op = "*";
                break;
            case R.id.sub_button:
                op = "-";
                break;
            case R.id.add_button:
                op = "+";
                break;

        }

    }

    public void assignEvent(View view) {
        String newNumber = workspace.getText().toString();
        double result = 0.0;
        boolean divByZero = false;
        switch (op){
            case "+":
                result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                break;
            case "-":
                result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                break;
            case "*":
                result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                break;
            case "/":
                if (Double.parseDouble(newNumber) == 0.0){
                    divByZero = true;
                }
                else {
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                }
                break;
            case "sqrt":
                result = Math.sqrt(Double.parseDouble(newNumber));
                break;
            case "^2":
                result = Double.parseDouble(newNumber) * Double.parseDouble(newNumber);
                break;
            case "^":
                result = Math.pow(Double.parseDouble(oldNumber), Double.parseDouble(newNumber));
                break;
            case "ln":
                if (Double.parseDouble(newNumber) == 0.0){
                    divByZero = true;
                }
                else {
                    result = Math.log(Double.parseDouble(newNumber));
                }
                break;

        }
        if (divByZero){
            workspace.setText("ERROR");
        }
        else {
            workspace.setText(result+"");
        }

    }

    public void clearEvent (View view) {
        workspace.setText("0");
        isNewOp = true;
    }

    public void percentEvent (View view) {
        double no = Double.parseDouble(workspace.getText().toString())/100;
        workspace.setText(no+"");
        isNewOp = true;
    }
}


