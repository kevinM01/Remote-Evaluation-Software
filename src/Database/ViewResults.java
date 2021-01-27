package Database;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class ViewResults extends JFrame implements ActionListener
{
    DefaultTableModel model = new DefaultTableModel();
    Container cnt = this.getContentPane();
    JTable ResultTable = new JTable(model);
    JButton b1; 
    ViewResults()
    {

        model.addColumn("EMAIL");
        model.addColumn("TOPIC");
        model.addColumn("TOTAL MARKS");
        model.addColumn("MARKS SECURED");
        model.addColumn("RESULT");
        b1 = new JButton("Back");
        b1.setBounds(300,600, 100, 30);
        b1.addActionListener(this);
        add(b1);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "Virti#200");
            PreparedStatement st = conn.prepareStatement("select * from results");
            ResultSet rs = st.executeQuery();
            while (rs.next()) 
            {
                String user = rs.getString("E_mail");
                String topi = rs.getString("topic");
                String totM = String.valueOf(rs.getString("totalmarks"));
                String markS = String.valueOf(rs.getString("markssecured"));
                String result = rs.getString("result");
                String tableData[] = {user, topi, totM, markS, result};
                model.addRow(tableData);
            }

        } catch (Exception e) {}
        JScrollPane pg = new JScrollPane(ResultTable);
        cnt.add(pg);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent ex) {
         if (ex.getSource() == b1) {
                AdminPanel f = new AdminPanel();
                f.setVisible(true);
                //f.setLocationRelativeTo(null);
                f.setSize(700, 700);
                dispose();
            }
    }

}



