/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "main_course")
@Data
public class MainCourse {

    @Column(name = "dish_name", length = 50, nullable = false)
    private String dishName;

    @ManyToOne()
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;
}
