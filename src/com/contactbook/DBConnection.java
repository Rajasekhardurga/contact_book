package com.contactbook;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static String url = "jdbc:postgresql://localhost:5432/contact_book"; // Your database name
    static String user = "postgres"; // Your username
    static String password = "123"; // Your password
    public static Connection getConnection() {
        Connection con = null;
        try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,user,password);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return con;
    }
}
