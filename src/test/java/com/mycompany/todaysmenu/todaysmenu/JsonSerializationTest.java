/*
 * |-------------------------------------------------
 * | Copyright © 2018 Colin But. All rights reserved. 
 * |-------------------------------------------------
 */
package com.mycompany.todaysmenu.todaysmenu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mycompany.todaysmenu.todaysmenu.model.Menu;
import com.mycompany.todaysmenu.todaysmenu.model.Starter;
import org.joda.time.DateTime;
import org.junit.Test;

public class JsonSerializationTest {

    @Test
    public void givenEntities_whenJsonSerialize_thenSerializeCorrectly() throws JsonProcessingException {
        Menu menu = new Menu();
        menu.setId(1);
        menu.setDate(DateTime.now().toDate());

        Starter starter = new Starter();
        starter.setId(2);
        starter.setDishName("Dish");
        starter.setMenu(menu);

        menu.getStarters().add(starter);

        String result = new ObjectMapper().writeValueAsString(menu);

        System.out.println(result);
    }
}
