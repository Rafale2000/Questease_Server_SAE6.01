package fr.uphf.questease.controller;


import fr.uphf.questease.model.MotCryptex;
import fr.uphf.questease.service.MotCryptexServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller de la classe MotCryptex
 */
@RestController
@RequestMapping("/motcryptex")  // Base path to avoid conflicts
public class MotCryptexController {
    public final Random random = new Random();

    /**
     * Service du repositoire de MotCryptex
     */
    private final MotCryptexServiceImpl repo;

    /**
     * Contructeur de la classe MotCryptexController
     * @param repo le service du repositoire de MotCryptex
     */
    public MotCryptexController(MotCryptexServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un mot via son id
     * @param idMotCryptex L'id du mot récupéré
     * @return Le mot récupéré
     */
    @GetMapping("/idMotCryptex{idMotCryptex}")
    public Optional<MotCryptex> getMotById(@PathVariable Long idMotCryptex) {
        return repo.fetchMotCryptex(idMotCryptex);
    }

    /**
     * Méthode get permettant de récupérer in mot aléatoire de la base de donnée
     * @return Un mot aléatoire de la base de donnée
     */
    @GetMapping("/random")
    public MotCryptex getRandomWord(){
        List<MotCryptex> liste = repo.fetchMotCryptexList();
        return liste.get((random.nextInt() * (liste.size() + 1)));
    }

    /**
     * Méthode Post permettant d'ajouter un mot à la base de donnée
     * @param M Le mot qui sera ajouté à la base de donnée
     */
    @PostMapping("/{idMotCryptex}")
    public void postIndice(@PathVariable MotCryptex M) {
        repo.saveMotCryptex(M);
    }

    /**
     * Méthode Update permettant de mettre à jour un mot de la base de donnée
     * @param idMot L'id du mot qui sera mis à jour
     * @param motCryptex Le mot qui sera mis à jour
     */
    @PatchMapping("/{idMotCryptex}")
    public void updateMot(Long idMot, @PathVariable MotCryptex motCryptex) {
        repo.deleteMotCryptex(idMot);
        repo.saveMotCryptex(motCryptex);
    }

    /**
     * Méthode Delete permettant de supprimer un mot de la base de donnée
     * @param motId Le mot qui sera supprimé de la base de donnée
     */
    @DeleteMapping("/{motId}")
    public void deleteMot(@PathVariable int motId) {
        repo.deleteMotCryptex((long) motId);
    }

    /**
     * Méthode GET qui renvoit une liste contenant tous les MotCryptex de la base de données.
     * @return List<MotCryptex> une liste qui contient des valeurs (s'il y en a dans la BDD)
     */
    @GetMapping("")
    public List<MotCryptex> getMotCryptex() {return repo.fetchMotCryptexList();}

    /**
     * Méthode POST qui renvoit une liste contenant tous les MotCryptex de la base de données.
     * @return List<MotCryptex> une liste qui contient des valeurs (s'il y en a dans la BDD)
     */
    @PostMapping("")
    public List<MotCryptex> getMotCryptexPost() {return repo.fetchMotCryptexList();}

}