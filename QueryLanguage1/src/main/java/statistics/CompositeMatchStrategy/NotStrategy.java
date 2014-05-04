
package statistics.CompositeMatchStrategy;

import statistics.Player;
import statistics.matcher.Matcher;


public class NotStrategy implements CompositeMatchingStrategy {

    @Override
    public boolean matchReturnValue() {
        return false;
    }

    @Override
    public boolean matches(Matcher matcher, Player p) {
        return matcher.matches(p);
    }
    
}
