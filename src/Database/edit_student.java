package Database; 
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.String;

public class edit_student extends JFrame implements ActionListener
{
    JTextField t1,t2,t3,t4,t5;
    JTextField p;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6;
    JRadioButton r1,r2;    
    Container cp = getContentPane();
    ButtonGroup bg = new ButtonGroup();
    
    edit_student(){
        l1 = new JLabel("Name");
        l2 = new JLabel("Email-ID");
        l3 = new JLabel("Set Password");
        l4 = new JLabel("Phone Number");
        l5 = new JLabel("Std");
        l6 = new JLabel("Gender");
        t1 = new JTextField();
        t2 = new JTextField();
        p = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        b1 = new JButton("Update");  
        b3 = new JButton("Back");  
        b2 = new JButton("Show");  
        r1=new JRadioButton("Male");    
        r2=new JRadioButton("Female");    

      
        cp.setLayout(null);
        
        l1.setBounds(80, 70, 200, 30);  
        l2.setBounds(80, 110, 200, 30);  
        l3.setBounds(80, 150, 200, 30);  
        l4.setBounds(80, 190, 200, 30);  
        l5.setBounds(80, 230, 200, 30);    
        l6.setBounds(80, 270, 200, 30);
        t1.setBounds(300, 70, 200, 30);  
        t2.setBounds(300, 110, 200, 30);  
        p.setBounds (300, 150, 200, 30);  
        t3.setBounds(300, 190, 200, 30); 
        t4.setBounds(300, 230, 200, 30);
        b1.setBounds(50, 350, 100, 30); 
        b2.setBounds(150, 350, 100, 30);
        b3.setBounds(250, 350, 100, 30);
        r1.setBounds(140,270,200,30); 
        r2.setBounds(140,290,200,30); 
        
        cp.add(l1);
        cp.add(l2);
        cp.add(l3);
        cp.add(l4);
        cp.add(l5);
        cp.add(l6);
        cp.add(t1);
        cp.add(t2);
        cp.add(p);
        cp.add(t3);
        cp.add(t4);
        
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(r1);
        cp.add(r2);
        bg.add(r1);
        bg.add(r2);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
    }
          public void actionPerformed(ActionEvent e)
        {
         try{ Class.forName("com.mysql.cj.jdbc.Driver");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root" , "");

      if(e.getSource() == b1)
      {

      String query;
         query = "UPDATE student_info SET  name = ?,password = ?,mobile = ?,std = ? WHERE e_mail=?";
      PreparedStatement pstmt = conn.prepareStatement(query);
     
        pstmt.setString(1, t1.getText());
          pstmt.setString(5, t2.getText());
            pstmt.setString(2, p.getText());
              pstmt.setString(3,t3.getText());
                pstmt.setString(4, t4.getText());
                
                pstmt.executeUpdate();
                conn.close();
                JOptionPane.showMessageDialog(null,"Updation  SUCCESSFUL");
      }
      if(e.getSource() == b3)
      {
           AdminPanel r = new AdminPanel();
        r.setVisible(true);
        r.setSize(700, 700);
        r.setLayout(null);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setTitle("...");
        dispose();
      }
      if(e.getSource() == b2)
      {
          String sql="select * from student_info where e_mail=?";
          PreparedStatement pstmt = conn.prepareStatement(sql);
          pstmt.setString(1,t2.getText());
          ResultSet rs = pstmt.executeQuery();
          if(rs.next())
          {
              t1.setText(rs.getString("Name"));
              p.setText(rs.getString("Password"));
              t3.setText(rs.getString( "Mobile"));
              t4.setText(rs.getString("STD"));
              String genderEdit=rs.getString("Gender"); 

                    if(genderEdit.equals("Male"))
                    {
                         r1.setSelected(true); 
                    }
                    else if(genderEdit.equals("Female"))
                    {
                         r2.setSelected(true);
                    }
          }
          else
          {
                JOptionPane.showMessageDialog(null,"Record Not Found");
          }
          conn.close(); 
      }
     }catch(SQLException se)
  {
      se.printStackTrace();
   }
  catch(Exception ex)
  {
      ex.printStackTrace();
   }
        }
//  public static void main(String[] args)
//    {
//        edit_student r = new edit_student();
//            r.setVisible(true);  
//            r.setSize(700, 700);  
//            r.setLayout(null);  
//            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//            r.setTitle("Edit Form");
//    }
 

    
    
}
