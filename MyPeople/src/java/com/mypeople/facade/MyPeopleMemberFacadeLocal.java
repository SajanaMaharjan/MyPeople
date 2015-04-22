/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mypeople.facade;

import com.mypeople.entity.MyPeopleMember;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author sajana
 */
@Local
public interface MyPeopleMemberFacadeLocal {

    void create(MyPeopleMember member);

    void edit(MyPeopleMember member);

    void remove(MyPeopleMember member);

    MyPeopleMember find(Object id);

    List<MyPeopleMember> findAll();

    List<MyPeopleMember> findRange(int[] range);

    int count();
    
}
