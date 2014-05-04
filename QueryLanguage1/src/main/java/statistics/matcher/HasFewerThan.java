 
package statistics.matcher;

import statistics.matchStrategy.HasFewerThanStrategy;


class HasFewerThan extends PlayerAttributeValueChecker {

    public HasFewerThan(int value, String category) {
        super(value, category, new HasFewerThanStrategy());
    }

}
