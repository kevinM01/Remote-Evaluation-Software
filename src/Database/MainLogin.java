package Database;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MainLogin extends JFrame implements ActionListener {

    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JLabel l1;
    Container cp = getContentPane();

    MainLogin() {
        l1 = new JLabel();
        l1.setText("LOGIN AS");
        l1.setFont(new Font("ARIEL", Font.PLAIN, 17));
        b1 = new JButton("STUDENT");
        b2 = new JButton("ADMIN");
        //b3 = new JButton("Previous page");

        cp.setLayout(null);

        l1.setBounds(240, 90, 300, 100);
        b1.setBounds(200, 180, 150, 50);
        b2.setBounds(200, 250, 150, 50);
        //b3.setBounds(200, 350, 150, 30);

        cp.add(b1);
        cp.add(b2);
        //cp.add(b3);
        cp.add(l1);

        b1.addActionListener(this);
        b2.addActionListener(this);
        //b3.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) {
                First f = new First();
                f.setVisible(true);
                //f.setLocationRelativeTo(null);
                f.setSize(700, 700);
                dispose();
            }
            if (e.getSource() == b2) {
                AdminLogin al = new AdminLogin();
                al.setVisible(true);
                al.setSize(700, 700);
                dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }

    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        MainLogin fr = new MainLogin();
        fr.setLayout(null);
        fr.setVisible(true);
        //fr.setLocationRelativeTo(null);
        fr.setDefaultCloseOperation(MainLogin.EXIT_ON_CLOSE);
        fr.setSize(700, 700);

    }

}
