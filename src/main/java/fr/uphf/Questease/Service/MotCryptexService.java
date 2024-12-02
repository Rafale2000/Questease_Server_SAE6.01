package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.Indice;
import fr.uphf.Questease.Model.MotCryptex;

import java.util.List;
import java.util.Optional;

public interface MotCryptexService {
    MotCryptex SaveMotCryptex(MotCryptex motCryptex);

    List<MotCryptex> FetchMotCryptexList();

    Optional<MotCryptex> FetchMotCryptex(Long id);

    MotCryptex UpdateMotCryptex(MotCryptex motCryptex, Long motCrpyexId);

    void deleteMotCryptex(Long motCryptexId);
}
