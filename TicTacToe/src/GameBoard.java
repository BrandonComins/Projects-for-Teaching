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

    private boolean checkTie(){
        for(int i = 0; i < 3; ++i){
            for(int j = 0; j < 3; ++j){
                if(board[i][j] == " "){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkWin(){
        return winRows() || winColunms()  ||  winDiagnols();
    }

    private boolean winRows(){
        for(int i = 0; i < 3; ++i){
            if(board[i][0].equals(board[i][1]) 
                && board[i][1].equals(board[i][2]) 
                && !board[i][0].equals(" ")){
                return true;
            }
        }
        return false;
    }

    private boolean winColunms(){
        for(int i = 0; i < 3; ++i){
            if(board[0][i].equals(board[1][i]) 
                && board[1][i].equals(board[2][i]) 
                && !board[0][i].equals(" ")){
                return true;
            }
        }
        return false;
    }

    private boolean winDiagnols(){
        boolean left = (board[0][0].equals(board[1][1]) 
                            && board[1][1].equals(board[2][2])
                            && !board[0][0].equals(" "));
        boolean right = (board[0][2].equals(board[1][1]) 
                            && board[1][1].equals(board[2][0])
                            && !board[0][2].equals(" "));
        return left || right;
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

    public boolean takeTurn(Player player, Scanner player_input){
        char row;
        char colunm;

        while(true){
            System.out.print(player.name + " input: ");
            String userInput = player_input.next();
            row = userInput.charAt(1);
            colunm = userInput.charAt(0);
            if(colunm == 'A' || colunm == 'B' || colunm == 'C'){
                if(row == '0' || row == '1' || row == '2'){
                    int c = colunm - 65;
                    int r = Character.getNumericValue(row);
                    if(board[r][c] == " "){
                        board[r][c] = player.color + player.symbol + Colors.WHITE;
                    } else {
                        System.out.println("Spot alreay Taken!");
                        row = '\0';
                        colunm = '\0';
                        continue;
                    }
                    
                    printBoard();
                    if (checkWin()){
                        System.out.println(player.name + " wins!");
                        resetBoard();
                        return true;
                    }
                    else if(checkTie()){
                        System.out.println("Tie game!");
                        resetBoard();
                        return true;
                    }
                }else{
                    System.out.println("Sorry invalid input");
                    row = '\0';
                    colunm = '\0';
                    continue;
                }
                break;
            }
        }
        return false;
    }
}
