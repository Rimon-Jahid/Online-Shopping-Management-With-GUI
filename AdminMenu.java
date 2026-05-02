import java.awt.*;
import javax.swing.*;

public class AdminMenu {
    CustomerManu customerManu;
    ProductManager productManager;
    public AdminMenu() {
        productManager = new ProductManager(null);
        productManager.loadProductsFromFile();

    }
    public void addmenu(){
        AdminFrame adminFrame = new AdminFrame();
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(0, 102, 204);
                GradientPaint gradient1 = new GradientPaint(0,0,color1,getWidth(),getHeight(),color2);
                g2d.setPaint(gradient1);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(275, 100,680,420);
        panel.setPreferredSize(new Dimension(680,420));
        panel.setLayout(null);
        adminFrame.addPanel(panel);
        adminFrame.adddisable();
        JLabel codelabel = new JLabel("Product Code");
        codelabel.setFont(new Font("Serif", Font.PLAIN, 15));
        codelabel.setForeground(Color.WHITE);
        codelabel.setBounds(150, 20, 200, 20);

        JTextArea codtext = new JTextArea();
        codtext.setBounds(150, 42, 350, 20);

        JLabel Pname = new JLabel("Product Name");
        Pname.setFont(new Font("Serif", Font.PLAIN, 15));
        Pname.setForeground(Color.WHITE);
        Pname.setBounds(150, 80, 200, 20);

        JTextArea nametext = new JTextArea();
        nametext.setBounds(150, 102, 350, 20);

        JLabel Pprice = new JLabel("Product Price");
        Pprice.setFont(new Font("Serif", Font.PLAIN, 15));
        Pprice.setForeground(Color.WHITE);
        Pprice.setBounds(150, 130, 200, 20);

        JTextArea pricetext = new JTextArea();
        pricetext.setBounds(150, 152, 350, 20);

        JLabel Ppdate = new JLabel("Production date");
        Ppdate.setFont(new Font("Serif", Font.PLAIN, 15));
        Ppdate.setForeground(Color.WHITE);
        Ppdate.setBounds(150, 180, 200, 20);

        JTextArea pdtext = new JTextArea();
        pdtext.setBounds(150, 202, 350, 20);

        JLabel Peddate = new JLabel("Expire date");
        Peddate.setFont(new Font("Serif", Font.PLAIN, 15));
        Peddate.setForeground(Color.WHITE);
        Peddate.setBounds(150, 240, 200, 20);

        JTextArea edtext = new JTextArea();
        edtext.setBounds(150, 262, 350, 20);

        JLabel Ppic = new JLabel("Product Picture");
        Ppic.setFont(new Font("Serif", Font.PLAIN, 15));
        Ppic.setForeground(Color.WHITE);
        Ppic.setBounds(150, 300, 200, 20);

        JTextArea pictext = new JTextArea();
        pictext.setBounds(150, 322, 350, 20);

        JButton add = new JButton("Add Product");
        add.setFont(new Font("Serif", Font.PLAIN, 15));
        add.setForeground(Color.RED);
        add.setBounds(230, 375, 200, 30);
        add.addActionListener(event -> {
            int code = Integer.parseInt(codtext.getText());
            String name = nametext.getText();
            float price = Float.parseFloat(pricetext.getText());
            String pdate = pdtext.getText();
            String edate = edtext.getText();
            String picture = pictext.getText();
            if(code != 0 && name != null && price != 0 && pdate != null && edate != null && picture != null){
                ProductManager pm = new ProductManager(customerManu);
                pm.insertProduct(code, name, price, pdate, edate,picture);
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
            }
            productManager.loadProductsFromFile();
            addmenu();
        });
        JButton back = new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN, 10));
        back.setForeground(Color.RED);
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(600, 10, 60, 20);
        back.addActionListener(event -> {
            adminFrame.frame.dispose();
            AdminFrame admin = new AdminFrame();
            admin.admininterface();
        });

        panel.add(codelabel);
        panel.add(Pname);
        panel.add(Pprice);
        panel.add(Ppdate);
        panel.add(Peddate);
        panel.add(Ppic);

        panel.add(codtext);
        panel.add(nametext);
        panel.add(pricetext);
        panel.add(pdtext);
        panel.add(edtext);
        panel.add(pictext);

        panel.add(add);
        panel.add(back);
    }
    public void updatemenu(){
        AdminFrame adminFrame = new AdminFrame();
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(0, 102, 204);
                GradientPaint gradiyent = new GradientPaint(0,0,color1,getWidth(),getHeight(),color2);
                g2d.setPaint(gradiyent);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(275, 100,680,420);
        panel.setPreferredSize(new Dimension(680,420));
        panel.setLayout(null);

        JTextField searchfield1 = new JTextField("  Product Code");
        searchfield1.setSize(100,30);
        searchfield1.setBounds(25,30,200,30);
        searchfield1.setEditable(true);
        searchfield1.setBorder(null);

        MyButton searchbutton1 = new MyButton("\uD83D\uDD0D");
        searchbutton1.setSize(30,30);
        searchbutton1.setForeground(Color.BLACK);
        searchbutton1.setBounds(220,20,50,50);

        MyButton ViewOrerHistory = new MyButton("Update");
        ViewOrerHistory.setSize(100,30);
        ViewOrerHistory.setForeground(Color.BLACK);
        ViewOrerHistory.setContentAreaFilled(true);
        ViewOrerHistory.setBackground(Color.WHITE);
        ViewOrerHistory.setBounds(25,100,200,30);
        ViewOrerHistory.addActionListener(event -> {
            adminFrame.framedispose();
            int code = Integer.parseInt(searchfield1.getText());
            ProductManager productManu = new ProductManager(customerManu);
            System.out.println("code is " + code);
            productManu.loadProductsFromFile();
            Product product1 = productManu.findProduct(code);
            if(product1 != null){
                updatemenu2(product1);
            }
            else {
                JOptionPane.showMessageDialog(null, "Product not found");
            }
        });

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.PINK);
        panel4.setBounds(0,170,270,170);
        panel4.setOpaque(true);
        panel4.setLayout(null);
        panel4.add(searchfield1);
        panel4.add(searchbutton1);
        panel4.add(ViewOrerHistory);

        panel.add(panel4);
        adminFrame.addPanel(panel);
    }
    public void updatemenu2(Product product){
        AdminFrame adminFrame = new AdminFrame();
        Product product1 = product;
        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(0, 102, 204);
                GradientPaint gradient1 = new GradientPaint(0,0,color1,getWidth(),getHeight(),color2);
                g2d.setPaint(gradient1);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(275, 100,680,420);
        panel.setPreferredSize(new Dimension(680,420));
        panel.setLayout(null);
        adminFrame.addPanel(panel);
        adminFrame.adddisable();
        JLabel codelabel = new JLabel("Product Code");
        codelabel.setFont(new Font("Serif", Font.PLAIN, 15));
        codelabel.setForeground(Color.WHITE);
        codelabel.setBounds(150, 20, 200, 20);

        JTextArea codtext = new JTextArea();
        codtext.setText(String.valueOf(product1.code));
        codtext.setBounds(150, 42, 350, 20);

        JLabel Pname = new JLabel("Product Name");
        Pname.setFont(new Font("Serif", Font.PLAIN, 15));
        Pname.setForeground(Color.WHITE);
        Pname.setBounds(150, 80, 200, 20);

        JTextArea nametext = new JTextArea();
        nametext.setText(product1.name);
        nametext.setBounds(150, 102, 350, 20);

        JLabel Pprice = new JLabel("Product Price");
        Pprice.setFont(new Font("Serif", Font.PLAIN, 15));
        Pprice.setForeground(Color.WHITE);
        Pprice.setBounds(150, 130, 200, 20);

        JTextArea pricetext = new JTextArea();
        pricetext.setText(String.valueOf(product1.price));
        pricetext.setBounds(150, 152, 350, 20);

        JLabel Ppdate = new JLabel("Production date");
        Ppdate.setFont(new Font("Serif", Font.PLAIN, 15));
        Ppdate.setForeground(Color.WHITE);
        Ppdate.setBounds(150, 180, 200, 20);

        JTextArea pdtext = new JTextArea();
        pdtext.setText(product1.prodDate);
        pdtext.setBounds(150, 202, 350, 20);

        JLabel Peddate = new JLabel("Expire date");
        Peddate.setFont(new Font("Serif", Font.PLAIN, 15));
        Peddate.setForeground(Color.WHITE);
        Peddate.setBounds(150, 240, 200, 20);

        JTextArea edtext = new JTextArea();
        edtext.setText(product1.expireDate);
        edtext.setBounds(150, 262, 350, 20);

        JLabel Ppic = new JLabel("Product Picture");
        Ppic.setFont(new Font("Serif", Font.PLAIN, 15));
        Ppic.setForeground(Color.WHITE);
        Ppic.setBounds(150, 300, 200, 20);

        JTextArea pictext = new JTextArea();
        pictext.setText(product1.pic);
        pictext.setBounds(150, 322, 350, 20);

        JButton add = new JButton("Update Product");
        add.setFont(new Font("Serif", Font.PLAIN, 15));
        add.setForeground(Color.RED);
        add.setBounds(230, 375, 200, 30);
        add.addActionListener(event -> {
            int code = Integer.parseInt(codtext.getText().trim());
            String name = nametext.getText().trim();
            float price = Float.parseFloat(pricetext.getText().trim());
            String pdate = pdtext.getText().trim();
            String edate = edtext.getText().trim();
            String picture = pictext.getText().trim();
            if(code != 0 && name != null && price != 0 && pdate != null && edate != null && picture != null){
                ProductManager pm = new ProductManager(customerManu);
                pm.updateProductInFile(code,name,price,pdate,edate,picture);
                JOptionPane.showMessageDialog(null, "Product Updated","Information",JOptionPane.INFORMATION_MESSAGE);
                updatemenu();
            }
            else{
                JOptionPane.showMessageDialog(null, "Please fill all the fields");
                updatemenu();
            }

        });
        JButton back = new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN, 10));
        back.setForeground(Color.RED);
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(600, 10, 60, 20);
        back.addActionListener(event -> {
            adminFrame.framedispose();
            updatemenu();
        });

        panel.add(codelabel);
        panel.add(Pname);
        panel.add(Pprice);
        panel.add(Ppdate);
        panel.add(Peddate);
        panel.add(Ppic);

        panel.add(codtext);
        panel.add(nametext);
        panel.add(pricetext);
        panel.add(pdtext);
        panel.add(edtext);
        panel.add(pictext);

        panel.add(add);
        panel.add(back);
    }
    public void removeproduct(){
        AdminFrame adminFrame = new AdminFrame();

        JPanel panel = new JPanel(){
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                Color color1 = new Color(0, 51, 102);
                Color color2 = new Color(0, 102, 204);
                GradientPaint gradient1 = new GradientPaint(0,0,color1,getWidth(),getHeight(),color2);
                g2d.setPaint(gradient1);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setBounds(275, 100,680,420);
        panel.setPreferredSize(new Dimension(680,420));
        panel.setLayout(null);

        JTextField searchfield1 = new JTextField("  Product Code");
        searchfield1.setSize(100,30);
        searchfield1.setBounds(25,30,200,30);
        searchfield1.setEditable(true);
        searchfield1.setBorder(null);

        MyButton searchbutton1 = new MyButton("\uD83D\uDD0D");
        searchbutton1.setSize(30,30);
        searchbutton1.setForeground(Color.BLACK);
        searchbutton1.setBounds(220,20,50,50);

        MyButton ViewOrerHistory = new MyButton("Remove");
        ViewOrerHistory.setSize(100,30);
        ViewOrerHistory.setForeground(Color.BLACK);
        ViewOrerHistory.setContentAreaFilled(true);
        ViewOrerHistory.setBackground(Color.WHITE);
        ViewOrerHistory.setBounds(25,100,200,30);
        ViewOrerHistory.addActionListener(event -> {
            adminFrame.framedispose();
            int code = Integer.parseInt(searchfield1.getText());
            ProductManager productManu = new ProductManager(customerManu);
            productManu.loadProductsFromFile();
            System.out.println("code is " + code);
            Product product1 = productManu.findProduct(code);
            if(product1 != null){

                productManu.removeProductFromFile(code);
            }
            else {
                JOptionPane.showMessageDialog(null, "Product not found");
            }
            productManager.loadProductsFromFile();
            removeproduct();
        });
        JButton back = new JButton("Back");
        back.setFont(new Font("Serif", Font.PLAIN, 10));
        back.setForeground(Color.RED);
        back.setFocusable(false);
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setBounds(600, 10, 60, 20);
        back.addActionListener(event -> {
            adminFrame.framedispose();
            AdminFrame adminFrame2 = new AdminFrame();
            adminFrame2.admininterface();
        });
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.PINK);
        panel4.setBounds(0,170,270,170);
        panel4.setOpaque(true);
        panel4.setLayout(null);
        panel4.add(searchfield1);
        panel4.add(searchbutton1);
        panel4.add(ViewOrerHistory);

        panel.add(panel4);
        panel.add(back);
        adminFrame.addPanel(panel);
    }
    public void userList(){

    }
}
