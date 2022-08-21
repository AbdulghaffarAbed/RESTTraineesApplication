package edu.training.traineesrestapplication.TraineesEntitiy;

import javax.persistence.*;

/**
 * Trainees class used as entity to store trainee information
 * On the other hand, this class converted to table based on ORM concept
 * JPA annotations to convert object to relational database
 */


@Entity(name = "trainees")      // used to create table in the database
@Table                          // this annotation used to assign properties for table elements
public class Trainees {

    // Define instance variables to store trainer's information

    @Id                                                 // annotation to define the primary key for the table
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainee_id",                       // Column annotation used to assign properties for the column elements
            updatable = false,
            nullable = false)
    private int id;              // Used to store trainee ID

    @Column(name = "trainee_name",
            nullable = false,
            columnDefinition = "TEXT")
    private String name;         // Used to store trainee name

    @Column(name = "trainee_university",
            nullable = false,
            columnDefinition = "TEXT")
    private String university;      // Used to store university name

    @Column(name = "training_path",
            nullable = false,
            columnDefinition = "TEXT")
    private String trainingPath;        // Used to store training path type to the trainee

    @Column(name = "trainee_GPA",
            nullable = false,
            columnDefinition = "NUMERIC (3,2)")
    private float GPA;                 // Describe trainee grade point average

    /**
     * Create constructor includes all instance variables instead of id
     * Because id will generate as a sequence automatically for every new trainee
     *
     * @param name         trainee name
     * @param university   trainee university
     * @param trainingPath trainee training path
     * @param GPA          trainee GPA
     */


    public Trainees(String name, String university, String trainingPath, float GPA) {
        this.name = name;
        this.university = university;
        this.trainingPath = trainingPath;
        this.GPA = GPA;
    }

    /**
     * Default constructor
     */


    public Trainees() {
    }

    /**
     * Getter and Setter methods for the instance variables
     */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTrainingPath() {
        return trainingPath;
    }

    public void setTrainingPath(String trainingPath) {
        this.trainingPath = trainingPath;
    }

    public float getGPA() {
        return GPA;
    }

    public void setGPA(float GPA) {
        this.GPA = GPA;
    }

    /**
     * toString method to display instance variables values as one string
     */


    @Override
    public String toString() {
        return "Trainees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", university='" + university + '\'' +
                ", trainingPath='" + trainingPath + '\'' +
                ", GPA=" + GPA +
                '}';
    }
}
