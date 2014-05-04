
package statistics.matcher;

import java.util.ArrayList;
import java.util.List;
import statistics.CompositeMatchStrategy.AndStrategy;
import statistics.CompositeMatchStrategy.NotStrategy;
import statistics.CompositeMatchStrategy.OrStrategy;
import statistics.matchStrategy.AtLeastStrategy;
import statistics.matchStrategy.HasFewerThanStrategy;


public class QueryBuilder {
    List<Matcher> matchers;
    
    public QueryBuilder() {
        matchers = new ArrayList<Matcher>();
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new PlayerAttributeValueChecker(value, category, new HasFewerThanStrategy()));
        return this;
    }
    
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new PlayerAttributeValueChecker(value, category, new AtLeastStrategy()));
        return this;
    }
    
    
    public QueryBuilder oneOf(Matcher ...m) {
        matchers.add(new CompositeBase(new OrStrategy(), m));
        return this;
    }
    
    public QueryBuilder not(Matcher ...m) {
        matchers.add(new CompositeBase(new NotStrategy(), m));
        return this;
    }
    
    public Matcher and(Matcher ...matchers) {
        return new CompositeBase(new AndStrategy(), matchers);
    }
    
    
    public Matcher build() {
        Matcher m = new CompositeBase(new AndStrategy(), matchers.toArray(new Matcher[matchers.size()]));
        matchers.clear();
        return m;
    }
    
    
    
}
