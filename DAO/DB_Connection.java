package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Connection
{
	      private String url = "";
	      private String user = "";
	      private String passwd = "";

	public void DB_Connection()
	
	{
	       url = "jdbc:mysql://localhost:3306/demo";
	       user = "root";
	       passwd = "";
	}
	
	public Statement get_connection()
	{
	
	try
	{
		  Class.forName("com.mysql.jdbc.Driver");
	      Connection conn = DriverManager.getConnection(url, user, passwd);
	      Statement stm = conn.createStatement();

			return stm;

	}
	catch (Exception e)
	{
			  System.out.println(e);
	}
	return null;
	}
}