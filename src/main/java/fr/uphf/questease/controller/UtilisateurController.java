package fr.uphf.questease.controller;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.Service.UtilisateurServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller du repositoire d'Utilisateur
 */
@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {

    /**
     * Le repositoire d'Utilisateur
     */
    private final UtilisateurServiceImpl UtilRepository;

    /**
     * Le constructeur d'UtilisateurController
     * @param utililisateurRepository Le repositoire d'Utilisateur
     */
    public UtilisateurController(UtilisateurServiceImpl utililisateurRepository) {
        UtilRepository = utililisateurRepository;
    }
    /**
     * Méthode Get pour récupérer un Utilisateur via son nom
     * @param nameUtil Le nom de l'Utilisateur à trouver
     * @return L'Utilisateur à trouver
    **/
    @GetMapping("/{idUtil}")
    public ResponseEntity<Iterable<Utilisateur>> getUserByName(@PathVariable String nameUtil){
        return ResponseEntity.ok(UtilRepository.FetchOne(nameUtil));
    }

    /**
     * Méthode Post permettant d'ajouter un Utilisateur à la base de donnée
     * @param Util L'utilisateur à ajouté à la base de donnée
    **/
    @PostMapping("/{idUtil}")
    public void PostUser(@PathVariable Utilisateur Util){
        UtilRepository.SaveUtilisateur(Util);
    }

    /**
     * Méthode Update permettant de mettre à jour un Utilisateur dans la base de donnée
     * @param IdUser L'id de L'Utilisateur à mettre à jour
     * @param Util L'utilisateur qui sera mis à jour
    **/
    @PatchMapping("/{idUtil}")
    public void UpdateUser(Long IdUser, @PathVariable Utilisateur Util){
        UtilRepository.DeleteUtilisateur(IdUser);
        UtilRepository.SaveUtilisateur(Util);
    }

    /**
     * Méthode Delete permettant de supprimer un Utilisateur de la base de donnée
     * @param idUtil L'id de l'Utilisateur à supprimer de la base de donnée
    **/
    @DeleteMapping("/{idUtil}")
    public void DeleteUser(@PathVariable Long idUtil){
        UtilRepository.DeleteUtilisateur(idUtil);
    }

    /**
     * Méthode GET qui renvoie tous les JoueurTmp de la base de données
     * @return une list de JoueurTmp
     */
    @GetMapping()
    public List<Utilisateur> GetAllUserGet(){return UtilRepository.FetchUtilisateurList();}

    /**
     * Méthode POST qui renvoie tous les JoueurTmp de la base de données
     * @return une list de JoueurTmp
     */
    @PostMapping()
    public List<Utilisateur> GetAllUserPost(){return UtilRepository.FetchUtilisateurList();}

}
