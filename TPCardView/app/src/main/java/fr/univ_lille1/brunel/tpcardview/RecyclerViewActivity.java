package fr.univ_lille1.brunel.tpcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedHashMap;

public class RecyclerViewActivity extends AppCompatActivity {

    public static final int SIMPLE_LIST = 0;
    public static final int CARDVIEW_LIST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        int type = getIntent().getIntExtra("type", -1);

        if(type != -1) {
            // Récupération du RecyclerView
            RecyclerView list = (RecyclerView) findViewById(R.id.list);
            list.setHasFixedSize(true);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
            list.setLayoutManager(mLayoutManager);

            // Création du contenu à afficher dans le RecyclerView
            // Clé = id de l'image à afficher, Valeur = nom du monument associé à afficher sous l'image
            LinkedHashMap<Integer, Integer> content = new LinkedHashMap<>();
            content.put(R.drawable.colisee, R.string.coliseum);
            content.put(R.drawable.taj_mahal, R.string.taj_mahal);
            content.put(R.drawable.tour_eiffel, R.string.eiffel_tower);
            content.put(R.drawable.big_ben, R.string.big_ben);

            if(type == SIMPLE_LIST) {
                // Création de l'adapter et affectation de celui-ci au RecyclerView
                SimpleListAdapter adapter = new SimpleListAdapter(this, content);
                list.setAdapter(adapter);
            } else {
                // Création de l'adapter et affectation de celui-ci au RecyclerView
                CardsListAdapter adapter = new CardsListAdapter(this, content);
                list.setAdapter(adapter);
            }
        } else {
            finish();
        }
    }
}
