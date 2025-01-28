package fr.uphf.questease.service;

import fr.uphf.questease.model.Utilisateur;

import java.util.List;

/**
 * Interface pour le service de gestion des objets `Utilisateur`.
 * Cette interface définit les opérations CRUD à effectuer sur les objets `Utilisateur`.
 */
public interface UtilisateurService {

    /**
     * Sauvegarde un nouvel objet `Utilisateur` ou met à jour un objet existant.
     *
     * @param utilisateur L'objet `Utilisateur` à sauvegarder.
     * @return L'objet `Utilisateur` sauvegardé.
     */
    public Utilisateur saveUtilisateur(Utilisateur utilisateur);

    /**
     * Récupère la liste de tous les objets `Utilisateur` enregistrés.
     *
     * @return Une liste contenant tous les objets `Utilisateur`.
     */
    public List<Utilisateur> fetchUtilisateurList();

    /**
     * Récupère un ou plusieurs objets `Utilisateur` spécifiques à partir du pseudo de l'utilisateur.
     *
     * @param pseudoUser Le pseudo de l'utilisateur à récupérer.
     * @return Un `Iterable` contenant l'utilisateur correspondant, ou vide si aucun utilisateur n'est trouvé.
     */
    public Iterable<Utilisateur> fetchOne(String pseudoUser);

    /**
     * Met à jour un objet `Utilisateur` existant.
     *
     * @param utilisateur   L'objet contenant les nouvelles informations.
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` à mettre à jour.
     * @return L'objet `Utilisateur` mis à jour.
     */
    public Utilisateur updateUtilisateur(Utilisateur utilisateur, Long utilisateurId);

    /**
     * Supprime un objet `Utilisateur` à partir de son identifiant.
     *
     * @param utilisateurId L'identifiant de l'objet `Utilisateur` à supprimer.
     */
    public void deleteUtilisateur(Long utilisateurId);
}
