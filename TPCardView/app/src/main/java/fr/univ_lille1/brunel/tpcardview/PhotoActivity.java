package fr.univ_lille1.brunel.tpcardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class PhotoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);

        // On récupère l'id de la photo envoyé avec l'intent, -1 si rien n'est envoyé
        Integer res = getIntent().getIntExtra("photo", -1);

        // Si un id a été envoyé, on affiche le drawable correspondant dans l'ImageView
        if(res != -1) {
            ImageView photoImageView = (ImageView) findViewById(R.id.photo_image_view);
            photoImageView.setImageDrawable(getResources().getDrawable(res));
        } else { // Sinon, on ferme l'activity
            finish();
        }
    }
}
