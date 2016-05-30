package myProject.entities;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by 1 on 26.04.2016.
 */
@Entity
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(generator="CustomerSeq")
    @SequenceGenerator(name="CustomerSeq",sequenceName="CUSTOMER_ID_SEQ", allocationSize=1)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Collection<ProjectEntity> projects;


    public CustomerEntity(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<ProjectEntity> getProjects() {
        return projects;
    }

    public void setProjects(Collection<ProjectEntity> projects) {
        this.projects = projects;
    }
}
