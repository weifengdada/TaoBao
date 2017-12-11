package com.example.taobao;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.splash_image)
    ImageView splashImage;
    @BindView(R.id.splash_text)
    TextView splashText;
    private int time=5;
    Handler handler=new Handler(){
      @Override
      public void handleMessage(Message msg) {
          super.handleMessage(msg);
          if(msg.what==0){
                if(time>0){
                    time--;
                    splashText.setText(time+"秒后跳转");
                    handler.sendEmptyMessageDelayed(0,1000);
                }else{
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }

          }

      }

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        handler.sendEmptyMessageDelayed(0,1000);
        splashText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       handler.removeCallbacksAndMessages(null);
    }
}
