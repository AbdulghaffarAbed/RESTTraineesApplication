package edu.training.traineesrestapplication.TraineesService;


import edu.training.traineesrestapplication.TraineesEntitiy.Trainees;
import edu.training.traineesrestapplication.TraineesRepository.TraineesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * TraineesService include services done for trainees entity using Http methods
 *
 */


@Service
public class TraineesService implements TraineesServicesMethods {

    @Autowired
    private TraineesRepository traineesRepository; // Define DI reference for Trainees repository

    /**
     * findAllTrainees used to display all trainees data from trainees table
     * @return return a list include table rows
     */


    @Override
    public List<Trainees> findAllTrainees() {
        return traineesRepository.findAll();
    }

    /**
     * Used to find a row of trainee information based on the passed id
     * @param id  represent row id (primary key for the table)
     * @return id row information
     */


    @Override
    public Optional<Trainees> findTraineeById(int id) {
        return traineesRepository.findById(id);
    }

    /**
     * Used to save the json file passed through page body in the database
     * @param trainee reference to trainee entity
     * @return  the saved row information
     */


    @Override
    public Trainees saveTrainee(Trainees trainee) {
        return traineesRepository.save(trainee);
    }

    /**
     * Used with PUT method after update a row in the table
     * @param trainee reference to trainee entity
     * @return the updated row information
     */


    @Override
    public Trainees updateTrainee(int id,Trainees trainee) throws Exception {
        System.out.println(trainee.toString());
        Trainees updateTrainee = traineesRepository.findById(id)
                .orElseThrow(() -> new Exception("Trainee with id: "+id+" not exist"));
        updateTrainee.setName(trainee.getName());
        updateTrainee.setUniversity(trainee.getUniversity());
        updateTrainee.setTrainingPath(trainee.getTrainingPath());
        updateTrainee.setGPA(trainee.getGPA());
        return traineesRepository.save(updateTrainee);
    }

    /**
     * Used to delete a row in the database table based on the primary key (id)
     * @param id represent primary key for the wanted row to delete
     */


    @Override
    public void deleteTrainee(int id) {
        traineesRepository.deleteById(id);
    }
}
