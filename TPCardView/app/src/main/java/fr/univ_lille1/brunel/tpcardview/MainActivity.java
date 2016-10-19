package fr.univ_lille1.brunel.tpcardview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button simpleRecyclerViewButton = (Button) findViewById(R.id.simplelistview_button);
        Button cardViewRecyclerViewButton = (Button) findViewById(R.id.cardlistview_button);

        final Intent i = new Intent(MainActivity.this, RecyclerViewActivity.class);

        simpleRecyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("type", RecyclerViewActivity.SIMPLE_LIST);
                startActivity(i);
            }
        });

        cardViewRecyclerViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("type", RecyclerViewActivity.CARDVIEW_LIST);
                startActivity(i);
            }
        });
    }
}
