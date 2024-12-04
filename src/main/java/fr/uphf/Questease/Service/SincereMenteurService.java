package fr.uphf.Questease.Service;

import java.util.List;
import java.util.Optional;


import fr.uphf.Questease.Model.SincereMenteur;

public interface SincereMenteurService {

    SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur);

    List<SincereMenteur> fetchSincereMenteur();

    Optional<SincereMenteur> FetchSincereMenteur(Long id);

    SincereMenteur UpdateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId);

    void deleteInfoSecu(Long sincereMenteurId);
}



