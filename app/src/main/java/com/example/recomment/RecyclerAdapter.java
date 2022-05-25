package com.example.recomment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>{

    private Context c;
    private List<Content> contentList;

    public RecyclerAdapter(Context c, List<Content> contentList) {
        this.c = c;
        this.contentList = contentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.main_contents, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.thumbnail.setText("" + contentList.get(position).getThumbnail());
        holder.title.setText(contentList.get(position).getTitle());
        holder.content.setText("" + contentList.get(position).getContent());

    }

    @Override
    public int getItemCount() {
        return contentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView thumbnail;
        TextView title;
        TextView content;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = (TextView)itemView.findViewById(R.id.thumbnail_id);
            title = (TextView)itemView.findViewById(R.id.title_id);
            content = (TextView)itemView.findViewById(R.id.content_id);

        }
    }
}
