/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Events;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sajana
 */
@Local
public interface EventsFacadeLocal {
      void create(Events event);

    void edit(Events event);

    void remove(Events event);

    Events find(Object id);

    List<Events> findAll();

    List<Events> findRange(int[] range);

    int count();
    
    public Events getUserInfo(String email);
    
    public List<Events> findActiveUsers();
    
      
}
