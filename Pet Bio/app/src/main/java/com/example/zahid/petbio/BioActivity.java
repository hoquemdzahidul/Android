package com.example.zahid.petbio;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BioActivity extends AppCompatActivity {
    private ImageView petImageView;
    private TextView petTextView;
    private TextView petBioTextView;
    private Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        petImageView = findViewById(R.id.petBioImageView);
        petTextView = findViewById(R.id.nameTextView);
        petBioTextView = findViewById(R.id.bioTextView);
        extras = getIntent().getExtras();
        if(extras != null)
        {
            String name = extras.getString("name");
            String bio = extras.getString("bio");
            setUp(name , bio);
        }

    }
    public void setUp(String name , String bio)
    {
        if(name.equals("Dog Vuger"))
        {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            petTextView.setText(name);
            petBioTextView.setText(bio);
        }else if(name.equals("Cat Jarvis"))
        {
            petImageView.setImageDrawable(getResources().getDrawable(R.drawable.cat));
            petTextView.setText(name);
            petBioTextView.setText(bio);
        }

    }
}
