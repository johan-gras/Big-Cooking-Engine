package bigcookingdata_engine.db_connection;

import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * @desc A singleton database access class
 * @author sofiane-hamiti
 *
 */

public final class SingletonConnection {
	public Connection conn;
	public static SingletonConnection db;

	/*
	 * Constructor without fields
	 */
	private SingletonConnection() {
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "bigcookingdata";
		String driver = "com.mysql.jdbc.Driver";
		String userName = "root";
		String password = "azerty";
		try {
			Class.forName(driver).newInstance();
			this.conn = (Connection) DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}
	
	public static synchronized SingletonConnection getDbConnection() {
		if(db == null) {
			db = new SingletonConnection();
		}
		
		return db;
	}
}
