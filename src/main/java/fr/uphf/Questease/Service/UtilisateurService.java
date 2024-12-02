package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    Utilisateur SaveUtilisateur(Utilisateur utilisateur);

    List<Utilisateur> FetchUtilisateurList();

    Iterable<Utilisateur> FetchOne(String pseudoUser);

    Utilisateur UpdateUtilisateur(Utilisateur utilisateur, Long utilisateurId);

    void DeleteUtilisateur(Long utilisateurId);

}
