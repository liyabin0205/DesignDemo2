package com.app.designdemo2;

import android.support.design.widget.Snackbar;
import android.support.design.widget.SwipeDismissBehavior;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SwipeDismissBehavior.OnDismissListener, View.OnClickListener {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.main_text);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.main_recycler);
        List<String> list = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            list.add(String.format(Locale.CHINA, "第%03d条数据", i));
        }
        recycler.setAdapter(new MyAdapter(this, list));

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) text.getLayoutParams();
//        SwipeDismissBehavior<TextView> behavior = new SwipeDismissBehavior<>();
//        behavior.setListener(this);
//        params.setBehavior(behavior);
//        MyBehavior behavior = new MyBehavior();
//        params.setBehavior(behavior);

        findViewById(R.id.fab).setOnClickListener(this);
        findViewById(R.id.ibtn).setOnClickListener(this);
    }

    @Override
    public void onDragStateChanged(int state) {

    }

    @Override
    public void onDismiss(View view) {
        view.setVisibility(View.GONE);
        Snackbar.make(view,"删除了一个控件",Snackbar.LENGTH_LONG)
                .setAction("撤销",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        text.setVisibility(View.VISIBLE);
                        ViewCompat.animate(text).alpha(1).start();
                    }
                }).show();
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v,"点击事件",Snackbar.LENGTH_LONG).show();
    }
}
