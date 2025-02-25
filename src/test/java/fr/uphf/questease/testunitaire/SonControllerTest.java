package fr.uphf.questease.testunitaire;

import fr.uphf.questease.controller.SonController;
import fr.uphf.questease.model.Indice;
import fr.uphf.questease.model.Son;
import fr.uphf.questease.service.SonServiceImpl;
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

public class SonControllerTest {
    /**
     * Le service du controller de Son.
     */
    @Mock
    private SonServiceImpl service;

    /**
     * Le controller de Son.
     */
    @InjectMocks
    private SonController controller;

    /**
     * Methode permettant d'initialiser les champs annotes avec les Mockitos avant tous les tests.
     * Il s'agit de la premiere methode appelee de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Methode permettant de tester si la methode GetSonById fonctionne correctement.
     */
    @Test
    void testGetSonById() {
        // Creation et sauvegarde subsequente de l'objet.
        Son son = new Son(100L, "AAAAAAA", new Indice(100, "AAAAAAAAAAAA"));
        service.saveSon(son);

        // Recuperation des donnees sur la base.
        when(service.fetchOne(100L)).thenReturn(Optional.of(son));
        ResponseEntity<Optional<Son>> response = controller.getSonById(100L);

        // Verification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals(100L, response.getBody().get().getId());
    }

    /**
     * Methode permettant de tester si la methode postSon de la clase SonController fonctionne correctement.
     * Elle cree un nouveau element puis l'insere dans la base de donnees.
     * Enfin elle verifie qu'elle est presente dans cette derniere.
     */
    @Test
    void testPostSon() {
        // Nouvel objet de test cree ici.
        Son son = new Son(101L, "BBBBBBBB", new Indice(101, "BBBBBBBBBB"));

        // Ajout de l'objet dans la base de donnees.
        controller.postSon(son);

        // Verification si l'objet est bien sauvegarde.
        verify(service, times(1)).saveSon(son);
    }

    /**
     * Methode permettant de tester si la methode updateSon de la classe SonController fonctionne correctement.
     * Elle cree un objet pour le test et modifie l'objet cree precedemment dans la methode testPostSon.
     * Enfin, elle verifie si l'objet est bien modifie.
     */
    @Test
    void testUpdateSon() {
        // Creation d'un nouveau objet.
        Son son = new Son(101L, "CCCCCCCC", new Indice(101, "CCCCCCCCCC"));
        // Appel a la methode pour mettre un jour un objet.
        controller.postSon(son);
        // Test si l'objet est bien modifie.
        verify(service, times(1)).updateSon(son, 101L);
    }

    /**
     * Methode permettant de tester si la methode deleteSon de la classe SonController fonctionne correctement.
     * Elle verifie qu'un objet est bien supprime de la base de donnees.
     */
    @Test
    void testDeleteChose() {
        controller.deleteSon(101L);

        verify(service, times(1)).deleteSon(101L);
    }

    /**
     * Methode permettant de tester si la methode getAll de la classe SonController fonctionne correctement.
     * Elle verifie que les elements crees sont bien dans la base de donnees.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 elements de test
        List<Son> sons = Arrays.asList(
                new Son(100L, "AAAAAAAA", new Indice(100, "AAAAAAAAAAA")),
                new Son(101L, "BBBBBBBB", new Indice(100, "BBBBBBBBBBB"))
        );

        // Ajout dans le service des elements de la list
        when(service.fetchSonList()).thenReturn(sons);

        // Test de la methode du controller
        List<Son> response = controller.getAllSonGet();

        // Test de la taille des elements retourne
        assertEquals(2, response.size());
        // Test de l'id du 1er element
        assertEquals(100L, response.get(0).getId());
        // Test de l'id du 2e element
        assertEquals(101L, response.get(1).getId());
    }
}
