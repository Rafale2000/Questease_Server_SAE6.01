package fr.uphf.questease.repository;

import fr.uphf.questease.model.SincereMenteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositoire de la classe SincereMenteur
 */
@Repository
public interface SincereMenteurRepository extends CrudRepository<SincereMenteur, Long> {

}
