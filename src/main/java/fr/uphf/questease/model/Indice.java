package fr.uphf.questease.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Représente l'indice lié à l'un des minijeux
 */
@Entity
public class Indice {
    /**
     * L'id de l'indice
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idindice")
    private long id;

    /**
     * Le texte de l'indice
     */
    @Column(name = "indice",unique=true, nullable=false)
    private String indiceText;


    /**
     * La liste d'indices pour le Cryptex
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indice", cascade = CascadeType.ALL)
    private List<MotCryptex> motCryptexList;


    /**
     * La liste d'indices du Deviner le Son
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indice", cascade = CascadeType.ALL)
    private List<MotCryptex> sonList;

    /**
     * Le constructeur par défaut de l'indice
     */
    public Indice() {}

    /**
     * Le constructeur paramétrique de l'indice
     * @param id L'id de l'indice
     * @param indice Le texte de l'indice
     */
    public Indice(int id, String indice) {
        this.id = id;
        this.indiceText = indice;
    }

    /**
     * Le getter de l'id de l'indice
     * @return L'id de l'indice
     */
    public long getId() {
        return id;
    }

    /**
     * Le getter du texte de l'indice
     * @return Le texte de l'indice
     */
    public String getHint() {
        return indiceText;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIndiceText() {
        return indiceText;
    }

    public void setIndiceText(String indiceText) {
        this.indiceText = indiceText;
    }

    public List<MotCryptex> getMotCryptexList() {
        return motCryptexList;
    }

    public void setMotCryptexList(List<MotCryptex> motCryptexList) {
        this.motCryptexList = motCryptexList;
    }

    public List<MotCryptex> getSonList() {
        return sonList;
    }

    public void setSonList(List<MotCryptex> sonList) {
        this.sonList = sonList;
    }
}
