package fr.uphf.questease.service;

import fr.uphf.questease.model.MotPendu;

import java.util.List;
import java.util.Optional;


/**
 * Interface pour le service de gestion des mots du jeu "Pendu".
 * Fournit des fonctionnalites CRUD pour les objets `MotPendu`.
 */
public interface MotPenduService {

    /**
     * Sauvegarde un nouveau mot du jeu "Pendu" ou met a jour un mot existant.
     * @param motPendu L'objet `MotPendu` a sauvegarder.
     * @return L'objet `MotPendu` sauvegarde.
     */
    MotPendu saveMotPendu(MotPendu motPendu);

    /**
     * Recupere la liste de tous les mots du jeu "Pendu" enregistres.
     * @return Une liste contenant tous les objets `MotPendu`.
     */
    List<MotPendu> fetchMotPenduList();

    /**
     * Recupere un mot du jeu "Pendu" specifique a partir de son identifiant.
     * @param idPendu L'identifiant du mot a recuperer.
     * @return Un `Optional` contenant le mot s'il est trouve, sinon vide.
     */
    Optional<MotPendu> fetchOneMotPendu(Long idPendu);

    /**
     * Met a jour un mot du jeu "Pendu" existant en fonction de son identifiant.
     * @param motPendu   L'objet contenant les nouvelles informations du mot du jeu "Pendu".
     * @param motpenduId L'identifiant du mot a mettre a jour.
     * @return L'objet `MotPendu` mis a jour.
     */
    MotPendu updateMotPendu(MotPendu motPendu, Long motpenduId);

    /**
     * Supprime un mot du jeu "Pendu" a partir de son identifiant.
     * @param motPenduId L'identifiant du mot a supprimer.
     */
    void deleteMotPendu(Long motPenduId);
}
