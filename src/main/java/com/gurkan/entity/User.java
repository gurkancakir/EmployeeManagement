package com.gurkan.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="app_user")
public class User {
    @Id @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="password")
    private String password;

    @Column(name="price")
    private int price;

    @Column(name="weeklyWorkingHours")
    private int weeklyWorkingHours;

    @OneToMany
    @JoinColumn(name="app_user_id", referencedColumnName="id")
    private List<UserRole> roles;

    @ManyToMany(mappedBy = "users")
    private List<Task> tasks;
    
    public User() { }
    
    public User(Long id, String username, String password, List<UserRole> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeeklyWorkingHours() {
        return weeklyWorkingHours;
    }

    public void setWeeklyWorkingHours(int weeklyWorkingHours) {
        this.weeklyWorkingHours = weeklyWorkingHours;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
