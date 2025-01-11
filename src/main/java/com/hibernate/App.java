package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hello world!
 *
 */
public class App 
{
      SessionFactory sessionFactory=null;
      Session session=null;
      Transaction transaction=null;
    public App()
    {
        sessionFactory=HibernateConfiguration.getSessionFactory();
        session=sessionFactory.openSession();
        
    }
     public void addEmployee()
    {        transaction=session.beginTransaction();
              Employee employee=new Employee(55353, "Sonam", 40000);          
              session.save(employee);         
              transaction.commit();  
    }
     
     public void updateEmployee()
     {          transaction=session.beginTransaction();
              Employee employee=session.get(Employee.class, new Long(123));       
              employee.setName("Kumar"); employee.setSalary(60000);           
              session.saveOrUpdate(employee);   
              transaction.commit();  
     }
     
     public void fetchEmployee()
     {
            
             // get method(single object)
              Employee employee=session.get(Employee.class, new Long(123)); 
              System.out.println(employee);
              
              
              //load method(single object) 
              Employee employee1=session.load(Employee.class,new Long(123)); 
              System.out.println(employee1);
             
     }
     
     public void deleteEmployee()
     {      transaction=session.beginTransaction();
            Employee employee=session.get(Employee.class, new Long(123));
            session.delete(employee);
             
             transaction.commit();
             
         
             session.close();
     }
     
    public static void main( String[] args )
    {
      App app=new App();
      app.addEmployee();
      app.updateEmployee();
      app.fetchEmployee();
      app.deleteEmployee();
      
    }
}
