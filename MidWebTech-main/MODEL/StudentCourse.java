package MODEL;

import javax.persistence.*;

@Entity
@Table(name = "studentCourse")
public class StudentCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "registration_id", referencedColumnName = "registration_id")
    private StudentRegistration studentRegistration;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private Course course;

    @Column(name = "credits")
    private int credits;

    @Column(name = "results")
    private String results;

    public StudentCourse() {
    }

    public StudentCourse(StudentRegistration studentRegistration, Course course, int credits, String results) {
        this.studentRegistration = studentRegistration;
        this.course = course;
        this.credits = credits;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentRegistration getStudentRegistration() {
        return studentRegistration;
    }

    public void setStudentRegistration(StudentRegistration studentRegistration) {
        this.studentRegistration = studentRegistration;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }
}