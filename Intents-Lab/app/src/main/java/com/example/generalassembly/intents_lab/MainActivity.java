package com.example.generalassembly.intents_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mbutton;
    EditText mfirst_adj;
    EditText msecond_adj;
    EditText mfirst_noun;
    EditText msecond_noun;
    EditText manimal;
    EditText mgamename;
    ArrayList<EditText> marray;
    public static int mcounter = 0;

//    public static String FIRST_ADJ = "first_adj";

    void setError(CharSequence error) {
    }

    private boolean isEmpty(EditText eText, ArrayList array_b) {
        for (int i = 0; i < array_b.size(); i++) {
            if (eText.getText().toString().length() > 0)
                return true;
            else {
                eText.setError("Please fill the empty fields");
                return false;
            }
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbutton = (Button) findViewById(R.id.button_submit);
        mfirst_adj = (EditText) findViewById(R.id.firstadj);
        msecond_adj = (EditText) findViewById(R.id.seconfadj);
        mfirst_noun = (EditText) findViewById(R.id.firstnoun);
        msecond_adj = (EditText) findViewById(R.id.secondnoun);
        msecond_noun = (EditText) findViewById(R.id.animal);
        manimal = (EditText) findViewById(R.id.animal);
        mgamename = (EditText) findViewById(R.id.gamename);
//        first_noun = (EditText) findViewById(R.)

        marray = new ArrayList<>();
        marray.add(mfirst_adj);
        marray.add(msecond_adj);
        marray.add(mfirst_noun);
        marray.add(msecond_noun);
        marray.add(manimal);
        marray.add(mgamename);


        View.OnClickListener emailListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResponseActivity.class);
                int counter = 1;
                for (int i = 0; i < marray.size(); i++) {
                    if (isEmpty(marray.get(i), marray)) {

                        {

                        counter += 1;
                            Log.d("counter1 =" , String.valueOf(counter));
                        }
                    }
                }

                Log.d("counter =" , String.valueOf(counter));
                if(counter >= 7){
                    intent.putExtra("adj one", marray.get(0).getText().toString());
                    intent.putExtra("adj two", marray.get(1).getText().toString());
                    intent.putExtra("noun one", marray.get(2).getText().toString());
                    intent.putExtra("noun two", marray.get(3).getText().toString());
                    intent.putExtra("animal", marray.get(4).getText().toString());
                    intent.putExtra("game name", marray.get(5).getText().toString());

                    startActivity(intent);
                }
            }
        };
        mbutton.setOnClickListener(emailListener);
    }
}


