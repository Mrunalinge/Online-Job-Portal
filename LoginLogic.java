package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.JobSeeker;
import bean.Login;

public class LoginLogic {

	public LoginLogic() {
		// TODO Auto-generated constructor stub
	}

	

	public boolean CheckLogin(JobSeeker u) {
	//	String name = "Name";
	//	String pass = "Pss";
		Connection conn=null;
		System.out.println("Hello");
		Statement stmt = null;
		ResultSet rs;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Driver loaded");
		//	System.out.println(u.getUsername() + "  " + u.getPassword());

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/jobportal", "root", "root");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from registration where email='"
					+ u.getEmail() + "'and password='" + u.getPassword() + "'");

			if (rs.next()) {
				rs.close();
				conn.close();
				System.out.println("Connection done");
				return true;

			} else {

				rs.close();
				conn.close();
				System.out.println("Connection not done");
				return false;

			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class not found");
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}

}
