package fr.uphf.questease.model;

import jakarta.persistence.*;


/**
 * Représente la liste des résultat d'une partie de l'utilisateur
 */
@Entity
@Table(name = "Resultat")
public class Resultat {

    /**
     * L'id de la partie auquel sont liés les résultats
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartie")
    private Long idPartie;

    /**
     * Le booléan représentant si l'utilisateur a battu le jeu au cours de cette partie
     */
    @Column(name = "isEpreuve1", nullable = false)
    private boolean isEpreuve1;

    /**
     * Le booléan représentant si l'utilisateur a battu le mini-jeu du Cryptex
     */
    @Column(name = "isEpreuve2", nullable = false)
    private boolean isEpreuve2;

    /**
     * Le booléan représentant si l'utilisateur a battu le mini-jeu du pendu
     */
    @Column(name = "isEpreuve3", nullable = false)
    private boolean isEpreuve3;

    /**
     * Le booléan représentant si l'utilisateur a battu le mini-jeu du devinez le son
     */
    @Column(name = "isEpreuve4", nullable = false)
    private boolean isEpreuve4;

    /**
     * L'utilisateur auquel sont lié les résultats
     */
    @ManyToOne
    @JoinColumn(name = "idutilisateur", nullable = false)
    private Utilisateur utilisateur;

    /**
     * Le getter de l'id de la partie
     * @return L'id de la partie
     */
    public Long getIdPartie() {
        return idPartie;
    }

    /**
     * Méthode Getter renvoyant le booléan correspondant à une victoire sur le cryptex ou non
     * @return Un booléan correspondant à une victoire sur le cryptex ou non
     */
    public boolean isEpreuve1() {
        return isEpreuve1;
    }

    /**
     * Méthode Getter renvoyant le booléan correspondant à une victoire sur le pendu ou non
     * @return Un booléan correspondant à une victoire sur le pendu ou non
     */
    public boolean isEpreuve2() {
        return isEpreuve2;
    }

    /**
     * Méthode Getter renvoyant le booléan correspondant à une victoire sur le jeu du son ou non
     * @return Un booléan correspondant à une victoire sur le jeu du son ou non
     */
    public boolean isEpreuve3() {
        return isEpreuve3;
    }

    /**
     * Méthode Getter renvoyant le booléan correspondant à une victoire sur le cryptex ou non
     * @return Un booléan correspondant à une victoire sur le prix juste ou non
     */
    public boolean isEpreuve4() {
        return isEpreuve4;
    }

    /**
     * Le getter de l'utilisateur lié à la partie
     * @return L'utilisateur lié à la partie
     */
    public Utilisateur getJoueurTmp() {
        return utilisateur;
    }
}