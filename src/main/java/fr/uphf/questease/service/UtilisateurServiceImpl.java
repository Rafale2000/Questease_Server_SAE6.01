package fr.uphf.questease.service;

import fr.uphf.questease.model.Utilisateur;
import fr.uphf.questease.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour gerer les objets `Utilisateur`.
 * Cette classe implemente les operations CRUD pour les objets `Utilisateur`.
 */
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    /**
     * Repository utilise pour interagir avec la base de donnees des objets `Utilisateur`.
     */
    @Autowired
    private UtilisateurRepository repo;

    /**
     * Sauvegarde un nouvel objet `Utilisateur` ou met a jour un objet existant.
     * @param utilisateur L'objet `Utilisateur` a sauvegarder.
     * @return L'objet `Utilisateur` sauvegarde.
     */
    @Override
    public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
        return repo.save(utilisateur);
    }

    /**
     * Recupere la liste de tous les objets `Utilisateur` enregistres.
     * @return Une liste contenant tous les objets `Utilisateur`.
     */
    @Override
    public List<Utilisateur> fetchUtilisateurList() {
        return (List<Utilisateur>) repo.findAll();
    }

    /**
     * Recupere un ou plusieurs objets `Utilisateur` specifiques a partir du pseudo de l'utilisateur.
     * @param pseudoUser Le pseudo de l'utilisateur a recuperer.
     * @return Un `Iterable` contenant l'utilisateur correspondant, ou vide si aucun utilisateur n'est trouve.
     */
    @Override
    public Optional<Utilisateur> fetchOne(String pseudoUser) {
        return repo.findUtilByName(pseudoUser);
    }

    /**
     * Met a jour un objet `Utilisateur` existant.
     * @param utilisateur   L'objet contenant les nouvelles informations.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` a mettre a jour.
     * @return L'objet `Utilisateur` mis a jour.
     */
    @Override
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId) {
        repo.deleteById(utilisateurId);
        return repo.save(utilisateur);
    }

    /**
     * Supprime un objet `Utilisateur` a partir de son identifiant.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` a supprimer.
     */
    @Override
    public void deleteUtilisateur(Long utilisateurId) {
        repo.deleteById(utilisateurId);
    }

    /**
     * Renvoie un optional si un objet existe avec un id donnee
     * @param id L'id de l'utilisateur a recuperer.
     * @return Optional
     */
    @Override
    public Optional<Utilisateur> getUser(long id) {
        return repo.findById(id);
    }
}
