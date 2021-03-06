package myProject.entities;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by 1 on 26.04.2016.
 */
@Entity
@Table(name = "project")
public class ProjectEntity {
    @Id
    @Column(name="id")
    @GeneratedValue(generator="ProjectSeq")
    @SequenceGenerator(name="ProjectSeq",sequenceName="PROJECT_ID_SEQ", allocationSize=1)
    private long id;

    @Column(name="name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name="beg_date")
    private Date begDate;

    @Temporal(TemporalType.DATE)
    @Column(name="end_date")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Collection<EmploymentEntity> employments;

    @OneToMany(mappedBy = "project", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Collection<Resources_planEntity> plans;

    public ProjectEntity(){

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


    public Date getBeg_date() {
        return begDate;
    }

    public void setBeg_date(Date beg_date) {
        this.begDate = beg_date;
    }

    public Date getEnd_date() {
        return endDate;
    }

    public void setEnd_date(Date end_date) {
        this.endDate = end_date;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public Collection<EmploymentEntity> getEmployments() {
        return employments;
    }

    public void setEmployments(Collection<EmploymentEntity> employments) {
        this.employments = employments;
    }

    public Collection<Resources_planEntity> getPlans() {
        return plans;
    }

    public void setPlans(Collection<Resources_planEntity> plans) {
        this.plans = plans;
    }
}
