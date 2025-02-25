package fr.uphf.questease.service;

import fr.uphf.questease.model.Resultat;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des resultats.
 * Permet d'effectuer des operations CRUD sur les objets `Resultat`.
 */
public interface ResultatService {

    /**
     * Sauvegarde un nouveau resulat ou met a jour un resulat existant.
     * @param resultat L'objet `resulat` a sauvegarder.
     * @return L'objet `resulat` sauvegarde.
     */
    Resultat saveResultat(Resultat resultat);

    /**
     * Recupere la liste de tous les mots Cryptex enregistres.
     * @return Une liste contenant tous les objets `MotCryptex`.
     */
    List<Resultat> fetchResultatList();

    /**
     * Recupere un mot resulat specifique a partir de son identifiant.
     * @param id L'identifiant du resulat a recuperer.
     * @return Un `Optional` contenant l'objet `resulat` s'il est trouve, sinon vide.
     */
    Optional<Resultat> fetchResulat(Long id);

    /**
     * Met a jour un resultat existant en fonction de son identifiant.
     * @param resultat   L'objet contenant les nouvelles informations du Resultat.
     * @param resultatId  L'identifiant du resultat a mettre a jour.
     * @return L'objet `Resultat` mis a jour.
     */
    Resultat updateInfoSecu(Resultat resultat, Long resultatId);

    /**
     * Supprime un Resultat a partir de son identifiant.
     * @param resultatId L'identifiant du resultat a supprimer.
     */
    void deleteResultat(Long resultatId);

}
