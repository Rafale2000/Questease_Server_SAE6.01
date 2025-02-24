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
import java.util.List;import java.util.Objects;
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
     * Méthode permettant d'initialiser les champs annotés avec les mockitos avant tous les tests.
     * Il s'agit de la première méthode appelée de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Méthode permettant de tester si la méthode getMotById fonctionne correctement.
     */
    @Test
    void testGetMotById() {
        // Création et sauvegarde subséquente de l'objet.
        MotPendu mot = new MotPendu(100L, "Rhododendron");
        service.saveMotPendu(mot);

        // Récupération des données sur la base.
        when(service.fetchOneMotPendu(100L)).thenReturn(Optional.of(mot));
        ResponseEntity<Optional<MotPendu>> response = controller.getMotById(100L);

        // Vérification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("Rhododendron", response.getBody().get().getMot());
    }

    /**
     * Méthode permettant de tester si la méthode PostMot de la clase MotPendu fonctionne correctement.
     * Elle crée un nouveau élément puis l'insère dans la base de données.
     * Enfin elle vérifie qu'elle est présente dans cette dernière.
     */
    @Test
    void testPostMot() {
        // Nouvel objet de test créé ici.
        MotPendu mot = new MotPendu(101L, "Pandémonium");

        // Ajout de l'objet dans la base de données.
        controller.postMot(mot);

        // Vérification si l'objet est bien sauvegardé.
        verify(service, times(1)).saveMotPendu(mot);
    }

    /**
     * Méthode permettant de tester si la méthode updateMot de la clase MotPendu fonctionne correctement.
     * Elle crée un objet pour le test et modifie l'objet crée précédemment dans la méthode testPostChose.
     * Enfin, elle vérifie si l'objet est bien modifié.
     */
    @Test
    void testUpdateChoseATrouver() {
        // Création d'un nouveau objet.
        MotPendu mot = new MotPendu(101L, "Kaléidoscope");
        // Appel a la méthode pour mettre un jour un objet.
        controller.updateMot(101L, mot);
        // Test si l'objet est bien modifié.
        verify(service, times(1)).updateMotPendu(mot, 101L);
    }

    /**
     * Méthode permettant de tester si la méthode deleteMot de la classe MotPendu fonctionne correctement.
     * Elle vérifie qu'un objet est bien supprimé de la base de données.
     */
    @Test
    void testDeleteChose() {
        controller.deleteMot(101L);

        verify(service, times(1)).deleteMotPendu(101L);
    }

    /**
     * Méthode permettant de tester si la méthode getAll de la classe MotPendu fonctionne correctement.
     * Elle vérifie que les éléments créés sont bien dans la base de données.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 éléments de test
        List<MotPendu> choses = Arrays.asList(
                new MotPendu(100L, "Protozoaire"),
                new MotPendu(101L, "Zygomatique")
        );

        // Ajout dans le service des élements de la list
        when(service.fetchMotPenduList()).thenReturn(choses);

        // Test de la méthode du controller
        List<MotPendu> response = controller.getAllMotGet();

        // Test de la taille des éléments retourné
        assertEquals(2, response.size());
        // Test de l'id du 1er élément
        assertEquals("Protozoaire", response.get(0).getMot());
        // Test de l'id du 2e élément
        assertEquals("Zygomatique", response.get(1).getMot());
    }
}
