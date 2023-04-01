package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {
    TextView txt1, txt2;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        txt1 = findViewById(R.id.textView2);
        txt2 = findViewById(R.id.textView3);
        btn1 = findViewById(R.id.share);

        Intent i = getIntent();
        String user = i.getStringExtra("name");

        int ran = generate();
        txt2.setText("" + ran);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               sharedata(user, ran);
            }
        });



    }
    public int generate(){
        Random random = new Random();
        int upper = 1000;

        int r = random.nextInt(1000);

        return r;
    }
     public void sharedata(String user , int ran){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        String num = String.valueOf(ran);

        i.putExtra(Intent.EXTRA_SUBJECT,user);
        i.putExtra(Intent.EXTRA_TEXT, num);

        startActivity(Intent.createChooser(i,"Choose a Platform"));

     }
}