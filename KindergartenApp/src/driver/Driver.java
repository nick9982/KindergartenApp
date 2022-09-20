package driver;

import interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {
	public static void main(String[]args)
	{
		String user = args[0];
		String pwd = args[1];
		try {
			String url = "jdbc:sqlserver://kindergartenserver.database.windows.net;"
							+ "user=" + user
							+ ";password=" + pwd
							+ ";encrypt=true;"
							+ "trustServerCertificate=false;"
							+ "loginTimeout=30;"
							+ "database=kindergarten_app;";
			Connection c = DriverManager.getConnection(url);
			Statement s = c.createStatement();
			LoginPageStudent lp = new LoginPageStudent(c);
		}
		catch(SQLException e)
		{
			System.out.println("Exception occurred");
			e.printStackTrace(System.out);
		}
	}
}
