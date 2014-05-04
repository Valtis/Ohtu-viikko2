package ohtu;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    Map<Integer, String> scoreNames;
    Map<String, Integer> playerScores;

    private int player1Score = 0;
    private int player2Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame(String player1Name, String player2Name) {
        playerScores = new HashMap<String, Integer>();
        scoreNames = new HashMap<Integer, String>();
        scoreNames.put(0, "Love");
        scoreNames.put(1, "Fifteen");
        scoreNames.put(2, "Thirty");
        scoreNames.put(3, "Forty");

        playerScores.put(player1Name, 0);
        playerScores.put(player2Name, 0);

        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {

        if (playerName.equals("player1")) {
            player1Score += 1;
        } else {
            player2Score += 1;
        }

        if (playerScores.containsKey(playerName)) {
            playerScores.put(playerName, playerScores.get(playerName) + 1);
        }
    }

    public String getScore() {
 
        if ((player1Score >= 4 || player2Score >= 4) && player1Score != player2Score) {
           return getDescriptionString();
        } else {
            return getScoreString();
        }
    }

    private String getDescriptionString() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult == 1) {
            score = "Advantage player1";
        } else if (minusResult == -1) {
            score = "Advantage player2";
        } else if (minusResult >= 2) {
            score = "Win for player1";
        } else {
            score = "Win for player2";
        }
        return score;
    }
    
    
    private String getScoreString() {
    
            String score = scoreNames.get(player1Score) + "-";
            if (player1Score == player2Score) {
                if (player1Score > 3) {
                    return "Deuce";
                }
               
                score += "All";
            } else {
                score += scoreNames.get(player2Score);
            }
            
            return score;
    }

}
