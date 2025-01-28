package fr.uphf.questease.service;

import fr.uphf.questease.model.InfoSecu;
import fr.uphf.questease.repository.InfoSecuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InfoSecuServiceImpl implements InfoSecuService {
    // Repository utilisé pour interagir avec la base de données des mots Cryptex.
    @Autowired
    private InfoSecuRepository repo;


    /**
     * Sauvegarde un nouveau InfoSecu ou met à jour un existant.
     *
     * @param infoSecu L'objet `Infosecu` à sauvegarder.
     * @return L'objet `MotCryptex` sauvegardé.
     */
    @Override
    public InfoSecu saveInfoSecu(InfoSecu infoSecu) {
        return repo.save(infoSecu);
    }
    /**
     * Récupère un indice spécifique en fonction de son identifiant.
     *
     * @param id L'identifiant de l'infoSecu à récupérer.
     * @return Un `Optional` contenant l'infoSecu s'il est trouvé, sinon vide.
     */
    @Override
    public Optional<InfoSecu> fetchInfoSecu(Long id) {
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
    public InfoSecu updateInfoSecu(InfoSecu infoSecu, Long infoSecuId) {
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
