package fr.uphf.questease.controller;

import org.springframework.web.socket.WebSocketSession;

/**
 *
 */
public class User {

    /**
     *
     */
    private String nom;

    /**
     *
     */
    private WebSocketSession session;

    /**
     *
     * @param nom
     * @param session
     */
    public User(String nom, WebSocketSession session) {
        this.nom = nom;
        this.session = session;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param session
     */
    public User(WebSocketSession session) {
        this.session = session;
        this.nom = null;
    }

    /**
     *
     * @return
     */
    public WebSocketSession getSession() {
        return session;
    }
}
