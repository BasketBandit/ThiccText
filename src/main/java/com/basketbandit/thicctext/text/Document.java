package com.basketbandit.thicctext.text;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "document_tone",
        "sentences_tone"
})
public class Document {
    @JsonProperty("document_tone")
    private DocumentTone documentTone;
    @JsonProperty("sentences_tone")
    private List<Sentence> sentences;

    @JsonProperty("document_tone")
    public DocumentTone getDocumentTone() {
        return documentTone;
    }

    @JsonProperty("sentences_tone")
    public List<Sentence> getSentences() {
        return sentences;
    }

    @JsonProperty("sentences_tone")
    public void setSentenceTone(List<Sentence> sentences) {
        this.sentences = sentences;
    }
}
