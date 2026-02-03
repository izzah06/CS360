package com.example.listycity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView cityList;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addButton, deleteButton, confirmButton;
    EditText cityInput;
    int selectedPosition = -1;
    String pendingCity = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityList = findViewById(R.id.city_list);
        addButton = findViewById(R.id.addButton);
        deleteButton = findViewById(R.id.deleteButton);
        confirmButton = findViewById(R.id.confirmButton);
        cityInput = findViewById(R.id.cityInput);

        String[] cities = {"Edmonton", "Vancouver", "Moscow", "Berlin", "Vienna", "Tokyo", "Beijing", "Osaka", "New Delhi", "Lahore", "Boston", "London"};

        dataList = new ArrayList<>(Arrays.asList(cities));

        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        cityList.setAdapter(cityAdapter);

        cityList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        cityList.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position;
            cityList.setItemChecked(position, true);
        });

        addButton.setOnClickListener(v -> {
            String cityName = cityInput.getText().toString().trim();
            if (!cityName.isEmpty()) {
                pendingCity = cityName;
                confirmButton.setVisibility(View.VISIBLE);
            }
        });

        confirmButton.setOnClickListener(v -> {
            if (!pendingCity.isEmpty()) {
                dataList.add(pendingCity);
                cityAdapter.notifyDataSetChanged();
                cityInput.setText("");
                pendingCity = "";
                confirmButton.setVisibility(View.GONE);
            }
        });

        deleteButton.setOnClickListener(v -> {
            if (selectedPosition != -1) {
                dataList.remove(selectedPosition);
                cityAdapter.notifyDataSetChanged();
                selectedPosition = -1;
                cityList.clearChoices();
            }
        });
    }

    private void onClick(View v) {
        String cityName = cityInput.getText().toString().trim();
        if (!cityName.isEmpty()) {
            dataList.add(cityName);
            cityAdapter.notifyDataSetChanged();
            cityInput.setText("");
        }
    }
}