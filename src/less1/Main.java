package less1;


public class Main {
    public static void main(String[] args) {

        ServerWindowGUI serverWindow = new ServerWindowGUI();
        new ClientGUILess1(serverWindow);
        new ClientGUILess1(serverWindow);
    }
}
