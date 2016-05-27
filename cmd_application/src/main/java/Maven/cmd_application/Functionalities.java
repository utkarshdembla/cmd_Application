package Maven.cmd_application;

import java.util.*;

import com.eric.test.app.JPA.services.MainTest;
import com.eric.test.app.security.Crypt;
import com.eric.test.app.utilities.JDBC_utilities;

import java.sql.*;

public class Functionalities{
	
		JDBC_utilities j=new JDBC_utilities();
		MainTest m=new MainTest();
		Crypt crypt=new Crypt();
		
		Scanner sc= new Scanner(System.in);
		int userid;
	    String firstname;
	    String lastname;
	    String username;
	    String email;
	    String phonenumber;
	    String password;
	    String pass="\n";
	    char input='\n';
	  
	public void create() throws SQLException
	{  
	// System.out.println("Enter UserId:");
   	//UserId= sc.nextInt();
   	 	
   	 System.out.println("Enter Firstname:");
	 firstname= sc.next();
	 
	 System.out.println("Enter LastName:");
	 lastname= sc.next();
	 
	 System.out.println("Enter username:");
	 username= sc.next();
	 
	 System.out.println("Enter Password:");
	 password= sc.next();			
	
	// pass=password.toString();
	// String p=crypt.encrypt(password);
	// System.out.println(p);
	 
	 
	
	 System.out.println("Enter email:");
	 email= sc.next();
	 
	 System.out.println("Enter phonenumber");
	 phonenumber= sc.next();
	
	 m.createUser(firstname,lastname,username,password,email,phonenumber);
	 
//	 String sql= "insert into cmd"
//				+"(UserId,FirstName,LastName,username,email,password,phonennumber)"
//			    +"values('"+UserId+"','"+FirstName+"','"+LastName+"','"+username+"','"+email+"','"+p+"','"+PhoneNumber+"')";
	 
//	 j.createData(sql);
	
	}
	
	public void retrieve() throws SQLException{
		 
		 System.out.println("Enter UserId");
		 userid=sc.nextInt();            
		 
		 //String sql="select * from cmd where UserId='"+UserId+"'";
		
		 //ResultSet rs=j.retrieveData(sql);
		
	//	 if(rs.absolute(1)) 
		// {
			// System.out.println(rs.getString("UserId")+","+rs.getString("FirstName")+","+rs.getString("LastName")+","+rs.getString("username")+","+rs.getString("email")+","+crypt.encrypt(rs.getString("password"))+","+rs.getString("phonennumber"));
         //}
		 //else
		 //{
			// System.out.println("No user exists with userid"+UserId);	
		 //}
	
		 m.retrieveUser(userid);
}

	
	public void update() throws SQLException{
		String sql="";
	System.out.println("Enter the UserId");
	userid=sc.nextInt();
	
	m.updateUser(userid);
	/*
	int n;		
	System.out.println("Enter the option which you want to select");
	n=sc.nextInt();		
	
		switch(n)
		{
		case 1: 	 System.out.println("Enter Firstname:");
		 FirstName= sc.next();
         sql="UPDATE cmd SET FirstName ='"+FirstName+"' WHERE UserId='"+UserId+"'";
        break;
        
		case 2: 	 System.out.println("Enter Lastname:");
		 LastName= sc.next();
         sql="UPDATE cmd SET LastName='"+LastName+"' where UserId='"+UserId+"'";
        break;
        
		case 3: 	 System.out.println("Enter Username:");
		 username= sc.next();
         sql="UPDATE cmd SET username='"+username+"' where UserId='"+UserId+"'";
         break;
         
		case 4: 	 System.out.println("Enter email:");
		 email= sc.next();
         sql="UPDATE cmd SET email='"+email+"' where UserId='"+UserId+"'";
         break;
         
		 case 5: 	 System.out.println("Enter password:");
         
    	 password= sc.next();			        
         pass=password.toString();
         sql="UPDATE cmd SET password='"+pass+"' where UserId='"+UserId+"'";
         break;
         
		 case 6: 	 System.out.println("Enter phonenumber:");
         PhoneNumber= sc.next();
         sql="UPDATE cmd SET phonennumber='"+PhoneNumber+"' where UserId='"+UserId+"'";
         break;
         
		 default : System.out.println("Enter valid input:");
		}
		
		j.updateData(sql);
		
		*/
	}


public void delete() throws SQLException {
	 
	  System.out.println("Enter the UserId:");
	  userid=sc.nextInt();
	  m.deleteUser(userid);
	
	  
	  /* String sql1="select * from cmd where UserId='"+UserId+"'";
		 ResultSet rs=j.retrieveData(sql1);
		 if(rs.absolute(1))
		 {
			 	String sql="DELETE from cmd where UserId='"+UserId+"'";
			 	j.deleteData(sql);
		 }
		 else{
			 System.out.println("Invalid UserId"+UserId);
		 }
*/
}
	}
