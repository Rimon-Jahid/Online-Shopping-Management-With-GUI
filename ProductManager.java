import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
class ProductManager {
    ArrayList<Product> products = new ArrayList<>();
    OrderManager orderManager;
    UserManager userManager;
    CustomerManu customerManu;
    public ProductManager(CustomerManu customerManu) {
        userManager = new UserManager();
        userManager.loadUsersFromFile();
        this.customerManu = customerManu;
    }
    public Product findProduct(int code) {
        loadProductsFromFile();
        System.out.println("Product code: " + code);
        for (Product p : products) {
            if (p.code == code) {
                return p;
            }
        }
        System.out.println("Product not found");
        return null;
    }

    public void insertProduct(int code, String name, float price, String prodDate, String expireDate,String pic) {
        if (findProduct(code) != null) {
            System.out.println("This product already exists!");
            return;
        }
        saveProductToFile(code, name, price, prodDate, expireDate, pic);
    }

    public void addproduct(int code, String name, float price, String prodDate, String expireDate,String pic){
        Product p = findProduct(code);
        if (p.code != code) {
            saveProductToFile(code, name, price, prodDate, expireDate, pic);
            JOptionPane.showMessageDialog(null, "Product added successfully!");
        }
        else {
            JOptionPane.showMessageDialog(null, "Product already exists!");
        }
        loadProductsFromFile();
    }


    public void Productpanel(int firstCode, int secondCode,String email) {
        for (Product p : products) {
            if (p.code >= firstCode && p.code <= secondCode) {
                System.out.println(p.code + " " + email);
                JPanel panel1 = new JPanel();
                panel1.setLayout(null);
                panel1.setBackground(Color.white);

                ImageIcon image1=new ImageIcon(p.pic);
                Image image2=image1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                ImageIcon image =new ImageIcon(image2);
                JLabel label1 = new JLabel();
                label1.setBounds(30,10,150,125);
                label1.setIcon(image);

                JLabel label2 = new JLabel();
                label2.setText(p.name);
                label2.setFont(new Font("SansSerif",Font.BOLD,20));
                label2.setBounds(30,140,120,25);

                JLabel label3 = new JLabel();
                String str = String.valueOf(p.code);
                label3.setText("Code : "+str);
                label3.setFont(new Font("SansSerif",Font.BOLD,10));
                label3.setBounds(130,160,90,15);

                JLabel label4 = new JLabel();
                label4.setText("Production date : "+p.prodDate);
                label4.setFont(new Font("Arial",Font.PLAIN,10));
                label4.setBounds(30,180,190,15);
                JLabel label5 = new JLabel();
                label5.setText("expire date       : "+p.expireDate);
                label5.setFont(new Font("Arial",Font.PLAIN,10));
                label5.setBounds(30,195,190,15);

                JLabel label6 = new JLabel();
                label6.setText(p.price+" ৳");
                label6.setFont(new Font("SansSerif",Font.BOLD,25));
                label6.setForeground(Color.RED);
                label6.setBounds(75,230,190,31);

                JButton button1 = new JButton("🛒 Buy Now");
                button1.setFont(new Font("SansSerif",Font.BOLD,10));
                button1.setForeground(Color.BLUE);
                button1.setBackground(new Color(245, 245, 245));
                button1.setBounds(18,265,170,25);
                button1.setFocusable(false);
                button1.addActionListener(e -> {
                    UserManager userManager = new UserManager();
                    userManager.loadUsersFromFile();
                    int id=userManager.findUserId(email);
                    orderManager = new OrderManager();
                    orderManager.placeOrder(p.code,id,p.price);
                    orderManager.displayPendingOrders();
                });

                panel1.add(label1);
                panel1.add(label2);
                panel1.add(label3);
                panel1.add(label4);
                panel1.add(label5);
                panel1.add(label6);
                panel1.add(button1);
                panel1.setOpaque(true);

                customerManu.addSubpanel(panel1);
            }
        }

    }

