package com.davinci.edu.airline_android.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.davinci.edu.airline_android.R;
import com.davinci.edu.airline_android.infraestructure.api.ApiClient;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final ApiClient apiClient = new ApiClient();

        final TextView usernameTxt = (TextView) findViewById(R.id.usernameTxt);
        final TextView passwordTxt = (TextView) findViewById(R.id.passwordTxt);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if (apiClient.getUser(usernameTxt.getText().toString(), passwordTxt.getText().toString())) {
                if (true) {

                    Intent intent = new Intent(getBaseContext(), ListItemActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    getBaseContext().startActivity(intent);
                } else {
                    Toast.makeText(getBaseContext(), "Login incorrecto!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
