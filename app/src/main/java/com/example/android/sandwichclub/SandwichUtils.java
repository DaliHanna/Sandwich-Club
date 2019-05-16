package com.example.android.sandwichclub;

import android.graphics.Movie;
import android.util.Log;

import com.example.android.sandwichclub.models.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SandwichUtils {
    public static Sandwich parseJson(String json) {

        try {
            JSONObject mainJsonObject = new JSONObject(json);

            JSONObject name = mainJsonObject.getJSONObject("name");
            String mainName = name.getString("mainName");

            JSONArray alsoKnownAsJson = name.getJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = converyJsonArrayToList(alsoKnownAsJson);

            String placeOfOrigin = mainJsonObject.optString("placeOfOrigin");

            String description = mainJsonObject.getString("description");

            String image = mainJsonObject.getString("image");

            JSONArray ingredientsJson = mainJsonObject.getJSONArray("ingredients");
            List<String> ingredients = converyJsonArrayToList(ingredientsJson);

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static List<String> converyJsonArrayToList(JSONArray jsonArray) throws JSONException {
        List<String> list = new ArrayList<>(jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getString(i));
        }

        return list;
    }
}
