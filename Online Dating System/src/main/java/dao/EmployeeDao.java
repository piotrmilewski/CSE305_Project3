package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.Employee;

public class EmployeeDao {
	/*
	 * This class handles all the database operations related to the employee table
	 */
	
	public String addEmployee(Employee employee) {

		/*
		 * All the values of the add employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database insertion of the employee details and return "success" or "failure" based on result of the database insertion.
		 */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("INSERT INTO Person VALUES('" + 
					employee.getEmployeeID() + "', '" + 
					employee.getPassword() + "', '" + 
					employee.getFirstName() + "', '" + 
					employee.getLastName() + "', '" + 
					employee.getAddress() + "', '" + 
					employee.getCity() + "', '" + 
					employee.getState() + "', " + 
					employee.getZipCode() + ", '" + 
					employee.getEmail() + "', '" + 
					employee.getTelephone() + "');");
			if (result1 != 1)
				return "failure";
			int result2 = st.executeUpdate("INSERT INTO Employee VALUES('" + 
					employee.getEmployeeID() + "', '" + 
					employee.getEmployeeRole() + "', '" + 
					employee.getStartDate() + "', " + 
					employee.getHourlyRate() + ");");
			if (result2 != 1) {
				st.executeUpdate("DELETE FROM Person WHERE SSN=" + employee.getEmployeeID() + ";");
				return "failure";
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return "success";
	}

	public String editEmployee(Employee employee) {
		/*
		 * All the values of the edit employee form are encapsulated in the employee object.
		 * These can be accessed by getter methods (see Employee class in model package).
		 * e.g. firstName can be accessed by employee.getFirstName() method.
		 * The sample code returns "success" by default.
		 * You need to handle the database update and return "success" or "failure" based on result of the database update.
		 */
		
		System.out.println(employee.getFirstName() + " " + employee.getEmployeeRole());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("UPDATE Person" + 
					" SET FirstName = '" + employee.getFirstName() + "'," +
					" LastName = '" + employee.getLastName() + "'," +
					" Street = '" + employee.getAddress() + "'," +
					" City = '" + employee.getCity() + "'," +
					" State = '" + employee.getState() + "'," +
					" Zipcode = " + employee.getZipCode() + "," +
					" Email = '" + employee.getEmail() + "'," +
					" Telephone = '" + employee.getTelephone() + "'" +
					" WHERE SSN = '" + employee.getEmployeeID() + "';");
			int result2 = st.executeUpdate("UPDATE Employee" +
					" SET Role = '" + employee.getEmployeeRole() + "'," +
					" StartDate = '" + employee.getStartDate() + "'," +
					" HourlyRate = " + employee.getHourlyRate() +
					" WHERE SSN = '" + employee.getEmployeeID() + "';");
		}  catch (Exception e) {
			System.out.println(e);
		}
		
		return "success";
	}

	public String deleteEmployee(String employeeID) {
		/*
		 * employeeID, which is the Employee's ID which has to be deleted, is given as method parameter
		 * The sample code returns "success" by default.
		 * You need to handle the database deletion and return "success" or "failure" based on result of the database deletion.
		 */
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("DELETE FROM Employee WHERE SSN = '" + employeeID + "';");
			int result2 = st.executeUpdate("DELETE FROM Person WHERE SSN = '" + employeeID + "';");
		}  catch (Exception e) {
			System.out.println(e);
		}
		
		return "success";
	}

	
	public List<Employee> getEmployees() {

		/*
		 * The students code to fetch data from the database will be written here
		 * Query to return details about all the employees must be implemented
		 * Each record is required to be encapsulated as a "Employee" class object and added to the "employees" List
		 */

		List<Employee> employees = new ArrayList<Employee>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Person P" + 
					" INNER JOIN Employee E on E.SSN = P.SSN;");
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmail(rs.getString("Email"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				System.out.println(rs.getString("Role"));
				employee.setEmployeeRole(rs.getString("Role"));
				employee.setAddress(rs.getString("Street"));
				employee.setCity(rs.getString("City"));
				employee.setStartDate(rs.getString("StartDate"));
				employee.setState(rs.getString("State"));
				employee.setZipCode(rs.getInt("Zipcode"));
				employee.setTelephone(rs.getString("Telephone"));
				employee.setEmployeeID(rs.getString("SSN"));
				employee.setHourlyRate(rs.getInt("HourlyRate"));
				employees.add(employee);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return employees;
	}

	public Employee getEmployee(String employeeID) {

		/*
		 * The students code to fetch data from the database based on "employeeID" will be written here
		 * employeeID, which is the Employee's ID who's details have to be fetched, is given as method parameter
		 * The record is required to be encapsulated as a "Employee" class object
		 */
		
		Employee employee = new Employee();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Person P" + 
					" INNER JOIN Employee E on E.SSN = P.SSN" +
					" WHERE P.SSN = '" + employeeID + "';");
			
			if (rs.first() == false)
				return employee;
			
			employee.setEmail(rs.getString("Email"));
			employee.setFirstName(rs.getString("FirstName"));
			employee.setLastName(rs.getString("LastName"));
			employee.setEmployeeRole(rs.getString("Role"));
			employee.setAddress(rs.getString("Street"));
			employee.setCity(rs.getString("City"));
			employee.setStartDate(rs.getString("StartDate"));
			employee.setState(rs.getString("State"));
			employee.setZipCode(rs.getInt("Zipcode"));
			employee.setTelephone(rs.getString("Telephone"));
			employee.setEmployeeID(rs.getString("SSN"));
			employee.setHourlyRate(rs.getInt("HourlyRate"));
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return employee;
	}
	
	public String getEmployeeID(String username) {
		/*
		 * The students code to fetch data from the database based on "username" will be written here
		 * username, which is the Employee's email address who's Employee ID has to be fetched, is given as method parameter
		 * The Employee ID is required to be returned as a String
		 */

		return "111-11-1111";
	}

}
