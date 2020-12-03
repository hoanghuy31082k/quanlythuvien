package UTILS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
 
 private String db_url = null;
 private String db_user = null;
 private String db_password = null;
 private Connection con;
 
 public Connection getConnection(){
	
	 try {
		 
		 db_url = "jdbc:mysql://localhost:3306/qltv";
		 db_user = "root";
		 db_password = "";
		
		 System.err.println("Database Connected");
		 con = DriverManager.getConnection(db_url, db_user, db_password);
	 } catch (SQLException e) {
		 System.err.println("Loi ket noi co so du lieu.");
	 }
	 if (con == null) {
		 throw new NullPointerException("Ket noi khong thanh cong.");
	 }
	 return con;
 }

} 
