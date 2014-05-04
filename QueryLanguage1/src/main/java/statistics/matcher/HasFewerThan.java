 
package statistics.matcher;

import statistics.matchStrategy.HasFewerThanStrategy;


public class HasFewerThan extends PlayerAttributeValueChecker {

    public HasFewerThan(int value, String category) {
        super(value, category, new HasFewerThanStrategy());
    }

}
