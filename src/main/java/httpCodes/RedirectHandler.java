package httpCodes;

public class RedirectHandler implements HttpCodeHandler {
    public void handle(){
        System.out.println("Redirect message!");
    }
}
