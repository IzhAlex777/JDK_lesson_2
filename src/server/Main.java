package server;

import server.client.ClientController;
import server.client.ClientGUI;
import server.server.RepositoryServerImpl;
import server.server.ServerController;
import server.server.ServerWindow;

public class Main {
    public static void main(String[] args) {

        //создание объектов сервера и создание связи между ними
        ServerWindow serverWindow = new ServerWindow();
        RepositoryServerImpl repositoryServer = new RepositoryServerImpl();
        ServerController serverController = new ServerController();
       // serverController.setServerView(serverWindow);
        serverController.setViewServer(serverWindow);
        serverController.setRepositoryServer(repositoryServer);
       // serverWindow.setServerController(serverController);


        //создание объектов клиента1 и создание связи между ними
        ClientGUI clientGUI1 = new ClientGUI();
        ClientController clientController1 = new ClientController();
        clientController1.setClientView(clientGUI1);
        clientGUI1.setClient(clientController1);
        clientController1.setServerController(serverController);

        //создание объектов клиента2 и создание связи между ними
        ClientGUI clientGUI2 = new ClientGUI();
        ClientController clientController2 = new ClientController();
        clientController2.setClientView(clientGUI2);
        clientGUI2.setClient(clientController2);
        clientController2.setServerController(serverController);
    }
}
