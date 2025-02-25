package fr.uphf.questease.controller;


import fr.uphf.questease.model.Son;
import fr.uphf.questease.service.SonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller du repositoire de Son.
 */
@RestController
@RequestMapping("/son")
public class SonController {

    /**
     * Generation du chiffre au hasard.
     */
    public final Random rand = new Random();

    /**
     * Le repositoire de Son.
     */
    private final SonServiceImpl repo;

    /**
     * Le constructeur de SonController.
     * @param repo Le repositoire de Son.
     */
    public SonController(SonServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Methode Get permettant de recuperer un Son via son id.
     * @param idSon L'id du son a recuperer.
     * @return Le son a recuperer.
     */
    @GetMapping("/idSon")
    public ResponseEntity<Optional<Son>> getSonById(@PathVariable Long idSon) {
        return ResponseEntity.ok(repo.fetchOne(idSon));
    }

    /**
     * Methode Post permettant d'ajouter un Son a la base de donnees.
     * @param son Le Son qui sera ajoute a la base de donnees.
     */
    @PostMapping("/{idSon}")
    public void postSon(@PathVariable Son son) {
        repo.saveSon(son);
    }


    /**
     * Methode Update permettant de mettre a jour un Son dans la base de donnees.
     * @param idSon L'id du Son a mettre a jour.
     * @param son Le son qui sera mis a jour.
     */
    @PatchMapping("/{idSon}")
    public void updateSon(@PathVariable Long idSon, @RequestBody Son son) {
        repo.updateSon(son,idSon);
    }

    /**
     * Methode Delete permettant de supprimer un Son dans la base de donnees.
     * @param idSon L'id du son a supprimer.
     */
    @DeleteMapping("/{idSon}")
    public void deleteSon(@PathVariable Long idSon) {
        repo.deleteSon(idSon);
    }

    /**
     * Methode Get qui renvoie tous les sons de la base de donnees.
     * @return List<Son> La liste de tout les Sons.
     */
    @GetMapping()
    public List<Son> getAllSonGet() {return repo.fetchSonList();}

    /**
     * Methode Post qui renvoie tous les sons de la base de donnees.
     * @return List<Son> La liste de tout les Sons.
     */
    @PostMapping()
    public List<Son> getAllSonPost() {return repo.fetchSonList();}

    /**
     * Methode get qui renvoie un Son au hasard contenu dans la base de donnees.
     * @return Son Un Son au hasard de la base de donnees.
     */
    @GetMapping("/random")
    public Son getRandomSon() {
        return repo.fetchSonList().get(rand.nextInt(repo.fetchSonList().size()));
    }
}
