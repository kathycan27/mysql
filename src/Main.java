import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame =new JFrame("estudiantes");

        frame.setContentPane(new estudiantes().panel1);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}