    public void adminproductpanel(){
        AdminFrame adminFrame = new AdminFrame();

        JPanel panel = new JPanel();
        panel.setBounds(275,100,680,8000);
        panel.setPreferredSize(new Dimension(680,8000));
        panel.setLayout(new GridLayout(0,3,5,5));

        System.out.println("Admin product panel loaded!");
        for (Product p : products) {
            if(products==null || products.size()==0) {
                System.out.println("No products found");
            }



            JPanel panel1 = new JPanel();
            panel1.setLayout(null);
            panel1.setBackground(Color.white);

            ImageIcon image1 = new ImageIcon(p.pic);
            Image image2 = image1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(image2);
            JLabel label1 = new JLabel();
            label1.setBounds(30, 10, 150, 125);
            label1.setIcon(image);

            JLabel label2 = new JLabel();
            label2.setText(p.name);
            label2.setFont(new Font("SansSerif", Font.BOLD, 20));
            label2.setBounds(30, 140, 120, 25);

            JLabel label3 = new JLabel();
            String str = String.valueOf(p.code);
            label3.setText("Code : " + str);
            label3.setFont(new Font("SansSerif", Font.BOLD, 10));
            label3.setBounds(130, 160, 90, 15);

            JLabel label4 = new JLabel();
            label4.setText("Production date : " + p.prodDate);
            label4.setFont(new Font("Arial", Font.PLAIN, 10));
            label4.setBounds(30, 180, 190, 15);
            JLabel label5 = new JLabel();
            label5.setText("expire date       : " + p.expireDate);
            label5.setFont(new Font("Arial", Font.PLAIN, 10));
            label5.setBounds(30, 195, 190, 15);

            JLabel label6 = new JLabel();
            label6.setText(p.price + " ৳");
            label6.setFont(new Font("SansSerif", Font.BOLD, 25));
            label6.setForeground(Color.RED);
            label6.setBounds(75, 230, 190, 31);

            panel1.add(label1);
            panel1.add(label2);
            panel1.add(label3);
            panel1.add(label4);
            panel1.add(label5);
            panel1.add(label6);
            panel.add(panel1);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(275, 100,680,420);
        scrollPane.setOpaque(true);
        adminFrame.addScrollPanel(scrollPane);

    }



    public void removeProductFromFile(int code) {
        File productFile = new File("products.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(productFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) != code) {
                    updatedLines.add(line); // Keep lines that don't match the code
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productFile))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
        }
        loadProductsFromFile();
    }



    public void updateProductInFile(int code, String name, float price, String prodDate, String expireDate, String pic) {
        File productFile = new File("products.txt");
        ArrayList<String> updatedLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(productFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(",");
                if (Integer.parseInt(parts[0]) == code) {
                    updatedLines.add(code + "," + name + "," + price + "," + prodDate + "," + expireDate + "," + pic);
                } else {
                    updatedLines.add(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file.");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productFile))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file.");
        }
        loadProductsFromFile();
    }



    public void seedDefaultProducts() {
        System.out.println("Nothing");
        insertProduct(101, "Mango(kg)", 230.00f, "28/11/2024", "06/12/2024","C:\\Users\\rimon\\Downloads\\Mango.png");
        insertProduct(102, "Apple(kg)", 150.00f, "28/11/2024", "06/12/2024","C:\\Users\\rimon\\Downloads\\Apple.png");
        insertProduct(103, "Watermelon", 60.00f, "28/11/2024", "06/12/2024","C:\\Users\\rimon\\Downloads\\Watermelon.png");
        insertProduct(104, "Strawberry(kg)", 200.00f, "28/11/2024", "06/12/2024","C:\\Users\\rimon\\Downloads\\Strawberry.png");
        insertProduct(105, "Orange(kg)", 220.00f, "28/11/2024", "06/12/2024","C:\\Users\\rimon\\Downloads\\Orange.png");
        insertProduct(201, "Chips", 15.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Chips.png");
        insertProduct(202, "Biscuits", 60.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Biscuits.png");
        insertProduct(203, "Cake", 80.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\cake.png");
        insertProduct(204, "Juice", 20.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Juice.png");
        insertProduct(205, "Ice-cream", 50.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Ice-cream.png");
        insertProduct(301, "Rice(kg)", 75.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Rice.png");
        insertProduct(302, "Sugar(kg)", 135.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Suger.png");
        insertProduct(303, "Salt(kg)", 45.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Salt.png");
        insertProduct(304, "Flour(kg)", 75.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\Atta.png");
        insertProduct(306, "Dal(kg)", 120.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\dal.png");
        insertProduct(401, "Headphone", 450.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\headphon.png");
        insertProduct(402, "Mouse", 950.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\mouse.png");
        insertProduct(403, "Router", 850.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\router.png");
        insertProduct(404, "Smartwatch", 1550.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\watch.png");
        insertProduct(405, "Printer", 5550.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\printer.png");
        insertProduct(501, "Shampoo", 350.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\sampo.png");
        insertProduct(502, "Perfume", 350.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\perfume.png");
        insertProduct(503, "Cleanser", 250.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\handwash.png");
        insertProduct(504, "Powder", 100.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\powder.png");
        insertProduct(505, "Toothpaste", 75.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\toothpest.png");
        insertProduct(601, "Football", 450.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\football.png");
        insertProduct(602, "Bat", 450.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\bat.png");
        insertProduct(603, "Badminton", 500.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\badminton.png");
        insertProduct(604, "Cards", 150.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\card.png");
        insertProduct(605, "Chessboard", 400.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\chees.png");
        insertProduct(701, "Facemask", 40.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\mask.png");
        insertProduct(702, "Gloves", 250.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\gloves.png");
        insertProduct(703, "Socks", 150.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\moja.png");
        insertProduct(704, "Handbag", 650.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\bag.png");
        insertProduct(705, "Sunglasses", 200.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\sunglass.png");
        insertProduct(801, "Belts", 350.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\belt.png");
        insertProduct(802, "Carpets", 4450.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\carpet.png");
        insertProduct(803, "Diapers", 850.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\dayapar.png");
        insertProduct(804, "Toys", 350.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\toy.png");
        insertProduct(805, "Umbrella", 320.00f, "06/10/2024", "06/10/2025","C:\\Users\\rimon\\Downloads\\chata.png");
    }
    private void saveProductToFile(int code, String name, float price, String prodDate, String expireDate, String pic) {
        File productFile = new File("products.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(productFile, true))) {
            writer.write(code + "," + name + "," + price + "," + prodDate + "," + expireDate + "," + pic);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing product to file.");
        }
    }

    public void loadProductsFromFile() {
        File productFile = new File("products.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(productFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    int code = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    String prodDate = parts[3].trim();
                    String expireDate = parts[4].trim();
                    String pic = parts[5].trim();

                    products.add(new Product(code, name, price, prodDate, expireDate, pic));
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading products from file: " + e.getMessage());
        }
    }



}

