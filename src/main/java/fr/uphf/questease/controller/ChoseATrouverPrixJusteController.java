package fr.uphf.questease.controller;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.service.ChoseATrouverPrixJusteServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire de ChoseATrouverPrixJuste
 */
@RestController
@RequestMapping("/choseATrouver")
public class ChoseATrouverPrixJusteController {

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
    public ResponseEntity<Optional<ChoseATrouverPrixJuste>> GetChoseById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.ReadChose(id));
    }

    /**
     * Méthode Post permettant d'ajouter un élément mystère du Prix Juste à la base de donnée
     * @param C L'élément à ajouter à la base de donnée
     */
    @PostMapping("/{idChoseATrouver}")
    public void PostChose(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste C) {
        repo.SaveChose(C);
    }

    /**
     * Méthode Update permettant de mettre à jour un élément mystère du Prix Juste dans la base de donnée
     * @param idChoseATrouver L'id de l'élément qui mettra à jour
     * @param C L'élément qui sera mis à jour
     */
    @PatchMapping("/{idChoseATrouver}")
    public void UpdateChoseATrouver(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste C) {
        repo.UpdateChose(C, idChoseATrouver);
    }

    /**
     * Méthode Delete permettant de supprimer un élément de la base de donnée
     * @param idChoseATrouver L'id de l'élément à supprimer
     */
    @DeleteMapping("/{idChoseATrouver}")
    public void DeleteChose(@PathVariable Long idChoseATrouver) {
        repo.DeleteChose(idChoseATrouver);
    }

    /**
     * Méthode GET permettant d'obtenir un objet ChoseATrouverPrixJuste choisi au hasard parmi tous ceux présents dans la base de données.
     * @return ChoseATrouverPrixJuste
     */
    @GetMapping("/random")
    public ChoseATrouverPrixJuste GetRandomChose() {
        List<ChoseATrouverPrixJuste> liste = repo.FetchChoseList();
        return liste.get((int) (Math.random() * ((liste.size()))));
    }

    /**
     * Méthode GET par défault, renvoie tous les elements ChoseATrouverPrixJuste de la base de données.
     * @return une list de ChoseATrouverPrixJuste
     */
    @GetMapping("")
    public List<ChoseATrouverPrixJuste> GetAll(){
        return repo.FetchChoseList();
    }
}

