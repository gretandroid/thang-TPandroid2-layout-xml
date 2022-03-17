package com.example.tpandroid2layoutxml.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PersonInfo {
    private String surname;
    private String name;
    private List<String> formations = new ArrayList<>();
    private String marriageStatus;
    private String country;
    private Date date;

    public PersonInfo() {
        super();
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getFormations() {
        return Collections.unmodifiableList(formations);
    }

    public void addFormation(String formation) {
        this.formations.add(formation);
    }

    public void addFormations(List<String> formations) {
        this.formations.addAll(formations);
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", formations='" + formations + '\'' +
                ", marriageStatus='" + marriageStatus + '\'' +
                ", country='" + country + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonInfo)) return false;
        PersonInfo that = (PersonInfo) o;
        return Objects.equals(surname, that.surname) && Objects.equals(name, that.name) && Objects.equals(formations, that.formations) && Objects.equals(marriageStatus, that.marriageStatus) && Objects.equals(country, that.country) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, formations, marriageStatus, country, date);
    }
}
