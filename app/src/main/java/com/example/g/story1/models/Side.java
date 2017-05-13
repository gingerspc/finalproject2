package com.example.g.story1.models;

/**
 * Created by g on 5/13/17.
 */

public class Side {

    public String uid;
    public String image;

    public Side() {
        // Default constructor required for calls to DataSnapshot.getValue(Comment.class)
    }

    public Side(String uid, String image) {
        this.uid = uid;
        this.image = image;
    }
}
