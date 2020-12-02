package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Login;

public class LoginDao {
	/*
	 * This class handles all the database operations related to login functionality
	 */
	
	
	public Login login(String username, String password) {
		/*
		 * Return a Login object with role as "manager", "customerRepresentative" or "customer" if successful login
		 * Else, return null
		 * The role depends on the type of the user, which has to be handled in the database
		 * username, which is the email address of the user, is given as method parameter
		 * password, which is the password of the user, is given as method parameter
		 * Query to verify the username and password and fetch the role of the user, must be implemented
		 */
		
		Login login = new Login();
		String role = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Person p" + 
					" LEFT OUTER JOIN Employee e ON e.SSN = p.SSN" + 
					" LEFT OUTER JOIN User u ON u.SSN = p.SSN" + 
					" WHERE p.Email = '" + username + "' AND p.Password = '" + password + "';");
			if (rs.first() == false)
				return null;
			role = rs.getString("Role");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if (role.equals("Manager"))
			login.setRole("manager");
		else if (role.equals("CustRep"))
			login.setRole("customerRepresentative");
		else
			login.setRole("customer");

		return login;
	}
	
	public String addUser(Login login) {
		/*
		 * Query to insert a new record for user login must be implemented
		 * login, which is the "Login" Class object containing username and password for the new user, is given as method parameter
		 * The username and password from login can get accessed using getter methods in the "Login" model
		 * e.g. getUsername() method will return the username encapsulated in login object
		 * Return "success" on successful insertion of a new user
		 * Return "failure" for an unsuccessful database operation
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
	}

}
