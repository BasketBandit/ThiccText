package com.basketbandit.thicctext.sound;

import com.basketbandit.thicctext.text.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Generator {
    protected static final Logger log = LoggerFactory.getLogger(Generator.class);

    private Document document;
    private Scale scale;

    public Generator(Document document, Scale scale) {
        this.document = document;
        this.scale = scale;
    }

    public String generate() {
        StringBuilder s = new StringBuilder();

        s.append("V0 I[Piano] ");
        document.getSentences().forEach(sentence -> {
            ArrayList<String[]> toneScales = scale.getScaleByTone(sentence.getTones().get(0).getToneName());
            log.info("Tone Scales: " + toneScales.size());

            List<String> sentenceScale = Arrays.asList(toneScales.get(new Random().nextInt(toneScales.size())));
            log.info("Sentence Scale: " + sentenceScale.toString());

            Arrays.asList(sentence.getText().split(" ")).forEach(word -> {
                s.append(sentenceScale.get(new Random().nextInt(sentenceScale.size())));
                s.append(" ");
            });
            s.append("Rw | "); // Rw - Rest whole
        });

        log.info("Document: " + s.toString());
        return s.toString();
    }
}
