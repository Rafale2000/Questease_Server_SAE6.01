package fr.uphf.questease.controller;

import fr.uphf.questease.model.Indice;
import fr.uphf.questease.service.IndiceServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire d'IndiceRepositoire.
 */
@RestController
@RequestMapping("/indice")
public class IndiceController {

    /**
     * Le repositoire de la classe Indice.
     */
    private final IndiceServiceImpl repo;

    /**
     * Constructeur de la classe IndiceController.
     * @param repo Le repositoire de la classe Indice.
     */
    public IndiceController(IndiceServiceImpl repo) {
        this.repo = repo;
    }

    /**
     * Methode Get permettant de recuperer un indice grace a son Id.
     * @param idIndice L'id de l'indice a recuperer.
     * @return L'indice qui possede l'id precedemment mentionne.
     */
    @GetMapping("/idIndice{idIndice}")
    public Optional<Indice> getIndiceById(@PathVariable Long idIndice) {
        return repo.fetchIndice(idIndice);
    }

    /**
     * Methode Get permettant de recuperer tout les indices.
     * @return Une liste contenant tout les indices.
     */
    @GetMapping("")
    public List<Indice> getAllIndices() {
        return repo.fetchIndiceList();
    }

    /**
     * Methode Post permettant d'ajouter a la base de donnee un indice.
     * @param indice L'indice a ajouter a la base de donnee.
     */
    @PostMapping("/get{idIndice}")
    public void postIndice(@PathVariable("idIndice") Long idIndice, @RequestBody Indice indice) {
        indice.setId(idIndice);
        repo.saveIndice(indice);
    }

    /**
     * Methode Update permettant de mettre a jour un indice de la base de donnee.
     * @param idIndice L'id de l'indice a mettre a jour.
     * @param updatedIndice L'indice qui remplacera celui mis a jour.
     */
    @PatchMapping("/{idIndice}")
    public void updateIndice(@PathVariable("idIndice") Long idIndice, @RequestBody Indice updatedIndice) {
        Indice existingIndice = repo.fetchIndice(idIndice).orElseThrow(() -> new RuntimeException("Indice introuvable"));
        existingIndice.setIndiceText(updatedIndice.getHint());
        repo.saveIndice(existingIndice);
    }

    /**
     * Methode Delete permettant de supprimer un Indice de la base de donnee.
     * @param idIndice L'indice supprime de la base de donnee.
     */
    @DeleteMapping("/{idIndice}")
    public void deleteinfoSecu(@PathVariable int idIndice) {
        repo.deleteIndice((long) idIndice);
    }

    /**
     * Methode GET permettant de recuperer un indice avec son ID.
     *
     * @param idIndice ID de l'indice a recuperer.
     * @return L'objet Indice correspondant a l'ID.
     * @throws ResponseStatusException si l'ID est introuvable.
     */
    @GetMapping("/{idIndice}")
    public Indice getIndice(@PathVariable Long idIndice) {
        return repo.fetchIndice(idIndice)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Indice introuvable pour l'ID : " + idIndice));
    }

}
