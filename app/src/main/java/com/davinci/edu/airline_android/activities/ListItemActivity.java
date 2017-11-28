package com.davinci.edu.airline_android.activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.davinci.edu.airline_android.R;
import com.davinci.edu.airline_android.infraestructure.FlightAdapter;
import com.davinci.edu.airline_android.infraestructure.api.ApiClient;
import com.davinci.edu.airline_android.infraestructure.api.OnSuccessCallback;
import com.davinci.edu.airline_android.infraestructure.models.Flight;

import java.util.ArrayList;
import java.util.List;

public class ListItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        final ApiClient apiClient = new ApiClient(getBaseContext());

        final ProgressDialog progressDialog = ProgressDialog.show(this, "Vuelos", "Obteniendo el menu...", true, false);

        apiClient.getListFlights(new OnSuccessCallback() {
            @Override
            public void execute(Object body) {

                ListView itemsFlight = (ListView) findViewById(R.id.listItemView);
                itemsFlight.setAdapter(new FlightAdapter(getBaseContext(), (List<Flight>) body));

                progressDialog.dismiss();
            }
        });


    }
}
