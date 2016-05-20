package myProject.entities;

import javax.persistence.*;

/**
 * Created by 1 on 27.04.2016.
 */

@Entity
@Table(name="resources_plan")
public class Resources_planEntity {

    @Id
    @Column(name="id")
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;

    @ManyToOne(optional = false)
    @JoinColumn(name = "position_id")
    private ProjectEntity position;

    @Column(name="man_hour")
    private int man_hour;

    public Resources_planEntity(){

    }




    public int getMan_hour() {
        return man_hour;
    }

    public void setMan_hour(int man_hour) {
        this.man_hour = man_hour;
    }
}
