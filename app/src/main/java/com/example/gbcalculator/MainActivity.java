package com.example.gbcalculator;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.text.DecimalFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Values values;
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVISION = "/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        values = new Values();

        initElem();
    }

    private void initElem() {
        TextView textView1 = findViewById(R.id.textView1);

        Button button_0 = findViewById(R.id.button0);
        Button button_1 = findViewById(R.id.button1);
        Button button_2 = findViewById(R.id.button2);
        Button button_3 = findViewById(R.id.button3);
        Button button_4 = findViewById(R.id.button4);
        Button button_5 = findViewById(R.id.button5);
        Button button_6 = findViewById(R.id.button6);
        Button button_7 = findViewById(R.id.button7);
        Button button_8 = findViewById(R.id.button8);
        Button button_9 = findViewById(R.id.button9);

        Button button_point = findViewById(R.id.button_point);

        Button button_plus = findViewById(R.id.button_plus);
        Button button_minus = findViewById(R.id.button_minus);
        Button button_multiply = findViewById(R.id.button_multiply);
        Button button_division = findViewById(R.id.button_division);
        Button button_backspace = findViewById(R.id.button_backspace);
        Button button_equally = findViewById(R.id.button_equally);

        buttonClickSymbol(button_0, textView1);
        buttonClickSymbol(button_1, textView1);
        buttonClickSymbol(button_2, textView1);
        buttonClickSymbol(button_3, textView1);
        buttonClickSymbol(button_4, textView1);
        buttonClickSymbol(button_5, textView1);
        buttonClickSymbol(button_6, textView1);
        buttonClickSymbol(button_7, textView1);
        buttonClickSymbol(button_8, textView1);
        buttonClickSymbol(button_9, textView1);
        buttonClickSymbol(button_point, textView1);

        buttonClickOper(button_plus, textView1);
        buttonClickOper(button_minus, textView1);
        buttonClickOper(button_multiply, textView1);
        buttonClickOper(button_division, textView1);

        buttonClickEquals(button_equally, textView1);
        button_backspace.setOnClickListener(v -> textView1.setText(""));

    }

    private void buttonClickSymbol(Button button, TextView textView) {
        button.setOnClickListener(v -> {
            StringBuffer textViewStr = new StringBuffer();
            textViewStr.append(textView.getText()).append(button.getText());
            textView.setText(textViewStr);
        });
    }

    private void buttonClickOper(Button button, TextView textView) {
        button.setOnClickListener(v -> {
            values.setX(Double.parseDouble(textView.getText().toString()));
            values.setOper(button.getText().toString());
            textView.setText("");
        });
    }

    private void buttonClickEquals(Button button, TextView textView) {
        button.setOnClickListener(v -> {
            DecimalFormat df = new DecimalFormat("#.########");
            double result = 0;

            values.setY(Double.parseDouble(textView.getText().toString()));
            switch (values.getOper()) {
                case PLUS:
                    result = values.getX() + values.getY();
                    break;
                case MINUS:
                    result = values.getX() - values.getY();
                    break;
                case MULTIPLY:
                    result = values.getX() * values.getY();
                    break;
                case DIVISION:
                    result = values.getX() / values.getY();
                    break;
            }
            textView.setText(df.format(result));
        });
    }
}