package fr.uphf.questease.controller;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.service.ChoseATrouverPrixJusteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ChoseATrouverPrixJusteControllerTest {

    @Mock
    private ChoseATrouverPrixJusteServiceImpl service;

    @InjectMocks
    private ChoseATrouverPrixJusteController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetChoseById() {
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45);
        service.saveChose(chose);
        when(service.readChose(100L)).thenReturn(Optional.of(chose));

        ResponseEntity<Optional<ChoseATrouverPrixJuste>> response = controller.getChoseById(100L);

        assertTrue(response.getBody().isPresent());
        assertEquals("Laptop", response.getBody().get().getNom());
    }



    @Test
    void testPostChose() {
        ChoseATrouverPrixJuste chose = new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200);

        controller.postChose(101L, chose);

        verify(service, times(1)).saveChose(chose);
    }

    @Test
    void testUpdateChoseATrouver() {
        ChoseATrouverPrixJuste updatedChose = new ChoseATrouverPrixJuste(101L, "Tablet", "Gadgets", 69);

        controller.updateChoseATrouver(101L, updatedChose);

        verify(service, times(1)).updateChose(updatedChose, 101L);
    }

    @Test
    void testDeleteChose() {
        controller.deleteChose(101L);

        verify(service, times(1)).deleteChose(101L);
    }

    @Test
    void testGetAll() {
        List<ChoseATrouverPrixJuste> choses = Arrays.asList(
                new ChoseATrouverPrixJuste(100L, "Laptop", "Electronics", 45),
                new ChoseATrouverPrixJuste(101L, "Phone", "Electronics", 1200)
        );

        when(service.fetchChoseList()).thenReturn(choses);

        List<ChoseATrouverPrixJuste> response = controller.getAll();

        assertEquals(2, response.size());
        assertEquals("Laptop", response.get(0).getNom());
        assertEquals("Phone", response.get(1).getNom());
    }
}
