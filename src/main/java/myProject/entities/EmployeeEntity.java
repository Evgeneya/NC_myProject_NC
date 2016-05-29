package myProject.entities;

import javax.persistence.*;
import java.util.Collection;


/**
 * Created by 1 on 26.04.2016.
 */

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(generator="EmployeeSeq")
    @SequenceGenerator(name="EmployeeSeq",sequenceName="EMPLOYEE_ID_SEQ", allocationSize=1)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="phone")
    private String phone;

    @Column(name="age")
    private int age;

    @Column(name="status")
    private String status;

    @Column(name="experience")
    private int experience;

    @Column(name="salary")
    private int salary;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id")
    private PositionEntity position;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private Collection<EmploymentEntity> employments;

    public EmployeeEntity(){

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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    public Collection<EmploymentEntity> getEmployments() {
        return employments;
    }

    public void setEmployments(Collection<EmploymentEntity> employments) {
        this.employments = employments;
    }

    @Override
    public String toString(){
        return "id = " + id +", name = " + name + ", email = " + email +
                ", phone = " + phone + ", age = " + age + ", status = " + status +
                ", experience = " + experience + ", salary = " + salary + ";";
    }
}
