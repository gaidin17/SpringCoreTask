package domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
@Entity(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "deadline_date")
    private Date deadLineDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Job() {

    }

    public Job(Date date, String description) {
        this.deadLineDate = date;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Date getDeadLineDate() {
        return deadLineDate;
    }

    public String getDescription() {
        return description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
