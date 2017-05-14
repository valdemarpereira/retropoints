package com.valdemar.retropoints.domain;

import org.springframework.data.annotation.Id;

public class TeamMember {

    @Id private String id;
    private String name;
    private String username;
    private String email;

    public TeamMember() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TeamMember(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public static TeamMember of(String name, String username, String email){
        return new TeamMember(name, username, email);
    }
}
