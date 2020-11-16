package libraryManageMent;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;






public class IssueBook extends JFrame {
	private JPanel panel,panel2,panel3;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
	private JButton b1,b2,b3,b4;
	private JDateChooser dateChooser;
	IssueBook(){
		super("Issue Book");
		setBounds(100,100,880,500);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		setContentPane(panel);
		//Books
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
		t1.setBounds(175,95,85,30);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(175,135,200,30);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(175,175,200,30);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(175,215,200,30);
		t4.setEditable(false);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(175,255,200,30);
		t5.setEditable(false);
		panel.add(t5);
		
		t6 = new JTextField();
		t6.setBounds(175,295,200,30);
		t6.setEditable(false);
		panel.add(t6);
		
		t7 = new JTextField();
		t7.setEditable(false);
		t7.setBounds(175,335,200,30);
		panel.add(t7);
		
		//Students
		
		l8 = new JLabel("Student Id :");
		l8.setBounds(500,60,200,100);
		panel.add(l8);
		
		l9 = new JLabel("Name :");
		l9.setBounds(500,100,200,100);
		panel.add(l9);
		
		l10 = new JLabel("Father's Name :");
		l10.setBounds(500,140,200,100);
		panel.add(l10);
		
		l11 = new JLabel("Course :");
		l11.setBounds(500,180,200,100);
		panel.add(l11);
		
		l12 = new JLabel("Branch :");
		l12.setBounds(500,220,200,100);
		panel.add(l12);
		
		l13 = new JLabel("Year :");
		l13.setBounds(500,260,200,100);
		panel.add(l13);
		
		l14 = new JLabel("Semester :");
		l14.setBounds(500,300,200,100);
		panel.add(l14);
		
		t8 = new JTextField();
		t8.setBounds(595,95,85,30);
		panel.add(t8);
		
		t9 = new JTextField();
		t9.setEditable(false);
		t9.setBounds(595,135,200,30);
		panel.add(t9);
		
		t10 = new JTextField();
		t10.setEditable(false);
		t10.setBounds(595,175,200,30);
		panel.add(t10);
		
		t11 = new JTextField();
		t11.setEditable(false);
		t11.setBounds(595,215,200,30);
		panel.add(t11);
		
		t12 = new JTextField();
		t12.setBounds(595,255,200,30);
		t12.setEditable(false);
		panel.add(t12);
		
		t13 = new JTextField();
		t13.setEditable(false);
		t13.setBounds(595,295,200,30);
		panel.add(t13);
		
		t14 = new JTextField();
		t14.setEditable(false);
		t14.setBounds(595,335,200,30);
		panel.add(t14);
		
		//buttons
		b1 = new JButton("Retrive");
		b1.setBounds(275, 95, 80, 30);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		panel.add(b1);
		
		b2 = new JButton("Retrive");
		b2.setBounds(692, 95, 80, 30);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		panel.add(b2);
		
		b3 = new JButton("Issue");
		b3.setBounds(400, 385, 80, 30);
	    b3.setBackground(Color.BLACK);
	    b3.setForeground(Color.WHITE);
		panel.add(b3);
		
		b4 = new JButton("Back");
		b4.setBounds(500, 385, 80, 30);
	    b4.setBackground(Color.BLACK);
	    b4.setForeground(Color.WHITE);
		panel.add(b4);
		
		l15 = new JLabel("Date Of Issue:");
		l15.setBounds(140,350,400,100);
		panel.add(l15);
		
		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(228, 385, 150, 29);
		panel.add(dateChooser);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.white);
		panel3.setBorder(new TitledBorder(new LineBorder(Color.BLACK), "Details", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel3.setBounds(100, 69, 718, 364);
		panel.add(panel3);
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  String o=t1.getText();
			
		 try{
			
			 		Conn con = new Conn();
	                String sql = "select * from book where book_id ='"+o+"' ";	                
	                ResultSet rs = con.s.executeQuery(sql);
			
	                while (rs.next()) {
	                    t2.setText(rs.getString("b_name"));
	                    t3.setText(rs.getString("isbn"));
	                    t4.setText(rs.getString("publisher"));
	                    t5.setText(rs.getString("edition"));
	                    t6.setText(rs.getString("price"));
	                    t7.setText(rs.getString("pages"));
			
	                }
			
	            }catch(Exception e1) {
	            	e1.fillInStackTrace();
	            
	            }
			}});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  String a=t8.getText();
			
		 try{
			
			 		Conn con = new Conn();
	                String sql = "select * from student where Student_id ='"+a+"' ";	                
	                ResultSet rs = con.s.executeQuery(sql);
			
	                while (rs.next()) {
	                    t9.setText(rs.getString("name"));
	                    t10.setText(rs.getString("father"));
	                    t11.setText(rs.getString("course"));
	                    t12.setText(rs.getString("branch"));
	                    t13.setText(rs.getString("year"));
	                    t14.setText(rs.getString("semester"));
			
	                }
			
	            }catch(Exception e1) {
	            	e1.fillInStackTrace();
	            
	            }
			}});
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			
		 try{
			 		Conn con = new Conn();
			 
			 String sql = "insert into issuebook(book_id, Student_id, b_name, name, course, branch, dateOfIssue) values(?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, t1.getText());
				st.setString(2, t8.getText());
				st.setString(3, t2.getText());
				st.setString(4, t9.getText());
				st.setString(5, t11.getText());
				st.setString(6, t12.getText());
				st.setString(7, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
				int i = st.executeUpdate();
				if (i > 0)
		                    JOptionPane.showMessageDialog(null, "Successfully Book Issued..!");
				else
		                    JOptionPane.showMessageDialog(null, "error");
		                    }catch(Exception eb){
		                        eb.printStackTrace();
		                                }
		            }
			});
		b4.addActionListener(new ActionListener() {
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
		
public static void main(String args[]) {
	new IssueBook().setVisible(true);
}}