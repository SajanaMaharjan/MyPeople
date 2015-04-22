/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.MyPeopleMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sajana
 */
@Stateless
public class MyPeopleMemberFacade extends AbstractFacade<MyPeopleMember> implements MyPeopleMemberFacadeLocal {
    @PersistenceContext(unitName = "MyPeoplePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MyPeopleMemberFacade() {
        super(MyPeopleMember.class);
    }
    
}
