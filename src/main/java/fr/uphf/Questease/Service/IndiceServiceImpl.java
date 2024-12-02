package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Indice;
import fr.uphf.Questease.Repository.IndiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndiceServiceImpl implements IndiceService {
    @Autowired
    private IndiceRepository repo;

    @Override
    public Indice SaveIndice(Indice indice) {
        return repo.save(indice);
    }

    @Override
    public List<Indice> FetchIndiceList() {
        return (List<Indice>)repo.findAll();
    }

    @Override
    public Optional<Indice> FetchIndice(Long id) {
        return repo.findById(id);
    }


    @Override
    public Indice UpdateIndice(Indice indice, Long indiceId) {
        repo.deleteById(indiceId);
        return repo.save(indice);
    }

    @Override
    public void deleteIndice(Long indiceId) {
        repo.deleteById(indiceId);
    }
}
