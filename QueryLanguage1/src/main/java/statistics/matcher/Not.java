
package statistics.matcher;

import statistics.CompositeMatchStrategy.NotStrategy;
import statistics.Player;


public class Not extends CompositeBase {
  public Not(Matcher ...matchers) {
        super(new NotStrategy(), matchers);
    }
}
