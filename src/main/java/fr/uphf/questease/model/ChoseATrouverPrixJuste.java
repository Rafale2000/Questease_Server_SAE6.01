package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Représente l'un des éléments à trouver du Prix Juste
 */
@Entity
@Table(name="choseATrouverPrixJust")
public class ChoseATrouverPrixJuste {

    /**
     * L'id de l'élément
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idChoseATrouver")
    private Long id;

    /**
     * Le nom de l'élément
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    /**
     * Le path vers l'image de l'élément
     */
    @Column(name = "pathtopicture", nullable = false)
    private String cheminImage;

    /**
     * Le prix de l'élément
     */
    @Column(name = "prix", nullable = false)
    private int valeur;

    /**
     * Le constructeur par défaut de l'élément
     */
    public ChoseATrouverPrixJuste() {}

    /**
     * Le constructeur paramétrique de l'élément
     * @param id L'id de l'élément
     * @param nom Le nom de l'élément
     * @param cheminImage Le path vers l'image de l'élément
     * @param valeur Le prix de l'élément
     */
    public ChoseATrouverPrixJuste(Long id, String nom, String cheminImage, int valeur) {
        this.id = id;
        this.nom = nom;
        this.cheminImage = cheminImage;
        this.valeur = valeur;
    }


    /**
     * Le getter du nom de l'élément
     * @return Le nom de l'élément
     */
    public String getNom() {
        return nom;
    }

    /**
     * Le getter du path vers l'image de l'élément
     * @return Le path vers l'image de l'élément
     */
    public String getCheminImage() {
        return cheminImage;
    }

    /**
     * Le getter du prix de l'élément
     * @return Le prix de l'élément
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Le setter de l'id de l'élément
     * @param id L'id de l'élément
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter de l'id de l'élément
     * @return L'id de l'élément
     */
    public Long getId() {
        return id;
    }
}