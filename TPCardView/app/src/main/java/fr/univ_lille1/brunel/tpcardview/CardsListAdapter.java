package fr.univ_lille1.brunel.tpcardview;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by thibautbrunel on 29/09/2016.
 */
public class CardsListAdapter extends RecyclerView.Adapter<CardsListAdapter.MyViewHolder> {

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;

        public MyViewHolder(CardView cardView) {
            super(cardView);
            this.cardView = cardView;
        }
    }

    // Le context de l'application
    private Context ctx;
    // La liste des données à afficher dans les CardViews
    private ArrayList mData;

    public CardsListAdapter(Context context, LinkedHashMap<Integer, Integer> content) {
        this.ctx = context;
        this.mData = new ArrayList();
        this.mData.addAll(content.entrySet());
    }

    @Override
    public CardsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cardView = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        MyViewHolder vh = new MyViewHolder(cardView);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // Récupération des ressources pour pouvoir récupérer les drawables et strings à afficher
        /*final Resources resources = this.ctx.getResources();
        // On récupère l'élément à afficher à la position en paramètre dans notre ArrayList mData
        final Map.Entry<Integer, Integer> item = (Map.Entry<Integer, Integer>) this.mData.get(position);

        // On récupère l'ImageView et le TextView se trouvant dans la CardView afin de modifier leur contenu
        ImageView thumbnailImageView = (ImageView) holder.cardView.findViewById(R.id.preview_image_view);
        TextView descriptionTextView = (TextView) holder.cardView.findViewById(R.id.description);

        // On récupère les données à mettre dans ces vues
        Integer thumbnail = item.getKey();
        final String description = resources.getString(item.getValue());

        // On ajoute les données aux vues
        thumbnailImageView.setImageDrawable(resources.getDrawable(thumbnail));
        descriptionTextView.setText(description);*/

        // Gestion du clic sur la CardView
        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(ctx)
                        .setCancelable(false)
                        .setTitle(resources.getString(R.string.action))
                        .setMessage(resources.getString(R.string.action_choice))
                        .setPositiveButton(resources.getString(R.string.show_picture), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Intent intent = new Intent(ctx, PhotoActivity.class);
                                intent.putExtra("photo", item.getKey());
                                ctx.startActivity(intent);
                            }
                        })
                        .setNegativeButton(String.format(resources.getString(R.string.search_on_the_internet), description), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                
                            }
                        })
                        .setNeutralButton(resources.getString(R.string.cancel), null);

                alert.show();
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
