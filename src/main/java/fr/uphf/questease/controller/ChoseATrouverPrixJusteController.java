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

    /**
     * Generation d'un chiffre au hasard
     */
    private final Random random = new Random();

    /**
     * Implementation du service permettant d'acceder au repositoire
     */
    private final ChoseATrouverPrixJusteServiceImpl repo;

    /**
     * Constructeur de la classe ChoseATrouverPrixJusteController
     * @param repo Repositoire de la classe ChoseATrouverPrixJusteController
     */
    public ChoseATrouverPrixJusteController(ChoseATrouverPrixJusteServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Methode Get permettant de recuperer un element de la BDD selon son id.
     * @param id L'id de l'element a recuperer.
     * @return L'element a recuperer.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ChoseATrouverPrixJuste>> getChoseById(@PathVariable Long id) {
        return ResponseEntity.ok(repo.readChose(id));
    }

    /**
     * Methode Post permettant d'ajouter un element mystere du Prix Juste a la base de donnee
     * @param c L'element a ajouter a la base de donnee
     */
    @PostMapping("/{idChoseATrouver}")
    public void postChose(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste c) {
        repo.saveChose(c);
    }

    /**
     * Methode Update permettant de mettre a jour un element mystere du Prix Juste dans la base de donnee
     * @param idChoseATrouver L'id de l'element qui mettra a jour
     * @param c L'element qui sera mis a jour
     */
    @PatchMapping("/{idChoseATrouver}")
    public void updateChoseATrouver(@PathVariable Long idChoseATrouver, @RequestBody ChoseATrouverPrixJuste c) {
        repo.updateChose(c, idChoseATrouver);
    }

    /**
     * Methode Delete permettant de supprimer un element de la base de donnee
     * @param idChoseATrouver L'id de l'element a supprimer
     */
    @DeleteMapping("/{idChoseATrouver}")
    public void deleteChose(@PathVariable Long idChoseATrouver) {
        repo.deleteChose(idChoseATrouver);
    }

    /**
     * Methode GET permettant d'obtenir un objet ChoseATrouverPrixJuste choisi au hasard parmi tout ceux presents dans la base de donnees.
     * @return ChoseATrouverPrixJuste
     */
    @GetMapping("/random")
    public ChoseATrouverPrixJuste getRandomChose() {
        List<ChoseATrouverPrixJuste> liste = repo.fetchChoseList();
        return liste.get((random.nextInt() * (liste.size())));
    }

    /**
     * Methode GET par defaut, renvoie tous les elements ChoseATrouverPrixJuste de la base de donnees.
     * @return une list de ChoseATrouverPrixJuste
     */
    @GetMapping("")
    public List<ChoseATrouverPrixJuste> getAll(){
        return repo.fetchChoseList();
    }
}

