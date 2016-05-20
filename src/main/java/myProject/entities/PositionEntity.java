package myProject.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 1 on 26.04.2016.
 */

@Entity
@Table(name="position")
public class PositionEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(generator="PositionSeq")
    @SequenceGenerator(name="PositionSeq",sequenceName="POSITION_ID_SEQ", allocationSize=1)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="min_salary")
    private int min_salary;

    @Column(name="max_salary")
    private int max_salary;

    @OneToMany(mappedBy = "position")
    private Collection<EmployeeEntity> employees;

    @OneToMany(mappedBy = "position")
    private Collection<Resources_planEntity> plans;

    public PositionEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(int min_salary) {
        this.min_salary = min_salary;
    }

    public int getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(int max_salary) {
        this.max_salary = max_salary;
    }

    public Collection<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(Collection<EmployeeEntity> employees) {
        this.employees = employees;
    }

    @Override
    public String toString(){
        return "id = " + id + ", name = " + name + ", minSalary = " + min_salary + ", maxSalary = " + max_salary + ";";
    }
}
