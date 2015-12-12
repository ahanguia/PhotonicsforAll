package com.android.nevyan.photonicsforall.exprience_tools;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.nevyan.photonicsforall.BasicsPhotonics.explore_control.ExploreControleUnderstandActivity;
import com.android.nevyan.photonicsforall.R;
import com.android.nevyan.photonicsforall.quiz_tools.DataLoader;

import com.android.nevyan.photonicsforall.quiz_tools.Question;
import com.parse.Parse;
import com.parse.ParseObject;
import com.parse.ParseQuery;


import java.util.ArrayList;
import java.util.List;


public class ListVideos extends AppCompatActivity {
    ListView listView;
    Intent intent;
    String subCat;
    int color;
    ArrayList<Video> videoList=new ArrayList<Video>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_videos);
        getSupportActionBar().hide();
        listView=(ListView) findViewById(R.id.list);
        loadIntentData();
        LoadColor(listView);


        new RemoteDataTask().execute();
        //loadVideoList();
        //ifListEmpty();
        //setListView();

    }



    private void setListView() {
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<Video> adapter = new ArrayAdapter<Video>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, videoList);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent i;
                i = new Intent(view.getContext(), VideoPlayer.class);
                i.putExtra("code", videoList.get(position).getCode());
                i.putExtra("color", color);
                startActivity(i);

            }

        });
    }

    private void loadIntentData() {
        intent = getIntent();
        subCat = intent.getStringExtra("subCat");
        color = intent.getIntExtra("color", 000000);
    }

    private void LoadColor(ListView Ll) {
        Ll.setBackgroundColor(getResources().getColor(color));
    }
    private class RemoteDataTask extends AsyncTask<Void, Void, List<Video>> {

        @Override
        protected List<Video> doInBackground(Void... params) {

            String name;
            String code;
            Video vid;


            ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("videos");
            query.whereEqualTo("subcategory", subCat);
            query.whereEqualTo("language", DataLoader.getLanguage());
            try {
                List<ParseObject> ob = query.find();
                for (ParseObject video : ob) {
                    name = (String) video.get("nom");
                    code = (String) video.get("code");
                    vid=new Video(name,code);
                    videoList.add(vid);
                }
            } catch (com.parse.ParseException e) {
                e.printStackTrace();
            }

            return videoList;
        }

        @Override
        protected void onPostExecute(List<Video> result) {

            setListView();


        }
    }
}


