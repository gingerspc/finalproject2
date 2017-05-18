package com.example.g.story1.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.g.story1.QuestionActivity;
import com.example.g.story1.R;

public class End1 extends AppCompatActivity {

    public TextView mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end1);
        mStory = (TextView) findViewById(R.id.story);
        final Button button1 = (Button) findViewById(R.id.button1);

        mStory.setText("You shot the man. The man is dead. His gun is fake. ");
        button1.setText("What really happened");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(End1.this, QuestionActivity.class));
                // Do something in response to button1
            }
        });
    }
}
