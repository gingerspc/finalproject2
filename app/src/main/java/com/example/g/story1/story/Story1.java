package com.example.g.story1.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.g.story1.R;

public class Story1 extends AppCompatActivity {

    public TextView mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
        mStory = (TextView) findViewById(R.id.story);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);

        mStory.setText("It’s 8:30 pm again. I sit on the register, scrolling my phone. No one is in the store. My manager and co-workers are chatting some nonsense. I look at them, bored. I look down, keep scrolling my phone. A black man walks into the store. He is nearly twice of my size.");
        button1.setText("Smile and say, “Welcome to Jimmy John’s.”");
        button2.setText("Grab my co-worker to help him. I step aside.");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Story1.this, Story2a.class));
                        // Do something in response to button1
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Story1.this, Story2b.class));
                        // Do something in response to button2
            }
        });
    }
}
