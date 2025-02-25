package fr.uphf.questease.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Represente l'indice lie a l'un des minijeux.
 */
@Entity
public class Indice {

    /**
     * L'id de l'indice.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idindice")
    private long id;

    /**
     * Le texte de l'indice.
     */
    @Column(name = "indice",unique=true, nullable=false)
    private String indiceText;

    /**
     * La liste d'indices du Deviner le Son.
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indice", cascade = CascadeType.ALL)
    private List<Son> sonList;

    /**
     * Le constructeur par defaut de l'indice.
     */
    public Indice() {}

    /**
     * Le constructeur parametrique de l'indice.
     * @param id L'id de l'indice.
     * @param indice Le texte de l'indice.
     */
    public Indice(int id, String indice) {
        this.id = id;
        this.indiceText = indice;
    }

    /**
     * Le getter de l'id de l'indice.
     * @return L'id de l'indice.
     */
    public long getId() {
        return id;
    }

    /**
     * Le getter du texte de l'indice.
     * @return Le texte de l'indice.
     */
    public String getHint() {
        return indiceText;
    }

    /**
     * Le setter de l'id de l'indice.
     * @param id L'id de l'indice.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Le getter du texte de l'indice.
     * @return Le texte de l'indice.
     */
    public String getIndiceText() {
        return indiceText;
    }

    /**
     * Le setter du texte de l'indice.
     * @param indiceText Le texte de l'indice.
     */
    public void setIndiceText(String indiceText) {
        this.indiceText = indiceText;
    }

    /**
     * Le getter de la liste des indices du jeu du son.
     * @return La liste des indices du jeu du son.
     */
    public List<Son> getSonList() {
        return sonList;
    }

    /**
     * Le setter de la liste des indices du jeu du son.
     * @param sonList La liste des indices du jeu du son.
     */
    public void setSonList(List<Son> sonList) {
        this.sonList = sonList;
    }
}
