package fr.uphf.questease.service;

import fr.uphf.questease.model.Resultat;

import java.util.List;
import java.util.Optional;

public interface ResultatService {
    /**
     * Sauvegarde un nouveau resulat ou met à jour un resulat existant.
     *
     * @param resultat L'objet `resulat` à sauvegarder.
     * @return L'objet `resulat` sauvegardé.
     */
    Resultat saveResultat(Resultat resultat);

    /**
     * Récupère la liste de tous les mots Cryptex enregistrés.
     *
     * @return Une liste contenant tous les objets `MotCryptex`.
     */
    List<Resultat> fetchResultatList();

    /**
     * Récupère un mot resulat spécifique à partir de son identifiant.
     *
     * @param id L'identifiant du resulat à récupérer.
     * @return Un `Optional` contenant l'objet `resulat` s'il est trouvé, sinon vide.
     */
    Optional<Resultat> fetchResulat(Long id);

    /**
     * Met à jour un resultat existant en fonction de son identifiant.
     *
     * @param resultat   L'objet contenant les nouvelles informations du Resultat.
     * @param resultatId  L'identifiant du resultat à mettre à jour.
     * @return L'objet `Resultat` mis à jour.
     */
    Resultat updateInfoSecu(Resultat resultat, Long resultatId);

    /**
     * Supprime un Resultat à partir de son identifiant.
     *
     * @param resultatId L'identifiant du resultat à supprimer.
     */
    void deleteResultat(Long resultatId);

}
