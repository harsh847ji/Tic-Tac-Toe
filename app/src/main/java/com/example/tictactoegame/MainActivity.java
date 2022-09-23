package com.example.tictactoegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimatedImageDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button11;
    TextView textView;
    String b1,b2,b3,b4,b5,b6,b7,b8,b9;
    ConstraintLayout background;
    int count=0;
    int i=0;
    boolean winner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //called a method to initialize the id fo button
        init();
        background.setBackgroundColor(getResources().getColor(R.color.def));
        button11.setTranslationX(-2000f);
        textView.setText("X's Turn");




    }

    public void init(){
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button11 = findViewById(R.id.button11);
        textView = findViewById(R.id.textView);
        background = findViewById(R.id.background);

    }

    public void click(View view){
        Button current = (Button) view;
        if (current.getText().toString().equals("")){
            count++;

            if (i==0&& !winner){
                current.setText("X");
                i=1;
                textView.setText("O's Turn");
            }
            else if(i == 1 && !winner){
                current.setText("O");
                textView.setText("X's Turn");
                i = 0;
            }
            if (count>=5) {
                b1 = button1.getText().toString();
                b2 = button2.getText().toString();
                b3 = button3.getText().toString();
                b4 = button4.getText().toString();
                b5 = button5.getText().toString();
                b6 = button6.getText().toString();
                b7 = button7.getText().toString();
                b8 = button8.getText().toString();
                b9 = button9.getText().toString();

            //Cpndition
            if (b1.equals(b2) && b2.equals(b3) && !b1.equals("")&& !winner) {
                textView.setText("Winner is "+b1);
                winner = true;
                background.setBackgroundColor(getResources().getColor(R.color.back));
                restart();
            } else if (b4.equals(b5) && b5.equals(b6) && !b4.equals("")&& !winner) {
                textView.setText("Winner is "+b4);
                winner = true;
                background.setBackgroundColor(getResources().getColor(R.color.back));
                restart();
            } else if (b7.equals(b8) && b8.equals(b9) && !b7.equals("")&& !winner) {
                textView.setText("Winner is "+b7);
                background.setBackgroundColor(getResources().getColor(R.color.back));
                winner = true;
                restart();
            } else if (b1.equals(b4) && b4.equals(b7) && !b1.equals("")&& !winner) {
                textView.setText("Winner is "+b1);
                background.setBackgroundColor(getResources().getColor(R.color.back));
                winner = true;
                restart();
            } else if (b2.equals(b5) && b5.equals(b8) && !b2.equals("")&& !winner) {
                textView.setText("Winner is "+b2);
                background.setBackgroundColor(getResources().getColor(R.color.back));
                winner = true;
                restart();
            } else if (b3.equals(b6) && b6.equals(b9) && !b3.equals("")&& !winner) {
                textView.setText("Winner is "+b3);
                background.setBackgroundColor(getResources().getColor(R.color.back));
                winner = true;
                restart();
            } else if (b1.equals(b5) && b5.equals(b9) && !b1.equals("")&& !winner) {
                textView.setText("Winner is "+b1);
                background.setBackgroundColor(getResources().getColor(R.color.back));
                winner = true;
                restart();
            } else if (b3.equals(b5) && b5.equals(b7) && !b3.equals("")&& !winner) {
                textView.setText("Winner is "+b3);
                winner = true;
                background.setBackgroundColor(getResources().getColor(R.color.back));
                restart();
            }
            if (count >= 9 && !winner){
                textView.setText("It's a Tie");
                background.setBackgroundColor(getResources().getColor(R.color.tie));
                restart();
            }

        }
        }



    }
    public void restart(){
        button11.animate().translationXBy(2000f).setDuration(100);
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button1.setText("");
                button2.setText("");
                button3.setText("");
                button4.setText("");
                button5.setText("");
                button6.setText("");
                button7.setText("");
                button8.setText("");
                button9.setText("");
                button11.setTranslationX(-2000f);
                i = 0;
                count = 0;
                textView.setText("X's Turn");
                winner=false;
                background.setBackgroundColor(getResources().getColor(R.color.def));
            }
        });
    }

}