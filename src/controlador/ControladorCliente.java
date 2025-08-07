
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
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
        String sql="SELECT cedula FROM tb_cliente WHERE cedula= '"+cliente+"';";
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
    
    //metodo actualizar
    public boolean actualizar(Cliente objeto, int idCliente) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cliente set nombre=?, apellido=?, cedula=?, telefono=?, direccion=?, estado=? where idCliente ='"+idCliente+"';");
            
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3,objeto.getCedula());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setInt(6, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al actualizar el Cliente:  " + e);
        }
        return respuesta;
    }
    //metodo Eliminar
    public boolean eliminar( int idCliente) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        PreparedStatement consulta=null;
        try {
            consulta = cn.prepareStatement("delete from tb_Cliente where idCliente = ?");
            
            consulta.setInt(1, idCliente);
            int filasAfectadas=consulta.executeUpdate();
            
            if (filasAfectadas > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el Cliente :  " + e.getMessage());
        }
        return respuesta;
    }
    public boolean ValidarCampoNumerico(String campo){
        boolean respuesta=false;
        try{
            int numero=Integer.parseInt(campo);
            if(numero>0){
                respuesta=true;
            }else{
                JOptionPane.showMessageDialog(null, "ingresaste un numero invalido");
            }
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Introduzca un numero valido");
        }
        
        
        return respuesta;
        
    }
}
