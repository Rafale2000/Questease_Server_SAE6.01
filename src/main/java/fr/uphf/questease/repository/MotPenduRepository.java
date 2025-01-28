package fr.uphf.questease.repository;

import fr.uphf.questease.model.MotPendu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe MotPendu
 */
@Repository
public interface MotPenduRepository extends CrudRepository<MotPendu, Long> {

}