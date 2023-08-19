import org.dreambot.api.methods.container.impl.Inventory;

public class Banking extends Node{
    @Override
    public boolean validate(){
        return Inventory.isFull();
    }

    @Override
    public void execute(){

    }
}
