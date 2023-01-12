package com.example.appearl2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Button bTutup = (Button) findViewById(R.id.tutup_profile);
        bTutup.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.tutup_profile:finish();break;
            }
        }
    };
}