package fr.uphf.questease.service;

import fr.uphf.questease.model.InfoSecu;

import java.util.Optional;

/**
 * Interface pour le service de gestion des InfoSecu.
 * Permet d'effectuer des operations CRUD sur les objets `InfoSecu`.
 */
public interface InfoSecuService {

    /**
     * Sauvegarde un nouveau infoSecu ou met a jour un infoSecu existant.
     * @param infoSecu L'objet `infoSecu` a sauvegarder.
     * @return L'objet `infoSecu` sauvegarde.
     */
    InfoSecu saveInfoSecu(InfoSecu infoSecu);


    /**
     * Recupere un mot InfoSecu specifique a partir de son identifiant.
     * @param id L'identifiant de l'infoSecu a recuperer.
     * @return Un `Optional` contenant l'objet `InfoSecu` s'il est trouve, sinon vide.
     */
    Optional<InfoSecu> fetchInfoSecu(Long id);

    /**
     * Met a jour un mot Cryptex existant en fonction de son identifiant.
     * @param infoSecu   L'objet contenant les nouvelles informations du infoSecu.
     * @param infoSecuId  L'identifiant de l'infoSecu a mettre a jour.
     * @return L'objet `infoSecu` mis a jour.
     */
    InfoSecu updateInfoSecu(InfoSecu infoSecu, Long infoSecuId);

    /**
     * Supprime un infoSecu a partir de son identifiant.
     * @param infoSecuId L'identifiant de l'infoSecu a supprimer.
     */
    void deleteMotCryptex(Long infoSecuId);
}
