
package statistics.matchStrategy;


public class AtLeastStrategy implements MatchingStrategy {

    @Override
    public boolean matches(int score, int threshold) {
        return score >= threshold;
    }
    

}
