
package fr.uphf.Questease.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.uphf.Questease.Model.Lobby;
import fr.uphf.Questease.Model.User;
import fr.uphf.Questease.Model.WebSocketMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.util.ArrayList;

@Component
public class WebSocketHandlerImpl implements WebSocketHandler {
    private ArrayList<Lobby> lobbies;
    private ArrayList<User> users;
    public WebSocketHandlerImpl() {
        System.out.println("WebSocketHandlerImpl chargé et prêt.");
        this.lobbies = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connexion WebSocket établie: " + session.getId());
        User user = new User(session);
        this.users.add(user);
    }
    @Override
    public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) {
        System.out.println("Message reçu: " + message.getPayload());
        ObjectMapper objectMapper = new ObjectMapper();
        WebSocketMessage responseMessage;
        try {
            WebSocketMessage receivedMessage = objectMapper.readValue(message.getPayload().toString(), WebSocketMessage.class);
            System.out.println("Tag: " + receivedMessage.getTag());
            System.out.println("Message: " + receivedMessage.getMessage());
            if ("gameupdate".equals(receivedMessage.getTag())) {
                System.out.println("Mise à jour de jeu : " + receivedMessage.getMessage());
                responseMessage = new WebSocketMessage("ack", "Message reçu avec succès");
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            }
            else if("requestLobbies".equals(receivedMessage.getTag())) {
                System.out.println("requête de la liste des lobby");
                ArrayList<String> content = new ArrayList<String>();
                //this.lobbies.add(new Lobby(identifyUserBySession(session),"lobbytest"));
                for(Lobby lobby : this.lobbies) {
                    content.add(lobby.getNom());}
                String contentJson = objectMapper.writeValueAsString(content);
                responseMessage = new WebSocketMessage("Lobbylist",contentJson);
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
                System.out.println("message envoyé");
            }
            else if("createLobby".equals(receivedMessage.getTag())) {
                boolean found = false;
                for (Lobby lobby : this.lobbies) {
                    if (lobby.getNom().equals(receivedMessage.getMessage())) {
                        responseMessage = new WebSocketMessage("info","nom déja utilisé");
                        String responseJson = objectMapper.writeValueAsString(responseMessage);
                        session.sendMessage(new TextMessage(responseJson));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    this.lobbies.add(new Lobby(identifyUserBySession(session),receivedMessage.getMessage()));
                    responseMessage = new WebSocketMessage("info","Lobby crée");
                    String responseJson = objectMapper.writeValueAsString(responseMessage);
                    session.sendMessage(new TextMessage(responseJson));
                }
            }
            else if("setP2Name".equals(receivedMessage.getTag())) {
                Lobby lobby = findlobbybyplayer(session);
                User p1 = lobby.getp1();
                WebSocketSession sessionp1 = p1.getSession();
                lobby.getp2().setNom(receivedMessage.getMessage());
                WebSocketMessage webSocketMessage = new WebSocketMessage("setP2Name", receivedMessage.getMessage());
                String responseJson = objectMapper.writeValueAsString(webSocketMessage);
                sessionp1.sendMessage(new TextMessage(responseJson));
            }
            else if ("joinLobby".equals(receivedMessage.getTag())) {
                Lobby lobby = findlobbybyname(receivedMessage.getMessage());
                if(lobby != null && lobby.getp2() == null) {
                    lobby.setp2(identifyUserBySession(session));
                    responseMessage = new WebSocketMessage("lobbyJoined",lobby.getp1().getNom());
                }
                else{
                    responseMessage = new WebSocketMessage("LobbyRejected","Lobby introuvable ou plein");
                }
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
                System.out.println(lobby.toString());
            } else if ("destroyLobby".equals(receivedMessage.getTag())) {
                Lobby lobby = findlobbybyname(receivedMessage.getMessage());
                if (lobby != null) {
                    this.lobbies.remove(lobby);
                    responseMessage = new WebSocketMessage("info","Lobby supprimé");
                } else {
                    responseMessage = new WebSocketMessage("info","Lobby introuvable");
                }
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            } else if("setnom".equals(receivedMessage.getTag())){
                System.out.println("j'ai reçu un message setnom");
                if(findUser(receivedMessage.getMessage()) != null){
                    responseMessage = new WebSocketMessage("setnom","le nom est déja utilisé");
                } else{
                    responseMessage = new WebSocketMessage("setnom","success");
                    User user = identifyUserBySession(session);
                    user.setNom(receivedMessage.getMessage());
                }
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            } else if ("leaveLobby".equals(receivedMessage.getTag())) {
                User user = identifyUserBySession(session);
                if(findlobbybyname(receivedMessage.getMessage()) != null){
                    Lobby lobby = findlobbybyname(receivedMessage.getMessage());
                    if (lobby.getp1() == user){
                        WebSocketSession webSocketSession1  = null;
                        if(lobby.getp2()!=null){
                            webSocketSession1 = lobby.getp2().getSession();
                        }
                        responseMessage = new WebSocketMessage("p1Leaved",lobby.getp1().getNom());
                        String responseJson = objectMapper.writeValueAsString(responseMessage);
                        if (webSocketSession1!= null){
                            webSocketSession1.sendMessage(new TextMessage(responseJson));
                        }
                        this.lobbies.remove(lobby);
                    } else if (lobby.getp2().getSession() == session) {
                        WebSocketSession webSocketSession2 = lobby.getp1().getSession();
                        responseMessage = new WebSocketMessage("p2Leaved",lobby.getp2().getNom());
                        String responsejson = objectMapper.writeValueAsString(responseMessage);
                        webSocketSession2.sendMessage(new TextMessage(responsejson));
                        lobby.setp2(null);
                    }
                    if (lobby.getp2() == null && lobby.getp1() == null){
                        lobbies.remove(lobby);
                    }
                    user.setNom(null);
                    responseMessage = new WebSocketMessage("lobbyLeaved","");
                    String responseJson = objectMapper.writeValueAsString(responseMessage);
                    session.sendMessage(new TextMessage(responseJson));

                }
            } else if ("ready".equals(receivedMessage.getTag())) {
                User sourceUser = identifyUserBySession(session);
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                WebSocketSession session2 = null;
                if(sourceUser == lobby.getp1()){
                    User user2 = lobby.getp2();
                    session2 = user2.getSession();

                } else if (sourceUser == lobby.getp2()) {
                    User user2 = lobby.getp1();
                    session2 = user2.getSession();
                }
                responseMessage = new WebSocketMessage("playerReady", receivedMessage.getMessage());
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                session2.sendMessage(new TextMessage(responseJson));
            }
            else if("startGame".equals(receivedMessage.getTag())){
                Lobby lobby  = findlobbybyplayer(session);
                WebSocketSession session1 = lobby.getp1().getSession();
                WebSocketSession session2 = lobby.getp2().getSession();
                String nextgame = lobby.getNextGame();
                String nextgame1 = nextgame+"1";
                String nextgame2 = nextgame+"2";
                WebSocketMessage responseMessage1 = new WebSocketMessage("startActivity",nextgame1);
                WebSocketMessage responseMessage2 = new WebSocketMessage("startActivity",nextgame2);
                String responseJson1 = objectMapper.writeValueAsString(responseMessage1);
                String responseJson2 = objectMapper.writeValueAsString(responseMessage2);
                System.out.println("j'envoie "+responseJson1+ " au joueur "+lobby.getp1().getNom());
                session1.sendMessage(new TextMessage(responseJson1));
                System.out.println("j'envoie "+responseJson2+ " au joueur "+lobby.getp2().getNom());
                session2.sendMessage(new TextMessage(responseJson2));
            }
            //Fonctions pour le jeu Rotating Pictures
            else if ("RotatingPicOrientation".equals(receivedMessage.getTag())) {
                User sourceUser = identifyUserBySession(session);
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("RotatingPicOrientation",receivedMessage.getMessage());
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            }
            else if("successPopup".equals(receivedMessage.getTag())){
                User sourceUser = identifyUserBySession(session);
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("successPopup",receivedMessage.getMessage());
                String responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            try {
                session.sendMessage(new TextMessage("Erreur lors du traitement du message JSON."));
            } catch (Exception sendException) {
                sendException.printStackTrace();
            }
        }
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        exception.printStackTrace();
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        System.out.println("Connexion WebSocket fermée: " + session.getId());
        Lobby lobby = findlobbybyplayer(session);
        if (lobby != null) {
            System.out.println("Lobby "+lobby.getNom()+" fermé");
            this.lobbies.remove(lobby);
        }
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

    private Lobby findlobbybyplayer(WebSocketSession session) {
        for (Lobby lobby : this.lobbies) {
            if ((lobby.getp1() != null && lobby.getp1().getSession() == session) ||
                    (lobby.getp2() != null && lobby.getp2().getSession() == session)) {
                return lobby;
            }
        }
        return null;
    }

    private Lobby findlobbybyname(String name){
        for (Lobby lobby : this.lobbies) {
            if (lobby.getNom().equals(name)) {
                return lobby;
            }
        }
        return null;
    }
    private User identifyUserBySession(WebSocketSession session){
        for (User user : this.users) {
            if (user.getSession().equals(session)) {
                return user;}
        }
        return null;
    }


    private User findUser(String username){
        for (User user : this.users) {
            if(user.getNom()!=null && user.getNom().equals(username)){
                return user;
            }
        }
        return null;
    }
}