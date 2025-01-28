package fr.uphf.questease.service;

import fr.uphf.questease.model.Indice;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des indices.
 * Permet d'effectuer des opérations CRUD sur les objets `Indice`.
 */
public interface IndiceService {

    /**
     * Sauvegarde un nouvel indice ou met à jour un indice existant.
     *
     * @param indice L'objet `Indice` à sauvegarder ou mettre à jour.
     * @return L'objet `Indice` sauvegardé.
     */
    Indice saveIndice(Indice indice);

    /**
     * Récupère la liste de tous les indices enregistrés.
     *
     * @return Une liste contenant tous les indices (List<Indice>).
     */
    List<Indice> fetchIndiceList();

    /**
     * Récupère un indice spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant de l'indice à récupérer.
     * @return Un `Optional` contenant l'indice s'il est trouvé, sinon vide.
     */
    Optional<Indice> fetchIndice(Long id);

    /**
     * Met à jour un indice existant en fonction de son identifiant.
     *
     * @param indice   L'objet contenant les nouvelles informations de l'indice.
     * @param indiceId L'identifiant de l'indice à mettre à jour.
     * @return L'objet `Indice` mis à jour.
     */
    Indice updateIndice(Indice indice, Long indiceId);

    /**
     * Supprime un indice à partir de son identifiant.
     *
     * @param indiceId L'identifiant de l'indice à supprimer.
     */
    void deleteIndice(Long indiceId);
}
