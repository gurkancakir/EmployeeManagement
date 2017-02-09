package com.gurkan.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gurkan on 2/9/17.
 */
@Entity
@Table(name = "task_detail")
public class TaskDetail {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "date")
    private Date date;

    @Column(name = "time")
    private int time;
}
