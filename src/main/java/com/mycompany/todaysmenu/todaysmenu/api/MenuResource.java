/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu.api;

import com.mycompany.todaysmenu.todaysmenu.model.Menu;
import com.mycompany.todaysmenu.todaysmenu.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
public class MenuResource {

    @Autowired
    private MenuRepository menuRepository;

    @GetMapping("/menus")
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @GetMapping("/menu/{date}")
    public Menu getMenu(@PathVariable("date") Date date){
        return menuRepository.findByDate(date)
            .orElseThrow(() -> new RuntimeException("Error Finding Menu with date: " + date));
    }

    @PostMapping("/menu/save")
    public void newMenu(@Valid @RequestBody Menu menu) {
        menuRepository.save(menu);
    }

    @PutMapping("/menu/update")
    public void updateMenu(@Valid @RequestBody Menu menu) {
        Date date = menu.getDate();

        if (menuRepository.findByDate(date).isPresent()) {
            menuRepository.save(menu);
        } else {
            throw new RuntimeException("Menu with date: " + date + " is not present in records");
        }
    }

    @DeleteMapping("/menu/{date}")
    public ResponseEntity deleteMenu(@PathVariable("date") Date date) {
        if (!menuRepository.findByDate(date).isPresent()) {
            throw new RuntimeException("Menu with date: " + date + " is not present to be deleted");
        }

        Menu menu = menuRepository.findByDate(date).get();
        menuRepository.delete(menu);

        return ResponseEntity.ok().build();
    }
}
