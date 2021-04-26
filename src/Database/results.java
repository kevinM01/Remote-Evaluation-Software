package Database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class results extends JFrame implements ActionListener{
     QuestionFinal e;
    JLabel l1, l2, l3, l4, l5;
    JButton b1;
    int count, tmarks, total, pmark;
    String topic, result, sno;
    

    public results(QuestionFinal ex) 
    {
        e = ex;
        count = ex.count;
        sno = ex.stdno;
        topic = ex.topi;
        tmarks = 0;
        for (int r = 0; r < count; r++) {
            System.out.println("answer  " + ex.uans[r] + "   " + ex.ans[r]);
            if (ex.ans[r].equals(ex.uans[r])) {
                tmarks++;
            }
        }
        total = (count) * 5;
        tmarks = tmarks * 5;
        pmark = total / 2;
        result = "Fail";
        if (tmarks >= pmark) {
            result = "Pass";
        }

        l1 = new JLabel("EMAIL   :" + sno.toUpperCase());
        l2 = new JLabel("TOPIC  :" + topic.toUpperCase());
        l3 = new JLabel("TOTAL MARKS  :" + total);
        l4 = new JLabel("MARKS SECURED  :" + tmarks);
        l5 = new JLabel("RESULT   :" + result.toUpperCase());
        b1= new JButton ("BACK");

        l1.setBounds(80, 70, 200, 30);
        l2.setBounds(80, 110, 200, 30);
        l3.setBounds(80, 150, 200, 30);
        l4.setBounds(80, 190, 200, 30);
        l5.setBounds(80, 230, 200, 30);
        b1.setBounds(80, 280, 120, 40);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(l5);
        add(b1);
        
        setLayout(null);
        setVisible(true);
        b1.addActionListener(this);
        //b1.addActionListener(this);
        System.out.println(tmarks);
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            Statement st = conn.createStatement();
            String sql = "insert into results (E_mail,topic,totalmarks,markssecured,result) values (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            String t1 = String.valueOf(total);
            String t2 = String.valueOf(tmarks);
            pstmt.setString(1, sno);
            pstmt.setString(2, topic);
            pstmt.setString(3, t1);
            pstmt.setString(4, t2);
            pstmt.setString(5, result);

            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

     public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == b1) 
            {
                Courses f = new Courses(sno);
                f.setVisible(true);
                f.setSize(700, 700);
                f.setLayout(null);
                dispose();

            }          
        } catch (Exception ep) {
            JOptionPane.showMessageDialog(null, ep);
        }

    }

    }
