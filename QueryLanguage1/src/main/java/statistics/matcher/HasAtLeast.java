
package statistics.matcher;

import statistics.matchStrategy.AtLeastStrategy;

class HasAtLeast extends PlayerAttributeValueChecker {

    public HasAtLeast(int value, String category) {
        super(value, category, new AtLeastStrategy());
    }

}
