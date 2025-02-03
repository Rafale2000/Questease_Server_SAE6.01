package fr.uphf.questease.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class WebSocketMessage {
    private String tag;
    private String message;
    private int difficulty = 0;

    // Constructeurs
    public WebSocketMessage() {}

    public WebSocketMessage(String tag, String message, int difficulty) {
        this.tag = tag;
        this.message = message;
        this.difficulty = difficulty;
    }

    public WebSocketMessage(String tag, String message) {
        this.tag = tag;
        this.message = message;
    }

    // Getters et Setters
    public String getTag() { return tag; }
    public void setTag(String tag) { this.tag = tag; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public int getDifficulty() {
        return (difficulty != 0) ? difficulty : 1;
    }
}
