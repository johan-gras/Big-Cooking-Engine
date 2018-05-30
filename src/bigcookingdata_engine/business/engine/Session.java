package bigcookingdata_engine.business.engine;

import bigcookingdata_engine.business.data.user.User;

public class Session {
    private static Session ourInstance = new Session();
    private User user;
    private Recommender recommender;
    private Searcher searcher;

    private Session() {
    }

    public static Session getInstance() {
        return ourInstance;
    }

    public String connection(String user, String pwd){
        User user_db = fake_db_connection(user, pwd);
        if (user_db == null)
            return null;

        // Create session
        this.user = user_db;
        this.recommender = new Recommender();
        this.searcher = new Searcher();

        return user_db.getName();
    }

    // Fake
    private User fake_db_connection(String user, String pwd){
        String userID = "aa@aa.aa";
        String password = "aa";
        if (user.equals(userID) && pwd.equals(password)){
            User fake_user = new User(0, "Some", "body", "m", 120.);
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
}
