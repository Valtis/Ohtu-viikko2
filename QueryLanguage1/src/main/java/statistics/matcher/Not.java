
package statistics.matcher;

import statistics.CompositeMatchStrategy.NotStrategy;
import statistics.Player;


class Not extends CompositeBase {
  public Not(Matcher ...matchers) {
        super(new NotStrategy(), matchers);
    }
}
