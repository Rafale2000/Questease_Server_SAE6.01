package fr.uphf.questease.repository;

import fr.uphf.questease.model.Son;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe Son
 */
@Repository
public interface SonRepository extends CrudRepository<Son, Long> {

}