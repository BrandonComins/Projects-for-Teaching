package PiggyBank;

public class PiggyBank {
    int quarters, dimes, nickels, pennies; 

    //Constructor: this is called when you create an object
    public PiggyBank(int q, int d, int n, int p){
        this.quarters = checkValidQuarters(q);
        this.dimes = checkValidDimes(d);
        this.nickels = checkVaidNickels(n);
        this.pennies = checkValidPennies(p);
    }

    //Overloading Constuctor, this will be called instead if you put no parameters
    public PiggyBank(){
        this.quarters = 0;
        this.dimes    = 0;
        this.nickels  = 0;
        this.pennies  = 0;
    }

    public void insertChange(int q, int d, int n, int p){        
        this.quarters += checkValidQuarters(q);
        this.dimes    += checkValidDimes(d);
        this.nickels  += checkVaidNickels(n);
        this.pennies  += checkValidPennies(p);
    }

    public void printTotalAmount(){
        double total = this.quarters * .25 + this.dimes * .1
            + this.nickels * .05 + this.pennies * .01;

        System.out.printf("$%.2f", total);
    }

    public void printCoins(){
        System.out.println("quarters: " + this.quarters);
        System.out.println("dimes: "    + this.dimes);
        System.out.println("nickels: "  + this.nickels);
        System.out.println("pennies: "  + this.pennies);
    }

    private int checkValidQuarters(int q){
        if(q < 0){
            System.out.println("Can't put negative quarters in, Q = 0");
            q = 0;
        }

        return q;
    }

    private int checkValidDimes(int d){
        if (d < 0){
            System.out.println("Can't put negative dimes in, D = 0");
            d = 0;
        }

        return d;
    }

    private int checkVaidNickels(int n){
        if (n < 0){
            System.out.println("Can't put negative nickels in, N = 0");
            n = 0;
        }

        return n;
    }

    private int checkValidPennies(int p){
        if (p < 0){
            System.out.println("Can't have negative pennies, P = 0");
            p = 0;
        }

        return p;
    }
}
