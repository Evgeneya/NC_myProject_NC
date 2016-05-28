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
    private PositionEntity position;

    @Column(name="hour")
    private int hour;

    public Resources_planEntity(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public PositionEntity getPosition() {
        return position;
    }

    public void setPosition(PositionEntity position) {
        this.position = position;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int man_hour) {
        this.hour = man_hour;
    }
}
