package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ReferralDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	public String referProfile(String profileA, String profileB, String profileC){
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			
			String statement = "INSERT INTO Blinddate "
					+ "VALUES('" + profileA + "', '" + profileB + "', '" + profileC + "', NOW());";
	
			System.out.println(statement);
			int result = st.executeUpdate(statement);
			if (result != 1)
				return "failure";
		}	
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return profileA +" has referred " + profileB + "  to " + profileC;
	}
}
