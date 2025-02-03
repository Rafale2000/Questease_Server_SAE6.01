package fr.uphf.questease.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.uphf.questease.model.DatabaseManager;

import fr.uphf.questease.model.Mot;
import fr.uphf.questease.model.WebSocketMessage;
import fr.uphf.questease.repository.MotRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.TextMessage;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class WebSocketHandlerImpl implements WebSocketHandler {
    private final ArrayList<Lobby> lobbies;
    private final ArrayList<User> users;
    private static final Logger logger = LoggerFactory.getLogger(WebSocketHandlerImpl.class);
    @Autowired
    private MotRepository motRepository;

    public WebSocketHandlerImpl() {
        logger.info("WebSocketHandlerImpl chargé et prêt.");
        this.lobbies = new ArrayList<>();
        this.users = new ArrayList<>();
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession session){
        logger.info("Connexion WebSocket établie: {}", session.getId());
        User user = new User(session);
        this.users.add(user);
    }
    @Override
    public void handleMessage(WebSocketSession session, org.springframework.web.socket.WebSocketMessage<?> message) {
        DatabaseManager databaseManager = new DatabaseManager();

        logger.info("Message reçu: {}",  message.getPayload());
        ObjectMapper objectMapper = new ObjectMapper();
        WebSocketMessage responseMessage;
        String responseJson;
        try {
            WebSocketMessage receivedMessage = objectMapper.readValue(message.getPayload().toString(), WebSocketMessage.class);
            logger.info("Tag: {}", receivedMessage.getTag());
            logger.info("Message: {}",receivedMessage.getMessage());
            String tag = receivedMessage.getTag();
            String lemessage = receivedMessage.getMessage();
            if(tag.equals("gameupdate")) {
                logger.info("Mise à jour de jeu : {}", lemessage);
                responseMessage = new WebSocketMessage("ack", "Message reçu avec succès");
                responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            }
            else if(tag.equals("requestLobbies")) {
                logger.info("requête de la liste des lobby");
                Map<String,Integer> lobbies = new HashMap<>();

                //this.lobbies.add(new Lobby(identifyUserBySession(session),"lobbytest"));
                for(Lobby lobby : this.lobbies) {
                    lobbies.put(lobby.getNom(),lobby.getDifficulty());
                }
                String contentJson = objectMapper.writeValueAsString(lobbies);
                responseMessage = new WebSocketMessage("Lobbylist",contentJson);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
                logger.info("message envoyé");
            }
            else if(tag.equals("createLobby")) {

                boolean found = false;
                for (Lobby lobby : this.lobbies) {
                    if (lobby.getNom().equals(lemessage)) {
                        responseMessage = new WebSocketMessage("info","nom déja utilisé");
                        responseJson = objectMapper.writeValueAsString(responseMessage);
                        session.sendMessage(new TextMessage(responseJson));
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    this.lobbies.add(new Lobby(identifyUserBySession(session),lemessage,receivedMessage.getDifficulty()));
                    responseMessage = new WebSocketMessage("info","Lobby crée");
                    responseJson = objectMapper.writeValueAsString(responseMessage);
                    session.sendMessage(new TextMessage(responseJson));
                }
            }
            else if(tag.equals("setP2Name")) {
                Lobby lobby = findlobbybyplayer(session);

                assert lobby != null;
                User p1 = lobby.getp1();
                WebSocketSession sessionp1 = p1.getSession();
                lobby.getp2().setNom(lemessage);
                WebSocketMessage webSocketMessage = new WebSocketMessage("setP2Name", lemessage);
                responseJson = objectMapper.writeValueAsString(webSocketMessage);
                sessionp1.sendMessage(new TextMessage(responseJson));
            }
            else if (tag.equals("joinLobby")) {
                Lobby lobby = findlobbybyname(lemessage);
                if(lobby != null && lobby.getp2() == null) {
                    lobby.setp2(identifyUserBySession(session));
                    responseMessage = new WebSocketMessage("lobbyJoined",lobby.getp1().getNom());
                }
                else{
                    responseMessage = new WebSocketMessage("LobbyRejected","Lobby introuvable ou plein");
                }
                responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
                assert lobby != null;
                logger.info(lobby.toString());
            } else if (tag.equals("destroyLobby")) {
                Lobby lobby = findlobbybyname(lemessage);
                if (lobby != null) {
                    this.lobbies.remove(lobby);
                    responseMessage = new WebSocketMessage("info","Lobby supprimé");
                } else {
                    responseMessage = new WebSocketMessage("info","Lobby introuvable");
                }
                responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            } else if(tag.equals("setnom")){
                logger.info("j'ai reçu un message setnom");
                String query = "SELECT nom FROM utilisateur WHERE nom = ?";
                List<String> utilisateurs = databaseManager.getValuesFromColumn(query, lemessage);
                logger.info("j'ai fait ma requête "+utilisateurs.size());
                if(!utilisateurs.isEmpty() || findUser(lemessage) != null) {
                    responseMessage = new WebSocketMessage("setnom","un utilisateur possède déja ce nom");
                }
                else{
                    responseMessage = new WebSocketMessage("setnom","success");
                    User user = identifyUserBySession(session);
                    assert user != null;
                    user.setNom(lemessage);
                }
                responseJson = objectMapper.writeValueAsString(responseMessage);
                session.sendMessage(new TextMessage(responseJson));
            } else if (tag.equals("leaveLobby")) {
                User user = identifyUserBySession(session);
                if(findlobbybyname(lemessage) != null){
                    Lobby lobby = findlobbybyname(lemessage);
                    assert lobby != null;
                    logger.info(lobby.toString());
                    if (lobby.getp1() == user){
                        WebSocketSession webSocketSession1  = null;
                        if(lobby.getp2()!=null){
                            webSocketSession1 = lobby.getp2().getSession();
                        }
                        responseMessage = new WebSocketMessage("p1Leaved",lobby.getp1().getNom());
                        responseJson = objectMapper.writeValueAsString(responseMessage);
                        if (webSocketSession1!= null){
                            webSocketSession1.sendMessage(new TextMessage(responseJson));
                        }
                        this.lobbies.remove(lobby);
                    } else if (lobby.getp2() != null && lobby.getp2() == user) {
                        WebSocketSession webSocketSession2 = lobby.getp1().getSession();
                        responseMessage = new WebSocketMessage("p2Leaved",lobby.getp2().getNom());
                        responseJson = objectMapper.writeValueAsString(responseMessage);
                        webSocketSession2.sendMessage(new TextMessage(responseJson));
                        lobby.setp2(null);
                        logger.info(lobby.toString());
                    }
                    if (lobby.getp2() == null && lobby.getp1() == null){
                        lobbies.remove(lobby);
                    }
                    assert user != null;
                    user.setNom(null);
                    responseMessage = new WebSocketMessage("lobbyLeaved","");
                    responseJson = objectMapper.writeValueAsString(responseMessage);
                    session.sendMessage(new TextMessage(responseJson));

                }
            } else if ("ready".equals(tag)) {
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                WebSocketSession session2 = null;
                assert lobby != null;
                if(sourceUser == lobby.getp1()){
                    User user2 = lobby.getp2();
                    session2 = user2.getSession();

                } else if (sourceUser == lobby.getp2()) {
                    User user2 = lobby.getp1();
                    session2 = user2.getSession();
                }
                responseMessage = new WebSocketMessage("playerReady", lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                assert session2 != null;
                session2.sendMessage(new TextMessage(responseJson));
            }
            else if("startGame".equals(tag)){
                Lobby lobby  = findlobbybyplayer(session);
                assert lobby != null;
                WebSocketSession session1 = lobby.getp1().getSession();
                WebSocketSession session2 = lobby.getp2().getSession();
                String nextgame = lobby.getNextGame();
                String nextgame1 = nextgame+"1";
                String nextgame2 = nextgame+"2";
                WebSocketMessage responseMessage1 = new WebSocketMessage("startActivity",nextgame1);
                WebSocketMessage responseMessage2 = new WebSocketMessage("startActivity",nextgame2);
                String responseJson1 = objectMapper.writeValueAsString(responseMessage1);
                String responseJson2 = objectMapper.writeValueAsString(responseMessage2);
                logger.info("j'envoie {}",responseJson1+" au joueur "+lobby.getp1().getNom());
                session1.sendMessage(new TextMessage(responseJson1));
                logger.info("j'envoie {} au joueur {}",responseJson2,lobby.getp2().getNom());
                session2.sendMessage(new TextMessage(responseJson2));

                // Dans le cas où les deux ont la même activity, on envoie au j1 l'initiative
                WebSocketMessage responseMessage3 = new WebSocketMessage("beginGame", "");
                String responseJson3 = objectMapper.writeValueAsString(responseMessage3);

                try {
                    // Introduire un délai de 1 seconde
                    Thread.sleep(1000);
                    session1.sendMessage(new TextMessage(responseJson3));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restaurer l'état d'interruption
                    logger.info("Le délai avant l'envoi a été interrompu : {}",e.getMessage());
                }

            }
            //Fonctions pour le jeu Rotating Pictures
            else if ("RotatingPicOrientation".equals(tag)) {
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("RotatingPicOrientation",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            } else if ("PenduTry".equals(tag)) {
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("PenduTry",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            } else if ("getRandomMot".equals(tag)) {
                Lobby lobby = findlobbybyplayer(session);
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                WebSocketSession session1 = user1.getSession();
                WebSocketSession session2 = user2.getSession();
                if(lobby.getp1().getSession() == session){
                    try {
                        Optional<Mot> motOpt = motRepository.findRandomMot();
                        if (motOpt.isPresent()) {
                            Mot mot = motOpt.get();
                            responseMessage = new WebSocketMessage("setWord", mot.getTexte());
                        } else {
                            responseMessage = new WebSocketMessage("setWord", "Aucun mot trouvé");
                        }
                        String responseJson2 = objectMapper.writeValueAsString(responseMessage);

                        // Planifier l'envoi avec un délai de 2 secondes
                        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
                        scheduler.schedule(() -> {
                            try {
                                session1.sendMessage(new TextMessage(responseJson2));
                                session2.sendMessage(new TextMessage(responseJson2));
                            } catch (Exception e) {
                                logger.error("impossible d'envoyer un message aux sessions", e);
                            }
                        }, 2, TimeUnit.SECONDS);

                    } catch (Exception e) {
                        logger.error("aled", e);
                        responseMessage = new WebSocketMessage("error", "Erreur lors de l'accès à la base de données");
                        responseJson = objectMapper.writeValueAsString(responseMessage);
                        session.sendMessage(new TextMessage(responseJson));
                    }
                }
            }
            else if("successPopup".equals(tag)){
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("successPopup",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            } else if("showTip".equals(tag)){
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("showTip",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            }
            else if ("PrixJusteTry".equals(tag)) {
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("PrixJusteTry",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            } else if ("TrouveLeSonMessage".equals(tag)) {
                User sourceUser = identifyUserBySession(session);
                assert sourceUser != null;
                Lobby lobby = findlobbybyplayer(sourceUser.getSession());
                assert lobby != null;
                User user1 = lobby.getp1();
                User user2 = lobby.getp2();
                responseMessage = new WebSocketMessage("TrouveLeSonMessage",lemessage);
                responseJson = objectMapper.writeValueAsString(responseMessage);
                if(user1.equals(sourceUser)){
                    user2.getSession().sendMessage(new TextMessage(responseJson));
                }
                else if(user2.equals(sourceUser)){
                    user1.getSession().sendMessage(new TextMessage(responseJson));
                }
            }

            //info marqueur saé 6.01

        } catch (Exception e) {
            logger.error("erreur", e);
            try {
                session.sendMessage(new TextMessage("Erreur lors du traitement du message JSON."));
            } catch (Exception sendException) {
                logger.error("erreur lors du traitement du message", e);
            }
        }
    }
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) {
        logger.error("erreur", exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) {
        logger.info("Connexion WebSocket fermée: {}",session.getId());
        Lobby lobby = findlobbybyplayer(session);
        if (lobby != null) {
            logger.info("Lobby {}",lobby.getNom()+" fermé");
            this.lobbies.remove(lobby);
        }
        try{
            User user = identifyUserBySession(session);
            users.remove(user);}
        catch (Exception e){
            logger.info("la session n'avais pas défini de user");
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
