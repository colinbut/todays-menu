/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu.web;

import com.mycompany.todaysmenu.todaysmenu.model.Menu;
import com.mycompany.todaysmenu.todaysmenu.repository.MenuRepository;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.Optional;

@Controller
@Slf4j
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String getMenu(Model model) {
        Date todaysDate = DateTime.now().toDate();
        Optional<Menu> menu = menuRepository.findByDate(todaysDate);

        if (menu.isPresent()) {
            model.addAttribute("menu", menu);
        } else {
            log.warn("No Menu for today: {}", todaysDate);
        }

        return "menu";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAdminPage(Model model) {
        return "admin";
    }
}
