package fr.uphf.questease.model;

import jakarta.persistence.*;


/**
 * Represente la liste des resultat d'une partie de l'utilisateur.
 */
@Entity
@Table(name = "Resultat")
public class Resultat {

    /**
     * L'id de la partie auquel sont lies les resultats.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPartie")
    private Long idPartie;

    /**
     * Le boolean representant si l'utilisateur a battu le jeu au cours de cette partie.
     */
    @Column(name = "isEpreuve1", nullable = false)
    private boolean isEpreuve1;

    /**
     * Le boolean representant si l'utilisateur a battu le mini-jeu du Cryptex.
     */
    @Column(name = "isEpreuve2", nullable = false)
    private boolean isEpreuve2;

    /**
     * Le boolean representant si l'utilisateur a battu le mini-jeu du pendu.
     */
    @Column(name = "isEpreuve3", nullable = false)
    private boolean isEpreuve3;

    /**
     * Le boolean representant si l'utilisateur a battu le mini-jeu du devinez le son.
     */
    @Column(name = "isEpreuve4", nullable = false)
    private boolean isEpreuve4;

    /**
     * L'utilisateur auquel sont lie les resultats.
     */
    @ManyToOne
    @JoinColumn(name = "idutilisateur", nullable = false)
    private Utilisateur utilisateur;

    /**
     * Le getter de l'id de la partie.
     * @return L'id de la partie.
     */
    public Long getIdPartie() {
        return idPartie;
    }

    /**
     * Methode Getter renvoyant le boolean correspondant a une victoire sur le cryptex ou non.
     * @return Un boolean correspondant a une victoire sur le cryptex ou non.
     */
    public boolean isEpreuve1() {
        return isEpreuve1;
    }

    /**
     * Methode Getter renvoyant le boolean correspondant a une victoire sur le pendu ou non.
     * @return Un boolean correspondant a une victoire sur le pendu ou non.
     */
    public boolean isEpreuve2() {
        return isEpreuve2;
    }

    /**
     * Methode Getter renvoyant le boolean correspondant a une victoire sur le jeu du son ou non.
     * @return Un boolean correspondant a une victoire sur le jeu du son ou non.
     */
    public boolean isEpreuve3() {
        return isEpreuve3;
    }

    /**
     * Methode Getter renvoyant le boolean correspondant a une victoire sur le cryptex ou non.
     * @return Un boolean correspondant a une victoire sur le prix juste ou non.
     */
    public boolean isEpreuve4() {
        return isEpreuve4;
    }

    /**
     * Le getter de l'utilisateur lie a la partie.
     * @return L'utilisateur lie a la partie.
     */
    public Utilisateur getJoueurTmp() {
        return utilisateur;
    }
}