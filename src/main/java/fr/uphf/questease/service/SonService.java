package fr.uphf.questease.service;

import fr.uphf.questease.model.Son;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des objets `Son`.
 * Fournit des methodes pour effectuer des operations CRUD sur les objets `Son`.
 */
public interface SonService {

    /**
     * Sauvegarde un nouvel objet `Son` ou met a jour un objet existant.
     * @param son L'objet `Son` a sauvegarder.
     * @return L'objet `Son` sauvegarde.
     */
    Son saveSon(Son son);

    /**
     * Recupere la liste de tous les objets `Son` enregistres.
     * @return Une liste contenant tous les objets `Son`.
     */
    List<Son> fetchSonList();

    /**
     * Recupere un objet `Son` specifique a partir de son identifiant.
     * @param idSon L'identifiant de l'objet a recuperer.
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    Optional<Son> fetchOne(Long idSon);

    /**
     * Met a jour un objet `Son` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     * @param son     L'objet contenant les nouvelles informations.
     * @param sonId   L'identifiant de l'objet a mettre a jour.
     * @return L'objet `Son` mis a jour.
     */
    Son updateSon(Son son, Long sonId);

    /**
     * Supprime un objet `Son` a partir de son identifiant.
     * @param sonId L'identifiant de l'objet a supprimer.
     */
    void deleteSon(Long sonId);
}
