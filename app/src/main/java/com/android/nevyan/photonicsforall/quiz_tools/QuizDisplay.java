package com.android.nevyan.photonicsforall.quiz_tools;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.nevyan.photonicsforall.R;


/**
 * Created by adam on 30/11/2015.
 */
public  final  class QuizDisplay extends Activity{
    private QuizDisplay(){

    }
    public static void toastAnswer(Question quest,Toast toast,View layoutToast,Context context)
    {
        //Context context = getApplicationContext();
        //CharSequence text = quest.getANSWER();
        TextView textanswer = (TextView) layoutToast.findViewById(R.id.answerText);
        textanswer.setText(quest.getANSWER());
        toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(layoutToast);
        toast.show();
    }
}
