package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Indice;

import java.util.List;
import java.util.Optional;

public interface IndiceService {
    Indice SaveIndice(Indice indice);

    List<Indice> FetchIndiceList();

    Optional<Indice> FetchIndice(Long id);

    Indice UpdateIndice(Indice indice, Long indiceId);

    void deleteIndice(Long indiceId);
}
