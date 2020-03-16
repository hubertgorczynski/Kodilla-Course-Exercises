package com.kodilla.rps;

import java.util.Scanner;

public class GameHandler {
    int rounds = 1;
    int numberOfHumanVictories;
    int numberOfComputerVictories;
    int roundsToWin;
    String playerName;
    boolean end = false;

    public void start(boolean doYouPlay) {
        end = !doYouPlay;

        while (!end) {
            RoundHandler roundHandler = new RoundHandler();
            numberOfHumanVictories = 0;
            numberOfComputerVictories = 0;
            rounds = 1;

            System.out.println("\nWELCOME IN ROCK-PAPER-SCISSORS THE GAME!!! \nPlease enter Your name below:");
            Scanner nameScanner = new Scanner(System.in);
            playerName = nameScanner.nextLine();

            System.out.println("\nPlease set a number of rounds to win:");
            askForRoundsToWin();

            while (numberOfHumanVictories < roundsToWin && numberOfComputerVictories < roundsToWin) {
                System.out.println("\nRound: " + rounds);
                if (roundHandler.play()) {
                    numberOfHumanVictories++;
                } else {
                    numberOfComputerVictories++;
                }
                rounds++;
                displayActualScores();
            }
            displayFinalScores();
        }
    }

    private void askForRoundsToWin() {
        Scanner roundScanner = new Scanner(System.in);
        roundsToWin = roundScanner.nextInt();
        while (roundsToWin <= 0) {
            System.out.println("Invalid number. Please enter number greater than zero.");
            Scanner numberOfGamesScanner = new Scanner(System.in);
            roundsToWin = numberOfGamesScanner.nextInt();
        }
    }

    private void displayActualScores() {
        System.out.println("\n|Actual scoreboard|" + "\n " + playerName + " wins: " + numberOfHumanVictories +
                "\n Computer wins: " + numberOfComputerVictories);
    }

    public void displayFinalScores() {
        System.out.println("\n|Final scoreboard|" + "\n " + playerName + " wins: " + numberOfHumanVictories +
                "\n Computer wins: " + numberOfComputerVictories + "\n Rounds passed: " + (rounds - 1));
    }
}



