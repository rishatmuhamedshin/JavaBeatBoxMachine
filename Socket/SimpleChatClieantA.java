package LearnJavaKatyBert.Socket;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class SimpleChatClieantA {

    JTextField outgoing;
    PrintWriter writer;
    Socket socket;

    public static void main(String[] args) {
        SimpleChatClieantA simpleChatClieantA = new SimpleChatClieantA();
        simpleChatClieantA.go();
    }


    public void go(){
        JFrame f = new JFrame("Ludicrosly Simple Chat Client");
        JPanel jPanel = new JPanel();
        outgoing = new JTextField();
        JButton jButton = new JButton("send");

        jButton.addActionListener(new SendButtonListener());

        jPanel.add(jButton);
        jPanel.add(outgoing);
        f.getContentPane().add(BorderLayout.CENTER,jPanel);
        setUpNetWorking();

        //f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(400,500);
        f.setVisible(true);
    }

    private void setUpNetWorking() {
        try{
            socket = new Socket("127.0.0.1",5000);
            writer = new PrintWriter(socket.getOutputStream());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    class SendButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                writer.println(outgoing.getText());
                writer.flush();
            }catch (Exception exception){
                exception.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    }
}
