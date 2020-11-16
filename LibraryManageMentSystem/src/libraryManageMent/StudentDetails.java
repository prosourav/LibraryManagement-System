package libraryManageMent;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class StudentDetails extends JFrame{
	 private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	 private JButton bg,bg1;
	 private Container c;
	 private JPanel panel;
	 private Font f,h;
	 private JTable table;

	 StudentDetails(){
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//(JFrame.DISPOSE_ON_CLOSE
		this.setBounds(285,70,720,580);
		this.setTitle("Students");
		c = this.getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);
		h = new Font("Arial",Font.BOLD,20);
		f = new Font("Arial",Font.BOLD,16);
		
		l1 = new JLabel("Student Details");
    	l1.setBounds(270,35,200,50);
    	l1.setFont(h);
    	c.add(l1);
		
		bg = new JButton("Show");
		bg.setForeground(Color.white);
		bg.setBackground(Color.black);
    	bg.setBounds(265,405,80,50);
    	bg.setFont(f);
    	c.add(bg);
    	
    	
    	bg1 = new JButton("Back");
    	bg1.setForeground(Color.white);
    	bg1.setBackground(Color.black);
    	bg1.setBounds(365,405,80,50);
    	bg1.setFont(f);
    	c.add(bg1);
    	
        table = new JTable();
        table.setBackground(Color.white);
        table.setForeground(Color.blue);
	    table.setBounds(75, 100, 530, 300);
        
        JScrollPane pane = new JScrollPane(table);
	    pane.setBounds(75, 100, 530, 300);
        pane.setBackground(Color.black);
        add(pane);
        
        JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 13, 26), 2), "Books Available", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(50, 69, 580, 404);
		c.add(panel);
        
        bg1.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				try {
  					dispose(); 				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
	
    	  bg.addActionListener(new ActionListener() {
  			public void actionPerformed(ActionEvent e) {
  				try {
  					
  					Conn c1=new Conn();
  					
  					String str="SELECT * FROM student";
  					ResultSet rs=c1.s.executeQuery(str);
  					table.setModel(DbUtils.resultSetToTableModel(rs));
  				
  			}  catch(Exception ae){
  				ae.fillInStackTrace();
  			}
  		 }
  		});
  	    
		
}
public static void main(String args[]) {
	StudentDetails a = new StudentDetails();
	a.setVisible(true);	
}
}



