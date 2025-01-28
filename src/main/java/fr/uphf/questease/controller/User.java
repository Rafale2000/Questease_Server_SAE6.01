package fr.uphf.questease.controller;

import org.springframework.web.socket.WebSocketSession;

public class User {
    private String nom;
    private WebSocketSession session;

    public User(String nom, WebSocketSession session) {
        this.nom = nom;
        this.session = session;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public User(WebSocketSession session) {
        this.session = session;
        this.nom = null;
    }

    public WebSocketSession getSession() {
        return session;
    }
}
