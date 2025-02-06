package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Représente le mot à trouver lors du jeu du Pendu
 */
@Entity
@Table(name = "motPendu")
public class MotPendu {

    /**
     * L'id du mot du Pendu
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMotPendu")
    private Long id;

    /**
     * Le mot à trouver lors du jeu du Pendu
     */
    @Column(name = "mot",unique=true, nullable = false)
    private String mot;

    public MotPendu(Long id, String mot) {
        this.id = id;
        this.mot = mot;
    }

    public MotPendu() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMot() {
        return mot;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
}
