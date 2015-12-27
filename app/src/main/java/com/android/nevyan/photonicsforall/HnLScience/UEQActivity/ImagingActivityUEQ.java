package com.android.nevyan.photonicsforall.HnLScience.UEQActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.android.nevyan.photonicsforall.Understand_tools.UnderstandActivity;
import com.android.nevyan.photonicsforall.Understand_tools.UnderstandRessource;
import com.android.nevyan.photonicsforall.exprience_tools.Experience;
import com.android.nevyan.photonicsforall.HnLScience.Imaging.ImagingExperiment;
import com.android.nevyan.photonicsforall.HnLScience.Imaging.ImagingQuiz;
import com.android.nevyan.photonicsforall.HnLScience.Imaging.ImagingUnderstand;
import com.android.nevyan.photonicsforall.R;
import com.android.nevyan.photonicsforall.exprience_tools.Ressource;

public class ImagingActivityUEQ extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ueq);
        getSupportActionBar().hide();
        changeColorButtons();
    }

    private void changeColorButtons() {
        TextView understand = (TextView) findViewById(R.id.understandTV);
        TextView quiz = (TextView) findViewById(R.id.quizTV);
        TextView experiment = (TextView) findViewById(R.id.experimentTV);
        understand.setBackgroundColor(getResources().getColor(R.color.red_d));
        experiment.setBackgroundColor(getResources().getColor(R.color.red_l1));
        quiz.setBackgroundColor(getResources().getColor(R.color.red_l2));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_imaging, menu);
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
    public void OnCLKQuiz(View view){
        Intent intent = new Intent(this, ImagingQuiz.class);
        startActivity(intent);
    }


    public void onCLKexperiment(View view){
        Experience.setExperience(ImagingExperiment.class, Ressource.imaging, R.color.red_l1, view, this);

    }
    public void onCLKunderstand(View view){
        Intent intent = new Intent(this, UnderstandActivity.class);
        intent.putExtra("color",R.color.red_d);
        intent.putExtra("urlFr", UnderstandRessource.FRimaging);
        intent.putExtra("urlEn", UnderstandRessource.ENimaging);
        startActivity(intent);
    }
}
