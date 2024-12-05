package fr.uphf.Questease.Model;

import jakarta.persistence.*;
import java.util.Set;

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
    @Column(name = "pseudouser",nullable = false, unique = true)
    private String nom;

    /**
     * L'expérience accumulée par l'utilisateur
     */
    @Column(name = "xp",nullable = false)
    private int Xp;


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
}
