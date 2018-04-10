package handler;

public class ErrHandler extends ActionHandler{
    public void run(String message){
        System.out.println("Running ERR command handler: " + message);
    }
}
