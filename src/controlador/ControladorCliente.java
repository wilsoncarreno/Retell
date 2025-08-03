
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Cliente;
public class ControladorCliente {
    
    
    //metodo para guardar Cliente 
    public boolean Guardar(Cliente cliente){
        boolean respuesta=false;
        Connection cn=conexion.Conexion.conectar();
        try{
            PreparedStatement consulta=cn.prepareStatement("INSERT INTO tb_cliente (idCliente, nombre, apellido, cedula, telefono, direccion, estado) VALUES (?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, 0);//idCliente
            consulta.setString(2,cliente.getNombre());
            consulta.setString(3,cliente.getApellido());
            consulta.setString(4,cliente.getCedula());
            consulta.setString(5,cliente.getTelefono());
            consulta.setString(6, cliente.getDireccion());
            consulta.setInt(7,cliente.getEstado());
            if (consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            
        }catch(SQLException e){
            System.out.println("error al guardar el producto"+e);            
        }
        return respuesta;
    }
    
    
    // metodo para vrificar si el cliente existe
    public boolean ExisteCliente(String cliente){
        boolean respuesta=false;
        String sql="SELECT nombre FROM tb_cliente WHERE nombre= '"+cliente+"';";
        Statement st;
        try{
            Connection cn=conexion.Conexion.conectar();
            st=cn.createStatement();
            ResultSet rs =st.executeQuery(sql);
            while(rs.next()){
                respuesta=true;
            }
        }catch(SQLException e){
            System.out.println("error al consultar el Cliente"+ e.getMessage());
        }
        return respuesta;
        
    }
}
