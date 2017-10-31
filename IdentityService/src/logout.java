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

/**
 * Servlet implementation class logout
 */
@WebServlet("/logout")
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/ojekaccount";

	//  Database credentials
	static final String USER = "root";
	static final String PASS = "";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		try {
		  BufferedReader reader = request.getReader();
		  while ((line = reader.readLine()) != null)
		    jb.append(line);
		} catch (Exception e) { /*report an error*/ }
		
		String jsonData = jb.toString();
		PrintWriter out = response.getWriter();
		try {
			JSONObject jsonObject = new JSONObject(jsonData); // put "String"
			String key = jsonObject.getString("token");
			out.println(key);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
