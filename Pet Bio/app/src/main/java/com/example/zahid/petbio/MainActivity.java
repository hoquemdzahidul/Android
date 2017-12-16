package com.example.zahid.petbio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private ImageView catView;
  private ImageView dogView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        catView = findViewById(R.id.catImageView);
        dogView = findViewById(R.id.dogImageView);
        catView.setOnClickListener(this);
       dogView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
      switch (view.getId())
      {
          case R.id.catImageView :
              Intent catIntent = new Intent(MainActivity.this, BioActivity.class);
              catIntent.putExtra("name" , "Cat Jarvis");
              catIntent.putExtra("bio" , "Great cat loves peopl and mewa alot");
              startActivity(catIntent);
              break;
          case R.id.dogImageView:
              Intent dogIntent = new Intent(MainActivity.this, BioActivity.class);
              dogIntent.putExtra("name" , "Dog Vuger");
              dogIntent.putExtra("bio" , "Great dog loves peopl and mewa alot");
              startActivity(dogIntent);
              break;
      }
    }
}
