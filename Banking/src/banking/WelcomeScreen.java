package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class WelcomeScreen extends JFrame {

public static void main(String[] args) {
WelcomeScreen frameTabel = new WelcomeScreen();
}

JLabel welcome = new JLabel("Welcome User!");
JPanel panel = new JPanel();

WelcomeScreen(){
super("Welcome User!");
setSize(300,200);
setLocation(500,280);
panel.setLayout (null);

welcome.setBounds(70,50,150,60);

panel.add(welcome);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}

}