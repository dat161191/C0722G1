package ss8_clean_code.exercise;

public class TennisGame {
    static final int LOVE = 0;
    static final int FIFTEEN = 1;
    static final int THIRTY = 2;
    static final int FORTY = 3;

    static final String LOVE_ALL = "Love-All";
    static final String FIFTEEN_ALL = "Fifteen-All";
    static final String THIRTY_ALL = "Thirty-All";
    static final String FORTY_ALL = "Forty-All";
    static final String DEUCE = "Deuce";

    public static String getScore(String player1Name, String player2Name, int point1, int point2) {
        boolean isPointEqual = point1 == point2;
        boolean isPoint1GreaterThan4 = point1 >= 4;
        boolean isPointGreaterThan4 = point2 >= 4;

        if (isPointEqual) {
            return showPointEqual(point1);
        }

        if (isPoint1GreaterThan4 || isPointGreaterThan4) {
            return showPointGreaterThan4(player1Name, player2Name, point1, point2);
        }

        return showPointElse(point1, point2);
    }

    private static String showPointElse(int score1, int score2) {
        StringBuilder showPoint = new StringBuilder();
        int tempPoint;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempPoint = score1;
            } else {
                showPoint.append("-");
                tempPoint = score2;
            }
            switch (tempPoint) {
                case LOVE:
                    showPoint.append("Love");
                    break;
                case FIFTEEN:
                    showPoint.append("Fifteen");
                    break;
                case THIRTY:
                    showPoint.append("Thirty");
                    break;
                case FORTY:
                    showPoint.append("Forty");
                    break;
            }
        }
        return showPoint.toString();
    }

    private static String showPointGreaterThan4(String player1Name, String player2Name, int score1, int score2) {
        int minusResult = score1 - score2;

        if (minusResult == 1) {
            return "Advantage " + player1Name;
        }
        if (minusResult == -1) {
            return "Advantage " + player2Name;
        }
        if (minusResult >= 2) {
            return "Win for " + player1Name;
        }
        return "Win for " + player2Name;
    }

    private static String showPointEqual(int point) {
        switch (point) {
            case LOVE:
                return LOVE_ALL;
            case FIFTEEN:
                return FIFTEEN_ALL;
            case THIRTY:
                return THIRTY_ALL;
            case FORTY:
                return FORTY_ALL;
            default:
                return DEUCE;

        }
    }
}
