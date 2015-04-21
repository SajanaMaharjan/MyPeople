/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.Events;
import com.mypeople.facade.EventsFacade;
import com.mypeople.facade.EventsFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.persistence.Temporal;

/**
 *
 * @author sajana
 */
@ManagedBean
@SessionScoped
public class EventsController implements Serializable {

    @EJB
    EventsFacadeLocal service;
    private Events newEvent;
    private String eventName;
    @Temporal(javax.persistence.TemporalType.DATE)
    private String eventDate;
    private String eventDesc;
    private List<Events> eventList;

    public EventsController() {
        service = new EventsFacade();
        newEvent = new Events();
        eventList = new ArrayList<>(Arrays.asList(
                new Events("PU-ERH Tea", "sd", "sadfa"),
                new Events("PU-ERH Tea", "fsda", "sadfa"),
                new Events("PU-ERH Tea", "sdf", "sadfa"),
                new Events("PU-ERH Tea", "ffsd", "sadfa")));
    }

    public void addEvent() {
        Events newEvent = new Events(eventName, eventDate, eventDesc);
        eventList.add(newEvent);
        service.create(newEvent);
    }

    public Events getNewEvent() {
        return newEvent;
    }

    public void setNewEvent(Events newEvent) {
        this.newEvent = newEvent;
    }

    public List<Events> getEventList() {
        return eventList;
    }

    public void setEventList(List<Events> eventList) {
        this.eventList = eventList;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    
}
