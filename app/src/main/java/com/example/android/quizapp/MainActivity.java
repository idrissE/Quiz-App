package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // By default gets sat to 0
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Stop keyboard from appearing automatically because of the existence of EditText
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Display Score
     */
    public void displayResults(View view) {
        checkAllAnswers();
        String result;

        if (score == 4)
            result = getString(R.string.top_score_message, score);
        else if (score == 0)
            result = getString(R.string.fail_score_message);
        else
            result = getString(R.string.normal_score_message, score);
        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
        // reset score in case user clicks submit more than once
        score = 0;
    }

    /**
     * Check all answers
     */
    private void checkAllAnswers() {
        checkFirstQuestion();
        checkSecondQuestion();
        checkThirdQuestion();
        checkFourthQuestion();
    }

    /**
     * 1st quiz: Radio buttons inside a RadioGroup
     * Single answer can be selected
     * Correct answer: GoLang
     */
    private void checkFirstQuestion() {
        RadioGroup firstRadioGrp = findViewById(R.id.first_quiz);
        int selectAnswerId = firstRadioGrp.getCheckedRadioButtonId();
        if (selectAnswerId == R.id.go_answer) {
            score++;
        }
    }

    /**
     * 2nd quiz: Radio buttons inside a RadioGroup
     * Single answer can be selected
     * Correct answer: true
     */
    private void checkSecondQuestion() {
        RadioGroup SecondRadioGrp = findViewById(R.id.second_quiz);
        int selectAnswerId = SecondRadioGrp.getCheckedRadioButtonId();
        if (selectAnswerId == R.id.true_answer)
            score++;
    }

    /**
     * 3rd quiz: Answer entered in an EditText
     * Correct answer: "oreo"
     */
    private void checkThirdQuestion() {
        EditText answer_et = findViewById(R.id.third_answer);
        // remove any useless space and make sure its lowercase
        String answer = answer_et.getText().toString().trim().toLowerCase();
        if (answer.equals("oreo"))
            score++;
    }

    /**
     * 4th quiz: CheckBox answers
     * Correct answers:
     * layout_width && layout_height must be checked
     * the rest should not be checked
     */
    private void checkFourthQuestion() {
        CheckBox idCheckBox = findViewById(R.id.check_id_answer);
        CheckBox widthCheckBox = findViewById(R.id.check_width_answer);
        CheckBox heightCheckBox = findViewById(R.id.check_height_answer);
        CheckBox marginCheckBox = findViewById(R.id.check_margin_answer);

        if (widthCheckBox.isChecked() && heightCheckBox.isChecked() &&
                !idCheckBox.isChecked() && !marginCheckBox.isChecked())
            score++;
    }
}
