package banking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Log extends JFrame {

public static void main(String[] args) {
Log frameTabel = new Log();
}

JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JLabel l1=new JLabel("Username");
JLabel l2=new JLabel("Password");
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);

Log(){
super("Login Autentification");
setSize(500,300);
setLocation(500,280);
panel.setLayout (null);

l1.setBounds(70,30,150,20);
l2.setBounds(70,70,150,20);
txuser.setBounds(240,30,150,20);

pass.setBounds(240,70,150,20);
blogin.setBounds(150,110,80,20);

panel.add(l1);
panel.add(txuser);
panel.add(l2);
panel.add(pass);
panel.add(blogin);

getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String puname = txuser.getText();
String ppaswd = pass.getText();
if(puname.equals("test") && ppaswd.equals("12345")) {
WelcomeScreen regFace =new WelcomeScreen();
regFace.setVisible(true);
dispose();
Atm e=new Atm();
try {
	e.display();
} catch (RemoteException | MalformedURLException | NotBoundException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
} else {

JOptionPane.showMessageDialog(null,"Wrong Password / Username");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}

}
});
}
}
