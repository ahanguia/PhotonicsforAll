package com.android.nevyan.photonicsforall;
import android.app.Application;
import com.parse.Parse;

public class App extends Application {

    @Override public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "eA6MWCGtFfJKwjd4UuELmJHBDk1AEXfOxCvrRDeT", "UccM5ipP7Gbycl7ctcAsYjTuDnyZGsy0fQ61QHy5");

    }
}