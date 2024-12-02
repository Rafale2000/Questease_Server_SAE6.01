package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Son;

import java.util.List;
import java.util.Optional;

public interface SonService {
    Son SaveSon(Son son);

    List<Son> FetchSonList();

    Optional<Son> FetchOne(Long idSon);

    Son UpdateSon(Son son, Long sonId);

    void DeleteSon(Long sonId);
}
