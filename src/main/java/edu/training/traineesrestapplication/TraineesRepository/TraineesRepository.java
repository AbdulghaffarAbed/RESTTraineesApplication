package edu.training.traineesrestapplication.TraineesRepository;

import edu.training.traineesrestapplication.TraineesEntitiy.Trainees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * TraineesRepository interface extend JpaRepository to use JPA methods
 * where it provides powerful methods to deal with database through java
 */

@Repository
public interface TraineesRepository extends JpaRepository<Trainees,Integer> {
}
