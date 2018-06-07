package bigcookingdata_engine.database;

public class CreateData {
    public static void main(String[] args) throws Exception {
        Neo4J.createUser("a", "a", "a");
        Neo4J.ratingIngred("a", 2, 10);
        Neo4J.ratingIngred("a", 3, 10);
        Neo4J.ratingIngred("a", 4, 10);
        Neo4J.ratingCluster("a", 1, 70);
        Neo4J.ratingCluster("a", 2, 30);
        Neo4J.ratingCluster("a", 3, 20);
    }

}
