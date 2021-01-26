/**
 * 
 * @authors James McCarter, Kain McDonald, and Sam Ruiz
 * @id MBK897, NZK963, BVL818
 * @assignment Final Project
 * @version 1
 * @date 04/06/2020
 * @purpose To supply the logic and run the connect 4 game
 *
 */

import java.util.Scanner;
import java.util.Arrays;
public class Game {
    
    static char[][] board = new char[6][7];
    static Scanner input = new Scanner(System.in);
    static int turn = 0;
    static boolean inPlay = true;
    
    static Player player1 = new Player();
    static Player player2 = new Player();
    
    public static void main(String[] args) {
        String[] names = new String[2];
        char[] pawns = new char[2];
       
        //Ask for player names and chars
        System.out.print("Enter the name of player 1: ");
        names[0] = input.nextLine();
        pawns[0] = names[0].charAt(0);
        System.out.print("Enter the name of player 2: ");
        names[1] = input.nextLine();
        pawns[1] = names[1].charAt(0);
        
        //Create player object for statistics
        player1.setName(names[0]);
        player2.setName(names[1]);
        player1.setPawn(pawns[0]);
        player2.setPawn(pawns[1]);
        
        clearBoard(board);
        
        // Turns
        while(inPlay==true){
            
            switch(turn){
                // Player 1 turn
                case 0:
                    drop(pawns[turn], board);
                    inPlay = checkWin(pawns[turn], board);
                    if(inPlay==false) {
                        player1.addWin();
                        printBoard(board);
                        System.out.println("Player "+names[turn]+" wins!");
                        System.out.println("Player "+names[0]+" wins: "+player1.getWins());
                        System.out.println("Player "+names[1]+" wins: "+player2.getWins());
                        System.out.println();
                        clearBoard(board);
                        inPlay = playAgain();
                        if(inPlay == false){
                            System.out.println();
                            System.out.println("GOODBYE!");
                        }
                    }
                    turn = 1;
                    break;
                
                // Player 2 turn
                case 1:
                    drop(pawns[turn], board);
                    inPlay = checkWin(pawns[turn], board);
                    if (inPlay==false) {
                        player2.addWin();
                        printBoard(board);
                        System.out.println("Player "+names[turn]+" wins!");
                        System.out.println("Player "+names[0]+" wins: "+player1.getWins());
                        System.out.println("Player "+names[1]+" wins: "+player2.getWins());
                        System.out.println();
                        clearBoard(board);
                        inPlay = playAgain();
                        if(inPlay == false){
                            System.out.println();
                            System.out.println("GOODBYE!");
                        }
                    }
                    turn = 0;
                    break;
                default:
                    break;
            }
            
        }
        
    }
    
    public static boolean playAgain(){
        int j;
        do{
            System.out.println("Would you like to play again?");
            System.out.print("Enter 1 for YES, or 0 for NO: ");
            j = input.nextInt();
            if(j!=0 && j!=1){
            System.out.println("MUST ENTER A 0 OR 1!");
            System.out.println();
            }
        }while(j!=0 && j!=1);
        
        if(j==1){return true;}
        return false;
    }
    
    public static void clearBoard(char[][] grid){
        //Create or clear and Print board
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                board[row][col] = ' ';
            }
        }
        
    }
    
    public static void printBoard(char[][] grid) {
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++){
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++){
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        //System.out.println(player1.getName() + " wins: " + player1.getWins());
        //System.out.println(player2.getName() + " wins: " + player2.getWins());
        System.out.println();
    }
    
    public static void drop(char player, char[][] grid) {
        boolean validPlay = false;
        int play;
        do {
            printBoard(grid);

            System.out.print("Player " + player + ", choose a column: ");
            play = input.nextInt();
                        
            //validate play
            if(play>=0 && play < board[0].length){
                // full colum check
                if(grid[0][play] != ' '){
                    System.out.println("Column "+play+" is full. Choose another column.");
                } else {
                    validPlay = true;
                }
            } else {
                System.out.println("Must enter column 0-6!");
            }

        }while (validPlay == false);

        //drop the checker
        for (int row = grid.length-1; row >= 0; row--){
            if(grid[row][play] == ' '){
                grid[row][play] = player;
                break;
            }
        }
    }
    
    public static boolean checkWin(char player, char[][] grid){
        //check for 4 horizontal
        for(int row = 0; row<grid.length; row++){
            for (int col = 0;col < grid[0].length - 3;col++){
                if (grid[row][col] == player   && 
                    grid[row][col+1] == player &&
                    grid[row][col+2] == player &&
                    grid[row][col+3] == player){
                    return false;
                }
            }           
        }
        //check for 4 vertical
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == player   && 
                    grid[row+1][col] == player &&
                    grid[row+2][col] == player &&
                    grid[row+3][col] == player){
                    return false;
                }
            }
        }
        //check upward diagonal
        for(int row = 3; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   && 
                    grid[row-1][col+1] == player &&
                    grid[row-2][col+2] == player &&
                    grid[row-3][col+3] == player){
                    return false;
                }
            }
        }
        //check downward diagonal
        for(int row = 0; row < grid.length - 3; row++){
            for(int col = 0; col < grid[0].length - 3; col++){
                if (grid[row][col] == player   && 
                    grid[row+1][col+1] == player &&
                    grid[row+2][col+2] == player &&
                    grid[row+3][col+3] == player){
                    return false;
                }
            }
        }
        return true;
    }
    
    
}
