
import java.awt.*;
import javax.swing.*;

public class CreateNewAccount {
    Myframe frame;
    JPanel panel;
    JPanel topPanel;
    UserManager userManager = new UserManager();

    public CreateNewAccount(){

        JLabel Idlabel = new JLabel("ID");
        Idlabel.setForeground(Color.WHITE);
        Idlabel.setBounds(50, 60, 200, 20);

        JTextField Idfield = new JTextField();
        Idfield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Idfield.setBounds(50, 80, 200, 30);

        JLabel namelabel = new JLabel("Name");
        namelabel.setForeground(Color.WHITE);
        namelabel.setBounds(50, 115, 200, 20);

        JTextField namefield = new JTextField();
        namefield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        namefield.setBounds(50, 135, 200, 30);

        JLabel Phonlabel = new JLabel("Phon");
        Phonlabel.setForeground(Color.WHITE);
        Phonlabel.setBounds(50, 175, 200, 20);

        JTextField Phonfield = new JTextField();
        Phonfield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Phonfield.setBounds(50, 195, 200, 30);

        JLabel Addresslabel = new JLabel("Address");
        Addresslabel.setForeground(Color.WHITE);
        Addresslabel.setBounds(50, 240, 200, 20);

        JTextField Addressfield = new JTextField();
        Addressfield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Addressfield.setBounds(50, 260, 200, 30);

        JLabel emaillabel = new JLabel("Email");
        emaillabel.setForeground(Color.WHITE);
        emaillabel.setBounds(50, 295, 200, 20);

        JTextField emailfield = new JTextField();
        emailfield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        emailfield.setBounds(50, 315, 200, 30);

        JLabel Passwordlabel = new JLabel("Password");
        Passwordlabel.setForeground(Color.WHITE);
        Passwordlabel.setBounds(50, 350, 200, 20);

        JTextField Passwordfield = new JTextField();
        Passwordfield.setFont(new Font("SansSerif", Font.PLAIN, 20));
        Passwordfield.setBounds(50, 370, 200, 30);

        MyButton CreateButton = new MyButton("Create Account");
        CreateButton.setForeground(Color.WHITE);
        CreateButton.setBounds(50, 410, 200, 30);


        JLabel logolabel = new JLabel();
        logolabel.setSize(60,55);
        logolabel.setBounds(125,5,60,55);

        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\IdeaProjects\\New\\src\\Logo-removebg-preview.png");
        Image image2= image1.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
        ImageIcon logo= new ImageIcon(image2);
        logolabel.setIcon(logo);

        JButton back = new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN, 10));
        back.setForeground(Color.RED);
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(920, 10, 60, 20);
        back.addActionListener(event -> {
            frame.dispose();
            Firstpage firstpage = new Firstpage();
        });

        topPanel = new JPanel();
        topPanel.setSize(300,50);
        topPanel.setBackground(new Color(0, 25, 0));
        topPanel.setOpaque(true);
        topPanel.setBounds(0, 0, 303, 55);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(logolabel);

        panel = new JPanel();
        panel.setSize(300,450);
        panel.setBackground(new Color(0, 102, 204, 200));
        panel.setOpaque(true);
        panel.setBounds(300, 50, 303, 455);
        panel.setLayout(null);
        panel.add(topPanel);
        panel.add(Idlabel);
        panel.add(Idfield);
        panel.add(namelabel);
        panel.add(namefield);
        panel.add(Phonlabel);
        panel.add(Phonfield);
        panel.add(Addresslabel);
        panel.add(Addressfield);
        panel.add(emaillabel);
        panel.add(emailfield);
        panel.add(Passwordlabel);
        panel.add(Passwordfield);
        panel.add(CreateButton);

        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(0, 102, 204);
                GradientPaint gp = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        backgroundPanel.setLayout(null);
        backgroundPanel.setBounds(0,0,1000,600);
        backgroundPanel.setOpaque(true);
        backgroundPanel.add(panel);
        backgroundPanel.add(back);

        frame = new Myframe();
        frame.setLayout(null);
        frame.add(backgroundPanel);

        //--------------------Login Interface---------End---------------//

        CreateButton.addActionListener((actionEvent) -> {
            String getemail = emailfield.getText();
            String password_chars = Passwordfield.getText();
            String phonenumber = Phonfield.getText();
            String address = Addressfield.getText();
            String name = namefield.getText();
            int id = Integer.parseInt(Idfield.getText());
            userManager.loadUsersFromFile();
            if(userManager.checkUser2(getemail, name) && userManager.findUser2(id)){
                JOptionPane.showMessageDialog(panel, "ID, email or username already taken","Warning",JOptionPane.ERROR_MESSAGE);
            }
            else{
                userManager.addUser(id,name,getemail,password_chars,phonenumber,address);
                Customer customer = new Customer();
                customer.CustomerLogin();
            }
        });

    }
}
