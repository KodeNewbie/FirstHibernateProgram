package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ObjectStates {

    public static void main(String[] args) {
        
        SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        Transaction transaction=session.beginTransaction();
        
        //Transient state
        Employee employee=new Employee(766, "Imran", 50000);
        
        
        //Persistent state   [ session object copy -> database object copy ]
        //session.save(employee);
        session.persist(employee);
        //session.saveOrUpdate(employee);
        //session.update(employee);
        
        //detached state [database object detached from session object]
        //session.clear();
        //session.close();
        session.evict(employee);
        //Transaction transaction=session.beginTransaction();session.detach(employee);
        
        employee.setSalary(90000);
        
        session.update(employee);
        
        //removed state [object removed from session and database]
        //session.remove(employee);
        
        transaction.commit();
    }
}