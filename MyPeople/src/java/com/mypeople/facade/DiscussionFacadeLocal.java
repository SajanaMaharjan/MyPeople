/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Discussion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rejina
 */
@Local
public interface DiscussionFacadeLocal {
   
    void create(Discussion eventComment);

    void edit(Discussion eventComment);

    void remove(Discussion eventComment);

    Discussion find(Object id);

    List<Discussion> findAll();

    List<Discussion> findRange(int[] range);
    
    int count();

}
