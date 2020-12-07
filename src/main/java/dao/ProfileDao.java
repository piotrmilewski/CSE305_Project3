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
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

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
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByWeight(String weight) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByHeight(String height) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

    public List<Profile> getProfilesByHairColor(String hairColor) {

        /*Sample data begins*/
        List<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Profile profile = new Profile();
            profile.setProfileID("123");
            profile.setProfileName("Profile1");
            profile.setAge("23");
            profile.setAddress("address 11");
            profile.setGender("Male");
            profile.setPhy_char("Tall");
            profile.setInterests("Guitar");
            profile.setPhoto("Path to Photo");
            profile.setGeoRange("25");
            profile.setAgeRange("25 to 51");
            profiles.add(profile);
        }
        /*Sample data ends*/

        return profiles;
    }

}
