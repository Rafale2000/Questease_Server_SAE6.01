package fr.uphf.questease.service;

import fr.uphf.questease.model.MotCryptex;
import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des mots Cryptex.
 * Fournit des fonctionnalités CRUD pour les objets `MotCryptex`.
 */
public interface MotCryptexService {
    /**
     * Sauvegarde un nouveau mot Cryptex ou met à jour un mot existant.
     *
     * @param motCryptex L'objet `MotCryptex` à sauvegarder.
     * @return L'objet `MotCryptex` sauvegardé.
     */
    MotCryptex saveMotCryptex(MotCryptex motCryptex);

    /**
     * Récupère la liste de tous les mots Cryptex enregistrés.
     *
     * @return Une liste contenant tous les objets `MotCryptex`.
     */
    List<MotCryptex> fetchMotCryptexList();

    /**
     * Récupère un mot Cryptex spécifique à partir de son identifiant.
     *
     * @param id L'identifiant du mot Cryptex à récupérer.
     * @return Un `Optional` contenant l'objet `MotCryptex` s'il est trouvé, sinon vide.
     */
    Optional<MotCryptex> fetchMotCryptex(Long id);

    /**
     * Met à jour un mot Cryptex existant en fonction de son identifiant.
     *
     * @param motCryptex   L'objet contenant les nouvelles informations du mot Cryptex.
     * @param motCrpyexId  L'identifiant du mot Cryptex à mettre à jour.
     * @return L'objet `MotCryptex` mis à jour.
     */
    MotCryptex updateMotCryptex(MotCryptex motCryptex, Long motCrpyexId);

    /**
     * Supprime un mot Cryptex à partir de son identifiant.
     *
     * @param motCryptexId L'identifiant du mot Cryptex à supprimer.
     */
    void deleteMotCryptex(Long motCryptexId);
}
