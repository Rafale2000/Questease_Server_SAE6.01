package fr.uphf.questease.service;

import fr.uphf.questease.model.Son;
import fr.uphf.questease.repository.SonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour gérer les objets `Son`.
 * Cette classe implémente les opérations CRUD pour les objets `Son`.
 */
@Service
public class SonServiceImpl implements SonService {

    // Repository utilisé pour interagir avec la base de données des objets `Son`.
    @Autowired
    private SonRepository repo;

    /**
     * Sauvegarde un nouvel objet `Son` ou met à jour un objet existant.
     *
     * @param son L'objet `Son` à sauvegarder.
     * @return L'objet `Son` sauvegardé.
     */
    @Override
    public Son saveSon(Son son) {
        return repo.save(son);
    }

    /**
     * Récupère la liste de tous les objets `Son` enregistrés.
     *
     * @return Une liste contenant tous les objets `Son`.
     */
    @Override
    public List<Son> fetchSonList() {
        return (List<Son>) repo.findAll();
    }

    /**
     * Récupère un objet `Son` spécifique à partir de son identifiant.
     *
     * @param idSon L'identifiant de l'objet à récupérer.
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<Son> fetchOne(Long idSon){
        return repo.findById(idSon);
    }

    /**
     * Met à jour un objet `Son` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     *
     * @param son   L'objet contenant les nouvelles informations.
     * @param sonId L'identifiant de l'objet à mettre à jour.
     * @return L'objet `Son` mis à jour.
     */
    @Override
    public Son updateSon(Son son, Long sonId) {
        repo.deleteById(sonId);
        return repo.save(son);
    }

    /**
     * Méthode qui supprime un son de la base de donnée
     * @param sonId L'identifiant de l'objet à supprimer.
     */
    @Override
    public void deleteSon(Long sonId) {
        repo.deleteById(sonId);
    }
}
