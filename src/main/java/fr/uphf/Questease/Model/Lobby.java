package fr.uphf.Questease.Model;

import fr.uphf.Questease.Model.User;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Lobby {
    /*private static int counter = 0;
    private final int id;
    */
    private String nom;
    private User p1;
    private User p2;
    private ArrayList<String> lobbyGames;


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

    public String getNextGame(){
        return this.lobbyGames.get(0);
    }
    private void addplayer(User user){
        this.p2 = user;
    }
    private void sendtoplayers(String message) throws IOException {
        TextMessage content = new TextMessage(message);
        WebSocketSession webSocketSession1 = p1.getSession();
        webSocketSession1.sendMessage(content);
        WebSocketSession webSocketSession2 = p1.getSession();
        webSocketSession2.sendMessage(content);
    }
    private ArrayList<WebSocketSession> getplayers(){
        ArrayList<WebSocketSession> playerlist = new ArrayList<>();
        return playerlist;
    }
    public String getNom(){
        return this.nom;
    }

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
                ", lobbyGames=" + lobbyGames +
                '}';
    }
}
