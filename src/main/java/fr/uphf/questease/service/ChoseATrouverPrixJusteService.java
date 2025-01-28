package fr.uphf.questease.service;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import java.util.List;
import java.util.Optional;


/**
 * Interface pour le service de gestion des objets dans le jeu du "Prix Juste".
 */
public interface ChoseATrouverPrixJusteService {

    /**
     * Sauvegarde un nouvel objet ou met à jour un objet existant.
     *
     * @param chose L'objet à sauvegarder ou mettre à jour.
     * @return L'objet sauvegardé.
     */
    ChoseATrouverPrixJuste saveChose(ChoseATrouverPrixJuste chose);

    /**
     * Récupère la liste de tous les objets enregistrés.
     *
     * @return Une liste contenant tous les objets (List<ChoseATrouverPrixJuste>).
     */
    List<ChoseATrouverPrixJuste> fetchChoseList();

    /**
     * Lit un objet spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de l'objet.
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    Optional<ChoseATrouverPrixJuste> readChose(Long id);

    /**
     * Met à jour un objet existant en fonction de son identifiant.
     *
     * @param chose   L'objet contenant les nouvelles informations.
     * @param choseId L'identifiant de l'objet à mettre à jour.
     * @return L'objet mis à jour.
     */
    ChoseATrouverPrixJuste updateChose(ChoseATrouverPrixJuste chose, Long choseId);

    /**
     * Supprime un objet à partir de son identifiant.
     *
     * @param choseId L'identifiant de l'objet à supprimer.
     */
    void deleteChose(Long choseId);
}

