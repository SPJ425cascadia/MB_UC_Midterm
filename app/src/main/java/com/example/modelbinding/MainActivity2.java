package com.example.modelbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button fbtn = findViewById(R.id.convert_btn);
        Spinner spinner1;



        EditText finput = findViewById(R.id.fahrenheit_input);
        TextView ctxt = findViewById(R.id.celcius_text);
        spinner1 = findViewById(R.id.spinner1);



        List<Converter2> converter2List = new ArrayList<>();
        Converter2 converter2 = new Converter2("Lbs to Kg");
        converter2List.add(converter2);
        Converter2 converter3 = new Converter2("Gram to Ounce");
        converter2List.add(converter3);
        Converter2 converter4 = new Converter2("Quart to Gallon");
        converter2List.add(converter4);
        Converter2 converter5 = new Converter2("Feet to Meter");
        converter2List.add(converter5);

        ArrayAdapter<Converter2> adapter2 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, converter2List);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter2);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                fbtn.setOnClickListener(v1 -> {


                    switch (position) {
                        case 0:
                            double toPounds = Converter.toLbs(Float.parseFloat(finput.getText().toString()));
                            ctxt.setText(String.format("%.2f Pounds", toPounds, toString()));
                            break;
                        case 1:
                            double toOunce = ConverterOz.toOunce(Float.parseFloat(finput.getText().toString()));
                            ctxt.setText(String.format("%.2f Ounces", toOunce, toString()));
                            break;
                        case 2:
                            double toQuarts = ConverterQt.toQuart(Float.parseFloat(finput.getText().toString()));
                            ctxt.setText(String.format("%.2f Gallon", toQuarts, toString()));
                            break;
                        case 3:
                            double toMeter = ConverterFt.toFeet(Float.parseFloat(finput.getText().toString()));
                            ctxt.setText(String.format("%.2f Meter", toMeter, toString()));
                            break;
                    }


                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });}}

