package fr.uphf.Questease.Repository;

import fr.uphf.Questease.Model.MotPendu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe MotPendu
 */
@Repository
public interface MotPenduRepository extends CrudRepository<MotPendu, Long> {

}