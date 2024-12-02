package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.ChoseATrouverPrixJuste;

import java.util.List;
import java.util.Optional;

public interface ChoseATrouverPrixJusteService {
    ChoseATrouverPrixJuste SaveChose(ChoseATrouverPrixJuste chose);

    List<ChoseATrouverPrixJuste> FetchChoseList();

    Optional<ChoseATrouverPrixJuste> ReadChose(Long id);

    ChoseATrouverPrixJuste UpdateChose(ChoseATrouverPrixJuste chose, Long choseId);

    void DeleteChose(Long choseId);
}
