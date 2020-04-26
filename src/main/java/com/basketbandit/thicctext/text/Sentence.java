package com.basketbandit.thicctext.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sentence_id",
        "text",
        "tones"
})
public class Sentence {
    @JsonProperty("sentence_id")
    private Integer sentenceId;
    @JsonProperty("text")
    private String text;
    @JsonProperty("tones")
    private List<Tone> tones;

    @JsonProperty("sentence_id")
    public Integer getSentenceId() {
        return sentenceId;
    }

    @JsonProperty("sentence_id")
    public void setSentenceId(Integer sentenceId) {
        this.sentenceId = sentenceId;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("tones")
    public List<Tone> getTones() {
        return tones;
    }

    @JsonProperty("tones")
    public void setTones(List<Tone> tones) {
        this.tones = tones;
    }
}
