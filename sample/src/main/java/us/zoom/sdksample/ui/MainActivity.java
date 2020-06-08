package us.zoom.sdksample.ui;

import android.app.Activity;
import us.zoom.sdksample.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button btnLogin;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        textView = (TextView) findViewById(R.id.programmr);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginSuccess();
            }
        });
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.movetop);
        textView.startAnimation(myAnim);

    }

    private void loginSuccess() {
        // TODO: go to home screen
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
