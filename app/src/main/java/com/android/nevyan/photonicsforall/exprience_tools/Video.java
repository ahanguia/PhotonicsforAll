package com.android.nevyan.photonicsforall.exprience_tools;

import android.content.Intent;
import android.view.View;

import com.parse.ParseObject;

/**
 * Created by adam on 08/12/2015.
 */
public class Video  {
    private final String youtubeLinkBase="https://www.youtube.com/watch?v=";
    private String name;
    private String code;
    private String cat;
    private String subCat;
    private String lang;


    public Video(String name, String code) {
        this.name = name;
        this.code = code;

    }

    public Video(String name, String code, String cat, String subCat, String lang) {
        this.name = name;
        this.code = code;
        this.cat = cat;
        this.subCat = subCat;
        this.lang = lang;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSubCat() {
        return subCat;
    }

    public void setSubCat(String subcat) {
        this.subCat = subcat;
    }
    public String getLink(){
        String link=youtubeLinkBase+getCode();
        return link;
    }

    public static void sendDataIntent(String subCat, int color,View v) {
        Intent intent = new Intent(v.getContext(), ListVideos.class);
        intent.putExtra("subCat", subCat);
        intent.putExtra("color", color);
        v.getContext().startActivity(intent);

    }
    public String toString(){
        return this.getName();
    }
}
