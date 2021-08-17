package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "Avengers")
public class Avenger {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String power;

    @Column(name = "strenght", updatable = false, length = 50, nullable = false)
    private Integer strenght;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getStrenght() {
        return strenght;
    }

    public void setStrenght(Integer strenght) {
        this.strenght = strenght;
    }

    public Avenger( String name, String power, Integer strenght) {
        this.name = name;
        this.power = power;
        this.strenght = strenght;
    }

    public Avenger() {
    }
}
