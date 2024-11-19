package server.server;

import server.client.ClientController;
import server.client.ClientGUI;

public class ServerController  {

    private ViewServer viewServer;
    private RepositoryServer repositoryServer;

    public void setViewServer(ViewServer viewServer) {
        this.viewServer = viewServer;
    }

    public void setRepositoryServer(RepositoryServer repositoryServer) {
        this.repositoryServer = repositoryServer;
    }

    public boolean connectUser(ClientController clientController) {
        return viewServer.connectUser(clientController.getClientView());
    }

    public String getHistory() {
        return repositoryServer.getLog();
    }

//    public void setServerView(ServerWindow serverWindow) {
//
//    }

    public void disconnectUser(ClientController clientController) {

    }

    public void message(String text) {
        viewServer.showMessage(text);
        repositoryServer.saveInLog(text);
    }
}
