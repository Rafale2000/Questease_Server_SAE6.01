package fr.uphf.questease.model;

import jakarta.persistence.*;

/**
 * Les informations privées de l'utilisateur
 */
@Entity
@Table(name = "infoSecu")
public class InfoSecu {

    /**
     * L'id des informations privées de l'utilisateur
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idinfosecu")
    private Long id;

    /**
     * Le mot de passe de l'utilisateur
     */
    @Column(name = "pswrd", nullable = false)
    private String mdp;

    /**
     * L'email de l'utilisateur
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Lien vers les informations générales de l'utilisateur
     */
    @OneToOne
    @JoinColumn(name = "idutilisateur", referencedColumnName = "idutilisateur")
    private Utilisateur utilisateur;




    /**
     * Le getter de l'id des informations privées de l'utilisateur
     * @return L'id des informations privées de l'utilisateur
     */
    public Long getId() {
        return id;
    }

    /**
     * Le setter de l'id des informations privées de l'utilisateur
     * @param id L'id des informations privées de l'utilisateur
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Le getter du mot de passe de l'utilisateur
     * @return Le mot de passe de l'utilisateur
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Le setter du mot de passe de l'utilisateur
     * @param mdp Le mot de passe de l'utilisateur
     */
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    /**
     * Le getter de l'email de l'utilisateur
     * @return L'email de l'utilisateur
     */
    public String getEmail() {
        return email;
    }

    /**
     * Le setter de l'email de l'utilisateur
     * @param email L'email de l'utilisateur
     */
    public void setEmail(String email) {
        this.email = email;
    }
}