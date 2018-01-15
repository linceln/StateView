package com.xyz.lince;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.xyz.state.IState;
import com.xyz.state.S;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements IState {

    private S s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.tv);

        s = S.init(tv, new DefaultStateLayout(), this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int i = random.nextInt(4);
                switch (i) {
                    case 0:
                        s.empty();
                        break;
                    case 1:
                        s.load();
                        break;
                    case 2:
                        s.retry();
                        break;
                    case 3:
                        s.content();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 100, 0, "Fragment");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == 100){
            startActivity(new Intent(this, SecondActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onEmpty(View empty) {
        empty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onRetry(View retry) {
        retry.findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Snackbar make = Snackbar.make(v, v.getId() + "", Snackbar.LENGTH_SHORT);
                make.setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        make.dismiss();
                    }
                }).show();
            }
        });
    }

    @Override
    public void onLoad(View load) {

    }
}
