package fr.uphf.questease.service;

import fr.uphf.questease.model.Utilisateur;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des objets `Utilisateur`.
 * Cette interface definit les operations CRUD a effectuer sur les objets `Utilisateur`.
 */
public interface UtilisateurService {

    /**
     * Sauvegarde un nouvel objet `Utilisateur` ou met a jour un objet existant.
     * @param utilisateur L'objet `Utilisateur` a sauvegarder.
     * @return L'objet `Utilisateur` sauvegarde.
     */
    public Utilisateur saveUtilisateur(Utilisateur utilisateur);

    /**
     * Recupere la liste de tous les objets `Utilisateur` enregistres.
     * @return Une liste contenant tous les objets `Utilisateur`.
     */
    public List<Utilisateur> fetchUtilisateurList();

    /**
     * Recupere un ou plusieurs objets `Utilisateur` specifiques a partir du pseudo de l'utilisateur.
     * @param pseudoUser Le pseudo de l'utilisateur a recuperer.
     * @return Un `Iterable` contenant l'utilisateur correspondant, ou vide si aucun utilisateur n'est trouve.
     */
    public Optional<Utilisateur> fetchOne(String pseudoUser);

    /**
     * Met a jour un objet `Utilisateur` existant.
     * @param utilisateur   L'objet contenant les nouvelles informations.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` a mettre a jour.
     * @return L'objet `Utilisateur` mis a jour.
     */
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId);

    /**
     * Supprime un objet `Utilisateur` a partir de son identifiant.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` a supprimer.
     */
    public void deleteUtilisateur(Long utilisateurId);

    /**
     * Recupere un  objets `Utilisateur` specifiques a partir du son id de l'utilisateur.
     * @param id L'id de l'utilisateur a recuperer.
     * @return Un `Iterable` contenant l'utilisateur correspondant, ou vide si aucun utilisateur n'est trouve.
     */
    public Optional<Utilisateur> getUser(long id);
}
