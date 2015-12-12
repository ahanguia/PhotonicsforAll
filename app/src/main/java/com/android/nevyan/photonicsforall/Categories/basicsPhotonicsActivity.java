package com.android.nevyan.photonicsforall.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.nevyan.photonicsforall.BasicsPhotonics.CategoryUEQ.ExploreControlUEQActivity;
import com.android.nevyan.photonicsforall.BasicsPhotonics.CategoryUEQ.LaserConceptUEQActivity;
import com.android.nevyan.photonicsforall.BasicsPhotonics.CategoryUEQ.LensesNMirrorsUEQActivity;
import com.android.nevyan.photonicsforall.BasicsPhotonics.CategoryUEQ.OpticRraysWavesUEQActivity;
import com.android.nevyan.photonicsforall.R;


public class basicsPhotonicsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basics_photonics);
        getSupportActionBar().hide();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_basics_photonics, menu);
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
    public void onClkUEQexploreControl(View view){
        Intent intent = new Intent(this, ExploreControlUEQActivity.class);
        startActivity(intent);
    }
    public void onClkUEQopticRraysWaves(View view){
        Intent intent = new Intent(this, OpticRraysWavesUEQActivity.class);
        startActivity(intent);
    }

    public void onClkUEQLensesNMirrors(View view){
        Intent intent = new Intent(this, LensesNMirrorsUEQActivity.class);
        startActivity(intent);
    }
    public void onClkUEQLaserConcept(View view){
        Intent intent = new Intent(this, LaserConceptUEQActivity.class);
        startActivity(intent);
    }


}
