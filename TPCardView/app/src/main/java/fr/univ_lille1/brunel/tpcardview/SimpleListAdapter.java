package fr.univ_lille1.brunel.tpcardview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by thibautbrunel on 19/10/2016.
 */

public class SimpleListAdapter extends RecyclerView.Adapter<SimpleListAdapter.MyViewHolder> {
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public RelativeLayout layout;

        public MyViewHolder(RelativeLayout layout) {
            super(layout);
            this.layout = layout;
        }
    }

    // Le context de l'application
    private Context ctx;
    // La liste des données à afficher dans les CardViews
    private ArrayList mData;

    public SimpleListAdapter(Context context, LinkedHashMap<Integer, Integer> content) {
        this.ctx = context;
        this.mData = new ArrayList();
        this.mData.addAll(content.entrySet());
    }

    @Override
    public SimpleListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_simple, parent, false);

        SimpleListAdapter.MyViewHolder vh = new SimpleListAdapter.MyViewHolder(layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(SimpleListAdapter.MyViewHolder holder, int position) {
        // Récupération des ressources pour pouvoir récupérer les drawables et strings à afficher
        final Resources resources = this.ctx.getResources();
        // On récupère l'élément à afficher à la position en paramètre dans notre ArrayList mData
        final Map.Entry<Integer, Integer> item = (Map.Entry<Integer, Integer>) this.mData.get(position);

        // On récupère l'ImageView et le TextView se trouvant dans la CardView afin de modifier leur contenu
        ImageView thumbnailImageView = (ImageView) holder.layout.findViewById(R.id.preview_image_view);
        TextView descriptionTextView = (TextView) holder.layout.findViewById(R.id.description);

        // On récupère les données à mettre dans ces vues
        Integer thumbnail = item.getKey();
        final String description = resources.getString(item.getValue());

        // On ajoute les données aux vues
        thumbnailImageView.setImageDrawable(resources.getDrawable(thumbnail));
        descriptionTextView.setText(description);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ctx, String.format(resources.getString(R.string.click_on), description), Toast.LENGTH_SHORT).show();
            }
        });
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
