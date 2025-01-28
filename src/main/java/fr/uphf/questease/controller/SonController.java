package fr.uphf.questease.controller;


import fr.uphf.questease.model.Son;
import fr.uphf.questease.service.SonServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller du repositoire de Son
 */
@RestController
@RequestMapping("/son")
public class SonController {

    public final Random rand = new Random();

    /**
     * Le repositoire de Son
     */
    private final SonServiceImpl repo;

    /**
     * Le constructeur de SonController
     * @param repo Le repositoire de Son
     */
    public SonController(SonServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un Son via son id
     * @param idSon L'id du son à récupérer
     * @return Le son à récupérer
     */
    @GetMapping("/idSon")
    public Optional<Son> getSonById(@PathVariable Long idSon) {
        return repo.fetchOne(idSon);
    }

    /**
     * Méthode Post permettant d'ajouter un Son à la base de donnée
     * @param son
     */
    @PostMapping("/{idSon}")
    public void postSon(@PathVariable Son son) {
        repo.saveSon(son);
    }


    /**
     * Méthode Update permettant de mettre à jour un Son dans la base de donnée
     * @param idSon L'id du Son à mettre à jour
     * @param son Le son qui sera mis à jour
     */
    @PatchMapping("/{idSon}")
    public void updateSon(Long idSon, @PathVariable Son son) {
        repo.deleteSon(idSon);
        repo.saveSon(son);
    }

    /**
     * Méthode Delete permettant de supprimer un Son dans la base de donnée
     * @param idSon L'id du son à supprimer
     */
    @DeleteMapping("/{idSon}")
    public void deleteSon(@PathVariable Long idSon) {
        repo.deleteSon(idSon);
    }

    /**
     * Méthode get qui renvoie tous les sons de la base de donnée
     * @return List<Son>
     */
    @GetMapping()
    public List<Son> getAllSonGet() {return repo.fetchSonList();}

    /**
     * Méthode get qui renvoie tous les sons de la base de donnée
     * @return List<Son>
     */
    @PostMapping()
    public List<Son> getAllSonPost() {return repo.fetchSonList();}

    /**
     * Méthode get qui renvoie un Son random contenu dans la base de données
     * @return List<Son>
     */
    @GetMapping("/random")
    public Son getRandomSon() {

        return repo.fetchSonList().get(rand.nextInt(repo.fetchSonList().size()));
    }
}
