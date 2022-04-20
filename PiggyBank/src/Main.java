package PiggyBank;


public class Main{
    public static void main(String[] args){
        PiggyBank my_bank = new PiggyBank();

        
        my_bank.insertChange(-5, 5, 5, 5);
        my_bank.printCoins();
        my_bank.printTotalAmount();
    }
}