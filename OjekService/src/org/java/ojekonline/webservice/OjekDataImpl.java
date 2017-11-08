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
		
			stmt.close();
	        conn.close();
		} catch (SQLException e) {
		} 
        
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
	public Babi getProfile(int id_user, int driverstatus) {
		ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = null;
			if (driverstatus == 0) {
				query = "SELECT * FROM user WHERE id_user = " + Integer.toString(id_user);
			}
			else {
				query = "SELECT * FROM user join driver WHERE id_user = id_driver "
						+ "AND id_user = " + Integer.toString(id_user);
			}
			execute(query, 1);
			if (rs.next()) {
				System.out.println(rs.getString("name"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("name", rs.getString("name"));
				temp.put("prof_pic", rs.getString("prof_pic"));
				temp.put("username", rs.getString("username"));
				if (driverstatus == 1) {
					temp.put("avgrating", Float.toString(rs.getFloat("avgrating")));
					temp.put("num_votes", Integer.toString(rs.getInt("num_votes")));
				}
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}

	@Override
	public void insertOrder(int id_driver, int id_user, String tgl, String pick, String dest, int rate,
			String comment) {
		try {
			String query = 
					"INSERT INTO order_data(id_driver, id_user, date_order, origin, destination, rating, comment) " 
					+ "VALUES ("+ Integer.toString(id_driver) +", "+ Integer.toString(id_user) +", '"
					+ tgl +"', '"+ pick +"', '"+ dest +"', " 
					+ Integer.toString(rate) + ", '"+ comment +"')";
			execute(query, 2);
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	@Override
	public void updateDriver(int id_driver, int num_votes, float avgrating) {
		try {
			String query = 
					"UPDATE driver SET avgrating = "+ Float.toString(avgrating) +", "
							+ "num_votes = "+ Integer.toString(num_votes) +" "
							+ "WHERE id_driver = "+ Integer.toString(id_driver);
			execute(query, 3);
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}

	@Override
	public void insertHistory(int id_user, int id_driver, String tgl, String nameuser, String namedriver, String pick,
			String dest, int rate, String comment, int hide, int driverstatus) {
		try {
			String query = null;
			if (driverstatus == 0) { //userhistory
				query = 
						"INSERT INTO user_history(id_user, id_driver, date_order, customer_name, "
						+ "origin, destination, rating, comment, hide) " 
						+ "VALUES ("+ Integer.toString(id_user) +", "+ Integer.toString(id_driver) +", '"
						+ tgl + "', '"+ namedriver +"' , '"+ pick +"', '"+ dest +"', " 
						+ Integer.toString(rate) + ", '"+ comment +"' , 0)";
			}
			else { //driverhistory
				query = 
						"INSERT INTO driver_history(id_driver, id_user, date_order, customer_name, "
						+ "origin, destination, rating, comment, hide) " 
						+ "VALUES ("+ Integer.toString(id_driver) +", "+ Integer.toString(id_user) +", '"
						+ tgl + "', '"+ nameuser +"' , '"+ pick +"', '"+ dest +"', " 
						+ Integer.toString(rate) + ", '"+ comment +"' , 0)";
			}
			
			execute(query, 2);
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		
	}
	
	@Override
	public Babi getUserHistory(int id_user) {
		ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = null;
			query = "SELECT * FROM user_history WHERE id_user = " + Integer.toString(id_user) + " and hide = 0";
			System.out.println(query);
			execute(query, 1);
			while (rs.next()) {
				System.out.println(rs.getString("comment"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("id_history", Integer.toString(rs.getInt("id_history")));
				temp.put("id_user", Integer.toString(rs.getInt("id_user")));
				temp.put("id_driver", Integer.toString(rs.getInt("id_driver")));
				temp.put("date_order", rs.getString("date_order"));
				temp.put("customer_name", rs.getString("customer_name"));
				temp.put("origin", rs.getString("origin"));
				temp.put("destination", rs.getString("destination"));
				temp.put("rating", Integer.toString(rs.getInt("rating")));
				temp.put("comment", rs.getString("comment"));
				temp.put("hide", Integer.toString(rs.getInt("hide")));
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}
	
	@Override
	public Babi getDriverHistory(int id_driver) {
		ArrayList<Map<String, String>> smth = new ArrayList<Map<String, String>>();
		try {
			String query = null;
			query = "SELECT * FROM driver_history WHERE id_driver = " + Integer.toString(id_driver) + " and hide = 0";
			System.out.println(query);
			execute(query, 1);
			while (rs.next()) {
				System.out.println(rs.getString("comment"));
				Map<String, String> temp = new HashMap<String, String>();
				temp.put("id_history", Integer.toString(rs.getInt("id_history")));
				temp.put("id_user", Integer.toString(rs.getInt("id_user")));
				temp.put("id_driver", Integer.toString(rs.getInt("id_driver")));
				temp.put("date_order", rs.getString("date_order"));
				temp.put("customer_name", rs.getString("customer_name"));
				temp.put("origin", rs.getString("origin"));
				temp.put("destination", rs.getString("destination"));
				temp.put("rating", Integer.toString(rs.getInt("rating")));
				temp.put("comment", rs.getString("comment"));
				temp.put("hide", Integer.toString(rs.getInt("hide")));
				smth.add(temp);
			}
			
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	
		Babi kampret = new Babi();
		kampret.setResults(smth);
		
		return kampret;
	}
	
	public void hideUserHistory(int id_history) {
		try {
			String query = "UPDATE user_history SET hide=1 WHERE id_history =" + Integer.toString(id_history);
			execute(query, 3);
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void hideDriverHistory(int id_history) {
		try {
			String query = "UPDATE driver_history SET hide=1 WHERE id_history =" + Integer.toString(id_history);
			execute(query, 3);
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public void Register(String name, String email, String phone_number, String driver_status) {
		try {
			String query = ("INSERT INTO user (name, email, phone_number, driver_status) VALUES ('"+name+"','"+email+"','"+phone_number+"','"+driver_status+"')");
			execute(query, 2);
			 stmt.close();
		     conn.close();
		} catch (SQLException e) {
				e.printStackTrace();
		}
	}
	
	public String getPicture(int id_user) {
		String query = "SELECT prof_pic FROM user WHERE id_user = " + Integer.toString(id_user);
		execute(query, 1);
		String result = null;

		try {
			if (rs.next())
				result = rs.getString("prof_pic");
		
			stmt.close();
	        conn.close();
		} catch (SQLException e) {
		} 
        
		return result;
	}
}
