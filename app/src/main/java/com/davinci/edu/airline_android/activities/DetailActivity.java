package com.davinci.edu.airline_android.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.davinci.edu.airline_android.R;
import com.davinci.edu.airline_android.infraestructure.models.Flight;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    private Gson jsonParser;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context = getBaseContext();


        jsonParser = new Gson();
        Bundle extras = getIntent().getExtras();

        Flight flight = jsonParser.fromJson(extras.get("flight").toString(), Flight.class);

        TextView detailTitle = (TextView) this.findViewById(R.id.txtTitle);
        ImageView imageFlight = (ImageView) this.findViewById(R.id.detailFlightImg);
        TextView detailOrigin = (TextView) this.findViewById(R.id.destinationFromTxt);
        TextView detailDestination = (TextView) this.findViewById(R.id.destinationToTxt);
        TextView descriptionTxt = (TextView) this.findViewById(R.id.descriptionTxt);
        Button backButton = (Button) this.findViewById(R.id.backBtn);

        detailTitle.setText(flight.getPatent());
        Picasso.with(context).load(flight.getImgURL())
                .fit()
                .centerCrop()
                .into(imageFlight);

        detailOrigin.setText(flight.getRoute().getOrigin());
        detailDestination.setText(flight.getRoute().getDestination());
        descriptionTxt.setText(flight.getDescription());

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailActivity.super.finish();
            }
        });
    }
}
