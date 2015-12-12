package com.android.nevyan.photonicsforall.Categories;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.android.nevyan.photonicsforall.EnergyLnD.CategoryUEQ.DisplayUEQ;
import com.android.nevyan.photonicsforall.EnergyLnD.CategoryUEQ.EnergyUEQ;
import com.android.nevyan.photonicsforall.EnergyLnD.CategoryUEQ.LightningUEQ;
import com.android.nevyan.photonicsforall.R;

public class EnergyLnDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_energy_ln_d);
        getSupportActionBar().hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_energy_ln_d, menu);
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
    public void onClkUEQLightning(View view){
        Intent intent = new Intent(this, LightningUEQ.class);
        startActivity(intent);
    }
    public void onClkUEQDisplay(View view){
        Intent intent = new Intent(this, DisplayUEQ.class);
        startActivity(intent);
    }
    public void onClkUEQEnergy(View view){
        Intent intent = new Intent(this, EnergyUEQ.class);
        startActivity(intent);
    }


}
