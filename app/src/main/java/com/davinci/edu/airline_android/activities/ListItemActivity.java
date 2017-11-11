package com.davinci.edu.airline_android.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.davinci.edu.airline_android.R;
import com.davinci.edu.airline_android.infraestructure.FlightAdapter;
import com.davinci.edu.airline_android.infraestructure.api.ApiClient;
import com.davinci.edu.airline_android.infraestructure.models.Flight;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        final ApiClient apiClient = new ApiClient();

        List<Flight> flightList = new ArrayList<>();

        for (Flight flight : apiClient.getListFlights()) {
            flightList.add(flight);
        }

        ListView itemsFlight = (ListView) findViewById(R.id.listItemView);
        itemsFlight.setAdapter(new FlightAdapter(getBaseContext(), flightList));
    }
}
