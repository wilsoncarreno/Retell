package controlador;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Reportes {
    public void reportesClientes() {
        Document documento = new Document();
        try {
            String ruta = "C:\\Users\\DELL\\OneDrive\\Imágenes\\Escritorio\\reportes\\";
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdirs(); // crea la carpeta Desktop si no existe
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_clientes.pdf"));
            Image header = Image.getInstance("src/img/fondoencabezado.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte Creado por: \n Wilson Elias Carreño Morantes © Ingeniero en Software\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Clientes \n\n");
            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cedula");
            tabla.addCell("Telefono");
            tabla.addCell("Direccion");
            try {
                Connection con = conexion.Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("SELECT idCliente, concat(nombre,' ',apellido) as nombres, cedula ,telefono, direccion from  tb_cliente");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                    } while (rs.next());
                }
                documento.add(tabla);
                JOptionPane.showMessageDialog(null, "Reporte Creado");
            } catch (SQLException e) {
                System.out.println("error en " + e);
            }
            documento.close();
        } catch (DocumentException e) {
            System.out.println("error 1 en " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("error 2 en " + ex);
        } catch (IOException ex) {
            System.out.println("error 3 en " + ex);
        }
    }
    public void reportesProductos() {
        Document documento = new Document();
        try {
            String ruta = "C:\\Users\\DELL\\OneDrive\\Imágenes\\Escritorio\\reportes\\";
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdirs(); // crea la carpeta Desktop si no existe
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_productos.pdf"));
            Image header = Image.getInstance("src/img/fondoencabezado.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte Creado por: \n Wilson Elias Carreño Morantes © Ingeniero en Software\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Productoss \n\n");
            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);
            float[]columnwidths={3f,5f,4f,5f,7f,5f,6f};
            PdfPTable tabla = new PdfPTable(7);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Descripcion");
            tabla.addCell("% iva");
            tabla.addCell("Categoria");
            try {
                Connection con = conexion.Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("select p.idProducto, p.nombre,"
                        + " p.cantidad, p.precio, p.descripcion, p.porcentajeIva,"
                        + " c.descripcion as categoria, p.estado from tb_producto as p, "
                        + "tb_categoria as c where p.idCategoria = c.idCategoria;");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));
                        tabla.addCell(rs.getString(6));
                        tabla.addCell(rs.getString(7));
                    } while (rs.next());
                }
                documento.add(tabla);
                JOptionPane.showMessageDialog(null, "Reporte Creado");
            } catch (SQLException e) {
                System.out.println("error en " + e);
            }
            documento.close();
        } catch (DocumentException e) {
            System.out.println("error 1 en " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("error 2 en " + ex);
        } catch (IOException ex) {
            System.out.println("error 3 en " + ex);
        }
    }
    public void reportesCategorias() {
        Document documento = new Document();
        try {
            String ruta = "C:\\Users\\DELL\\OneDrive\\Imágenes\\Escritorio\\reportes\\";
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdirs(); 
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_categorias.pdf"));
            Image header = Image.getInstance("src/img/fondoencabezado.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte Creado por: \n Wilson Elias Carreño Morantes © Ingeniero en Software\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Categorias \n\n");
            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);
            PdfPTable tabla = new PdfPTable(3);
            tabla.addCell("Codigo");
            tabla.addCell("Nombre Categoria");
            tabla.addCell("Estado");
            try {
                Connection con = conexion.Conexion.conectar();
                PreparedStatement ps = con.prepareStatement("SELECT * from tb_categoria");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));                        
                    } while (rs.next());
                }
                documento.add(tabla);
                JOptionPane.showMessageDialog(null, "Reporte Creado");
            } catch (SQLException e) {
                System.out.println("error en " + e);
            }
            documento.close();
        } catch (DocumentException e) {
            System.out.println("error 1 en " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("error 2 en " + ex);
        } catch (IOException ex) {
            System.out.println("error 3 en " + ex);
        }
    }
    public void reportesVentas() {
        Document documento = new Document();
        try {
            String ruta = "C:\\Users\\DELL\\OneDrive\\Imágenes\\Escritorio\\reportes\\";
            File directorio = new File(ruta);
            if (!directorio.exists()) {
                directorio.mkdirs(); // crea la carpeta Desktop si no existe
            }
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "Reporte_de_ventas.pdf"));
            Image header = Image.getInstance("src/img/fondoencabezado.jpg");
            header.scaleToFit(650, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph parrafo = new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.add("Reporte Creado por: \n Wilson Elias Carreño Morantes © Ingeniero en Software\n\n");
            parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
            parrafo.add("Reporte de Ventas \n\n");
            documento.open();
            //agregamos los datos
            documento.add(header);
            documento.add(parrafo);
             float[]columnwidths={3f,9f,4f,5f,3f};
            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Codigo");
            tabla.addCell("Cliente");
            tabla.addCell("Total a Pagar");
            tabla.addCell("Fecha de Venta");
            tabla.addCell("Estado");
            try {
                Connection con = conexion.Conexion.conectar();
                PreparedStatement ps = con.prepareStatement(" select cv.idCabeceraVenta as id, concat(c.nombre,' ', apellido) as cliente, cv.valorPagar as total, cv.fechaVenta as fecha, cv.estado  from tb_cabecera_venta as cv, tb_cliente as c where cv.idCliente = c.idCliente;");
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    do {
                        tabla.addCell(rs.getString(1));
                        tabla.addCell(rs.getString(2));
                        tabla.addCell(rs.getString(3));
                        tabla.addCell(rs.getString(4));
                        tabla.addCell(rs.getString(5));                        
                    } while (rs.next());
                }
                documento.add(tabla);
                JOptionPane.showMessageDialog(null, "Reporte Creado");
            } catch (SQLException e) {
                System.out.println("error en " + e);
            }
            documento.close();
        } catch (DocumentException e) {
            System.out.println("error 1 en " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("error 2 en " + ex);
        } catch (IOException ex) {
            System.out.println("error 3 en " + ex);
        }
    }
}
