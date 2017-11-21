
import java.sql.*;
import java.util.Scanner;

public class MyJDBC {

	public static void main(String[] args)
    {
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/practice","root","07/35452");
		Scanner d=new Scanner(System.in);
		PreparedStatement st;
		String sqlcmd;
	    String empname;
	    int id;
	    float sal;
	    String desig;
	    String ans;
	    do
	    {
	    System.out.println("1. See data");
	    System.out.println("2. Create data");
	    System.out.println("Enter choice: ");
	    int check=d.nextInt();
	    switch(check)
	    {
	    case 1:
	    	sqlcmd="select * from empdetail";
	    	st=con.prepareStatement(sqlcmd);
	    	ResultSet rs=st.executeQuery();
	    	while(rs.next())
	    	{
	    		System.out.println(rs.getString(1)+" "+rs.getInt(2)+" "+rs.getFloat(3)+" "+rs.getString(4)+"\n");
	    	}
	    	break;
	    	
	    case 2:
			sqlcmd="insert into empdetail values(?,?,?,?)";
			st=con.prepareStatement(sqlcmd);
			System.out.println("Enter Employee name: ");
			empname=d.next();
			System.out.println("Enter the Employee id: ");
			id=d.nextInt();
			System.out.println("Enter the Employee salary: ");
			sal=d.nextFloat();
			System.out.println("Enter the Employee designation: ");
			desig=d.next();			
			
			st.setString(1,empname);
			st.setInt(2,id);
			st.setFloat(3,sal);
			st.setString(4,desig);
			int i=st.executeUpdate();
			if(i==1)
				System.out.println("Positively updated");
			else 
				System.out.println("Try again");
			break;
default:
	System.out.println("Wrong Choice....!! ");
	System.exit(0);
	break;
	    }
	System.out.println("Want to continue (y/n): ");
	ans=d.next();
	if(ans.startsWith("n"))
	{
		break;
	}
		
		}while(true);
		d.close();	    
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }

	}

