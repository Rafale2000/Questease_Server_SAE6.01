package fr.uphf.questease.controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.*;

/**
 * Classe Lobby qui represente l'ecran ou les joueurs se rejoignent.
 */
public class Lobby {

    /**
     * Nom du Lobby.
     */
    private final String nom;

    /**
     * Utilisateur numero 1, qui fonde le Lobby.
     */
    private User p1;

    /**
     * Utilisateur numero 2, qui rejoint le Lobby.
     */
    private User p2;

    /**
     * Liste des jeux qui peuvent apparaitre dans la partie.
     */
    private final ArrayList<String> lobbyGames;

    /**
     * Chiffre indiquant la difficulte d'un Lobby, choisie par l'Utilisateur numerp 1.
     */
    private int difficulty;

    /**
     * Constructeur de la classe Lobby.
     * @param user l'host du lobby et aussi le createur.
     * @param nom nom du lobby.
     */
    public Lobby(User user, String nom, int difficulty) {
        this.nom = nom;
        this.p1 = user;
        this.p2 = null;
        this.difficulty = difficulty;
        ArrayList<String> possiblegames = new ArrayList<>(Arrays.asList("prix_juste", "pendu", "rotating_pictures", "menteur", "son"));
        Map<String,Integer> possiblegamesDict = new Hashtable<>();
        possiblegamesDict.put("prix_juste", 1);
        possiblegamesDict.put("pendu", 1);
        possiblegamesDict.put("rotating_pictures", 2);
        possiblegamesDict.put("menteur", 3);
        possiblegamesDict.put("son", 3);
        this.lobbyGames = getLobbyGames(possiblegamesDict,difficulty);
        System.out.println("je vais faire le lobby"+nom+" de difficulty "+difficulty);
    }

    /**
     * Renvoie le prochain jeu.
     * @return Le Prochain jeu.
     */
    public String getNextGame(){
        if(lobbyGames.isEmpty()){
            return "";
        } else{
            this.lobbyGames.remove(0);
        }
        return this.lobbyGames.get(0);
    }

    /**
     * Ajoute un user au lobby.
     * @param user second joueur du lobby.
     */
    private void addplayer(User user){
        this.p2 = user;
    }

    /**
     * Envoie un message aux 2 joueurs.
     * @param message message a envoyer aux joueurs.
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
     * Renvoie les Jeux du Lobby.
     * @param possiblegames Tous les Jeux possibles du Lobby.
     * @param difficulty La difficulte du Lobby.
     * @return Une ArrayList contenant tous les Jeux du Lobby.
     */
    private ArrayList<String> getLobbyGames(Map<String,Integer> possiblegames, int difficulty){
        ArrayList<String> filteredGames = new ArrayList<>();
        ArrayList<String> probabilityList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : possiblegames.entrySet()) {
            if (entry.getValue() == difficulty) {
                for(int x = 0;x<30;x++){
                    probabilityList.add(entry.getKey());
                }
            } else if (Math.abs(entry.getValue() - difficulty) >=2 ) {
                for(int x=0;x<10;x++){
                    probabilityList.add(entry.getKey());
                }
            } else if (Math.abs(entry.getValue() - difficulty) == 1) {
                for (int x=0;x<20;x++){
                    probabilityList.add(entry.getKey());
                }
            }
        }
        Random random = new Random();
        while(filteredGames.size()< 4){
            int index = random.nextInt(0, probabilityList.size());
            String game = probabilityList.get(index);
            filteredGames.add(game);
            probabilityList = clearProbabilityList(probabilityList,game);

        }
        return filteredGames;
    }

    /**
     *
     * @param probabilities
     * @param game
     * @return
     */
    private ArrayList<String> clearProbabilityList(ArrayList<String> probabilities,String game){
        ArrayList<String> filteredProbabilities = new ArrayList<>();
        for (String probability : probabilities){
            if (!probability.equals(game)){
                filteredProbabilities.add(probability);
            }
        }
        return filteredProbabilities;
    }

    /**
     * Renvoie le nom de la partie.
     * @return String nom de la partie.
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Renvoie le premier Utilisateur.
     * @return Le permier Utilisateur.
     */
    public User getp1(){
        return this.p1;
    }

    /**
     * Renvoie le second Utilisateur.
     * @return Le second Utilisateur.
     */
    public User getp2(){
        return this.p2;
    }

    /**
     * Modifie le second Utilisateur.
     * @param user L'Utilisateur a modifier.
     */
    public void setp2(User user){
        this.p2 = user;
    }

    /**
     * Modifie le premier Utilisateur.
     * @param user L'Utilisateur a modifier.
     */
    public void setp1(User user){
        this.p1 = user;
    }

    /**
     * Renvoie la difficulte du Lobby.
     * @return La difficulte du Lobby.
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Renvoie l'Utilisateur sous forme de String.
     * @return L'Utilisateur sous forme de String.
     */
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
