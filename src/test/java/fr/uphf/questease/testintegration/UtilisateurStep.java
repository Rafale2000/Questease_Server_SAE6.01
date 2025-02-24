package fr.uphf.questease.testintegration;

import fr.uphf.questease.controller.UtilisateurController;
import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.service.UtilisateurServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.zh_cn.而且;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UtilisateurStep {

    @Mock
    private UtilisateurServiceImpl service;

    /**
     * Le controller de UtilisateurService.
     */
    @InjectMocks
    private UtilisateurController controller;

    Utilisateur u;
    Utilisateur u1;
    Utilisateur u2;

    @Given("l utilisateur souaite ajouter des utilisateurs dans la bdd")
    public void lUtilisateurSouaiteAjouterDesUtilisateursDansLaBdd() {

    }

    @When("l utilisateur creer les objets utils {string} {string} {string} {string}")
    public void lUtilisateurCreerLesObjetsUtils(String arg0, String arg1, String arg2, String arg3) {
        long id = Long.parseLong(arg0);
        int xp = Integer.parseInt(arg2);
        this.u = new Utilisateur(id, arg1, xp, Utilisateur.Status.ONE, null,null);

        controller.postUser(u);

    }

    @Then("les utilisateurs sont sur la bdd")
    public void lesUtilisateursSontSurLaBdd() {

        // Vérification si l'objet est bien sauvegardé.
        verify(service, times(1)).saveUtilisateur(u);

    }

    @Given("l utilisateur souaite modifier un utilisateur")
    public void lUtilisateurSouaiteModifierUnUtilisateur() {
        controller.postUser(u);
    }

    @When("l utilisateur modifie l utilisateur")
    public void lUtilisateurModifieLUtilisateur() {

        this.u1 = new Utilisateur(4L, "jean", 29, Utilisateur.Status.ONE, null,null);

        controller.updateUser(4L, u1);
    }

    @Then("l utilisateur est modifie")
    public void lUtilisateurEstModifie() {
        verify(service, times(1)).updateUtilisateur(u1, 4L);


    }

    @Given("Il existe un compte")
    public void ilExisteUnCompte() {
        this.u2 = new Utilisateur(5L, "robert", 39, Utilisateur.Status.ONE, null,null);
    }

    @When("l utilisateur veut supprimer le compte")
    public void lUtilisateurVeutSupprimerLeCompte() {
        controller.deleteUser(5L);

    }

    @Then("le compte est supprimer")
    public void leCompteEstSupprimer() {
        verify(service, times(1)).deleteUtilisateur(5L);

    }
}
