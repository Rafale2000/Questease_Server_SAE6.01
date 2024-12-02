package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.ChoseATrouverPrixJuste;
import fr.uphf.Questease.Repository.ChoseATrouverPrixJusteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChoseATrouverPrixJusteServiceImpl implements ChoseATrouverPrixJusteService{
    @Autowired
    private ChoseATrouverPrixJusteRepository repo;

    @Override
    public ChoseATrouverPrixJuste SaveChose(ChoseATrouverPrixJuste infoSecu) {
        return repo.save(infoSecu);
    }

    @Override
    public List<ChoseATrouverPrixJuste> FetchChoseList() {
        return (List<ChoseATrouverPrixJuste>)repo.findAll();
    }

    @Override
    public Optional<ChoseATrouverPrixJuste> ReadChose(Long id) {
        return repo.findById(id);
    }

    @Override
    public ChoseATrouverPrixJuste UpdateChose(ChoseATrouverPrixJuste chose, Long choseId) {
        repo.deleteById(choseId);
        return repo.save(chose);
    }

    @Override
    public void DeleteChose(Long choseId) {
        repo.deleteById(choseId);
    }
}
