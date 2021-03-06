/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.bean;

import com.mypeople.entity.Event;
import com.mypeople.entity.EventComment;
import com.mypeople.facade.EventsFacade;
import com.mypeople.facade.EventsFacadeLocal;
import com.mypeople.facade.EventCommentFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author sajana
 */
@ManagedBean
@ViewScoped
public class EventsController implements Serializable {

    @EJB
    EventsFacadeLocal service;
    @EJB
    EventCommentFacadeLocal commentFacade;
    private Event event;
    private List<Event> eventList;
    private EventComment comments;
    private List<EventComment> commentList;

    @PostConstruct
    public void initEvents() {
        eventList = service.findAll();
    }

    public EventsController() {
        service = new EventsFacade();
        comments = new EventComment();
        event = new Event();
    }

    public String addEvent() {
        service.create(event);
        return "event";
    }

    public void updateEvent(Event e) throws IOException{
        service.edit(e);
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/eventDetails.faces?eventId=" + e.getId());

    }

    public String deleteEvent(Event e) {
        commentList = commentFacade.getCommentOfEvent(e.getId());
        for (EventComment comment : commentList) {
            commentFacade.remove(comment);
        }

        service.remove(e);
        return "event";
    }

    public void preRenderView(String eventId) {

        if (!eventId.isEmpty()) {
            event = service.find(Long.parseLong(eventId));
            commentList = commentFacade.getCommentOfEvent(Long.parseLong(eventId));
        }
    }

    public void postComment() throws IOException {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Event event = service.find(Long.parseLong(params.get("eventId")));
        comments.setEvent(event);

        Date curDate = new Date();

        comments.setCreatedDate(curDate);
        commentFacade.create(comments);

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect(context.getRequestContextPath() + "/eventDetails.faces?eventId=" + event.getId());

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
    
    public EventComment getComments() {
        return comments;
    }

    public void setComments(EventComment comments) {
        this.comments = comments;
    }

    public List<EventComment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<EventComment> commentList) {
        this.commentList = commentList;
    }

}
