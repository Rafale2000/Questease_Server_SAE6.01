package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Représente les réponse des joueurs dans Sincère-Menteur
 */
@Entity
@Table(name = "sincerementeur")
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


    /**
     * Getter pour récupérer l'ID de l'objet.
     *
     * @return L'identifiant unique (long).
     */
    public long getId() {
        return id;
    }

    /**
     * Getter pour récupérer l'identifiant du joueur.
     *
     * @return L'identifiant du joueur (int).
     */
    public int getJoueur() {
        return joueur;
    }

    /**
     * Getter pour vérifier si la première réponse est valide.
     *
     * @return True si la première réponse est valide, sinon false.
     */
    public boolean isReponse1() {
        return reponse1;
    }

    /**
     * Getter pour vérifier si la deuxième réponse est valide.
     *
     * @return True si la deuxième réponse est valide, sinon false.
     */
    public boolean isReponse2() {
        return reponse2;
    }

    /**
     * Setter pour définir la valeur de la première réponse.
     *
     * @param reponse1 La nouvelle valeur pour la première réponse (boolean).
     */
    public void setReponse1(boolean reponse1) {
        this.reponse1 = reponse1;
    }

    /**
     * Setter pour définir l'identifiant du joueur.
     *
     * @param joueur La nouvelle valeur de l'identifiant du joueur (int).
     */
    public void setJoueur(int joueur) {
        this.joueur = joueur;
    }

    /**
     * Setter pour définir la valeur de la deuxième réponse.
     *
     * @param reponse2 La nouvelle valeur pour la deuxième réponse (boolean).
     */
    public void setReponse2(boolean reponse2) {
        this.reponse2 = reponse2;
    }

}
