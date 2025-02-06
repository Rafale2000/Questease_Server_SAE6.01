package fr.uphf.questease.controller;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
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
     * Méthode permettant d'initialiser les champs annotés avec les Mockitos avant tous les tests.
     * Il s'agit de la première méthode appelée de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Méthode permettant de tester si la méthode GetSonById fonctionne correctement.
     */
    @Test
    void testGetSonById() {
        // Création et sauvegarde subséquente de l'objet.
        Son son = new Son(100L, "AAAAAAA", new Indice(100, "AAAAAAAAAAAA"));
        service.saveSon(son);

        // Récupération des données sur la base.
        when(service.fetchOne(100L)).thenReturn(Optional.of(son));
        ResponseEntity<Optional<Son>> response = controller.getSonById(100L);

        // Vérification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals(100L, response.getBody().get().getId());
    }

    /**
     * Méthode permettant de tester si la méthode postSon de la clase SonController fonctionne correctement.
     * Elle crée un nouveau élément puis l'insère dans la base de données.
     * Enfin elle vérifie qu'elle est présente dans cette dernière.
     */
    @Test
    void testPostSon() {
        // Nouvel objet de test créé ici.
        Son son = new Son(101L, "BBBBBBBB", new Indice(101, "BBBBBBBBBB"));

        // Ajout de l'objet dans la base de données.
        controller.postSon(son);

        // Vérification si l'objet est bien sauvegardé.
        verify(service, times(1)).saveSon(son);
    }

    /**
     * Méthode permettant de tester si la méthode updateSon de la classe SonController fonctionne correctement.
     * Elle crée un objet pour le test et modifie l'objet crée précédemment dans la méthode testPostSon.
     * Enfin, elle vérifie si l'objet est bien modifié.
     */
    @Test
    void testUpdateSon() {
        // Création d'un nouveau objet.
        Son son = new Son(101L, "CCCCCCCC", new Indice(101, "CCCCCCCCCC"));
        // Appel a la méthode pour mettre un jour un objet.
        controller.postSon(son);
        // Test si l'objet est bien modifié.
        verify(service, times(1)).updateSon(son, 101L);
    }

    /**
     * Méthode permettant de tester si la méthode deleteSon de la classe SonController fonctionne correctement.
     * Elle vérifie qu'un objet est bien supprimé de la base de données.
     */
    @Test
    void testDeleteChose() {
        controller.deleteSon(101L);

        verify(service, times(1)).deleteSon(101L);
    }

    /**
     * Méthode permettant de tester si la méthode getAll de la classe SonController fonctionne correctement.
     * Elle vérifie que les éléments créés sont bien dans la base de données.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 éléments de test
        List<Son> sons = Arrays.asList(
                new Son(100L, "AAAAAAAA", new Indice(100, "AAAAAAAAAAA")),
                new Son(101L, "BBBBBBBB", new Indice(100, "BBBBBBBBBBB"))
        );

        // Ajout dans le service des élements de la list
        when(service.fetchSonList()).thenReturn(sons);

        // Test de la méthode du controller
        List<Son> response = controller.getAllSonGet();

        // Test de la taille des éléments retourné
        assertEquals(2, response.size());
        // Test de l'id du 1er élément
        assertEquals(100L, response.get(0).getId());
        // Test de l'id du 2e élément
        assertEquals(101L, response.get(1).getId());
    }
}
