/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import modelo.Usuario;


public class ControladorUsuario {

    //metodo para iniciar sesion
    public boolean loginUser(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "select  usuario, password from tb_usuario where usuario='" + objeto.getUsuario() + "'and password='" + objeto.getPassword() + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al iniciar seccion ");
            JOptionPane.showMessageDialog(null, "Error al iniciar seccion");

        }
        return respuesta;
    }
    
    //metodo para guardar usuario
    public boolean Guardar(Usuario usuario){
        boolean respuesta=false;
        Connection cn=conexion.Conexion.conectar();
        try{
            PreparedStatement consulta=cn.prepareStatement("INSERT INTO tb_usuario (idUsuario, nombre, apellido, usuario, password, telefono, estado) VALUES (?, ?, ?, ?, ?, ?, ?)");
            consulta.setInt(1, 0);//idCliente
            consulta.setString(2,usuario.getNombre());
            consulta.setString(3,usuario.getApellido());
            consulta.setString(4,usuario.getUsuario());
            consulta.setString(5,usuario.getPassword());
            consulta.setString(6, usuario.getTelefono());
            consulta.setInt(7,usuario.getEstado());
            if (consulta.executeUpdate()>0){
                respuesta=true;
            }
            cn.close();
            
        }catch(SQLException e){
            System.out.println("error al guardar el producto"+e);            
        }
        return respuesta;
    }
    public boolean ExisteUsuario(String usuario){
    boolean respuesta = false;
    String sql = "SELECT 1 FROM tb_usuario WHERE usuario = ?";

    try {
        Connection cn = conexion.Conexion.conectar();
        PreparedStatement ps = cn.prepareStatement(sql);
        ps.setString(1, usuario);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            respuesta = true;
        }
    } catch(SQLException e) {
        System.out.println("Error al consultar el usuario: " + e.getMessage());
    }

    return respuesta;
}
//     public boolean ExisteUsuario(String usuario){
//        boolean respuesta=false;
//        String sql="SELECT usuario FROM tb_usuario WHERE usuario= '"+usuario+"';";
//        Statement st;
//        try{
//            Connection cn=conexion.Conexion.conectar();
//            st=cn.createStatement();
//            ResultSet rs =st.executeQuery(sql);
//            while(rs.next()){
//                respuesta=true;
//            }
//        }catch(SQLException e){
//            System.out.println("error al consultar el Usuario"+ e.getMessage());
//        }
//        return respuesta;
//        
//    }
}
