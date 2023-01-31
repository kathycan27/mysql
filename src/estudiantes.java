import javax.sound.midi.ShortMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class estudiantes {

    JPanel panel1;
    PreparedStatement ps;
    private JTextField txtmail;
    private JTextField txtid;
    private JTextField txtnombre;
    private JTextField txtapellido;
    private JButton btn;

    public estudiantes() {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection con;
                try
                {
                    con=getConnection();
                    ps = con.prepareStatement("INSERT INTO datoses(ID, NOMBRE, APELLIDO, CORREO) values(?,?,?,?)");
                    ps.setString(1,txtid.getText());
                    ps.setString(2,txtnombre.getText());
                    ps.setString(3,txtapellido.getText());
                    ps.setString(4,txtmail.getText());
                    System.out.println(ps);
                    int res=ps.executeUpdate();
                    if(res>0)
                    {
                        JOptionPane.showMessageDialog(null,"Persona Guardada");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"ERROR","ERROR",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (HeadlessException | SQLException f) {
                    throw new RuntimeException(f);
                }

            }
        });
    }
    public static Connection getConnection() {
        Connection con = null;
        String base = "bdd";
        String url = "jdbc:mysql://localhost:3306/" + base;
        String user = "root";
        String password = "Luchito2724";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
