
package statistics.matcher;

import java.lang.reflect.Method;
import statistics.Player;
import statistics.matchStrategy.MatchingStrategy;


abstract class PlayerAttributeValueChecker implements Matcher {
   
    private int value;
    private String fieldName;
    private MatchingStrategy strategy;
    public PlayerAttributeValueChecker(int value, String category, MatchingStrategy strategy) {
        this.value = value;
        fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
        this.strategy = strategy;
    }

    @Override
    public boolean matches(Player p) {
        try {                                    
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return strategy.matches(playersValue, value);
        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }       
        
    }    
}
