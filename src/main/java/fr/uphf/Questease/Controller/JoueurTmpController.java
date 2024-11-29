package fr.uphf.Questease.Controller;

import fr.uphf.Questease.Model.JoueurTmp;
import fr.uphf.Questease.Service.JoueurTmpServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controller du repositoire d'Utilisateur
 */
@RestController
@RequestMapping("/utilisateur")
public class JoueurTmpController {

    /**
     * Le repositoire d'Utilisateur
     */
    private final JoueurTmpServiceImpl UtilRepository;

    /**
     * Le constructeur d'UtilisateurController
     * @param utililisateurRepository Le repositoire d'Utilisateur
     */
    public JoueurTmpController(JoueurTmpServiceImpl utililisateurRepository) {
        UtilRepository = utililisateurRepository;
    }
    /**
     * Méthode Get pour récupérer un Utilisateur via son nom
     * @param idJoueur L'id de l'Utilisateur à trouver
     * @return L'Utilisateur à trouver
    **/
    @GetMapping("/{idUtil}")
    public ResponseEntity<Optional<JoueurTmp>> getUserByName(@PathVariable Long idJoueur){
        return ResponseEntity.ok(UtilRepository.FetchOne(idJoueur));
    }

    /**
     * Méthode Post permettant d'ajouter un Utilisateur à la base de donnée
     * @param Util L'utilisateur à ajouté à la base de donnée
    **/
    @PostMapping("/{idUtil}")
    public void PostUser(@PathVariable JoueurTmp Util){
        UtilRepository.SaveJoueur(Util);
    }

    /**
     * Méthode Update permettant de mettre à jour un Utilisateur dans la base de donnée
     * @param IdUser L'id de L'Utilisateur à mettre à jour
     * @param Util L'utilisateur qui sera mis à jour
    **/
    @PatchMapping("/{idUtil}")
    public void UpdateUser(Long IdUser, @PathVariable JoueurTmp Util){
        UtilRepository.DeleteJoueur(IdUser);
        UtilRepository.SaveJoueur(Util);
    }

    /**
     * Méthode Delete permettant de supprimer un Utilisateur de la base de donnée
     * @param idUtil L'id de l'Utilisateur à supprimer de la base de donnée
    **/
    @DeleteMapping("/{idUtil}")
    public void DeleteUser(@PathVariable Long idUtil){
        UtilRepository.DeleteJoueur(idUtil);
    }

    /**
     * Méthode GET qui renvoie tous les JoueurTmp de la base de données
     * @return une list de JoueurTmp
     */
    @GetMapping()
    public List<JoueurTmp> GetAllUserGet(){return UtilRepository.FetchJoueurList();}

    /**
     * Méthode POST qui renvoie tous les JoueurTmp de la base de données
     * @return une list de JoueurTmp
     */
    @PostMapping()
    public List<JoueurTmp> GetAllUserPost(){return UtilRepository.FetchJoueurList();}

}
