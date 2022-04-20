
import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char operator;
        double num_1 = 0, num_2;

        while(true){
            //Getting input for operator
            operator = getOperator(input);

            //Exit program if input on operator is 'x'
            if(operator == 'x' || operator == 'X'){
                System.out.println("GoodBye!");
                break;
            }
            else if (
                   operator != '+' 
                && operator != '-'
                && operator != '/'
                && operator != '%'
                && operator != '*'
                && operator != '^'){
                    
                    System.out.println("Sorry invalid input, please try again" + '\n');    
                    continue;
            }

            //Getting input for numbers
            try{
                num_1 = getNumber(input, "first");
                num_2 = getNumber(input, "second");
            } catch(InputMismatchException e){
                System.out.println("input must be a number");
                continue;
            }
            
            //Handling what to do
            if(operator == '+') {
                print(add(num_1, num_2));
            }
            else if(operator == '-'){
                print(subtract(num_1, num_2));
            }
            else if(operator == '*'){
                print(multiply(num_1, num_2));
            }
            else if(operator == '/'){
                print(divide(num_1, num_2));
            }
            else if(operator == '%'){
                print(modulus(num_1, num_2));
            }else{
                print(Math.pow(num_1, num_2));
            }
        }
        input.close();
    }

    public static double add(double a, double b){
        return a + b;
    }

    public static double subtract(double a, double b){
        return a - b;
    }

    public static double multiply(double a, double b){
        return a * b;
    }

    public static double divide(double a, double b){
        return a / b;
    }

    public static double modulus(double a, double b){
        return a % b;
    }

    public static double abs(double a){     
        return a > 0 ? a : -a;
        /*codition ? true value : false value */ 
    }

    public static double getNumber(Scanner input, String message){
        System.out.print("Enter the " + message + " number: ");

        return input.nextDouble();
    }
     
    public static char getOperator(Scanner input){
        System.out.print("Enter an operator: ");
        
        return input.next().charAt(0);
    }

    public static void print(double value){
        System.out.println('\n' + "Result: " + value + '\n');
    }
}
