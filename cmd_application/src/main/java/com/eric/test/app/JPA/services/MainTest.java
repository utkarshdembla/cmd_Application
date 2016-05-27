package com.eric.test.app.JPA.services;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.*;
import java.util.*;

public class MainTest {
	EntityManager em = ParsistenceManager.INSTANCE.getEntityManager();
	Scanner sc= new Scanner(System.in);
  public void createUser(String firstname,String lastname,String username,String email,String password,String phonenumber){
    cmd table_input = new cmd();
    table_input
    	.setFirstName(firstname)
        .setLastName(lastname)
        .setUsername(username)
        .setEmail(email)
        .setPassword(password)
    	.setPhonennumber(phonenumber)
    	;
    	
    
    em.getTransaction()
        .begin();
    em.persist(table_input);
    em.getTransaction()
        .commit();
    em.close();
    ParsistenceManager.INSTANCE.close();
  }
  
  @SuppressWarnings("unchecked")
public void retrieveUser(int UserId)
{
	
	  int userid=UserId;
	//  System.out.println(userid);
	  
	 
	  Query query=em.createQuery("SELECT c FROM cmd c where c.UserId=:userid");
	  query.setParameter("userid", userid); 
	  List<cmd> list= query.getResultList();
	  System.out.println(list);
  }

  public void updateUser(int UserId)
  {
  	 String firstname;
  	 String lastname;
  	 String username;
	 String email;
	 String phonennumber;
	 String password;
  	 int userid=UserId;
  	 int n;		
	System.out.println("Enter the option which you want to select");
	n=sc.nextInt();	
  	
  	cmd table_input=em.find(cmd.class, userid);
  	
  	em.getTransaction().begin();
  	

  	switch(n)
	{
	case 1: 	 System.out.println("Enter Firstname:");
	 firstname= sc.next();
	 table_input.setFirstName(firstname);
    break;
    
	case 2: 	 System.out.println("Enter Lastname:");
	 lastname= sc.next();
	 table_input.setLastName(lastname);
    break;
    
	case 3: 	 System.out.println("Enter Username:");
	 username= sc.next();
	 table_input.setUsername(username);
     break;
     
	case 4: 	 System.out.println("Enter email:");
	 email= sc.next();
	 table_input.setEmail(email);
     break;
     
	 case 5: 	 System.out.println("Enter password:");
     
	 password= sc.next();			        
	 table_input.setPassword(password);
     break;
     
	 case 6: 	 System.out.println("Enter phonenumber:");
     phonennumber= sc.next();
     table_input.setPhonennumber(phonennumber);
     break;
     
	 default : System.out.println("Enter valid input:");
	}
	
  	em.getTransaction().commit();

    }
  
  
 public void deleteUser(int UserId)
  {
  	
  	  int userid=UserId;
  	cmd table_input=em.find(cmd.class, userid);
  	em.getTransaction().begin();
  	em.remove(table_input);
  	em.getTransaction().commit();
    }



}