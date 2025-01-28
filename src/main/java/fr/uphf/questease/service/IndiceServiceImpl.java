package fr.uphf.questease.service;

import fr.uphf.questease.model.Indice;
import fr.uphf.questease.repository.IndiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour la gestion des objets `Indice`.
 */
@Service
public class IndiceServiceImpl implements IndiceService {

    // Référentiel pour interagir avec la base de données des indices.
    @Autowired
    private IndiceRepository repo;

    /**
     * Sauvegarde un nouvel indice ou met à jour un indice existant.
     *
     * @param indice L'objet `Indice` à sauvegarder.
     * @return L'objet `Indice` sauvegardé.
     */
    @Override
    public Indice saveIndice(Indice indice) {
        return repo.save(indice);
    }

    /**
     * Récupère la liste de tous les indices enregistrés.
     *
     * @return Une liste contenant tous les indices.
     */
    @Override
    public List<Indice> fetchIndiceList() {
        return (List<Indice>) repo.findAll();
    }

    /**
     * Récupère un indice spécifique à partir de son identifiant.
     *
     * @param id L'identifiant de l'indice à récupérer.
     * @return Un `Optional` contenant l'indice s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<Indice> fetchIndice(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour un indice existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     *
     * @param indice   L'objet contenant les nouvelles informations.
     * @param indiceId L'identifiant de l'indice à mettre à jour.
     * @return L'objet `Indice` mis à jour.
     */
    @Override
    public Indice updateIndice(Indice indice, Long indiceId) {
        repo.deleteById(indiceId); // Supprime l'indice existant avec l'ID donné.
        return repo.save(indice); // Sauvegarde le nouvel indice.
    }

    /**
     * Supprime un indice à partir de son identifiant.
     *
     * @param indiceId L'identifiant de l'indice à supprimer.
     */
    @Override
    public void deleteIndice(Long indiceId) {
        repo.deleteById(indiceId);
    }
}
