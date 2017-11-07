import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import java.sql.*;
import com.mysql.jdbc.Statement;
import java.util.UUID;

/**
 * Servlet implementation class logout
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/ojekaccount";
	static final String DB_URL1 = "jdbc:mysql://localhost:3306/ojekonline";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		String fullname = null;
		String username = null;
		String email = null;
		String password = null;
		String phonenumber = null;
		String driverstatus = null;
		
		//Read body
		try {
		  BufferedReader reader = request.getReader();
		  while ((line = reader.readLine()) != null)
		    jb.append(line);
		} catch (Exception e) { /*report an error*/ }
		
		//Parse string JSON
		String jsonData = jb.toString();
		PrintWriter out = response.getWriter();
		try {
			JSONObject jsonObject = new JSONObject(jsonData); // put "String"
			fullname = jsonObject.getString("fullname");
			username = jsonObject.getString("username");
			email = jsonObject.getString("email");
			password = jsonObject.getString("password");
			phonenumber = jsonObject.getString("phonenumber");
			driverstatus = jsonObject.getString("driverstatus");			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//Connect to database
	    Statement stmt = null;
	    Statement stmt1 = null;
	    Connection conn = null;
	    Connection conn1 = null;
	    request.setAttribute("message", "sukses");
	    try {
	    	// Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	          
	      	// Open a connection
	        out.println("try to connect");
	        conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        conn1 = DriverManager.getConnection(DB_URL1, USER, PASS);
	        
	        out.println("success");
	          
	        stmt = (Statement) conn.createStatement();
	        stmt1 = (Statement) conn1.createStatement();
	        
			ResultSet rs = stmt.executeQuery("select id_user from userdata where username='"+username+"' or email='"+email+"'");
		    if(rs.next()) {
		    	out.println("Username or Email unavailable");
		    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	        	response.addHeader("message", "not valid");
	        	return;
		    }
		    out.println("welcome "+fullname);
	    	stmt.executeUpdate("INSERT INTO userdata (name, username, email, password, phone_number, driver_status) VALUES ('"+fullname+"','"+username+"', '"+email+"','"+password+"', '"+phonenumber+"', '"+driverstatus+"')");
	    	UUID uuid = UUID.randomUUID();
	        String usertoken = uuid.toString().replace("-", "");
	        // Execute Insert Query
	        rs =stmt.executeQuery("SELECT id_user FROM userdata WHERE username = '" + username + "'");
	        if (rs.next()) {
	        	int id = rs.getInt("id_user");
	        	out.println("insert token");
	        	stmt.executeUpdate("INSERT INTO accesstoken VALUES (" + id + ",'" + usertoken + "', '2020-10-10')");
	        	stmt1.executeUpdate("INSERT INTO driver VALUES (" + id + ", 0, 0)");
		        out.println("insert database driver");
	        }
	        response.setStatus(HttpServletResponse.SC_OK );
	        response.addHeader("message", "ok");
	        stmt.close();
	        conn.close();
	        stmt1.close();
	        conn1.close();
	    } 
	    catch(SQLException se) {
	    	//Handle errors for JDBC
	    	response.setStatus(HttpServletResponse.SC_BAD_REQUEST );
	    	se.printStackTrace();
	    } 
	    catch(Exception e) {
	      	//Handle errors for Class.forName
	      	e.printStackTrace();
	    } 
	    finally {
	    	//finally block used to close resources
	        try {
	           if(stmt!=null)
	              stmt.close();
	        } catch(SQLException se2) {
	        } // nothing we can do
	        try {
	           if(conn!=null)
	        	   conn.close();
	        } catch(SQLException se) {
	             se.printStackTrace();
	        } //end finally try
	    }
	}

}
