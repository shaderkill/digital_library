package com.example.digital_library;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText user_txt, pwd_txt;
    private Button button;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user_txt = findViewById(R.id.user_text);
        pwd_txt = findViewById(R.id.pwd_text);
        progressBar = findViewById(R.id.loading_spinner);
        button = findViewById(R.id.login_btn);
    }

    public void onGit(View view) {
        Intent intent = new Intent(getApplicationContext(), GitHubActivity.class);
        startActivity(intent);
    }

    public void onLogin(View view) {
        button.setVisibility(View.INVISIBLE);
        user_txt.setVisibility(View.INVISIBLE);
        pwd_txt.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        Runnable r = new Runnable() {
            public void run() {
                String user = user_txt.getText().toString();
                String password = pwd_txt.getText().toString();
                boolean result = false;

                try {
                    result = new LoginTask().execute(user, password).get();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (result == true) {
                    Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                    intent.putExtra("USERNAME", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña, no son válidos.", Toast.LENGTH_SHORT).show();
                }
                button.setVisibility(View.VISIBLE);
                user_txt.setVisibility(View.VISIBLE);
                pwd_txt.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.INVISIBLE);
            }
        };
        handler.postDelayed(r, 2000);


    }


}