/*package fr.uphf.Questease.Controller;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class GameWebSocketHandler extends TextWebSocketHandler {
    // Ensemble de sessions actives
    private final Set<WebSocketSession> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Nouvelle connexion : " + session.getId());
        // Ajoutez un log ici pour confirmer l'ajout de la session
        System.out.println("Session ajoutée. Nombre total de sessions : " + sessions.size());
    }

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) {
        // Log pour chaque message reçu
        System.out.println("Message reçu de la session " + session.getId() + ": " + message.getPayload());

        // Envoyer le message à toutes les sessions ouvertes
        synchronized (sessions) {
            for (WebSocketSession s : sessions) {
                try {
                    if (s.isOpen()) {
                        s.sendMessage(message);
                        System.out.println("Message envoyé à la session " + s.getId());
                    }
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'envoi du message à la session " + s.getId());
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Connexion fermée : " + session.getId());
        // Ajoutez un log ici pour confirmer la fermeture
        System.out.println("Session retirée. Nombre total de sessions restantes : " + sessions.size());
    }
}*/
