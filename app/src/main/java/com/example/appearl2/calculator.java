package com.example.appearl2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appearl2.R;

public class calculator extends AppCompatActivity {
    private EditText editBil1,editBil2;
    private TextView textHasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        editBil1=(EditText)findViewById(R.id.bilangan1);
        editBil2=(EditText)findViewById(R.id.bilangan2) ;
        textHasil=(TextView) findViewById(R.id.textView3);

        Button button4 = (Button) findViewById(R.id.button4);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button = (Button) findViewById(R.id.button);
        Button bTutup = (Button) findViewById(R.id.button5);
        bTutup.setOnClickListener(op);

        button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                bagi(v);
            }
        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kali(v);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                kurang(v);
            }
        });

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tambah(v);
            }
        });

    }

    View.OnClickListener op = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.button5:finish();break;
            }
        }
    };

    public void tambah(View v){
        float bil1, bil2, hasil;

        bil1=Float.parseFloat(editBil1.getText().toString());
        bil2=Float.parseFloat(editBil2.getText().toString());
        hasil=bil1+bil2;

        textHasil.setText(bil1+"+"+bil2+"="+hasil);
    }

    public void kurang(View v){
        float bil1, bil2, hasil;

        bil1=Float.parseFloat(editBil1.getText().toString());
        bil2=Float.parseFloat(editBil2.getText().toString());
        hasil=bil1-bil2;

        textHasil.setText(bil1+"-"+bil2+"="+hasil);
    }

    public void kali(View v){
        float bil1, bil2, hasil;

        bil1=Float.parseFloat(editBil1.getText().toString());
        bil2=Float.parseFloat(editBil2.getText().toString());
        hasil=bil1*bil2;

        textHasil.setText(bil1+"*"+bil2+"="+hasil);
    }

    public void bagi(View v){
        float bil1, bil2, hasil;

        bil1=Float.parseFloat(editBil1.getText().toString());
        bil2=Float.parseFloat(editBil2.getText().toString());
        hasil=bil1/bil2;

        textHasil.setText(bil1+"/"+bil2+"="+hasil);
    }
}