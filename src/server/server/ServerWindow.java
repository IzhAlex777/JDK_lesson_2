package server.server;


import server.client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

//класс требуется разделить на GUI, controller и repository (смотри схему проекта)
public class ServerWindow extends JFrame implements ViewServer{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    List<ClientGUI> clientGUIList;

    JButton btnStart, btnStop;
    JTextArea log;
    boolean work;

    public ServerWindow(){
        clientGUIList = new ArrayList<>();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat server");
        setLocationRelativeTo(null);

        createPanel();

        setVisible(true);
    }
    @Override
    public boolean connectUser(ClientGUI clientGUI){
        if (!work){
            return false;
        }
        clientGUIList.add(clientGUI);
        return true;
    }

    @Override
    public void disconnectUser(ClientGUI clientGUI){
        clientGUIList.remove(clientGUI);
        if (clientGUI != null){
            clientGUI.disconnectedFromServer();
        }
    }
    @Override
    public void showMessage(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
       // saveInLog(String text)
    }

    private void answerAll(String text){
        for (ClientGUI clientGUI: clientGUIList){
            clientGUI.answer(text);
        }
    }

    private void appendLog(String text){
        log.append(text + "\n");
    }

    private void createPanel() {
        log = new JTextArea();
        add(log);
        add(createButtons(), BorderLayout.SOUTH);
    }

    private Component createButtons() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (work){
                    appendLog("Сервер уже был запущен");
                } else {
                    work = true;
                    appendLog("Сервер запущен!");
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!work){
                    appendLog("Сервер уже был остановлен");
                } else {
                    work = false;
                    while (!clientGUIList.isEmpty()){
                        disconnectUser(clientGUIList.get(clientGUIList.size()-1));
                    }
                    appendLog("Сервер остановлен!");
                }
            }
        });

        panel.add(btnStart);
        panel.add(btnStop);
        return panel;
    }

//    public  void setServerController(ServerController serverController){
//
//    };
}
