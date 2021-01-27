/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class examrules extends JFrame implements ActionListener {

    String username;
    String topic;
    JPanel p, p1;
    JButton b1, b2;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;

    public examrules(String user, String top) {
        username = user;
        topic = top;
        l1 = new JLabel("You have selected " + topic);
        l3 = new JLabel("Rules: ");
        l4 = new JLabel("1. Exam carries for 1 hr");
        l6 = new JLabel("2. Use faster, reliable and continued internet connection.");
        l9 = new JLabel(" Best Of Luck!!");
        l10 = new JLabel("3. Save Your Responces using the Mark button periodically during the exam.");
        l7 = new JLabel("Username: " + user);
        
        l1.setBounds(200, 100, 300, 100);
        l3.setBounds(200, 140, 300, 100);
        l4.setBounds(200, 170, 300, 100);
        l7.setBounds(100, 50, 300, 100);
        l6.setBounds(200, 210, 300, 100);
        l9.setBounds(200, 300, 300, 50);
        l10.setBounds(200, 250, 400, 100);
        add(l1);
        //add(l2);
        add(l3);
        add(l4);
        //add(l5);
        add(l6);
        add(l7);
        add(l9);
        add(l10);
        setLayout(null);
        //setVisible(null);
        
        b1 = new JButton("Start");
        b2 = new JButton("Back");
        b2.setBounds(160, 400, 120, 40);
        b1.setBounds(290, 400, 120, 40);
        add(b1);
        add(b2);
        b1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                QuestionFinal ex = new QuestionFinal(username, topic);
                ex.setVisible(true);
                ex.setLayout(null);
                ex.setSize(700, 700);
                //ex.setLocationRelativeTo(null);
                dispose();
            }
        });

        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b2) //start
            {
                Courses f = new Courses(username);
                f.setVisible(true);
                f.setSize(700, 700);
                f.setLayout(null);
                dispose();

            }

            if (e.getSource() == b1) //start
            {
                try {
                    QuestionFinal ex = new QuestionFinal(username, topic);
                    ex.setVisible(true);
                    ex.setLayout(null);
                    ex.setSize(700, 700);
                    dispose();

                } catch (Exception gg) {
                }
            }
        } catch (Exception ep) {
            JOptionPane.showMessageDialog(null, ep);
        }

    }

}
