package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by andeski on 7/4/16.
 */
public class ResponseActivity extends AppCompatActivity {
//    ArrayList<Book> mBookList;/
TextView mview;
TextView mview2;

    ArrayList<String> marray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response);
//
        mview = (TextView) findViewById(R.id.one_view);
        mview2 = (TextView) findViewById(android.R.id.text1);
////        mnoun2 = (TextView) findViewById(R.id.noun_two_view);
////        madj1 = (TextView) findViewById(R.id.adj_one_view);
////        madj2 = (TextView) findViewById(R.id.adj_two_view);
////        manimal1 = (TextView) findViewById(R.id.animal_view);
////        mgamename1 = (TextView) findViewById(R.id.game_name_view);
//
        Intent intent = getIntent();
//
        String title = intent.getStringExtra("travellerTitle");
        String author = intent.getStringExtra("travellerAuthor");
        marray.add(title);
        marray.add(author);

        mview.setText("You have completed the " + title + ": " + "by " + author);
//        for(int i=0; i<array.size(); i++) {
//            mview2.setText(array.get(i));
//        }

    }
}
