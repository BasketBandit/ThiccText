package com.basketbandit.thicctext;

import com.basketbandit.thicctext.io.RequestHandler;
import com.google.gson.JsonObject;
import okhttp3.Credentials;

import java.io.File;

public class ThiccText {
    public static void main(String[] args) {
        String apiUrl = args[0];
        String apiKey = Credentials.basic("apikey", args[1]);
        File text = new File(ThiccText.class.getResource("/text.json").getFile());

        JsonObject object = new RequestHandler(apiUrl, apiKey, text).getJsonObject();
    }
}
