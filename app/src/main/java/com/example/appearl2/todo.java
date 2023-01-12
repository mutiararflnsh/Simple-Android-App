package com.example.appearl2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class todo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        Button bTutup = (Button) findViewById(R.id.tutup_todo);
        bTutup.setOnClickListener(op);
    }

    View.OnClickListener op = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.tutup_todo:finish();break;
            }
        }
    };
}