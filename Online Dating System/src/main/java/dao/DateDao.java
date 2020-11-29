package dao;

import model.Date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DateDao {

    public String addDate(Date date) {
        return "Success";
    }


    public List<Date> getDatesByCalendar(String calendarDate) {
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Date" + 
					" WHERE date(Date_Time) = '" + calendarDate + "';");
			while (rs.next()) {
				Date date = new Date();
	            date.setDateID("1111111");
	            date.setUser1ID(rs.getString("Profile1"));
	            date.setUser2ID(rs.getString("Profile2"));
	            date.setDate(rs.getString("Date_Time"));
	            date.setGeolocation(rs.getString("Location"));
	            date.setBookingfee(rs.getString("BookingFee"));
	            date.setCustRepresentative(rs.getString("CustRep"));
	            date.setComments(rs.getString("Comments"));
	            date.setUser1Rating(rs.getString("User1Rating"));
	            date.setUser2Rating(rs.getString("User2Rating"));
	            dates.add(date);
			}
        } catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }

    public List<Date> getDatesByMonthYear(String month, String year) {
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Date" + 
					" WHERE year(Date_Time) = " + year + " AND month(Date_Time) = " + month + ";");
			int i = 0;
			while (rs.next()) {
	            Date date = new Date();
	            date.setDateID(Integer.toString(i));
	            date.setUser1ID(rs.getString("Profile1"));
	            date.setUser2ID(rs.getString("Profile2"));
	            date.setDate(rs.getString("Date_Time"));
	            date.setGeolocation(rs.getString("Location"));
	            date.setBookingfee(rs.getString("BookingFee"));
	            date.setCustRepresentative(rs.getString("CustRep"));
	            date.setComments(rs.getString("Comments"));
	            date.setUser1Rating(rs.getString("User1Rating"));
	            date.setUser2Rating(rs.getString("User2Rating"));
	            i++;
	            dates.add(date);
	        }
    	} catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }

    public List<Date> getDatesByCustomerName(String customerName) {

        List<Date> dates = new ArrayList<Date>();

        String[] tokens = customerName.split(" ");
		String firstName = tokens[0];
		String lastName = tokens[1];
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT *" + 
					" FROM Date d" + 
					" INNER JOIN Profile p1 ON p1.ProfileID = d.Profile1" + 
					" INNER JOIN Profile p2 ON p2.ProfileID = d.Profile2" + 
					" INNER JOIN Person pe1 ON p1.OwnerSSN = pe1.SSN" + 
					" INNER JOIN Person pe2 ON p2.OwnerSSN = pe2.SSN" + 
					" WHERE pe1.FirstName = '" + firstName + "' AND pe1.LastName = '" + lastName + "' OR pe2.FirstName = '" + firstName + "' AND pe2.LastName = '" + lastName + "';");
			while (rs.next()) {
				Date date = new Date();
	            date.setDateID("1111111");
	            date.setUser1ID(rs.getString("Profile1"));
	            date.setUser2ID(rs.getString("Profile2"));
	            date.setDate(rs.getString("Date_Time"));
	            date.setGeolocation(rs.getString("Location"));
	            date.setBookingfee(rs.getString("BookingFee"));
	            date.setCustRepresentative(rs.getString("CustRep"));
	            date.setComments(rs.getString("Comments"));
	            date.setUser1Rating(rs.getString("User1Rating"));
	            date.setUser2Rating(rs.getString("User2Rating"));
	            dates.add(date);
			}
        } catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }

    public List<Date> getHighestRatedCalendarDate() {
    	
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			int result1 = st.executeUpdate("DROP TABLE IF EXISTS temp;");
			int result2 = st.executeUpdate("CREATE TABLE temp AS" + 
					" SELECT Date, totalAVG" + 
					" FROM (SELECT DATE(Date_Time) AS Date, (AVG(User1Rating)+AVG(User2Rating))/2 AS totalAVG" + 
					"       FROM Date" + 
					"       GROUP BY DATE(Date_Time)) d;");
			ResultSet rs = st.executeQuery("SELECT a.Date, a.totalAvg" + 
					" FROM temp a" + 
					" WHERE a.totalAvg = (SELECT MAX(b.totalAvg)" + 
					" 				     FROM temp b);");
			while (rs.next()) {
				Date date = new Date();
	            date.setDateID("12313123");
	            date.setUser1ID("1212");
	            date.setUser2ID("2121");
	            date.setDate(rs.getString("Date"));
	            date.setGeolocation("location");
	            date.setBookingfee("21");
	            date.setCustRepresentative("Manoj Pandey");
	            date.setComments("Comments");
	            date.setUser1Rating(rs.getString("totalAvg"));
	            date.setUser2Rating(rs.getString("totalAvg"));
	            dates.add(date);
			}
        } catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }


    public List<Date> getOpenDates() {

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID("12313123");
            date.setUser1ID("1212");
            date.setUser2ID("2121");
            date.setDate("12-12-2020");
            date.setGeolocation("location");
            date.setBookingfee("21");
            date.setCustRepresentative("Manoj Pandey");
            date.setComments("Comments");
            date.setUser1Rating("3");
            date.setUser2Rating("3");
            dates.add(date);
        }
        /*Sample data ends*/

        return dates;
    }

    public String setNewDate(String user1, String user2) {
        return "Successfull date b/w " + user1 + " and " + user2;
    }

    public String cancelDate(String dateID) {
        return "Date - " + dateID + " is now cancelled";
    }

    public String commentDate(String dateID, String comment) {
        return "Date - " + dateID + " has new comment - " + comment;
    }

    public String getSalesReport(String month, String year) {
    	String retVal = "0";
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT month(Date_Time) as Month, year(Date_Time) as Year, sum(BookingFee) AS Revenue, count(*) as Number_Of_Dates" + 
					" FROM Date" + 
					" WHERE month(Date_Time) = " + month + " AND year(Date_Time) = " + year + 
					" GROUP BY month(Date_Time), year(Date_Time);");
			if (rs.first() == false)
				return retVal;
			int val = (int)Math.round(rs.getDouble("Revenue"));
			retVal = Integer.toString(val);
    	} catch (Exception e) {
			System.out.println(e);
		}
        return retVal;
    }

    public List<Date> getPendingDates(String user) {

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID("12313123");
            date.setUser1ID("1212");
            date.setUser2ID("2121");
            date.setDate("12-12-2020");
            date.setGeolocation("location");
            date.setBookingfee("21");
            date.setCustRepresentative("Manoj Pandey");
            date.setComments("Comments");
            date.setUser1Rating("3");
            date.setUser2Rating("3");
            dates.add(date);
        }
        /*Sample data ends*/

        return dates;
    }

    public List<Date> getPastDates(String user) {

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID("12313123");
            date.setUser1ID("1212");
            date.setUser2ID("2121");
            date.setDate("12-12-2020");
            date.setGeolocation("location");
            date.setBookingfee("21");
            date.setCustRepresentative("Manoj Pandey");
            date.setComments("Comments");
            date.setUser1Rating("3");
            date.setUser2Rating("3");
            dates.add(date);
        }
        /*Sample data ends*/

        return dates;
    }


    public String getMostPopularLocation(String user) {
        return "Jersey City";
    }


    public List<Date> getDateSuggestions(String user) {

        List<Date> dates = new ArrayList<Date>();

        /*Sample data begins*/
        for (int i = 0; i < 10; i++) {
            Date date = new Date();
            date.setDateID("12313123");
            date.setUser1ID("1212");
            date.setUser2ID("2121");
            date.setDate("12-12-2020");
            date.setGeolocation("location");
            date.setBookingfee("21");
            date.setCustRepresentative("Manoj Pandey");
            date.setComments("Comments");
            date.setUser1Rating("3");
            date.setUser2Rating("3");
            dates.add(date);
        }
        /*Sample data ends*/

        return dates;
    }

    public List<Date> getRevenueByCalendar(String calendarDate) {
        List<Date> dates = new ArrayList<Date>();

        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT DATE(Date_Time) as Date, SUM(BookingFee) as Revenue" + 
					" FROM Date" + 
					" WHERE DATE(Date_Time) = '" + calendarDate + "'" + 
					" GROUP BY DATE(Date_Time);");
			while (rs.next()) {
				Date date = new Date();
	            date.setDateID(rs.getString("Revenue"));
	            date.setDate(rs.getString("Date"));
	            dates.add(date);
			}
        } catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }
    
    public List<Date> getRevenueByCustomer(String customerName) {
        List<Date> dates = new ArrayList<Date>();

        String[] tokens = customerName.split(" ");
		String firstName = tokens[0];
		String lastName = tokens[1];
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT '" + firstName + "' as FirstName, '" + lastName + "' as LastName, SUM(BookingFee) as Revenue" + 
					" FROM Date d" + 
					" INNER JOIN Profile p1 ON p1.ProfileID = d.Profile1" + 
					" INNER JOIN Profile p2 ON p2.ProfileID = d.Profile2" + 
					" INNER JOIN Person pe1 ON p1.OwnerSSN = pe1.SSN" + 
					" INNER JOIN Person pe2 ON p2.OwnerSSN = pe2.SSN" + 
					" WHERE pe1.FirstName = '" + firstName + "' AND pe1.LastName = '" + lastName + "' OR pe2.FirstName = '" + firstName + "' AND pe2.LastName = '" + lastName + "';");
			while (rs.next()) {
				Date date = new Date();
	            date.setDateID(rs.getString("Revenue"));
	            date.setUser1ID(rs.getString("LastName"));
	            date.setUser2ID(rs.getString("FirstName"));
	            dates.add(date);
			}
        } catch (Exception e) {
			System.out.println(e);
		}

        return dates;
    }
}
