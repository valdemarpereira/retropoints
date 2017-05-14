package com.valdemar.retropoints.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;


public class Retropoint {

    @Id
    private Integer id;
    private String retropoint;
    private boolean done;
    private String dueDate;
    private TeamMember teamMember;

    public Retropoint() {
    }

    public Retropoint(Integer id, String retropoint, boolean done, String dueDate, TeamMember teamMember) {
        this.id = id;
        this.retropoint = retropoint;
        this.done = done;
        this.dueDate = dueDate;
        this.teamMember = teamMember;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRetropoint() {
        return retropoint;
    }

    public void setRetropoint(String retropoint) {
        this.retropoint = retropoint;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}
