package com.android.nevyan.photonicsforall;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        // change font of the title
//        Typeface typefaceTitle=Typeface.createFromAsset(getAssets(),"title_font.otf");
//        TextView title=(TextView)findViewById(R.id.titleTV);
//        title.setTypeface(typefaceTitle);
//        title.setShadowLayer(1.5f, -1, 1, Color.LTGRAY);

        // change font of the title

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void OnClkSignup(View view){
        Intent intent = new Intent(this, Signup.class);
        startActivity(intent);
    }
    public void OnClkLogin(View view){
        Intent intent = new Intent(this, CategoriesActivity.class);
        startActivity(intent);
    }


}
