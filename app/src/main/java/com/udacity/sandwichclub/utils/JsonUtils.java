package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject sandwichJSON = new JSONObject(json);

            Sandwich sandwich = new Sandwich();

            sandwich.setMainName(sandwichJSON.getJSONObject("name").getString("mainName"));

            sandwich.setAlsoKnownAs(jsonArrayToList(sandwichJSON.getJSONObject("name").getJSONArray("alsoKnownAs")));
            sandwich.setPlaceOfOrigin(sandwichJSON.getString("placeOfOrigin"));
            sandwich.setDescription(sandwichJSON.getString("description"));
            sandwich.setImage(sandwichJSON.getString("image"));
            sandwich.setIngredients(jsonArrayToList(sandwichJSON.getJSONArray("ingredients")));

            return sandwich;
        } catch (JSONException e) {
            return null;
        }

    }

    private static List<String> jsonArrayToList(JSONArray jsonArray) throws JSONException {

        List<String> stringList = null;

        if (jsonArray != null  && jsonArray.length() > 0) {
            stringList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                stringList.add(jsonArray.getString(i));
            }
        }

        return stringList;
    }
}
