package com.ascending.training.model;

import java.util.Objects;

public class Department {
    private int id;
    private String name;
    private String description;
    private String location;


    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String getLocation(){
        return location;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, location);
    }



}
