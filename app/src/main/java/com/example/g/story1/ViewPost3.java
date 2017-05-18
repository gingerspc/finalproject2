package com.example.g.story1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.g.story1.Card.CardActivity;
import com.example.g.story1.models.Post;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.g.story1.QuestionActivity.support;

//public class ViewPost3 extends AppCompatActivity implements View.OnClickListener {
public class ViewPost3 extends AppCompatActivity {

    private static final String TAG = "ViewPost3";

    public static final String EXTRA_POST_KEY = "post_key";

    private DatabaseReference mPostReference;
    private DatabaseReference mPostChild;
    private DatabaseReference mCommentsReference;
    private ValueEventListener mPostListener;
    private String mPostKey;

    private TextView mAuthorView;
    private TextView mTitleView;
    private TextView mBodyView;
    private EditText mCommentField;
    private Button mCommentButton;
    private RecyclerView mCommentsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);

        mTitleView = (TextView) findViewById(R.id.story1);

        mCommentButton = (Button) findViewById(R.id.button1);
        mCommentButton.setText("I see.");
        mCommentButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(ViewPost3.this, CardActivity.class));
            }
        });

        if (support == 1 ) {
            mPostReference = FirebaseDatabase.getInstance().getReference()
                    .child("posts").child("oppose");
                    //.child("-KkD9jKYc4GXdqWb5gmj");
        }

        if (support == 0 ) {
            mPostReference = FirebaseDatabase.getInstance().getReference()
                    .child("posts").child("support");
                    //.child("-KkD9jKYc4GXdqWb5gmj");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        ValueEventListener postListener = new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {
                    Post post = childSnapshot.getValue(Post.class);
                    mTitleView.setText(post.text);
                }

                //Post post = dataSnapshot.getValue(Post.class);
                //mTitleView.setText(post.text);


            }
            public void onCancelled(DatabaseError databaseError) {

                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());

                Toast.makeText(ViewPost3.this, "Failed to load post.",
                        Toast.LENGTH_SHORT).show();

            }

        };


        mPostReference.addValueEventListener(postListener);
        // [END post_value_event_listener]

        // Keep copy of post listener so we can remove it when app stops
        mPostListener = postListener;

    }

    @Override
    public void onStop() {
        super.onStop();

        // Remove post value event listener
        if (mPostListener != null) {
            mPostReference.removeEventListener(mPostListener);
        }
    }
}
