package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private double storedValue;
    private char curOperator;
    private EditText text;
    boolean isNumber = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201632007 김희수");

    }

    public void onClick(View view) {
        EditText eText = (EditText) findViewById(R.id.number);
        String current = eText.getText().toString();

        switch (view.getId()) {
            case R.id.n0:
                isNumber = true;
                eText.setText(current + "0");
                break;
            case R.id.n1:
                isNumber = true;
                eText.setText(current + "1");
                break;
            case R.id.n2:
                isNumber = true;
                eText.setText(current + "2");
                break;
            case R.id.n3:
                isNumber = true;
                eText.setText(current + "3");
                break;
            case R.id.n4:
                isNumber = true;
                eText.setText(current + "4");
                break;
            case R.id.n5:
                isNumber = true;
                eText.setText(current + "5");
                break;
            case R.id.n6:
                isNumber = true;
                eText.setText(current + "6");
                break;
            case R.id.n7:
                isNumber = true;
                eText.setText(current + "7");
                break;
            case R.id.n8:
                isNumber = true;
                eText.setText(current + "8");
                break;
            case R.id.n9:
                isNumber = true;
                eText.setText(current + "9");
                break;
            case R.id.ndot:
                isNumber = true;
                eText.setText(current + ".");
                break;

            case R.id.plus:
                if (current.equals("")||!isNumber) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    isNumber = false;
                    eText.setText(current + "+");
                }
                break;

            case R.id.sub:
                if (current.equals("")||!isNumber) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    isNumber = false;
                    eText.setText(current + "-");
                }
                break;

            case R.id.mul:
                if (current.equals("")||!isNumber) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    isNumber = false;
                    eText.setText(current + "×");
                }
                break;

            case R.id.div:
                if (current.equals("")||!isNumber) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    isNumber = false;
                    eText.setText(current + "÷");
                }
                break;

            case R.id.clear:
                isNumber = false;
                eText.setText("");
                break;

            case R.id.ok:
                if (current.equals("")||!isNumber) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    isNumber = false;
                    eText.setText(resultPrint(organize(current)));
                }

        }
    }


    public String[] organize(String s) {

        s = s.replace("+", " + ");
        s = s.replace("-", " - ");
        s = s.replace("÷", " / ");
        s = s.replace("×", " * ");
        s = s.replace("  ", " ");
        String[] str = s.split(" ");

        ArrayList<String> sb = new ArrayList<>();
        Stack<String> stack = new Stack<>();



        for (int i = 0; i < str.length; i++) {
            String now = str[i];

            switch (now){
                case "+":
                case "-":
                case "*":
                case "/":
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(now)) {
                        sb.add(stack.pop());
                    }
                    stack.push(now);
                    break;
                default:
                    sb.add(now);
            }
        }

        while (!stack.isEmpty()) {
            sb.add(stack.pop());
        }

        String[] result = new String[sb.size()];

        for(int i = 0; i < sb.size(); i++) {
            result[i]=sb.get(i);
        }

        return result;
    }

    // 사칙연산
    public int priority(String operator){
        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        } else if (operator.equals("*") || operator.equals("/")) {
            return 2;
        }
        return -1;
    }

    // 후위 계산 메소드
    public String resultPrint(String[] str) {

        Stack<Double> stack = new Stack<>();

        for (String x : str) {

            if (!x.equals("+")&&!x.equals("-")&&!x.equals("*")&&!x.equals("/")) {
                stack.push(Double.parseDouble(x));
            }else {

                double a = stack.pop();
                double b = stack.pop();

                switch (x) {
                    case "+":
                        stack.push(b+a);
                        break;
                    case "-":
                        stack.push(b-a);
                        break;
                    case "*":
                        stack.push(b*a);
                        break;
                    case "/":
                        stack.push(b/a);
                        break;
                }
            }
        }

        double d = Math.round(stack.pop()*1000000000)/1000000000.0;

        if(Math.ceil(d) == Math.floor(d)) return Integer.toString((int)d);
        else return Double.toString(d);
    }


}

