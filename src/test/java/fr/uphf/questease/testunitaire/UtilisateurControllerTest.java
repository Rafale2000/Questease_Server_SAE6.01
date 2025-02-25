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
     * Methode permettant d'initialiser les champs annotes avec les mockitos avant tous les tests.
     * Il s'agit de la premiere methode appelee de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Methode permettant de tester si la methode getUserByName fonctionne correctement.
     */
    @Test
    void testPostUser() {
        // Creation et sauvegarde subsequente de l'objet.
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");
        Utilisateur utilisateur = new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null);
        infoSecu.setUtilisateur(utilisateur);
        service.saveUtilisateur(utilisateur);

        // Recuperation des donnees sur la base.
        when(service.fetchOne("roberto")).thenReturn(Optional.of(utilisateur));

        ResponseEntity<Optional<Utilisateur>> response = controller.getUserByName("roberto");

        // Verification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("roberto", response.getBody().get().getNom());
    }


    /**
     * Methode permettant de tester si la methode updateChoseATrouver de la clase UtilisateurController fonctionne correctement.
     * Elle cree un objet pour le test et modifie l'objet cree precedemment dans la methode testPostChose.
     * Enfin, elle verifie si l'objet est bien modifie.
     */
    @Test
    void testUpdateUser() {
        // Creation d'un nouveau objet.
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");
        Utilisateur updateUtilisateur = new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null);
        infoSecu.setUtilisateur(updateUtilisateur);


        // Appel a la methode pour mettre un jour un objet.
        when(service.updateUtilisateur(any(Utilisateur.class), eq(101L))).thenReturn(updateUtilisateur);

        controller.updateUser(101L, updateUtilisateur);
        // Test si l'objet est bien modifie.

        verify(service, times(1)).updateUtilisateur(updateUtilisateur, 101L);

    }

    /**
     * Methode permettant de tester si la methode deleteChose de la classe UtilisateurController fonctionne correctement.
     * Elle verifie qu'un objet est bien supprime de la base de donnees.
     */
    @Test
    void testDeleteUser() {
        controller.deleteUser(101L);

        verify(service, times(1)).deleteUtilisateur(101L);
    }

    /**
     * Methode permettant de tester si la methode getAll de la classe UtilisateurController fonctionne correctement.
     * Elle verifie que les elements crees sont bien dans la base de donnees.
     */
    @Test
    void testGetAllUserGet() {
        // Liste contenant 2 elements de test
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");

        List<Utilisateur> utils = Arrays.asList(
                new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null),
                new Utilisateur(101L, "twingo", 100, Utilisateur.Status.ONE, infoSecu, null)
        );

        // Ajout dans le service des elements de la list
        for (Utilisateur util : utils) {
            when(service.saveUtilisateur((util))).thenReturn(util);

        }

        when(service.fetchUtilisateurList()).thenReturn(utils);

        // Test de la methode du controller
        List<Utilisateur> response = controller.getAllUserGet();

        // Test de la taille des elements retourne
        assertEquals(2, response.size());
        // Test de l'id du 1er element
        assertEquals("roberto", response.get(0).getNom());
        // Test de l'id du 2e element
        assertEquals("twingo", response.get(1).getNom());
    }

    /**
     * Methode permettant de tester si la methode getAll de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle verifie que les elements crees sont bien dans la base de donnees.
     */
    @Test
    void testGetAllUserPost() {
        // Liste contenant 2 elements de test
        InfoSecu infoSecu = new InfoSecu(1L, "azerty12345", "roberto.robert@mail.su");

        List<Utilisateur> utils = Arrays.asList(
                new Utilisateur(100L, "roberto", 100, Utilisateur.Status.ONE, infoSecu, null),
                new Utilisateur(101L, "twingo", 100, Utilisateur.Status.ONE, infoSecu, null)
        );

        // Ajout dans le service des elements de la list
        for (Utilisateur util : utils) {
            when(service.saveUtilisateur((util))).thenReturn(util);

        }

        when(service.fetchUtilisateurList()).thenReturn(utils);

        // Test de la methode du controller
        List<Utilisateur> response = controller.getAllUserPost();

        // Test de la taille des elements retourne
        assertEquals(2, response.size());
        // Test de l'id du 1er element
        assertEquals("roberto", response.get(0).getNom());
        // Test de l'id du 2e element
        assertEquals("twingo", response.get(1).getNom());
    }
}
