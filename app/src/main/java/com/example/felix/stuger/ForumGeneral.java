package com.example.felix.stuger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import com.example.felix.stuger.Model.ForumQuestion;

import java.util.ArrayList;

public class ForumGeneral extends AppCompatActivity {

    Toolbar toolbar;

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.toolbar_menu, menu);
//        return true;
//    }

    ArrayList<ForumQuestion> listForumQuestion;
    RecyclerView rvForumQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_general);

        toolbar = findViewById(R.id.forum_general_toolbar);
        //setSupportActionBar(toolbar);

        listForumQuestion = new ArrayList<>();

        rvForumQuestion = findViewById(R.id.rv_forum_question);

    }
}
