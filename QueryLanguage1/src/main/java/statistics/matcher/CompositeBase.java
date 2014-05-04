
package statistics.matcher;

import statistics.CompositeMatchStrategy.CompositeMatchingStrategy;
import statistics.Player;


class CompositeBase implements Matcher {

    private Matcher[] matchers;
    CompositeMatchingStrategy strategy;
    
    public CompositeBase(CompositeMatchingStrategy strategy, Matcher... matchers) {
        this.matchers = matchers;
        this.strategy = strategy;
    }


    @Override
    public boolean matches(Player p) {
        for (Matcher matcher : matchers) {
            if (strategy.matches(matcher, p)) {
                return strategy.matchReturnValue();
            }
        }

        return !strategy.matchReturnValue();
    }
}
