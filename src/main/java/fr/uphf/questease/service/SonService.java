package fr.uphf.questease.service;

import fr.uphf.questease.model.Son;

import java.util.List;
import java.util.Optional;
/**
 * Interface pour le service de gestion des objets `Son`.
 * Fournit des méthodes pour effectuer des opérations CRUD sur les objets `Son`.
 */
public interface SonService {
    /**
     * Sauvegarde un nouvel objet `Son` ou met à jour un objet existant.
     *
     * @param son L'objet `Son` à sauvegarder.
     * @return L'objet `Son` sauvegardé.
     */
    Son saveSon(Son son);

    /**
     * Récupère la liste de tous les objets `Son` enregistrés.
     *
     * @return Une liste contenant tous les objets `Son`.
     */
    List<Son> fetchSonList();

    /**
     * Récupère un objet `Son` spécifique à partir de son identifiant.
     *
     * @param idSon L'identifiant de l'objet à récupérer.
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    Optional<Son> fetchOne(Long idSon);

    /**
     * Met à jour un objet `Son` existant.
     * Supprime d'abord l'ancien objet et sauvegarde le nouveau.
     *
     * @param son     L'objet contenant les nouvelles informations.
     * @param sonId   L'identifiant de l'objet à mettre à jour.
     * @return L'objet `Son` mis à jour.
     */
    Son updateSon(Son son, Long sonId);

    /**
     * Supprime un objet `Son` à partir de son identifiant.
     *
     * @param sonId L'identifiant de l'objet à supprimer.
     */
    void deleteSon(Long sonId);
}
