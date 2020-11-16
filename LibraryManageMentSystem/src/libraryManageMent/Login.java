
package libraryManageMent;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Login extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField t1;
	private JLabel l1,l2,l3;
	private JPasswordField p1;
    private JButton b1,b2,b3;
public static void main(String args[]) {
	new Login().setVisible(true);
}
	Login(){
		super("Login");
		setBackground(new Color(169, 169, 169));
		setBounds(325,120,600,450);
		
	panel = new JPanel();
	panel.setLayout(null);
	panel.setBackground(new Color(120,220,255));
	setContentPane(panel);
	
	l1 = new JLabel("Enter User Name:");
	l1.setBounds(110,60,200,100);
	panel.add(l1);
	
	l2 = new JLabel("Enter Password:");
	l2.setBounds(110,100,200,100);
	panel.add(l2);
	
	t1 = new JTextField();
	t1.setBounds(220,95,160,30);
	panel.add(t1);
	
	p1 = new JPasswordField();
	p1.setBounds(220,135,160,30);
	panel.add(p1);
		
	l3 = new JLabel("Trouble in Login :");
	l3.setForeground(Color.red);
	l3.setBounds(110,200,200,100);
	panel.add(l3);
	
	b1 = new JButton("Login");
	b1.addActionListener(this);
	b1.setForeground(Color.GREEN);
	b1.setBackground(new Color(250,240,220));
	b1.setBounds(225,180,68,35);
	panel.add(b1);
	
	b2 = new JButton("SignUp");
	b2.addActionListener(this);
	b2.setForeground(Color.blue);
	b2.setBackground(new Color(250,240,220));
	b2.setBounds(300,180,74,35);
	panel.add(b2);
	

	b3 = new JButton("Forgot Password");
	b3.addActionListener(this);
	b3.setForeground(new Color(250,50,10));
	b3.setBackground(new Color(250,240,220));
	b3.setBounds(230,230,140,40);
	panel.add(b3);
	}
	
	public void actionPerformed(ActionEvent ae){
	
			if(ae.getSource()==b1) {
			try { Conn con = new Conn();
			String sta = "select * from account where username=? and password=?";
            PreparedStatement st = con.c.prepareStatement(sta);

            st.setString(1, t1.getText());
            st.setString(2, p1.getText());

            ResultSet rs = st.executeQuery();
			
            if (rs.next()) {
                this.setVisible(false);
                JOptionPane.showMessageDialog(null, "Successfully logIn");
                dispose();
          Home h = new Home();
          h.setVisible(true);
            } else
	JOptionPane.showMessageDialog(null, "Invalid Login...!");
               
} catch (Exception e2) {
            e2.printStackTrace();
}}
    
    if(ae.getSource() == b2){
        setVisible(false);
SignIn su = new SignIn();
su.setVisible(true);

    }   
    if(ae.getSource() == b3){
        setVisible(false);
Forget forgot = new Forget();
forgot.setVisible(true);
    }
}
    
		
	}
	

