package bigcookingdata_engine.db_connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

/**
 * Class for simple actions: Create, Read, Update, Delete (CRUD)
 * @author sofiane-hamiti
 *
 */

public class DataBaseCrudMethods {
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	public static ResultSet rs = null;
	
	/**
	 * Get data from DB
	 * @param query
	 * 		SQL query
	 * @return
	 * 		return sql.resultSet
	 * @throws SQLException
	 */
	public static ResultSet GetResultSet(String query) {
		try {
			SingletonConnection sc = SingletonConnection.getDbConnection();
			conn = sc.conn;
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
		} catch (Exception sqle) {
			sqle.printStackTrace();
		}
		return rs;
	}
	
	public static void DeleteUdateCreate(String query) {
		try {
			SingletonConnection sc = SingletonConnection.getDbConnection();
			conn = sc.conn;
			ps = conn.prepareStatement(query);
			ps.executeUpdate();
			System.out.println("db updated");
		}catch (Exception sqle) {
			sqle.printStackTrace();
		}
	}
	
	
	
	
}
