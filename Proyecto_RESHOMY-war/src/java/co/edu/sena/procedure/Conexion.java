
package co.edu.sena.procedure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection con = null;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Connection conexion() {

        try {
            //cargar nuestro driver
           Class.forName("com.mysql.jdbc.Driver");
           String BD = "ResHomy";
           String usuario= "root";
           String contrasena= "Thegameisover";
           con=DriverManager.getConnection("jdbc:mysql://localhost/"+ BD,usuario,contrasena);
           System.out.println("conexion establecida");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("error en la conexion");
        }
        return con;
    }
}
