package fr.uphf.Questease.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import fr.uphf.Questease.Model.SincereMenteur;
import fr.uphf.Questease.Repository.SincereMenteurRepository;

@Service
public class SincereMenteurServiceImpl implements SincereMenteurService {
    @Autowired
    private SincereMenteurRepository repo;


    @Override
    public SincereMenteur saveSincereMenteur(SincereMenteur sincereMenteur) {
        return repo.save(sincereMenteur);
    }

    @Override
    public List<SincereMenteur> fetchSincereMenteur() {
        return (List<SincereMenteur>) repo.findAll();
    }

    @Override
    public Optional<SincereMenteur> FetchSincereMenteur(Long id) {
        return repo.findById(id);
    }

    @Override
    public SincereMenteur UpdateSincereMenteur(SincereMenteur sincereMenteur, Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
        return repo.save(sincereMenteur);
    }

    @Override
    public void deleteInfoSecu(Long sincereMenteurId) {
        repo.deleteById(sincereMenteurId);
    }
}

