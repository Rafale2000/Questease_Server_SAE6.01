package fr.uphf.questease.controller;

import fr.uphf.questease.model.Indice;
import fr.uphf.questease.service.IndiceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire d'IndiceRepositoire
 */
@RestController
@RequestMapping("/indice")
public class IndiceController {

    /**
     * Le repositoire de la classe Indice
     */
    private final IndiceServiceImpl repo;

    /**
     * Constructeur de la classe IndiceController
     * @param repo Le repositoire de la classe Indice
     */
    public IndiceController(IndiceServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Méthode Get permettant de récupérer un indice grâce à son Id
     * @param idIndice L'id de l'indice à récupérer
     * @return L'indice qui possède l'id précedemment mentionné
     */
    @GetMapping("/idIndice{idIndice}")
    public Optional<Indice> getIndiceById(@PathVariable Long idIndice) {
        return repo.fetchIndice(idIndice);
    }

    /**
     * Méthode Get permettant de récupérer tout les indices
     * @return Une liste contenant tout les indices
     */
    @GetMapping("")
    public List<Indice> getAllIndices() {
        return repo.fetchIndiceList();
    }

    /**
     * Méthode Post permettant d'ajouter à la base de donnée un indice
     * @param indice L'indice à ajouter à la base de donnée
     */
    @PostMapping("/get{idIndice}")
    public void postIndice(@PathVariable("idIndice") Long idIndice, @RequestBody Indice indice) {
        indice.setId(idIndice);
        repo.saveIndice(indice);
    }

    /**
     * Méthode Update permettant de mettre à jour un indice de la base de donnée
     * @param idIndice L'id de l'indice à mettre à jour
     * @param updatedIndice L'indice qui remplacera celui mis à jour
     */
    @PatchMapping("/{idIndice}")
    public void updateIndice(@PathVariable("idIndice") Long idIndice, @RequestBody Indice updatedIndice) {
        Indice existingIndice = repo.fetchIndice(idIndice).orElseThrow(() -> new RuntimeException("Indice introuvable"));
        existingIndice.setIndiceText(updatedIndice.getHint());
        repo.saveIndice(existingIndice);
    }

    /**
     * Méthode Delete permettant de supprimer un Indice de la base de donnée
     * @param idIndice L'indice supprimé de la base de donnée
     */
    @DeleteMapping("/{idIndice}")
    public void deleteinfoSecu(@PathVariable int idIndice) {
        repo.deleteIndice((long) idIndice);
    }

    /**
     * Méthode GET permettant de récupérer un indice avec son ID.
     *
     * @param idIndice ID de l'indice à récupérer.
     * @return L'objet Indice correspondant à l'ID.
     * @throws ResponseStatusException si l'ID est introuvable.
     */
    @GetMapping("/{idIndice}")
    public Indice getIndice(@PathVariable Long idIndice) {
        return repo.fetchIndice(idIndice)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Indice introuvable pour l'ID : " + idIndice));
    }

}
