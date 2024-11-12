package fr.uphf.Questease.Repository;

import fr.uphf.Questease.Model.SincereMenteur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SincereMenteurRepository extends CrudRepository<SincereMenteur, Long> {

}
