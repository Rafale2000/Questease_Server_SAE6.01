package fr.uphf.questease.service;

import fr.uphf.questease.model.InfoSecu;
import fr.uphf.questease.repository.InfoSecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation du service pour la gestion des objets `InfoSecu`.
 */
@Service
public class InfoSecuServiceImpl implements InfoSecuService {

    // Repository utilise pour interagir avec la base de donnees des mots Cryptex.
    @Autowired
    private InfoSecuRepository repo;

    /**
     * Sauvegarde un nouveau InfoSecu ou met a jour un existant.
     * @param infoSecu L'objet `Infosecu` a sauvegarder.
     * @return L'objet `MotCryptex` sauvegarde.
     */
    @Override
    public InfoSecu saveInfoSecu(InfoSecu infoSecu) {
        return repo.save(infoSecu);
    }

    /**
     * Recupere un indice specifique en fonction de son identifiant.
     * @param id L'identifiant de l'infoSecu a recuperer.
     * @return Un `Optional` contenant l'infoSecu s'il est trouve, sinon vide.
     */
    @Override
    public Optional<InfoSecu> fetchInfoSecu(Long id) {
        return repo.findById(id);
    }

    /**
     * Met a jour un mot Cryptex existant en supprimant d'abord l'ancien, puis en sauvegardant le nouveau.
     * @param infoSecu   L'objet contenant les nouvelles informations de l'infoSecu.
     * @param infoSecuId L'identifiant de l'infoSecu a mettre a jour.
     * @return L'objet `infoSecu` mis a jour.
     */
    @Override
    public InfoSecu updateInfoSecu(InfoSecu infoSecu, Long infoSecuId) {
        repo.deleteById(infoSecuId);
        return repo.save(infoSecu);
    }

    /**
     * Supprime un infoSecu a partir de son identifiant.
     * @param infoSecuId L'identifiant du mot InfoSecu a supprimer.
     */
    @Override
    public void deleteMotCryptex(Long infoSecuId) {
        repo.deleteById(infoSecuId);
    }
}
