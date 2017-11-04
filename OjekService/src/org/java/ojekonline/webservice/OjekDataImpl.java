package org.java.ojekonline.webservice;
import javax.jws.WebService;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.mysql.jdbc.Statement;

@WebService(endpointInterface="org.java.ojekonline.webservice.OjekData")
public class OjekDataImpl implements OjekData{
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/ojekonline";
	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	Statement stmt = null;
    Connection conn = null;
    ResultSet rs = null;
		
	@Override
	public Boolean validateToken(String token) {
		return true;
	}
	
	void execute(String query, int code) {
		// code 1 : select
		// code 2 : insert
		// code 3 : update
		// code 4 : delete
		//Connect to database
	    try {
	    	// Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	          
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	          
	        stmt = (Statement) conn.createStatement();
	        
	        //Validate token
	        switch(code) {
	        	case 1: rs =stmt.executeQuery(query);
	        			break;
	        	default:stmt.executeUpdate(query);
	        			break;
	        }
	    } 
	    catch(SQLException se) {
	    	//Handle errors for JDBC
	    	se.printStackTrace();
	    } 
	    catch(Exception e) {
	      	//Handle errors for Class.forName
	      	e.printStackTrace();
	    } 
	}

	@Override
	public Babi findDriver(int id_user, String pick, String dest) {
	    ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = 
					"SELECT DISTINCT name, prof_pic, avgrating, "
					+ "id_driver, num_votes FROM driver NATURAL JOIN pref_location "
					+ "join user WHERE id_user <> "+ Integer.toString(id_user) +" AND id_user = id_driver AND" + 
					"( '" + pick + "' = location OR '" +  dest + "' = location)";
			execute(query, 1);
			while (rs.next()) {
				System.out.println(rs.getString("name"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("name", rs.getString("name"));
				temp.put("prof_pic", rs.getString("prof_pic"));
				temp.put("avgrating", Float.toString(rs.getFloat("avgrating")));
				temp.put("id_driver", Integer.toString(rs.getInt("id_driver")));
				temp.put("num_votes", Integer.toString(rs.getInt("num_votes")));
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("asem");
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}

	@Override
	public String getNameUser(int id_user) {
		String query = "SELECT name FROM user WHERE id_user = " + Integer.toString(id_user);
		execute(query, 1);
		String result = null;

		try {
			if (rs.next())
				result = rs.getString("name");
			
			System.out.println(rs.getString("name"));
			
			stmt.close();
	        conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
        
		if (result == null)
			return "asu";
		else
			return result;
	}

	@Override
	public Babi findPrefDriver(int id_user, String name) {
		ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = 
					"SELECT DISTINCT name, prof_pic, avgrating, "
					+ "id_driver, num_votes FROM driver "
					+ "join user WHERE id_user <> "+ Integer.toString(id_user) +" AND id_user = id_driver AND" + 
					" name = '" + name + "'";
			execute(query, 1);
			if (rs.next()) {
				System.out.println(rs.getString("name"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("name", rs.getString("name"));
				temp.put("prof_pic", rs.getString("prof_pic"));
				temp.put("avgrating", Float.toString(rs.getFloat("avgrating")));
				temp.put("id_driver", Integer.toString(rs.getInt("id_driver")));
				temp.put("num_votes", Integer.toString(rs.getInt("num_votes")));
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("asem");
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}

	@Override
	public Babi getProfile(int id_user) {
		ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = 
					"SELECT * FROM user WHERE id_user = " + Integer.toString(id_user);
			execute(query, 1);
			if (rs.next()) {
				System.out.println(rs.getString("name"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("name", rs.getString("name"));
				temp.put("prof_pic", rs.getString("prof_pic"));
				temp.put("username", rs.getString("username"));
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("asem");
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}
	
	
	
	

}
