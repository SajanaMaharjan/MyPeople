/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.Discussion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rejina
 */
@Stateless
public class DiscussionFacade extends AbstractFacade<Discussion> implements DiscussionFacadeLocal {
    @PersistenceContext(unitName = "MyPeoplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DiscussionFacade() {
        super(Discussion.class);
    }
    
}
