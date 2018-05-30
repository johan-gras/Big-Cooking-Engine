package bigcookingdata_engine.database;

import java.sql.DriverManager;

/**
 * Singleton connection for neo4j
 * @author sofiane-hamiti
 *
 */
public final class SingletonConnectionNeo4j {
	
	
	public java.sql.Connection conn;
	public static SingletonConnectionNeo4j db;
	
	public SingletonConnectionNeo4j() {
		
		try {
			this.conn=(java.sql.Connection) DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/?user=neo4j,password=password");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static synchronized SingletonConnectionNeo4j getDbConnection() {
		if(db == null) {
			db = new SingletonConnectionNeo4j();
		}
		
		return db;
	}
	
}
