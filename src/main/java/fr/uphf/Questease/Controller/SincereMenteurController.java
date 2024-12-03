package fr.uphf.Questease.Controller;

import fr.uphf.Questease.Model.SincereMenteur;
import fr.uphf.Questease.Repository.SincereMenteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/sincere_menteur")
public class SincereMenteurController {

    @Autowired
    private SincereMenteurRepository repository;

    // Endpoint pour envoyer les réponses des joueurs
    @PostMapping("/submit")
    public SincereMenteur submitResponse(@RequestBody SincereMenteur reponse) {
        return repository.save(reponse);
    }

    // Endpoint pour récupérer les réponses d’un joueur spécifique
    @GetMapping("/response/{idJoueur}")
    public Optional<SincereMenteur> getResponse(@PathVariable long idJoueur) {
        return repository.findById(idJoueur);
    }
}
