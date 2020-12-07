package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Customer;

import java.util.stream.IntStream;

public class CustomerDao {
	/*
	 * This class handles all the database operations related to the customer table
	 */
	
	/**
	 * @return ArrayList<Customer> object
	 */
	public List<Customer> getCustomers() {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */
		
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT P.SSN, P.FirstName, P.LastName, P.Street, P.City, P.State, P.Zipcode, P.Email, P.Telephone, A.CardNumber, A.AcctNum, A.AcctCreationDate, U.PPP, U.Rating, U.DateOfLastAct" + 
					" FROM Person P" + 
					" INNER JOIN User U on U.SSN = P.SSN" + 
					" INNER JOIN Account A on A.OwnerSSN = P.SSN;");
			
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setUserID(rs.getString("SSN"));
				customer.setUserSSN(rs.getString("SSN"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setLastName(rs.getString("LastName"));
				customer.setAddress(rs.getString("Street"));
				customer.setCity(rs.getString("City"));
				customer.setState(rs.getString("State"));
				customer.setZipCode(rs.getInt("ZipCode"));
				customer.setTelephone(rs.getString("Telephone"));
				customer.setEmail(rs.getString("Email"));
				customer.setAccNum(rs.getString("AcctNum"));
				customer.setAccCreateDate(rs.getString("AcctCreationDate"));
				customer.setCreditCard(rs.getString("CardNumber"));
				customer.setPpp(rs.getString("PPP"));
				customer.setRating(rs.getInt("Rating"));
				customer.setDateLastActive(rs.getString("DateOfLastAct"));
				customers.add(customer);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */
		
		return customers;
	}

	public List<Customer> getCustomerMailingList() {

		/*
		 * This method fetches the all customer mailing details and returns it
		 * The students code to fetch data from the database will be written here
		 * Each customer record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		
		List<Customer> customers = new ArrayList<Customer>();
		
		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setAddress("123 Success Street");
			customer.setLastName("Lu");
			customer.setFirstName("Shiyong");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setZipCode(11790);
			customers.add(customer);			
		}
		/*Sample data ends*/
		
		return customers;
	}

	public Customer getCustomer(String customerID) {

		/*
		 * This method fetches the customer details and returns it
		 * customerID, which is the Customer's ID who's details have to be fetched, is given as method parameter
		 * The students code to fetch data from the database will be written here
		 * The customer record is required to be encapsulated as a "Customer" class object
		 */
		
		/*Sample data begins*/
		Customer customer = new Customer();
		customer.setUserID("111-11-1111");
		customer.setAddress("123 Success Street");
		customer.setLastName("Lu");
		customer.setFirstName("Shiyong");
		customer.setCity("Stony Brook");
		customer.setState("NY");
		customer.setEmail("shiyong@cs.sunysb.edu");
		customer.setZipCode(11790);
		customer.setTelephone("5166328959");
		customer.setCreditCard("1234567812345678");
		customer.setRating(1);
		/*Sample data ends*/
		
		return customer;
	}
	
	public String deleteCustomer(String customerID) {

		/*
		 * This method deletes a customer returns "success" string on success, else returns "failure"
		 * The students code to delete the data from the database will be written here
		 * customerID, which is the Customer's ID who's details have to be deleted, is given as method parameter
		 */

		/*Sample data begins*/
		return "success";
		/*Sample data ends*/
		
	}


	public String getCustomerID(String username) {
		/*
		 * This method returns the Customer's ID based on the provided email address
		 * The students code to fetch data from the database will be written here
		 * username, which is the email address of the customer, who's ID has to be returned, is given as method parameter
		 * The Customer's ID is required to be returned as a String
		 */

		return "111-11-1111";
	}


	public String addCustomer(Customer customer) {

		/*
		 * All the values of the add customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the customer details and return "success" or "failure" based on result of the database insertion.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}

	public String editCustomer(Customer customer) {
		/*
		 * All the values of the edit customer form are encapsulated in the customer object.
		 * These can be accessed by getter methods (see Customer class in model package).
		 * e.g. firstName can be accessed by customer.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		/*Sample data begins*/
		return "success";
		/*Sample data ends*/

	}



	public List<Customer> getMostActiveUser(){
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("DROP TABLE IF EXISTS temp;");
			int result2 = st.executeUpdate("CREATE TABLE temp AS" + 
					" SELECT FirstName, LastName, SSN, COUNT(Profile) AS NumberOfDates" + 
					" FROM (SELECT D1.Profile1 as Profile, Date_Time" + 
					"       FROM Date D1" + 
					"       UNION" + 
					"       SELECT D2.Profile2 as Profile, Date_Time" + 
					"       FROM Date D2) d" + 
					" INNER JOIN Profile p1 ON p1.ProfileID = d.Profile" + 
					" INNER JOIN Person p2 ON p1.OwnerSSN = p2.SSN" + 
					" GROUP BY SSN;");
			ResultSet rs = st.executeQuery("SELECT a.FirstName, a.LastName, a.SSN" + 
					" FROM temp a" + 
					" WHERE a.NumberOfDates = (SELECT MAX(b.NumberOfDates)" + 
					"                          FROM temp b);");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setUserID(rs.getString("SSN"));
				customer.setUserSSN(rs.getString("SSN"));
				customer.setAddress("null");
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity("null");
				customer.setState("null");
				customer.setEmail("null@null.com");
				customer.setZipCode(11111);
				customers.add(customer);
			}
			int result3 = st.executeUpdate("DROP TABLE temp;");
		} catch (Exception e) {
			System.out.println(e);
		}

