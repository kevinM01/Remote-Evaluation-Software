/**
 *
 * @author Manasi
*/
package Database;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.sql.*;
public class InsertQuestion extends JFrame implements ActionListener
{
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;   
    Container cp = getContentPane();

    
    
    InsertQuestion()
    {
                 
        l1 = new JLabel("Question No");
        l2 = new JLabel("Question");
        l3 = new JLabel("Option 1");
        l4 = new JLabel("Option 2");
        l5 = new JLabel("Option 3");
        l6 = new JLabel("Option 4");
        l7 = new JLabel("Correct Answer");
        l8 = new JLabel("Topic");        
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        
        b1 = new JButton("Back");    
        b2 = new JButton("Clear");  
        b3 = new JButton("Submit");

      
        cp.setLayout(null);
        
        l1.setBounds(80, 70, 200, 30);  
        l2.setBounds(80, 110, 200, 60);  
        l3.setBounds(80, 190, 200, 30);  
        l4.setBounds(80, 240, 200, 30);  
        l5.setBounds(80, 290, 200, 30);    
        l6.setBounds(80, 340, 200, 30);
        l7.setBounds(80, 390, 200, 30);
        l8.setBounds(200,30,200,30);
        t1.setBounds(300, 70, 200, 30);  
        t2.setBounds(300, 110, 200, 60);  
        t3.setBounds (300, 190, 200, 30);  
        t4.setBounds(300, 240, 200, 30);
        t5.setBounds(300, 290, 200, 30);  
        t6.setBounds (300, 340, 200, 30);
        t7.setBounds (300, 390, 200, 30);  
        t8.setBounds(300,30,200, 30);//topic

        b1.setBounds(80, 500, 100, 30);  
        b2.setBounds(210, 500, 100, 30);  
        b3.setBounds(340, 500, 100, 30);
        
        cp.add(l1);cp.add(l2);cp.add(l3);cp.add(l4);
        cp.add(l5);cp.add(l6);cp.add(l7);cp.add(l8);
        
        cp.add(t1);cp.add(t2);cp.add(t3);cp.add(t4);
        cp.add(t5);cp.add(t6);cp.add(t7); cp.add(t8);

        
        cp.add(b1);cp.add(b2);cp.add(b3);        
        
        b1.addActionListener(this); 
        b2.addActionListener(this); 
        b3.addActionListener(this); 
        
      }
    public void actionPerformed(ActionEvent e)
        {
            try
            {
            if(e.getSource()==b2) //clear 
            {
                t1.setText("");  
                t2.setText("");     
                t3.setText("");  
                t4.setText(""); 
                t5.setText(""); 
                t6.setText(""); 
                t7.setText(""); 
                t8.setText(""); 
               
            }
            if(e.getSource()==b1) //back
            {
               AdminPanel r = new AdminPanel();
        r.setVisible(true);
        r.setSize(700, 700);
        r.setLayout(null);
        r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        r.setTitle("...");
        dispose();
            }
            if(e.getSource()==b3)//submit
            {

               Class.forName("com.mysql.cj.jdbc.Driver");
               try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root" , "Virti#200")) 
               {
                    String sql = "insert into question values (?,?,?,?,?,?,?,?)";
                    PreparedStatement pstmt = conn.prepareStatement(sql);
                    pstmt.setString(1, t1.getText());
                    pstmt.setString(2, t2.getText());
                    pstmt.setString(3, t8.getText());
                    pstmt.setString(4, t3.getText());
                    pstmt.setString(5, t4.getText());
                    pstmt.setString(6, t5.getText());
                    pstmt.setString(7, t6.getText());
                    pstmt.setString(8, t7.getText());

                    pstmt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Insertion Successful");
                    ResultSet rs = pstmt.executeQuery();

                }
                 
 catch(Exception ee){}
               
                }
            }
            
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
        }

    public static void main(String args[])
            {
             InsertQuestion frame = new InsertQuestion();
             frame.setTitle("Insert Question");
             frame.setVisible(true);
             frame.setSize(700, 700);
             frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
            }
}