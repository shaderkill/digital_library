package com.example.digital_library;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GitHubActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner;
    private TextView textView;
    private String[] names = {"Farenheith", "Revival", "El Alquimista", "El Poder", "Despertar"};
    private Integer[] prices = {7000, 22000, 45000, 88000, 156000};

    /*Farenheith: 7000
    Revival: 22000
    El Alquimista:  45000
    El Poder:  88000
    Despertar:  156000*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_git_hub);
        textView = findViewById(R.id.git_txtview);
        textView.setText("");
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, names);
        spinner = findViewById(R.id.git_spinner);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String name = names[position];
        Integer price = prices[position];
        textView.setText("El valor de " + name + " es de: $" + price);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        textView.setText("");
    }
}