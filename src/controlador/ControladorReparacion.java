/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Reparacion;

/**
 *
 * @author DELL
 */
public class ControladorReparacion {
     public boolean guardar(Reparacion objeto){    
        boolean respuesta = false;
        Connection cn=conexion.Conexion.conectar();
        
        try{
            
            PreparedStatement consulta= cn.prepareStatement("insert into tb_reparacion values(?,?,?,?,?)");
            consulta.setInt(1,0);//id
            consulta.setInt(2,objeto.getIdCliente());
            consulta.setDouble(3,objeto.getPrecioReparacion());
            consulta.setString(4,objeto.getDescripcion());
            consulta.setString(5,objeto.getFechaContrato());
            
            if(consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            
            
        }catch(SQLException e){
            System.out.println("Error al guardar el producto"+e);
        }
        return respuesta;
    }
}
