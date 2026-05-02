import java.awt.*;
import javax.swing.*;

public class Firstpage {
    Myframe frame;
    public  Firstpage() {
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0,0,600,600);
        //leftPanel.setBackground(Color.lightGray);
        leftPanel.setLayout(null);
        leftPanel.setOpaque(true);

        JLabel logolabel = new JLabel();
        logolabel.setSize(100,100);
        logolabel.setHorizontalAlignment(JLabel.LEFT);
        logolabel.setVerticalAlignment(JLabel.TOP);

        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\Downloads\\Logo-removebg-preview.png");
        Image image2= image1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon logo= new ImageIcon(image2);
        logolabel.setIcon(logo);
        leftPanel.add(logolabel);

        JLabel line1 = new JLabel("Revolutionizing");
        line1.setFont(new Font("SansSerif",Font.PLAIN,32));
        line1.setBounds(150, 150, 400, 40);
        JLabel line2 = new JLabel("online shopping");
        line2.setFont(new Font("SansSerif",Font.PLAIN,32));
        line2.setBounds(150, 200, 400, 40);
        JLabel line3 = new JLabel("Welcome to");
        line3.setFont(new Font("SansSerif",Font.BOLD,50));
        line3.setBounds(150, 275, 400, 55);
        JLabel line4 = new JLabel("EasyKinakata");
        line4.setFont(new Font("SansSerif",Font.BOLD,50));
        line4.setBounds(150, 335, 400, 65);

        leftPanel.add(line1);
        leftPanel.add(line2);
        leftPanel.add(line3);
        leftPanel.add(line4);


        ImageIcon image = new ImageIcon("C:\\Users\\rimon\\IdeaProjects\\New\\src\\superMarket.png");

