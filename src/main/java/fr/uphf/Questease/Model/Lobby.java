package fr.uphf.Questease.Model;

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
    private String nom; //nom du lobby
    private User p1; //joueur 1 aussi le host
    private User p2; //joueur 2
    private ArrayList<String> lobbyGames; // list des jeux

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
        ArrayList<String> possibleGames = new ArrayList<String>();
        //possibleGames.addAll(Arrays.asList("pendu","prix_juste","rotating_pictures","menteur","cryptex"));
        possibleGames.addAll(Arrays.asList("prix_juste"));
        this.lobbyGames= new ArrayList<>();
        Collections.shuffle(possibleGames);
        /*for(int x=0;x<3;x++){
            this.lobbyGames.add(possibleGames.get(x));
        }*/
        this.lobbyGames.addAll(possibleGames);
    }

    /**
     *Renvoie le prochain jeu
     * @return
     */
    public String getNextGame(){
        return this.lobbyGames.get(0);
    }

    /**
     *Ajoute un jour dans le lobby
     * @param user joueur à ajouter à la partie
     */
    private void addplayer(User user){
        this.p2 = user;
    }

    /**
     *Envoie un message au 2 joueur
     * @param message message a envoyer au joueurs
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
     * Renvoie les sessions des joueurs connecté au lobby
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

    /**
     * Renvoie le second Joueur
     * @return User p2
     */
    public User getp2(){

        return this.p2;
    }

    /**
     * Modifie les valeur du second joueur
     * @param user  user
     */
    public void setp2(User user){
        this.p2 = user;
    }

    /**
     * Modifie les valeur du second joueur
     * @param user  user
     */
    public void setp1(User user){
        this.p1 = user;
    }

    /**
     * Renvoie sous forme de string les valeurs contenu dans le lobby.
     * @return Str
     */
    @Override
    public String toString() {
        return "Lobby{" +
                "nom='" + nom + '\'' +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", lobbyGames=" + lobbyGames +
                '}';
    }
}
