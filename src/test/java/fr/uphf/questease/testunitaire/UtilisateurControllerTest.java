package fr.uphf.questease.testunitaire;

import fr.uphf.questease.controller.UtilisateurController;
import fr.uphf.questease.model.InfoSecu;
import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.service.UtilisateurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

public class UtilisateurControllerTest {
    /**
     * Le service du controller de UtilisateurService.
     */
    @Mock
    private UtilisateurServiceImpl service;

    /**
     * Le controller de UtilisateurService.
     */
    @InjectMocks
    private UtilisateurController controller;

    /**
     * Méthode permettant d'initialiser les champs annotés avec les mockitos avant tous les tests.
     * Il s'agit de la première méthode appelée de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Méthode permettant de tester si la méthode getUserByName fonctionne correctement.
     */
    @Test
    void testPostUser() {
        // Création et sauvegarde subséquente de l'objet.
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");
        Utilisateur utilisateur = new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null);
        infoSecu.setUtilisateur(utilisateur);
        service.saveUtilisateur(utilisateur);

        // Récupération des données sur la base.
        when(service.fetchOne("roberto")).thenReturn(Optional.of(utilisateur));

        ResponseEntity<Optional<Utilisateur>> response = controller.getUserByName("roberto");

        // Vérification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("roberto", response.getBody().get().getNom());
    }


    /**
     * Méthode permettant de tester si la méthode updateChoseATrouver de la clase UtilisateurController fonctionne correctement.
     * Elle crée un objet pour le test et modifie l'objet crée précédemment dans la méthode testPostChose.
     * Enfin, elle vérifie si l'objet est bien modifié.
     */
    @Test
    void testUpdateUser() {
        // Création d'un nouveau objet.
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");
        Utilisateur updateUtilisateur = new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null);
        infoSecu.setUtilisateur(updateUtilisateur);


        // Appel a la méthode pour mettre un jour un objet.
        when(service.updateUtilisateur(any(Utilisateur.class), eq(101L))).thenReturn(updateUtilisateur);

        controller.updateUser(101L, updateUtilisateur);
        // Test si l'objet est bien modifié.

        verify(service, times(1)).updateUtilisateur(updateUtilisateur, 101L);

    }

    /**
     * Méthode permettant de tester si la méthode deleteChose de la classe UtilisateurController fonctionne correctement.
     * Elle vérifie qu'un objet est bien supprimé de la base de données.
     */
    @Test
    void testDeleteUser() {
        controller.deleteUser(101L);

        verify(service, times(1)).deleteUtilisateur(101L);
    }

    /**
     * Méthode permettant de tester si la méthode getAll de la classe UtilisateurController fonctionne correctement.
     * Elle vérifie que les éléments créés sont bien dans la base de données.
     */
    @Test
    void testGetAllUserGet() {
        // Liste contenant 2 éléments de test
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");

        List<Utilisateur> utils = Arrays.asList(
                new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null),
                new Utilisateur(101L, "twingo", 100, Utilisateur.Status.ONE, infoSecu, null)
        );

        // Ajout dans le service des élements de la list
        for (Utilisateur util : utils) {
            when(service.saveUtilisateur((util))).thenReturn(util);

        }

        when(service.fetchUtilisateurList()).thenReturn(utils);

        // Test de la méthode du controller
        List<Utilisateur> response = controller.getAllUserGet();

        // Test de la taille des éléments retourné
        assertEquals(2, response.size());
        // Test de l'id du 1er élément
        assertEquals("roberto", response.get(0).getNom());
        // Test de l'id du 2e élément
        assertEquals("twingo", response.get(1).getNom());
    }

    /**
     * Méthode permettant de tester si la méthode getAll de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle vérifie que les éléments créés sont bien dans la base de données.
     */
    @Test
    void testGetAllUserPost() {
        // Liste contenant 2 éléments de test
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");

        List<Utilisateur> utils = Arrays.asList(
                new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null),
                new Utilisateur(101L, "twingo", 100, Utilisateur.Status.ONE, infoSecu, null)
        );

        // Ajout dans le service des élements de la list
        for (Utilisateur util : utils) {
            when(service.saveUtilisateur((util))).thenReturn(util);

        }

        when(service.fetchUtilisateurList()).thenReturn(utils);

        // Test de la méthode du controller
        List<Utilisateur> response = controller.getAllUserPost();

        // Test de la taille des éléments retourné
        assertEquals(2, response.size());
        // Test de l'id du 1er élément
        assertEquals("roberto", response.get(0).getNom());
        // Test de l'id du 2e élément
        assertEquals("twingo", response.get(1).getNom());
    }
}
