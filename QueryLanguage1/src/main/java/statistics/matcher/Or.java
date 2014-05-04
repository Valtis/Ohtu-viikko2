package statistics.matcher;

import statistics.CompositeMatchStrategy.OrStrategy;

public class Or extends CompositeBase {

    public Or(Matcher... matchers) {
        super(new OrStrategy(), matchers);
    }
}
