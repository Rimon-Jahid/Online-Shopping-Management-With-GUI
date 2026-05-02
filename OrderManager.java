import java.awt.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class OrderManager {
    //Myframe frame = new Myframe();
    UserManager userManager = new UserManager();
    String email;
    String name;
    int id;
    ArrayList<Order> orderList = new ArrayList<>();
    ArrayList<Order> pendingOrders = new ArrayList<>();
    final String orderFile = "orders.txt";
    private int currentOrderId = 1;
    Scanner sc = new Scanner(System.in);

    public void placeOrder(int productId, int userId, float price) {
        int orderId = currentOrderId++;
        float totalPrice = price * 0.90f;
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String orderDateTime = date.format(formatter);
        String stutas = "Confirmed";
        Order newOrder = new Order(orderId, productId, userId, totalPrice,orderDateTime, stutas);
        orderList.add(newOrder);
        pendingOrders.add(newOrder);
        saveOrderToFile(newOrder);
        JOptionPane.showMessageDialog(null, "Order Placed");
    }

    public void displayAllOrders() {
        AdminFrame adminFrame = new AdminFrame();

        if (orderList.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        String[] columnNames = {"ID", "User ID", "Product ID", "Total Price", "Status"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Order order : orderList) {
            Object[] row = {order.orderId,order.userId,order.productId,order.totalPrice,order.orderDatetime,order.status};
            model.addRow(row);
        }

        JTable userTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(275, 100,680,420);
        scrollPane.setOpaque(true);
        adminFrame.addScrollPanel(scrollPane);
    }

    public void displayOrdersByUser(int userId,String email) {
        boolean found = false;

        String[] columnNames = {"Order No", "Product ID", "User ID", "Total Price", "Order Date", "Order Status"};

        List<Object[]> rowData = new ArrayList<>();

        for (Order o : orderList) {
            if (o.userId == userId) {
                found = true;
                rowData.add(new Object[]{
                        o.orderId,
                        o.productId,
                        o.userId,
                        o.totalPrice,
                        o.orderDatetime,
                        o.status
                });
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "No orders found for this user.");
            return;
        }

        Object[][] dataArray = rowData.toArray(new Object[0][]);

        JTable table = new JTable(dataArray, columnNames);
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel3 = new JPanel();
        panel3.setBounds(40,140,618,360);
        panel3.setLayout(new BorderLayout());
        panel3.add(scrollPane, BorderLayout.CENTER);
        CustomerFrame frame = new CustomerFrame(email);
        frame.addpanel(panel3);

    }

    public void displayPendingOrders() {
        if (pendingOrders.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }
        System.out.printf("%-10s %-10s %-10s %-10s\n", "Order ID", "Product ID", "User ID", "Order Date");
        for (Order o : pendingOrders) {
            System.out.printf("%-10d %-10d %-10d %-10s\n", o.orderId, o.productId, o.userId, o.orderDatetime);//from then
        }
    }

    public void processOrder() {
        if (pendingOrders.isEmpty()) {
            System.out.println("No pending orders.");
            return;
        }

        System.out.printf("%-10s %-10s %-10s %-10s\n", "Order ID", "Product ID", "User ID", "Order Date");

        Iterator<Order> iterator = pendingOrders.iterator();
        while (iterator.hasNext()) {
            Order o = iterator.next();
            System.out.printf("%-10d %-10d %-10d %-10s\n", o.orderId, o.productId, o.userId, o.orderDatetime);
            System.out.println("Press ok to confirm this order, and no for cancel.");
            String state = sc.nextLine();
            if (state.equals("ok")) {
                o.status = "Confirmed";
                saveOrderToFile(o);
                iterator.remove();
                System.out.println("Order confirmed.");
            } else if (state.equals("no")) {
                o.status = "Cancelled";
                saveOrderToFile(o);
                iterator.remove();
                System.out.println("Order cancelled.");
            } else {
                System.out.println("Order still in pending.");
            }
        }
    }


    public void cancelOrder(int orderId) {
        for (Order o : pendingOrders) {
            if (o.orderId == orderId) {
                pendingOrders.remove(o);
                o.status="Cancelled";
                saveOrderToFile(o);
                System.out.println("Order ID " + orderId + " cancelled.");
                return;
            }
        }
        System.out.println("Order ID not found in pending list.");
    }

    private void saveOrderToFile(Order order) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(orderFile, true))) {
            writer.write(order.orderId + "," + order.productId + "," + order.userId + "," + order.totalPrice+","+order.orderDatetime+","+order.status);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving order to file.");
        }
    }

    public void loadOrdersFromFile() {
        File file = new File(orderFile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    Order o = new Order(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Float.parseFloat(parts[3]),parts[4],parts[5]);
                    orderList.add(o);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading orders from file.");
        }
    }
}
