import java.util.Scanner;

public class GameBoard {
    private Player player_1, player_2;
    private String[][] board = {{" ", " ", " "},
                                {" ", " ", " "},
                                {" ", " ", " "}};
    
    public GameBoard(Player player_1, Player player_2){
        this.player_1 = player_1;
        this.player_2 = player_2;
    }

    private void resetBoard(){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                this.board[i][j] = " ";
            }
        } 
    }

    public void printBoard(){
        System.out.println();

        for(int i = 0; i < 3; ++i){
            System.out.print(i + " ");
            for(int j = 0; j < 3; ++j){
                System.out.print(this.board[i][j]);
                if(j != 2){
                    System.out.print("|");
                }
            }
            if(i != 2){
                System.out.println("\n  -+-+-");
            }
        }
        System.out.println("\n\n  A B C");
        System.out.println();
    }

    public void takeTurn(Scanner input){
        input.nextLine();
    }
}
