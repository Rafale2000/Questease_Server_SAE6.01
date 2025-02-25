package fr.uphf.questease.testunitaire;

import fr.uphf.questease.controller.ChoseATrouverPrixJusteController;
import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.service.ChoseATrouverPrixJusteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChoseATrouverPrixJusteControllerTest {

    /**
     * Le service du controller de ChoseATrouverPrixJuste.
     */
    @Mock
    private ChoseATrouverPrixJusteServiceImpl service;

    /**
     * Le controller de ChoseATrouverPrixJuste.
     */
    @InjectMocks
    private ChoseATrouverPrixJusteController controller;

    /**
     * Methode permettant d'initialiser les champs annotes avec les mockitos avant tous les tests.
     * Il s'agit de la premiere methode appelee de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Methode permettant de tester si la methode GetChoseById fonctionne correctement.
     */
    @Test
    void testGetChoseById() {
        // Creation et sauvegarde subsequente de l'objet.
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45);
        service.saveChose(chose);

        // Recuperation des donnees sur la base.
        when(service.readChose(100L)).thenReturn(Optional.of(chose));
        ResponseEntity<Optional<ChoseATrouverPrixJuste>> response = controller.getChoseById(100L);

        // Verification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("Laptop", response.getBody().get().getNom());
    }

    /**
     * Methode permettant de tester si la methode postChose de la clase ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle cree un nouveau element puis l'insere dans la base de donnees.
     * Enfin elle verifie qu'elle est presente dans cette derniere.
     */
    @Test
    void testPostChose() {
        // Nouvel objet de test cree ici.
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200);

        // Ajout de l'objet dans la base de donnees.
        controller.postChose(101L, chose);

        // Verification si l'objet est bien sauvegarde.
        verify(service, times(1)).saveChose(chose);
    }

    /**
     * Methode permettant de tester si la methode updateChoseATrouver de la clase ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle cree un objet pour le test et modifie l'objet cree precedemment dans la methode testPostChose.
     * Enfin, elle verifie si l'objet est bien modifie.
     */
    @Test
    void testUpdateChoseATrouver() {
        // Creation d'un nouveau objet.
        ChoseATrouverPrixJuste updatedChose = new ChoseATrouverPrixJuste(101L, "Tablet", "Gadgets", 69);
        // Appel a la methode pour mettre un jour un objet.
        controller.updateChoseATrouver(101L, updatedChose);
        // Test si l'objet est bien modifie.
        verify(service, times(1)).updateChose(updatedChose, 101L);
    }

    /**
     * Methode permettant de tester si la methode deleteChose de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle verifie qu'un objet est bien supprime de la base de donnees.
     */
    @Test
    void testDeleteChose() {
        controller.deleteChose(101L);

        verify(service, times(1)).deleteChose(101L);
    }

    /**
     * Methode permettant de tester si la methode getAll de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle verifie que les elements crees sont bien dans la base de donnees.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 elements de test
        List<ChoseATrouverPrixJuste> choses = Arrays.asList(
                new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45),
                new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200)
        );

        // Ajout dans le service des elements de la list
        when(service.fetchChoseList()).thenReturn(choses);

        // Test de la methode du controller
        List<ChoseATrouverPrixJuste> response = controller.getAll();

        // Test de la taille des elements retourne
        assertEquals(2, response.size());
        // Test de l'id du 1er element
        assertEquals("Laptop", response.get(0).getNom());
        // Test de l'id du 2e element
        assertEquals("Phone", response.get(1).getNom());
    }
}
