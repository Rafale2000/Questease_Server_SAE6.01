package fr.uphf.Questease.Repository;

import fr.uphf.Questease.Model.Son;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe Son
 */
@Repository
public interface SonRepository extends CrudRepository<Son, Long> {

}