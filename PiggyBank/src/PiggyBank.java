

public class PiggyBank {
    private int quarters, dimes, nickels, pennies; 

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

    public void combineBanks(PiggyBank right){
        this.quarters += right.quarters;
        this.dimes += right.dimes;
        this.nickels += right.nickels;
        this.pennies += right.pennies;

        right.quarters = 0;
        right.dimes = 0;
        right.nickels = 0;
        right.pennies = 0;
    }

    /*Bonus points if you can do this function recursively, 
    but I haven't taught it at this point */
    public void removeExactMoney(double money){ 
        int num_quarters = 0, num_dimes = 0, num_nickels = 0, num_pennies = 0;
        double initial_money = money;
        

        //Ask me why or look up I need round for comparing doubles
        while(Math.round(money * 100.0) / 100.0 != 0.00){
            if(this.quarters > 0 && money >= .25){
                this.quarters -= 1;
                money -= .25;
                ++num_quarters;
                continue;
            }
            else if(this.dimes > 0 && money >= .1){
                this.dimes -= 1;
                money -= .1;
                ++num_dimes;
                continue;
            }
            else if (this.nickels > 0 && money >= .05){
                this.nickels -= 1;
                money -= .05;
                ++num_nickels;
                continue;
            }
            else if (this.pennies > 0 && money >= .01){
                this.pennies -= 1;
                money -= .01;
                ++num_pennies;
                continue;
            }else{
                insertChange(num_quarters, num_dimes, num_nickels, num_pennies);
                System.out.printf("Not enough money in bank to pay: $%.2f \n",
                                    initial_money);
                System.out.print("Current change: ");
                printTotalAmount();
                break;
            }
        }
    }

    public void printTotalAmount(){
        double total = this.quarters * .25 + this.dimes * .1
            + this.nickels * .05 + this.pennies * .01;

        System.out.printf("$%.2f", total);
        System.out.println('\n');
    }

    public void printCoins(){
        System.out.println("Quarters: " + this.quarters);
        System.out.println("Dimes: "    + this.dimes);
        System.out.println("Nickels: "  + this.nickels);
        System.out.println("Pennies: "  + this.pennies);
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
