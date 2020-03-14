package com.kodilla.rps;

import java.util.Scanner;

public class Algorithm {

    int rounds = 0;
    int numberOfHumanVictories = 0;
    int numberOfComputerVictories = 0;
    int numberOfTies = 0;
    int roundsToWin;
    String playerName;
    String playerMove;
    String computerMove;

    public void askForPlayerName() {
        Scanner nameScanner = new Scanner(System.in);
        playerName = nameScanner.nextLine();
    }

    public int askForRoundsToWin(int roundsToWin) {
        Scanner roundScanner = new Scanner(System.in);
        this.roundsToWin = roundScanner.nextInt();
        while (this.roundsToWin <= 0) {
            System.out.println("Invalid number. Please enter number greater than zero.");
            Scanner numberOfGamesScanner = new Scanner(System.in);
            this.roundsToWin = numberOfGamesScanner.nextInt();
        }
        return this.roundsToWin;
    }

    public void displayFinalScores() {
        System.out.println("Final scoreboard below:" + "\n " + playerName + " wins: " + numberOfHumanVictories +
                "\n Computer wins: " + numberOfComputerVictories + "\n Number of ties: " + numberOfTies +
                "\n Rounds passed: " + rounds);
    }

    public void play() {
        String whatToDo = "";
        Scanner scan = new Scanner(System.in);
        RpsRunner rpsGame = new RpsRunner();

        whatToDo = askForPlayerMove();
        if (whatToDo.equals("x")) {
            System.out.println(Statements.areYouSureExit);
            if (!scan.next().equals("y")) {
                displayFinalScores();
                rpsGame.start();
            }
            whatToDo = askForPlayerMove();
        }
        if (whatToDo.equals("n")) {
            System.out.println(Statements.areYouSureNewGame);
            if (!scan.next().equals("n")) {
                rpsGame.start();
            }
            whatToDo = askForPlayerMove();
        }
        setHumanMoves(whatToDo);
        setComputerMoves();
        compareMoves();
    }

    public String askForPlayerMove() {
        System.out.println(Statements.rules);
        Scanner moveScanner = new Scanner(System.in);
        String playerChoice = moveScanner.next();
        if (playerChoice.equals("1") || playerChoice.equals("2") || playerChoice.equals("3")
                || playerChoice.equals("x") || playerChoice.equals("n")) {
            return playerChoice;
        }
        System.out.println("Invalid key used. Please enter one from these keys: 1, 2, 3, n, x.");
        askForPlayerMove();
        return playerChoice;
    }

    public void compareMoves() {
        System.out.println(playerName + " choose: " + playerMove + "\nComputer choose: " + computerMove);
        if (playerMove.equals("rock") && computerMove.equals("scissors")
                || playerMove.equals("paper") && computerMove.equals("rock")
                || playerMove.equals("scissors") && computerMove.equals("paper")) {
            System.out.println(playerName + " wins!");
            numberOfHumanVictories++;
        } else if (playerMove.equals("rock") && computerMove.equals("paper")
                || playerMove.equals("paper") && computerMove.equals("scissors")
                || playerMove.equals("scissors") && computerMove.equals("rock")) {
            System.out.println("Computer wins!");
            numberOfComputerVictories++;
        } else if (playerMove.equals(computerMove)) {
            System.out.println("We have a tie!");
            numberOfTies++;
        }
    }

    public void setHumanMoves(String text) {
        if (text.equals("1")) {
            playerMove = "rock";
        } else if (text.equals("2")) {
            playerMove = "paper";
        } else if (text.equals("3")) {
            playerMove = "scissors";
        }
    }

    public void setComputerMoves() {
        computerMove = Math.random() < 0.33 ? "paper" : (Math.random() >= 0.33 && Math.random() < 0.66
                ? "scissors" : "rock");
    }

    public void setComputerMovesSmarter() {
        if (playerMove.equals("rock")) {
            computerMove = Math.random() <= 0.50 ? "paper" : (Math.random() < 0.25 && Math.random() < 0.25
                    ? "scissors" : "rock");
        } else if (playerMove.equals("paper")) {
            computerMove = Math.random() <= 0.50 ? "scissors" : (Math.random() < 0.25 && Math.random() < 0.25
                    ? "paper" : "rock");
        } else if (playerMove.equals("scissors")) {
            computerMove = Math.random() <= 0.50 ? "rock" : (Math.random() < 0.25 && Math.random() < 0.25
                    ? "scissors" : "scissors");
        }
    }
}
