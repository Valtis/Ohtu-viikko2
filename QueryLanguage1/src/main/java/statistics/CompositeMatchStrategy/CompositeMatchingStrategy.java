package statistics.CompositeMatchStrategy;

import statistics.Player;
import statistics.matcher.Matcher;

public interface CompositeMatchingStrategy {
    public boolean matchReturnValue();
    public boolean matches(Matcher matcher, Player p);
}
