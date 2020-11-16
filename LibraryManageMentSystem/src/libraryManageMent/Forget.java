package libraryManageMent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Forget extends JFrame{
	private JPanel panel;
	private JTextField t1,t2,t3,t4,t5;
	private JLabel l1,l2,l3,l4,l5;
	private JPasswordField p1;
    private JButton b1,b2,b3;
    
    Forget(){
	super("SignUp page");
	setBounds(325,120,600,450);
	
panel = new JPanel();
panel.setLayout(null);
panel.setBackground(Color.white);
setContentPane(panel);

l1 = new JLabel("Enter UserName:");
l1.setBounds(110,60,200,100);
panel.add(l1);

l2 = new JLabel("Name:");
l2.setBounds(110,100,200,100);
panel.add(l2);

l3 = new JLabel("Security Question:");
l3.setBounds(110,140,200,100);
panel.add(l3);

l4 = new JLabel("Answer:");
l4.setBounds(110,180,200,100);
panel.add(l4);

l5 = new JLabel("Password:");
l5.setBounds(110,220,200,100);
panel.add(l5);


t1 = new JTextField();
t1.setBounds(230,95,100,30);
panel.add(t1);

t2 = new JTextField();
t2.setEditable(false);
t2.setBounds(230,135,160,30);
panel.add(t2);

t3 = new JTextField();
t3.setEditable(false);
t3.setBounds(230,175,160,30);
panel.add(t3);

t4 = new JTextField();
t4.setBounds(230,215,120,30);
panel.add(t4);

t5 = new JTextField();
t5.setEditable(false);
t5.setBounds(230,255,160,30);
panel.add(t5);

b1 = new JButton("Search");
//b1.addActionListener(this);
b1.setBounds(340, 95, 75, 30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
panel.add(b1);

b2 = new JButton("Retrive");
b2.setBounds(364, 215, 75, 30);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
panel.add(b2);

b3 = new JButton("Back");
b3.setBounds(235, 310, 106, 27);
b3.setBackground(Color.BLACK);
b3.setForeground(Color.WHITE);
panel.add(b3);

b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String o=t1.getText();
		try {
			Conn con = new Conn();
		    String a = "Select Name,Sec_q from account where userName='"+o+"'";
		    ResultSet rs = con.s.executeQuery(a);	
        	if(rs.next()) {
          t2.setText(rs.getString("Name"));
          t3.setText(rs.getString("Sec_q"));
          
        	}
        	else {
        		 JOptionPane.showMessageDialog(null,"Wrong UserId..!");
        	}
	}  catch(Exception ae){
		ae.fillInStackTrace();
	}
 }
});

b2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String o=t4.getText();
		try {
			Conn con = new Conn();
		    String a = "Select password from account where Seq_a='"+o+"'";
		    ResultSet rs = con.s.executeQuery(a);	
        	if(rs.next()) {
          t5.setText(rs.getString("password"));

        	}
        	else {
        		 JOptionPane.showMessageDialog(null, "Wrong Answer..!");
        	}
		
	}  catch(Exception ae){
		ae.fillInStackTrace();
	}
 }
});

b3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		try {
			dispose();
          new Login().setVisible(true);
		
	}  catch(Exception ae){
		ae.fillInStackTrace();
	}
 }
});
}

    public static void main(String args[]) {
    	new Forget().setVisible(true);
    }
}