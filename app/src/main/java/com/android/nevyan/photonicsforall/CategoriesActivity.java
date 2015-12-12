package com.android.nevyan.photonicsforall;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.nevyan.photonicsforall.Categories.EnergyLnDActivity;
import com.android.nevyan.photonicsforall.Categories.HnLScienceActivity;
import com.android.nevyan.photonicsforall.Categories.PhotonicsForICT;
import com.android.nevyan.photonicsforall.Categories.PhotonicsSecurityActivity;
import com.android.nevyan.photonicsforall.Categories.basicsPhotonicsActivity;
import com.parse.Parse;


public class CategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable Local Datastore.
        /*Parse.enableLocalDatastore(this);

        Parse.initialize(this, "eA6MWCGtFfJKwjd4UuELmJHBDk1AEXfOxCvrRDeT", "UccM5ipP7Gbycl7ctcAsYjTuDnyZGsy0fQ61QHy5");
        */setContentView(R.layout.activity_categories);
        getSupportActionBar().hide();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
    public void OnClkBasics(View view){
        Intent intent = new Intent(this, basicsPhotonicsActivity.class);
        startActivity(intent);
    }

    public void OnClkPhotonicsForICT(View view){
        Intent intent = new Intent(this, PhotonicsForICT.class);
        startActivity(intent);
    }
    public void OnClkEnergyLnD(View view){
        Intent intent = new Intent(this, EnergyLnDActivity.class);
        startActivity(intent);
    }
    public void OnClkSecurity(View view){
        Intent intent = new Intent(this, PhotonicsSecurityActivity.class);
        startActivity(intent);
    }
    public void OnClkHnlScience(View view){
        Intent intent = new Intent(this, HnLScienceActivity.class);
        startActivity(intent);
    }
}
