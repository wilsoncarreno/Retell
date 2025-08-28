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
import vista.InterFacturacion;
import static vista.InterGestionarVentas.TablaProductosADevolver;

public class VentaPDF {

    // Variables de instancia
    private String nombreCliente;
    private String cedulaCliente;
    private String telefonoCliente;
    private String direccionCliente;

    // AGREGAR ESTAS VARIABLES QUE FALTABAN:
    private String nombreArchivoPDFVenta;
    private String fechaActual;

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

    // AGREGAR ESTE MÉTODO QUE TAMBIÉN FALTA:
    private int obtenerNumeroFactura() {
        int numeroFactura = 1;
        try {
            Connection con = conexion.Conexion.conectar();
            String sql = "SELECT MAX(idCabeceraVenta) as ultimaVenta FROM tb_cabecera_venta";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                numeroFactura = rs.getInt("ultimaVenta");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener número de factura: " + e);
        }
        return numeroFactura;
    }

    public void generarFacturaPDF() {
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
            nombreArchivoPDFVenta = "Venta_" + nombreCliente + "_" + fechaNueva + ".pdf";
            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFVenta);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/logoRetell..png");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE);
            int numeroFactura = obtenerNumeroFactura();
            fecha.add("Factura: " + numeroFactura + "\nFecha: " + fechaActual + "\n\n");

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

            PdfPTable tablaProducto = new PdfPTable(4);
            tablaProducto.setWidthPercentage(100);
            tablaProducto.getDefaultCell().setBorder(0);

            float[] columnaProducto = new float[]{15f, 50f, 15f, 20f};
            tablaProducto.setWidths(columnaProducto);
            tablaProducto.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell producto1 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell producto2 = new PdfPCell(new Phrase("Descripcion: ", negrita));
            PdfPCell producto3 = new PdfPCell(new Phrase("Precio Unitario: ", negrita));
            PdfPCell producto4 = new PdfPCell(new Phrase("Precio Total: ", negrita));

            producto1.setBorder(0);
            producto2.setBorder(0);
            producto3.setBorder(0);
            producto4.setBorder(0);

            producto1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto2.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto3.setBackgroundColor(BaseColor.LIGHT_GRAY);
            producto4.setBackgroundColor(BaseColor.LIGHT_GRAY);

            tablaProducto.addCell(producto1);
            tablaProducto.addCell(producto2);
            tablaProducto.addCell(producto3);
            tablaProducto.addCell(producto4);

            for (int i = 0; i < InterFacturacion.tablaProductos.getRowCount(); i++) {
                String producto = InterFacturacion.tablaProductos.getValueAt(i, 1).toString();
                String cantidad = InterFacturacion.tablaProductos.getValueAt(i, 2).toString();
                String precio = InterFacturacion.tablaProductos.getValueAt(i, 3).toString();
                String total = InterFacturacion.tablaProductos.getValueAt(i, 7).toString();

                tablaProducto.addCell(cantidad);
                tablaProducto.addCell(producto);
                tablaProducto.addCell(precio);
                tablaProducto.addCell(total);
            }

            doc.add(tablaProducto);

            Paragraph info = new Paragraph();
            info.add(Chunk.NEWLINE);
            info.add("Total a Pagar: " + InterFacturacion.txtTotalPagar.getText());
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
            mensaje.add("¡Gracias por su compra !");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);

            doc.close();
            archivo.close();

            Desktop.getDesktop().open(file);

        } catch (DocumentException | IOException e) {
            System.out.println("error en: " + e);
        }
    }

