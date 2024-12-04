package fr.uphf.Questease.Controller;


import fr.uphf.Questease.Model.MotCryptex;
import fr.uphf.Questease.Service.MotCryptexServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller de la classe MotCryptex
 */
@RestController
@RequestMapping("/motcryptex")  // Base path to avoid conflicts
public class MotCryptexController {

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
    @GetMapping("/idMotCryptex")
    public Optional<MotCryptex> getMotById(@PathVariable Long idMotCryptex) {
        return repo.FetchMotCryptex(idMotCryptex);
    }

    /**
     * Méthode get permettant de récupérer in mot aléatoire de la base de donnée
     * @return Un mot aléatoire de la base de donnée
     */
    @GetMapping("/random")
    public MotCryptex getRandomWord(){
        List<MotCryptex> liste = repo.FetchMotCryptexList();
        return liste.get((int) (Math.random() * ((liste.size()) + 1)));
    }

    /**
     * Méthode Post permettant d'ajouter un mot à la base de donnée
     * @param M Le mot qui sera ajouté à la base de donnée
     */
    @PostMapping("/{idMotCryptex}")
    public void PostIndice(@PathVariable MotCryptex M) {
        repo.SaveMotCryptex(M);
    }

    /**
     * Méthode Update permettant de mettre à jour un mot de la base de donnée
     * @param IdMot L'id du mot qui sera mis à jour
     * @param M Le mot qui sera mis à jour
     */
    @PatchMapping("/{idMotCryptex}")
    public void UpdateMot(Long IdMot, @PathVariable MotCryptex M) {
        repo.deleteMotCryptex(IdMot);
        repo.SaveMotCryptex(M);
    }

    /**
     * Méthode Delete permettant de supprimer un mot de la base de donnée
     * @param M Le mot qui sera supprimé de la base de donnée
     */
    @DeleteMapping("/{idMoCryptex}")
    public void DeleteMot(@PathVariable MotCryptex M) {
        repo.deleteMotCryptex(M.getId());
    }

    /**
     * Méthode GET qui renvoit une liste contenant tous les MotCryptex de la base de données.
     * @return List<MotCryptex> une liste qui contient des valeurs (s'il y en a dans la BDD)
     */
    @GetMapping("")
    public List<MotCryptex> getMotCryptex() {return repo.FetchMotCryptexList();}

    /**
     * Méthode POST qui renvoit une liste contenant tous les MotCryptex de la base de données.
     * @return List<MotCryptex> une liste qui contient des valeurs (s'il y en a dans la BDD)
     */
    @PostMapping("")
    public List<MotCryptex> getMotCryptexPost() {return repo.FetchMotCryptexList();}

}