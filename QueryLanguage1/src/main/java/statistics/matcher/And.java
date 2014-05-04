package statistics.matcher;

import statistics.CompositeMatchStrategy.AndStrategy;

class And extends CompositeBase {
    public And(Matcher ...matchers) {
        super(new AndStrategy(), matchers);
    }
}
