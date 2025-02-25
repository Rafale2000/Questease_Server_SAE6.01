package fr.uphf.questease.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import fr.uphf.questease.model.SincereMenteur;
import fr.uphf.questease.repository.SincereMenteurRepository;

/**
 * Implementation du service pour gerer les objets `SincereMenteur`.
 * Cette classe implemente les operations CRUD pour les objets `SincereMenteur`.
 */
@Service
public class SincereMenteurServiceImpl implements SincereMenteurService {

    /**
     * Repository utilise pour interagir avec la base de donnees des objets `SincereMenteur`.
     */
    @Autowired
    private SincereMenteurRepository repo;

    /**
     * Sauvegarde un nouvel objet `SincereMenteur` ou met a jour un objet existant.
     * @param sincereMenteur L'objet `SincereMenteur` a sauvegarder.
     * @return L'objet `SincereMenteur` sauvegarde.
     */
    @Override
    public SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur) {
        return repo.save(sincereMenteur);
    }

    /**
     * Recupere la liste de tous les objets `SincereMenteur` enregistres.
     * @return Une liste contenant tous les objets `SincereMenteur`.
     */
    @Override
    public List<SincereMenteur> fetchSincereMenteur() {
        return (List<SincereMenteur>) repo.findAll();
    }

    /**
     * Recupere un objet `SincereMenteur` specifique a partir de son identifiant.
     * @param id L'identifiant de l'objet a recuperer.
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    @Override
    public Optional<SincereMenteur> fetchSincereMenteur(Long id) {
        return repo.findById(id);
    }

    /**
     * Met a jour un objet `SincereMenteur` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     * @param sincereMenteur      L'objet contenant les nouvelles informations.
     * @param sincereMenteurId    L'identifiant de l'objet a mettre a jour.
     * @return L'objet `SincereMenteur` mis a jour.
     */
    @Override
    public SincereMenteur updateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
        return repo.save(sincereMenteur);
    }

    /**
     * Supprime un objet `SincereMenteur` a partir de son identifiant.
     * @param sincereMenteurId L'identifiant de l'objet a supprimer.
     */
    @Override
    public void deleteInfoSecu(Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
    }
}

