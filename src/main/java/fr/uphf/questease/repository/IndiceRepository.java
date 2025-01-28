package fr.uphf.questease.repository;

import fr.uphf.questease.model.Indice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe Indice
 */
@Repository
public interface IndiceRepository extends CrudRepository<Indice, Long> {

}
