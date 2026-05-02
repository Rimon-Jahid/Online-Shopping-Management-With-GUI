import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
class UserManager {
    ArrayList<User> users = new ArrayList<>();
    final String userFile = "users.txt";

    public void addUser(int id, String name, String email, String password, String phone, String address) {
        users.add(new User(id, name, email, password, phone, address));
        saveUserToFile(id, name, email, password, phone, address);
        JOptionPane.showMessageDialog(null, "Account create successfully.Pls login to continue");
    }



    public boolean checkUser(String email, String password) {
        for (User user : users) {
            if (user.email.equals(email) && user.password.equals(password)) {
                System.out.println("User found");
                return true;

            }
        }
        System.out.println("User not found");
        return false;
    }

    public boolean checkUser2(String email, String name) {
        for (User user : users) {
            if (user.email.equals(email) || user.password.equals(name)) {

                return true;

            }
        }
        return false;
    }

    public Boolean findUser2(int id) {
        for (User user : users) {
            if (user.id == id) {
                return true;
            }
        }
        return false;
    }

    public User findUser(int id) {
        for (User user : users) {
            if (user.id == id)
                return user;
        }
        return null;
    }

    public String findUserwithemail(String email) {
        for (User user : users) {
            if (user.email.equals(email)){
                System.out.println("User found");
                return user.name;
            }
        }
        System.out.println("User not found");
        return null;
    }

    public int findUserId(String email) {
        for (User user : users) {
            if (user.email.equals(email)){
                System.out.println("User found");
                return user.id;
            }
        }
        System.out.println("User not found");
        return -1;
    }


    public void displayAllUsers() {
        AdminFrame adminFrame = new AdminFrame();

        if (users.isEmpty()) {
            System.out.println("No users available.");
            return;
        }

        String[] columnNames = {"ID", "Name", "Email", "Phone", "Address"};

        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (User user : users) {
            Object[] row = {user.id, user.name, user.email, user.phone, user.address};
            model.addRow(row);
        }

        JTable userTable = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(userTable);
        scrollPane.setBounds(275, 100,680,420);
        scrollPane.setOpaque(true);
        adminFrame.addScrollPanel(scrollPane);
    }

    public void displayUserById(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println("\nUser Details:");
            System.out.println("ID: " + user.id);
            System.out.println("Name: " + user.name);
            System.out.println("Email: " + user.email);
            System.out.println("Phone: " + user.phone);
            System.out.println("Address: " + user.address);
        } else {
            System.out.println("User not found.");
        }
    }

    private void saveUserToFile(int id, String name, String email, String password, String phone, String address) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
            writer.write(id + "," + name + "," + email + "," + password + "," + phone + "," + address);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing user to file.");
        }
    }

    public void loadUsersFromFile() {
        File file = new File(userFile);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 6) {
                    users.add(new User(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4], parts[5]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading users from file.");
        }
    }
}