		return customers;
	}

	public List<Customer> getDatedCustomers(String primary){

		List<Customer> customers = new ArrayList<Customer>();
		
		String[] tokens = primary.split(" ");
		if (tokens.length < 2)
			return customers;
		String firstName = tokens[0];
		String lastName = tokens[1];

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("DROP TABLE IF EXISTS temp;");
			int result2 = st.executeUpdate("CREATE TABLE temp AS" + 
					" SELECT pe1.SSN as SSN1, pe1.FirstName as FirstName1, pe1.LastName as LastName1, pe2.SSN as SSN2, pe2.FirstName as FirstName2, pe2.LastName as LastName2" + 
					" FROM Date d, Profile p1, Profile p2, Person pe1, Person pe2" + 
					" WHERE d.Profile1 = p1.ProfileID AND p1.OwnerSSN = pe1.SSN AND d.Profile2 = p2.ProfileID AND p2.OwnerSSN = pe2.SSN;");
			ResultSet rs = st.executeQuery("SELECT FirstName, LastName, SSN" + 
					" FROM (SELECT t1.FirstName1 as FirstName, t1.LastName1 as LastName, t1.SSN1 as SSN" + 
					"     FROM temp t1" + 
					"     WHERE t1.FirstName2 = '" + firstName + "' AND t1.LastName2 = '" + lastName + "'" + 
					"     UNION\r\n" + 
					"     SELECT t2.FirstName2 as FirstName, t2.LastName2 as LastName, t2.SSN2 as SSN" + 
					"     FROM temp t2" + 
					"     WHERE t2.FirstName1 = '" + firstName + "' AND t2.LastName1 = '" + lastName + "') d" +
					" ORDER BY SSN;");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setUserID(rs.getString("SSN"));
				customer.setUserSSN(rs.getString("SSN"));
				customer.setAddress("null");
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity("null");
				customer.setState("null");
				customer.setEmail("null@null.com");
				customer.setZipCode(11111);
				customers.add(customer);
			}
			int result3 = st.executeUpdate("DROP TABLE temp;");
		} catch (Exception e) {
			System.out.println(e);
		}

		return customers;
	}

	public List<Customer> getHighestRatedCustomer(){
		List<Customer> customers = new ArrayList<Customer>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT FirstName, LastName, p.SSN as SSN, u.Rating as Rating" + 
					" FROM User u" + 
					" INNER JOIN Person p ON p.SSN = u.SSN" + 
					" WHERE u.Rating = (SELECT MAX(u2.Rating)" + 
					"                   FROM sys.User u2);");
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setUserID(rs.getString("SSN"));
				customer.setUserSSN(rs.getString("SSN"));
				customer.setAddress("null");
				customer.setLastName(rs.getString("LastName"));
				customer.setFirstName(rs.getString("FirstName"));
				customer.setCity("null");
				customer.setState("null");
				customer.setEmail("null@null.com");
				customer.setZipCode(11111);
				customer.setRating(rs.getInt("Rating"));
				customers.add(customer);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return customers;
	}


	public List<Customer> getDateSuggestions(String userID) {
		/*
		 * This method fetches one or more customers and returns it as an ArrayList
		 */

		List<Customer> customers = new ArrayList<Customer>();

		/*
		 * The students code to fetch data from the database will be written here
		 * Each record is required to be encapsulated as a "Customer" class object and added to the "customers" List
		 */

		/*Sample data begins*/
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer();
			customer.setUserID("111-11-1111");
			customer.setFirstName("long");
			customer.setLastName("Lu");
			customer.setAddress("123 Success Street12");
			customer.setCity("Stony Brook");
			customer.setState("NY");
			customer.setZipCode(11790);
			customer.setTelephone("5166328959");
			customer.setEmail("shiyong@cs.sunysb.edu");
			customer.setAccNum("12345");
			customer.setAccCreateDate("12-12-2020");
			customer.setCreditCard("1234567812345678");
			customer.setPpp("User");
			customer.setRating(1);
			customer.setDateLastActive("12-12-2020");
			customers.add(customer);
		}
		/*Sample data ends*/

		return customers;
	}
	
	public List<String> getMaxRevenueCustomer() {
		
		List<String> customers = new ArrayList<String>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT FirstName, LastName, SUM(BookingFee) as TotalRevenue" + 
					" FROM (SELECT D1.Profile1 as Profile, D1.BookingFee" + 
					"     FROM Date D1" + 
					"     UNION" + 
					"     SELECT D2.Profile2 as Profile, D2.BookingFee" + 
					"     FROM Date D2) d" + 
					" INNER JOIN Profile p1 ON p1.ProfileID = d.Profile" + 
					" INNER JOIN Person p2 ON p1.OwnerSSN = p2.SSN" + 
					" GROUP BY OwnerSSN" + 
					" ORDER BY SUM(BookingFee) DESC" + 
					" LIMIT 1;");
			if (rs.first() == false)
				return customers;

			customers.add(rs.getString("FirstName") + " " + rs.getString("LastName"));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return customers;
	}
	
	public String getMaxRevenueAmount() {
		
		String amount = "";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT FirstName, LastName, SUM(BookingFee) as TotalRevenue" + 
					" FROM (SELECT D1.Profile1 as Profile, D1.BookingFee" + 
					"     FROM Date D1" + 
					"     UNION" + 
					"     SELECT D2.Profile2 as Profile, D2.BookingFee" + 
					"     FROM Date D2) d" + 
					" INNER JOIN Profile p1 ON p1.ProfileID = d.Profile" + 
					" INNER JOIN Person p2 ON p1.OwnerSSN = p2.SSN" + 
					" GROUP BY OwnerSSN" + 
					" ORDER BY SUM(BookingFee) DESC" + 
					" LIMIT 1;");
			if (rs.first() == false)
				return amount;

			amount = rs.getString("TotalRevenue");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return amount;
	}

}
