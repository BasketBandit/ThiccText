package com.basketbandit.thicctext.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tones"
})
public class DocumentTone {
    @JsonProperty("tones")
    private List<Tone> tones;

    @JsonProperty("tones")
    public List<Tone> getTones() {
        return tones;
    }
}