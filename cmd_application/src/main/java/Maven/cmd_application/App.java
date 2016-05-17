package Maven.cmd_application;


import java.util.*;

import com.eric.test.app.utilities.JDBC_utilities; 



public class App 
{
    public static void main( String[] args )
    {
    	try{
    	
    	//char ex='\n';
    		char ex='\n';
   while(JDBC_utilities.createDBConnection())
   {
	   Scanner sc = new Scanner(System.in);
	   if((ex == 'E')||(ex == 'e'))
	   {
		 JDBC_utilities.closeDBConnection();
		 System.out.println("Application closed");
		 System.exit(0);
	   }
	   else
	   {
	    char input='\n';
    	
    	Functionalities function=new Functionalities();
     // if(JDBC_utilities.createDBConnection()){
    	System.out.println("Enter your choice: \nC : Create a new user \nR : Fetch existing user \nU :Update user details \nD : delete the User \nE : Exit application");
     	input=sc.next().charAt(0);				   

     	
   		if((input == 'c')||(input == 'C'))
     {
    	function.create();
   		System.out.println("User created successfully");
     }
     
     else if(input== 'r' || input== 'R' )
    {
    	 	function.retrieve();
    	 	System.out.println("Information Retrieved successfully");
  
    }
     
      else if(input== 'u' || input== 'U' )
	    { 
    	  	function.update(); 
    	  	System.out.println("Information updated successfully");
	    }
     else if(input== 'd' || input== 'D' )
	    {
    	 	function.delete();
    	 	System.out.println("User Inofrmation deleted");
	    }
     else if(input== 'e' || input== 'E' )
	    {
    	 JDBC_utilities.closeDBConnection();
		 System.out.println("Application closed");
		 System.exit(0);
	    }
	 
     else
       {
    	 System.out.println("Enter valid Input");
       }
    System.out.println("Enter e or E to exit the application");
   }
    
	   	ex='\n';
	    ex=sc.next().charAt(0);
   }
    

   }
     catch(Exception e){
    	 e.printStackTrace();
     }
    	
    }
    
}

