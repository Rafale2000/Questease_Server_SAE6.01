package fr.uphf.questease.service;

import fr.uphf.questease.model.Indice;

import java.util.List;
import java.util.Optional;

/**
 * Interface pour le service de gestion des indices.
 * Permet d'effectuer des operations CRUD sur les objets `Indice`.
 */
public interface IndiceService {

    /**
     * Sauvegarde un nouvel indice ou met a jour un indice existant.
     * @param indice L'objet `Indice` a sauvegarder ou mettre a jour.
     * @return L'objet `Indice` sauvegarde.
     */
    Indice saveIndice(Indice indice);

    /**
     * Recupere la liste de tous les indices enregistres.
     * @return Une liste contenant tous les indices (List<Indice>).
     */
    List<Indice> fetchIndiceList();

    /**
     * Recupere un indice specifique en fonction de son identifiant.
     * @param id L'identifiant de l'indice a recuperer.
     * @return Un `Optional` contenant l'indice s'il est trouve, sinon vide.
     */
    Optional<Indice> fetchIndice(Long id);

    /**
     * Met a jour un indice existant en fonction de son identifiant.
     * @param indice   L'objet contenant les nouvelles informations de l'indice.
     * @param indiceId L'identifiant de l'indice a mettre a jour.
     * @return L'objet `Indice` mis a jour.
     */
    Indice updateIndice(Indice indice, Long indiceId);

    /**
     * Supprime un indice a partir de son identifiant.
     * @param indiceId L'identifiant de l'indice a supprimer.
     */
    void deleteIndice(Long indiceId);
}
