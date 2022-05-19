import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
        
        Player player_1 = new Player("Brandon", 'x');
        Player player_2 = new Player("Joey", 'O');
        
        Scanner input = new Scanner(System.in);
        
        while(true){
            try{
                int user_input = printMainMenu(input);
                if(user_input == 1){ // Play game
                    playHumanGame(player_1, player_2, input);
                }
                else if(user_input == 2){
                    playAIGame(player_1, player_2, input);

                }
                else if (user_input == 3){ // options
                    System.out.println("\nSelect a Player: ");
                    System.out.println("1. " + player_1.name);
                    System.out.println("2. " + player_2.name);
                    System.out.println("3. Back");
                    
                    System.out.print("\nYour input: ");
                    user_input = input.nextInt();
                    
                    if(user_input == 1){
                        printOptions(input, player_1);
                    }
                    else if(user_input == 2){
                        printOptions(input, player_2);
                    }
                    else if(user_input == 3){
                        continue;
                    }else{
                        throw new InputMismatchException();
                    }
                }
                else if (user_input == 4){ // Exit
                    break;
                }else{
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException e){
                System.out.println("Sorry invalid input\n");
                input.nextLine(); // This line prevents infinite loop
                continue;
            }
        }
        input.close();
    }

    public static int printMainMenu(Scanner input){
        System.out.println("\nMain Menu: ");
        System.out.println("1. Play Human Game");
        System.out.println("2. Play AI Game");
        System.out.println("3. Options");
        System.out.println("4. Exit");

        System.out.print('\n' + "Your input: ");
        return input.nextInt();
    }

    public static void printColorMenu(Scanner input, Player player){
        System.out.println("1. White");
        System.out.println(Colors.RED    + "2. Red"    + Colors.WHITE);
        System.out.println(Colors.GREEN  + "3. Green"  + Colors.WHITE);
        System.out.println(Colors.YELLOW + "4. Yellow" + Colors.WHITE);
        System.out.println(Colors.BLUE   + "5. Blue"   + Colors.WHITE);
        System.out.println(Colors.PURPLE + "6. Purple" + Colors.WHITE);
        System.out.println(Colors.CYAN   + "7. CYAN"   + Colors.WHITE);

        System.out.print("Your input: ");
        int user_input = input.nextInt();

        if(user_input == 1){
            player.changeColor(Colors.WHITE);
        }
        else if(user_input == 2){
            player.changeColor(Colors.RED);
        }
        else if(user_input == 3){
            player.changeColor(Colors.GREEN);
        }
        else if(user_input == 4){
            player.changeColor(Colors.YELLOW);
        }
        else if(user_input == 5){
            player.changeColor(Colors.BLUE);
        }
        else if(user_input == 6){
            player.changeColor(Colors.PURPLE);
        }
        else if(user_input == 7){
            player.changeColor(Colors.CYAN);
        }else{
            throw new InputMismatchException();
        }
    }

    public static void printOptions(Scanner input, Player player){
        System.out.println("\nOptions: ");
        System.out.println("1. Change name");
        System.out.println("2. Change symbol");
        System.out.println("3. Change color");
        System.out.println("4. Main Menu");

        System.out.print("\nYour input: ");
        int user_input = input.nextInt();

        if(user_input == 1){
            System.out.print("\nNew name: ");
            player.changeName(input.next());
        }
        else if(user_input == 2){
            System.out.print("\nNew Symbol: ");
            player.changeSymbol(input.next().charAt(0));
        }

        else if(user_input == 3){
            printColorMenu(input, player);
        }
        else if(user_input == 4){
            System.out.println(); //Goes back to main menu
        }else{
            throw new InputMismatchException();
        }
    }

    public static void playHumanGame(Player player_1, Player player_2, Scanner input){
        GameBoard board = new GameBoard(player_1, player_2);
        while(true){
            board.printBoard();
            
            if(board.takeHumanTurn(player_1, input)){
                break;
            }
            
            if(board.takeHumanTurn(player_2, input)){
                break;
            }
        }
        
    }

    public static void playAIGame(Player player_1, Player player_2, Scanner input){
        GameBoard board = new GameBoard(player_1, player_2);
        while(true){
            board.printBoard();
            
            if(board.takeHumanTurn(player_1, input)){
                break;
            }
            
            if(board.takeAITurn(player_2)){
                break;
            }
        }
    }
}
