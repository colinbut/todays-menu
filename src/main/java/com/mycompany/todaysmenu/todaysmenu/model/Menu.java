/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "menu")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date", unique = true, nullable = false)
    private Date date;

    @OneToMany(mappedBy = "dishName", cascade = CascadeType.ALL)
    private Set<Starter> starters = new HashSet<>(0);

    @OneToMany(mappedBy = "dishName", cascade = CascadeType.ALL)
    private Set<MainCourse> mainCourses = new HashSet<>(0);

    @OneToMany(mappedBy = "dishName", cascade = CascadeType.ALL)
    private Set<Dessert> desserts = new HashSet<>(0);
}
