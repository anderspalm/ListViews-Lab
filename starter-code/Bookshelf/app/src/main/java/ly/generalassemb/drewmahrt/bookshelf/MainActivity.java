package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //Method to generate a list of Books
    public List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();
        books.add(new Book("Apples Book","Brad"));
        books.add(new Book("Cats Book","Ryan"));
        books.add(new Book("Eagles Book","Kate"));
        books.add(new Book("Strawberries Cathy","Brad"));
        books.add(new Book("Dogs Book","Tom"));
        books.add(new Book("Ants Book","Zane"));
        return books;
    }

    //TODO: Define your ListView
    ListView mlistview;
    Button mbutton;

    //TODO: Define your Book List
    ArrayList<Book> mBookList;

    public ArrayList rabbit = new ArrayList<>();

    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this,ResponseActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistview =  (ListView) findViewById(R.id.list_item);
        mbutton = (Button) findViewById(R.id.completed);

        //Use helper method to add books to the list
        mBookList = (ArrayList<Book>) generateBooks();

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;
                if (view== null) {
                    LayoutInflater inflator = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflator.inflate(android.R.layout.simple_list_item_2,null);
                }

                TextView title = (TextView) view.findViewById(android.R.id.text1);
                TextView name = (TextView) view.findViewById(android.R.id.text2);

                title.setText(mBookList.get(position).getTitle());
                name.setText(mBookList.get(position).getAuthor());

                return view;
            }
        };

        //TODO: Set the ListView's adapter
        mlistview.setAdapter(mBookAdapter);
//        ColorStateList mList = mlistview.getTextColors();
//        int color = mList.getDefaultColor();
        mlistview.setOnItemClickListener( new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title = (TextView) view.findViewById(android.R.id.text1);
                TextView name = (TextView) view.findViewById(android.R.id.text2);

                int color = title.getCurrentTextColor();
                int color2 = name.getCurrentTextColor();

                //Checking things completed and uncompleted
                if ((color == Color.BLACK) || (color2 == Color.BLACK)) {
                    title.setTextColor(Color.parseColor("#f50057"));
                    name.setTextColor(Color.parseColor("#f50057"));
                }
                else if ((color != Color.BLACK) || (color2 != Color.BLACK)) {
                    title.setTextColor(Color.BLACK);
                    name.setTextColor(Color.BLACK);
                }
            }
        });

        mlistview.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title = (TextView) view.findViewById(android.R.id.text1);
                TextView name = (TextView) view.findViewById(android.R.id.text2);

                rabbit.add(mBookList.get(position).getTitle());
                rabbit.add(mBookList.get(position).getAuthor());
//
                Intent intent = new Intent(view.getContext(), ResponseActivity.class);
                intent.putExtra("travellerTitle", mBookList.get(position).getTitle());
                intent.putExtra("travellerAuthor", mBookList.get(position).getAuthor());
//                intent.putStringArrayListExtra("hello", rabbit);
                startActivity(intent);
                return true;
            }
        });
    }
}
