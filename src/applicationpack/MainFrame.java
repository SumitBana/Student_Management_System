/******************************************************************
File#3: MainFrame.java
******************************************************************/
package applicationpack;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainFrame extends JFrame
{
    private Font fnt = new Font("Verdana",1,12);
    private JMenuBar menuBar;
    private JMenu menuAdmin,menuProfessor,menuStudent;
    private JMenuItem[] adminItems = new JMenuItem[7];
    private JMenuItem[] profItems = new JMenuItem[4];
    private JMenuItem[] stuItems = new JMenuItem[3];
    private String[] adminItemCap = {"Add Student","Add Professor","Edit Student","Edit Professor","Delete Student","Delete Professor","Exit"};
    private String[] profItemCap = {"Assign Grade","Edit Grade","View Student","Exit"};
    private String[] stuItemCap = {"View Detail","View Grade","Exit"};
    
    private JMenu makeMenu(String caption)
    {
        JMenu temp = new JMenu(caption);
        temp.setFont(fnt);
        menuBar.add(temp);
        return temp;
    }
    private JMenuItem makeMenuItem(String caption,JMenu menu,String image)
    {
        JMenuItem temp = new JMenuItem(caption,new ImageIcon(image));
        temp.setFont(fnt);
        menu.add(temp);
        temp.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                Object ob = e.getSource();
                if(ob == adminItems[0]) // Add new student
                {
                    StudentAddFrame frame = new StudentAddFrame();
                    frame.setTitle("ADD NEW STUDENT");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,550);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,200,150));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[1]) // Add new professor
                {
                    ProfessorAddFrame frame = new ProfessorAddFrame();
                    frame.setTitle("ADD NEW PROFESSOR");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,510);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(150,200,250));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[2]) // Edit existing student
                {
                    StudentEditFrame frame = new StudentEditFrame();
                    frame.setTitle("EDIT EXISTING STUDENT");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,550);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,200,150));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[3]) // Edit existing professor
                {
                    ProfessorEditFrame frame = new ProfessorEditFrame();
                    frame.setTitle("EDIT EXISTING PROFESSOR");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,500);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(150,200,250));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[4]) // Delete existing student
                {
                    StudentDeleteFrame frame = new StudentDeleteFrame();
                    frame.setTitle("DELETE EXISTING STUDENT");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,550);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,200,150));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[5]) // Delete existing professor
                {
                    ProfessorDeleteFrame frame = new ProfessorDeleteFrame();
                    frame.setTitle("DELETE EXISTING PROFESSOR");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,500);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(150,200,250));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == adminItems[6]) // Exit
                {
                    System.exit(0);
                }
                else if(ob == profItems[0]) // Assigning grade
                {
                    System.setProperty("gradeassign", "1");
                    GradeAssign frame = new GradeAssign();
                    frame.setTitle("ASSIGNING OF GRADE");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(540,270);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,225,200));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == profItems[1]) // Editing grade
                {
                    System.setProperty("gradeassign", "2");
                    GradeAssign frame = new GradeAssign();
                    frame.setTitle("MODIFICATION OF GRADE");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(540,270);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,225,200));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == profItems[2]) // View student
                {
                    StudentSnapshot frame = new StudentSnapshot();
                    frame.setTitle("STUDENTS' SEMESTER WISE GRADE SNAPSHOT");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(900,400);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(new Color(250,225,200));
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == profItems[3]) // Exit
                {
                    System.exit(0);
                }
                else if(ob == stuItems[0]) // View detail
                {
                    ViewDetailByStudent frame = new ViewDetailByStudent();
                    frame.setTitle("PERSONAL DETAIL");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,550);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(Color.WHITE);
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == stuItems[1]) // View grade
                {
                    ViewGradeByStudent frame = new ViewGradeByStudent();
                    frame.setTitle("GRADE DETAIL");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setResizable(false);
                    frame.setSize(530,500);
                    frame.setLocationRelativeTo(null);
                    frame.getContentPane().setBackground(Color.WHITE);
                    frame.setModal(true);
                    frame.setLayout(new BorderLayout());
                    frame.setVisible(true);
                }
                else if(ob == stuItems[2]) // Exit
                {
                    System.exit(0);
                }
            }
        });
        return temp;
    }
    public void setMenuEnable(boolean b1,boolean b2,boolean b3)
    {
        menuAdmin.setEnabled(b1);
        menuProfessor.setEnabled(b2);
        menuStudent.setEnabled(b3);
    }
    public MainFrame()
    {
        menuBar = new JMenuBar();
        super.setJMenuBar(menuBar);
        menuAdmin = makeMenu("Administration");
        menuProfessor = makeMenu("Professor");
        menuStudent = makeMenu("Student");
        for(int i = 0;i < 7;i++)
        {
            if(i != 0 && i%2 == 0) menuAdmin.addSeparator();
            adminItems[i] = makeMenuItem(adminItemCap[i], menuAdmin, "p1.jpg");
        }
        for(int i = 0;i < 4;i++) 
        {
            if(i == 3) menuProfessor.addSeparator();
            profItems[i] = makeMenuItem(profItemCap[i], menuProfessor, "p2.jpg");
        }
        for(int i = 0;i < 3;i++)
        {
            if(i == 2) menuStudent.addSeparator();
            stuItems[i] = makeMenuItem(stuItemCap[i], menuStudent, "p3.jpg");
        }
    }
}
