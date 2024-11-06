/******************************************************************
File#9: ProfessorDeleteFrame.java
******************************************************************/
package applicationpack;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
public class ProfessorDeleteFrame extends JDialog
{
    private JTextField txtID,txtName,txtAddress,txtPhone,txtEmail,txtDOB,txtDOJ,txtDegree;
    private JComboBox cmbGender;
    private JButton btnSearch,btnDelete,btnReturn;
    private String[] gender = {"Male","Female","Trans","Other"};
    private Connection con = null;
    private PreparedStatement pst1 = null;
    private PreparedStatement pst2 = null;
    private PreparedStatement pst3 = null;
    
    private JLabel makeLabel(String cap,int x,int y,int w,int h)
    {
        JLabel temp = new JLabel(cap);
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setForeground(Color.BLACK);
        temp.setBounds(x,y,w,h);
        super.add(temp);
        return temp;
    }
    private JTextField makeTextField(int x,int y,int w,int h)
    {
        Border brdr = BorderFactory.createLineBorder(Color.BLACK, 1);
        JTextField temp = new JTextField();
        temp.setFont(new Font("Courier New", 1, 18));
        temp.setBounds(x,y,w,h);
        temp.setHorizontalAlignment(JLabel.CENTER);
        temp.setBorder(brdr);
        temp.setEnabled(false);
        temp.setDisabledTextColor(Color.BLACK);
        super.add(temp);
        return temp;
    }
    private JComboBox makeComboBox(String sub[],int x,int y,int w,int h)
    {
        Border brdr = BorderFactory.createLineBorder(Color.BLACK, 1);
        JComboBox temp = new JComboBox(sub);
        temp.setBounds(x,y,w,h);
        temp.setFont(new Font("Courier New",1,18));
        temp.setBorder(brdr);
        temp.setEnabled(false);
        ((JLabel)temp.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
        UIManager.put("ComboBox.disabledForeground", Color.BLACK);
        add(temp);
        return temp;
    }
    private JButton makeButton(String cap,int x,int y,int w,int h)
    {
        JButton temp = new JButton(cap);
        temp.setFont(new Font("Verdana", Font.BOLD, 12));
        temp.setBounds(x,y,w,h);
        temp.setMargin(new Insets(0,0,0,0));
        ActionListener act;
        act = new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object ob = e.getSource();
                try
                {
                    if(ob == btnSearch)
                    {
                        if(txtID.getText().equals(""))
                        {
                            JOptionPane.showMessageDialog(null, "PROFESSOR ID NOT ENTERED");
                            txtID.grabFocus();
                        }
                        else
                        {
                            pst1.setString(1, txtID.getText());
                            pst2.setString(1, txtID.getText());
                            ResultSet rst1 = pst1.executeQuery();
                            ResultSet rst2 = pst2.executeQuery();
                            if(rst1.next())
                            {
                                txtName.setText(rst1.getString(1));
                                txtAddress.setText(rst1.getString(2));
                                cmbGender.setSelectedItem(rst1.getString(3));
                                txtPhone.setText(rst1.getString(4));
                                txtEmail.setText(rst1.getString(5));
                                txtDOB.setText(rst1.getString(6));
                                txtDOJ.setText(rst1.getString(7));
                                String degree = "";
                                if(rst2.next()) degree = rst2.getString(1);
                                while(rst2.next()) degree += ","+rst2.getString(1);
                                txtDegree.setText(degree);
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "PROFESSOR NOT FOUND");
                                txtID.setText("");
                                txtID.grabFocus();
                            }
                        }
                    }
                    else if(ob == btnDelete)
                    {
                        int confirm = JOptionPane.showConfirmDialog(null, "ARE YOU SURE TO DELETE THE RECORD?","Confirm Delete",JOptionPane.YES_NO_OPTION);
                        if(confirm == 0)
                        {
                            pst3.setString(1, txtID.getText());
                            pst3.executeUpdate();
                            clearFields();
                        }
                        txtID.grabFocus();
                        txtID.selectAll();
                    }
                    else if(ob == btnReturn)
                    {
                        dispose();
                    }
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        };
        temp.addActionListener(act);
        super.add(temp);
        return temp;
    }
    private void clearFields()
    {
        txtID.setText("");
        txtName.setText("");
        txtAddress.setText("");
        cmbGender.setSelectedIndex(0);
        txtPhone.setText("");
        txtEmail.setText("");
        txtDOB.setText("");
        txtDOJ.setText("");
        txtDegree.setText("");
    }
    public ProfessorDeleteFrame()
    {
        try
        {
            Border brdr1 = BorderFactory.createLineBorder(Color.RED, 2);
            Border brdr2 = BorderFactory.createLineBorder(Color.BLUE, 2);
            Border brdr3 = BorderFactory.createCompoundBorder(brdr1, brdr2);
            JLabel caption = new JLabel("EDITING AN EXISTING PROFESSOR");
            caption.setFont(new Font("verdana",1,22));
            caption.setHorizontalAlignment(JLabel.CENTER);
            caption.setOpaque(true);
            caption.setBackground(Color.YELLOW);
            caption.setForeground(Color.red);
            caption.setBorder(brdr3);
            caption.setBounds(10,10,500,50);
            super.add(caption);

            makeLabel("PROFESSOR ID GENERATED",10, 70,250,30);
            txtID = makeTextField(260, 70,250,30);
            txtID.setEnabled(true);
            makeLabel("ENTER PROFESSOR NAME",    10,110,250,30);
            txtName = makeTextField(260,110,250,30);
            makeLabel("ENTER LOCAL ADDRESS",10,150,250,30);
            txtAddress = makeTextField(260,150,250,30);
            makeLabel("SELECT GENDER STATUS",10,190,250,30);
            cmbGender = makeComboBox(gender,260,190,250,30);
            makeLabel("ENTER PHONE NUMBER",10,230,250,30);
            txtPhone = makeTextField(260,230,250,30);
            makeLabel("ENTER EMAIL ADDRESS",10,270,250,30);
            txtEmail = makeTextField(260,270,250,30);
            makeLabel("ENTER DATE OF BIRTH",10,310,250,30);
            txtDOB = makeTextField(260,310,250,30);
            makeLabel("ENTER DATE OF JOIN",10,350,250,30);
            txtDOJ = makeTextField(260,350,250,30);
            makeLabel("DEGREE COMMA SEPARATED",10,390,250,30);
            txtDegree = makeTextField(260,390,250,30);
            txtDegree.setToolTipText("Comma Separated Value for Multiple Degree (Eg.BSc,BTech,MTech)");
            btnSearch = makeButton("Search",55,430,100,30);
            btnDelete = makeButton("Delete",210,430,100,30);
            btnReturn = makeButton("Return",365,430,100,30);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/project2024","root","150800");
            pst1 = con.prepareStatement("SELECT NAME,ADDRESS,GENDER,PHONE,EMAIL,DOB,DOJ FROM PROFESSOR_MASTER WHERE PROFESSOR_ID = ?");
            pst2 = con.prepareStatement("SELECT DEGREE FROM PROFESSOR_DEGREE WHERE PROFESSOR_ID = ?");
            pst3 = con.prepareStatement("DELETE FROM PROFESSOR_MASTER WHERE PROFESSOR_ID = ?");
        }
        catch(ClassNotFoundException | SQLException | NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
}
