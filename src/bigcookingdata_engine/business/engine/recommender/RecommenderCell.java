package bigcookingdata_engine.business.engine.recommender;

import java.util.HashMap;

abstract class RecommenderCell {
    abstract HashMap<Integer, Integer> scoring();
}
