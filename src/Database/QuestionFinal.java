package Database;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class QuestionFinal extends JFrame implements ActionListener {

    String stdno;
    int i;
    int qcounter;
    String topi;
    int count = 0;
    int qno;
    String[] ques;
    String[] op1;
    String[] op2;
    String[] op3;
    String[] op4;
    String[] ans;
    String[] uans;
    String[] umark;
    JPanel cp;
    JLabel l1, l2, l3, lb1, lb2, lb3, lb4, lb5;
    JButton pre, n, m, s;

    JRadioButton radioop1, radioop2, radioop3, radioop4;
    int qmark;
    //mythread mn;

    results r;

    public QuestionFinal(String user, String top) 
    {
        this.qcounter = 0;

        qcounter = 0;
        stdno = user;
        topi = top;
        setLayout(new FlowLayout());

        qno = qcounter + 1;
        pre = new JButton("Previous");
        n = new JButton("Next");
        m = new JButton("Mark");
        s = new JButton("Submit");
        l1 = new JLabel();
        // l3 = new JLabel("Time :00::50::00");
        l2 = new JLabel("Q.NO" + qno + "of" + count);

        pre.setBounds(50, 300, 100, 30);
        m.setBounds(250, 300, 100, 30);
        n.setBounds(150, 300, 100, 30);
        s.setBounds(350, 300, 100, 30);
        l1.setBounds(50, 50, 400, 50);
        l2.setBounds(50, 400, 100, 30);
        //l3.setBounds(250, 400, 100, 30);

        add(l1);
        add(l2);
        //add(l3);
        add(pre);
        add(n);
        add(m);
        add(s);

        radioop1 = new JRadioButton();
        radioop2 = new JRadioButton();
        radioop3 = new JRadioButton();
        radioop4 = new JRadioButton();
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioop1);
        bg.add(radioop2);
        bg.add(radioop3);
        bg.add(radioop4);

        radioop1.setBounds(50, 100, 400, 30);
        radioop2.setBounds(50, 150, 400, 30);
        radioop3.setBounds(50, 200, 400, 30);
        radioop4.setBounds(50, 250, 400, 30);

        add(radioop1);
        add(radioop2);
        add(radioop3);
        add(radioop4);

        //mn = new mythread(this);
        //mn.start();
        setLayout(null);
        setVisible(true);

        pre.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        s.addActionListener(this);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Virti#200");
            Statement st = c.createStatement();
            String sql = "insert into question values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery("Select * from question where topic='" + topi + "' order by qno");

            while (rs.next()) {
                count++;
            }
            st.close();
            ques = new String[count];
            op1 = new String[count];
            op2 = new String[count];
            op3 = new String[count];
            op4 = new String[count];
            ans = new String[count];
            uans = new String[count + 1];
            umark = new String[count];
            Statement st1 = c.createStatement();
            rs = st1.executeQuery("Select * from question where topic='" + topi + "'");
            int i = 0;
            while (rs.next()) {
                ques[i] = rs.getString(2);
                op1[i] = rs.getString(4);
                op2[i] = rs.getString(5);
                op3[i] = rs.getString(6);
                op4[i] = rs.getString(7);
                ans[i] = rs.getString(8);
                umark[i] = "N";
                i++;
            }

            st1.close();

        } catch (ClassNotFoundException | SQLException y) {
            System.out.println("inside:" + y);
        }
        add124(qcounter);

    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Virti#200");
            String sql = "insert into sans values (?,?,?,?)";
            PreparedStatement pstmt = c.prepareStatement(sql);

            if (e.getSource() == pre) {
                qcounter = qcounter - 1;
                if (qcounter <= 0) {
                    qcounter = 0;
                }
                add124(qcounter);
            } else if (e.getSource() == n) {
                qcounter = qcounter + 1;
                if (qcounter >= (count)) {
                    qcounter = qcounter - 1;
                }

                add124(qcounter);

            } else if (e.getSource() == m) {
                if (radioop1.isSelected()) {
                    uans[qcounter] = radioop1.getText();
                } else if (radioop2.isSelected()) {
                    uans[qcounter] = radioop2.getText();
                } else if (radioop3.isSelected()) {
                    uans[qcounter] = radioop3.getText();
                } else if (radioop4.isSelected()) {
                    uans[qcounter] = radioop4.getText();
                }
                System.out.println(uans[qcounter]);
            } else if (e.getSource() == s) {
                dispresults();
            }

        } catch (Exception t) {
            JOptionPane.showMessageDialog(null, t);

        }
        l1.setText("" + ques[qcounter]);
        radioop1.setText(op1[qcounter]);
        radioop2.setText(op2[qcounter]);
        radioop3.setText(op3[qcounter]);
        radioop4.setText(op4[qcounter]);

    }

    public void add124(int c) {
        qcounter = c;
        l1.setText(ques[c]);
        radioop1.setText(op1[c]);
        radioop2.setText(op2[c]);
        radioop3.setText(op3[c]);
        radioop4.setText(op4[c]);

        l2.setText("Q.NO " + (c + 1) + " of " + count);
        //System.out.println("change="+(c+1)+"    "+count);
        validate();
        return;
    }

    public void dispresults() throws SQLException {
        if (r == null) {
            System.out.println("Method dispresults called");
            results r = new results(this);
            r.setVisible(true);
            r.setSize(700, 700);
            r.setLayout(null);
            r.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            r.setTitle("Results");
            dispose();
        }

    }


}
