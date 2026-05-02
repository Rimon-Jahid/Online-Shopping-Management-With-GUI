import javax.swing.*;

public class Myframe extends JFrame{
    public Myframe(){
        ImageIcon image2=new ImageIcon("C:\\Users\\rimon\\OneDrive\\Documents\\Project with swing\\Logo.jpg");

        setTitle("Easy Kinakata");
        setSize(1000,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(image2.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        setVisible(true);
    }
}
