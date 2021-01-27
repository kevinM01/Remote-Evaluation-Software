package Database;

/**
 *
 * @author Manasi
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminPanel extends JFrame implements ActionListener {

    JButton b1, b2, b3,b4;
    Container cp = getContentPane();

    AdminPanel() {
        b1 = new JButton("Results");
        b2 = new JButton("Students Details");
        b3 = new JButton("Add Questions");
        b4 = new JButton("Back");

        cp.setLayout(null);
        b1.setBounds(150, 150, 150, 50);
        b2.setBounds(150, 250, 150, 50);
        b3.setBounds(150, 350, 150, 50);
        b4.setBounds(150, 550, 100, 50);
        cp.add(b1);
        cp.add(b2);
        cp.add(b3);
        cp.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) { 
            ViewResults frame = new ViewResults();
            frame.setTitle("Results");
            frame.setVisible(true);
            frame.setSize(700, 700);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            dispose();
        }
        if (e.getSource() == b2) { //student details
            edit_student r = new edit_student();
            r.setVisible(true);  
            r.setSize(700, 700);  
            r.setLayout(null);  
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            r.setTitle("Edit Form");
             dispose();
        }
        if (e.getSource() == b3) { //add q
            InsertQuestion r = new InsertQuestion();
            r.setVisible(true);  
            r.setSize(700, 700);  
            r.setLayout(null);  
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
            r.setTitle("Insert questions");
             dispose();
        }
        if (e.getSource() == b4) {
                AdminLogin f = new AdminLogin();
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                //f.setLocationRelativeTo(null);
                f.setSize(700, 700);
                dispose();
            }
    }


}

