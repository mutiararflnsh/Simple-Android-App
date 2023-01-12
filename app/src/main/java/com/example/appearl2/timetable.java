package com.example.appearl2;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class timetable extends AppCompatActivity {
    private EditText editnama, editnrp, editdate, editpukul, editliter, txtinput;
    private Button simpan, ambildata, isihari;
    private SQLiteDatabase dbku;
    private SQLiteOpenHelper Opendb;
    private TextView hasilnya;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        editnama = (EditText)findViewById(R.id.editnama);
        editnrp = (EditText)findViewById(R.id.editnrp);
        editpukul = (EditText)findViewById(R.id.editpukul);
        editliter = (EditText)findViewById(R.id.editliter);
        editdate = (EditText)findViewById(R.id.editdate);
        simpan = (Button)findViewById(R.id.simpan);
        ambildata = (Button)findViewById(R.id.ambildata);
        isihari = (Button)findViewById(R.id.isihari);
        hasilnya = (TextView)findViewById(R.id.result);

        simpan.setOnClickListener(op);
        ambildata.setOnClickListener(op);
        isihari.setOnClickListener(operation);
        
        Button bTutup = (Button) findViewById(R.id.tutup_timetable);
        bTutup.setOnClickListener(op);
        
        Opendb = new SQLiteOpenHelper(this,"db.sql",null,1) {
            @Override
            public void onCreate(SQLiteDatabase db) {}
            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}
        };
        
        dbku = Opendb.getWritableDatabase();
        dbku.execSQL("create table if not exists user (nama TEXT, nrp TEXT, tanggal TEXT, pukul TEXT, liter TEXT);");
    }

    @Override
    protected void onStop(){
        dbku.close();
        Opendb.close();
        super.onStop();
    }

    View.OnClickListener op = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            switch(view.getId()){
                case R.id.tutup_timetable:finish();break;
                case R.id.simpan:simpan();break;
                case R.id.ambildata:a();break;
            }
        }
    };
    
    private void simpan()
    {
        ContentValues dataku = new ContentValues();
        dataku.put("nama", editnama.getText().toString());
        dataku.put("tanggal", editdate.getText().toString());
        dataku.put("nrp", editnrp.getText().toString());
        dataku.put("pukul", editpukul.getText().toString());
        dataku.put("liter", editliter.getText().toString());
        dbku.insert("user",null,dataku);
        Toast.makeText(this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
    }
    
    private void a()
    {
        Cursor cur = dbku.rawQuery("select * from user where nrp ='" + editnrp.getText().toString()+ "'", null);
        
        if(cur.getCount() > 0)
        {
            Toast.makeText(this, "Data ditemukan sejumlah " + cur.getCount(), Toast.LENGTH_SHORT).show();
            cur.moveToFirst();
            editnama.setText(cur.getString(cur.getColumnIndex("nama")));
        }
        else
            Toast.makeText(this, "Data tidak ditemukan", Toast.LENGTH_SHORT).show();
    }

    View.OnClickListener operation = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.isihari:
                    tampil_input();
                    break;
            }
        }
    };

    private void tampil_input(){
        LayoutInflater li = LayoutInflater.from(this);
        View inputnya = li.inflate(R.layout.input_hari,null);

        AlertDialog.Builder dialognya = new AlertDialog.Builder(this);
        dialognya.setView(inputnya);
        txtinput = (EditText) inputnya.findViewById(R.id.enterhari);

        dialognya
                .setCancelable(false)
                .setPositiveButton("Ok", oknya)
                .setNegativeButton("Batal", oknya);
        dialognya.show();
    }

    DialogInterface.OnClickListener oknya = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case -1: hasilnya.setText(txtinput.getText().toString());
                    break;
                case -2:
                    break;
            }
        }
    };
}
