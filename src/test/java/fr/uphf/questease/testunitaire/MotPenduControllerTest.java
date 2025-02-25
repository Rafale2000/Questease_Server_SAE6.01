package fr.uphf.questease.testunitaire;

import fr.uphf.questease.controller.MotPenduController;
import fr.uphf.questease.model.MotPendu;
import fr.uphf.questease.service.MotPenduServiceImpl;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MotPenduControllerTest {

    /**
     * Le service du controller de ChoseATrouverPrixJuste.
     */
    @Mock
    private MotPenduServiceImpl service;
    /**
     * Le controller de ChoseATrouverPrixJuste.
     */
    @InjectMocks
    private MotPenduController controller;

    /**
     * Methode permettant d'initialiser les champs annotes avec les mockitos avant tous les tests.
     * Il s'agit de la premiere methode appelee de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Methode permettant de tester si la methode getMotById fonctionne correctement.
     */
    @Test
    void testGetMotById() {
        // Creation et sauvegarde subsequente de l'objet.
        MotPendu mot = new MotPendu(100L, "Rhododendron");
        service.saveMotPendu(mot);

        // Recuperation des donnees sur la base.
        when(service.fetchOneMotPendu(100L)).thenReturn(Optional.of(mot));
        ResponseEntity<Optional<MotPendu>> response = controller.getMotById(100L);

        // Verification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("Rhododendron", response.getBody().get().getMot());
    }

    /**
     * Methode permettant de tester si la methode PostMot de la clase MotPendu fonctionne correctement.
     * Elle cree un nouveau element puis l'insere dans la base de donnees.
     * Enfin elle verifie qu'elle est presente dans cette derniere.
     */
    @Test
    void testPostMot() {
        // Nouvel objet de test cree ici.
        MotPendu mot = new MotPendu(101L, "Pandemonium");

        // Ajout de l'objet dans la base de donnees.
        controller.PostMot(mot);

        // Verification si l'objet est bien sauvegarde.
        verify(service, times(1)).saveMotPendu(mot);
    }

    /**
     * Methode permettant de tester si la methode updateMot de la clase MotPendu fonctionne correctement.
     * Elle cree un objet pour le test et modifie l'objet cree precedemment dans la methode testPostChose.
     * Enfin, elle verifie si l'objet est bien modifie.
     */
    @Test
    void testUpdateChoseATrouver() {
        // Creation d'un nouveau objet.
        MotPendu mot = new MotPendu(101L, "Kaleidoscope");
        // Appel a la methode pour mettre un jour un objet.
        controller.updateMot(101L, mot);
        // Test si l'objet est bien modifie.
        verify(service, times(1)).updateMotPendu(mot, 101L);
    }

    /**
     * Methode permettant de tester si la methode deleteMot de la classe MotPendu fonctionne correctement.
     * Elle verifie qu'un objet est bien supprime de la base de donnees.
     */
    @Test
    void testDeleteChose() {
        controller.deleteMot(101L);

        verify(service, times(1)).deleteMotPendu(101L);
    }

    /**
     * Methode permettant de tester si la methode getAll de la classe MotPendu fonctionne correctement.
     * Elle verifie que les elements crees sont bien dans la base de donnees.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 elements de test
        List<MotPendu> choses = Arrays.asList(
                new MotPendu(100L, "Protozoaire"),
                new MotPendu(101L, "Zygomatique")
        );

        // Ajout dans le service des elements de la list
        when(service.fetchMotPenduList()).thenReturn(choses);

        // Test de la methode du controller
        List<MotPendu> response = controller.getAllMotGet();

        // Test de la taille des elements retourne
        assertEquals(2, response.size());
        // Test de l'id du 1er element
        assertEquals("Protozoaire", response.get(0).getMot());
        // Test de l'id du 2e element
        assertEquals("Zygomatique", response.get(1).getMot());
    }
}
