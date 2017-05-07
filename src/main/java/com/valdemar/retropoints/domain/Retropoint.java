package com.valdemar.retropoints.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;


public class Retropoint {

    @Id private Integer id;

    private String retropoint;
    private boolean done;
    private LocalDate dueDate;
    private TeamMember teamMember;

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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
    }
}
