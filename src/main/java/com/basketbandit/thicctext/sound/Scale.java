package com.basketbandit.thicctext.sound;

import java.util.ArrayList;
import java.util.HashMap;

public class Scale {
    private final HashMap<String, ArrayList<String[]>> tones = new HashMap<>();

    public Scale() {
        ArrayList<String[]> anger = new ArrayList<>();
        anger.add(new String[]{"C4", "D4", "Eb4", "G4", "C5"});
        tones.put("Anger", anger);

        ArrayList<String[]> fear = new ArrayList<>();
        tones.put("Fear", fear);

        ArrayList<String[]> joy = new ArrayList<>();
        joy.add(new String[]{"C4", "D4", "E4", "G4", "A5", "C5"});
        tones.put("Joy", joy);

        ArrayList<String[]> sadness = new ArrayList<>();
        tones.put("Sadness", sadness);

        ArrayList<String[]> analytical = new ArrayList<>();
        tones.put("Analytical", analytical);

        ArrayList<String[]> confident = new ArrayList<>();
        tones.put("Confident", confident);

        ArrayList<String[]> tentative = new ArrayList<>();
        tones.put("Tentative", tentative);
    }

    public ArrayList<String[]> getScaleByTone(String tone) {
        return tones.get(tone);
    }
}
