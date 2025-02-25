package fr.uphf.questease.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represente l'utilisateur qui jour aux differents jeux.
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    /**
     * L'id de l'utilisateur.
     */
    @Id
    @GeneratedValue
    @Column(name = "idutilisateur")
    private Long id;

    /**
     * Le pseudonyme de l'utilisateur.
     */
    @Column(name = "nom",nullable = false, unique = true)
    private String nom;

    /**
     * L'experience accumulee par l'utilisateur.
     */
    @Column(name = "xp",nullable = false)
    private int Xp;

    /**
     * Le status de l'utilisateur.
     */
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "diff", nullable = false)
    private Status diff = Status.ONE;

    /**
     * L'enumeration TODO
     */
    public enum Status {
        ONE(1), TWO(2), THREE(3);

        /**
         *
         */
        private final int value;

        /**
         *
         * @param value
         */
        Status(int value) {
            this.value = value;
        }

        /**
         *
         * @return
         */
        public int getValue() {
            return value;
        }
    }

    /**
     * Lien vers les informations generales de l'utilisateur.
     */
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InfoSecu infoSecu;

    /**
     * Le constructeur parametrique de la classe Utilisateur.
     * @param id L'id de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     * @param xp L'experience acquise par l'utilisateur.
     * @param diff La difficulte des Lobby cree par l'utilisateur.
     * @param infoSecu Les informations importantes de l'utilisateur.
     * @param resultat TODO
     */
    public Utilisateur(Long id, String nom, int xp, Status diff, InfoSecu infoSecu, List<Resultat> resultat) {
        this.id = id;
        this.nom = nom;
        Xp = xp;
        this.diff = diff;
        this.infoSecu = infoSecu;
        this.resultat = resultat;
    }

    /**
     * Le constructeur vide de la classe Utilisateur.
     */
    public Utilisateur() {}

    /**
     * La liste de resultat pour un utilisateur.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPartie", cascade = CascadeType.ALL)
    private List<Resultat> resultat;


    /**
     * Le getter de l'id de l'utilisateur.
     * @return L'id de l'utilisateur.
     */
    public Long getId() {
        return id;
    }

    /**
     * Le setter de l'id de l'utilisateur.
     * @param id L'id de l'utilisateur.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter du nom de l'utilisateur.
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Le setter du pseudonyme de l'utilisateur.
     * @param nom Le pseudonyme de l'utlisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Le getter de l'experience de l'utilisateur.
     * @return L'experience de l'utilisateur.
     */
    public int getXp() {
        return Xp;
    }

    /**
     * Le setter de l'experience de l'utilisateur.
     * @param xp L'experience de l'utilisateur.
     */
    public void setXp(int xp) {
        Xp = xp;
    }

    /**
     * Le getter du TODO
     * @return
     */
    public Status getDiff() {
        return diff;
    }

    /**
     * Le setter du TODO
     * @param diff
     */
    public void setDiff(Status diff) {
        this.diff = diff;
    }

    /**
     * Le getter des informations importantes de l'utilisateur.
     * @return Les informations importantes de l'utilisateur.
     */
    public InfoSecu getInfoSecu() {
        return infoSecu;
    }

    /**
     * Le setter des informations importantes de l'utilisateur.
     * @param infoSecu Les informations importantes de l'utilisateur.
     */
    public void setInfoSecu(InfoSecu infoSecu) {
        this.infoSecu = infoSecu;
    }

    /**
     * Le getter des Resultats de l'utilisateur.
     * @return Les Resultats de l'utilisateur.
     */
    public List<Resultat> getResultat() {
        return resultat;
    }

    /**
     * Le setter des Resultats de l'utilisateur.
     * @param resultat Les Resultats de l'utilisateur.
     */
    public void setResultat(List<Resultat> resultat) {
        this.resultat = resultat;
    }
}
