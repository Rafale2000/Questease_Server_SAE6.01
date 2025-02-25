package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Represente le mot a trouver lors du jeu du Pendu.
 */
@Entity
@Table(name = "motPendu")
public class MotPendu {

    /**
     * L'id du mot du Pendu.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idMotPendu")
    private Long id;

    /**
     * Le mot a trouver lors du jeu du Pendu.
     */
    @Column(name = "mot",unique=true, nullable = false)
    private String mot;

    /**
     * Le constructeur parametrique de MotPendu.
     * @param id L'id de MotPendu.
     * @param mot Le mot du jeu du Pendu.
     */
    public MotPendu(Long id, String mot) {
        this.id = id;
        this.mot = mot;
    }

    /**
     * Le constructeur vide de MotPendu.
     */
    public MotPendu() {
    }

    /**
     * Le getter de l'id de MotPendu.
     * @return L'id de MotPendu.
     */
    public Long getId() {
        return id;
    }

    /**
     * Le setter de l'id de MotPendu.
     * @param id L'id de MotPendu.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter du mot de MotPendu.
     * @return Le mot de MotPendu.
     */
    public String getMot() {
        return mot;
    }

    /**
     * Le setter du mot de MotPendu.
     * @param mot Le mot de MotPendu.
     */
    public void setMot(String mot) {
        this.mot = mot;
    }
}
