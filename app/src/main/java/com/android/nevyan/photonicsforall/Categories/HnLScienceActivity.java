package com.android.nevyan.photonicsforall.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.nevyan.photonicsforall.HnLScience.UEQActivity.ImagingActivityUEQ;
import com.android.nevyan.photonicsforall.HnLScience.UEQActivity.LaserTherapyUEQ;
import com.android.nevyan.photonicsforall.HnLScience.UEQActivity.MicroscopyUEQ;
import com.android.nevyan.photonicsforall.HnLScience.UEQActivity.SpectrometryUEQ;
import com.android.nevyan.photonicsforall.R;

public class HnLScienceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hn_lscience);
        getSupportActionBar().hide();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hn_lscience, menu);
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
    public void onClkUEQMicroscopy(View view){
        Intent intent = new Intent(this, MicroscopyUEQ.class);
        startActivity(intent);
    }
    public void onClkUEQImaging(View view){
        Intent intent = new Intent(this, ImagingActivityUEQ.class);
        startActivity(intent);
    }
    public void onClkUEQSpectrometry(View view){
        Intent intent = new Intent(this, SpectrometryUEQ.class);
        startActivity(intent);
    }
    public void onClkUEQLaserTherapy(View view){
        Intent intent = new Intent(this, LaserTherapyUEQ.class);
        startActivity(intent);
    }

}
