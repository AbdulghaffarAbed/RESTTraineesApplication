package edu.training.traineesrestapplication.TraineesController;


import edu.training.traineesrestapplication.TraineesEntitiy.Trainees;
import edu.training.traineesrestapplication.TraineesService.TraineesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * TraineesController which will controll all connection attempts to trainees information
 * Include listeners for CRUD Http operations
 * The URL must start with: http://localhost:8080/api/trainees
 */


@RestController
@RequestMapping("api/trainees")
public class TraineesController {

    @Autowired
    private TraineesService traineesService;   // autowire reference to TraineesService class

    /**
     * Used Display all trainees table content
     *
     * @return a list of table rows
     */


    @GetMapping
    @PreAuthorize("hasAuthority('trainee:read')")
    public List<Trainees> findAllTrainees() {
        return traineesService.findAllTrainees();
    }

    /**
     * Used to display a specific row using its id
     *
     * @param id reference to the row id
     * @return the required row data
     */


    @GetMapping("find/{id}")
    @PreAuthorize("hasAuthority('trainee:read')")
    public Optional<Trainees> findEmployeeById(@PathVariable("id") int id) {
        return traineesService.findTraineeById(id);
    }

    /**
     * Post method used to create a new row in the trainees table
     *
     * @param trainees reference to the trainees entity
     * @return the new added row
     */


    @PostMapping("/addTrainee")
    @PreAuthorize("hasAuthority('trainee:add')")
    public Trainees saveEmployee(@RequestBody Trainees trainees) {
        return traineesService.saveTrainee(trainees);
    }

    /**
     * Put method used to update row data based on the passed id
     * Using put we must include all row fields
     *
     * @param trainees reference to the trainees entity
     * @return the updated row
     */


    @PutMapping("/update/{id}")
    @PreAuthorize("hasAuthority('trainee:update')")
    public Trainees updateEmployee(@PathVariable("id") int id, @RequestBody Trainees trainees) throws Exception {
        return traineesService.updateTrainee(id, trainees);
    }

    /**
     * This http method used to delete a row in the table based on the row id
     * for DELETE request we didn't create permission, so we use the role directly inside @PreAuthorize to decide
     * how can access and execute this request which the admin
     *
     * @param id represent the primary key of the required row
     */


    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteEmployee(@PathVariable("id") int id) {
        traineesService.deleteTrainee(id);
    }
}
