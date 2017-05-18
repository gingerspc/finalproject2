package com.example.g.story1.Card;

/**
 * Created by g on 5/1/17.
 */

        import android.content.Intent;
        import android.support.design.widget.Snackbar;
        import android.support.v7.widget.RecyclerView;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.TextView;
        import com.example.g.story1.PostActivity2;

        import com.example.g.story1.R;
        import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    //private String[] date = {};


    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        //public ImageView itemImage;
        public TextView PostText;
        //public TextView itemNews;
        public TextView itemDetail;


        public ViewHolder(View itemView) {
            super(itemView);

            //itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            PostText = (TextView)itemView.findViewById(R.id.post_text);
            //itemNews = (TextView)itemView.findViewById(R.id.item_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                }
            });
        }
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cards_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        //List<T> list = new ArrayList<T>();
        //T [] text = list.toArray(new T [list.size()]);


        viewHolder.PostText.setText(CardActivity.myPostList.get(i));
        //viewHolder.itemNews.setText(news[i]);
        //viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return PostActivity2.postList.size();
    }
}