package myProject.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by 1 on 27.04.2016.
 */

@Entity
@Table(name = "employment")
public class EmploymentEntity {

    @Id
    @Column(name="id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employee;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;


    @Column(name="count_hour")
    private int countHour;

    public EmploymentEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public int getCount_hour() {
        return countHour;
    }

    public void setCount_hour(int count_hour) {
        this.countHour = count_hour;
    }
}
