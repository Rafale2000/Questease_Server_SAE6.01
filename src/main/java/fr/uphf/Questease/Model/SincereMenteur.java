package fr.uphf.Questease.Model;

import jakarta.persistence.*;

/**
 * Représente les réponse des joueurs dans Sincère-Menteur
 */
@Entity
@Table
public class SincereMenteur {

    /**
     * id des réponse donnèes
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsincerementeur")
    private long id;

    /**
     * Représente l'id des joueurs
     */
    @Column(name = "idjoueur", unique = true,nullable = false)
    private int joueur;
    /**
     * Représente la première réponse d'un joueur
     */

    @Column(name = "reponse1")
    private boolean reponse1;

    /**
     * Représente la seconde réponse d'un joueur
     */

    @Column(name = "reponse2")
    private boolean reponse2;


    public long getId() {
        return id;
    }

    public int getJoueur() {
        return joueur;
    }

    public boolean isReponse1() {
        return reponse1;
    }

    public boolean isReponse2() {
        return reponse2;
    }

    public void setReponse1(boolean reponse1) {
        this.reponse1 = reponse1;
    }

    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    public void setReponse2(boolean reponse2) {
        this.reponse2 = reponse2;
    }
}
