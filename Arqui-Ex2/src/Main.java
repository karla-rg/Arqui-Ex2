import clientinterface.ClientInterface;

public class Main {
    public static void main(String[] args) {
        ClientInterface menu = new ClientInterface();
        while (!menu.isDone()) {
            menu.displayOptions();
        }
        System.out.println("♡♥ Gracias por utilizar el Sistema Bancario Alianzza - Vuelve pronto ♡♥");
    }
}
