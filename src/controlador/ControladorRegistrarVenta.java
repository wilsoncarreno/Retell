
package controlador;


import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;



public class ControladorRegistrarVenta {
    //ultimo id de la cabecera
    public static int idcabeceraRegistrada;
    java.math.BigDecimal iDColVar;
    
    //metodo para guardar la cabecera de venta
    public boolean guardar(CabeceraVenta objeto){
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                "INSERT INTO tb_cabecera_venta (idCabeceraVenta, idCliente, valorPagar, fechaVenta, estado) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
            consulta.setInt(1, 0); // idCabeceraVenta (autoincremental)
            consulta.setInt(2, objeto.getIdCliente());
            consulta.setDouble(3, objeto.getValorPagar());
            consulta.setString(4, objeto.getFechaVenta());
            consulta.setInt(5, objeto.getEstado()); // Corregido a índice 5
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            ResultSet rs = consulta.getGeneratedKeys();
            while (rs.next()) {
                iDColVar = rs.getBigDecimal(1);
                idcabeceraRegistrada = iDColVar.intValue();
            }
            cn.close();            
        } catch (SQLException e) {
            System.out.println("error al guardar cabecera de venta: " + e);            
        }
        return respuesta;
    }
    
    //metodo para guardar el detalle de venta
    public boolean guardarDetalle(DetalleVenta objeto){
        boolean respuesta=false;
        Connection cn=conexion.Conexion.conectar();
        try{
            PreparedStatement consulta=cn.prepareStatement("INSERT INTO tb_detalle_venta (idDetalleVenta, idCabeceraVenta, idProducto, cantidad, precioUnitario, subtotal, descuento,iva,totalPagar,estado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, 0);//idCliente
            consulta.setInt(2,idcabeceraRegistrada);
            consulta.setInt(3,objeto.getIdProducto());
            consulta.setInt(4,objeto.getCantidad());
            consulta.setDouble(5,objeto.getPrecioUnitario());
            consulta.setDouble(6, objeto.getSubTotal());
            consulta.setDouble(7, objeto.getDescuento());
            consulta.setDouble(8, objeto.getIva());
            consulta.setDouble(9, objeto.getTotalPagar());
            consulta.setInt(10,objeto.getEstado());
            if (consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();            
        }catch(SQLException e){
            System.out.println("error al guardar el detalle de venta"+e);            
        }
        return respuesta;
    }
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cabecera_venta set idCliente=?, "
                    + " estado=? where idCabeceraVenta ='"+idCabeceraVenta+"';");
            
            consulta.setInt (1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al actualizar el cabecera:  " + e);
        }
        return respuesta;
    }
    
}
