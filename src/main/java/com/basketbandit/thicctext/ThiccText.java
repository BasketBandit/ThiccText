package com.basketbandit.thicctext;

import com.basketbandit.thicctext.io.RequestHandler;
import com.basketbandit.thicctext.sound.Generator;
import com.basketbandit.thicctext.sound.Scale;
import com.basketbandit.thicctext.text.Document;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.Credentials;
import org.jfugue.player.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class ThiccText {
    protected static final Logger log = LoggerFactory.getLogger(ThiccText.class);

    private final String BASE_URL = "https://api.eu-gb.tone-analyzer.watson.cloud.ibm.com/instances/a38502ae-73ea-4f39-a0d6-ec24c9f60156/v3/tone?version=2017-09-21";
    private final String credentials;

    private final File text = new File(Launcher.class.getResource("/text.json").getFile());

    public ThiccText(String apiKey) {
        this.credentials = Credentials.basic("apikey", apiKey);

        Document document = null;
        Scale scale = new Scale();
        try {
            document = new ObjectMapper().readValue(new RequestHandler(BASE_URL, credentials, text).getString(), new TypeReference<>(){});
        } catch(Exception ex) {
            log.error("An error occurred while running the {} class, message: {}", Launcher.class.getSimpleName(), ex.getMessage(), ex);
        }

        Generator generator = new Generator(document, scale);

        Player player = new Player();
        player.play(generator.generate());
    }
}