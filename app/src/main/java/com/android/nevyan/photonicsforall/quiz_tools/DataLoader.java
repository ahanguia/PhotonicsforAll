package com.android.nevyan.photonicsforall.quiz_tools;

import android.webkit.WebView;

import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;
import java.util.Locale;

/**
 * Created by adam on 29/11/2015.
 */
public final class DataLoader {
    static String  lang=getLanguage();
    private DataLoader(){

    }
    public static List<ParseObject> loadData(String category){
        List<ParseObject> ob;
        lang=getLanguage();
        ParseQuery<ParseObject> query = new ParseQuery<ParseObject>(
                "question");
        query.whereEqualTo("category",category);
        query.whereEqualTo("language",lang);
        try {
            ob = query.find();
            return ob;
        }
        catch (com.parse.ParseException e) {
            e.printStackTrace();
            return null;
        }

    }
    public static List<Question> loadQuestionAnswer(List<Question> questList ,List<ParseObject> ob) {
        for (ParseObject question : ob) {
            if ((question.get("optC"))==null)
                questList.add(new Question((String) question.get("question"), (String) question.get("optA"), (String) question.get("optB"), (String) question.get("answer")));
            else if (( question.get("optD"))==null) {

                questList.add(new Question((String) question.get("question"), (String) question.get("optA"), (String) question.get("optB"), (String) question.get("optC"), (String) question.get("answer")));
            }else {

                questList.add(new Question((String) question.get("question"), (String) question.get("optA"), (String) question.get("optB"), (String) question.get("optC"), (String) question.get("optD"), (String) question.get("answer")));

            }
        }
        /*Question Q1= new Question("Nous pouvons voir parce que:","Nos yeux émettent de la lumière","Les objets émettent de la lumière"
                ,"Les objets réfléchissent de la lumière","Les objets réfléchissent de la lumière");
        Question Q2= new Question("Un objet est vert car il:","Absorbe la lumière verte","Réfléchit la lumière verte"
                ,"Transmet la lumière verte","Réfléchit la lumière verte");
        Question Q3= new Question("Un objet qui absorbe toute la lumière est","Invisible"
                ,"Noir","Blanc","Noir");*/
        return questList;
    }

    public static String getLanguage() {

        if(Locale.getDefault().getLanguage().equals("fr"))
            return "fr";
        else
            return "en";
    }
    public static void loadCourse(WebView webview,String url){
        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(url);
    }
}
