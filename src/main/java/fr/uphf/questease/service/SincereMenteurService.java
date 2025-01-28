package fr.uphf.questease.service;

import java.util.List;
import java.util.Optional;


import fr.uphf.questease.model.SincereMenteur;

/**
 * Interface pour le service de gestion des objets `SincereMenteur`.
 * Fournit des fonctionnalités CRUD pour les objets `SincereMenteur`.
 */
public interface SincereMenteurService {
    /**
     * Sauvegarde un nouvel objet `SincereMenteur` ou met à jour un objet existant.
     *
     * @param sincereMenteur L'objet `SincereMenteur` à sauvegarder.
     * @return L'objet `SincereMenteur` sauvegardé.
     */
    SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur);

    /**
     * Récupère la liste de tous les objets `SincereMenteur` enregistrés.
     *
     * @return Une liste contenant tous les objets `SincereMenteur`.
     */
    List<SincereMenteur> fetchSincereMenteur();

    /**
     * Récupère un objet `SincereMenteur` spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de l'objet à récupérer.
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    Optional<SincereMenteur> fetchSincereMenteur(Long id);

    /**
     * Met à jour un objet `SincereMenteur` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     *
     * @param sincereMenteur      L'objet contenant les nouvelles informations.
     * @param sincereMenteurId    L'identifiant de l'objet à mettre à jour.
     * @return L'objet `SincereMenteur` mis à jour.
     */
    SincereMenteur updateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId);

    /**
     * Supprime un objet `SincereMenteur` à partir de son identifiant.
     *
     * @param sincereMenteurId L'identifiant de l'objet à supprimer.
     */
    void deleteInfoSecu(Long sincereMenteurId);
}



