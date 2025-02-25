package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Represente l'un des elements a trouver du Prix Juste.
 */
@Entity
@Table(name="choseATrouverPrixJust")
public class ChoseATrouverPrixJuste {

    /**
     * L'id de l'element.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idChoseATrouver")
    private Long id;

    /**
     * Le nom de l'element.
     */
    @Column(name = "nom", nullable = false)
    private String nom;

    /**
     * Le path vers l'image de l'element.
     */
    @Column(name = "pathtopicture", nullable = false)
    private String cheminImage;

    /**
     * Le prix de l'element.
     */
    @Column(name = "prix", nullable = false)
    private int valeur;

    /**
     * Le constructeur par defaut de l'element.
     */
    public ChoseATrouverPrixJuste() {}

    /**
     * Le constructeur parametrique de l'element.
     * @param id L'id de l'element.
     * @param nom Le nom de l'element.
     * @param cheminImage Le path vers l'image de l'element.
     * @param valeur Le prix de l'element.
     */
    public ChoseATrouverPrixJuste(Long id, String nom, String cheminImage, int valeur) {
        this.id = id;
        this.nom = nom;
        this.cheminImage = cheminImage;
        this.valeur = valeur;
    }

    /**
     * Le getter du nom de l'element.
     * @return Le nom de l'element.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Le getter du path vers l'image de l'element.
     * @return Le path vers l'image de l'element.
     */
    public String getCheminImage() {
        return cheminImage;
    }

    /**
     * Le getter du prix de l'element.
     * @return Le prix de l'element.
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Le setter de l'id de l'element.
     * @param id L'id de l'element.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter de l'id de l'element.
     * @return L'id de l'element.
     */
    public Long getId() {
        return id;
    }
}