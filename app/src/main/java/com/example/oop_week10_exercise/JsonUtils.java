package com.example.oop_week10_exercise;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context) {
        List<Movie> movies = new ArrayList<>();
        try {
            // Load JSON from the assets folder
            String jsonString = loadJsonFromAsset(context, "movies.json");
            if (jsonString == null) {
                throw new IOException("Failed to load JSON file");
            }

            JSONArray jsonArray = new JSONArray(jsonString);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String title = jsonObject.optString("title", "Unknown Title");
                int year = jsonObject.optInt("year", -1);
                String genre = jsonObject.optString("genre", "Unknown Genre");
                String posterResourceName = jsonObject.optString("posterResource", null);

                int posterResourceId = context.getResources().getIdentifier(
                        posterResourceName, "drawable", context.getPackageName());

                if (year != -1 && posterResourceId != 0) {
                    movies.add(new Movie(title, year, genre, posterResourceId));
                } else {
                    Log.w(TAG, "Invalid data in JSON object at index " + i);
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
        } catch (JSONException e) {
            Log.e(TAG, "Error parsing JSON", e);
        } catch (IllegalArgumentException e) {
            Log.e(TAG, "Invalid data format", e);
        }

        return movies;
    }

    private static String loadJsonFromAsset(Context context, String fileName) throws IOException {
        InputStream inputStream = context.getAssets().open(fileName);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        return new String(buffer, "UTF-8");
    }
}
