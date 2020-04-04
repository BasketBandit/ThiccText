package com.basketbandit.thicctext;

import com.basketbandit.thicctext.io.RequestHandler;
import com.google.gson.JsonObject;
import okhttp3.Credentials;
import org.jfugue.player.Player;

import java.io.File;

public class ThiccText {
    public static void main(String[] args) {
        String apiUrl = args[0];
        String apiKey = Credentials.basic("apikey", args[1]);
        File text = new File(ThiccText.class.getResource("/text.json").getFile());

        // JsonObject object = new RequestHandler(apiUrl, apiKey, text).getJsonObject(); // comment out if testing player to save api calls

        Player player = new Player();
        player.play("V0 I[Piano] Eq Fh. | Eq Fh. | Fq Eq Dq EqQQ" +
                "           V1 I[Flute] Rw     | Rw     | EmajQQQ FmajQQQQQ"); // interesting formatting, could be useful for me
    }
}
