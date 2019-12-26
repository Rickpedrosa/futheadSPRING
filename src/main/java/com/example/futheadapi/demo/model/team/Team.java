package com.example.futheadapi.demo.model.team;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    private String club;
    private String club_logo;
    private float average;
    private float average_team;
    private float quality;

    public Team() {
    }

    public Team(String club, String club_logo,
                float average, float average_team, float quality) {
        this.club = club;
        this.club_logo = club_logo;
        this.average = average;
        this.average_team = average_team;
        this.quality = quality;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getClub_logo() {
        return club_logo;
    }

    public void setClub_logo(String club_logo) {
        this.club_logo = club_logo;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public float getAverage_team() {
        return average_team;
    }

    public void setAverage_team(float average_team) {
        this.average_team = average_team;
    }

    public float getQuality() {
        return quality;
    }

    public void setQuality(float quality) {
        this.quality = quality;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object obj) {
        return ((Team) obj).club.equals(this.club);
    }

    @Override
    public int hashCode() {
        return club.hashCode();
    }
}
