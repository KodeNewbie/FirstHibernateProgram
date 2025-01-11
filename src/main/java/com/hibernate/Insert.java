package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Insert {


    public static void main(String[] args) {
        
        SessionFactory sessionFactory=HibernateConfiguration.getSessionFactory();
        Session session=sessionFactory.openSession();
        
        Transaction transaction=session.beginTransaction();

        Employee employee1=new Employee();
        employee1.setName("Ishita");
        employee1.setSalary(70000);
        
        session.persist(employee1);
        
        transaction.commit();
    }
}
