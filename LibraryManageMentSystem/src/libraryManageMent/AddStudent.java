package libraryManageMent;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class AddStudent extends JFrame {
	private JPanel panel,panel2;
	private JLabel l1,l2,l3,l4,l5,l6,l7;
	private JTextField t1,t2,t3;
	private JButton b1,b2;
	private JComboBox cb1,cb2,cb3,cb4;
	private String[] course = {"B.E","B.Tech","B.C.A","B.B.A","B.S.C","M.Tech","M.S.C","M.C.A","M.B.A"};
	private String[] sem = {"1st","2nd","3rd","4th","5th","6th","7th","8th"};
	private String[] Brnch = {"Mechanical","CSE","IT","AutoMobie","EEE","Other"};
	private String[] Year = {"First","Second","Third","Fourth"};

    public void random() {
        Random rd = new Random();
	t1.setText("" + rd.nextInt(10000 + 1));
    }

    public AddStudent() {
    	super("Add Student");
		setBounds(325,120,600,500);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		setContentPane(panel);
		
		l1 = new JLabel("Student Id :");
		l1.setBounds(110,60,200,100);
		panel.add(l1);
		
		l2 = new JLabel("Name :");
		l2.setBounds(110,100,200,100);
		panel.add(l2);
		
		l3 = new JLabel("Father's Name :");
		l3.setBounds(110,140,200,100);
		panel.add(l3);
		
		l4 = new JLabel("Course :");
		l4.setBounds(110,180,200,100);
		panel.add(l4);
		
		l5 = new JLabel("Branch :");
		l5.setBounds(110,220,200,100);
		panel.add(l5);
		
		l6 = new JLabel("Year :");
		l6.setBounds(110,260,200,100);
		panel.add(l6);
		
		l7 = new JLabel("Semester :");
		l7.setBounds(110,300,200,100);
		panel.add(l7);
		
		t1 = new JTextField();
		t1.setEditable(false);
		t1.setBounds(210,95,150,30);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setBounds(210,135,150,30);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setBounds(210,175,150,30);
		panel.add(t3);
		
		cb1 = new JComboBox(course);
		cb1.setBounds(175,215,200,30);
		cb1.setEditable(true);
		panel.add(cb1);

		cb2 = new JComboBox(Brnch);
		cb2.setBounds(175,255,200,30);
		cb2.setEditable(true);
		panel.add(cb2);		

		cb3 = new JComboBox(Year);
		cb3.setBounds(175,295,200,30);
		cb3.setEditable(true);
		panel.add(cb3);
		
		cb4 = new JComboBox(sem);
		cb4.setBounds(175,335,200,30);
		cb4.setEditable(true);
		panel.add(cb4);
		

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
		panel2.setBorder(new TitledBorder(new LineBorder(new Color(100, 180, 250), 2), "Add Books", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel2.setBounds(50, 69, 418, 364);
		panel.add(panel2);
    
    b1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		String in1=t1.getText();
		String in2=t2.getText();
		String in3=t3.getText();
		String in4=(String) cb1.getSelectedItem();
		String in5=(String) cb2.getSelectedItem();
		String in6=(String) cb3.getSelectedItem();
		String in7=(String) cb4.getSelectedItem();
	try {
		Conn con = new Conn();
	String sta = "insert into student values('"+in1+"', '"+in2+"', '"+in3+"','"+in4+"', '"+in5+"','"+in6+"','"+in7+"')";
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

public static void main(String args[] ){
	new AddStudent().setVisible(true);
	}
}

