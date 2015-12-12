package com.android.nevyan.photonicsforall.BasicsPhotonics.OpticRaysWaves;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.LinearLayout;

import com.android.nevyan.photonicsforall.quiz_tools.DataLoader;
import com.android.nevyan.photonicsforall.R;


public class OpticRraysWavesUnderstandActivity extends AppCompatActivity {
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_understand);
        getSupportActionBar().hide();
        WebView webview = (WebView)findViewById(R.id.Wv);
        DataLoader.loadCourse(webview, getUrl());
        LinearLayout Ll=(LinearLayout) findViewById(R.id.understandLl);
        LoadColor(Ll);
    }

    private void LoadColor(LinearLayout Ll) {
        Ll.setBackgroundColor(getResources().getColor(R.color.blue_d));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_explore_controle_understand, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public String getUrl() {
        if(DataLoader.getLanguage()=="fr")
            url="file:///android_asset/basicsphotonics/fr/optics_r_rays.html";
        else
            url="file:///android_asset/basicsphotonics/en/optics_r_rays.html";
        return url;
    }
}
