package fr.uphf.questease.service;

import fr.uphf.questease.model.MotPendu;

import java.util.List;
import java.util.Optional;


/**
 * Interface pour le service de gestion des mots du jeu "Pendu".
 * Fournit des fonctionnalités CRUD pour les objets `MotPendu`.
 */
public interface MotPenduService {

    /**
     * Sauvegarde un nouveau mot du jeu "Pendu" ou met à jour un mot existant.
     *
     * @param motPendu L'objet `MotPendu` à sauvegarder.
     * @return L'objet `MotPendu` sauvegardé.
     */
    MotPendu saveMotPendu(MotPendu motPendu);

    /**
     * Récupère la liste de tous les mots du jeu "Pendu" enregistrés.
     *
     * @return Une liste contenant tous les objets `MotPendu`.
     */
    List<MotPendu> fetchMotPenduList();

    /**
     * Récupère un mot du jeu "Pendu" spécifique à partir de son identifiant.
     *
     * @param idPendu L'identifiant du mot à récupérer.
     * @return Un `Optional` contenant le mot s'il est trouvé, sinon vide.
     */
    Optional<MotPendu> fetchOneMotPendu(Long idPendu);

    /**
     * Met à jour un mot du jeu "Pendu" existant en fonction de son identifiant.
     *
     * @param motPendu   L'objet contenant les nouvelles informations du mot du jeu "Pendu".
     * @param motpenduId L'identifiant du mot à mettre à jour.
     * @return L'objet `MotPendu` mis à jour.
     */
    MotPendu updateMotPendu(MotPendu motPendu, Long motpenduId);

    /**
     * Supprime un mot du jeu "Pendu" à partir de son identifiant.
     *
     * @param motPenduId L'identifiant du mot à supprimer.
     */
    void deleteMotPendu(Long motPenduId);
}
