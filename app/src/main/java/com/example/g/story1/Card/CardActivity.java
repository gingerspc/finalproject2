package com.example.g.story1.Card;

        import android.os.Bundle;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Toast;

        import com.example.g.story1.PostActivity2;
        import com.example.g.story1.R;
        import com.example.g.story1.models.Post;
        import com.example.g.story1.models.User;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

public class CardActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    private static final String TAG = "CardActivity";
    private DatabaseReference mDatabase;
    private FirebaseUser mUser;
    private FirebaseAuth mAuth;
    public String userId;
    public static ArrayList<String> myPostList = new ArrayList<String>();
    String myPostlist[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cards_list);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new MyAdapter();
        recyclerView.setAdapter(adapter);

        //userId = FirebaseAuth.getInstance().getCurrentUser().getUid();


        //mUser = mAuth.getCurrentUser();
        //mDatabase = FirebaseDatabase.getInstance().getReference()
                //.child("users-posts").child(mUser.getUid().toString());

        userId = FirebaseAuth.getInstance().getCurrentUser().getUid().toString();

        mDatabase = FirebaseDatabase.getInstance().getReference()
                .child("users-posts").child(userId);

        ValueEventListener postListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        // Get user value
                        //User user = dataSnapshot.getValue(User.class);

                        for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                            Post post = childSnapshot.getValue(Post.class);


                            String ag = post.text.toString().trim();
                            if (ag.length() != 0) {
                                myPostList.add(ag);

                            }


                            finish();

                            // [START_EXCLUDE]
                            /**if (user == null) {
                             // User is null, error out
                             Log.e(TAG, "User " + userId + " is unexpectedly null");
                             Toast.makeText(PostActivity2.this,
                             "Error: could not fetch user.",
                             Toast.LENGTH_SHORT).show();
                             } else {
                             // Write new post
                             numK();
                             }*/

                        }
                    }

                    public void onCancelled(DatabaseError databaseError) {
                        Log.w(TAG, "getUser:onCancelled", databaseError.toException());
                    }
                };

    }

    /**@Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_settings) {

            //add card
            return true;

        }

        return super.onOptionsItemSelected(item);
    }*/

}

