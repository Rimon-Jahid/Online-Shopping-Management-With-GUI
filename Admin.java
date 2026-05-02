
import java.awt.*;
import javax.swing.*;

public class Admin {
    private Myframe frame;
    private JPanel panel;
    private JPanel topPanel;
    private JLabel label;
    private JLabel namelabel;
    public Admin(){
        JLabel AdminLabel = new JLabel("Admin");
        AdminLabel.setFont(new Font("SansSerif",Font.BOLD,35));
        AdminLabel.setForeground(Color.WHITE);
        AdminLabel.setBounds(80, 80, 120, 40);

        JLabel emailLabel = new JLabel("Email ID");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setBounds(50, 130, 100, 30);

        JTextField email = new JTextField("admin@gmail.com");
        //email.setBorder(null);
        email.setBounds(50,155,200,30);

        JLabel PasswordLabel = new JLabel("Password");
        PasswordLabel.setForeground(Color.WHITE);
        PasswordLabel.setBounds(50, 200, 100, 30);

        JPasswordField passwordField = new JPasswordField("admin123");
        //passwordField.setBorder(null);
        passwordField.setBounds(50,225,200,30);

        JCheckBox rememberMe = new JCheckBox("Remember me");
        rememberMe.setBorder(null);
        rememberMe.setForeground(Color.WHITE);
        rememberMe.setOpaque(false);
        rememberMe.setBounds(35, 260, 150, 30);
        rememberMe.setBackground(new Color(0, 102, 204, 200));
        rememberMe.setFocusable(false);
        rememberMe.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel forgotLabel = new JLabel("Forgot Password?");
        forgotLabel.setForeground(Color.WHITE);
        forgotLabel.setBounds(180, 260, 150, 30);

        JButton loginButton = new JButton("LOGIN");
        loginButton.setBounds(50, 310, 210, 40);
        loginButton.setBackground(new Color(0, 153, 255));
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorder(null);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("SansSerif", Font.BOLD, 16));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        JLabel logolabel = new JLabel();
        logolabel.setSize(60,55);
        logolabel.setBounds(125,5,60,55);

        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\IdeaProjects\\New\\src\\Logo-removebg-preview.png");
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
        panel.add(rememberMe);
        panel.add(forgotLabel);
        panel.add(loginButton);
        panel.add(AdminLabel);

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

        //--------------------Login Interface---------End---------------//

        loginButton.addActionListener((actionEvent) -> {
            String getemail = email.getText();
            char[] password_chars = passwordField.getPassword();
            String password = new String(password_chars);
            if(getemail.equals("admin@gmail.com") && password.equals("admin123")){
                frame.dispose();
                AdminFrame adminFrame = new AdminFrame();
                adminFrame.admininterface();
            }
            else{
                JOptionPane.showMessageDialog(panel, "Wrong email or password","Warning",JOptionPane.ERROR_MESSAGE);
            }
        });

    }
}
