package fr.univ_lille1.brunel.tpcardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedHashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Récupération du RecyclerView
        RecyclerView cardsList = (RecyclerView) findViewById(R.id.cards_list);
        cardsList.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        cardsList.setLayoutManager(mLayoutManager);

        // Création du contenu à afficher dans le RecyclerView
        // Clé = id de l'image à afficher, Valeur = nom du monument associé à afficher sous l'image
        LinkedHashMap<Integer, Integer> content = new LinkedHashMap<>();
        content.put(R.drawable.colisee, R.string.coliseum);
        content.put(R.drawable.taj_mahal, R.string.taj_mahal);
        content.put(R.drawable.tour_eiffel, R.string.eiffel_tower);
        content.put(R.drawable.big_ben, R.string.big_ben);

        // Création de l'adapter et affectation de celui-ci au RecyclerView
        CardsListAdapter adapter = new CardsListAdapter(this, content);
        cardsList.setAdapter(adapter);
    }
}
