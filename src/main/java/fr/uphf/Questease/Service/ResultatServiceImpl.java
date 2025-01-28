package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Resultat;
import fr.uphf.Questease.Repository.MotPenduRepository;
import fr.uphf.Questease.Repository.ResultatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResultatServiceImpl implements ResultatService {
    // Repository utilisé pour interagir avec la base de données des resultats.
    @Autowired
    private ResultatRepository repo;

    /**
     * Sauvegarde un resultat ou met à jour un resultat existant.
     *
     * @param resultat L'objet `Resultat` à sauvegarder.
     * @return L'objet `Resultat` sauvegardé.
     */
    @Override
    public Resultat SaveResultat(Resultat resultat) {
        return null;
    }

    /**
     * Récupère la liste de tous les resultats enregistrés.
     *
     * @return Une liste contenant tous les resultats.
     */
    @Override
    public List<Resultat> FetchResultatList() {
        return (List<Resultat>) repo.findAll();
    }

    /**
     * Récupère un resultat spécifique à partir de son identifiant.
     *
     * @param id L'identifiant du resultat.
     * @return Un `Optional` contenant un resultat s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<Resultat> FetchResulat(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour un resultat existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     *
     * @param resultat   L'objet contenant les nouvelles informations.
     * @param resultatId L'identifiant du resultat à mettre à jour.
     * @return L'objet `Resultat` mis à jour.
     */
    @Override
    public Resultat UpdateInfoSecu(Resultat resultat, Long resultatId) {
        repo.deleteById(resultatId);
        return repo.save(resultat);
    }

    /**
     * Supprime un resultat à partir de son identifiant.
     *
     * @param resultatId L'identifiant du resultat à supprimer.
     */
    @Override
    public void deleteResultat(Long resultatId) {

    }
}
