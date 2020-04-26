package com.basketbandit.thicctext;

import com.basketbandit.thicctext.io.RequestHandler;
import com.basketbandit.thicctext.text.Document;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Credentials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ThiccText {
    protected static final Logger log = LoggerFactory.getLogger(ThiccText.class);

    private final String BASE_URL = "https://api.eu-gb.tone-analyzer.watson.cloud.ibm.com/instances/a38502ae-73ea-4f39-a0d6-ec24c9f60156/v3/tone?version=2017-09-21";
    private final String apiKey;

    private final File text = new File(Launcher.class.getResource("/text.json").getFile());
    private Document document = null;

    public ThiccText(String apiKey) {
        this.apiKey = Credentials.basic("apikey", apiKey);

        try {
            this.document = new ObjectMapper().readValue(new RequestHandler(BASE_URL, apiKey, text).getString(), new TypeReference<>(){});
        } catch(Exception ex) {
            log.error("An error occurred while running the {} class, message: {}", Launcher.class.getSimpleName(), ex.getMessage(), ex);
        }

        document.getSentences().forEach(sentence -> {
            System.out.println(sentence.getText() + " : ");
            sentence.getTones().forEach(tone -> {
                System.out.print(tone.getToneName() + " -> " + tone.getScore() + " ");
            });
            System.out.println();
        });

        //Player player = new Player();
        //player.play("V0 I[Piano] Eq Fh. | Eq Fh. | Fq Eq Dq EqQQ" +
        //       "           V1 I[Flute] Rw     | Rw     | EmajQQQ FmajQQQQQ"); // interesting formatting, could be useful for me
    }
}