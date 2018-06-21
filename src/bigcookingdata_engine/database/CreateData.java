package bigcookingdata_engine.database;

public class CreateData {
    public static void main(String[] args) throws Exception {
        Neo4J.createUser("aa@aa.aa", "aa@aa.aa", "a","12");
        Neo4J.ratingIngred("aa@aa.aa", 2, 10);
        Neo4J.ratingIngred("aa@aa.aa", 3, 10);
        Neo4J.ratingIngred("aa@aa.aa", 4, 10);
        Neo4J.ratingCluster("aa@aa.aa", 1, 70);
        Neo4J.ratingCluster("aa@aa.aa", 2, 30);
        Neo4J.ratingCluster("aa@aa.aa", 3, 20);
        Neo4J.ratingRecipe("aa@aa.aa", 24, 5);
        Neo4J.ratingRecipe("aa@aa.aa", 34, 6);
        Neo4J.ratingRecipe("aa@aa.aa", 76, 9);
        Neo4J.ratingRecipe("aa@aa.aa", 90, 7);
        Neo4J.ratingRecipe("aa@aa.aa", 234, 4);

        Neo4J.createUser("max", "max@gmail.com", "a","70");
        Neo4J.ratingIngred("max@gmail.com", 2, 4);
        Neo4J.ratingIngred("max@gmail.com", 90, 9);
        Neo4J.ratingIngred("max@gmail.com", 12, 6);
        Neo4J.ratingIngred("max@gmail.com", 23, 3);
        Neo4J.ratingIngred("max@gmail.com", 43, 5);
        Neo4J.ratingIngred("max@gmail.com", 23, 4);
        Neo4J.ratingRecipe("max@gmail.com", 234, 9);
        Neo4J.ratingRecipe("max@gmail.com", 24, 9);
        Neo4J.ratingRecipe("max@gmail.com", 14, 10);
        Neo4J.ratingRecipe("max@gmail.com", 124, 4);
        Neo4J.ratingRecipe("max@gmail.com", 74, 6);

        Neo4J.createUser("aissam", "aissam@gmail.com", "a","110");
        Neo4J.ratingIngred("aissam@gmail.com", 2, 10);
        Neo4J.ratingIngred("aissam@gmail.com", 90, 8);
        Neo4J.ratingIngred("aissam@gmail.com", 45, 2);
        Neo4J.ratingIngred("aissam@gmail.com", 43, 1);
        Neo4J.ratingIngred("aissam@gmail.com", 53, 5);
        Neo4J.ratingIngred("aissam@gmail.com", 59, 6);
        Neo4J.ratingRecipe("aissam@gmail.com", 124, 5);
        Neo4J.ratingRecipe("aissam@gmail.com", 165, 9);
        Neo4J.ratingRecipe("aissam@gmail.com", 345, 6);
        Neo4J.ratingRecipe("aissam@gmail.com", 564, 5);
        Neo4J.ratingRecipe("aissam@gmail.com", 346, 1);

        Neo4J.createUser("sofiane", "sofiane@gmail.com", "a","17");
        Neo4J.ratingIngred("sofiane@gmail.com", 2, 7);
        Neo4J.ratingIngred("sofiane@gmail.com", 90, 8);
        Neo4J.ratingIngred("sofiane@gmail.com", 34, 6);
        Neo4J.ratingIngred("sofiane@gmail.com", 123, 1);
        Neo4J.ratingIngred("sofiane@gmail.com", 122, 5);
        Neo4J.ratingIngred("sofiane@gmail.com", 23, 6);
        Neo4J.ratingRecipe("sofiane@gmail.com", 389, 2);
        Neo4J.ratingRecipe("sofiane@gmail.com", 34, 4);
        Neo4J.ratingRecipe("sofiane@gmail.com", 36, 9);
        Neo4J.ratingRecipe("sofiane@gmail.com", 16, 10);

        Neo4J.createUser("rezki", "rezki@gmail.com", "a","67");
        Neo4J.ratingIngred("rezki@gmail.com", 2, 7);
        Neo4J.ratingIngred("rezki@gmail.com", 90, 8);
        Neo4J.ratingIngred("rezki@gmail.com", 34, 6);
        Neo4J.ratingIngred("rezki@gmail.com", 123, 1);
        Neo4J.ratingIngred("rezki@gmail.com", 122, 5);
        Neo4J.ratingIngred("rezki@gmail.com", 23, 6);
        Neo4J.ratingRecipe("rezki@gmail.com", 145, 10);
        Neo4J.ratingRecipe("rezki@gmail.com", 765, 9);
        Neo4J.ratingRecipe("rezki@gmail.com", 654, 7);
        Neo4J.ratingRecipe("rezki@gmail.com", 766, 3);
        

        Neo4J.createUser("johan", "johan@gmail.com", "a","44");
        Neo4J.ratingIngred("johan@gmail.com", 2, 9);
        Neo4J.ratingIngred("johan@gmail.com", 99, 8);
        Neo4J.ratingIngred("johan@gmail.com", 543, 6);
        Neo4J.ratingIngred("johan@gmail.com", 345, 1);
        Neo4J.ratingIngred("johan@gmail.com", 455, 5);
        Neo4J.ratingIngred("johan@gmail.com", 23, 6);
        Neo4J.ratingRecipe("johan@gmail.com", 766, 2);
        Neo4J.ratingRecipe("johan@gmail.com", 66, 3);
        Neo4J.ratingRecipe("johan@gmail.com", 26, 5);
        Neo4J.ratingRecipe("johan@gmail.com", 76, 7);


    }

}
