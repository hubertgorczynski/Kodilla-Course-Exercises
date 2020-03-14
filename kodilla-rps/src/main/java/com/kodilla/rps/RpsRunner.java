package com.kodilla.rps;

public class RpsRunner {
    int numberOfHumanVictories = 0;
    int numberOfComputerVictories = 0;
    int roundsToWin;

    public void start() {
        Algorithm algorithm = new Algorithm();

        System.out.println("WELCOME IN ROCK-PAPER-SCISSORS THE GAME!!! \nPlease enter Your name below:");
        algorithm.askForPlayerName();

        System.out.println("Please set a number of rounds to win:");
        algorithm.askForRoundsToWin(roundsToWin);

        while (numberOfHumanVictories < roundsToWin || numberOfComputerVictories < roundsToWin) {
            algorithm.play();
        }
    }
}

