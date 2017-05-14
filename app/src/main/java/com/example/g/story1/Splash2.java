package com.example.g.story1;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash2 extends AppCompatActivity {

    public ImageView mStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
        mStory = (ImageView) findViewById(R.id.story);
        final Button button1 = (Button) findViewById(R.id.button1);

        mStory.setImageResource(R.drawable.logo);
        button1.setText("Thank you for being part of the story.\n" +
                "\n" +
                "        Stay tuned to receive a story from another side of the story.");

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Splash2.this, ViewPost3.class));
                // Do something in response to button1
            }
        });
    }
}
