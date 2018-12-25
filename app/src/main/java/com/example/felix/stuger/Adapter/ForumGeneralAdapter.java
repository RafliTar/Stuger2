package com.example.felix.stuger.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.felix.stuger.ForumGeneral;
import com.example.felix.stuger.Model.ForumQuestion;
import com.example.felix.stuger.R;

import java.util.ArrayList;

public class ForumGeneralAdapter extends RecyclerView.Adapter<ForumGeneralAdapter.ViewHolder> {

    Context context;
    ArrayList<ForumQuestion> listForumQuestion;

    public ForumGeneralAdapter(Context context, ArrayList<ForumQuestion> listForumQuestion){
        this.context = context;
        this.listForumQuestion = listForumQuestion;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_forum_question, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ForumGeneralAdapter.ViewHolder viewHolder, int i) {
        viewHolder.bind(listForumQuestion.get(i));
    }

    @Override
    public int getItemCount() {
        return listForumQuestion.size();
    }

    public void setData(ArrayList<ForumQuestion> listForumQuestion){
        this.listForumQuestion = listForumQuestion;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvForumThread, tvForumDescription;
        Button btnSubmit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


        }
    }
}
