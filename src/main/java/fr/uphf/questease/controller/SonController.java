package fr.uphf.questease.controller;


import fr.uphf.questease.Model.Son;
import fr.uphf.questease.Service.SonServiceImpl;
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
        return repo.FetchOne(idSon);
    }

    /**
     * Méthode Post permettant d'ajouter un Son à la base de donnée
     * @param S
     */
    @PostMapping("/{idSon}")
    public void PostSon(@PathVariable Son S) {
        repo.SaveSon(S);
    }


    /**
     * Méthode Update permettant de mettre à jour un Son dans la base de donnée
     * @param IdSon L'id du Son à mettre à jour
     * @param S Le son qui sera mis à jour
     */
    @PatchMapping("/{idSon}")
    public void UpdateSon(Long IdSon, @PathVariable Son S) {
        repo.DeleteSon(IdSon);
        repo.SaveSon(S);
    }

    /**
     * Méthode Delete permettant de supprimer un Son dans la base de donnée
     * @param idSon L'id du son à supprimer
     */
    @DeleteMapping("/{idSon}")
    public void DeleteSon(@PathVariable Long idSon) {
        repo.DeleteSon(idSon);
    }

    /**
     * Méthode get qui renvoie tous les sons de la base de donnée
     * @return List<Son>
     */
    @GetMapping()
    public List<Son> GetAllSonGet() {return repo.FetchSonList();}

    /**
     * Méthode get qui renvoie tous les sons de la base de donnée
     * @return List<Son>
     */
    @PostMapping()
    public List<Son> GetAllSonPost() {return repo.FetchSonList();}

    /**
     * Méthode get qui renvoie un Son random contenu dans la base de données
     * @return List<Son>
     */
    @GetMapping("/random")
    public Son GetRandomSon() {
        Random rand = new Random();
        return repo.FetchSonList().get(rand.nextInt(repo.FetchSonList().size()));
    }
}
