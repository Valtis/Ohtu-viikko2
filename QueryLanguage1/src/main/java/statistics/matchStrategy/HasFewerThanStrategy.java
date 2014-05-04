
package statistics.matchStrategy;


public class HasFewerThanStrategy implements MatchingStrategy {
    @Override
    public boolean matches(int score, int threshold) {
        return score < threshold;
    }
}
