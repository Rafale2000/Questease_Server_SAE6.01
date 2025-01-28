package fr.uphf.questease.service;

import fr.uphf.questease.model.MotPendu;
import fr.uphf.questease.repository.MotPenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour gérer les mots du jeu "Pendu".
 */
@Service
public class MotPenduServiceImpl implements MotPenduService {

    // Repository utilisé pour interagir avec la base de données des mots du jeu "Pendu".
    @Autowired
    private MotPenduRepository repo;

    /**
     * Sauvegarde un mot du jeu "Pendu" ou met à jour un mot existant.
     *
     * @param motPendu L'objet `MotPendu` à sauvegarder.
     * @return L'objet `MotPendu` sauvegardé.
     */
    @Override
    public MotPendu saveMotPendu(MotPendu motPendu) {
        return repo.save(motPendu);
    }

    /**
     * Récupère la liste de tous les mots du jeu "Pendu" enregistrés.
     *
     * @return Une liste contenant tous les objets `MotPendu`.
     */
    @Override
    public List<MotPendu> fetchMotPenduList() {
        return (List<MotPendu>) repo.findAll();
    }

    /**
     * Récupère un mot du jeu "Pendu" spécifique à partir de son identifiant.
     *
     * @param idPendu L'identifiant du mot à récupérer.
     * @return Un `Optional` contenant le mot s'il est trouvé, sinon vide.
     */
    public Optional<MotPendu> fetchOneMotPendu(Long idPendu){
        return repo.findById(idPendu);
    }

    /**
     * Met à jour un mot du jeu "Pendu" existant.
     * Supprime d'abord l'ancien mot et sauvegarde le nouveau.
     *
     * @param motPendu   L'objet contenant les nouvelles informations du mot.
     * @param motPenduId L'identifiant du mot à mettre à jour.
     * @return L'objet `MotPendu` mis à jour.
     */
    @Override
    public MotPendu updateMotPendu(MotPendu motPendu, Long motPenduId) {
        repo.deleteById(motPenduId);
        return repo.save(motPendu);
    }

    /**
     * Supprime un mot du jeu "Pendu" à partir de son identifiant.
     *
     * @param motPenduId L'identifiant du mot à supprimer.
     */
    @Override
    public void deleteMotPendu(Long motPenduId) {
        repo.deleteById(motPenduId);
    }
}
