package bigcookingdata_engine.business.engine;

import bigcookingdata_engine.business.data.user.User;
import bigcookingdata_engine.business.engine.recommender.Recommender;
import bigcookingdata_engine.database.Neo4J;

public class Session {
    private static Session ourInstance = new Session();
    private User user = null;
    private Recommender recommender = null;
    private Searcher searcher = null;

    private Session() {}

    public static Session getInstance() {
        return ourInstance;
    }

    public String connection(String user, String pwd){
        User user_db = Neo4J.connection(user, pwd);
        if (user_db == null)
            return null;

        // Create session
        this.user = user_db;
        this.recommender = new Recommender();
        this.searcher = new Searcher();

        return user_db.getName();
    }

    public void deconnection(){
        user = null;
        recommender = null;
        searcher = null;
    }

    // Fake
    private User fake_db_connection(String user, String pwd){
        String userID = "aa@aa.aa";
        String password = "aa";
        if (user.equals(userID) && pwd.equals(password)){
            User fake_user = new User(0, "a", "body", "m", "120");
            return fake_user;
        }
        return null;
    }

    public Recommender getRecommender() {
        return recommender;
    }

    public Searcher getSearcher() {
        return searcher;
    }

    public User getUser() {
        return user;
    }

    public boolean isConnected(){
        return user != null;
    }
}
