package libraryManageMent;

import java.awt.Color;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Addbook extends JFrame {
	private JPanel panel,panel2;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1,t2,t3,t4,t6,t7;
	private JButton b1,b2,b3;
	private JComboBox cb;
	private String[] edtions = {"1st","2nd","3rd","4th","5th","6th"};
	    	
	 public void random() {
	        Random rd = new Random();
	        System.out.println(rd);
		t1.setText("" + rd.nextInt(1000 + 1));
	    }
	 
	Addbook(){
		super("Add Book");
		setBounds(325,120,600,500);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		setContentPane(panel);
		
		l1 = new JLabel("Book Id:");
		l1.setBounds(110,60,200,100);
		panel.add(l1);
		
		l2 = new JLabel("Name:");
		l2.setBounds(110,100,200,100);
		panel.add(l2);
		
		l3 = new JLabel("ISBN:");
		l3.setBounds(110,140,200,100);
		panel.add(l3);
		
		l4 = new JLabel("Publisher:");
		l4.setBounds(110,180,200,100);
		panel.add(l4);
		
		l5 = new JLabel("Edition:");
		l5.setBounds(110,220,200,100);
		panel.add(l5);
		
		l6 = new JLabel("Price:");
		l6.setBounds(110,260,200,100);
		panel.add(l6);
		
		l7 = new JLabel("Pages:");
		l7.setBounds(110,300,200,100);
		panel.add(l7);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(175,95,200,30);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(175,135,200,30);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(175,175,200,30);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(175,215,200,30);
		panel.add(t4);
		
		cb = new JComboBox(edtions);
		cb.setBounds(175,255,250,30);
		cb.setEditable(true);
		panel.add(cb);
		
		t6 = new JTextField();
		t6.setBounds(175,295,200,30);
		panel.add(t6);
		
		t7 = new JTextField();
		t7.setBounds(175,335,200,30);
		panel.add(t7);
		
		b1 = new JButton("Add");
		b1.setBounds(180, 380, 80, 30);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		panel.add(b1);
		
		b2 = new JButton("Back");
		b2.setBounds(280, 380, 80, 30);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		panel.add(b2);
		
		random();
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.white);
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(250, 13, 26), 2), "Add Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel2.setBounds(50, 69, 418, 364);
		panel.add(panel2);
	
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
					String in1=t1.getText();
					String in2=t2.getText();
					String in3=t3.getText();
					String in4=t4.getText();
					String in5=(String) cb.getSelectedItem();
					String in6=t6.getText();
					String in7=t7.getText();
				try {
					Conn con = new Conn();
				String sta = "insert into book values('"+in1+"', '"+in2+"', '"+in3+"','"+in4+"', '"+in5+"','"+in6+"','"+in7+"')";
		        con.s.executeUpdate(sta);
		        JOptionPane.showMessageDialog(null, "Successfully Added");  
		        setVisible(false);
				} catch (Exception e2) {
		        e2.printStackTrace();
				}
			}
			});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					dispose();
				
			}  catch(Exception ae){
				ae.fillInStackTrace();
			}
		 }
		});
		
	}	
	public static void main(String ags[]) {
	  new Addbook().setVisible(true);
	}
		
	}