package Database;

import java.awt.event.*;
import javax.swing.JComboBox;
import javax.swing.*;
import java.awt.*;

public class Courses extends JFrame implements ActionListener {

    String username;
    String top;
    JTextField t1, t2, t3;
    JButton b1, b2, b3;
    JLabel l1, l2;
    JList<String> list;
    //JComboBox<String> comboBox;

    Container cp = getContentPane();

    Courses(String user) {
        username = user;
        l1 = new JLabel();
        l1.setText("Select Your Exam subject:");
        l1.setFont(new Font("ARIEL", Font.BOLD, 16));
        l1.setBounds(210, 100, 300, 100);

        //String[] options = { "JAVA","DSA", "PCPF","PCE","MATH"};
        DefaultListModel<String> l = new DefaultListModel<>();
        l.addElement("JAVA");
        l.addElement("PCPF");
        l.addElement("DSA");
        l.addElement("DBMS");
        list = new JList<>(l);
        list.setBounds(250, 230, 80, 70);
        cp.add(list);
        cp.setSize(400, 400);
        cp.setLayout(null);
        cp.setVisible(true);
        top = (String) list.getSelectedValue();

        b1 = new JButton("Sign Out");
        b1.setBounds(180, 400, 100, 40);

        b3 = new JButton("Start Test");
        b3.setBounds(290, 400, 100, 40);

        cp.setLayout(null);
        
        //cp.add(cb);
        cp.add(l1);
        cp.add(b1);
        //cp.add(b2);
        cp.add(b3);
        // cp.add(l2);

        b1.addActionListener(this);
       // b2.addActionListener(this);
        b3.addActionListener(this);
    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            First f = new First();
            f.setVisible(true);
            f.setSize(700, 700);
            dispose();
        }
        
        if (e.getSource() == b3) {
            top = (String) list.getSelectedValue();
            examrules f = new examrules(username, top);
            f.setVisible(true);
            f.setSize(700, 700);
            dispose();
        }

    }

}
