package fr.uphf.questease.service;

import java.util.List;
import java.util.Optional;


import fr.uphf.questease.model.SincereMenteur;

/**
 * Interface pour le service de gestion des objets `SincereMenteur`.
 * Fournit des fonctionnalites CRUD pour les objets `SincereMenteur`.
 */
public interface SincereMenteurService {

    /**
     * Sauvegarde un nouvel objet `SincereMenteur` ou met a jour un objet existant.
     * @param sincereMenteur L'objet `SincereMenteur` a sauvegarder.
     * @return L'objet `SincereMenteur` sauvegarde.
     */
    SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur);

    /**
     * Recupere la liste de tous les objets `SincereMenteur` enregistres.
     * @return Une liste contenant tous les objets `SincereMenteur`.
     */
    List<SincereMenteur> fetchSincereMenteur();

    /**
     * Recupere un objet `SincereMenteur` specifique a partir de son identifiant.
     * @param id L'identifiant de l'objet a recuperer.
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    Optional<SincereMenteur> fetchSincereMenteur(Long id);

    /**
     * Met a jour un objet `SincereMenteur` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     * @param sincereMenteur      L'objet contenant les nouvelles informations.
     * @param sincereMenteurId    L'identifiant de l'objet a mettre a jour.
     * @return L'objet `SincereMenteur` mis a jour.
     */
    SincereMenteur updateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId);

    /**
     * Supprime un objet `SincereMenteur` a partir de son identifiant.
     * @param sincereMenteurId L'identifiant de l'objet a supprimer.
     */
    void deleteInfoSecu(Long sincereMenteurId);
}



