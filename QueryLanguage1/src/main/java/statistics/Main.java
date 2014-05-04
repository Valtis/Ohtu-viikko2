package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));
/*
        Matcher m = new And(new Or(new HasAtLeast(10, "goals"),
                new HasAtLeast(10, "assists")),
                new HasFewerThan(50, "points"),
                new PlaysIn("PHI"),
                new Not(new PlaysIn("NYI"))
        );*/
        QueryBuilder query = new QueryBuilder();
        Matcher m = 
                query.oneOf(
                        (new QueryBuilder()).
                                hasAtLeast(10, "goals").build(),
                        (new QueryBuilder()).
                                hasAtLeast(10, "assists").build()).
                hasFewerThan(50, "points").
                playsIn("PHI").
                not(
                        (new QueryBuilder()).
                                playsIn("NYI").build())
        .build();
        

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
