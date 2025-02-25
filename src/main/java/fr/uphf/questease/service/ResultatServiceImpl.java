package fr.uphf.questease.service;

import fr.uphf.questease.model.Resultat;
import fr.uphf.questease.repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour gerer les mots du jeu "Resultat".
 */
@Service
public class ResultatServiceImpl implements ResultatService {

    /**
     * Repository utilise pour interagir avec la base de donnees des resultats.
     */
    @Autowired
    private ResultatRepository repo;

    /**
     * Sauvegarde un resultat ou met a jour un resultat existant.
     * @param resultat L'objet `Resultat` a sauvegarder.
     * @return L'objet `Resultat` sauvegarde.
     */
    @Override
    public Resultat saveResultat(Resultat resultat) {
        return null;
    }

    /**
     * Recupere la liste de tous les resultats enregistres.
     * @return Une liste contenant tous les resultats.
     */
    @Override
    public List<Resultat> fetchResultatList() {
        return (List<Resultat>) repo.findAll();
    }

    /**
     * Recupere un resultat specifique a partir de son identifiant.
     * @param id L'identifiant du resultat.
     * @return Un `Optional` contenant un resultat s'il est trouve, sinon vide.
     */
    @Override
    public Optional<Resultat> fetchResulat(Long id) {
        return repo.findById(id);
    }

    /**
     * Met a jour un resultat existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     * @param resultat   L'objet contenant les nouvelles informations.
     * @param resultatId L'identifiant du resultat a mettre a jour.
     * @return L'objet `Resultat` mis a jour.
     */
    @Override
    public Resultat updateInfoSecu(Resultat resultat, Long resultatId) {
        repo.deleteById(resultatId);
        return repo.save(resultat);
    }

    /**
     * Supprime un resultat a partir de son identifiant.
     * @param resultatId L'identifiant du resultat a supprimer.
     */
    @Override
    public void deleteResultat(Long resultatId) {
        repo.deleteById(resultatId);
    }
}
