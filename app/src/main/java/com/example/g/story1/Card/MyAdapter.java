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

    //public ArrayList<String> list2 = new ArrayList<String>();
    private String[] date = mPost.;



    /**private String[] news = {"I hugged you", "I pet you", "I kissed you", "I miao you"};

    private String[] detail = {"This is a sleepy kitter that will not run.", "Happy kitty, sleep miaomi. This kitten is not as fluffy as the 1st one.",
    "Lets join the fluffy pack and conquer the world!!!", "Check it out! This kitter is so cute."};

    private int[] images = {R.drawable.hello, R.drawable.hello, R.drawable.hello,
            R.drawable.hello};*/

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        //public ImageView itemImage;
        public TextView itemDate;
        //public TextView itemNews;
        public TextView itemDetail;


        public ViewHolder(View itemView) {
            super(itemView);
            //itemImage = (ImageView)itemView.findViewById(R.id.item_image);
            itemDate = (TextView)itemView.findViewById(R.id.item_date);
            //itemNews = (TextView)itemView.findViewById(R.id.item_news);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {

                    //show details
                    //Intent intent = new Intent();

                    //snackbar will not be used
                    /**int position = getAdapterPosition() + 1;

                    Snackbar.make(v, "You just pet cat " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();*/

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


        viewHolder.itemDate.setText();
        //viewHolder.itemNews.setText(news[i]);
        //viewHolder.itemImage.setImageResource(images[i]);
    }

    @Override
    public int getItemCount() {
        return date.length;
    }
}