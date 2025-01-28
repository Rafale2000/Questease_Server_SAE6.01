package fr.uphf.questease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import fr.uphf.questease.model.SincereMenteur;
import fr.uphf.questease.repository.SincereMenteurRepository;

/**
 * Implémentation du service pour gérer les objets `SincereMenteur`.
 * Cette classe implémente les opérations CRUD pour les objets `SincereMenteur`.
 */
@Service
public class SincereMenteurServiceImpl implements SincereMenteurService {
    // Repository utilisé pour interagir avec la base de données des objets `SincereMenteur`.
    @Autowired
    private SincereMenteurRepository repo;

    /**
     * Sauvegarde un nouvel objet `SincereMenteur` ou met à jour un objet existant.
     *
     * @param sincereMenteur L'objet `SincereMenteur` à sauvegarder.
     * @return L'objet `SincereMenteur` sauvegardé.
     */
    @Override
    public SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur) {
        return repo.save(sincereMenteur);
    }

    /**
     * Récupère la liste de tous les objets `SincereMenteur` enregistrés.
     *
     * @return Une liste contenant tous les objets `SincereMenteur`.
     */
    @Override
    public List<SincereMenteur> fetchSincereMenteur() {
        return (List<SincereMenteur>) repo.findAll();
    }

    /**
     * Récupère un objet `SincereMenteur` spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de l'objet à récupérer.
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<SincereMenteur> fetchSincereMenteur(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour un objet `SincereMenteur` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     *
     * @param sincereMenteur      L'objet contenant les nouvelles informations.
     * @param sincereMenteurId    L'identifiant de l'objet à mettre à jour.
     * @return L'objet `SincereMenteur` mis à jour.
     */
    @Override
    public SincereMenteur updateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
        return repo.save(sincereMenteur);
    }

    /**
     * Supprime un objet `SincereMenteur` à partir de son identifiant.
     *
     * @param sincereMenteurId L'identifiant de l'objet à supprimer.
     */
    @Override
    public void deleteInfoSecu(Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
    }
}

