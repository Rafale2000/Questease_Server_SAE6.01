package fr.uphf.questease.model;

public class WebSocketMessage {
    private String tag;
    private String message;

    // Constructeurs
    public WebSocketMessage() {}
    public WebSocketMessage(String tag, String message) {
        this.tag = tag;
        this.message = message;
    }

    // Getters et Setters
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
