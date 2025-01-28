package fr.uphf.questease.controller;

import org.springframework.web.socket.WebSocketSession;

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

    /**
     * Classe représentant un utilisateur associé à une session WebSocket.
     */
    public static class User {
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
}
