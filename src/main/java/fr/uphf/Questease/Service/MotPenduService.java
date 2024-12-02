package fr.uphf.Questease.Service;

import fr.uphf.Questease.Model.MotPendu;

import java.util.List;
import java.util.Optional;

public interface MotPenduService {
    MotPendu SaveMotPendu(MotPendu motPendu);

    List<MotPendu> FetchMotPenduList();

    Optional<MotPendu> FetchOne(Long idPendu);

    MotPendu UpdateMotPendu(MotPendu motPendu, Long motpenduId);

    void DeleteMotPendu(Long motPenduId);
}
