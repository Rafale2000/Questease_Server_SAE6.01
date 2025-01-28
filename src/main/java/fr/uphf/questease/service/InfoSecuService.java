package fr.uphf.questease.service;

import fr.uphf.questease.model.InfoSecu;

import java.util.Optional;

public interface InfoSecuService {
    /**
     * Sauvegarde un nouveau infoSecu ou met à jour un infoSecu existant.
     *
     * @param infoSecu L'objet `infoSecu` à sauvegarder.
     * @return L'objet `infoSecu` sauvegardé.
     */
    InfoSecu saveInfoSecu(InfoSecu infoSecu);


    /**
     * Récupère un mot InfoSecu spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de l'infoSecu à récupérer.
     * @return Un `Optional` contenant l'objet `InfoSecu` s'il est trouvé, sinon vide.
     */
    Optional<InfoSecu> fetchInfoSecu(Long id);

    /**
     * Met à jour un mot Cryptex existant en fonction de son identifiant.
     *
     * @param infoSecu   L'objet contenant les nouvelles informations du infoSecu.
     * @param infoSecuId  L'identifiant de l'infoSecu à mettre à jour.
     * @return L'objet `infoSecu` mis à jour.
     */
    InfoSecu updateInfoSecu(InfoSecu infoSecu, Long infoSecuId);

    /**
     * Supprime un infoSecu à partir de son identifiant.
     *
     * @param infoSecuId L'identifiant de l'infoSecu à supprimer.
     */
    void deleteMotCryptex(Long infoSecuId);


}
