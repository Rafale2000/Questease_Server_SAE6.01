package fr.uphf.questease.controller;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.service.ChoseATrouverPrixJusteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.Random;

/**
 * Controller du repositoire de ChoseATrouverPrixJuste
 */
@RestController
@RequestMapping("/choseATrouver")
public class ChoseATrouverPrixJusteController {
    private final Random random = new Random();

    /**
     * Implémentation du service permettant d'accéder au repositoire
     */
    private final ChoseATrouverPrixJusteServiceImpl repo;

    /**
     * Constructeur de la classe ChoseATrouverPrixJusteController
     * @param repo Repositoire de la classe ChoseATrouverPrixJusteController
     */
    public ChoseATrouverPrixJusteController(ChoseATrouverPrixJusteServiceImpl repo) {
        this.repo = repo;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ChoseATrouverPrixJuste>> getChoseById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.readChose(id));
    }

    /**
     * Méthode Post permettant d'ajouter un élément mystère du Prix Juste à la base de donnée
     * @param c L'élément à ajouter à la base de donnée
     */
    @PostMapping("/{idChoseATrouver}")
    public void postChose(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste c) {
        repo.saveChose(c);
    }

    /**
     * Méthode Update permettant de mettre à jour un élément mystère du Prix Juste dans la base de donnée
     * @param idChoseATrouver L'id de l'élément qui mettra à jour
     * @param c L'élément qui sera mis à jour
     */
    @PatchMapping("/{idChoseATrouver}")
    public void updateChoseATrouver(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste c) {
        repo.updateChose(c, idChoseATrouver);
    }

    /**
     * Méthode Delete permettant de supprimer un élément de la base de donnée
     * @param idChoseATrouver L'id de l'élément à supprimer
     */
    @DeleteMapping("/{idChoseATrouver}")
    public void deleteChose(@PathVariable Long idChoseATrouver) {
        repo.deleteChose(idChoseATrouver);
    }

    /**
     * Méthode GET permettant d'obtenir un objet ChoseATrouverPrixJuste choisi au hasard parmi tous ceux présents dans la base de données.
     * @return ChoseATrouverPrixJuste
     */
    @GetMapping("/random")
    public ChoseATrouverPrixJuste getRandomChose() {
        List<ChoseATrouverPrixJuste> liste = repo.fetchChoseList();

        return liste.get((random.nextInt() * (liste.size())));
    }

    /**
     * Méthode GET par défault, renvoie tous les elements ChoseATrouverPrixJuste de la base de données.
     * @return une list de ChoseATrouverPrixJuste
     */
    @GetMapping("")
    public List<ChoseATrouverPrixJuste> getAll(){
        return repo.fetchChoseList();
    }
}

