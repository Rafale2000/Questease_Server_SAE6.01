package fr.uphf.questease.controller;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.service.UtilisateurServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire d'Utilisateur.
 */
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    /**
     * Le repositoire d'Utilisateur.
     */
    private final UtilisateurServiceImpl UtilRepository;

    /**
     * Le constructeur d'UtilisateurController.
     * @param utililisateurRepository Le repositoire d'Utilisateur.
     */
    public UtilisateurController(UtilisateurServiceImpl utililisateurRepository) {
        UtilRepository = utililisateurRepository;
    }
    /**
     * Methode Get pour recuperer un Utilisateur via son nom.
     * @param nameUtil Le nom de l'Utilisateur a trouver.
     * @return L'Utilisateur a trouver.
    **/
    @GetMapping("/{idUtil}")
    public ResponseEntity<Optional<Utilisateur>> getUserByName(@PathVariable String nameUtil){
        return ResponseEntity.ok(UtilRepository.fetchOne(nameUtil));
    }

    /**
     * Methode Post permettant d'ajouter un Utilisateur a la base de donnee.
     * @param Util L'utilisateur a ajoute a la base de donnee.
    **/
    @PostMapping("/{idUtil}")
    public void postUser(@PathVariable Utilisateur Util){
        UtilRepository.saveUtilisateur(Util);
    }

    /**
     * Methode Update permettant de mettre a jour un Utilisateur dans la base de donnee.
     * @param idUtil L'id de L'Utilisateur a mettre a jour.
     * @param util L'utilisateur qui sera mis a jour.
    **/
    @PatchMapping("/{idUtil}")
    public void updateUser(Long idUtil, @PathVariable Utilisateur util){
        UtilRepository.updateUtilisateur(util,idUtil);
    }

    /**
     * Methode Delete permettant de supprimer un Utilisateur de la base de donnee.
     * @param idUtil L'id de l'Utilisateur a supprimer de la base de donnee.
    **/
    @DeleteMapping("/{idUtil}")
    public void deleteUser(@PathVariable Long idUtil){
        UtilRepository.deleteUtilisateur(idUtil);
    }

    /**
     * Methode GET qui renvoie tous les JoueurTmp de la base de donnees.
     * @return une list de JoueurTmp.
     */
    @GetMapping()
    public List<Utilisateur> getAllUserGet(){return UtilRepository.fetchUtilisateurList();}

    /**
     * Methode POST qui renvoie tous les JoueurTmp de la base de donnees.
     * @return une list de JoueurTmp.
     */
    @PostMapping()
    public List<Utilisateur> getAllUserPost(){return UtilRepository.fetchUtilisateurList();}

}
