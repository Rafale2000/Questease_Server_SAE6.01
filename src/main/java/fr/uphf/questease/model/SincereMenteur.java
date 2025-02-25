package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Represente les reponse des joueurs dans Sincere-Menteur.
 */
@Entity
@Table(name = "sincerementeur")
public class SincereMenteur {

    /**
     * id des reponse donnees.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idsincerementeur")
    private long id;

    /**
     * Represente l'id des joueurs.
     */
    @Column(name = "idjoueur", unique = true,nullable = false)
    private int joueur;

    /**
     * Represente la premiere reponse d'un joueur.
     */
    @Column(name = "reponse1")
    private boolean reponse1;

    /**
     * Represente la seconde reponse d'un joueur.
     */
    @Column(name = "reponse2")
    private boolean reponse2;


    /**
     * Getter pour recuperer l'ID de l'objet.
     * @return L'identifiant unique (long).
     */
    public long getId() {
        return id;
    }

    /**
     * Getter pour recuperer l'identifiant du joueur.
     * @return L'identifiant du joueur (int).
     */
    public int getJoueur() {
        return joueur;
    }

    /**
     * Getter pour verifier si la premiere reponse est valide.
     * @return True si la premiere reponse est valide, sinon false.
     */
    public boolean isReponse1() {
        return reponse1;
    }

    /**
     * Getter pour verifier si la deuxieme reponse est valide.
     * @return True si la deuxieme reponse est valide, sinon false.
     */
    public boolean isReponse2() {
        return reponse2;
    }

    /**
     * Setter pour definir la valeur de la premiere reponse.
     * @param reponse1 La nouvelle valeur pour la premiere reponse (boolean).
     */
    public void setReponse1(boolean reponse1) {
        this.reponse1 = reponse1;
    }

    /**
     * Setter pour definir l'identifiant du joueur.
     * @param joueur La nouvelle valeur de l'identifiant du joueur (int).
     */
    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    /**
     * Setter pour definir la valeur de la deuxieme reponse.
     * @param reponse2 La nouvelle valeur pour la deuxieme reponse (boolean).
     */
    public void setReponse2(boolean reponse2) {
        this.reponse2 = reponse2;
    }
}
