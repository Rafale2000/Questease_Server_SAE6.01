package fr.uphf.Questease.Controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
/**
 * Classe Lobby qui est utilisé dans l'application
 */
public class Lobby {
    /*private static int counter = 0;
    private final int id;
    */
    private String nom;
    private User p1;
    private User p2;
    private ArrayList<String> lobbyGames;
    /**
     * Constructeur de la classe Lobby
     * @param user l'host du lobby et aussi le créateur
     * @param nom nom du lobby
     */

    public Lobby(User user,String nom) {
        //this.id = (++counter);
        this.nom = nom;
        this.p1 = user;
        this.p2 = null;
        ArrayList<String> possiblegames = new ArrayList<String>();
        possiblegames.addAll(Arrays.asList("prix_juste","pendu","rotating_pictures","menteur","son"));

        this.lobbyGames= new ArrayList<>();
        Collections.shuffle(possiblegames);
        for(int x=0;x<2;x++){
            this.lobbyGames.add(possiblegames.get(x));
        }

        this.lobbyGames.add("gyroscope");
        this.lobbyGames.add("endActivity");
        this.lobbyGames.addAll(possiblegames);
    }

    /**
     *Renvoie le prochain jeu
     * @return
     */
    public String getNextGame(){
        if(lobbyGames.size()==0){
            return "";
        }
        String game = this.lobbyGames.get(0);
        if(!lobbyGames.isEmpty()){
            this.lobbyGames.remove(0);
        }
        return game;
    }
    private void addplayer(User user){
        this.p2 = user;
    }
    /**
     *Envoie un message aux 2 joueurs
     * @param message message a envoyer aux joueurs
     * @throws IOException
     */
    private void sendtoplayers(String message) throws IOException {
        TextMessage content = new TextMessage(message);
        WebSocketSession webSocketSession1 = p1.getSession();
        webSocketSession1.sendMessage(content);
        WebSocketSession webSocketSession2 = p1.getSession();
        webSocketSession2.sendMessage(content);
    }

    /**
     * Renvoie les sessions des joueurs connectés au lobby
     * @return
     */
    private ArrayList<WebSocketSession> getplayers(){
        ArrayList<WebSocketSession> playerlist = new ArrayList<>();
        return playerlist;
    }

    /**
     *Renvoie le nom de la partie
     * @return String nom de la partie
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Renvoie le premier Joueur
     * @return User host
     */
    public User getp1(){
        return this.p1;
    }
    public User getp2(){
        return this.p2;
    }
    public void setp2(User user){
        this.p2 = user;
    }
    public void setp1(User user){
        this.p1 = user;
    }
    @Override
    public String toString() {
        return "Lobby{" +
                "nom='" + nom + '\'' +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", lobbygames=" + lobbyGames +
                '}';
    }
}
