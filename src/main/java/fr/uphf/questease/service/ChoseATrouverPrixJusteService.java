package fr.uphf.questease.service;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import java.util.List;
import java.util.Optional;


/**
 * Interface pour le service de gestion des objets dans le jeu du "Prix Juste".
 */
public interface ChoseATrouverPrixJusteService {

    /**
     * Sauvegarde un nouvel objet ou met a jour un objet existant.
     * @param chose L'objet a sauvegarder ou mettre a jour.
     * @return L'objet sauvegarde.
     */
    ChoseATrouverPrixJuste saveChose(ChoseATrouverPrixJuste chose);

    /**
     * Recupere la liste de tous les objets enregistres.
     * @return Une liste contenant tous les objets (List<ChoseATrouverPrixJuste>).
     */
    List<ChoseATrouverPrixJuste> fetchChoseList();

    /**
     * Lit un objet specifique a partir de son identifiant.
     * @param id L'identifiant de l'objet.
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    Optional<ChoseATrouverPrixJuste> readChose(Long id);

    /**
     * Met a jour un objet existant en fonction de son identifiant.
     * @param chose   L'objet contenant les nouvelles informations.
     * @param choseId L'identifiant de l'objet a mettre a jour.
     * @return L'objet mis a jour.
     */
    ChoseATrouverPrixJuste updateChose(ChoseATrouverPrixJuste chose, Long choseId);

    /**
     * Supprime un objet a partir de son identifiant.
     * @param choseId L'identifiant de l'objet a supprimer.
     */
    void deleteChose(Long choseId);
}

