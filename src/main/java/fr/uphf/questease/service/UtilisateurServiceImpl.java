package fr.uphf.questease.service;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implémentation du service pour gérer les objets `Utilisateur`.
 * Cette classe implémente les opérations CRUD pour les objets `Utilisateur`.
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService{

    // Repository utilisé pour interagir avec la base de données des objets `Utilisateur`.
    @Autowired
    private UtilisateurRepository repo;

    /**
     * Sauvegarde un nouvel objet `Utilisateur` ou met à jour un objet existant.
     *
     * @param utilisateur L'objet `Utilisateur` à sauvegarder.
     * @return L'objet `Utilisateur` sauvegardé.
     */
    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return repo.save(utilisateur);
    }

    /**
     * Récupère la liste de tous les objets `Utilisateur` enregistrés.
     *
     * @return Une liste contenant tous les objets `Utilisateur`.
     */
    @Override
    public List<Utilisateur> fetchUtilisateurList() {
        return (List<Utilisateur>) repo.findAll();
    }

    /**
     * Récupère un ou plusieurs objets `Utilisateur` spécifiques à partir du pseudo de l'utilisateur.
     *
     * @param pseudoUser Le pseudo de l'utilisateur à récupérer.
     * @return Un `Iterable` contenant l'utilisateur correspondant, ou vide si aucun utilisateur n'est trouvé.
     */
    @Override
    public Iterable<Utilisateur> fetchOne(String pseudoUser){
        return repo.findUtilByName(pseudoUser);
    }

    /**
     * Met à jour un objet `Utilisateur` existant.
     *
     * @param utilisateur   L'objet contenant les nouvelles informations.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` à mettre à jour.
     * @return L'objet `Utilisateur` mis à jour.
     */
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId) {
        repo.deleteById(utilisateurId);
        return repo.save(utilisateur);
    }

    /**
     * Supprime un objet `Utilisateur` à partir de son identifiant.
     *
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` à supprimer.
     */
    @Override
    public void deleteUtilisateur(Long utilisateurId) {
        repo.deleteById(utilisateurId);
    }
}
