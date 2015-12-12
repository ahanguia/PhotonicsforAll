package com.android.nevyan.photonicsforall.exprience_tools;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.android.nevyan.photonicsforall.R;

/**
 * Created by adam on 08/12/2015.
 */
public class Experience {

    public static void setExperience(Class activity, String subClass, int color, View v,Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWifi = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if (mWifi.isConnected()) {
            Video.sendDataIntent(subClass, color, v);
        }
        else {
            Intent intent = new Intent(v.getContext(), activity);
            v.getContext().startActivity(intent);
        }
    }
    public static void getInit(VideoView video_player_view,Context context,MediaController media_Controller,DisplayMetrics dm,int video) {
        media_Controller = new MediaController(context);
        dm = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        video_player_view.setMinimumWidth(width);
        video_player_view.setMinimumHeight(height);
        video_player_view.setMediaController(media_Controller);
        video_player_view.setVideoPath("android.resource://" + context.getPackageName() + "/" + video);
        video_player_view.start();
    }


}
