
package com.bridgelabz;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int index, toss;
    static char[] ticTacToe = new char[10];
    static char letter;
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void TicTacToeInit() {        // UC-1
        int i=0;
        for (i = 0; i < 10; i++) {
            ticTacToe[i] = ' ';
        }
    }
    /* public static void ChooseValue() {         // UC-2

        System.out.println("Please Select the Letter: X or O");
        letter = sc.next().charAt(0);
    } */

    static void ShowBoard() {                   // UC-3
        int i=0;
        for (i = 0; i <= 8; i++) {
            System.out.println(ticTacToe[i] + " | " + ticTacToe[++i] + " | " + ticTacToe[++i] + '\n' + "---------");
        }
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("*************************");
        System.out.println("*************************");
    }

    public static void MakeMove() {               // UC-4,5
        System.out.println("Enter the index you want to enter the value (1-9)");

        index = sc.nextInt();
        if (ticTacToe[index - 1] == ' ') {
            ticTacToe[index - 1] = 'X';
        }
    }

    public static int Toss() {                      // UC-6
        toss = rand.nextInt(2);
        System.out.println(toss);
        if (toss == 0) {
            System.out.println("User won the toss and will start first.");
        } else {
            System.out.println("Computer won toss and will start first.");
        }
        return toss;
    }

    public static int GameCheck() {                     // UC-7
        int won=0;
        int i=0;
        for (i = 0; i <= 6; i++) {                              // Because our conditions are valid till i=6.
            if (i == 0 || i == 1 || i == 2) {
                if ((ticTacToe[i] == ticTacToe[i + 3]) && (ticTacToe[i] == ticTacToe[i + 6]) && ticTacToe[i] == 'X') {
                    System.out.println("Player WON");
                    won=1;
                    break;
                }
                if ((ticTacToe[i] == ticTacToe[i + 3]) && (ticTacToe[i] == ticTacToe[i + 6]) && ticTacToe[i] == 'O') {
                    System.out.println("Computer WON");
                    won=2;
                    break;
                }
            }  if ((i == 0 || i == 3 || i == 6)) {
                if ((ticTacToe[i] == ticTacToe[i + 1]) && (ticTacToe[i] == ticTacToe[i + 2]) && ticTacToe[i] == 'X') {
                    System.out.println("Player WON");
                    won=1;
                    break;
                }
                if ((ticTacToe[i] == ticTacToe[i + 1]) && (ticTacToe[i] == ticTacToe[i + 2]) && ticTacToe[i] == 'O') {
                    System.out.println("Computer WON");
                    won=2;
                    break;
                }
            }  if (i == 0) {
                if ((ticTacToe[i] == ticTacToe[i + 4]) && (ticTacToe[i] == ticTacToe[i + 8]) && ticTacToe[i] == 'X') {
                    System.out.println("Payer WON");
                    won=1;
                    break;
                }
                if ((ticTacToe[i] == ticTacToe[i + 4]) && (ticTacToe[i] == ticTacToe[i + 8]) && ticTacToe[i] == 'O') {
                    System.out.println("Computer WON");
                    won=2;
                    break;
                }
            }  if (i == 2) {
                if ((ticTacToe[i] == ticTacToe[i + 2]) && (ticTacToe[i] == ticTacToe[i + 4]) && ticTacToe[i] == 'X') {
                    System.out.println("Player WON");
                    won=1;
                    break;
                }
                if ((ticTacToe[i] == ticTacToe[i + 2]) && (ticTacToe[i] == ticTacToe[i + 4]) && ticTacToe[i] == 'O') {
                    System.out.println("Computer WON");
                    won=2;
                    break;
                }
            }
        }
        System.out.println("value of won : "+won);
        if(won == 0) {
            System.out.println("Game is still on.....");
        }
      return won;
    }

    public static void ComputerTurn() {                   // UC-8
        int k=0,compturn;
        while(k != 1) {
            compturn = rand.nextInt(10);
            if (compturn==0)
            {
                compturn = compturn +1;
            }
            System.out.println("Computer Placed value at " + compturn);
            if (ticTacToe[compturn-1] == ' ') {
                ticTacToe[compturn-1] = 'O';
                k=1;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToeInit();
        int count=0;
        //Toss();
            if (Toss()==0) {
                System.out.println("User won the toss and turn started");
                for (count = 0; count < 9; count++) {
                    //     ChooseValue();
                    ShowBoard();
                    MakeMove();
                    ShowBoard();
                    int Game_won=GameCheck();
                 if( Game_won==1) {
                     System.out.println("Player Won");
                     count=12;
                 }
                 else if(Game_won==2) {
                     System.out.println("Computer Won");
                     count=12;
                 }
                 else {
                     System.out.println("Game is still on...Please continue");
                 }
                    ComputerTurn();
                    Game_won=GameCheck();
                    if( Game_won==1) {
                        System.out.println("Player Won");
                        count=12;
                    }
                    else if(Game_won==2) {
                        System.out.println("Computer Won");
                        count=12;
                    }
                    else {
                        System.out.println("Game is still on...Please continue");
                    }
                    ShowBoard();

                }
            }
            else
                for (count = 0; count < 9; count++) {
                    //     ChooseValue();
                    ShowBoard();
                    ComputerTurn();
                    int Game_won=GameCheck();
                    if( Game_won==1) {
                        System.out.println("Player Won");
                        count=12;
                    }
                    else if(Game_won==2) {
                        System.out.println("Computer Won");
                        count=12;
                    }
                    else {
                        System.out.println("Game is still on...Please continue");
                    }

                    ShowBoard();

                    MakeMove();
                    Game_won=GameCheck();
                    if( Game_won==1) {
                        System.out.println("Player Won");
                        count=12;
                    }
                    else if(Game_won==2) {
                        System.out.println("Computer Won");
                        count=12;
                    }
                    else {
                        System.out.println("Game is still on...Please continue");
                    }
                    ShowBoard();

                }

        }
    }
