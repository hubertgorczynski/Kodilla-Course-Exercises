package com.kodilla.rps;

public class Statements {

    private Statements() {
    }

    public static final String rules = "|Key 1 - play \"rock\"|" + "\n|Key 2 - play \"paper\"|"
            + "\n|Key 3 - play \"scissors\"|" + "\n|Exit (press \"x\" button)|"
            + "\n|Start new game (press \"n\" button)|";

    public static final String areYouSureExit = "Are you sure you want to end the game? "
            + "\n Confirm by pressing\"y\" button to cancel";

    public static final String areYouSureNewGame = "Are you sure you want to start new game? "
            + "\n Confirm by pressing\"y\" button to cancel";

    public static final String askForDifficultyLevel = "Would You like to check your strength on harder level?";

}

