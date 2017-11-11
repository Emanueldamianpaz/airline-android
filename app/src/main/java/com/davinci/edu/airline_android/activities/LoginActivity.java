package com.davinci.edu.airline_android.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.davinci.edu.airline_android.R;
import com.davinci.edu.airline_android.infraestructure.api.ApiClient;

public class LoginActivity extends AppCompatActivity {
    private Context context;

    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = getBaseContext();

        final ApiClient apiClient = new ApiClient();

        final TextView usernameTxt = (TextView) findViewById(R.id.usernameTxt);
        final TextView passwordTxt = (TextView) findViewById(R.id.passwordTxt);
        final CheckBox saveUserCheck = (CheckBox) findViewById(R.id.saveUserCheck);
        Button loginBtn = (Button) findViewById(R.id.loginBtn);

        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);

        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if (username != "" && password != "") {
            usernameTxt.setText(username);
            passwordTxt.setText(password);
        }


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ProgressDialog dialog = ProgressDialog.show(LoginActivity.this, "", "Espere...", true);

                if (apiClient.getUser(usernameTxt.getText().toString(), passwordTxt.getText().toString())) {

                    if (saveUserCheck.isChecked()) {
                        sharedPreferences = context.getSharedPreferences(getResources().getString(R.string.app_name), MODE_PRIVATE);
                        sharedPreferences.edit()
                                .putString("username", usernameTxt.getText().toString())
                                .putString("password", passwordTxt.getText().toString())
                                .apply();
                    }
                    dialog.closeOptionsMenu();
                    Intent intent = new Intent(context, ListItemActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, "Login incorrecto!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
