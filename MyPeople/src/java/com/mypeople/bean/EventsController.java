/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.Events;
import java.io.Serializable;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 *
 * @author sajana
 */
@Named
@ApplicationScoped
public class EventsController implements Serializable{
  
    private Events newEvent;
    
    public void addEvent(){
        
    }
}
