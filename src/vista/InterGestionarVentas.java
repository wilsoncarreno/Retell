package vista;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.*;
import java.sql.*;
import javax.swing.JOptionPane;
import conexion.Conexion;
import controlador.ControladorCliente;
import controlador.ControladorRegistrarVenta;
import controlador.VentaPDF;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.Cliente;
import modelo.DetalleVenta;
import modelo.Producto;

public class InterGestionarVentas extends javax.swing.JInternalFrame {

    private int idProducto;
    private int idCliente = 0;
    private int idVenta;
    private int idVentaSeleccionada;

    private DefaultTableModel modeloDatosProductos;
    private DetalleVenta productoDetalleVenta;

    public InterGestionarVentas() {
        initComponents();
//        this.setSize(1182, 607);
        this.setSize(new Dimension(1452, 627));
        this.setTitle("Gestionar Venta");
        this.cargarCliente();
        this.cargarTablaVenta();
        this.inicializarTablaProducto();

    }

    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Solo la última columna (Cantidad a devolver) es editable
                return column == 8;
            }
        };

        //añadir columnas
        modeloDatosProductos.addColumn("N°");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("Precio Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva por Unidad");
        modeloDatosProductos.addColumn("Total a Pagar");
        modeloDatosProductos.addColumn("Cantidad a devolver");
        //agregar los datos del modelo a la tabla
        this.TablaProductosADevolver.setModel(modeloDatosProductos);
        TablaProductosADevolver.setRowHeight(30);

        //metodo para presentar informacion de la tabla 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVenta = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotalPagar = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        botonActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxEstado = new javax.swing.JComboBox<>();
        comboBoxCliente = new javax.swing.JComboBox<>();
        botonBuscarCliente1 = new javax.swing.JButton();
        txtClienteBuscar = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablaProductosADevolver = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        botonDevolver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 240, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaVenta.setBackground(new java.awt.Color(221, 240, 254));
        tablaVenta.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        tablaVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaVenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 290));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 290));

        jPanel4.setBackground(new java.awt.Color(221, 240, 254));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(221, 240, 254));
        jLabel3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevaventa.png"))); // NOI18N
        jLabel3.setText("Total a Pagar");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 160, 40));

        jLabel5.setBackground(new java.awt.Color(221, 240, 254));
        jLabel5.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario1.png"))); // NOI18N
        jLabel5.setText("Fecha: ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 40));

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPagar.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtTotalPagar.setForeground(new java.awt.Color(0, 0, 0));
        txtTotalPagar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalPagar.setEnabled(false);
        txtTotalPagar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTotalPagarMouseEntered(evt);
            }
        });
        txtTotalPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalPagarActionPerformed(evt);
            }
        });
        jPanel4.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 140, 30));

        txtFecha.setEditable(false);
        txtFecha.setBackground(new java.awt.Color(255, 255, 255));
        txtFecha.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(0, 0, 0));
        txtFecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtFecha.setEnabled(false);
        txtFecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTotalPagarMouseEntered(evt);
            }
        });
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });
        jPanel4.add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 140, 30));

        botonActualizar.setBackground(new java.awt.Color(0, 204, 204));
        botonActualizar.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizarCategoria.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel4.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 120, 40));

        jLabel4.setBackground(new java.awt.Color(221, 240, 254));
        jLabel4.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar (2).png"))); // NOI18N
        jLabel4.setText("Cliente:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 80, 50));

        jLabel6.setBackground(new java.awt.Color(221, 240, 254));
        jLabel6.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/direcciones (1).png"))); // NOI18N
        jLabel6.setText("estado:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 110, 40));

        comboBoxEstado.setBackground(new java.awt.Color(221, 240, 254));
        comboBoxEstado.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        comboBoxEstado.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        comboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxEstadoActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 140, 30));

        comboBoxCliente.setBackground(new java.awt.Color(221, 240, 254));
        comboBoxCliente.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        comboBoxCliente.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", "Item 2", "Item 3", "Item 4" }));
        comboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxClienteActionPerformed(evt);
            }
        });
        jPanel4.add(comboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 270, 30));

        botonBuscarCliente1.setBackground(new java.awt.Color(0, 153, 255));
        botonBuscarCliente1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonBuscarCliente1.setForeground(new java.awt.Color(0, 0, 0));
        botonBuscarCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar (2).png"))); // NOI18N
        botonBuscarCliente1.setText("Buscar");
        botonBuscarCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarCliente1ActionPerformed(evt);
            }
        });
        jPanel4.add(botonBuscarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 110, 30));

        txtClienteBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteBuscar.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtClienteBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtClienteBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtClienteBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtClienteBuscarMouseEntered(evt);
            }
        });
        txtClienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteBuscarActionPerformed(evt);
            }
        });
        jPanel4.add(txtClienteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 230, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 650, 220));

        jPanel3.setBackground(new java.awt.Color(217, 232, 237));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaProductosADevolver.setBackground(new java.awt.Color(221, 240, 254));
        TablaProductosADevolver.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        TablaProductosADevolver.setForeground(new java.awt.Color(0, 0, 0));
        TablaProductosADevolver.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaProductosADevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaProductosADevolverMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TablaProductosADevolver);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 750, 290));

        jLabel8.setBackground(new java.awt.Color(217, 232, 237));
        jLabel8.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Devolucion de productos");
        jLabel8.setToolTipText("");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 190, 30));

        botonDevolver.setBackground(new java.awt.Color(0, 153, 255));
        botonDevolver.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        botonDevolver.setForeground(new java.awt.Color(0, 0, 0));
        botonDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/devolucionnn.png"))); // NOI18N
        botonDevolver.setText("Devolucion");
        botonDevolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonDevolverMouseClicked(evt);
            }
        });
        botonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonDevolverActionPerformed(evt);
            }
        });
        jPanel3.add(botonDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 150, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 760, 590));

        jLabel7.setBackground(new java.awt.Color(221, 240, 254));
        jLabel7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Gestionar Venta");
        jLabel7.setToolTipText("");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 190, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1430, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        ControladorRegistrarVenta controlRegistrarVenta = new ControladorRegistrarVenta();
        String cliente, estado;
        cliente = comboBoxCliente.getSelectedItem().toString().trim();
        estado = comboBoxEstado.getSelectedItem().toString().trim();
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "SELECT idCliente, CONCAT(nombre,' ',apellido) AS cliente FROM tb_cliente WHERE CONCAT(nombre,' ',apellido) = ?;"
            );
            pst.setString(1, cliente);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("error al cargar el id cliente " + e);
        }

        if (!cliente.equalsIgnoreCase("Seleccione Cliente:")) {
            cabeceraVenta.setIdCliente(idCliente);
            if (estado.equalsIgnoreCase("Activo")) {
                cabeceraVenta.setEstado(1);
            } else {
                cabeceraVenta.setEstado(0);
            }
            if (controlRegistrarVenta.actualizar(cabeceraVenta, idVenta)) {
                this.cargarTablaVenta();
                JOptionPane.showMessageDialog(null, "Registro Actualizado");
                this.limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error al  Actualizar");
            }
        } else {
            JOptionPane.showMessageDialog(null, "seleccione registro para actualizar datos");
        }


    }//GEN-LAST:event_botonActualizarActionPerformed

    private void txtTotalPagarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTotalPagarMouseEntered
        txtTotalPagar.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtTotalPagarMouseEntered

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        txtFecha.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtFechaActionPerformed

    private void txtTotalPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalPagarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalPagarActionPerformed

    private void comboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxClienteActionPerformed

    private void comboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxEstadoActionPerformed

    private void botonBuscarCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarCliente1ActionPerformed
        String clienteBuscar = txtClienteBuscar.getText().trim();
        Connection con = conexion.Conexion.conectar();
        String sql = "SELECT nombre, apellido FROM tb_cliente where cedula='" + clienteBuscar + "';";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                comboBoxCliente.setSelectedItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            } else {
                comboBoxCliente.setSelectedItem("Seleccione Cliente:");
                JOptionPane.showMessageDialog(null, "Cedula de Cliente incorrecta o no encontrada");
            }
