package fr.uphf.questease.Repository;

import fr.uphf.questease.Model.MotPendu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe MotPendu
 */
@Repository
public interface MotPenduRepository extends CrudRepository<MotPendu, Long> {

}