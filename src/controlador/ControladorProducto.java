
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Producto;

public class ControladorProducto {
    
    
    // metodo para guardar producto
    public boolean guardar(Producto objeto){    
        boolean respuesta = false;
        Connection cn=conexion.Conexion.conectar();
        
        try{
            
            PreparedStatement consulta= cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1,0);//id
            consulta.setString(2,objeto.getNombre());
            consulta.setInt(3,objeto.getCantidad());
            consulta.setDouble(4,objeto.getPrecio());
            consulta.setString(5,objeto.getDescripcion());
            consulta.setInt(6,objeto.getPorcentajeIva());
            consulta.setInt(7,objeto.getIdCategoria());
            consulta.setInt(8,objeto.getEstado());
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            
            
        }catch(SQLException e){
            System.out.println("Error al guardar el producto"+e);
        }
        return respuesta;
    }
    
    //metodo para saber si el producto existe 
    
    public boolean existeProducto(String producto){
        boolean respuesta=false;
        String sql="select nombre from tb_producto where nombre= '" + producto + "';";
        Statement st;
        
        try{
            Connection cn=conexion.Conexion.conectar();
            st=cn.createStatement();
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()){
                respuesta=true;
            }
        }catch(SQLException e){
            System.out.println("error al consultar el prodcto"+ e.getMessage());
        }
        return respuesta;
            
        }
    //metodo de actualizar tabala producto.
    public boolean actualizar(Producto objeto, int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_producto set nombre=?, cantidad=?, precio=?, descripcion=?, porcentajeIva=?, idCategoria=?, estado=? where idProducto ='"+idProducto+"';");
            
            consulta.setString(1, objeto.getNombre());
            consulta.setInt(2, objeto.getCantidad());
            consulta.setDouble(3,objeto.getPrecio());
            consulta.setString(4, objeto.getDescripcion());
            consulta.setInt(5, objeto.getPorcentajeIva());
            consulta.setInt(6, objeto.getIdCategoria());
            consulta.setInt(7, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al actualizar el producto:  " + e);
        }
        return respuesta;
    }
    
    //metodo de eliminar producto.
    public boolean eliminar( int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        PreparedStatement consulta=null;
        try {
            consulta = cn.prepareStatement("delete from tb_producto where idProducto = ?");
            
            consulta.setInt(1, idProducto);
            int filasAfectadas=consulta.executeUpdate();
            
            if (filasAfectadas > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar el producto:  " + e.getMessage());
        }
        return respuesta;
    }
    //metodo de actualizar el stock de producto.
    public boolean actualizarStock(Producto producto, int idProducto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        PreparedStatement consulta=null;
        try {
            consulta = cn.prepareStatement("update  tb_producto set cantidad=? where idProducto = '"+idProducto+"';");
            
            consulta.setInt(1, producto.getCantidad());
            int filasAfectadas=consulta.executeUpdate();
            
            if (filasAfectadas > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al Actualizar el producto:  " + e.getMessage());
        }
        return respuesta;
    }
    
    
    
}
