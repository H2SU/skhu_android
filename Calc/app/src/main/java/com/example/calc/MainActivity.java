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

public class MainActivity extends AppCompatActivity {
    private double storedValue;
    private char curOperator;
    private EditText text;
    private Log log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("201632007 김희수");
        log.v("test","test");
    }

    public void onClick(View view) {
        log.v("test","test");
        EditText eText = (EditText) findViewById(R.id.number);
        String current = eText.getText().toString();;
        switch (view.getId()) {
            case R.id.n0:
                log.v("test","test");
                eText.setText(current + "0");
                break;
            case R.id.n1:
                eText.setText(current + "1");
                break;
            case R.id.n2:
                eText.setText(current + "2");
                break;
            case R.id.n3:
                eText.setText(current + "3");
                break;
            case R.id.n4:
                eText.setText(current + "4");
                break;
            case R.id.n5:
                eText.setText(current + "5");
                break;
            case R.id.n6:
                eText.setText(current + "6");
                break;
            case R.id.n7:
                eText.setText(current + "7");
                break;
            case R.id.n8:
                eText.setText(current + "8");
                break;
            case R.id.n9:
                eText.setText(current + "9");
                break;
            case R.id.ndot:
                eText.setText(current + ".");
                break;
            case R.id.plus:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '+';
                    eText.setText("");
                    break;
                }
            case R.id.sub:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '-';
                    eText.setText("");
                    break;
                }
            case R.id.mul:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '*';
                    eText.setText("");
                    break;
                }
            case R.id.div:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    storedValue = Double.parseDouble(current);
                    curOperator = '/';
                    eText.setText("");
                    break;
                }

            case R.id.clear:
                eText.setText("");
                storedValue = 0.0;
                break;

            case R.id.ok:
                if (current.equals("")) {
                    Toast.makeText(getApplicationContext(), "숫자를 먼저 입력하세요", Toast.LENGTH_SHORT).show();
                } else {
                    double result = 0;
                    double thisValue = Double.parseDouble(eText.getText().toString());
                    switch (curOperator) {
                        case '+':
                            result = storedValue + thisValue;
                            break;
                        case '-':
                            result = storedValue - thisValue;
                            break;
                        case '*':
                            result = storedValue * thisValue;
                            break;
                        case '/':
                            result = storedValue / thisValue;
                            break;
                    }
                    eText.setText("" + result);
                    storedValue = 0.0;
                    break;
                }
        }
    }
}
