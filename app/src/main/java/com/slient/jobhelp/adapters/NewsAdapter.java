package com.slient.jobhelp.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.slient.jobhelp.R;
import com.slient.jobhelp.callbacks.NewsCallback;
import com.slient.jobhelp.models.data.ItemNews;
import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

/**
 * Created by silent on 5/7/2018.
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private Context context;
    private List<ItemNews> itemNewsList;

    public NewsAdapter(Context context){
        this.context = context;
        this.itemNewsList = Collections.emptyList();
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        ItemNews itemNews = itemNewsList.get(position);
        holder.bindData(itemNews);
    }

    @Override
    public int getItemCount() {
         return (itemNewsList == null) ? 0 : itemNewsList.size();
    }

    public void swapList(List<ItemNews> itemNewsList){
        this.itemNewsList = itemNewsList;
        notifyDataSetChanged();
    }

    class NewsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView titleNewsText;
        public TextView dateTimeText;
        public ImageView srcImageView;

        public NewsHolder(View itemView) {
            super(itemView);
            titleNewsText = itemView.findViewById(R.id.titleNewsText);
            dateTimeText = itemView.findViewById(R.id.dateTimeText);
            srcImageView = itemView.findViewById(R.id.srcImageView);
            itemView.setOnClickListener(this);
        }

        public void bindData(ItemNews itemNews){
            Log.d("TRUNG", itemNews.srcImage);
            Picasso.get().load(itemNews.srcImage).into(srcImageView);
            titleNewsText.setText(itemNews.title);
            dateTimeText.setText(itemNews.dateTime);
        }

        @Override
        public void onClick(View v) {
            NewsCallback newsCallback = (NewsCallback) context;
            newsCallback.callback(itemNewsList.get(getAdapterPosition()).url);
        }
    }
}
