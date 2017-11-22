package com.example.joker.newsapp.Utils;

import android.util.Log;

import com.example.joker.newsapp.ModelClass.TopHeadlines;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by joker on 22/11/17.
 */

public final class ParseTopHeadline {

    private static final String TAG = ParseTopHeadline.class.getSimpleName();

    private static ArrayList<TopHeadlines> topHeadlines = new ArrayList<>();

    public static ArrayList<TopHeadlines> parseTopHeadline(String rawData) {

        try {
            JSONObject data = new JSONObject(rawData);
            String status = data.getString("status");

            if (status.equals("ok")) {
                JSONArray articles = data.getJSONArray("articles");

                for (int i = 0; i < articles.length(); i++) {
                     JSONObject article = articles.getJSONObject(i);
                     TopHeadlines news;

                     String title = article.getString("title");
                     String description = article.getString("description");
                     String urlToImage = article.getString("urlToImage");

                     news = new TopHeadlines(
                             null,
                             null,
                             null,
                             title,
                             description,
                             null,
                             urlToImage,
                             null);

                    topHeadlines.add(news);

                }

            }


        } catch (JSONException e) {
            e.printStackTrace();
            Log.d(TAG, "Json Exception in ParseTopHeadline");
        }catch (Exception e){
            Log.d(TAG,"Exception in ParseTopHeadline");
            e.printStackTrace();
        }

        return topHeadlines;
    }


}
