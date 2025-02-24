package fr.uphf.questease.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente l'utilisateur qui jour aux différents jeux
 */
@Entity
@Table(name = "Utilisateur")
public class Utilisateur {

    /**
     * L'id de l'utilisateur
     */
    @Id
    @GeneratedValue
    @Column(name = "idutilisateur")
    private Long id;

    /**
     * Le pseudonyme de l'utilisateur
     */
    @Column(name = "nom",nullable = false, unique = true)
    private String nom;

    /**
     * L'expérience accumulée par l'utilisateur
     */
    @Column(name = "xp",nullable = false)
    private int Xp;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "diff", nullable = false)
    private Status diff = Status.ONE;


    public enum Status {
        ONE(1), TWO(2), THREE(3);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Lien vers les informations générales de l'utilisateur
     */
    @OneToOne(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private InfoSecu infoSecu;

    public Utilisateur(Long id, String nom, int xp, Status diff, InfoSecu infoSecu, List<Resultat> resultat) {
        this.id = id;
        this.nom = nom;
        Xp = xp;
        this.diff = diff;
        this.infoSecu = infoSecu;
        this.resultat = resultat;
    }
    public Utilisateur() {}

    /**
     * La liste de resultat pour un utilisateur
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "idPartie", cascade = CascadeType.ALL)
    private List<Resultat> resultat;


    /**
     * Le getter de l'id de l'utilisateur
     * @return L'id de l'utilisateur
     */
    public Long getId() {
        return id;
    }

    /**
     * Le setter de l'id de l'utilisateur
     * @param id L'id de l'utilisateur
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter du nom de l'utilisateur
     * @return Le nom de l'utilisateur
     */
    public String getNom() {
        return nom;
    }

    /**
     * Le setter du pseudonyme de l'utilisateur
     * @param nom Le pseudonyme de l'utlisateur
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Le getter de l'expérience de l'utilisateur
     * @return L'expérience de l'utilisateur
     */
    public int getXp() {
        return Xp;
    }

    /**
     * Le setter de l'expérience de l'utilisateur
     * @param xp L'expérience de l'utilisateur
     */
    public void setXp(int xp) {
        Xp = xp;
    }

    public Status getDiff() {
        return diff;
    }

    public void setDiff(Status diff) {
        this.diff = diff;
    }

    public InfoSecu getInfoSecu() {
        return infoSecu;
    }

    public void setInfoSecu(InfoSecu infoSecu) {
        this.infoSecu = infoSecu;
    }

    public List<Resultat> getResultat() {
        return resultat;
    }

    public void setResultat(List<Resultat> resultat) {
        this.resultat = resultat;
    }
}
