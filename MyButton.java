
import java.awt.*;
import javax.swing.*;;

public class MyButton extends JButton{
    public MyButton(String name){
        super(name);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.BLACK);
        setFont(new Font("SansSerif", Font.PLAIN, 16));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
