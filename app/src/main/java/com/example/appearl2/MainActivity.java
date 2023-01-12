package com.example.appearl2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView profileclick = (CardView) findViewById(R.id.profile);
        CardView timetableclick = (CardView) findViewById(R.id.timetable);
        CardView calculatorclick = (CardView) findViewById(R.id.calculator);
        CardView notesclick = (CardView) findViewById(R.id.notes);
        CardView todoclick = (CardView) findViewById(R.id.todo);
        CardView mapsclick = (CardView) findViewById(R.id.maps);
        profileclick.setOnClickListener(operasi);
        timetableclick.setOnClickListener(operasi);
        calculatorclick.setOnClickListener(operasi);
        notesclick.setOnClickListener(operasi);
        todoclick.setOnClickListener(operasi);
        mapsclick.setOnClickListener(operasi);
    }

    View.OnClickListener operasi = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.profile:bukaprofile();break;
                case R.id.timetable:bukatimetable();break;
                case R.id.calculator:bukacalculator();break;
                case R.id.notes:bukanotes();break;
                case R.id.todo:bukatodo();break;
                case R.id.maps:bukamaps();break;
            }
        }
    };

    void bukaprofile(){
        Intent intentku = new Intent(getBaseContext(),profile.class);
        startActivityForResult(intentku, 0);
    }

    void bukatimetable(){
        Intent intentku = new Intent(getBaseContext(),timetable.class);
        startActivityForResult(intentku, 0);
    }

    void bukacalculator(){
        Intent intentku = new Intent(getBaseContext(),calculator.class);
        startActivityForResult(intentku, 0);
    }

    void bukanotes(){
        Intent intentku = new Intent(getBaseContext(),notes.class);
        startActivityForResult(intentku, 0);
    }

    void bukatodo(){
        Intent intentku = new Intent(getBaseContext(),todo.class);
        startActivityForResult(intentku, 0);
    }

    void bukamaps(){
        Intent intentku = new Intent(getBaseContext(),maps.class);
        startActivityForResult(intentku, 0);
    }
}