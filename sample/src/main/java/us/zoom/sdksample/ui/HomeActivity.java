package us.zoom.sdksample.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.widget.LinearLayout;
import android.widget.TextView;


import us.zoom.sdksample.R;
import us.zoom.sdksample.quiz.QuizActivity;

import static java.security.AccessController.getContext;

public class HomeActivity extends Activity {
    public int counter=60;
    Button button,signup1,signup2,signup3;
    TextView classTimer,timerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        classTimer = (TextView)findViewById(R.id.timer) ;
        timerText =(TextView)findViewById(R.id.timerMessage) ;
        signup1 = (Button)findViewById(R.id.signup1);
        signup2 = (Button)findViewById(R.id.signup2);
        signup3 = (Button)findViewById(R.id.signup3);
        //class booking timer

        new CountDownTimer(30000, 1000){
            public void onTick(long millisUntilFinished){
                String timestrip = String.format("%02d:%02d",counter/60,counter%60);
                classTimer.setText(timestrip);
                counter--;
            }
            public  void onFinish(){
                classTimer.setText("");
                counter=300;
                timerText.setText("Sign up ends in ");
                signup1.setVisibility(View.VISIBLE);
                signup2.setVisibility(View.VISIBLE);
                signup3.setVisibility(View.VISIBLE);

                startSignupCountDown();
            }
        }.start();
    }

    public void startSignupCountDown(){
        new CountDownTimer(3000000, 1000){
            public void onTick(long millisUntilFinished){
                String timestrip = String.format("%02d:%02d",counter/60,counter%60);
                classTimer.setText(timestrip);
                counter--;
            }
            public  void onFinish(){
                classTimer.setText("");
                startSignupCountDown();
            }
        }.start();
    }

    public void onClickSignUp(View view) {
        // go to home  live class screen
        Intent intent = new Intent(this, InitAuthSDKActivity.class);
        String classTag = (String)view.getTag();
        Resources res = getResources();
        int iamgealtid = res.getIdentifier(classTag+"_assigning","id",getPackageName());
        Log.d("info","iamgealtid"+iamgealtid);
        LinearLayout imgalt1 = (LinearLayout)findViewById(iamgealtid);
        imgalt1.setVisibility(View.VISIBLE);
        ImageView img1 = (ImageView)findViewById(R.id.liveclass1_image1);
        img1.setVisibility(View.GONE);

        //startActivity(intent);
    }


    public void onClickQuiz(View view) {
        // go to quiz  screen
        String imageTag = (String)view.getTag();


        Log.d("INFO222222222",imageTag);

        Intent intent = new Intent(this, us.zoom.sdksample.quiz2.FormActivity.class);
        intent.putExtra("mImageTag", imageTag);
        startActivity(intent);
    }
}
