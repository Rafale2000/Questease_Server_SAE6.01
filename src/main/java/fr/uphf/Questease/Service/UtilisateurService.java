package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Utilisateur;

import java.util.List;

public interface UtilisateurService {
    public Utilisateur SaveUtilisateur(Utilisateur utilisateur);

    public List<Utilisateur> FetchUtilisateurList();

    public Iterable<Utilisateur> FetchOne(String pseudoUser);

    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur, Long utilisateurId);

    public void DeleteUtilisateur(Long utilisateurId);
}
