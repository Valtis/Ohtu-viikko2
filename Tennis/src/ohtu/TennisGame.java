package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    Map<Integer, String> scoreNames;

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {

        scoreNames = new HashMap<Integer, String>();
        scoreNames.put(0, "Love");
        scoreNames.put(1, "Fifteen");
        scoreNames.put(2, "Thirty");
        scoreNames.put(3, "Forty");

        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else if (playerName.equals(player2Name)) {
            player2Score += 1;
        }
    }

    public String getScore() {
        
        if (isDeuce()) {
            return "Deuce";
        } else if (gameWon()) {
           return "Win for " + getPlayerNameForAdvantageOrVictory();
        }
        else if (isAdvantage()) {
            return getAdvantageOrWonString();
        } else {
            return getScoreString();
        }
    }

    private boolean gameAtAdvantageOrWon() {
        return player1Score >= 4 || player2Score >= 4;
    }

    private String getAdvantageOrWonString() {      
        return "Advantage " + getPlayerNameForAdvantageOrVictory();
    }

    private String getScoreString() {
        String score = scoreNames.get(player1Score) + "-";

        if (player1Score == player2Score) {
            score += "All";
        } else {
            score += scoreNames.get(player2Score);
        }

        return score;
    }

    public boolean isDeuce() {
        return player1Score == player2Score && scoresHighEnoughToAllowVictory();
    }

    private boolean isAdvantage() {
       return Math.abs(player1Score - player2Score) == 1 && scoresHighEnoughToAllowVictory();
    }

    private String getPlayerNameForAdvantageOrVictory() {
        if (player1Score > player2Score) {
            return player1Name;
        }
        return player2Name;
    }

    private boolean gameWon() {
        return Math.abs(player1Score - player2Score) >= 2  && scoresHighEnoughToAllowVictory();
    }

    private boolean scoresHighEnoughToAllowVictory() {
        return Math.max(player1Score, player2Score) > 3;
    }
}
