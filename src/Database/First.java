package Database;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class First extends JFrame implements ActionListener
{
        JTextField t1;
        JPasswordField p;
        JButton b1,b2,b3,b4;
        JLabel l1,l2,l3;
        Container cp = getContentPane();
        JCheckBox c;
        
        First()
        {
            l1 = new JLabel();
            l1.setText("Username:");
            t1 = new JTextField();
 
            l2 = new JLabel();
            l2.setText("Password:");
            l3 = new JLabel();
            l3.setText("");
            p = new JPasswordField();
            b1 = new JButton("Sign in");
            b2 = new JButton("Sign up");
            b3 = new JButton("Reset");
            b4 = new JButton("Back");
            c = new JCheckBox("Show Password");
            
            cp.setLayout(null);
             
            l1.setBounds(50, 150, 100, 30);
            l2.setBounds(50, 220, 100, 30);
            l3.setBounds(50, 270, 100, 30);
            t1.setBounds(150, 150, 150, 30);
            p.setBounds(150, 220, 150, 30);
            c.setBounds(150, 250, 150, 30);
            b1.setBounds(50, 300, 100, 30);
            b2.setBounds(250, 300, 100, 30);
            b3.setBounds(150, 300, 100, 30);
            b4.setBounds(350, 300, 100, 30);
           
             
            b1.addActionListener(this);
            b3.addActionListener(this);
            c.addActionListener(this);
            b2.addActionListener(this);
            b4.addActionListener(this);
            
            cp.add(l1);
            cp.add(l2);
            cp.add(l3);
            cp.add(t1);
            cp.add(p);
            cp.add(c);
            cp.add(b1);
            cp.add(b2);
            cp.add(b3);
            cp.add(b4);
        } 
        @Override
                 public void actionPerformed(ActionEvent e) 
                {
                try
                {
                if (e.getSource() == b1) {
                    String userText;
                    String pwdText;
                    userText = t1.getText();
                    pwdText = p.getText();
                        String sql = "select E_mail,Password from student_info where E_mail=? and Password = ?";
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root" , "Virti#200");
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1,t1.getText());
                        pstmt.setString(2,new String(p.getPassword()));
                         
                        ResultSet rs = pstmt.executeQuery();
                        if(rs.next())
                        {
                         JOptionPane.showMessageDialog(null, "Welcome "+userText,"Successful Login",JOptionPane.INFORMATION_MESSAGE);
                    Courses f = new Courses(t1.getText());
                    f.setVisible(true);
                    f.setSize(700, 700);
                    dispose();
                        }
                    else 
                    {
                       JOptionPane.showMessageDialog(null, "Invalid Username/Password","Unsuccessful Login",JOptionPane.ERROR_MESSAGE);
                    }

                }
                if(e.getSource()==b2)
            {
               Registration f = new Registration();
               f.setVisible(true);
               f.setSize(700, 700);
               dispose();
            }
                
                if (e.getSource() == b3)
                {
                    t1.setText("");
                    p.setText("");
                }
                
                if (e.getSource() == c)
                {
                    if (c.isSelected()) 
                    {
                        p.setEchoChar((char)0);
                    }
                    else
                    {
                        p.setEchoChar('*');
                    }
                }
                if(e.getSource()==b4)
            {
               MainLogin m = new MainLogin();
               m.setVisible(true);
               m.setSize(700, 700);
               dispose();
            }
                }catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null,ex);
                }
                
            }
   
//        public static void main(String args[])
//            throws Exception {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        
//             First frame = new First();
//             frame.setTitle("Login Form");
//             frame.setVisible(true);
//             frame.setSize(700, 700);
//             //frame.setLocationRelativeTo(null);
//             frame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         
//            }
    

}
