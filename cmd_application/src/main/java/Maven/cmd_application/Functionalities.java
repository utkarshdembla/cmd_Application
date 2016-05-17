package Maven.cmd_application;

import java.util.*;

import com.eric.test.app.utilities.JDBC_utilities;

import java.sql.*;

public class Functionalities{
	
		JDBC_utilities j=new JDBC_utilities();
		Scanner sc= new Scanner(System.in);
		int UserId;
	    String FirstName;
	    String LastName;
	    String username;
	    String email;
	    long PhoneNumber;
	    char[] password= new char[20];
	    String pass="\n";
	    char input='\n';
	  
	public void create() throws SQLException
	{  
	 System.out.println("Enter UserId:");
   	 UserId= sc.nextInt();
   	 	
   	 System.out.println("Enter Firstname:");
	 FirstName= sc.next();
	 
	 System.out.println("Enter LastName:");
	 LastName= sc.next();
	 
	 System.out.println("Enter username:");
	 username= sc.next();
	 
	 System.out.println("Enter Password:");
	 password= sc.next().toCharArray();			
	
	 pass=password.toString();
	
	 System.out.println("Enter email:");
	 email= sc.next();
	 
	 System.out.println("Enter phonenumber");
	 PhoneNumber= sc.nextLong();
	
	 String sql= "insert into cmd"
				+"(UserId,FirstName,LastName,username,email,password,phonennumber)"
			    +"values('"+UserId+"','"+FirstName+"','"+LastName+"','"+username+"','"+email+"','"+pass+"','"+PhoneNumber+"')";
	 
	 j.createData(sql);
	
	}
	
	public void retrieve() throws SQLException{
		 
		 System.out.println("Enter UserId");
		 UserId=sc.nextInt();            
		 
		 String sql="select * from cmd where UserId='"+UserId+"'";
		 ResultSet rs=j.retrieveData(sql);
		 
		 if(rs.absolute(1)) 
		 {
			 System.out.println(rs.getString("UserId")+","+rs.getString("FirstName")+","+rs.getString("LastName")+","+rs.getString("username")+","+rs.getString("email")+","+rs.getString("password")+","+rs.getString("phonennumber"));
         }
		 else
		 {
			 System.out.println("No user exists with userid"+UserId);	
		 }
	
}

	
	public void update() throws SQLException{
		String sql="";
	System.out.println("Enter the UserId");
	UserId=sc.nextInt();
	
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
         password= sc.next().toCharArray();	        
         pass=password.toString();
         sql="UPDATE cmd SET password='"+pass+"' where UserId='"+UserId+"'";
         break;
         
		 case 6: 	 System.out.println("Enter phonenumber:");
         PhoneNumber= sc.nextLong();
         sql="UPDATE cmd SET phonennumber='"+PhoneNumber+"' where UserId='"+UserId+"'";
         break;
         
		 default : System.out.println("Enter valid input:");
		}
		
		j.updateData(sql);
	}


public void delete() throws SQLException {
	 
	  System.out.println("Enter the UserId:");
	  UserId=sc.nextInt();
	  String sql1="select * from cmd where UserId='"+UserId+"'";
		 ResultSet rs=j.retrieveData(sql1);
		 if(rs.absolute(1))
		 {
			 	String sql="DELETE from cmd where UserId='"+UserId+"'";
			 	j.deleteData(sql);
		 }
		 else{
			 System.out.println("Invalid UserId"+UserId);
		 }
}
	}
