package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.InfoSecu;
import fr.uphf.Questease.Model.MotCryptex;
import fr.uphf.Questease.Repository.InfoSecuRepository;
import fr.uphf.Questease.Repository.MotCryptexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InfoSecuServiceImpl implements InfoSecuService {
    // Repository utilisé pour interagir avec la base de données des mots Cryptex.
    @Autowired
    private InfoSecuRepository repo;


    /**
     * Sauvegarde un nouveau mot Cryptex ou met à jour un mot existant.
     *
     * @param motCryptex L'objet `MotCryptex` à sauvegarder.
     * @return L'objet `MotCryptex` sauvegardé.
     */
    @Override
    public InfoSecu SaveInfoSecu(InfoSecu infoSecu) {
        return repo.save(infoSecu);
    }
    /**
     * Récupère un indice spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant de l'infoSecu à récupérer.
     * @return Un `Optional` contenant l'infoSecu s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<InfoSecu> FetchInfoSecu(Long id) {
        return repo.findById(id);
    }

    /**
     * Met à jour un mot Cryptex existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     *
     * @param infoSecu   L'objet contenant les nouvelles informations de l'infoSecu.
     * @param infoSecuId L'identifiant de l'infoSecu à mettre à jour.
     * @return L'objet `infoSecu` mis à jour.
     */
    @Override
    public InfoSecu UpdateInfoSecu(InfoSecu infoSecu, Long infoSecuId) {
        repo.deleteById(infoSecuId);
        return repo.save(infoSecu);
    }

    /**
     * Supprime un infoSecu à partir de son identifiant.
     *
     * @param infoSecuId L'identifiant du mot InfoSecu à supprimer.
     */
    @Override
    public void deleteMotCryptex(Long infoSecuId) {
        repo.deleteById(infoSecuId);
    }
}
