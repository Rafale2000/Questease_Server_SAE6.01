package fr.uphf.Questease.Model;

import org.springframework.web.socket.WebSocketSession;

/**
 * Classe représentant un utilisateur associé à une session WebSocket.
 */
public class User {
    private String nom;
    private WebSocketSession session;

    /**
     * Constructeur permettant d'initialiser l'utilisateur avec un nom et une session WebSocket.
     *
     * @param nom     Le nom de l'utilisateur.
     * @param session La session WebSocket associée.
     */
    public User(String nom, WebSocketSession session) {
        this.nom = nom;
        this.session = session;
    }
    /**
     * Getter pour récupérer le nom de l'utilisateur.
     *
     * @return Le nom de l'utilisateur (String).
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter pour définir le nom de l'utilisateur.
     *
     * @param nom Le nouveau nom de l'utilisateur (String).
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Constructeur permettant d'initialiser l'utilisateur uniquement avec une session WebSocket.
     * Le nom de l'utilisateur est initialisé à null.
     *
     * @param session La session WebSocket associée.
     */
    public User(WebSocketSession session) {
        this.session = session;
        this.nom = null;
    }

    /**
     * Getter pour récupérer la session WebSocket associée à l'utilisateur.
     *
     * @return La session WebSocket (WebSocketSession).
     */
    public WebSocketSession getSession() {
        return session;
    }
}


