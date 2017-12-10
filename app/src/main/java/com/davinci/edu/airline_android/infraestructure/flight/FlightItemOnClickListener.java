package com.davinci.edu.airline_android.infraestructure.flight;


import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.davinci.edu.airline_android.activities.DetailActivity;
import com.davinci.edu.airline_android.infraestructure.models.Flight;
import com.google.gson.Gson;

public class FlightItemOnClickListener implements View.OnClickListener {

    private Context context;
    private Flight flight;


    public FlightItemOnClickListener(Context context, Flight flight) {
        this.context = context;
        this.flight = flight;
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("flight", new Gson().toJson(flight));
        context.startActivity(intent);
    }
}
