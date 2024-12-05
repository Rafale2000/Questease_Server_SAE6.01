package fr.uphf.Questease.Repository;

import fr.uphf.Questease.Model.MotCryptex;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe MotCryptex
 */
@Repository
public interface MotCryptexRepository extends CrudRepository<MotCryptex, Long> {

}
