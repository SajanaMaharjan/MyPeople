/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.EventComment;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sajana
 */
@Local
public interface EventCommentFacadeLocal {

    void create(EventComment eventComment);

    void edit(EventComment eventComment);

    void remove(EventComment eventComment);

    EventComment find(Object id);

    List<EventComment> findAll();

    List<EventComment> findRange(int[] range);

    List<EventComment> getCommentOfEvent(Long eventId);
    
    int count();
    
}
