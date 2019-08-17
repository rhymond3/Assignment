package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/* to show the song list*/
public class ListActivity extends AppCompatActivity {

    ListView listView;
    String[] songNames = {"Chasing Wonder", "Enjoyable", "Healing Piano"};
    int[] songImages = {R.drawable.chasingwonder, R.drawable.enjoyable, R.drawable.healingpiano};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musiclist);

        listView = findViewById(R.id.listview);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), MusicActivity.class);
                intent.putExtra("name", songNames[i]);
                intent.putExtra("image", songImages[i]);
                startActivity(intent);
            }
        });
    }

    private class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return songImages.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
          View view1 = getLayoutInflater().inflate(R.layout.row_data,null);

            TextView name = view1.findViewById(R.id.song);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(songNames[i]);
            image.setImageResource(songImages[i]);

            return view1;
        }
    }
}
