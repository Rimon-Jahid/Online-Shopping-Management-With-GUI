
import java.awt.*;
import javax.swing.*;

public class CustomerManu {
    String email;
    int id;
    CustomerFrame customerFrame;
    ProductManager productManager;
    UserManager userManager;
    OrderManager orderManager;
    JPanel panel;
    public CustomerManu(String email) {
        this.email = email;

        customerFrame = new CustomerFrame(email);
        productManager = new ProductManager(this);
        productManager.loadProductsFromFile();
        userManager = new UserManager();
        orderManager = new OrderManager();

        userManager.loadUsersFromFile();
        orderManager.loadOrdersFromFile();
        this.id = userManager.findUserId(email);

        panel = new JPanel();
        panel.setLayout(new GridLayout(0,3,5,5));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setOpaque(true);

        panel.setPreferredSize(new Dimension(625, 620));

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(40,140,625,360);

        customerFrame.addScrollpanel(scrollPane);
    }

    public void fruits(){
        productManager.Productpanel(100,200,email);
        customerFrame.setFruitsDisable();
    }
    public void snacs(){
        productManager.Productpanel(200,300,email);
        customerFrame.setSnacksDisable();
    }
    public void groceries(){
        productManager.Productpanel(300,400,email);
        customerFrame.setGroceriesDisable();
    }
    public void itItem(){
        productManager.Productpanel(400,500,email);
        customerFrame.setItItemsDisable();
    }
    public void cosmetics(){
        productManager.Productpanel(700,800,email);
        customerFrame.setCosmeticsDisable();
    }
    public void sportsItem(){
        productManager.Productpanel(600,700,email);
        customerFrame.setsportsItemsDisable();
    }
    public void accecories(){
        productManager.Productpanel(800,900,email);
        customerFrame.setAccessoriesDisable();
    }
    public void addSubpanel(JPanel subpanel){
        panel.add(subpanel);
    }

}