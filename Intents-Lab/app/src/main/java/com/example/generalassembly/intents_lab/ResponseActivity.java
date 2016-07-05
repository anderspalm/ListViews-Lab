package com.example.generalassembly.intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity {

    TextView mnoun1;
//    TextView mnoun2;
//    TextView madj1;
//    TextView madj2;
//    TextView manimal1;
//    TextView mgamename1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);

        mnoun1 = (TextView) findViewById(R.id.noun_one_view);
//        mnoun2 = (TextView) findViewById(R.id.noun_two_view);
//        madj1 = (TextView) findViewById(R.id.adj_one_view);
//        madj2 = (TextView) findViewById(R.id.adj_two_view);
//        manimal1 = (TextView) findViewById(R.id.animal_view);
//        mgamename1 = (TextView) findViewById(R.id.game_name_view);

        Intent intent = getIntent();

        String adjone = intent.getStringExtra("adj one");
        String adjtwo = intent.getStringExtra("adj two");
        String nounone = intent.getStringExtra("noun one");
        String nountwo = intent.getStringExtra("noun two");
        String animal = intent.getStringExtra("animal");
        String gamename = intent.getStringExtra("game name");

        mnoun1.setText(" The title of this story is " + gamename + ". In a galexy far away a(n) " + nounone + adjone + " " + animal + " materialized suddenly above an unknown plannet" +
                " falling through the atmosphere next to a " + adjtwo + " " + nountwo + " and a pot of petunias.");

    }
}
