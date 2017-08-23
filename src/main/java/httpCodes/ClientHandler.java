package httpCodes;

public class ClientHandler implements HttpCodeHandler {
    public void handle(){
        System.out.println("Client Error message!");
    }
}
