package fr.uphf.questease.service;

import fr.uphf.questease.model.Indice;
import fr.uphf.questease.repository.IndiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour la gestion des objets `Indice`.
 */
@Service
public class IndiceServiceImpl implements IndiceService {

    // Referentiel pour interagir avec la base de donnees des indices.
    @Autowired
    private IndiceRepository repo;

    /**
     * Sauvegarde un nouvel indice ou met a jour un indice existant.
     * @param indice L'objet `Indice` a sauvegarder.
     * @return L'objet `Indice` sauvegarde.
     */
    @Override
    public Indice saveIndice(Indice indice) {
        return repo.save(indice);
    }

    /**
     * Recupere la liste de tous les indices enregistres.
     * @return Une liste contenant tous les indices.
     */
    @Override
    public List<Indice> fetchIndiceList() {
        return (List<Indice>) repo.findAll();
    }

    /**
     * Recupere un indice specifique a partir de son identifiant.
     * @param id L'identifiant de l'indice a recuperer.
     * @return Un `Optional` contenant l'indice s'il est trouve, sinon vide.
     */
    @Override
    public Optional<Indice> fetchIndice(Long id) {
        return repo.findById(id);
    }

    /**
     * Met a jour un indice existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     * @param indice   L'objet contenant les nouvelles informations.
     * @param indiceId L'identifiant de l'indice a mettre a jour.
     * @return L'objet `Indice` mis a jour.
     */
    @Override
    public Indice updateIndice(Indice indice, Long indiceId) {
        repo.deleteById(indiceId); // Supprime l'indice existant avec l'ID donne.
        return repo.save(indice); // Sauvegarde le nouvel indice.
    }

    /**
     * Supprime un indice a partir de son identifiant.
     * @param indiceId L'identifiant de l'indice a supprimer.
     */
    @Override
    public void deleteIndice(Long indiceId) {
        repo.deleteById(indiceId);
    }
}
