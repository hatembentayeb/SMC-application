package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class singletonConnection {
private static Connection connection;
	
	
	public static Connection getConnection(){
		return connection;
	}
	
	static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/estore", "root" , "");
			System.out.println("connexion etablie");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
