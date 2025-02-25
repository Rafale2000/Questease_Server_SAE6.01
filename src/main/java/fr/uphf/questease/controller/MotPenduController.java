package fr.uphf.questease.controller;

import fr.uphf.questease.model.MotPendu;
import fr.uphf.questease.service.MotPenduServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller du repositoire de motPendu.
 */
@RestController
@RequestMapping("/motpendu")
public class MotPenduController {

    /**
     * Generation d'un chiffre au hasard.
     */
    public final Random random = new Random();

    /**
     * Le repositoire de motPendu.
     */
    private final MotPenduServiceImpl repo;

    /**
     * Le constructeur de la classe motPenduController.
     * @param repo le repositoire de motPendu.
     */
    public MotPenduController(MotPenduServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Methode Get permettant de recuperer un mot via son id.
     * @param idMotPendu L'id du mot a trouver lors d'un pendu.
     * @return Le mot a trouver.
     */
    @GetMapping("/{idMotPendu}")
    public ResponseEntity<Optional<MotPendu>> getMotById(@PathVariable Long idMotPendu) {
        return ResponseEntity.ok(repo.fetchOneMotPendu(idMotPendu));
    }

    /**
     * Methode Post permettant d'ajouter un mot a la base de donnee.
     * @param M Le mot a ajouter a la base de donnee.
     */
    @PostMapping("/{idMotPendu}")
    public void PostMot(@PathVariable MotPendu M) {
        repo.saveMotPendu(M);
    }

    /**
     * Methode Update permettant de mettre a jour un mot dans la base de donnee.
     * @param idMotPendu L'id du mot a mettre a jour.
     * @param mot Le mot qui sera mis a jour.
     */
    @PatchMapping("/{idMotPendu}")
    public void updateMot(Long idMotPendu, @PathVariable MotPendu mot) {
        repo.updateMotPendu(mot,idMotPendu);
    }

    /**
     * Methode Delete permettant de supprimer un mot dans la base de donnee.
     * @param idPendu L'id du mot dans la base de donnee a supprimer.
     */
    @DeleteMapping("/{idPendu}")
    public void deleteMot(@PathVariable Long idPendu) {
        repo.deleteMotPendu(idPendu);
    }

    /**
     * Methode Get permettant de recuperer tous les Mots possibles pour une partie de Pendu.
     * @return tous les Mots possibles pour une partie de Pendu.
     */
    @GetMapping()
    public List<MotPendu> getAllMotGet() {return repo.fetchMotPenduList();}

    /**
     * Methode GET permettant d'obtenir un objet MotPendu choisi au hasard parmi tous ceux presents dans la base de donnees.
     * @return Un mot Pendu recuperer au hasard.
     */
    @GetMapping("/random")
    public MotPendu getRandomMotPendu() {
        List<MotPendu> liste = repo.fetchMotPenduList();
        return liste.get(random.nextInt() * (liste.size()));
    }
}


