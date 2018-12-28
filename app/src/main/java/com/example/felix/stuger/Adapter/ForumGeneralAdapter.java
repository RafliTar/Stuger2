package com.example.felix.stuger.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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

        viewHolder.etSubmitAnswer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                switch (event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_UP:
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                return false;
            }
        });
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
        EditText etSubmitAnswer;
        Button btnSubmit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvForumThread = itemView.findViewById(R.id.tv_forum_thread);
            tvForumDescription = itemView.findViewById(R.id.tv_forum_description);
            btnSubmit = itemView.findViewById(R.id.btn_submit_answer);
            etSubmitAnswer = itemView.findViewById(R.id.et_submit_answer);
        }

        public void bind(ForumQuestion forumQuestion) {
            tvForumThread.setText(forumQuestion.getForumThread());
            tvForumDescription.setText(forumQuestion.getForumDescription());
        }
    }
}
