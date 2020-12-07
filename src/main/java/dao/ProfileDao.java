package dao;

import model.Customer;
import model.Profile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfileDao {
    /*
     * This class handles all the database operations related to the customer table
     */

    public List<Profile> getProfiles() {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
       
        /*Sample data ends*/
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Profile;");
			while (rs.next()) {
				Profile profile = new Profile();
	            profile.setProfileID(rs.getString("OwnderSSN"));
	            profile.setProfileName(rs.getString("ProfileID"));
	            profile.setAge(rs.getString("Age"));
	            profile.setGender(rs.getString("M_F"));
	            profile.setInterests(rs.getString("Hobbies"));
	            profile.setGeoRange(rs.getString("DatingGeoRange"));
	            profile.setAgeRange(rs.getString("DatingAgeRangeStart") + " to " + rs.getString("DatingAgeRangeEnd"));
	            profiles.add(profile);
			}
		} 
   	 	catch (Exception e){
			System.out.println(e);
   	 	}
        return profiles;
    }

    public List<Profile> getHighestRatedProfile()
    {
    	 List<Profile> profiles = new ArrayList<>();
    	 
    	 try 
    	 {
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
 			Statement st = con.createStatement();
 			ResultSet rs = st.executeQuery("SELECT ProfileID, Rating" + 
 					" FROM Profile P" + 
 					" (SELECT SSN, Rating FROM User) As ratings WHERE (ratings.SSN = P.OwnerSSN) ORDER BY rating DESC;");
 			while (rs.next())
 			{
 				Profile profile = new Profile();
 				profile.setProfileID(rs.getString("ProfileID"));
 				profiles.add(profile);
 			}
 		} 
    	 catch (Exception e)
    	 {
 			System.out.println(e);
 		 }
    	 return profiles;
    }
    
    public List<Profile> getProfilesByAge(String age) {
        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        /*Sample data ends*/
       
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Profile WHERE Age = " + Integer.parseInt(age) + ";");
			while (rs.next()) {
				Profile profile = new Profile();
	            profile.setProfileID(rs.getString("OwnderSSN"));
	            profile.setProfileName(rs.getString("ProfileID"));
	            profile.setAge(rs.getString("Age"));
	            profile.setGender(rs.getString("M_F"));
	            profile.setInterests(rs.getString("Hobbies"));
	            profile.setGeoRange(rs.getString("DatingGeoRange"));
	            profile.setAgeRange(rs.getString("DatingAgeRangeStart") + " to " + rs.getString("DatingAgeRangeEnd"));
	            profiles.add(profile);
			}
		} 
   	 	catch (Exception e){
			System.out.println(e);
   	 	}

        return profiles;
    }

    public List<Profile> getProfilesByWeight(String weight) {
        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        /*Sample data ends*/
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Profile WHERE Weight = " + Integer.parseInt(weight) + ";");
			while (rs.next()) {
				Profile profile = new Profile();
	            profile.setProfileID(rs.getString("OwnderSSN"));
	            profile.setProfileName(rs.getString("ProfileID"));
	            profile.setAge(rs.getString("Age"));
	            profile.setGender(rs.getString("M_F"));
	            profile.setInterests(rs.getString("Hobbies"));
	            profile.setGeoRange(rs.getString("DatingGeoRange"));
	            profile.setAgeRange(rs.getString("DatingAgeRangeStart") + " to " + rs.getString("DatingAgeRangeEnd"));
	            profiles.add(profile);
			}
		} 
   	 	catch (Exception e){
			System.out.println(e);
   	 	}

        return profiles;
    }

    public List<Profile> getProfilesByHeight(String height) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        
        /*Sample data ends*/
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Profile WHERE Height = " + Integer.parseInt(height) + ";");
			while (rs.next()) {
				Profile profile = new Profile();
	            profile.setProfileID(rs.getString("OwnderSSN"));
	            profile.setProfileName(rs.getString("ProfileID"));
	            profile.setAge(rs.getString("Age"));
	            profile.setGender(rs.getString("M_F"));
	            profile.setInterests(rs.getString("Hobbies"));
	            profile.setGeoRange(rs.getString("DatingGeoRange"));
	            profile.setAgeRange(rs.getString("DatingAgeRangeStart") + " to " + rs.getString("DatingAgeRangeEnd"));
	            profiles.add(profile);
			}
		} 
   	 	catch (Exception e){
			System.out.println(e);
   	 	}
        return profiles;
    }

    public List<Profile> getProfilesByHairColor(String hairColor) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
       
        /*Sample data ends*/
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sys", "admin", "password");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Profile WHERE HairColor = '" + hairColor + "';");
			while (rs.next()) {
				Profile profile = new Profile();
	            profile.setProfileID(rs.getString("OwnderSSN"));
	            profile.setProfileName(rs.getString("ProfileID"));
	            profile.setAge(rs.getString("Age"));
	            profile.setGender(rs.getString("M_F"));
	            profile.setInterests(rs.getString("Hobbies"));
	            profile.setGeoRange(rs.getString("DatingGeoRange"));
	            profile.setAgeRange(rs.getString("DatingAgeRangeStart") + " to " + rs.getString("DatingAgeRangeEnd"));
	            profiles.add(profile);
			}
		} 
   	 	catch (Exception e){
			System.out.println(e);
   	 	}
        return profiles;
    }

}
