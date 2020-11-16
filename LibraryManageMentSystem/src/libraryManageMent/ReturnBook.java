
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

import com.toedter.calendar.JDateChooser;



public class ReturnBook extends JFrame {
    private JPanel panel;
    private JLabel Bl,Bl1,sl,sl1,sl2,sl3,sl4,sl5,sl6;
    private JTextField t, t1,t2,t3,t4,t5,t6;
    private JButton b1,b2,b3;
    private JDateChooser dateChooser;
    
    ReturnBook(){
		super("Return Book");
		setBounds(350,150,680,500);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.white);
		setContentPane(panel);
		
		sl = new JLabel("Studet Id:");
		sl.setBounds(260,60,200,100);
		panel.add(sl);
		
		Bl = new JLabel("Book Id:");
		Bl.setBounds(110,60,200,100);
		panel.add(Bl);
		
		Bl1 = new JLabel("Book Name :");
		Bl1.setBounds(130,100,200,100);
		panel.add(Bl1);
		
		sl2 = new JLabel("Student's Name :");
		sl2.setBounds(130,140,200,100);
		panel.add(sl2);
		
		sl3 = new JLabel("Course :");
		sl3.setBounds(130,180,200,100);
		panel.add(sl3);
		
		sl4 = new JLabel("Branch :");
		sl4.setBounds(130,220,200,100);
		panel.add(sl4);
		
		sl5 = new JLabel("Date Of Issue :");
		sl5.setBounds(130,260,200,100);
		panel.add(sl5);
		
		sl6 = new JLabel("Date Of Return :");
		sl6.setBounds(130,300,200,100);
		panel.add(sl6);
		
		t = new JTextField();
		t.setBounds(320,95,85,30);
		panel.add(t);
		
		t1 = new JTextField();
		t1.setBounds(165,95,85,30);
		panel.add(t1);
		
		t2 = new JTextField();
		t2.setEditable(false);
		t2.setBounds(245,135,150,30);
		panel.add(t2);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(245,175,200,30);
		panel.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(245,215,200,30);
		t4.setEditable(false);
		panel.add(t4);
		
		t5 = new JTextField();
		t5.setBounds(245,255,200,30);
		t5.setEditable(false);
		panel.add(t5);
		
		t6 = new JTextField();
		t6.setBounds(245,295,100,30);
		t6.setEditable(false);
		panel.add(t6);
		

		dateChooser = new JDateChooser();
		dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		dateChooser.setForeground(new Color(105, 105, 105));
		dateChooser.setBounds(248, 335, 100, 30);
		panel.add(dateChooser);
			
		b1 = new JButton("Search");
		b1.setBounds(415, 95, 80, 30);
	    b1.setBackground(Color.BLACK);
	    b1.setForeground(Color.WHITE);
		panel.add(b1);
		
		b2 = new JButton("Return");
		b2.setBounds(365, 295, 80, 30);
	    b2.setBackground(Color.BLACK);
	    b2.setForeground(Color.WHITE);
		panel.add(b2);
		
		b3 = new JButton("Back");
		b3.setBounds(365, 335, 80, 30);
	    b3.setBackground(Color.BLACK);
	    b3.setForeground(Color.WHITE);
		panel.add(b3);
		
		
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				  String o=t.getText();
				  String x=t1.getText();
				  System.out.println(o);
				
		 try{
			
			 		Conn con = new Conn();
	                String sql = "select b_name,name,course,branch,dateOfIssue from issuebook where book_id ='"+x+"' and Student_id='"+o+"' ";	                
	                ResultSet rs = con.s.executeQuery(sql);
			
	                while (rs.next()) {
	                	t2.setText(rs.getString("b_name"));
	                    t3.setText(rs.getString("name"));
	                    t4.setText(rs.getString("course"));
	                    t5.setText(rs.getString("branch"));
	                    t6.setText(rs.getString("dateOfIssue"));
	                   
	                }
			
	            }catch(Exception e1) {
	            	e1.fillInStackTrace();
	            
	            }
			}});
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
		 try{
			
			 		Conn con = new Conn();
	                String sql = "Insert into raturn_book (book_id,Student_id,b_name,name,course,branch,dateOfIssue,dateOfReturn) values(?, ?, ?, ?, ?, ?, ?,?)";  
					PreparedStatement st = con.c.prepareStatement(sql);
	            	st.setString(1, t.getText());
					st.setString(2, t1.getText());
					st.setString(3, t2.getText());
					st.setString(4, t3.getText());
					st.setString(5, t4.getText());
					st.setString(6, t5.getText());
					st.setString(7, t6.getText());
					st.setString(8, ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText());
	              
	                   
					int i = st.executeUpdate();
					if (i > 0) {
			                    JOptionPane.showMessageDialog(null, "Processing..");
			                    delete();
			                    JOptionPane.showMessageDialog(null, "Book is Returned Successfully");
			                    dispose();
					} else {
			                    JOptionPane.showMessageDialog(null, "error");
					
			            } 
			
	            }catch(Exception e1) {
	            	e1.fillInStackTrace();
	            
	            }
			}});
		b3.addActionListener(new ActionListener() {
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
    public void delete() {
    	
    	String l=t1.getText();
        try {
            Conn con = new Conn();
            String sql = "delete from issuebook where book_id='"+l+"'"; 
            PreparedStatement st = con.c.prepareStatement(sql);
            int i = st.executeUpdate();
            if (i > 0)
                JOptionPane.showConfirmDialog(null, "Do you want to Return");
            else
                JOptionPane.showMessageDialog(null, "error in Deleting");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
	}
        
    }

public static void main(String args[]) {
	new ReturnBook().setVisible(true);
}
}
