package fr.uphf.questease.service;

import fr.uphf.questease.model.ChoseATrouverPrixJuste;
import fr.uphf.questease.repository.ChoseATrouverPrixJusteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour la gestion des objets "Chose a Trouver" du jeu "Prix Juste".
 */
@Service
public class ChoseATrouverPrixJusteServiceImpl implements ChoseATrouverPrixJusteService{

    // Repository permettant d'interagir avec la base de donnees.
    @Autowired
    private ChoseATrouverPrixJusteRepository repo;

    /**
     * Sauvegarde une nouvelle "chose a trouver" ou met a jour une existante.
     * @param infoSecu L'objet `ChoseATrouverPrixJuste` a sauvegarder.
     * @return L'objet `ChoseATrouverPrixJuste` sauvegarde.
     */
    @Override
    public ChoseATrouverPrixJuste saveChose(ChoseATrouverPrixJuste infoSecu) {
        return repo.save(infoSecu);
    }

    /**
     * Recupere la liste de toutes les "choses a trouver" enregistrees.
     * @return Une liste contenant tous les objets `ChoseATrouverPrixJuste`.
     */
    @Override
    public List<ChoseATrouverPrixJuste> fetchChoseList() {
        return (List<ChoseATrouverPrixJuste>)repo.findAll();
    }

    /**
     * Recupere une "chose a trouver" specifique a partir de son identifiant.
     * @param id L'identifiant de la "chose a trouver".
     * @return Un `Optional` contenant l'objet s'il est trouve, sinon vide.
     */
    @Override
    public Optional<ChoseATrouverPrixJuste> readChose(Long id) {
        return repo.findById(id);
    }

    /**
     * Met a jour une "chose a trouver" existante en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     * @param chose   L'objet contenant les nouvelles informations.
     * @param choseId L'identifiant de la "chose a trouver" a mettre a jour.
     * @return L'objet `ChoseATrouverPrixJuste` mis a jour.
     */
    @Override
    public ChoseATrouverPrixJuste updateChose(ChoseATrouverPrixJuste chose, Long choseId) {
        repo.deleteById(choseId);
        return repo.save(chose);
    }

    /**
     * Supprime une "chose a trouver" a partir de son identifiant.
     * @param choseId L'identifiant de la "chose a trouver" a supprimer.
     */
    @Override
    public void deleteChose(Long choseId) {
        repo.deleteById(choseId);
    }
}