//            txtTotalPagar.setText("");
//            txtFecha.setText("");
            con.close();
        } catch (SQLException e) {
            System.out.println("error al buscar cliente" + e);
        }
    }//GEN-LAST:event_botonBuscarCliente1ActionPerformed

    private void txtClienteBuscarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtClienteBuscarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteBuscarMouseEntered

    private void txtClienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteBuscarActionPerformed

    private void TablaProductosADevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaProductosADevolverMouseClicked

    }//GEN-LAST:event_TablaProductosADevolverMouseClicked

    private void botonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonDevolverActionPerformed
        realizarDevolucionMultiplePorColumna();
        limpiar();
        DefaultTableModel modelo = (DefaultTableModel) TablaProductosADevolver.getModel();
        modelo.setRowCount(0);
    }//GEN-LAST:event_botonDevolverActionPerformed

    private void botonDevolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonDevolverMouseClicked

    }//GEN-LAST:event_botonDevolverMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TablaProductosADevolver;
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonBuscarCliente1;
    private javax.swing.JButton botonDevolver;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JComboBox<String> comboBoxEstado;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tablaVenta;
    private javax.swing.JTextField txtClienteBuscar;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
    private void cargarTablaVenta() {
        Connection con = conexion.Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select  cv.idCabeceraVenta as id, concat(c.nombre,' ',c.apellido) as cliente, "
                + "cv.valorPagar as total, cv.fechaVenta	as fecha, cv.estado "
                + "from  tb_cabecera_venta as cv,  tb_cliente as c where cv.idCliente=c.idCliente;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarVentas.tablaVenta = new JTable(model);
            InterGestionarVentas.jScrollPane1.setViewportView(InterGestionarVentas.tablaVenta);
            model.addColumn("N°");
            model.addColumn("Cliente");
            model.addColumn("Total a Pagar");
            model.addColumn("Fecha Venta");
            model.addColumn("Estado");
            while (rs.next()) {
                Object fila[] = new Object[5];
                for (int i = 0; i < 5; i++) {
                    if (i == 4) {
                        String estado = String.valueOf(rs.getObject(i + 1));
                        if (estado.equalsIgnoreCase("1")) {
                            fila[i] = "Activo";

                        } else {
                            fila[i] = "Inactivo";
                        }
                    } else {
                        fila[i] = rs.getObject(i + 1);
                    }

                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de ventas " + e);
        }
        InterGestionarVentas.tablaVenta.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int filaPoint = InterGestionarVentas.tablaVenta.rowAtPoint(e.getPoint());
                int columnaPoint = 0;
                if (filaPoint > -1) {
                    idVenta = (int) model.getValueAt(filaPoint, columnaPoint);
                    EnviarDatosVentaSeleccionada(idVenta);
                }

            }
        });
    }

    private void limpiar() {
        this.txtTotalPagar.setText("");
        this.txtFecha.setText("");
        this.comboBoxCliente.setSelectedItem("Seleccione Cliente:");
        this.comboBoxEstado.setSelectedItem("Activo");
        idCliente = 0;
    }

    private void cargarCliente() {
        Connection con = conexion.Conexion.conectar();
        String sql = "SELECT * FROM tb_cliente;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboBoxCliente.removeAllItems();
            comboBoxCliente.addItem("Seleccione Cliente:");
            while (rs.next()) {
                comboBoxCliente.addItem(rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al cargar clientes" + e);
        }

    }

    public void EnviarDatosVentaSeleccionada(int idVenta) {
        this.idVentaSeleccionada = idVenta; // AGREGAR ESTA LÍNEA
        this.limpiar();
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement("select  cv.idCabeceraVenta, cv.idCliente, "
                    + "concat (c.nombre,' ',c.apellido) as cliente, cv.valorPagar, cv.fechaVenta, cv.estado "
                    + " from  tb_cabecera_venta as cv,  tb_cliente  as  c "
                    + " where  cv.idCabeceraVenta = ? and  cv.idCliente =  c.idCliente");
            pst.setInt(1, idVenta);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                comboBoxCliente.setSelectedItem(rs.getString("cliente"));
                txtTotalPagar.setText(rs.getString("valorPagar"));
                txtFecha.setText(rs.getString("fechaVenta"));
                cargarProductosDeVenta(idVenta);
                int estado = rs.getInt("estado");
                if (estado == 1) {
                    comboBoxEstado.setSelectedItem("Activo");
                } else {
                    comboBoxEstado.setSelectedItem("Inactivo");
                }
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar venta" + e.getMessage());
        }
    }

    private void cargarProductosDeVenta(int idVenta) {
        // limpiar datos previos
        modeloDatosProductos.setRowCount(0);

        try (Connection con = conexion.Conexion.conectar()) {
            String sql = "SELECT p.nombre, dv.cantidad, dv.precioUnitario, dv.subtotal, "
                    + "dv.descuento, dv.iva, dv.totalPagar "
                    + "FROM tb_detalle_venta dv "
                    + "INNER JOIN tb_producto p ON dv.idProducto = p.idProducto "
                    + "WHERE dv.idCabeceraVenta = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, idVenta);
            ResultSet rs = pst.executeQuery();

            int contador = 1;
            while (rs.next()) {
                Object[] fila = new Object[9];
                fila[0] = contador++; // N°
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("cantidad");
                fila[3] = rs.getDouble("precioUnitario");
                fila[4] = rs.getDouble("subtotal");
                fila[5] = rs.getDouble("descuento");
                fila[6] = rs.getDouble("iva");
                fila[7] = rs.getDouble("totalPagar");
                fila[8] = 0; // columna de acción

                modeloDatosProductos.addRow(fila);
            }

            TablaProductosADevolver.setModel(modeloDatosProductos);
            TablaProductosADevolver.setRowHeight(30);

        } catch (SQLException e) {
            System.out.println("Error al cargar productos de la venta: " + e.getMessage());
        }
    }

    private void realizarDevolucionMultiplePorColumna() {
        try {
            if (idVentaSeleccionada == 0) {
                JOptionPane.showMessageDialog(null, "Primero debe seleccionar una venta.");
                return;
            }

            Connection con = conexion.Conexion.conectar();
            con.setAutoCommit(false);

            try {
                boolean devolvioAlgo = false;

                for (int fila = 0; fila < modeloDatosProductos.getRowCount(); fila++) {
                    String nombreProducto = (String) modeloDatosProductos.getValueAt(fila, 1);
                    int cantidadVenta = Integer.parseInt(modeloDatosProductos.getValueAt(fila, 2).toString());
                    int cantidadDevolver = Integer.parseInt(modeloDatosProductos.getValueAt(fila, 8).toString()); // ahora es 8

                    if (cantidadDevolver > 0) {
                        devolvioAlgo = true;

                        if (cantidadDevolver > cantidadVenta) {
                            JOptionPane.showMessageDialog(null,
                                    "La cantidad a devolver de '" + nombreProducto + "' no puede ser mayor a la vendida.");
                            continue; // saltar este producto
                        }

                        int idProducto = obtenerIdProductoPorNombre(nombreProducto);
                        if (idProducto == -1) {
                            continue;
                        }

                        // Eliminar o actualizar detalle
                        if (cantidadVenta == cantidadDevolver) {
                            PreparedStatement psEliminar = con.prepareStatement(
                                    "DELETE FROM tb_detalle_venta WHERE idCabeceraVenta = ? AND idProducto = ?");
                            psEliminar.setInt(1, idVentaSeleccionada);
                            psEliminar.setInt(2, idProducto);
                            psEliminar.executeUpdate();
                        } else {
                            PreparedStatement psDetalle = con.prepareStatement(
                                    "UPDATE tb_detalle_venta SET cantidad = cantidad - ?, "
                                    + "subtotal = (cantidad - ?) * precioUnitario, "
                                    + "totalPagar = ((cantidad - ?) * precioUnitario) - descuento + iva "
                                    + "WHERE idCabeceraVenta = ? AND idProducto = ?");
                            psDetalle.setInt(1, cantidadDevolver);
                            psDetalle.setInt(2, cantidadDevolver);
                            psDetalle.setInt(3, cantidadDevolver);
                            psDetalle.setInt(4, idVentaSeleccionada);
                            psDetalle.setInt(5, idProducto);
                            psDetalle.executeUpdate();
                        }

                        // Actualizar stock
                        PreparedStatement psStock = con.prepareStatement(
                                "UPDATE tb_producto SET cantidad = cantidad + ? WHERE idProducto = ?");
                        psStock.setInt(1, cantidadDevolver);
                        psStock.setInt(2, idProducto);
                        psStock.executeUpdate();

                        // Registrar devolución
                        registrarDevolucion(idVentaSeleccionada, idProducto, cantidadDevolver, con);
                    }
                }

                if (!devolvioAlgo) {
                    JOptionPane.showMessageDialog(null, "No ingresó ninguna cantidad para devolver.");
                    return;
                }

                // Actualizar total venta
                actualizarTotalVenta(idVentaSeleccionada, con);

                con.commit();

                cargarProductosDeVenta(idVentaSeleccionada);
                cargarTablaVenta();
                generarPDFActualizado();

                JOptionPane.showMessageDialog(null, "Devoluciones procesadas correctamente.");

            } catch (SQLException ex) {
                con.rollback();
                throw ex;
            } finally {
                con.setAutoCommit(true);
                con.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,
                    "Error en la devolución múltiple: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

//    private void agregarEventoClickProductos() {
//        TablaProductosADevolver.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int fila = TablaProductosADevolver.rowAtPoint(e.getPoint());
//                if (fila > -1) {
//                    // Tomar valores de la fila seleccionada
//                    String nombreProducto = (String) modeloDatosProductos.getValueAt(fila, 1); // columna "Nombre"
//                    int cantidad = (int) modeloDatosProductos.getValueAt(fila, 2);             // columna "Cantidad"
//
//                    // Enviar a los componentes
//                    txtNombreProducto.setText(nombreProducto);
//                    jSpinnerCantidad.setValue(cantidad);
//                }
//            }
//        });
//    }
    public boolean actualizar(CabeceraVenta objeto, int idCabeceraVenta) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_cabecera_venta set idCliente=?, estado=? where idCabeceraVenta ='" + idCabeceraVenta + "';");

            consulta.setInt(1, objeto.getIdCliente());
            consulta.setInt(2, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("error al actualizar cabecera de venta   " + e);
        }
        return respuesta;
    }

    private int obtenerIdProductoPorNombre(String nombre) throws SQLException {
        int idProducto = -1;
        Connection con = conexion.Conexion.conectar();
        String sql = "SELECT idProducto FROM tb_producto WHERE nombre = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            idProducto = rs.getInt("idProducto");
        }
        con.close();
        return idProducto;
    }

    private void actualizarTotalVenta(int idVenta, Connection con) throws SQLException {
        String sqlTotal = "UPDATE tb_cabecera_venta SET valorPagar = ("
                + "SELECT COALESCE(SUM(totalPagar), 0) FROM tb_detalle_venta WHERE idCabeceraVenta = ?"
                + ") WHERE idCabeceraVenta = ?";
        PreparedStatement psTotal = con.prepareStatement(sqlTotal);
        psTotal.setInt(1, idVenta);
        psTotal.setInt(2, idVenta);
        psTotal.executeUpdate();
    }

    private void registrarDevolucion(int idVenta, int idProducto, int cantidad, Connection con) {

        try {
            // Obtener el precio unitario del producto desde la venta original
            String sqlPrecio = "SELECT precioUnitario FROM tb_detalle_venta WHERE idCabeceraVenta = ? AND idProducto = ?";
            PreparedStatement psPrecio = con.prepareStatement(sqlPrecio);
            psPrecio.setInt(1, idVenta);
            psPrecio.setInt(2, idProducto);
            ResultSet rsPrecio = psPrecio.executeQuery();

            double precioUnitario = 0.0;
            if (rsPrecio.next()) {
                precioUnitario = rsPrecio.getDouble("precioUnitario");
            }

            // Registrar la devolución con el nombre correcto de columna
            String sql = "INSERT INTO tb_devoluciones (idCabeceraVenta, idProducto, cantidad, precioUnitario, fechaDevolucion) VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idVenta);  // Aquí se usa idVenta pero se mapea a idCabeceraVenta
            ps.setInt(2, idProducto);
            ps.setInt(3, cantidad);
            ps.setDouble(4, precioUnitario);
            ps.executeUpdate();

            System.out.println("Devolución registrada exitosamente en tb_devoluciones");

        } catch (SQLException e) {
            // Si la tabla no existe, simplemente ignoramos el error
            System.out.println("Tabla de log de devoluciones no encontrada o error en registro: " + e.getMessage());
        }
    }

//private void realizarDevolucion() {
//    try {
//        if (idVentaSeleccionada == 0) {
//            JOptionPane.showMessageDialog(null, "Primero debe seleccionar una venta.");
//            return;
//        }
//
//        Connection con = conexion.Conexion.conectar();
//        con.setAutoCommit(false);
//
//        try {
//            boolean devolvioAlgo = false;
//
//            for (int fila = 0; fila < modeloDatosProductos.getRowCount(); fila++) {
//                String nombreProducto = (String) modeloDatosProductos.getValueAt(fila, 1);
//                int cantidadVenta = Integer.parseInt(modeloDatosProductos.getValueAt(fila, 2).toString());
//                int cantidadDevolver = Integer.parseInt(modeloDatosProductos.getValueAt(fila, 8).toString()); // columna editable
//
//                if (cantidadDevolver > 0) {
//                    devolvioAlgo = true;
//
//                    if (cantidadDevolver > cantidadVenta) {
//                        JOptionPane.showMessageDialog(null,
//                                "La cantidad a devolver de '" + nombreProducto + "' no puede ser mayor a la vendida.");
//                        continue; // saltar este producto
//                    }
//
//                    int idProducto = obtenerIdProductoPorNombre(nombreProducto);
//                    if (idProducto == -1) continue;
//
//                    // Eliminar o actualizar detalle
//                    if (cantidadVenta == cantidadDevolver) {
//                        PreparedStatement psEliminar = con.prepareStatement(
//                            "DELETE FROM tb_detalle_venta WHERE idCabeceraVenta = ? AND idProducto = ?");
//                        psEliminar.setInt(1, idVentaSeleccionada);
//                        psEliminar.setInt(2, idProducto);
//                        psEliminar.executeUpdate();
//                    } else {
//                        PreparedStatement psDetalle = con.prepareStatement(
//                            "UPDATE tb_detalle_venta SET cantidad = cantidad - ?, "
//                            + "subtotal = (cantidad - ?) * precioUnitario, "
//                            + "totalPagar = ((cantidad - ?) * precioUnitario) - descuento + iva "
//                            + "WHERE idCabeceraVenta = ? AND idProducto = ?");
//                        psDetalle.setInt(1, cantidadDevolver);
//                        psDetalle.setInt(2, cantidadDevolver);
//                        psDetalle.setInt(3, cantidadDevolver);
//                        psDetalle.setInt(4, idVentaSeleccionada);
//                        psDetalle.setInt(5, idProducto);
//                        psDetalle.executeUpdate();
//                    }
//
//                    // Actualizar stock
//                    PreparedStatement psStock = con.prepareStatement(
//                        "UPDATE tb_producto SET cantidad = cantidad + ? WHERE idProducto = ?");
//                    psStock.setInt(1, cantidadDevolver);
//                    psStock.setInt(2, idProducto);
//                    psStock.executeUpdate();
//
//                    // Registrar devolución
//                    registrarDevolucion(idVentaSeleccionada, idProducto, cantidadDevolver, con);
//                }
//            }
//
//            if (!devolvioAlgo) {
//                JOptionPane.showMessageDialog(null, "No ingresó ninguna cantidad para devolver.");
//                return;
//            }
//
//            // Actualizar total venta
//            actualizarTotalVenta(idVentaSeleccionada, con);
//
//            con.commit();
//
//            cargarProductosDeVenta(idVentaSeleccionada);
//            cargarTablaVenta();
//            generarPDFActualizado();
//
//            JOptionPane.showMessageDialog(null, "Devoluciones procesadas correctamente.");
//
//        } catch (SQLException ex) {
//            con.rollback();
//            throw ex;
//        } finally {
//            con.setAutoCommit(true);
//            con.close();
//        }
//
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null,
//                "Error en la devolución: " + e.getMessage(),
//                "Error", JOptionPane.ERROR_MESSAGE);
//    }
//}
// Método para registrar la devolución (opcional - para auditoría)
//    private void realizarDevolucion() {
//        int fila = TablaProductosADevolver.getSelectedRow();
//
//        if (fila >= 0) {
//            try {
//                // 1. Validar que se haya seleccionado una venta
//                if (idVentaSeleccionada == 0) {
//                    JOptionPane.showMessageDialog(null, "Primero debe seleccionar una venta de la tabla superior.");
//                    return;
//                }
//
//                // 2. Obtener datos de la tabla
//                String nombreProducto = (String) TablaProductosADevolver.getValueAt(fila, 1);
//                int cantidadVenta = Integer.parseInt(TablaProductosADevolver.getValueAt(fila, 2).toString());
//                int cantidadDevolver = (int) jSpinnerCantidad.getValue();
//
//                // 3. Validaciones
//                if (cantidadDevolver <= 0) {
//                    JOptionPane.showMessageDialog(null, "La cantidad a devolver debe ser mayor a cero.");
//                    return;
//                }
//
//                if (cantidadDevolver > cantidadVenta) {
//                    JOptionPane.showMessageDialog(null, "La cantidad a devolver no puede ser mayor a la cantidad vendida.");
//                    return;
//                }
//
//                // 4. Obtener ID del producto
//                int idProducto = obtenerIdProductoPorNombre(nombreProducto);
//                if (idProducto == -1) {
//                    JOptionPane.showMessageDialog(null, "No se pudo encontrar el producto.");
//                    return;
//                }
//
//                // 5. Confirmar la devolución
//                String mensaje = String.format(
//                        "¿Está seguro de devolver %d unidades de '%s'?\n\n"
//                        + "✓ Se actualizará el inventario\n"
//                        + "✓ Se recalculará el total de la venta\n"
//                        + "✓ Se generará un PDF actualizado automáticamente",
//                        cantidadDevolver, nombreProducto);
//
//                int confirmacion = JOptionPane.showConfirmDialog(null, mensaje,
//                        "Confirmar Devolución", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//
//                if (confirmacion != JOptionPane.YES_OPTION) {
//                    return;
//                }
//
//                Connection con = conexion.Conexion.conectar();
//                con.setAutoCommit(false); // Iniciar transacción
//
//                try {
//                    // 6. Verificar si después de la devolución la cantidad sería 0
//                    boolean eliminarDetalle = (cantidadVenta == cantidadDevolver);
//
//                    if (eliminarDetalle) {
//                        // Eliminar completamente el detalle de venta
//                        String sqlEliminar = "DELETE FROM tb_detalle_venta WHERE idCabeceraVenta = ? AND idProducto = ?";
//                        PreparedStatement psEliminar = con.prepareStatement(sqlEliminar);
//                        psEliminar.setInt(1, idVentaSeleccionada);
//                        psEliminar.setInt(2, idProducto);
//                        psEliminar.executeUpdate();
//                    } else {
//                        // Restar cantidad en detalle de venta
//                        String sqlDetalle = "UPDATE tb_detalle_venta SET cantidad = cantidad - ?, "
//                                + "subtotal = (cantidad - ?) * precioUnitario, "
//                                + "totalPagar = ((cantidad - ?) * precioUnitario) - descuento + iva "
//                                + "WHERE idCabeceraVenta = ? AND idProducto = ?";
//                        PreparedStatement psDetalle = con.prepareStatement(sqlDetalle);
//                        psDetalle.setInt(1, cantidadDevolver);
//                        psDetalle.setInt(2, cantidadDevolver);
//                        psDetalle.setInt(3, cantidadDevolver);
//                        psDetalle.setInt(4, idVentaSeleccionada);
//                        psDetalle.setInt(5, idProducto);
//                        psDetalle.executeUpdate();
//                    }
//
//                    // 7. Aumentar stock en producto
//                    String sqlStock = "UPDATE tb_producto SET cantidad = cantidad + ? WHERE idProducto = ?";
//                    PreparedStatement psStock = con.prepareStatement(sqlStock);
//                    psStock.setInt(1, cantidadDevolver);
//                    psStock.setInt(2, idProducto);
//                    psStock.executeUpdate();
//
//                    // 8. Actualizar el total de la venta
//                    actualizarTotalVenta(idVentaSeleccionada, con);
//
//                    // 9. Registrar la devolución (si existe la tabla)
//                    registrarDevolucion(idVentaSeleccionada, idProducto, cantidadDevolver, con);
//
//                    con.commit(); // Confirmar transacción
//
//                    // 10. Refrescar las tablas y limpiar campos
//                    cargarProductosDeVenta(idVentaSeleccionada);
//                    cargarTablaVenta();
//                    limpiarCamposDevolucion();
//
//                    // 11. GENERAR PDF ACTUALIZADO AUTOMÁTICAMENTE
//                    generarPDFActualizado();
//
//                    // 12. Mensaje de éxito
//                    JOptionPane.showMessageDialog(null,
//                            "✓ Devolución procesada exitosamente\n"
//                            + "✓ Inventario actualizado\n"
//                            + "✓ PDF actualizado generado\n\n"
//                            + "Cantidad devuelta: " + cantidadDevolver + " unidades de " + nombreProducto,
//                            "Devolución Completada", JOptionPane.INFORMATION_MESSAGE);
//
//                } catch (SQLException ex) {
//                    con.rollback(); // Revertir cambios en caso de error
//                    throw ex;
//                } finally {
//                    con.setAutoCommit(true);
//                    con.close();
//                }
//
//            } catch (SQLException e) {
//                JOptionPane.showMessageDialog(null,
//                        "Error en la devolución: " + e.getMessage(),
//                        "Error", JOptionPane.ERROR_MESSAGE);
//                e.printStackTrace();
//            }
//        } else {
//            JOptionPane.showMessageDialog(null,
//                    "Seleccione un producto de la tabla para devolver.",
//                    "Selección requerida", JOptionPane.WARNING_MESSAGE);
//        }
//    }
// Método auxiliar para generar PDF actualizado
    private void generarPDFActualizado() {
        if (idVentaSeleccionada != 0) {
            try {
                // Obtener el ID del cliente de la venta seleccionada
                Connection con = conexion.Conexion.conectar();
                String sql = "SELECT idCliente FROM tb_cabecera_venta WHERE idCabeceraVenta = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idVentaSeleccionada);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int idClienteVenta = rs.getInt("idCliente");
                    con.close();

                    // Crear instancia de VentaPDF y generar el PDF actualizado
                    VentaPDF ventaPDF = new VentaPDF();
                    ventaPDF.generarPDFActualizado(idVentaSeleccionada, idClienteVenta);

                } else {
                    con.close();
                    JOptionPane.showMessageDialog(null, "No se pudo obtener los datos del cliente.");
                }

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al generar PDF: " + e.getMessage());
            }
        }
    }

// Método para limpiar campos después de la devolución
    private void limpiarCamposDevolucion() {

        TablaProductosADevolver.clearSelection();
    }

}
