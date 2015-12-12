package com.android.nevyan.photonicsforall.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.nevyan.photonicsforall.PhotonicsForICT.CategoryUEQ.ImageNVideoUEQActivity;
import com.android.nevyan.photonicsforall.PhotonicsForICT.CategoryUEQ.OpticalCommunicationUEQActivity;
import com.android.nevyan.photonicsforall.PhotonicsForICT.CategoryUEQ.OpticalStorageUEQActivity;
import com.android.nevyan.photonicsforall.R;

public class PhotonicsForICT extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photonics_for_ict);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_photonics_for_ict, menu);
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
    public void onClkUEQopticalCommuniciation(View view){
        Intent intent = new Intent(this, OpticalCommunicationUEQActivity.class);
        startActivity(intent);
    }

    public void onClkUEQopticalStorage(View view){
        Intent intent = new Intent(this, OpticalStorageUEQActivity.class);
        startActivity(intent);
    }
    public void onClkUEQImageNVideo(View view){
        Intent intent = new Intent(this, ImageNVideoUEQActivity.class);
        startActivity(intent);
    }
}
