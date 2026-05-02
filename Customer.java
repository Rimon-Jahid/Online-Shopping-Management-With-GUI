
import java.awt.*;
import javax.swing.*;

public class Customer {
    Myframe frame;
    JPanel panel;
    JPanel topPanel;
    UserManager userManager = new UserManager();
    String getemail;
    String email2;
    int id;
    public Customer(){
        userManager.loadUsersFromFile();
    }
    public void CustomerLogin(){
        JLabel emailLabel = new JLabel("Email ID");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(50, 100, 100, 30);

        JTextField email = new JTextField("rimon@gmail.com");
        email.setBounds(50,125,200,30);
        this.email2 = email.getText();

        JLabel PasswordLabel = new JLabel("Password");
        PasswordLabel.setForeground(Color.WHITE);
        PasswordLabel.setBounds(50, 170, 100, 30);

        JPasswordField passwordField = new JPasswordField("rimon123");
        //passwordField.setBorder(null);
        passwordField.setBounds(50,195,200,30);

        JCheckBox showPassword = new JCheckBox("Show password");
        showPassword.setForeground(Color.WHITE);
        showPassword.setBorder(null);
        showPassword.setOpaque(false);
        showPassword.setBounds(35, 240, 150, 30);
        showPassword.setBackground(new Color(0, 102, 204, 200));
        showPassword.setFocusable(false);
        showPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showPassword.addActionListener(e -> {
            if(showPassword.isSelected()){
                passwordField.setEchoChar((char)0);
            }
        });


        JLabel forgotLabel = new JLabel("Forgot Password?");
        forgotLabel.setForeground(Color.WHITE);
        forgotLabel.setBounds(180, 240, 150, 30);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(50, 290, 210, 40);
        loginButton.setBackground(new Color(0, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setBorder(null);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        MyButton button = new MyButton("Create new account.?");
        button.setFont(new Font("SansSerif", Font.PLAIN, 10));
        button.setBounds(100,340,200,30);

        JLabel logolabel = new JLabel();
        logolabel.setSize(60,55);
        logolabel.setBounds(125,5,60,55);

        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\Downloads\\Logo-removebg-preview.png");
        Image image2= image1.getImage().getScaledInstance(60, 55, Image.SCALE_SMOOTH);
        ImageIcon logo= new ImageIcon(image2);
        logolabel.setIcon(logo);

        topPanel = new JPanel();
        topPanel.setSize(300,50);
        topPanel.setBackground(new Color(0, 25, 0));
        topPanel.setOpaque(true);
        topPanel.setBounds(0, 0, 303, 55);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        topPanel.add(logolabel);

        panel = new JPanel();
        panel.setSize(300,400);
        panel.setBackground(new Color(0, 102, 204, 200));
        panel.setOpaque(true);
        panel.setBounds(300, 50, 303, 405);
        panel.setLayout(null);
        panel.add(topPanel);
        panel.add(emailLabel);
        panel.add(email);
        panel.add(PasswordLabel);
        panel.add(passwordField);
        panel.add(showPassword);
        panel.add(forgotLabel);
        panel.add(loginButton);
        panel.add(button);

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

        frame = new Myframe();
        frame.setLayout(null);
        frame.add(backgroundPanel);

        //-------------Login end -------------------//

        loginButton.addActionListener((actionEvent) -> {
            getemail = email.getText();
            char[] password_chars = passwordField.getPassword();
            String password = new String(password_chars);
            if(userManager.checkUser(getemail, password)){

                CustomerFrame cm = new CustomerFrame(getemail);
                cm.CustomerInterface();
                frame.dispose();
            }
            else{
                JOptionPane.showMessageDialog(panel, "Wrong email or password","Warning",JOptionPane.ERROR_MESSAGE);
            }
        });
        button.addActionListener((actionEvent) -> {
            CreateNewAccount createNewAccount = new CreateNewAccount();
        });
    }
}
