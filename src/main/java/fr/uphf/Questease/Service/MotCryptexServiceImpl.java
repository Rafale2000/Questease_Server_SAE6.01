package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.MotCryptex;
import fr.uphf.Questease.Repository.MotCryptexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotCryptexServiceImpl implements MotCryptexService {
    @Autowired
    private MotCryptexRepository repo;

    @Override
    public MotCryptex SaveMotCryptex(MotCryptex motCryptex) {
        return repo.save(motCryptex);
    }

    @Override
    public List<MotCryptex> FetchMotCryptexList() {
        return (List<MotCryptex>) repo.findAll();
    }

    @Override
    public Optional<MotCryptex> FetchMotCryptex(Long id) {
        return repo.findById(id);
    }

    @Override
    public MotCryptex UpdateMotCryptex(MotCryptex motCryptex, Long motCryptexId) {
        repo.deleteById(motCryptexId);
        return repo.save(motCryptex);
    }

    @Override
    public void deleteMotCryptex(Long motCryptexId) {
        repo.deleteById(motCryptexId);
    }
}
