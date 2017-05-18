package com.example.g.story1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Splash1 extends AppCompatActivity {

    public ImageView mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash1);
        mStory = (ImageView) findViewById(R.id.story);
        final Button button1 = (Button) findViewById(R.id.button1);

        mStory.setImageResource(R.drawable.logo);
        button1.setText("There are at least two sides to every story.");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Splash1.this, SignInActivity.class));
                // Do something in response to button1
            }
        });
    }
}