//    public void generarPDFActualizado(int idVenta, int idCliente) {
//        // Cargar datos del cliente
//        this.datosCliente(idCliente);
//
//        try {
//            Date date = new Date();
//            String fechaActualizacion = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
//            String fechaNueva = fechaActualizacion.replace("/", "_").replace(":", "-").replace(" ", "_");
//
//            String nombreArchivo = "Factura_Actualizada_" + nombreCliente.replace(" ", "_") + "_" + fechaNueva + ".pdf";
//            FileOutputStream archivo;
//            File file = new File("src/pdf/" + nombreArchivo);
//            archivo = new FileOutputStream(file);
//
//            Document doc = new Document();
//            PdfWriter.getInstance(doc, archivo);
//            doc.open();
//
//            // Fuentes
//            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
//            Font tituloRojo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.RED);
//
//            // Logo (si existe)
//            try {
//                Image img = Image.getInstance("src/img/logoRetell..png");
//                img.scaleToFit(100, 100);
//
//                // Encabezado
//                PdfPTable encabezado = new PdfPTable(3);
//                encabezado.setWidthPercentage(100);
//                encabezado.getDefaultCell().setBorder(0);
//
//                float[] columnas = new float[]{20f, 50f, 30f};
//                encabezado.setWidths(columnas);
//
//                encabezado.addCell(img);
//
//                PdfPCell infoEmpresa = new PdfPCell(new Phrase(
//                        "RETELL\n"
//                        + "NIT: 1090480697-1\n"
//                        + "TELÉFONO: 305 7216202\n"
//                        + "DIRECCIÓN: K3 Vía San Gil Parqueadero La Playita\n"
//                        + "RAZÓN SOCIAL: RETELL", negrita));
//                infoEmpresa.setBorder(0);
//                infoEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
//                encabezado.addCell(infoEmpresa);
//
//                PdfPCell fechaCell = new PdfPCell(new Phrase(
//                        "FACTURA ACTUALIZADA\n"
//                        + "Venta N°: " + idVenta + "\n"
//                        + "Fecha Actualización:\n" + fechaActualizacion, tituloRojo));
//                fechaCell.setBorder(0);
//                fechaCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//                encabezado.addCell(fechaCell);
//
//                doc.add(encabezado);
//            } catch (Exception e) {
//                // Si no hay logo, agregar solo texto
//                Paragraph titulo = new Paragraph("FACTURA ACTUALIZADA - VENTA N° " + idVenta, tituloRojo);
//                titulo.setAlignment(Element.ALIGN_CENTER);
//                doc.add(titulo);
//
//                Paragraph fecha = new Paragraph("Fecha de Actualización: " + fechaActualizacion);
//                fecha.setAlignment(Element.ALIGN_RIGHT);
//                doc.add(fecha);
//            }
//
//            // Espacio
//            doc.add(new Paragraph(" "));
//
//            // Datos del cliente
//            Paragraph clienteTitulo = new Paragraph("DATOS DEL CLIENTE:\n", negrita);
//            doc.add(clienteTitulo);
//
//            PdfPTable tablaCliente = new PdfPTable(4);
//            tablaCliente.setWidthPercentage(100);
//            float[] columnasCliente = new float[]{25f, 25f, 25f, 25f};
//            tablaCliente.setWidths(columnasCliente);
//
//            // Headers cliente
//            tablaCliente.addCell(new PdfPCell(new Phrase("CÉDULA/NIT", negrita)));
//            tablaCliente.addCell(new PdfPCell(new Phrase("NOMBRE", negrita)));
//            tablaCliente.addCell(new PdfPCell(new Phrase("TELÉFONO", negrita)));
//            tablaCliente.addCell(new PdfPCell(new Phrase("DIRECCIÓN", negrita)));
//
//            // Datos cliente
//            tablaCliente.addCell(cedulaCliente != null ? cedulaCliente : "");
//            tablaCliente.addCell(nombreCliente != null ? nombreCliente : "");
//            tablaCliente.addCell(telefonoCliente != null ? telefonoCliente : "");
//            tablaCliente.addCell(direccionCliente != null ? direccionCliente : "");
//
//            doc.add(tablaCliente);
//            doc.add(new Paragraph(" "));
//
//            // Productos actuales (después de devoluciones)
//            Paragraph productosTitulo = new Paragraph("PRODUCTOS ACTUALES:\n", negrita);
//            doc.add(productosTitulo);
//
//            PdfPTable tablaProductos = new PdfPTable(5);
//            tablaProductos.setWidthPercentage(100);
//            float[] columnasProductos = new float[]{10f, 40f, 15f, 15f, 20f};
//            tablaProductos.setWidths(columnasProductos);
//
//            // Headers productos
//            PdfPCell[] headersProductos = {
//                new PdfPCell(new Phrase("CANT.", negrita)),
//                new PdfPCell(new Phrase("DESCRIPCIÓN", negrita)),
//                new PdfPCell(new Phrase("PRECIO UNIT.", negrita)),
//                new PdfPCell(new Phrase("IVA POR UNIDAD", negrita)),
//                new PdfPCell(new Phrase("TOTAL", negrita))
//            };
//
//            for (PdfPCell header : headersProductos) {
//                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                tablaProductos.addCell(header);
//            }
//
//            // Crear un mapa para obtener las cantidades a devolver de la tabla
//            Map<String, Integer> cantidadesADevolver = new HashMap<>();
//            Map<String, Double> ivasPorUnidad = new HashMap<>();
//
//            // Recorrer la tabla para obtener las cantidades a devolver y el IVA por unidad
//            for (int i = 0; i < TablaProductosADevolver.getRowCount(); i++) {
//                try {
//                    String nombreProducto = (String) TablaProductosADevolver.getValueAt(i, 1); // columna Nombre
//                    Object cantidadDevolver = TablaProductosADevolver.getValueAt(i, 8); // columna "Cantidad a devolver"
//                    Object ivaPorUnidad = TablaProductosADevolver.getValueAt(i, 6); // columna "Iva por Unidad"
//
//                    int cantDevolver = 0;
//                    if (cantidadDevolver != null && !cantidadDevolver.toString().trim().isEmpty()) {
//                        cantDevolver = Integer.parseInt(cantidadDevolver.toString());
//                    }
//
//                    double ivaUnidad = 0.0;
//                    if (ivaPorUnidad != null && !ivaPorUnidad.toString().trim().isEmpty()) {
//                        String ivaStr = ivaPorUnidad.toString().replace("$", "").replace(",", "").trim();
//                        ivaUnidad = Double.parseDouble(ivaStr);
//                    }
//
//                    cantidadesADevolver.put(nombreProducto, cantDevolver);
//                    ivasPorUnidad.put(nombreProducto, ivaUnidad);
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                    // Si hay error, asumir 0 devoluciones para este producto
//                }
//            }
//
//            // Cargar productos actuales
//            Connection con = conexion.Conexion.conectar();
//            String sqlProductos = "SELECT p.idProducto, p.nombre, dv.cantidad, dv.precioUnitario "
//                    + "FROM tb_detalle_venta dv "
//                    + "INNER JOIN tb_producto p ON dv.idProducto = p.idProducto "
//                    + "WHERE dv.idCabeceraVenta = ? AND dv.cantidad > 0 "
//                    + "ORDER BY p.nombre";
//
//            PreparedStatement ps = con.prepareStatement(sqlProductos);
//            ps.setInt(1, idVenta);
//            ResultSet rs = ps.executeQuery();
//
//            boolean hayProductos = false;
//            double totalGeneral = 0;
//
//            while (rs.next()) {
//                int idProducto = rs.getInt("idProducto");
//                String nombreProducto = rs.getString("nombre");
//                int cantidad = rs.getInt("cantidad");   // cantidad original
//                double precioUnit = rs.getDouble("precioUnitario");
//
//                // 🚨 AQUÍ USAMOS LOS VALORES DE LA TABLA DIRECTAMENTE
//                int devueltos = cantidadesADevolver.getOrDefault(nombreProducto, 0);
//                double ivaPorUnidad = ivasPorUnidad.getOrDefault(nombreProducto, 0.0);
//
//                int cantidadFinal = cantidad - devueltos;
//
//                if (cantidadFinal <= 0) {
//                    continue; // si no queda nada, saltar
//                }
//
//                hayProductos = true;
//
//                // 📌 Calcular valores para cantidad final usando el IVA de la tabla
//                double subTotal = cantidadFinal * precioUnit;
//                double ivaTotal = cantidadFinal * ivaPorUnidad;
//                double totalPagar = subTotal + ivaTotal;
//
//                // Sumar al total general
//                totalGeneral += totalPagar;
//
//                // Añadir al PDF
//                tablaProductos.addCell(new PdfPCell(new Phrase(String.valueOf(cantidadFinal))));
//                tablaProductos.addCell(new PdfPCell(new Phrase(nombreProducto)));
//                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", precioUnit))));
//                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", ivaPorUnidad))));
//                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", totalPagar))));
//            }
//
//            if (!hayProductos) {
//                PdfPCell noProductos = new PdfPCell(new Phrase("TODOS LOS PRODUCTOS HAN SIDO DEVUELTOS",
//                        new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED)));
//                noProductos.setColspan(5);
//                noProductos.setHorizontalAlignment(Element.ALIGN_CENTER);
//                tablaProductos.addCell(noProductos);
//            }
//
//            doc.add(tablaProductos);
//
//            // Total actualizado
//            doc.add(new Paragraph(" "));
//            Paragraph totalParagraph = new Paragraph(
//                    "TOTAL A PAGAR ACTUALIZADO: $" + String.format("%.2f", totalGeneral),
//                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE)
//            );
//            totalParagraph.setAlignment(Element.ALIGN_RIGHT);
//            doc.add(totalParagraph);
//
//            // SECCIÓN: Información de devoluciones (mostrar datos de la tabla)
//            doc.add(new Paragraph(" "));
//           tttt Paragraph devolucionesTitulo = new Paragraph("INFORMACIÓN DE DEVOLUCIONES:",
//                    new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED));
//            doc.add(devolucionesTitulo);
//
//            // Mostrar las devoluciones basadas en la tabla
//            PdfPTable tablaDevoluciones = new PdfPTable(3);
//            tablaDevoluciones.setWidthPercentage(100);
//            float[] columnasDev = new float[]{50f, 25f, 25f};
//            tablaDevoluciones.setWidths(columnasDev);
//
//            // Headers devoluciones
//            PdfPCell[] headersDev = {
//                new PdfPCell(new Phrase("PRODUCTO", negrita)),
//                new PdfPCell(new Phrase("CANTIDAD DEV.", negrita)),
//                new PdfPCell(new Phrase("ESTADO", negrita))
//            };
//
//            for (PdfPCell header : headersDev) {
//                header.setBackgroundColor(BaseColor.PINK);
//                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//                tablaDevoluciones.addCell(header);
//            }
//
//            boolean hayDevoluciones = false;
//            // Agregar filas de devoluciones desde la tabla
//            for (Map.Entry<String, Integer> entry : cantidadesADevolver.entrySet()) {
//                if (entry.getValue() > 0) {
//                    hayDevoluciones = true;
//
//                    tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getKey())));
//                    tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getValue().toString())));
//                    tablaDevoluciones.addCell(new PdfPCell(new Phrase("A DEVOLVER",
//                            new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED))));
//                }
//            }
//
//            if (hayDevoluciones) {
//                doc.add(tablaDevoluciones);
//            } else {
//                Paragraph sinDev = new Paragraph("No hay devoluciones registradas para esta venta.",
//                        new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
//                doc.add(sinDev);
//            }
//
//            con.close();
//
//            // Nota final
//            doc.add(new Paragraph(" "));
//            Paragraph notaFinal = new Paragraph(
//                    "DOCUMENTO ACTUALIZADO: Este documento refleja el estado actual de la venta "
//                    + "después de procesar las devoluciones correspondientes. "
//                    + "Fecha de generación: " + fechaActualizacion,
//                    new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
//            notaFinal.setAlignment(Element.ALIGN_CENTER);
//            doc.add(notaFinal);
//
//            // Firma
//            doc.add(new Paragraph(" "));
//            doc.add(new Paragraph(" "));
//            Paragraph firma = new Paragraph("AUTORIZADO POR:\n\n_________________________\nFirma y Sello");
//            firma.setAlignment(Element.ALIGN_CENTER);
//            doc.add(firma);
//
//            doc.close();
//            archivo.close();
//
//            // Abrir automáticamente
//            Desktop.getDesktop().open(file);
//            JOptionPane.showMessageDialog(null,
//                    "PDF actualizado generado exitosamente:\n" + nombreArchivo);
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,
//                    "Error al generar PDF actualizado: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
public void generarPDFActualizado(int idVenta, int idCliente) {
    // Cargar datos del cliente
    this.datosCliente(idCliente);

    try {
        Date date = new Date();
        String fechaActualizacion = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
        String fechaNueva = fechaActualizacion.replace("/", "_").replace(":", "-").replace(" ", "_");

        String nombreArchivo = "Factura_Actualizada_" + nombreCliente.replace(" ", "_") + "_" + fechaNueva + ".pdf";
        FileOutputStream archivo;
        File file = new File("src/pdf/" + nombreArchivo);
        archivo = new FileOutputStream(file);

        Document doc = new Document();
        PdfWriter.getInstance(doc, archivo);
        doc.open();

        // Fuentes
        Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
        Font tituloRojo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.RED);

        // Logo (si existe)
        try {
            Image img = Image.getInstance("src/img/logoRetell..png");
            img.scaleToFit(100, 100);

            // Encabezado
            PdfPTable encabezado = new PdfPTable(3);
            encabezado.setWidthPercentage(100);
            encabezado.getDefaultCell().setBorder(0);

            float[] columnas = new float[]{20f, 50f, 30f};
            encabezado.setWidths(columnas);

            encabezado.addCell(img);

            PdfPCell infoEmpresa = new PdfPCell(new Phrase(
                    "RETELL\n"
                    + "NIT: 1090480697-1\n"
                    + "TELÉFONO: 305 7216202\n"
                    + "DIRECCIÓN: K3 Vía San Gil Parqueadero La Playita\n"
                    + "RAZÓN SOCIAL: RETELL", negrita));
            infoEmpresa.setBorder(0);
            infoEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
            encabezado.addCell(infoEmpresa);

            PdfPCell fechaCell = new PdfPCell(new Phrase(
                    "FACTURA ACTUALIZADA\n"
                    + "Venta N°: " + idVenta + "\n"
                    + "Fecha Actualización:\n" + fechaActualizacion, tituloRojo));
            fechaCell.setBorder(0);
            fechaCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            encabezado.addCell(fechaCell);

            doc.add(encabezado);
        } catch (Exception e) {
            // Si no hay logo, agregar solo texto
            Paragraph titulo = new Paragraph("FACTURA ACTUALIZADA - VENTA N° " + idVenta, tituloRojo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            Paragraph fecha = new Paragraph("Fecha de Actualización: " + fechaActualizacion);
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);
        }

        // Espacio
        doc.add(new Paragraph(" "));

        // Datos del cliente
        Paragraph clienteTitulo = new Paragraph("DATOS DEL CLIENTE:", negrita);
        doc.add(clienteTitulo);

        PdfPTable tablaCliente = new PdfPTable(4);
        tablaCliente.setWidthPercentage(100);
        float[] columnasCliente = new float[]{25f, 25f, 25f, 25f};
        tablaCliente.setWidths(columnasCliente);

        // Headers cliente
        tablaCliente.addCell(new PdfPCell(new Phrase("CÉDULA/NIT", negrita)));
        tablaCliente.addCell(new PdfPCell(new Phrase("NOMBRE", negrita)));
        tablaCliente.addCell(new PdfPCell(new Phrase("TELÉFONO", negrita)));
        tablaCliente.addCell(new PdfPCell(new Phrase("DIRECCIÓN", negrita)));

        // Datos cliente
        tablaCliente.addCell(cedulaCliente != null ? cedulaCliente : "");
        tablaCliente.addCell(nombreCliente != null ? nombreCliente : "");
        tablaCliente.addCell(telefonoCliente != null ? telefonoCliente : "");
        tablaCliente.addCell(direccionCliente != null ? direccionCliente : "");

        doc.add(tablaCliente);
        doc.add(new Paragraph(" "));

        // Productos actuales (después de devoluciones)
        Paragraph productosTitulo = new Paragraph("PRODUCTOS ACTUALES:", negrita);
        doc.add(productosTitulo);

        PdfPTable tablaProductos = new PdfPTable(5);
        tablaProductos.setWidthPercentage(100);
        float[] columnasProductos = new float[]{10f, 40f, 15f, 15f, 20f};
        tablaProductos.setWidths(columnasProductos);

        // Headers productos
        PdfPCell[] headersProductos = {
            new PdfPCell(new Phrase("CANT.", negrita)),
            new PdfPCell(new Phrase("DESCRIPCIÓN", negrita)),
            new PdfPCell(new Phrase("PRECIO UNIT.", negrita)),
            new PdfPCell(new Phrase("IVA POR UNIDAD", negrita)),
            new PdfPCell(new Phrase("TOTAL", negrita))
        };

        for (PdfPCell header : headersProductos) {
            header.setBackgroundColor(BaseColor.LIGHT_GRAY);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaProductos.addCell(header);
        }

        // Crear un mapa para obtener las cantidades a devolver de la tabla
        Map<String, Integer> cantidadesADevolver = new HashMap<>();
        Map<String, Double> ivasPorUnidad = new HashMap<>();
        
        // Recorrer la tabla para obtener las cantidades a devolver y el IVA por unidad
        for (int i = 0; i < TablaProductosADevolver.getRowCount(); i++) {
            try {
                String nombreProducto = (String) TablaProductosADevolver.getValueAt(i, 1); // columna Nombre
                Object cantidadDevolver = TablaProductosADevolver.getValueAt(i, 8); // columna "Cantidad a devolver"
                Object ivaPorUnidad = TablaProductosADevolver.getValueAt(i, 6); // columna "Iva por Unidad"
                
                int cantDevolver = 0;
                if (cantidadDevolver != null && !cantidadDevolver.toString().trim().isEmpty()) {
                    cantDevolver = Integer.parseInt(cantidadDevolver.toString());
                }
                
                double ivaUnidad = 0.0;
                if (ivaPorUnidad != null && !ivaPorUnidad.toString().trim().isEmpty()) {
                    String ivaStr = ivaPorUnidad.toString().replace("$", "").replace(",", "").trim();
                    ivaUnidad = Double.parseDouble(ivaStr);
                }
                
                cantidadesADevolver.put(nombreProducto, cantDevolver);
                ivasPorUnidad.put(nombreProducto, ivaUnidad);
                
                // 🚨 DEBUG: Mostrar los valores leídos
                System.out.println("Producto: " + nombreProducto + 
                                 ", Cantidad a devolver: " + cantDevolver + 
                                 ", IVA por unidad: " + ivaUnidad);
                
            } catch (Exception e) {
                e.printStackTrace();
                // Si hay error, asumir 0 devoluciones para este producto
            }
        }

        // Cargar productos actuales
        Connection con = conexion.Conexion.conectar();
        String sqlProductos = "SELECT p.idProducto, p.nombre, dv.cantidad, dv.precioUnitario " +
                             "FROM tb_detalle_venta dv " +
                             "INNER JOIN tb_producto p ON dv.idProducto = p.idProducto " +
                             "WHERE dv.idCabeceraVenta = ? AND dv.cantidad > 0 " +
                             "ORDER BY p.nombre";

        PreparedStatement ps = con.prepareStatement(sqlProductos);
        ps.setInt(1, idVenta);
        ResultSet rs = ps.executeQuery();

        boolean hayProductos = false;
        double totalGeneral = 0;

        while (rs.next()) {
            int idProducto = rs.getInt("idProducto");
            String nombreProducto = rs.getString("nombre");
            int cantidad = rs.getInt("cantidad");   // cantidad original
            double precioUnit = rs.getDouble("precioUnitario");

            // 🚨 AQUÍ USAMOS LOS VALORES DE LA TABLA DIRECTAMENTE
            int devueltos = cantidadesADevolver.getOrDefault(nombreProducto, 0);
            double ivaPorUnidad = ivasPorUnidad.getOrDefault(nombreProducto, 0.0);
            
            int cantidadFinal = cantidad - devueltos;

            if (cantidadFinal <= 0) {
                continue; // si no queda nada, saltar
            }

            hayProductos = true;

            // 📌 Calcular valores para cantidad final usando el IVA de la tabla
            double subTotal = cantidadFinal * precioUnit;
            double ivaTotal = cantidadFinal * ivaPorUnidad;
            double totalPagar = subTotal + ivaTotal;

            // Sumar al total general
            totalGeneral += totalPagar;

            // Añadir al PDF
            tablaProductos.addCell(new PdfPCell(new Phrase(String.valueOf(cantidadFinal))));
            tablaProductos.addCell(new PdfPCell(new Phrase(nombreProducto)));
            tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", precioUnit))));
            tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", ivaPorUnidad))));
            tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", totalPagar))));
        }

        if (!hayProductos) {
            PdfPCell noProductos = new PdfPCell(new Phrase("TODOS LOS PRODUCTOS HAN SIDO DEVUELTOS",
                    new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED)));
            noProductos.setColspan(5);
            noProductos.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaProductos.addCell(noProductos);
        }

        doc.add(tablaProductos);

        // Total actualizado
        doc.add(new Paragraph(" "));
        Paragraph totalParagraph = new Paragraph(
                "TOTAL A PAGAR ACTUALIZADO: $" + String.format("%.2f", totalGeneral),
                new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE)
        );
        totalParagraph.setAlignment(Element.ALIGN_RIGHT);
        doc.add(totalParagraph);

        // SECCIÓN: Información de devoluciones (mostrar datos de la tabla)
        doc.add(new Paragraph(" "));
        Paragraph devolucionesTitulo = new Paragraph("INFORMACIÓN DE DEVOLUCIONES:",
                new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED));
        doc.add(devolucionesTitulo);

        // Mostrar las devoluciones basadas en la tabla
        PdfPTable tablaDevoluciones = new PdfPTable(3);
        tablaDevoluciones.setWidthPercentage(100);
        float[] columnasDev = new float[]{50f, 25f, 25f};
        tablaDevoluciones.setWidths(columnasDev);

        // Headers devoluciones
        PdfPCell[] headersDev = {
            new PdfPCell(new Phrase("PRODUCTO", negrita)),
            new PdfPCell(new Phrase("CANTIDAD DEV.", negrita)),
            new PdfPCell(new Phrase("ESTADO", negrita))
        };

        for (PdfPCell header : headersDev) {
            header.setBackgroundColor(BaseColor.PINK);
            header.setHorizontalAlignment(Element.ALIGN_CENTER);
            tablaDevoluciones.addCell(header);
        }

        boolean hayDevoluciones = false;
        // 🚨 DEBUG: Mostrar el contenido del mapa antes de procesar
        System.out.println("=== CONTENIDO DEL MAPA DE DEVOLUCIONES ===");
        for (Map.Entry<String, Integer> entry : cantidadesADevolver.entrySet()) {
            System.out.println("Producto: '" + entry.getKey() + "' -> Cantidad: " + entry.getValue());
        }
        System.out.println("===========================================");
        
        // Agregar filas de devoluciones desde la tabla
        for (Map.Entry<String, Integer> entry : cantidadesADevolver.entrySet()) {
            System.out.println("Evaluando: " + entry.getKey() + " con cantidad: " + entry.getValue());
            
            if (entry.getValue() > 0) {
                hayDevoluciones = true;
                System.out.println("✅ Agregando devolución: " + entry.getKey() + " - " + entry.getValue());
                
                tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getKey())));
                tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getValue().toString())));
                tablaDevoluciones.addCell(new PdfPCell(new Phrase("A DEVOLVER",
                        new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED))));
            } else {
                System.out.println("❌ Sin devolución para: " + entry.getKey());
            }
        }

        if (hayDevoluciones) {
            System.out.println("✅ HAY DEVOLUCIONES - Agregando tabla al PDF");
            doc.add(tablaDevoluciones);
        } else {
            System.out.println("❌ NO HAY DEVOLUCIONES - Mostrando mensaje");
            Paragraph sinDev = new Paragraph("No hay devoluciones registradas para esta venta.",
                    new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
            doc.add(sinDev);
        }

        con.close();

        // Nota final
        doc.add(new Paragraph(" "));
        Paragraph notaFinal = new Paragraph(
                "DOCUMENTO ACTUALIZADO: Este documento refleja el estado actual de la venta "
                + "después de procesar las devoluciones correspondientes. "
                + "Fecha de generación: " + fechaActualizacion,
                new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
        notaFinal.setAlignment(Element.ALIGN_CENTER);
        doc.add(notaFinal);

        // Firma
        doc.add(new Paragraph(" "));
        doc.add(new Paragraph(" "));
        Paragraph firma = new Paragraph("AUTORIZADO POR:\n\n_________________________\nFirma y Sello");
        firma.setAlignment(Element.ALIGN_CENTER);
        doc.add(firma);

        doc.close();
        archivo.close();

        // Abrir automáticamente
        Desktop.getDesktop().open(file);
        JOptionPane.showMessageDialog(null,
                "PDF actualizado generado exitosamente:\n" + nombreArchivo);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null,
                "Error al generar PDF actualizado: " + e.getMessage());
        e.printStackTrace();
    }
        }
