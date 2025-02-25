package fr.uphf.questease.service;

import fr.uphf.questease.model.Son;
import fr.uphf.questease.repository.SonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour gerer les objets `Son`.
 * Cette classe implemente les operations CRUD pour les objets `Son`.
 */
@Service
public class SonServiceImpl implements SonService {

    /**
     * Repository utilise pour interagir avec la base de donnees des objets `Son`.
     */
    @Autowired
    private SonRepository repo;

    /**
     * Sauvegarde un nouvel objet `Son` ou met a jour un objet existant.
     * @param son L'objet `Son` a sauvegarder.
     * @return L'objet `Son` sauvegarde.
     */
    @Override
    public Son saveSon(Son son) {
        return repo.save(son);
    }

    /**
     * Recupere la liste de tous les objets `Son` enregistres.
     * @return Une liste contenant tous les objets `Son`.
     */
    @Override
    public List<Son> fetchSonList() {
        return (List<Son>) repo.findAll();
    }

    /**
     * Recupere un objet `Son` specifique a partir de son identifiant.
     * @param idSon L'identifiant de l'objet a recuperer.
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    @Override
    public Optional<Son> fetchOne(Long idSon){
        return repo.findById(idSon);
    }

    /**
     * Met a jour un objet `Son` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     * @param son   L'objet contenant les nouvelles informations.
     * @param sonId L'identifiant de l'objet a mettre a jour.
     * @return L'objet `Son` mis a jour.
     */
    @Override
    public Son updateSon(Son son, Long sonId) {
        repo.deleteById(sonId);
        return repo.save(son);
    }

    /**
     * Methode qui supprime un son de la base de donnee
     * @param sonId L'identifiant de l'objet a supprimer.
     */
    @Override
    public void deleteSon(Long sonId) {
        repo.deleteById(sonId);
    }
}
