/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import modelo.Categoria;

//metodo para registrar categorias.
public class ControladorCategoria {

    public boolean guardar(Categoria objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria values(?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getDescripcion());
            consulta.setInt(3, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al guardar categoria:  " + e);
        }
        return respuesta;
    }

    //metodo para consultar si existe la categoria 
    public boolean existeCategoria(String categoria) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_categoria where descripcion= '" + categoria + "';";
        Statement st;

        try {

            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("error al consultar categoria:  " + e);
        }
        return respuesta;
    }
    
    //metodo de actualizar tabala categoria.
    public boolean actualizar(Categoria objeto, int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_categoria set descripcion = ? where idCategoria ='"+idCategoria+"'");
            
            consulta.setString(1, objeto.getDescripcion());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al actualizar la categoria:  " + e);
        }
        return respuesta;
    }
    
    //metodo de eliminar tabala categoria.
    public boolean eliminar( int idCategoria) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("delete from tb_categoria where idCategoria = ?");
            
            consulta.setInt(1, idCategoria);
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar la categoria:  " + e.getMessage());
        }
        return respuesta;
    }
}
