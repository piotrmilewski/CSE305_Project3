package dao;

import model.Customer;
import model.Likes;
import model.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LikesDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	public String setNewLike(String user1, String user2){
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			
			String statement = "INSERT INTO Likes VALUES('" + user1 + "', '" + user2 + "', NOW();";
			
			System.out.println(statement);
			int result = st.executeUpdate(statement);
			if (result != 1)
				return "failure";
		}	
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return "User - "+user1+" likes "+user2;
	}

	public List<String> getFavorites(String mw){

		/*Sample data begins*/
		List<String> favs = new ArrayList<>();
//		for (int i = 0; i < 10; i++)
//			favs.add("user123");
		/*Sample data ends*/
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * from likes WHERE Liker = '" + mw + "' ORDER BY Date_Time DESC;");
			
			while (rs.next()) {
				String fav = rs.getString("Likee");
				favs.add(fav);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		return favs;
	}

}