//////public void generarPDFActualizado(int idVenta, int idCliente) {
//////        // Cargar datos del cliente
//////        this.datosCliente(idCliente);
//////
//////        try {
//////            Date date = new Date();
//////            String fechaActualizacion = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date);
//////            String fechaNueva = fechaActualizacion.replace("/", "_").replace(":", "-").replace(" ", "_");
//////
//////            String nombreArchivo = "Factura_Actualizada_" + nombreCliente.replace(" ", "_") + "_" + fechaNueva + ".pdf";
//////            FileOutputStream archivo;
//////            File file = new File("src/pdf/" + nombreArchivo);
//////            archivo = new FileOutputStream(file);
//////
//////            Document doc = new Document();
//////            PdfWriter.getInstance(doc, archivo);
//////            doc.open();
//////
//////            // Fuentes
//////            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
//////            Font tituloRojo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.RED);
//////
//////            // Logo (si existe)
//////            try {
//////                Image img = Image.getInstance("src/img/logoRetell..png");
//////                img.scaleToFit(100, 100);
//////
//////                // Encabezado
//////                PdfPTable encabezado = new PdfPTable(3);
//////                encabezado.setWidthPercentage(100);
//////                encabezado.getDefaultCell().setBorder(0);
//////
//////                float[] columnas = new float[]{20f, 50f, 30f};
//////                encabezado.setWidths(columnas);
//////
//////                encabezado.addCell(img);
//////
//////                PdfPCell infoEmpresa = new PdfPCell(new Phrase(
//////                        "RETELL\n"
//////                        + "NIT: 1090480697-1\n"
//////                        + "TELÉFONO: 305 7216202\n"
//////                        + "DIRECCIÓN: K3 Vía San Gil Parqueadero La Playita\n"
//////                        + "RAZÓN SOCIAL: RETELL", negrita));
//////                infoEmpresa.setBorder(0);
//////                infoEmpresa.setHorizontalAlignment(Element.ALIGN_CENTER);
//////                encabezado.addCell(infoEmpresa);
//////
//////                PdfPCell fechaCell = new PdfPCell(new Phrase(
//////                        "FACTURA ACTUALIZADA\n"
//////                        + "Venta N°: " + idVenta + "\n"
//////                        + "Fecha Actualización:\n" + fechaActualizacion, tituloRojo));
//////                fechaCell.setBorder(0);
//////                fechaCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
//////                encabezado.addCell(fechaCell);
//////
//////                doc.add(encabezado);
//////            } catch (Exception e) {
//////                // Si no hay logo, agregar solo texto
//////                Paragraph titulo = new Paragraph("FACTURA ACTUALIZADA - VENTA N° " + idVenta, tituloRojo);
//////                titulo.setAlignment(Element.ALIGN_CENTER);
//////                doc.add(titulo);
//////
//////                Paragraph fecha = new Paragraph("Fecha de Actualización: " + fechaActualizacion);
//////                fecha.setAlignment(Element.ALIGN_RIGHT);
//////                doc.add(fecha);
//////            }
//////
//////            // Espacio
//////            doc.add(new Paragraph(" "));
//////
//////            // Datos del cliente
//////            Paragraph clienteTitulo = new Paragraph("DATOS DEL CLIENTE:", negrita);
//////            doc.add(clienteTitulo);
//////
//////            PdfPTable tablaCliente = new PdfPTable(4);
//////            tablaCliente.setWidthPercentage(100);
//////            float[] columnasCliente = new float[]{25f, 25f, 25f, 25f};
//////            tablaCliente.setWidths(columnasCliente);
//////
//////            // Headers cliente
//////            tablaCliente.addCell(new PdfPCell(new Phrase("CÉDULA/NIT", negrita)));
//////            tablaCliente.addCell(new PdfPCell(new Phrase("NOMBRE", negrita)));
//////            tablaCliente.addCell(new PdfPCell(new Phrase("TELÉFONO", negrita)));
//////            tablaCliente.addCell(new PdfPCell(new Phrase("DIRECCIÓN", negrita)));
//////
//////            // Datos cliente
//////            tablaCliente.addCell(cedulaCliente != null ? cedulaCliente : "");
//////            tablaCliente.addCell(nombreCliente != null ? nombreCliente : "");
//////            tablaCliente.addCell(telefonoCliente != null ? telefonoCliente : "");
//////            tablaCliente.addCell(direccionCliente != null ? direccionCliente : "");
//////
//////            doc.add(tablaCliente);
//////            doc.add(new Paragraph(" "));
//////
//////            // Productos actuales (después de devoluciones)
//////            Paragraph productosTitulo = new Paragraph("PRODUCTOS ACTUALES:", negrita);
//////            doc.add(productosTitulo);
//////
//////            PdfPTable tablaProductos = new PdfPTable(5);
//////            tablaProductos.setWidthPercentage(100);
//////            float[] columnasProductos = new float[]{10f, 40f, 15f, 15f, 20f};
//////            tablaProductos.setWidths(columnasProductos);
//////
//////            // Headers productos
//////            PdfPCell[] headersProductos = {
//////                new PdfPCell(new Phrase("CANT.", negrita)),
//////                new PdfPCell(new Phrase("DESCRIPCIÓN", negrita)),
//////                new PdfPCell(new Phrase("PRECIO UNIT.", negrita)),
//////                new PdfPCell(new Phrase("IVA POR UNIDAD", negrita)),
//////                new PdfPCell(new Phrase("TOTAL", negrita))
//////            };
//////
//////            for (PdfPCell header : headersProductos) {
//////                header.setBackgroundColor(BaseColor.LIGHT_GRAY);
//////                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//////                tablaProductos.addCell(header);
//////            }
//////
//////            // Crear un mapa para obtener las cantidades a devolver de la tabla
//////            Map<String, Integer> cantidadesADevolver = new HashMap<>();
//////            Map<String, Double> ivasPorUnidad = new HashMap<>();
//////
//////            // Recorrer la tabla para obtener las cantidades a devolver y el IVA por unidad
//////            for (int i = 0; i < TablaProductosADevolver.getRowCount(); i++) {
//////                try {
//////                    String nombreProducto = (String) TablaProductosADevolver.getValueAt(i, 1); // columna Nombre
//////
//////                    // 🚨 DEBUG: Mostrar TODAS las columnas para encontrar dónde están las devoluciones
//////                    System.out.println("=== FILA " + i + " - PRODUCTO: " + nombreProducto + " ===");
//////                    for (int col = 0; col < TablaProductosADevolver.getColumnCount(); col++) {
//////                        Object valor = TablaProductosADevolver.getValueAt(i, col);
//////                        String nombreColumna = TablaProductosADevolver.getColumnName(col);
//////                        System.out.println("  Columna " + col + " (" + nombreColumna + "): " + valor);
//////                    }
//////                    System.out.println("================================================");
//////
//////                    Object cantidadDevolver = TablaProductosADevolver.getValueAt(i, 8); // columna "Cantidad a devolver"
//////                    Object ivaPorUnidad = TablaProductosADevolver.getValueAt(i, 6); // columna "Iva por Unidad"
//////
//////                    int cantDevolver = 0;
//////                    if (cantidadDevolver != null && !cantidadDevolver.toString().trim().isEmpty()
//////                            && !cantidadDevolver.toString().equals("0")) {
//////                        try {
//////                            cantDevolver = Integer.parseInt(cantidadDevolver.toString());
//////                        } catch (NumberFormatException e) {
//////                            System.out.println("❌ Error parseando cantidad: " + cantidadDevolver);
//////                        }
//////                    }
//////
//////                    double ivaUnidad = 0.0;
//////                    if (ivaPorUnidad != null && !ivaPorUnidad.toString().trim().isEmpty()) {
//////                        String ivaStr = ivaPorUnidad.toString().replace("$", "").replace(",", "").trim();
//////                        try {
//////                            ivaUnidad = Double.parseDouble(ivaStr);
//////                        } catch (NumberFormatException e) {
//////                            System.out.println("❌ Error parseando IVA: " + ivaPorUnidad);
//////                        }
//////                    }
//////
//////                    cantidadesADevolver.put(nombreProducto, cantDevolver);
//////                    ivasPorUnidad.put(nombreProducto, ivaUnidad);
//////
//////                    // 🚨 DEBUG: Mostrar los valores finales
//////                    System.out.println("✅ RESULTADO - Producto: " + nombreProducto
//////                            + ", Cantidad a devolver: " + cantDevolver
//////                            + ", IVA por unidad: " + ivaUnidad);
//////
//////                } catch (Exception e) {
//////                    e.printStackTrace();
//////                    // Si hay error, asumir 0 devoluciones para este producto
//////                }
//////            }
//////
//////            // Cargar productos actuales
//////            Connection con = conexion.Conexion.conectar();
//////            String sqlProductos = "SELECT p.idProducto, p.nombre, dv.cantidad, dv.precioUnitario "
//////                    + "FROM tb_detalle_venta dv "
//////                    + "INNER JOIN tb_producto p ON dv.idProducto = p.idProducto "
//////                    + "WHERE dv.idCabeceraVenta = ? AND dv.cantidad > 0 "
//////                    + "ORDER BY p.nombre";
//////
//////            PreparedStatement ps = con.prepareStatement(sqlProductos);
//////            ps.setInt(1, idVenta);
//////            ResultSet rs = ps.executeQuery();
//////
//////            boolean hayProductos = false;
//////            double totalGeneral = 0;
//////
//////            while (rs.next()) {
//////                int idProducto = rs.getInt("idProducto");
//////                String nombreProducto = rs.getString("nombre");
//////                int cantidad = rs.getInt("cantidad");   // cantidad original
//////                double precioUnit = rs.getDouble("precioUnitario");
//////
//////                // 🚨 AQUÍ USAMOS LOS VALORES DE LA TABLA DIRECTAMENTE
//////                int devueltos = cantidadesADevolver.getOrDefault(nombreProducto, 0);
//////                double ivaPorUnidad = ivasPorUnidad.getOrDefault(nombreProducto, 0.0);
//////
//////                int cantidadFinal = cantidad - devueltos;
//////
//////                if (cantidadFinal <= 0) {
//////                    continue; // si no queda nada, saltar
//////                }
//////
//////                hayProductos = true;
//////
//////                // 📌 Calcular valores para cantidad final usando el IVA de la tabla
//////                double subTotal = cantidadFinal * precioUnit;
//////                double ivaTotal = cantidadFinal * ivaPorUnidad;
//////                double totalPagar = subTotal + ivaTotal;
//////
//////                // Sumar al total general
//////                totalGeneral += totalPagar;
//////
//////                // Añadir al PDF
//////                tablaProductos.addCell(new PdfPCell(new Phrase(String.valueOf(cantidadFinal))));
//////                tablaProductos.addCell(new PdfPCell(new Phrase(nombreProducto)));
//////                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", precioUnit))));
//////                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", ivaPorUnidad))));
//////                tablaProductos.addCell(new PdfPCell(new Phrase("$" + String.format("%.2f", totalPagar))));
//////            }
//////
//////            if (!hayProductos) {
//////                PdfPCell noProductos = new PdfPCell(new Phrase("TODOS LOS PRODUCTOS HAN SIDO DEVUELTOS",
//////                        new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED)));
//////                noProductos.setColspan(5);
//////                noProductos.setHorizontalAlignment(Element.ALIGN_CENTER);
//////                tablaProductos.addCell(noProductos);
//////            }
//////
//////            doc.add(tablaProductos);
//////
//////            // Total actualizado
//////            doc.add(new Paragraph(" "));
//////            Paragraph totalParagraph = new Paragraph(
//////                    "TOTAL A PAGAR ACTUALIZADO: $" + String.format("%.2f", totalGeneral),
//////                    new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD, BaseColor.BLUE)
//////            );
//////            totalParagraph.setAlignment(Element.ALIGN_RIGHT);
//////            doc.add(totalParagraph);
//////
//////            // SECCIÓN: Información de devoluciones (mostrar datos de la tabla)
//////            doc.add(new Paragraph(" "));
//////            Paragraph devolucionesTitulo = new Paragraph("INFORMACIÓN DE DEVOLUCIONES:",
//////                    new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.RED));
//////            doc.add(devolucionesTitulo);
//////
//////            // Mostrar las devoluciones basadas en la tabla
//////            PdfPTable tablaDevoluciones = new PdfPTable(3);
//////            tablaDevoluciones.setWidthPercentage(100);
//////            float[] columnasDev = new float[]{50f, 25f, 25f};
//////            tablaDevoluciones.setWidths(columnasDev);
//////
//////            // Headers devoluciones
//////            PdfPCell[] headersDev = {
//////                new PdfPCell(new Phrase("PRODUCTO", negrita)),
//////                new PdfPCell(new Phrase("CANTIDAD DEV.", negrita)),
//////                new PdfPCell(new Phrase("ESTADO", negrita))
//////            };
//////
//////            for (PdfPCell header : headersDev) {
//////                header.setBackgroundColor(BaseColor.PINK);
//////                header.setHorizontalAlignment(Element.ALIGN_CENTER);
//////                tablaDevoluciones.addCell(header);
//////            }
//////
//////            boolean hayDevoluciones = false;
//////            // 🚨 DEBUG: Mostrar el contenido del mapa antes de procesar
//////            System.out.println("=== CONTENIDO DEL MAPA DE DEVOLUCIONES ===");
//////            for (Map.Entry<String, Integer> entry : cantidadesADevolver.entrySet()) {
//////                System.out.println("Producto: '" + entry.getKey() + "' -> Cantidad: " + entry.getValue());
//////            }
//////            System.out.println("===========================================");
//////
//////            // Agregar filas de devoluciones desde la tabla
//////            for (Map.Entry<String, Integer> entry : cantidadesADevolver.entrySet()) {
//////                System.out.println("Evaluando: " + entry.getKey() + " con cantidad: " + entry.getValue());
//////
//////                if (entry.getValue() > 0) {
//////                    hayDevoluciones = true;
//////                    System.out.println("✅ Agregando devolución: " + entry.getKey() + " - " + entry.getValue());
//////
//////                    tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getKey())));
//////                    tablaDevoluciones.addCell(new PdfPCell(new Phrase(entry.getValue().toString())));
//////                    tablaDevoluciones.addCell(new PdfPCell(new Phrase("A DEVOLVER",
//////                            new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.RED))));
//////                } else {
//////                    System.out.println("❌ Sin devolución para: " + entry.getKey());
//////                }
//////            }
//////
//////            if (hayDevoluciones) {
//////                System.out.println("✅ HAY DEVOLUCIONES - Agregando tabla al PDF");
//////                doc.add(tablaDevoluciones);
//////            } else {
//////                System.out.println("❌ NO HAY DEVOLUCIONES - Mostrando mensaje");
//////                Paragraph sinDev = new Paragraph("No hay devoluciones registradas para esta venta.",
//////                        new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
//////                doc.add(sinDev);
//////            }
//////
//////            con.close();
//////
//////            // Nota final
//////            doc.add(new Paragraph(" "));
//////            Paragraph notaFinal = new Paragraph(
//////                    "DOCUMENTO ACTUALIZADO: Este documento refleja el estado actual de la venta "
//////                    + "después de procesar las devoluciones correspondientes. "
//////                    + "Fecha de generación: " + fechaActualizacion,
//////                    new Font(Font.FontFamily.HELVETICA, 10, Font.ITALIC, BaseColor.GRAY));
//////            notaFinal.setAlignment(Element.ALIGN_CENTER);
//////            doc.add(notaFinal);
//////
//////            // Firma
//////            doc.add(new Paragraph(" "));
//////            doc.add(new Paragraph(" "));
//////            Paragraph firma = new Paragraph("AUTORIZADO POR:\n\n_________________________\nFirma y Sello");
//////            firma.setAlignment(Element.ALIGN_CENTER);
//////            doc.add(firma);
//////
//////            doc.close();
//////            archivo.close();
//////
//////            // Abrir automáticamente
//////            Desktop.getDesktop().open(file);
//////            JOptionPane.showMessageDialog(null,
//////                    "PDF actualizado generado exitosamente:\n" + nombreArchivo);
//////
//////        } catch (Exception e) {
//////            JOptionPane.showMessageDialog(null,
//////                    "Error al generar PDF actualizado: " + e.getMessage());
//////            e.printStackTrace();
//////        }
    //////    }
    ////////
    ///
}
