package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Represente le son a decrire lors du jeu du Son.
 */
@Entity
@Table(name = "Son")
public class Son {

    /**
     * L'id du son a decrire.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSon")
    private Long id;

    /**
     * Le path menant au son a decrire.
     */
    @Column(name = "cheminSon", nullable = false)
    private String cheminSon;

    /**
     * L'indice lie au son a decrire.
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idindice", referencedColumnName = "idindice")
    private Indice indice;

    /**
     * Le constructeur parametrique de la classe Son.
     * @param idSon L'id du Son.
     * @param cheminSon Le path vers le son.
     * @param indice L'indice lie au son.
     */
    public Son(Long idSon, String cheminSon, Indice indice) {
        this.id = id;
        this.cheminSon = cheminSon;
        this.indice = indice;
    }

    /**
     * Le constructeur vide de la classe Son.
     */
    public Son() {}

    /**
     * Le getter de l'id du Son.
     * @return L'id du Son.
     */
    public Long getId() {
        return id;
    }

    /**
     * Le setter de l'id du Son.
     * @param id L'id du Son.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter du path vers le Son.
     * @return Le path vers le Son.
     */
    public String getCheminSon() {
        return cheminSon;
    }

    /**
     * Le setter du path du Son.
     * @param cheminSon Le path du Son.
     */
    public void setCheminSon(String cheminSon) {
        this.cheminSon = cheminSon;
    }
}
