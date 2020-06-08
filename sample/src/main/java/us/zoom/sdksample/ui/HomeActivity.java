package us.zoom.sdksample.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import us.zoom.sdksample.R;
import us.zoom.sdksample.quiz.QuizActivity;

public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
    }

    public void onClickSignUp(View view) {
        // go to home  live class screen
        Intent intent = new Intent(this, InitAuthSDKActivity.class);
        startActivity(intent);
    }


    public void onClickQuiz(View view) {
        // go to quiz  screen
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }
}
