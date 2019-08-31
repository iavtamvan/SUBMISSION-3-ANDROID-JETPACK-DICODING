package com.iavariav.submission1.utils;

import android.app.Application;

import com.iavariav.submission1.data.remote.response.MovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {

    private Application application;

    public JsonHelper(Application application) {
        this.application = application;
    }

    private String parsingFileToString(String fileName) {
        try {
            InputStream is = application.getAssets().open(fileName);
            byte[] buffer = new byte[is.available()];
            is.read(buffer);
            is.close();
            return new String(buffer);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public List<MovieModel> loadCourses() {
        ArrayList<MovieModel> list = new ArrayList<>();

        try {
            JSONObject responseObject = new JSONObject(parsingFileToString("DataMovie.json"));
            JSONArray listArray = responseObject.getJSONArray("results");
            for (int i = 0; i < listArray.length(); i++) {
                JSONObject course = listArray.getJSONObject(i);

                String popularity = course.getString("popularity");
                String vote_count = course.getString("vote_count");
                String video = course.getString("video");
                String poster_path = course.getString("poster_path");
                String id = course.getString("id");
                String adult = course.getString("adult");
                String backdrop_path = course.getString("backdrop_path");
                String original_language = course.getString("original_language");
                String original_title = course.getString("original_title");
                String genre_ids = course.getString("genre_ids");
                String title = course.getString("title");
                String vote_average = course.getString("vote_average");
                String overview = course.getString("overview");
                String release_date = course.getString("release_date");

                MovieModel courseResponse = new MovieModel(
                        popularity,
                        vote_count,
                        video,
                        poster_path,
                        id,
                        adult,
                        backdrop_path,
                        original_language,
                        original_title,
                        genre_ids,
                        title,
                        vote_average,
                        overview,
                        release_date

                );
                list.add(courseResponse);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

//    public List<ModuleResponse> loadModule(String courseId) {
//        String fileName = String.format("Module_%s.json", courseId);
//        ArrayList<ModuleResponse> list = new ArrayList<>();
//        try {
//
//            String result = parsingFileToString(fileName);
//            if (result != null) {
//                JSONObject responseObject = new JSONObject(result);
//                JSONArray listArray = responseObject.getJSONArray("modules");
//                for (int i = 0; i < listArray.length(); i++) {
//                    JSONObject course = listArray.getJSONObject(i);
//
//                    String moduleId = course.getString("moduleId");
//                    String title = course.getString("title");
//                    String position = course.getString("position");
//
//                    ModuleResponse courseResponse = new ModuleResponse(moduleId, courseId, title, Integer.parseInt(position));
//                    list.add(courseResponse);
//                }
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public ContentResponse loadContent(String moduleId) {
//        String fileName = String.format("Content_%s.json", moduleId);
//        ContentResponse contentResponse = null;
//        try {
//
//            String result = parsingFileToString(fileName);
//            if (result != null) {
//                JSONObject responseObject = new JSONObject(result);
//
//                String content = responseObject.getString("content");
//
//                contentResponse = new ContentResponse(moduleId, content);
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return contentResponse;
//    }
}
