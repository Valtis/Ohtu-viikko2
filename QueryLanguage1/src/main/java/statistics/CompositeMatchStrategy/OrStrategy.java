
package statistics.CompositeMatchStrategy;

import statistics.Player;
import statistics.matcher.Matcher;


public class OrStrategy implements CompositeMatchingStrategy {

    @Override
    public boolean matchReturnValue() {
        return true; 
    }

    @Override
    public boolean matches(Matcher matcher, Player p) {
        return matcher.matches(p);
    }

}
