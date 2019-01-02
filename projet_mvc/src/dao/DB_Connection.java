package dao;

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
	       
	}
	
	public Statement get_connection()
	{
	
		try
		{
			url = "jdbc:mysql://localhost:3306/musicos";
			user = "root";
			passwd = "";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, passwd);
			Statement stm = conn.createStatement();
	      	return stm;

		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println(e.getMessage());
			System.out.println(e.getClass());
		}
		return null;
	}
}