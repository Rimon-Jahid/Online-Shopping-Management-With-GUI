
public class Main {
    public static void main(String[] args) {
        ProductManager pm = new ProductManager(null);

        pm.loadProductsFromFile();
        pm.seedDefaultProducts();
        UserManager um = new UserManager();
        um.loadUsersFromFile();
        OrderManager om = new OrderManager();
        om.loadOrdersFromFile();
        Firstpage firstpage = new Firstpage();
    }
}
