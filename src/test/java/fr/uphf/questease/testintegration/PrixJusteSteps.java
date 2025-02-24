package fr.uphf.questease.testintegration;

import fr.uphf.questease.controller.ChoseATrouverPrixJusteController;
import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.service.ChoseATrouverPrixJusteServiceImpl;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.vi.Cho;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class PrixJusteSteps {

    @Mock
    private ChoseATrouverPrixJusteServiceImpl service;
    private ChoseATrouverPrixJuste c;
    private ChoseATrouverPrixJuste c2;
    private ChoseATrouverPrixJuste c3;

    /**
     * Le controller de ChoseATrouverPrixJuste.
     */
    @InjectMocks
    private ChoseATrouverPrixJusteController controller;

    @Given("J ai acces a la bdd")
    public void jAiAccesALaBdd() {
        MockitoAnnotations.openMocks(this);
    }

    @Given("l utilisateur souaite ajouter des objets dans la bdd")
    public void lUtilisateurSouaiteAjouterDesObjetsDansLaBdd() {
        //pass
    }

    @When("l utilisateur creer les objets {string} {string} {string} {string}")
    public void lUtilisateurCreerLesObjets(String arg0, String arg1, String arg2, String arg3) {
        long id = Long.parseLong(arg0);
        int value = Integer.parseInt(arg3);
        this.c = new ChoseATrouverPrixJuste(id, arg1, arg2, value);
    }


    @Then("les objets sont sur la bdd")
    public void lesObjetsSontSurLaBdd() {
        controller.postChose(101L, c);

        // Vérification si l'objet est bien sauvegardé.
        verify(service, times(1)).saveChose(c);
    }


    @Given("l utilisateur souaite modifier un objet")
    public void lUtilisateurSouaiteModifierUnObjet() {
        this.c2 = new ChoseATrouverPrixJuste(5L, "beheme", "c:root", 3000);
        controller.postChose(5L, c2);

    }

    @When("l utilisateur modifie l objet")
    public void lUtilisateurModifieLObjet() {
        this.c2 = new ChoseATrouverPrixJuste(5L, "citron", "c:root", 3000);

        controller.updateChoseATrouver(5L, c2);
        // Test si l'objet est bien modifié.

    }

    @Then("l objet est modifie")
    public void lObjetEstModifie() {
        verify(service, times(1)).updateChose(c2, 5L);

    }

    @Given("Il existe un élément")
    public void ilExisteUnElement() {
        this.c3 = new ChoseATrouverPrixJuste(6L, "beheme", "c:root", 3000);
        controller.postChose(6L, c3);
    }

    @When("l'utilisateur veut le supprimer")
    public void lUtilisateurVeutLeSupprimer() {
        controller.deleteChose(6L);

    }

    @Then("Il disparait de la base de donnée")
    public void ilDisparaitDeLaBaseDeDonnee() {
        verify(service, times(1)).deleteChose(6L);

    }
}
