/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu.web;

import com.mycompany.todaysmenu.todaysmenu.model.Menu;
import com.mycompany.todaysmenu.todaysmenu.repository.MenuRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String getMenu(Model model) {
        Optional<Menu> menu = menuRepository.findByDate(DateTime.now().toDate());
        menu.ifPresent(menu1 -> model.addAttribute("menu", menu1));
        return "menu";
    }
}
