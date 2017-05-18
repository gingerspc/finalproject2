package com.example.g.story1.story;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.g.story1.R;

public class Story2a extends AppCompatActivity {

    public TextView mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story1);
        mStory = (TextView) findViewById(R.id.story);
        final Button button1 = (Button) findViewById(R.id.button1);
        final Button button2 = (Button) findViewById(R.id.button2);

        mStory.setText("The man keeps approaching, stops in front of the register. He wears a large hoodie baggy pants. His eyes are looking at the menu, while his hands are tucked inside big pockets. It looks like he is grabbing something in his pocket. But I feel strange. It’s not a shape of wallet. He pulls out a gun and points at my face. He shouts, “Give me all your money.” ");
        button1.setText("Give him the money");
        button2.setText("Think about alternatives");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Story2a.this, Story3a.class));
                // Do something in response to button1
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Story2a.this, Story3b.class));
                // Do something in response to button2
            }
        });
    }
}
