package edu.training.traineesrestapplication.TraineesService;


import edu.training.traineesrestapplication.TraineesEntitiy.Trainees;

import java.util.List;
import java.util.Optional;

/**
 * TraineesServicesMethods interface include methods to apply them as services
 * Such as display table contents, update row, delete row and others..
 */


public interface TraineesServicesMethods {

    List<Trainees> findAllTrainees();

    Optional<Trainees> findTraineeById(int id);

    Trainees saveTrainee(Trainees trainee);

    Trainees updateTrainee(int id,Trainees trainee) throws Exception;

    void deleteTrainee(int id);

}
