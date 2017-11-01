package com.example.android.news.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.news.Model.RSSObject;
import com.example.android.news.R;

/**
 * Created by GMachine on 31.10.2017.
 */

class FeedViewBolder extends RecyclerView.ViewHolder{

    public TextView txtTitle, txtPubDate, txtContent;

    public FeedViewBolder(View itemView) {
        super(itemView);

        txtTitle = (TextView) itemView.findViewById(R.id.txtTitle);
        txtPubDate = (TextView) itemView.findViewById(R.id.txtPubDate);
        txtContent = (TextView) itemView.findViewById(R.id.txtContent);
    }

}

public class FeedAdapter extends RecyclerView.Adapter<FeedViewBolder> {

    private RSSObject rssObject;
    private Context mContext;
    private LayoutInflater inflater;
    public FeedAdapter(RSSObject rssObject, Context mContext) {
        this.rssObject = rssObject;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public FeedViewBolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(R.layout.row,parent,false);
        return new FeedViewBolder(itemView);
    }

    @Override
    public void onBindViewHolder(FeedViewBolder holder, int position) {
        holder.txtTitle.setText(rssObject.getItems().get(position).getTitle());
        holder.txtPubDate.setText(rssObject.getItems().get(position).getPubDate());
        holder.txtContent.setText(rssObject.getItems().get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return rssObject.items.size();
    }
}
