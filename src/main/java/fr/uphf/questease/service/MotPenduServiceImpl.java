package fr.uphf.questease.service;

import fr.uphf.questease.model.MotPendu;
import fr.uphf.questease.repository.MotPenduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation du service pour gerer les mots du jeu "Pendu".
 */
@Service
public class MotPenduServiceImpl implements MotPenduService {

    /**
     * Repository utilise pour interagir avec la base de donnees des mots du jeu "Pendu".
     */
    @Autowired
    private MotPenduRepository repo;

    /**
     * Sauvegarde un mot du jeu "Pendu" ou met a jour un mot existant.
     * @param motPendu L'objet `MotPendu` a sauvegarder.
     * @return L'objet `MotPendu` sauvegarde.
     */
    @Override
    public MotPendu saveMotPendu(MotPendu motPendu) {
        return repo.save(motPendu);
    }

    /**
     * Recupere la liste de tous les mots du jeu "Pendu" enregistres.
     * @return Une liste contenant tous les objets `MotPendu`.
     */
    @Override
    public List<MotPendu> fetchMotPenduList() {
        return (List<MotPendu>) repo.findAll();
    }

    /**
     * Recupere un mot du jeu "Pendu" specifique a partir de son identifiant.
     * @param idPendu L'identifiant du mot a recuperer.
     * @return Un `Optional` contenant le mot s'il est trouve, sinon vide.
     */
    public Optional<MotPendu> fetchOneMotPendu(Long idPendu){
        return repo.findById(idPendu);
    }

    /**
     * Met a jour un mot du jeu "Pendu" existant.
     * Supprime d'abord l'ancien mot et sauvegarde le nouveau.
     * @param motPendu   L'objet contenant les nouvelles informations du mot.
     * @param motPenduId L'identifiant du mot a mettre a jour.
     * @return L'objet `MotPendu` mis a jour.
     */
    @Override
    public MotPendu updateMotPendu(MotPendu motPendu, Long motPenduId) {
        repo.deleteById(motPenduId);
        return repo.save(motPendu);
    }

    /**
     * Supprime un mot du jeu "Pendu" a partir de son identifiant.
     * @param motPenduId L'identifiant du mot a supprimer.
     */
    @Override
    public void deleteMotPendu(Long motPenduId) {
        repo.deleteById(motPenduId);
    }
}
