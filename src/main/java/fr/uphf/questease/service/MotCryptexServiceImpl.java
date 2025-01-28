package fr.uphf.questease.service;

import fr.uphf.questease.model.MotCryptex;
import fr.uphf.questease.repository.MotCryptexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implémentation du service pour la gestion des mots Cryptex.
 */
@Service
public class MotCryptexServiceImpl implements MotCryptexService {

    // Repository utilisé pour interagir avec la base de données des mots Cryptex.
    @Autowired
    private MotCryptexRepository repo;

    /**
     * Sauvegarde un nouveau mot Cryptex ou met à jour un mot existant.
     *
     * @param motCryptex L'objet `MotCryptex` à sauvegarder.
     * @return L'objet `MotCryptex` sauvegardé.
     */
    @Override
    public MotCryptex saveMotCryptex(MotCryptex motCryptex) {
        return repo.save(motCryptex);
    }

    /**
     * Récupère la liste de tous les mots Cryptex enregistrés.
     *
     * @return Une liste contenant tous les objets `MotCryptex`.
     */
    @Override
    public List<MotCryptex> fetchMotCryptexList() {
        return (List<MotCryptex>) repo.findAll();
    }

    /**
     * Récupère un mot Cryptex spécifique à partir de son identifiant.
     *
     * @param id L'identifiant du mot Cryptex à récupérer.
     * @return Un `Optional` contenant le mot s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<MotCryptex> fetchMotCryptex(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour un mot Cryptex existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     *
     * @param motCryptex   L'objet contenant les nouvelles informations du mot Cryptex.
     * @param motCryptexId L'identifiant du mot Cryptex à mettre à jour.
     * @return L'objet `MotCryptex` mis à jour.
     */
    @Override
    public MotCryptex updateMotCryptex(MotCryptex motCryptex, Long motCryptexId) {
        repo.deleteById(motCryptexId);
        return repo.save(motCryptex);
    }

    /**
     * Supprime un mot Cryptex à partir de son identifiant.
     *
     * @param motCryptexId L'identifiant du mot Cryptex à supprimer.
     */
    @Override
    public void deleteMotCryptex(Long motCryptexId) {
        repo.deleteById(motCryptexId);
    }
}
