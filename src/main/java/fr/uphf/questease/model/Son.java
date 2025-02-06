package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Représente le son à décrire lors du jeu du Son
 */
@Entity
@Table(name = "Son")
public class Son {

    /**
     * L'id du son à décrire
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idSon")
    private Long id;

    /**
     * Le path menant au son à décrire
     */
    @Column(name = "cheminSon", nullable = false)
    private String cheminSon;

    /**
     * L'indice lié au son à décrire
     */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idindice", referencedColumnName = "idindice")
    private Indice indice;

    public Son(Long idSon, String cheminSon, Indice indice) {
        this.id = id;
        this.cheminSon = cheminSon;
        this.indice = indice;
    }

    public Son() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
