package bigcookingdata_engine.database;

public class CreateData {
    public static void main(String[] args) throws Exception {
        Neo4J.createUser("aa@aa.aa", "a", "a");
        Neo4J.ratingIngred("aa@aa.aa", 2, 10);
        Neo4J.ratingIngred("aa@aa.aa", 3, 10);
        Neo4J.ratingIngred("aa@aa.aa", 4, 10);
        Neo4J.ratingCluster("aa@aa.aa", 1, 70);
        Neo4J.ratingCluster("aa@aa.aa", 2, 30);
        Neo4J.ratingCluster("aa@aa.aa", 3, 20);
    }

}
