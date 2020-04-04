package com.basketbandit.thicctext.io;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class RequestHandler {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);
    private static final OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String content;

    /**
     * RequestHandler method which takes a url and optional arguments as request properties.

     * @param url String: the url used for the connection
     */
    public RequestHandler(String url, String apiKey, File text) {
        Request.Builder builder = new Request.Builder()
                .url(url);

        builder.addHeader("Authorization", apiKey);
        builder.addHeader("Content-Type", "application/json");

        try(Response response = client.newCall(builder.post(RequestBody.create(text, JSON)).build()).execute()) {
            if(response.code() == 200) {
                this.content = response.body().string();
            } else {
                 log.error("An error occurred while running the {} class, message: {}", this, response.code());
            }
        } catch(Exception ex) {
            log.error("An error occurred while running the {} class, message: {}", this, ex.getMessage(), ex);
        }
    }

    /**
     * Retrieves the content as a string, does nothing else to it.
     *
     * @return String
     */
    public String getString() {
        return content;
    }

    /**
     * Retrieves the content as a JsonObject which can be handled and manipulated with the Google Gson package.
     *
     * @return {@link JsonObject}
     * @throws IllegalStateException IllegalStateException
     */
    public JsonObject getJsonObject() throws IllegalStateException {
        try {
            return (content == null) ? null : JsonParser.parseString(content).getAsJsonObject();
        } catch(Exception ex) {
            log.error("An error occurred while running the {} class, message: {}", this, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * Retrieves the content as a JsonArray which can be handled and manipulated with the Google Gson package.
     *
     * @return {@link JsonArray}
     * @throws IllegalStateException IllegalStateException
     */
    public JsonArray getJsonArray() throws IllegalStateException {
        try {
            return (content == null) ? null : JsonParser.parseString(content).getAsJsonArray();
        } catch(Exception ex) {
            log.error("An error occurred while running the {} class, message: {}", this, ex.getMessage(), ex);
            return null;
        }
    }

    /**
     * {
     *   "apikey": "x3BhWTk2llGOjEKnZBCZWn2RSLILsGYUTWv3JqzzHJnZ",
     *   "iam_apikey_description": "Auto-generated for key 8288450c-e660-4aca-be61-d5e9a388d67b",
     *   "iam_apikey_name": "Auto-generated service credentials",
     *   "iam_role_crn": "crn:v1:bluemix:public:iam::::serviceRole:Manager",
     *   "iam_serviceid_crn": "crn:v1:bluemix:public:iam-identity::a/c4dc3f6cb0324be28ce6b730f373d93a::serviceid:ServiceId-0eadeb89-9f2e-4e2b-aa91-d86e997378c5",
     *   "url": "https://api.eu-gb.tone-analyzer.watson.cloud.ibm.com/instances/a38502ae-73ea-4f39-a0d6-ec24c9f60156"
     * }
     */

}

