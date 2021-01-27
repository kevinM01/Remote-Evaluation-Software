package Database;

import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminLogin extends JFrame implements ActionListener {

    JTextField t1;
    JPasswordField p;
    JButton b1, b2, b3, b4;
    JLabel l1, l2, l3;
    Container c = getContentPane();
    JCheckBox ch;

    AdminLogin() {
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
        ch = new JCheckBox("Show Password");

        c.setLayout(null);

        l1.setBounds(50, 150, 100, 30);
        l2.setBounds(50, 220, 100, 30);
        l3.setBounds(50, 270, 100, 30);
        t1.setBounds(150, 150, 150, 30);
        p.setBounds(150, 220, 150, 30);
        ch.setBounds(150, 250, 150, 30);
        b1.setBounds(50, 300, 100, 30);
        b2.setBounds(150, 300, 100, 30);
        b3.setBounds(250, 300, 100, 30);
        b4.setBounds(350, 300, 100, 30);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        ch.addActionListener(this);

        c.add(l1);
        c.add(l2);
        c.add(l3);
        c.add(t1);
        c.add(p);
        c.add(ch);
        c.add(b1);
        c.add(b2);
        c.add(b3);
        c.add(b4);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                String userText;
                String pwdText;
                userText = t1.getText();
                pwdText = p.getText();
                String sql = "select E_mail,Password from admin_info where E_mail=? and Password = ?";
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AdminLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root" , "Virti#200");
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, t1.getText());
                pstmt.setString(2, new String(p.getPassword()));

                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Welcome " + userText, "Successful Login", JOptionPane.INFORMATION_MESSAGE);

               AdminPanel m = new AdminPanel();
               m.setVisible(true);
               m.setSize(700, 700);
               dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username/Password", "Unsuccessful Login", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (e.getSource() == b3) {
                t1.setText("");
                p.setText("");
            }

            if (e.getSource() == ch) {
                if (ch.isSelected()) {
                    p.setEchoChar((char) 0);
                } else {
                    p.setEchoChar('*');
                }
            }

            if (e.getSource() == b4) {
                MainLogin f = new MainLogin();
                f.setVisible(true);
                f.setSize(700, 700);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

//    public static void main (String args[])throws Exception {
//        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//        
////        AdminLogin f = new AdminLogin();
////        f.setTitle("Login Form");
////        f.setVisible(true);
////        f.setSize(700, 700);
////        f.setLocationRelativeTo(null);
////        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//    }

    
}
