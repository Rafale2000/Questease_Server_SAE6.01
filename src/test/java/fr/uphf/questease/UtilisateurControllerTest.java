package fr.uphf.questease;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.service.UtilisateurServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

public class UtilisateurControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UtilisateurServiceImpl utilisateurServiceImpl;

	private List<Utilisateur> utilisateurList;

	@BeforeEach
	void setUp() {
		Utilisateur utilisateur1 = null;
		Utilisateur utilisateur2 = null;
		utilisateurList = Arrays.asList(utilisateur1, utilisateur2);
	}

	@Test
	void testGetAllUserPost() throws Exception {
		// Mock the service layer to return a list of Utilisateur
		when(utilisateurServiceImpl.fetchUtilisateurList()).thenReturn(utilisateurList);

		// Perform the POST request and check the response status and the JSON structure
		mockMvc.perform(post("/utilisateur")
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].id").value(1))
				.andExpect(jsonPath("$[0].name").value("User1"))
				.andExpect(jsonPath("$[0].email").value("email1@example.com"))
				.andExpect(jsonPath("$[1].id").value(2))
				.andExpect(jsonPath("$[1].name").value("User2"))
				.andExpect(jsonPath("$[1].email").value("email2@example.com"));
	}
}
