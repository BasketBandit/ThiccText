package com.basketbandit.thicctext.sound;

import com.basketbandit.thicctext.text.Document;
import com.basketbandit.thicctext.util.CrudeSyllableCalculator;
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
            log.info("\"" + sentence.getText() + "\"");
            log.info("Sentence Tone: " + sentence.getTones().get(0).getToneName());

            ArrayList<String[]> toneScales = scale.getScaleByTone(sentence.getTones().get(0).getToneName());
            log.info("Tone Scales: " + toneScales.size());

            List<String> sentenceScale = Arrays.asList(toneScales.get(new Random().nextInt(toneScales.size())));
            log.info("Sentence Scale: " + sentenceScale.toString() + "\n");

            Arrays.asList(sentence.getText().split(" ")).forEach(word -> {
                int syllables = CrudeSyllableCalculator.countLonelyVowels(word);
                for(int i = 0; i < syllables; i++) {
                    s.append(sentenceScale.get(new Random().nextInt(sentenceScale.size())));
                    switch(syllables) {
                        case 1 -> s.append("h");
                        case 3 -> s.append("i");
                        case 4 -> s.append("s");
                        case 5,6,7,8,9,10 -> s.append("t");
                    }
                    s.append(" ");
                }

                log.info(word + " -> " + syllables);
            });
            s.append("Rw | "); // Rw - Rest whole
        });

        log.info("Document: " + s.toString());
        return s.toString();
    }
}
