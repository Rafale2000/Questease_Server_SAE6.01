package fr.uphf.questease.controller;

import fr.uphf.questease.model.MotPendu;
import fr.uphf.questease.service.MotPenduServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller du repositoire de motPendu
 */
@RestController
@RequestMapping("/motpendu")
public class MotPenduController {
    public final Random random = new Random();

    /**
     * Le repositoire de motPendu
     */
    private final MotPenduServiceImpl repo;

    /**
     * Le constructeur de la classe motPenduController
     * @param repo le repositoire de motPendu
     */
    public MotPenduController(MotPenduServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un mot via son id
     * @param idMotPendu L'id du mot à trouver lors d'un pendu
     * @return Le mot à trouver
     */
    @GetMapping("/{idMotPendu}")
    public Optional<MotPendu> getMotById(@PathVariable Long idMotPendu) {
        return repo.fetchOneMotPendu(idMotPendu);
    }

    /**
     * Méthode Post permettant d'ajouter un mot à la base de donnée
     * @param M Le mot à ajouter à la base de donnée
     */
    @PostMapping("/{idMotPendu}")
    public void PostMot(@PathVariable MotPendu M) {
        repo.saveMotPendu(M);
    }

    /**
     * Méthode Update permettant de mettre à jour un mot dans la base de donnée
     * @param idMotPendu L'id du mot à mettre à jour
     * @param M Le mot qui sera mis à jour
     */
    @PatchMapping("/{idMotPendu}")
    public void updateMot(Long idMotPendu, @PathVariable MotPendu M) {
        repo.deleteMotPendu(idMotPendu);
        repo.saveMotPendu(M);
    }

    /**
     * Méthode Delete permettant de supprimer un mot dans la base de donnée
     * @param idPendu L'id du mot dans la base de donnée à supprimer
     */
    @DeleteMapping("/{idPendu}")
    public void deleteMot(@PathVariable Long idPendu) {
        repo.deleteMotPendu(idPendu);
    }

    @GetMapping()
    public List<MotPendu> getAllMotGet() {return repo.fetchMotPenduList();}

    /**
     * Méthode GET permettant d'obtenir un objet MotPendu choisi au hasard parmi tous ceux présents dans la base de données.
     * @return MotPendu
     */
    @GetMapping("/random")
    public MotPendu getRandomMotPendu() {
        List<MotPendu> liste = repo.fetchMotPenduList();
        return liste.get(random.nextInt() * (liste.size()));
    }
}


