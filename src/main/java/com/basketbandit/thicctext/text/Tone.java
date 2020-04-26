package com.basketbandit.thicctext.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "score",
        "tone_id",
        "tone_name"
})
public class Tone {
    @JsonProperty("score")
    private Double score;
    @JsonProperty("tone_id")
    private String toneId;
    @JsonProperty("tone_name")
    private String toneName;

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("tone_id")
    public String getToneId() {
        return toneId;
    }

    @JsonProperty("tone_name")
    public String getToneName() {
        return toneName;
    }
}
