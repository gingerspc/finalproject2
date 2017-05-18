package com.example.g.story1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.g.story1.models.Post;
import com.example.g.story1.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.example.g.story1.QuestionActivity.support;

public class PostActivity2 extends AppCompatActivity {

    private static final String TAG = "PostActivity2";
    private static final String REQUIRED = "Cannot be empty";
    public static ArrayList<String> postList = new ArrayList<String>();
    String postlist[];
    public static ArrayList<String> keyList = new ArrayList<String>();
    String keylist[];

    // [START declare_database_ref]
    private DatabaseReference mDatabase;
    // [END declare_database_ref]

    public EditText mPost;
    private Button mButton;
    public String key;
    public String side; // or make it into int instead

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mPost = (EditText) findViewById(R.id.story);
        mButton = (Button) findViewById(R.id.button1);

        mButton.setText("Type your post above to enter the pool and hit this.");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitPost();
                //cardlist();
            }
        });
    }

    /**public void cardlist() {

        String ag = mPost.getText().toString().trim();
        if (ag.length() != 0) {
            postList.add(ag);
            mPost.setText("");

        }
    }*/

    private void submitPost() {
        final String post = mPost.getText().toString();

        // text is required
        if (TextUtils.isEmpty(post)) {
            mPost.setError(REQUIRED);
            return;
        }

        // Disable button so there are no multi-posts
        setEditingEnabled(false);
        Toast.makeText(this, "Posting...", Toast.LENGTH_SHORT).show();

        // [START single_value_read]
        final String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mDatabase.child("users").child(userId).addListenerForSingleValueEvent(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        User user = dataSnapshot.getValue(User.class);

                        // [START_EXCLUDE]
                        if (user == null) {
                            // User is null, error out
                            Log.e(TAG, "User " + userId + " is unexpectedly null");
                            Toast.makeText(PostActivity2.this,
                                    "Error: could not fetch user.",
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            // Write new post
                            writeNewPost(userId, user.username, post, side);

                        }

                        // Finish this Activity, back to the stream
                        setEditingEnabled(true);
                        finish();
                        // [END_EXCLUDE]
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                        // [START_EXCLUDE]
                        setEditingEnabled(true);
                        // [END_EXCLUDE]
                    }
                });

        startActivity(new Intent(PostActivity2.this, Splash2.class));
        // [END single_value_read]
    }

    private void setEditingEnabled(boolean enabled) {
        mPost.setEnabled(enabled);
        if (enabled) {
            mButton.setVisibility(View.VISIBLE);
        } else {
            mButton.setVisibility(View.GONE);
        }
    }

    private void writeNewPost(String userId, String username, String text, String side) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously

        key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, text, side);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();

        if (support == 1 ) {
            childUpdates.put("/posts/" + "/support/" + key, postValues);
        }

        if (support == 0 ) {
            childUpdates.put("/posts/" + "/oppose/" + key, postValues);
            //side = "oppose";
        }

        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }

    /** // [START write_fan_out]
    private void writeNewPost(String userId, String username, String text) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, text);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }


    // [END write_fan_out]*/
}
