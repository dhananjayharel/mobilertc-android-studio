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
import android.text.method.LinkMovementMethod;

import us.zoom.sdksample.R;
import us.zoom.sdksample.quiz.QuizActivity;

import static java.security.AccessController.getContext;

public class HomeActivity extends Activity {
    public int counter=35;
    Button button,signup1,signup2,signup3;
    TextView classTimer,timerText,liveclass1_link,liveclass2_link,liveclass3_link;
    LinearLayout laodingClasses,Liveclasseslist,Bookyourclassmessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);

        //loading classes
        laodingClasses = (LinearLayout)findViewById(R.id.loadingclassesmessage);
        Liveclasseslist = (LinearLayout)findViewById(R.id.classeslist);
        Bookyourclassmessage = (LinearLayout)findViewById(R.id.bookyourclassmessage);
        final Handler handler1 = new Handler();
        handler1.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                laodingClasses.setVisibility(View.GONE);
                Liveclasseslist.setVisibility(View.VISIBLE);
                Bookyourclassmessage.setVisibility(View.VISIBLE);

            }
        }, 3000);





        classTimer = (TextView)findViewById(R.id.timer) ;
        timerText =(TextView)findViewById(R.id.timerMessage) ;
        signup1 = (Button)findViewById(R.id.liveclass1_signup);
        signup2 = (Button)findViewById(R.id.liveclass2_signup);
        signup3 = (Button)findViewById(R.id.liveclass3_signup);
        //class booking timer
        liveclass1_link = (TextView) findViewById(R.id.liveclass1_link);
        liveclass2_link = (TextView) findViewById(R.id.liveclass2_link);
        liveclass3_link = (TextView) findViewById(R.id.liveclass3_link);

        liveclass1_link.setMovementMethod(LinkMovementMethod.getInstance());
        liveclass2_link.setMovementMethod(LinkMovementMethod.getInstance());
        liveclass3_link.setMovementMethod(LinkMovementMethod.getInstance());

        new CountDownTimer(35000, 1000){
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
        final Intent intent = new Intent(this, InitAuthSDKActivity.class);

        String classTag = (String)view.getTag();
        intent.putExtra("classTag",classTag);
        Resources res = getResources();
        int iamgealtid = res.getIdentifier(classTag+"_assigning","id",getPackageName());
        int classImage = res.getIdentifier(classTag+"_image1","id",getPackageName());
        int signupbutton = res.getIdentifier(classTag+"_signup","id",getPackageName());


        Log.d("info","iamgealtid"+iamgealtid);
        LinearLayout imgalt1 = (LinearLayout)findViewById(iamgealtid);
        imgalt1.setVisibility(View.VISIBLE);
        ImageView img1 = (ImageView)findViewById(classImage);
        Button signup = (Button)findViewById(signupbutton);

        img1.setVisibility(View.GONE);
        signup.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                startActivity(intent);

            }
        }, 5000);

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
