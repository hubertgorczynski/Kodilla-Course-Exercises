package com.kodilla.rps;

import java.util.Scanner;

public class RoundHandler {
    private String playerMove;
    private String computerMove;

    public boolean play() {
        boolean stateOfGame;
        GameHandler gameHandler = new GameHandler();
        Scanner scan = new Scanner(System.in);

        String whatToDo = askForPlayerMove();

        if (whatToDo.equals("x")) {
            System.out.println(Statements.areYouSureExit);
            if (scan.next().equals("x")) {
                gameHandler.displayFinalScores();
                gameHandler.start(false);
            }
        }

        if (whatToDo.equals("n")) {
            System.out.println(Statements.areYouSureNewGame);
            if (scan.next().equals("n")) {
                gameHandler.start(true);
            }
        }

        setHumanMoves(whatToDo);
        setComputerMoves();
        stateOfGame = compareMoves();
        return stateOfGame;
    }

    private String askForPlayerMove() {
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

    private boolean compareMoves() {
        System.out.println("You choose: " + playerMove + " vs Computer choose: " + computerMove);
        if (playerMove.equals("rock") && computerMove.equals("scissors")
                || playerMove.equals("paper") && computerMove.equals("rock")
                || playerMove.equals("scissors") && computerMove.equals("paper")) {
            System.out.println("You win!");
            return true;
        } else if (playerMove.equals("rock") && computerMove.equals("paper")
                || playerMove.equals("paper") && computerMove.equals("scissors")
                || playerMove.equals("scissors") && computerMove.equals("rock")) {
            System.out.println("Computer wins!");
            return false;
        } else {
            System.out.println("We have a tie!");
            return false;
        }
    }

    private void setHumanMoves(String text) {
        switch (text) {
            case "1":
                playerMove = "rock";
                break;
            case "2":
                playerMove = "paper";
                break;
            case "3":
                playerMove = "scissors";
                break;
        }
    }

    private void setComputerMoves() {
        if (playerMove.equals("rock")) {
            if (Math.random() <= 0.50) {
                computerMove = "paper";
            } else {
                if (Math.random() < 0.25) {
                    computerMove = "scissors";
                } else {
                    computerMove = "rock";
                }
            }
        }

        if (playerMove.equals("paper")) {
            if (Math.random() <= 0.50) {
                computerMove = "scissors";
            } else {
                if (Math.random() < 0.25) {
                    computerMove = "rock";
                } else {
                    computerMove = "paper";
                }
            }
        }

        if (playerMove.equals("scissors")) {
            if (Math.random() <= 0.50) {
                computerMove = "rock";
            } else {
                if (Math.random() < 0.25) {
                    computerMove = "paper";
                } else {
                    computerMove = "scissors";
                }
            }
        }

    }
}



