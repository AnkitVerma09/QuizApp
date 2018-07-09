package com.example.android.quizapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import java.lang.String;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int score = 0 ;
    public int increment(Boolean hasAns1a,Boolean hasAns1b,Boolean hasAns2a, Boolean hasAns2b, Boolean hasAns3, Boolean hasAns4, String ans5)
    {
        if ((hasAns1a)&&(hasAns1b)) {
            score = score + 1;
        }

        if ((hasAns2a)&&(hasAns2b)) {
            score = score + 1;
        }
        if (hasAns3) {
            score = score + 1;
        }
        if (hasAns4) {
            score = score + 1;
        }
        if (ans5=="Playstation") {
            score = score + 1;
        }


        return score;
    }

    public void order(View view)
    {
        int score = 0 ;
        CheckBox Ans1a = (CheckBox) findViewById(R.id.answer1a);
        boolean isAns1a= Ans1a.isChecked();
        CheckBox Ans1b = (CheckBox) findViewById(R.id.answer1a);
        boolean isAns1b= Ans1b.isChecked();
        CheckBox Ans2a = (CheckBox) findViewById(R.id.answer2a);
        boolean isAns2a= Ans2a.isChecked();
        CheckBox Ans2b= (CheckBox) findViewById(R.id.answer2b);
        boolean isAns2b= Ans2b.isChecked();
        RadioButton Ans3 = (RadioButton) findViewById(R.id.answer3);
        boolean isAns3= Ans3.isChecked();
        RadioButton Ans4 = (RadioButton) findViewById(R.id.answer4);
        boolean isAns4= Ans4.isChecked();

        EditText nameField = (EditText) findViewById(R.id.name_field);
        Editable nameEditable = nameField.getText();
        String isAns5 = nameEditable.toString();


        int finalScore=increment(isAns1a,isAns1b,isAns2a,isAns2b,isAns3,isAns4,isAns5);
        Context context = getApplicationContext();
        CharSequence text = "You have "+finalScore+" out of 5 questions correct!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