        JPanel rightpanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        rightpanel.setBounds(600, 0, 400, 600);
        rightpanel.setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,15,20));

        MyButton menuButton = new MyButton("Menu");
        menuButton.setForeground(new Color(255, 255, 0));
        MyButton homeButton = new MyButton("Home");
        homeButton.setEnabled(false);
        MyButton aboutusButton = new MyButton("About us");
        aboutusButton.setForeground(new Color(255, 255, 0));
        aboutusButton.addActionListener(e -> {
            frame.dispose();
            aboutus();
        });
        MyButton gmailButton = new MyButton("@easykinakata");
        gmailButton.setForeground(new Color(255, 255, 0));

        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem adminmenu = new JMenuItem("Admin");
        adminmenu.setFont(new Font("SansSerif", Font.PLAIN, 16));
        adminmenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminmenu.setForeground(Color.BLACK);

        JMenuItem customermenu = new JMenuItem("Customer");
        customermenu.setFont(new Font("SansSerif", Font.PLAIN, 16));
        customermenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        customermenu.setForeground(Color.BLACK);

        popupMenu.add(adminmenu);
        popupMenu.add(customermenu);

        menuButton.addActionListener((actionEvent) -> {
            popupMenu.show(menuButton, 10, menuButton.getHeight());
        });

        menuPanel.add(menuButton);
        homeButton.setForeground(Color.BLACK);
        homeButton.setBounds(525, 20, 80, 30);
        leftPanel.add(homeButton);
        menuPanel.add(aboutusButton);
        menuPanel.add(gmailButton);
        menuPanel.setOpaque(false);
        rightpanel.add(menuPanel,BorderLayout.WEST);


        frame = new Myframe();
        frame.setLayout(null);
        frame.add(rightpanel);
        frame.add(leftPanel);

        adminmenu.addActionListener((actionEvent) -> {
            frame.dispose();
            Admin admin = new Admin();
        });
        customermenu.addActionListener((actionEvent) -> {
            frame.dispose();
            Customer customer = new Customer();
            customer.CustomerLogin();
        });
    }
    public void aboutus() {
        frame = new Myframe();
        JPanel aboutuspanel = new JPanel();
        aboutuspanel.setBounds(0, 0, 1000, 600);
        aboutuspanel.setBackground(Color.WHITE);
        aboutuspanel.setLayout(null);

        // First image and label for MD. Muzahidul Islam
        ImageIcon mujahidIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\mujahid.jpg");
        Image mujahidd = mujahidIcon.getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        JLabel label1 = new JLabel(new ImageIcon(mujahidd));
        label1.setBounds(40, 20, 160, 180);
        label1.setBackground(Color.BLACK);
        label1.setOpaque(true);

        JLabel label12 = new JLabel("MD. Muzahidul Islam");
        label12.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label12.setBounds(40, 205, 160, 20);
        label12.setBackground(Color.LIGHT_GRAY);
        label12.setOpaque(true);

        JLabel label13 = new JLabel("ID : 241-15-023");
        label13.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label13.setBounds(40, 225, 160, 20);
        label13.setBackground(Color.LIGHT_GRAY);
        label13.setOpaque(true);

        // Second image and label for MD. Faysal Khan
        ImageIcon faysalIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\heemel-suit.jpg");
        Image faysal2 = faysalIcon.getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        JLabel label2 = new JLabel(new ImageIcon(faysal2));
        label2.setBounds(40, 285, 160, 180);
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);

        JLabel label21 = new JLabel("MD. Faysal Khan");
        label21.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label21.setBounds(40, 470, 160, 20);
        label21.setBackground(Color.LIGHT_GRAY);
        label21.setOpaque(true);

        JLabel label22 = new JLabel("ID : 241-15-033");
        label22.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label22.setBounds(40, 490, 160, 20);
        label22.setBackground(Color.LIGHT_GRAY);
        label22.setOpaque(true);

        // Third image and label for MD. Mahir Faysal
        ImageIcon mahirIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\mahir-suit.jpg");
        Image mahir2 = mahirIcon.getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        JLabel label3 = new JLabel(new ImageIcon(mahir2));
        label3.setBounds(240, 20, 160, 180);
        label3.setBackground(Color.BLACK);
        label3.setOpaque(true);

        JLabel label32 = new JLabel("MD. Mahir Faysal");
        label32.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label32.setBounds(240, 205, 160, 20);
        label32.setBackground(Color.LIGHT_GRAY);
        label32.setOpaque(true);

        JLabel label33 = new JLabel("ID : 241-15-116");
        label33.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label33.setBounds(240, 225, 160, 20);
        label33.setBackground(Color.LIGHT_GRAY);
        label33.setOpaque(true);

        // Fourth image and label for Mst. Raziya Akter Sristy
        ImageIcon sristyIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\sristy2.jpg");
        Image sristy2 = sristyIcon.getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        JLabel label4 = new JLabel(new ImageIcon(sristy2));
        label4.setBounds(240, 285, 160, 180);
        label4.setBackground(Color.LIGHT_GRAY);
        label4.setOpaque(true);

        JLabel label41 = new JLabel("Raziya Akter Sristy");
        label41.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label41.setBounds(240, 470, 160, 20);
        label41.setBackground(Color.LIGHT_GRAY);
        label41.setOpaque(true);

        JLabel label42 = new JLabel("ID : 241-15-089");
        label42.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label42.setBounds(240, 490, 160, 20);
        label42.setBackground(Color.LIGHT_GRAY);
        label42.setOpaque(true);

        // Fifth image and label for MD. Jahiul Islam Rimon
        ImageIcon rimonIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\Rimon Fm.jpg");
        Image rimon2 = rimonIcon.getImage().getScaledInstance(160, 180, Image.SCALE_SMOOTH);
        JLabel label5 = new JLabel(new ImageIcon(rimon2));
        label5.setBounds(440, 150, 160, 180);
        label5.setBackground(Color.BLACK);
        label5.setOpaque(true);

        JLabel label51 = new JLabel("Jahiul Islam Rimon");
        label51.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label51.setBounds(440, 335, 160, 20);
        label51.setBackground(Color.LIGHT_GRAY);
        label51.setOpaque(true);

        JLabel label52 = new JLabel("ID : 241-15-604");
        label52.setFont(new Font("SansSerif", Font.PLAIN, 16));
        label52.setBounds(440, 355, 160, 20);
        label52.setBackground(Color.LIGHT_GRAY);
        label52.setOpaque(true);

        JTextPane textPane = new JTextPane();
        String aboutus = "At EasyKinakata, we are committed to revolutionizing the online shopping experience by offering a seamless,"+
                " user-friendly platform that connects customers with quality products. Our mission is to provide a diverse range of items,"+
                " ensuring convenience and satisfaction for every shopper. With a team of dedicated professionals,"+
                " we strive to create an innovative shopping experience that delivers exceptional value, trust, and convenience to our customers."+
                " Whether you're looking for everyday essentials or unique finds, EasyKinakata is your one-stop shop for all your needs."+
                " Join us on this journey as we continue to shape the future of online shopping!";
        textPane.setText(aboutus);
        textPane.setFont(new Font("SansSerif", Font.PLAIN, 16));
        textPane.setEditable(false);
        textPane.setBounds(640,100,320,500);

        textPane.setForeground(Color.BLACK);
        textPane.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBounds(640,80,320,400);

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

        aboutuspanel.add(label5);
        aboutuspanel.add(label51);
        aboutuspanel.add(label52);
        aboutuspanel.add(label4);
        aboutuspanel.add(label42);
        aboutuspanel.add(label41);
        aboutuspanel.add(label3);
        aboutuspanel.add(label32);
        aboutuspanel.add(label33);
        aboutuspanel.add(label2);
        aboutuspanel.add(label21);
        aboutuspanel.add(label22);
        aboutuspanel.add(label1);
        aboutuspanel.add(label12);
        aboutuspanel.add(label13);

        frame.add(back);
        frame.add(aboutuspanel);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

}
