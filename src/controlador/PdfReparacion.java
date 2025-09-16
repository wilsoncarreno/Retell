package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.String.valueOf;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import modelo.Reparacion;
import vista.InterReparacion;
import static vista.InterGestionarVentas.TablaProductosADevolver;
import vista.InterReparacion;

public class PdfReparacion {

    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;
 
    String descripcion;
    String total;

    // AGREGAR ESTAS VARIABLES QUE FALTABAN:
    private String nombreArchivoPDFReparacion;
    private String fechaActual;
    InterReparacion interReparacion = new InterReparacion();

    public PdfReparacion() {

    }

    public PdfReparacion(Reparacion reparacion) {
        this.descripcion = reparacion.getDescripcion();
        this.total = String.valueOf((long) reparacion.getPrecioReparacion());
        

    }

    public void datosCliente(int idCliente) {
        Connection con = conexion.Conexion.conectar();
        String sql = "select * from tb_cliente where idCliente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nombreCliente = rs.getString("nombre") + " " + rs.getString("apellido");
                cedulaCliente = rs.getString("cedula");
                telefonoCliente = rs.getString("telefono");
                direccionCliente = rs.getString("direccion");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("error al obtener datos del cliente " + e);
        }
    }

    private int obtenerNumeroReparacion() {
        int numeroFactura = 1;
        try {
            Connection con = conexion.Conexion.conectar();
            String sql = "SELECT MAX(idReparacion) as ultimaReparacion FROM tb_Reparacion";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numeroFactura = rs.getInt("ultimaReparacion");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener número de factura: " + e);
        }
        return numeroFactura;
    }

    public void generarReparacionPDF() {
        try {
            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }
            nombreArchivoPDFReparacion = "Reparacion_" + nombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/Pdfreportes/" + nombreArchivoPDFReparacion);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/logoRetell..png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            int numeroReparacion = obtenerNumeroReparacion();
            fecha.add("Reparacion: " + numeroReparacion + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);

            float[] columnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(columnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);

            Encabezado.addCell(img);

            String nit = "1090480697-1";
            String nombre = "RETELL";
            String telefono = "305 7216202";
            String direccion = "K3 Vía San Gil Parqueadero La Playita";
            String razon = "RETELL";
            Encabezado.addCell("");
            Encabezado.addCell("NIT: " + nit + "\nNombre: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);

            doc.add(Encabezado);

            Paragraph cliente = new Paragraph();
            cliente.add(Chunk.NEWLINE);
            cliente.add("Datos del Cliente: " + "\n\n");
            doc.add(cliente);

            PdfPTable tablaCliente = new PdfPTable(4);
            tablaCliente.setWidthPercentage(100);
            tablaCliente.getDefaultCell().setBorder(0);
            float[] columnaCliente = new float[]{25f, 45f, 30f, 40f};
            tablaCliente.setWidths(columnaCliente);
            tablaCliente.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cliente1 = new PdfPCell(new Phrase("Cedula/NIT: ", negrita));
            PdfPCell cliente2 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell cliente3 = new PdfPCell(new Phrase("Telefono: ", negrita));
            PdfPCell cliente4 = new PdfPCell(new Phrase("Direccion: ", negrita));
            cliente1.setBorder(0);
            cliente2.setBorder(0);
            cliente3.setBorder(0);
            cliente4.setBorder(0);

            tablaCliente.addCell(cliente1);
            tablaCliente.addCell(cliente2);
            tablaCliente.addCell(cliente3);
            tablaCliente.addCell(cliente4);
            tablaCliente.addCell(cedulaCliente);
            tablaCliente.addCell(nombreCliente);
            tablaCliente.addCell(telefonoCliente);
            tablaCliente.addCell(direccionCliente);

            doc.add(tablaCliente);

            Paragraph espacio = new Paragraph();
            espacio.add(Chunk.NEWLINE);
            espacio.add("");
            espacio.setAlignment(Element.ALIGN_CENTER);
            doc.add(espacio);

            PdfPTable tablareparacion = new PdfPTable(2);
            tablareparacion.setWidthPercentage(100);
            tablareparacion.getDefaultCell().setBorder(0);

            float[] columnaReparacion = new float[]{70f, 30f};
            tablareparacion.setWidths(columnaReparacion);
            tablareparacion.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell reparacion1 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell reparacion2 = new PdfPCell(new Phrase("Precio Total: ", negrita));

            reparacion1.setBorder(0);
            reparacion2.setBorder(0);

            reparacion1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            reparacion2.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablareparacion.addCell(reparacion1);
            tablareparacion.addCell(reparacion2);

            tablareparacion.addCell(descripcion);
            tablareparacion.addCell(total);

            doc.add(tablareparacion);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a Pagar: " + total);
            info.setAlignment(Element.ALIGN_RIGHT);
            doc.add(info);

            Paragraph firma = new Paragraph();
            firma.add(Chunk.NEWLINE);
            firma.add("Cancelacion y Firma\n\n");
            firma.add("__________________________");
            firma.setAlignment(Element.ALIGN_CENTER);
            doc.add(firma);

            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Gracias por Preferirnos !");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("error en: " + e);
        }
    }
    public void generarPdf(int idReparacion) {
    try (Connection con = Conexion.conectar()) {
        String sql = "SELECT r.descripcion, r.precioReparacion, c.idCliente " +
                     "FROM tb_reparacion r " +
                     "INNER JOIN tb_cliente c ON r.idCliente = c.idCliente " +
                     "WHERE r.idReparacion = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idReparacion);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // asignar valores
                    this.descripcion = rs.getString("descripcion");
                    this.total = String.valueOf((long) rs.getDouble("precioReparacion"));
                    int idCliente = rs.getInt("idCliente");

                    // cargar datos del cliente
                    datosCliente(idCliente);

                    // generar el PDF con la info cargada
                    generarReparacionPDF();
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró la reparación con ID: " + idReparacion);
                }
            }
        }
    } catch (SQLException e) {
        System.out.println("Error al generar PDF por id: " + e);
    }
}

}
