package server.server;

import server.client.ClientGUI;

public interface ViewServer {
    void showMessage(String text);
    void disconnectUser(ClientGUI clientGUI);
    boolean connectUser(ClientGUI clientGUI);

}
