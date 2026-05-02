import java.awt.*;
import javax.swing.*;

public class AdminFrame {
    Myframe frame = new Myframe();
    AdminMenu adminMenu = new AdminMenu();
    MyButton userbutton;
    MyButton productbutton;
    MyButton orderbutton;
    MyButton updatebutton;
    MyButton removebutton;
    MyButton Addbutton;
    MyButton pendingorderbutton;
    MyButton pendingremovebutton;

    public AdminFrame() {
        ProductManager productManager = new ProductManager(null);
        OrderManager orderManager = new OrderManager();
        productManager.loadProductsFromFile();
        JLabel logolabel = new JLabel();
        ImageIcon logoicon = new ImageIcon("C:\\Users\\rimon\\Downloads\\Logo-removebg-preview.png");
        Image logoimage = logoicon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon logoicon1 = new ImageIcon(logoimage);
        logolabel.setBounds(50, 0, 100, 95);
        logolabel.setIcon(logoicon1);

        JTextField searchfield = new JTextField(" Search....");
        searchfield.setEditable(true);
        searchfield.setBorder(null);
        searchfield.setSize(500, 30);
        searchfield.setLocation(220, 25);

        MyButton searchbutton = new MyButton("\uD83D\uDD0D");
        searchbutton.setSize(30, 30);
        searchbutton.setBounds(710, 15, 50, 50);

        JLabel adminlabel = new JLabel("Admin");
        adminlabel.setFont(new Font("SanaSerif", Font.BOLD, 30));
        adminlabel.setSize(300, 40);
        adminlabel.setForeground(new Color(0, 51, 102));
        adminlabel.setBounds(800, 20, 100, 40);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(135, 206, 235));
        panel1.setBounds(0, 0, 1000, 85);
        panel1.setLayout(null);
        panel1.add(logolabel);
        panel1.add(searchfield);
        panel1.add(searchbutton);
        panel1.add(adminlabel);
        //------------------------------------//
        userbutton = new MyButton("User               >");
        userbutton.setSize(200, 30);
        userbutton.setForeground(Color.WHITE);
        userbutton.addActionListener(e->{
            frame.dispose();
            UserManager userManager = new UserManager();
            userManager.loadUsersFromFile();
            userManager.displayAllUsers();
        });
        productbutton = new MyButton("Product            >");
        productbutton.setSize(200, 30);
        productbutton.addActionListener(e -> {
            frame.dispose();
            productManager.loadProductsFromFile();
            productManager.adminproductpanel();
        });
        productbutton.setForeground(Color.WHITE);
        orderbutton = new MyButton("Order              >");
        orderbutton.setSize(200, 30);
        orderbutton.setForeground(Color.WHITE);
        orderbutton.addActionListener(e -> {
            frame.dispose();
            orderManager.loadOrdersFromFile();
            orderManager.displayAllOrders();
        });

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.DARK_GRAY);
        panel2.setBounds(20, 100, 230, 150);
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panel2.add(userbutton);
        panel2.add(productbutton);
        panel2.add(orderbutton);
        //----------------//
        updatebutton = new MyButton("Update              >");
        updatebutton.setSize(200, 30);
        updatebutton.setForeground(Color.WHITE);
        updatebutton.addActionListener(e -> {
            frame.dispose();
            adminMenu.updatemenu();
        });
        removebutton = new MyButton("Remove             >");
        removebutton.setSize(200, 30);
        removebutton.setForeground(Color.WHITE);
        removebutton.addActionListener(e -> {
            frame.dispose();
            adminMenu.removeproduct();
        });
        Addbutton = new MyButton("Add                  >");
        Addbutton.setSize(200, 30);
        Addbutton.setForeground(Color.WHITE);
        Addbutton.addActionListener(e->{
            frame.dispose();
            adminMenu.addmenu();
        });

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.DARK_GRAY);
        panel3.setBounds(20, 260, 230, 150);
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));
        panel3.add(Addbutton);
        panel3.add(updatebutton);
        panel3.add(removebutton);
        //---------------------//
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\rimon\\Downloads\\20250818_0152_Online Shopping Illustration_remix_01k2wsacj9etv96ajfh6w8kwjb.png");
        JPanel panel4 =  new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel4.setBackground(Color.DARK_GRAY);
        panel4.setBounds(20, 420, 230, 120);
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));


        MyButton settingbutton = new MyButton("⚙\uFE0F");
        settingbutton.setFont(new Font("SanaSerif",Font.BOLD,40));
        settingbutton.setSize(100,50);
        settingbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        settingbutton.setBounds(900,15,100,50);

        JPopupMenu popupmenu = new JPopupMenu();
        JMenuItem home = new JMenuItem("Home");
        home.setFont(new Font("SansSerif", Font.PLAIN, 16));
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));
        home.setForeground(Color.BLACK);

        JMenuItem Logout = new JMenuItem("Main Manu");
        Logout.setFont(new Font("SansSerif", Font.PLAIN, 16));
        Logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Logout.setForeground(Color.BLACK);

        popupmenu.add(home);
        popupmenu.add(Logout);

        settingbutton.addActionListener(e -> {
            popupmenu.show(settingbutton,10,settingbutton.getHeight());
        });
        home.addActionListener(e -> {
            frame.dispose();
            Firstpage f = new Firstpage();
        });
        Logout.addActionListener(e -> {
            frame.dispose();
            AdminFrame adminFrame = new AdminFrame();
            adminFrame.admininterface();
        });
        panel1.add(settingbutton);

        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
    }
    public void addScrollPanel(JScrollPane scrollpane) {
        frame.add(scrollpane);
    }
    public void addPanel(JPanel panel) {
        frame.add(panel);
    }
    public void admininterface(){
        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\Downloads\\ChatGPT Image Aug 13, 2025, 11_40_29 AM.png");
        JPanel panel5 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image1.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel5.setBounds(275, 100, 525, 280);
        panel5.setLayout(null);
        frame.add(panel5);

        JPanel panel9 = new JPanel();
        panel9.setBackground(Color.BLACK);
        panel9.setBounds(275, 390, 525, 150);
        frame.add(panel9);

        ImageIcon image2 = new ImageIcon("C:\\Users\\rimon\\Downloads\\ChatGPT Image Aug 15, 2025, 08_07_25 PM.png");
        JPanel panel6 = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image2.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel6.setBounds(820, 100, 150, 150);
        frame.add(panel6);

        ImageIcon image3 = new ImageIcon("C:\\Users\\rimon\\Downloads\\ChatGPT Image Aug 15, 2025, 09_03_38 PM.png");
        JPanel panel7 = new JPanel(){
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image3.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel7.setBounds(820, 260, 150, 150);
        frame.add(panel7);

        ImageIcon image4 = new ImageIcon("C:\\Users\\rimon\\Downloads\\ChatGPT Image Aug 15, 2025, 09_09_12 PM.png");
        JPanel panel8 = new JPanel() {
            protected void paintComponent(Graphics g){
                super.paintComponent(g);
                g.drawImage(image4.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel8.setBounds(820, 420, 150, 150);
        frame.add(panel8);
    }
    public void userdisable(){
        userbutton.setEnabled(false);
    }
    public void productdisable(){
        productbutton.setEnabled(false);
    }
    public void orderdisable(){
        orderbutton.setEnabled(false);
    }
    public void updatedisable(){
        updatebutton.setEnabled(false);
    }
    public void removedisable(){
        removebutton.setEnabled(false);
    }
    public void adddisable(){
        Addbutton.setEnabled(false);
    }
    public void pendingorderdisable(){
        pendingorderbutton.setEnabled(false);
    }
    public void pendingremovedisable(){
        pendingremovebutton.setEnabled(false);
    }
    public void framedispose(){
        frame.dispose();
    }
}
