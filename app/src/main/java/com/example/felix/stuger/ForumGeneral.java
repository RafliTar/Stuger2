package com.example.felix.stuger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toolbar;

import com.example.felix.stuger.Adapter.ForumGeneralAdapter;
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

        //toolbar = findViewById(R.id.forum_general_toolbar);
        //setSupportActionBar(toolbar);

        listForumQuestion = new ArrayList<>();

        //testing model and adapter
        ForumQuestion Test1 = new ForumQuestion();
        Test1.setForumThread("Nama1");
        Test1.setForumDescription("I like apple");

        ForumQuestion Test2 = new ForumQuestion();
        Test2.setForumThread("Nama2");
        Test2.setForumDescription("I like orange");

        ForumQuestion Test3 = new ForumQuestion();
        Test3.setForumThread("Nama3");
        Test3.setForumDescription("I like sleep");

        ForumQuestion Test4 = new ForumQuestion();
        Test4.setForumThread("Nama4");
        Test4.setForumDescription("I like trains");

        listForumQuestion.add(Test1);
        listForumQuestion.add(Test2);
        listForumQuestion.add(Test3);
        listForumQuestion.add(Test4);

        rvForumQuestion = findViewById(R.id.rv_forum_question);
        rvForumQuestion.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvForumQuestion.getContext(), DividerItemDecoration.VERTICAL);
        rvForumQuestion.addItemDecoration(dividerItemDecoration);

        BoundaryItemDecoration itemDecoration = new BoundaryItemDecoration(this, R.color.colorBlack, 2);
        rvForumQuestion.addItemDecoration(itemDecoration);

        final ForumGeneralAdapter forumGeneralAdapter = new ForumGeneralAdapter(this, listForumQuestion);
        rvForumQuestion.setAdapter(forumGeneralAdapter);

    }
}
