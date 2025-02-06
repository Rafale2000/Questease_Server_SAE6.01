package fr.uphf.questease.controller.testunitaire;

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
     * Méthode permettant d'initialiser les champs annotés avec les mockitos avant tous les tests.
     * Il s'agit de la première méthode appelée de ce fichier.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Méthode permettant de tester si la méthode GetChoseById fonctionne correctement.
     */
    @Test
    void testGetChoseById() {
        // Création et sauvegarde subséquente de l'objet.
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45);
        service.saveChose(chose);

        // Récupération des données sur la base.
        when(service.readChose(100L)).thenReturn(Optional.of(chose));
        ResponseEntity<Optional<ChoseATrouverPrixJuste>> response = controller.getChoseById(100L);

        // Vérification finale.
        assertTrue(Objects.requireNonNull(response.getBody()).isPresent());
        assertEquals("Laptop", response.getBody().get().getNom());
    }

    /**
     * Méthode permettant de tester si la méthode postChose de la clase ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle crée un nouveau élément puis l'insère dans la base de données.
     * Enfin elle vérifie qu'elle est présente dans cette dernière.
     */
    @Test
    void testPostChose() {
        // Nouvel objet de test créé ici.
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200);

        // Ajout de l'objet dans la base de données.
        controller.postChose(101L, chose);

        // Vérification si l'objet est bien sauvegardé.
        verify(service, times(1)).saveChose(chose);
    }

    /**
     * Méthode permettant de tester si la méthode updateChoseATrouver de la clase ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle crée un objet pour le test et modifie l'objet crée précédemment dans la méthode testPostChose.
     * Enfin, elle vérifie si l'objet est bien modifié.
     */
    @Test
    void testUpdateChoseATrouver() {
        // Création d'un nouveau objet.
        ChoseATrouverPrixJuste updatedChose = new ChoseATrouverPrixJuste(101L, "Tablet", "Gadgets", 69);
        // Appel a la méthode pour mettre un jour un objet.
        controller.updateChoseATrouver(101L, updatedChose);
        // Test si l'objet est bien modifié.
        verify(service, times(1)).updateChose(updatedChose, 101L);
    }

    /**
     * Méthode permettant de tester si la méthode deleteChose de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle vérifie qu'un objet est bien supprimé de la base de données.
     */
    @Test
    void testDeleteChose() {
        controller.deleteChose(101L);

        verify(service, times(1)).deleteChose(101L);
    }

    /**
     * Méthode permettant de tester si la méthode getAll de la classe ChosePrixATrouverPrixJusteController fonctionne correctement.
     * Elle vérifie que les éléments créés sont bien dans la base de données.
     */
    @Test
    void testGetAll() {
        // Liste contenant 2 éléments de test
        List<ChoseATrouverPrixJuste> choses = Arrays.asList(
                new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45),
                new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200)
        );

        // Ajout dans le service des élements de la list
        when(service.fetchChoseList()).thenReturn(choses);

        // Test de la méthode du controller
        List<ChoseATrouverPrixJuste> response = controller.getAll();

        // Test de la taille des éléments retourné
        assertEquals(2, response.size());
        // Test de l'id du 1er élément
        assertEquals("Laptop", response.get(0).getNom());
        // Test de l'id du 2e élément
        assertEquals("Phone", response.get(1).getNom());
    }
}
