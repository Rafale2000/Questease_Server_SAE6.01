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




}
