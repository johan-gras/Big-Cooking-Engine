package bigcookingdata_engine.database;

import java.sql.DriverManager;
import org.neo4j.jdbc.Driver;

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
			Class.forName("org.neo4j.jdbc.Driver");			
			this.conn=(java.sql.Connection) DriverManager.getConnection("jdbc:neo4j:bolt://localhost:7687/?user=neo4j,password=password,debug=true");
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
