

package libraryManageMent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignIn extends JFrame {
	private JPanel panel;
	private JTextField t1,t2,t3,t5;
	private JLabel l1,l2,l3,l4,l5;
	private JPasswordField p1;
    private JButton b1,b2;
    private JComboBox s_question;
    private String[] Secury_q = {"What is your lucky Number?","What is your favourite movie?",
			 "What was your childhood Name?", "what is your hobby?",};
	SignIn(){
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
	
	l3 = new JLabel("Password:");
	l3.setBounds(110,140,200,100);
	panel.add(l3);
	
	l4 = new JLabel("Security Question:");
	l4.setBounds(110,180,200,100);
	panel.add(l4);
	
	l5 = new JLabel("Answer:");
	l5.setBounds(110,220,200,100);
	panel.add(l5);
	
	t1 = new JTextField();
	t1.setBounds(230,95,200,30);
	panel.add(t1);
	
	t2 = new JTextField();
	t2.setBounds(230,135,200,30);
	panel.add(t2);
	
	t3 = new JTextField();
	t3.setBounds(230,175,200,30);
	panel.add(t3);
	
	s_question = new JComboBox(Secury_q);
	s_question.setBounds(230,216,250,30);
	s_question.setEditable(true);
	panel.add(s_question);
	
	t5 = new JTextField();
	t5.setBounds(230,255,200,30);
	panel.add(t5);
	
	b1 = new JButton("SignUp");
	b1.setBounds(235, 299, 80, 30);
    b1.setBackground(Color.BLACK);
    b1.setForeground(Color.WHITE);
	panel.add(b1);
	
	b2 = new JButton("Back");
	b2.setBounds(335, 299, 80, 30);
    b2.setBackground(Color.BLACK);
    b2.setForeground(Color.WHITE);
	panel.add(b2);

	b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent ae){		
			String in1=t1.getText();
			String in2=t2.getText();
			String in3=t3.getText();
			String in4= (String) s_question.getSelectedItem();
			String in5=t5.getText();
		try {
			Conn con = new Conn();
		String sta = "insert into account values('"+in1+"', '"+in2+"', '"+in3+"','"+in4+"', '"+in5+"')";
        con.s.executeUpdate(sta);
        JOptionPane.showMessageDialog(null, "Successfully SighnUp");  
        setVisible(false);
        new Login().setVisible(true);
		} catch (Exception e2) {
        e2.printStackTrace();
		}
	}
	});
	b2.addActionListener(new ActionListener() {
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
		new SignIn().setVisible(true);
	}
}