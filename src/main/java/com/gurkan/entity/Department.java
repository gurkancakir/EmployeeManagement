package com.gurkan.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gurkan on 2/9/17.
 */
@Entity
@Table(name = "department")
public class Department {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name="user_department", referencedColumnName="id")
    private List<User> users;

    @Column(name="name")
    private String name;

    @Column(name="startHour")
    private int startHour;

    @Column(name="endHour")
    private int endHour;

    @Column(name="startMinute")
    private int startMinute;

    @Column(name="endMinute")
    private int endMinute;

    @Column(name="startDays")
    private int startDays;

    @Column(name="endDays")
    private int endDays;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public int getStartMinute() {
        return startMinute;
    }

    public void setStartMinute(int startMinute) {
        this.startMinute = startMinute;
    }

    public int getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(int endMinute) {
        this.endMinute = endMinute;
    }

    public int getStartDays() {
        return startDays;
    }

    public void setStartDays(int startDays) {
        this.startDays = startDays;
    }

    public int getEndDays() {
        return endDays;
    }

    public void setEndDays(int endDays) {
        this.endDays = endDays;
    }
}
