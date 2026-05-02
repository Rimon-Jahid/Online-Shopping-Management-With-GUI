import java.awt.*;
import javax.swing.*;

public class CustomerFrame {
    Myframe frame = new Myframe();
    String email;
    String name;
    int id;
    UserManager userManager = new UserManager();
    OrderManager orderManager = new OrderManager();

    MyButton Cosmetics;
    MyButton Fruits;
    MyButton Vegetables;
    MyButton Snacks;
    MyButton SportsItems;
    MyButton Accessories;
    MyButton Groceries;
    MyButton ITItems;
    Customer customer;

    public CustomerFrame(String email) {
        this.email = email;
        System.out.println(this.email);
        userManager.loadUsersFromFile();
        orderManager.loadOrdersFromFile();

        this.name=userManager.findUserwithemail(this.email);
        this.id=userManager.findUserId(this.email);

        JLabel logolabel = new JLabel();
        ImageIcon logoicon = new ImageIcon("C:\\Users\\rimon\\Downloads\\Logo-removebg-preview.png");
        Image logoimage = logoicon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon logoicon1 = new ImageIcon(logoimage);
        logolabel.setBounds(50,0,100,95);
        logolabel.setIcon(logoicon1);

        JTextField searchfield = new JTextField(" Search....");
        searchfield.setEditable(true);
        searchfield.setBorder(null);
        searchfield.setSize(500,30);
        searchfield.setLocation(220,25);

        MyButton searchbutton = new MyButton("\uD83D\uDD0D");
        searchbutton.setSize(30,30);
        searchfield.setForeground(Color.BLACK);
        searchbutton.setBounds(710,15,50,50);

        JLabel namelabel = new JLabel();
        namelabel.setText(this.name);
        namelabel.setFont(new Font("SanaSerif",Font.BOLD,30));
        namelabel.setSize(200,40);
        namelabel.setForeground(new Color(0, 51, 102));
        namelabel.setBounds(800,20,100,40);

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

        JMenuItem Logout = new JMenuItem("Logout");
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
            Customer c = new Customer();
            c.CustomerLogin();;
        });


        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(135, 206, 235));
        panel1.setBounds(0,0,1000,75);
        panel1.setLayout(null);
        panel1.setOpaque(true);
        panel1.add(logolabel);
        panel1.add(searchfield);
        panel1.add(searchbutton);
        panel1.add(namelabel);
        panel1.add(settingbutton);

        Fruits = new MyButton("Fruits");
        Fruits.setSize(100,30);
        Fruits.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.fruits();
        });

        Snacks = new MyButton("Snacks");
        Snacks.setSize(100,30);
        Snacks.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.snacs();
        });


        Groceries = new MyButton("Groceries");
        Groceries.setSize(100,30);
        Groceries.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.groceries();
        });

        ITItems = new MyButton("IT Items");
        ITItems.setSize(100,30);
        ITItems.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.itItem();
        });

        Cosmetics = new MyButton("Cosmetics");
        Cosmetics.setSize(100,30);
        Cosmetics.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.cosmetics();
        });

        SportsItems = new MyButton("Sports Items");
        SportsItems.setSize(100,30);
        SportsItems.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.sportsItem();
        });

        Accessories = new MyButton("Accessories");
        Accessories.setSize(100,30);
        Accessories.addActionListener(e -> {
            frame.dispose();
            CustomerManu customerManu = new CustomerManu(this.email);
            customerManu.accecories();
        });

        Vegetables = new MyButton("Vegetables");
        Vegetables.setSize(100,30);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.WHITE);
        panel2.setBounds(0,75,1000,45);
        panel2.setOpaque(true);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT,18,10));

        panel2.add(Fruits);
        panel2.add(Snacks);
        panel2.add(Groceries);
        panel2.add(ITItems);
        panel2.add(Cosmetics);
        panel2.add(SportsItems);
        panel2.add(Accessories);
        panel2.add(Vegetables);

        JTextField searchfield1 = new JTextField("  Search User");
        searchfield1.setSize(100,30);
        searchfield1.setBounds(25,30,200,30);
        searchfield1.setEditable(true);
        searchfield1.setBorder(null);

        MyButton searchbutton1 = new MyButton("\uD83D\uDD0D");
        searchbutton1.setSize(30,30);
        searchbutton1.setForeground(Color.BLACK);
        searchbutton1.setBounds(220,20,50,50);

        MyButton ViewOrerHistory = new MyButton("View Order History");
        ViewOrerHistory.setSize(100,30);
        ViewOrerHistory.setForeground(Color.BLACK);
        ViewOrerHistory.setContentAreaFilled(true);
        ViewOrerHistory.setBackground(Color.WHITE);
        ViewOrerHistory.setBounds(25,100,200,30);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.PINK);
        panel4.setBounds(680,140,270,170);
        panel4.setOpaque(true);
        panel4.setLayout(null);
        panel4.add(searchfield1);
        panel4.add(searchbutton1);
        panel4.add(ViewOrerHistory);

        ViewOrerHistory.addActionListener(e -> {
            frame.remove(panel4);
            orderManager.displayOrdersByUser(id, this.email);
        });

        ImageIcon image3 = new ImageIcon("C:\\Users\\rimon\\Downloads\\panel5.jpg");
        JPanel panel5 = new JPanel(){
            protected  void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image3.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel5.setLayout(null);
        panel5.setBounds(680,330,270,170);
        panel5.setOpaque(true);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel4);
        frame.add(panel5);
    }
    public void addpanel(JPanel panel){
        frame.add(panel);
    }
    public void addScrollpanel(JScrollPane panel){
        frame.add(panel);
        frame.revalidate();
        frame.repaint();
    }
    public  void CustomerInterface(){
        ImageIcon image1 = new ImageIcon("C:\\Users\\rimon\\Downloads\\FinalPanel3.png");
        JPanel panel3 = new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image1.getImage(), 0, 0,getWidth(),getHeight(), this);
            }
        };
        panel3.setBounds(40,140,618,360);
        panel3.setOpaque(true);
        frame.add(panel3);
    }
    public void setCosmeticsDisable(){
        Cosmetics.setEnabled(false);
        Cosmetics.setForeground(Color.GRAY);
    }
    public void setFruitsDisable(){
        Fruits.setEnabled(false);
        Fruits.setForeground(Color.GRAY);
    }

    public void setSnacksDisable(){
        Snacks.setEnabled(false);
        Snacks.setForeground(Color.GRAY);
    }
    public void setGroceriesDisable(){
        Groceries.setEnabled(false);
        Groceries.setForeground(Color.GRAY);
    }
    public void setAccessoriesDisable(){
        Accessories.setEnabled(false);
        Accessories.setForeground(Color.GRAY);
    }
    public void setItItemsDisable(){
        ITItems.setEnabled(false);
        ITItems.setForeground(Color.GRAY);
    }
    public void setsportsItemsDisable(){
        SportsItems.setEnabled(false);
        SportsItems.setForeground(Color.GRAY);
    }
    public void setVegetablesDisable(){
        Vegetables.setEnabled(false);
        Vegetables.setForeground(Color.GRAY);
    }
    public void getemail2(String email2){
        this.email = email2;
        System.out.println(email);
    }
}
