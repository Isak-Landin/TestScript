public class Cooking extends Node{
    @Override
    public boolean validate(){
        boolean toReturn = true;
        return Inventory.isFull();
    }

    @Override
    public void execute(){

    }
}