package fr.uphf.questease.controller;

import fr.uphf.questease.model.SincereMenteur;
import fr.uphf.questease.service.SincereMenteurServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
/**
 * Controller du repositoire de sincere menteur.
 */
@RestController
@RequestMapping("/api/sincere_menteur")
public class SincereMenteurController {

    /**
     * Le repositoire de sincere_menteur.
     */
    public final SincereMenteurServiceImpl repository;

    /**
     * Constructeur de la classe SincereMenteurController.
     * @param repo Repositoire de la classe SincereMenteurController.
     */
    public SincereMenteurController(SincereMenteurServiceImpl repo) {
        this.repository = repo;
    }

    /**
     * Endpoint pour envoyer les reponses des joueurs.
     */
    @PostMapping("/submit")
    public SincereMenteur submitResponse(@RequestBody SincereMenteur reponse) {
        return repository.saveSincereMenteur(reponse);
    }

    /**
     * Endpoint pour recuperer les reponses d’un joueur specifique.
     */
    @GetMapping("/response/{idJoueur}")
    public Optional<SincereMenteur> getResponse(@PathVariable long idJoueur) {
        return repository.fetchSincereMenteur(idJoueur);
    }
}
