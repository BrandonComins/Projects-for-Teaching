package PiggyBank;


public class Main{
    public static void main(String[] args){
        PiggyBank my_bank = new PiggyBank(5, 5, 5,5);
        PiggyBank other_bank = new PiggyBank();

        System.out.println("Before Operations: \n");

        System.out.println("My bank:");
        my_bank.printCoins();
        my_bank.printTotalAmount();

        System.out.println("Other Bank");
        other_bank.insertChange(10, 10, 10, 10);
        other_bank.printCoins();
        other_bank.printTotalAmount();

        System.out.println("After Operations: \n");
        
        System.out.println("My bank:");
        my_bank.insertChange(-5, -5, 5, 5);
        my_bank.printCoins();
        my_bank.printTotalAmount();

        System.out.println("Other Bank");
        other_bank.removeExactMoney(2.37);
        other_bank.printCoins();
        other_bank.printTotalAmount();


        my_bank.combineBanks(other_bank);
        my_bank.removeExactMoney(1000);
    }
}