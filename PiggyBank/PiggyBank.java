package PiggyBank;

public class PiggyBank {
    int quarters, dimes, nickels, pennies; 

    //Constructor: this is called when you create an object
    public PiggyBank(int q, int d, int n, int p){
        assert q >= 0 : "can't have negative quarters";
        assert d >= 0 : "can't have negative dimes";
        assert n >= 0 : "can't have negative nickels";
        assert p >= 0 : "can't have negative pennies";
        
        this.quarters = q;
        this.dimes = d;
        this.nickels = n;
        this.pennies = p;
    }

    //Overloading Constuctor, this will be called instead if you put no parameters
    public PiggyBank(){
        this.quarters = 0;
        this.dimes    = 0;
        this.nickels  = 0;
        this.pennies  = 0;
    }

    public void insertChange(int q, int d, int n, int p){
        this.quarters += q;
        this.dimes    += d;
        this.nickels  += n;
        this.pennies  += p;

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
}
