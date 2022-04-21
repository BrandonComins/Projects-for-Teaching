public class Player {
    public char symbol;
    public String name;
    public String color;

    public Player(String name, char symbol){
        this.name = name;
        this.color = Colors.WHITE;
        this.symbol = symbol;
    }

    public void changeSymbol(char symbol){
        this.symbol = symbol;
    }

    public void changeName(String name){
        this.name = name;
    }

    public void changeColor(String color){
        this.color = color;
    }
}
