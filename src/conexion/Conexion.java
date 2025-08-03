
package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class Conexion {

    //conexion local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/sistema_retell_db", "root", "1090476974");
            return cn;

        } catch (SQLException e) {
            System.out.println("error en la conexion local: " + e);
        }
        return null;
    }
}
