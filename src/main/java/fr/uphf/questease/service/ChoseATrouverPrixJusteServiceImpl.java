package fr.uphf.questease.service;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.repository.ChoseATrouverPrixJusteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour la gestion des objets "Chose à Trouver" du jeu "Prix Juste".
 */
@Service
public class ChoseATrouverPrixJusteServiceImpl implements ChoseATrouverPrixJusteService{
    // Repository permettant d'interagir avec la base de données.
    @Autowired
    private ChoseATrouverPrixJusteRepository repo;

    /**
     * Sauvegarde une nouvelle "chose à trouver" ou met à jour une existante.
     *
     * @param infoSecu L'objet `ChoseATrouverPrixJuste` à sauvegarder.
     * @return L'objet `ChoseATrouverPrixJuste` sauvegardé.
     */
    @Override
    public ChoseATrouverPrixJuste saveChose(ChoseATrouverPrixJuste infoSecu) {
        return repo.save(infoSecu);
    }

    /**
     * Récupère la liste de toutes les "choses à trouver" enregistrées.
     *
     * @return Une liste contenant tous les objets `ChoseATrouverPrixJuste`.
     */
    @Override
    public List<ChoseATrouverPrixJuste> fetchChoseList() {
        return (List<ChoseATrouverPrixJuste>)repo.findAll();
    }

    /**
     * Récupère une "chose à trouver" spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de la "chose à trouver".
     * @return Un `Optional` contenant l'objet s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<ChoseATrouverPrixJuste> readChose(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour une "chose à trouver" existante en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     *
     * @param chose   L'objet contenant les nouvelles informations.
     * @param choseId L'identifiant de la "chose à trouver" à mettre à jour.
     * @return L'objet `ChoseATrouverPrixJuste` mis à jour.
     */
    @Override
    public ChoseATrouverPrixJuste updateChose(ChoseATrouverPrixJuste chose, Long choseId) {
        repo.deleteById(choseId);
        return repo.save(chose);
    }

    /**
     * Supprime une "chose à trouver" à partir de son identifiant.
     *
     * @param choseId L'identifiant de la "chose à trouver" à supprimer.
     */
    @Override
    public void deleteChose(Long choseId) {
        repo.deleteById(choseId);
    }
}
