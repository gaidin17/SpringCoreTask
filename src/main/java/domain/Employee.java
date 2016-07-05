package domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Evgeny_Akulenko on 7/4/2016.
 */
@Entity(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private int id;

    private String name;

    @OneToMany(targetEntity = Job.class, fetch = FetchType.EAGER, mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Job> jobs;

    public Employee() {

    }

    public Employee(String name) {
        this.name = name;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            if (this.getId() == ((Employee) obj).getId()) {
                return true;
            }
        }
        return false;
    }
}
