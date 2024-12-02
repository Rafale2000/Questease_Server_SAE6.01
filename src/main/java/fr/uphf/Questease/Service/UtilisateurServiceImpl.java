package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Utilisateur;
import fr.uphf.Questease.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
    @Autowired
    private UtilisateurRepository repo;

    @Override
    public Utilisateur SaveUtilisateur(Utilisateur utilisateur) {
        return repo.save(utilisateur);
    }

    @Override
    public List<Utilisateur> FetchUtilisateurList() {
        return (List<Utilisateur>) repo.findAll();
    }

    @Override
    public Iterable<Utilisateur> FetchOne(String pseudoUser){
        return repo.findUtilByName(pseudoUser);
    }

    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur, Long utilisateurId) {
        repo.deleteById(utilisateurId);
        return repo.save(utilisateur);
    }

    @Override
    public void DeleteUtilisateur(Long utilisateurId) {
        repo.deleteById(utilisateurId);
    }
}
