package vista;

import javax.swing.JDesktopPane;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class InterFacturacion extends javax.swing.JInternalFrame {

    public static JDesktopPane jDesktopPaneMenu;

    public InterFacturacion() {
        initComponents();
        this.setSize(1433, 632);
        this.setTitle("Facturacion");
        this.cargarCliente();
        this.cargarProducto();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        comboBoxProducto = new javax.swing.JComboBox<>();
        comboBoxCliente = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        txtProductoBuscar = new javax.swing.JTextField();
        botonBuscarProducto = new javax.swing.JButton();
        txtClienteBuscar = new javax.swing.JTextField();
        botonBuscarCliente1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        txtSubTotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtIva = new javax.swing.JTextField();
        txtTotalPagar = new javax.swing.JTextField();
        txtEfectivo = new javax.swing.JTextField();
        botonCalcularCambio1 = new javax.swing.JButton();
        botonBuscarProducto2 = new javax.swing.JButton();
        botonRegistrarVenta = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 240, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("cantidad:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cliente: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Producto:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 100, 30));

        comboBoxProducto.setBackground(new java.awt.Color(221, 240, 254));
        comboBoxProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        comboBoxProducto.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Producto:", "Item 2", "Item 3", "Item 4" }));
        comboBoxProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxProductoActionPerformed(evt);
            }
        });
        jPanel1.add(comboBoxProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 360, 30));

        comboBoxCliente.setBackground(new java.awt.Color(221, 240, 254));
        comboBoxCliente.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        comboBoxCliente.setForeground(new java.awt.Color(0, 0, 0));
        comboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Cliente:", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(comboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 360, 30));

        txtCantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtCantidad.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 70, 30));

        txtProductoBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtProductoBuscar.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtProductoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtProductoBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtProductoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProductoBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtProductoBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 290, 30));

        botonBuscarProducto.setBackground(new java.awt.Color(0, 153, 255));
        botonBuscarProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonBuscarProducto.setForeground(new java.awt.Color(0, 0, 0));
        botonBuscarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadiral-carritoo.png"))); // NOI18N
        botonBuscarProducto.setText("Agregar");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 130, 30));

        txtClienteBuscar.setBackground(new java.awt.Color(255, 255, 255));
        txtClienteBuscar.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtClienteBuscar.setForeground(new java.awt.Color(0, 0, 0));
        txtClienteBuscar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtClienteBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClienteBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(txtClienteBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 290, 30));

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
        jPanel1.add(botonBuscarCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 110, 30));

        jPanel2.setBackground(new java.awt.Color(221, 240, 254));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setBackground(new java.awt.Color(221, 240, 254));
        tablaProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tablaProductos.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        tablaProductos.setForeground(new java.awt.Color(0, 0, 0));
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaProductos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 310));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 910, 310));

        jPanel3.setBackground(new java.awt.Color(217, 232, 237));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(217, 232, 237));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("SubTotal:");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 110, 50));

        jLabel5.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Descuento:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 100, 50));

        jLabel7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("IVA:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 122, 80, 30));

        jLabel9.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Total a Pagar:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 160, 110, 50));

        jLabel1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Efectivo:");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 220, 70, 30));

        jLabel8.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Cambio: ");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 282, 70, 30));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 330));

        txtCambio.setEditable(false);
        txtCambio.setBackground(new java.awt.Color(255, 255, 255));
        txtCambio.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtCambio.setForeground(new java.awt.Color(0, 0, 0));
        txtCambio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtCambio.setEnabled(false);
        jPanel3.add(txtCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 250, 30));

        txtSubTotal.setEditable(false);
        txtSubTotal.setBackground(new java.awt.Color(255, 255, 255));
        txtSubTotal.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtSubTotal.setForeground(new java.awt.Color(0, 0, 0));
        txtSubTotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtSubTotal.setEnabled(false);
        jPanel3.add(txtSubTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 250, 30));

        txtDescuento.setEditable(false);
        txtDescuento.setBackground(new java.awt.Color(255, 255, 255));
        txtDescuento.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtDescuento.setForeground(new java.awt.Color(0, 0, 0));
        txtDescuento.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtDescuento.setEnabled(false);
        jPanel3.add(txtDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 250, 30));

        txtIva.setEditable(false);
        txtIva.setBackground(new java.awt.Color(255, 255, 255));
        txtIva.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtIva.setForeground(new java.awt.Color(0, 0, 0));
        txtIva.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtIva.setEnabled(false);
        jPanel3.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 250, 30));

        txtTotalPagar.setEditable(false);
        txtTotalPagar.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPagar.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtTotalPagar.setForeground(new java.awt.Color(0, 0, 0));
        txtTotalPagar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtTotalPagar.setEnabled(false);
        jPanel3.add(txtTotalPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 250, 30));

        txtEfectivo.setBackground(new java.awt.Color(255, 255, 255));
        txtEfectivo.setFont(new java.awt.Font("Roboto Condensed", 0, 24)); // NOI18N
        txtEfectivo.setForeground(new java.awt.Color(0, 0, 0));
        txtEfectivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.add(txtEfectivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 250, 30));

        botonCalcularCambio1.setBackground(new java.awt.Color(0, 153, 255));
        botonCalcularCambio1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonCalcularCambio1.setForeground(new java.awt.Color(0, 0, 0));
        botonCalcularCambio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevaventa.png"))); // NOI18N
        botonCalcularCambio1.setText("Calcular Cambio");
        botonCalcularCambio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularCambio1ActionPerformed(evt);
            }
        });
        jPanel3.add(botonCalcularCambio1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 200, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 90, 460, 400));

        botonBuscarProducto2.setBackground(new java.awt.Color(0, 153, 255));
        botonBuscarProducto2.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonBuscarProducto2.setForeground(new java.awt.Color(0, 0, 0));
        botonBuscarProducto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarproducto.png"))); // NOI18N
        botonBuscarProducto2.setText("Buscar");
        botonBuscarProducto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProducto2ActionPerformed(evt);
            }
        });
        jPanel1.add(botonBuscarProducto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 110, 30));

        botonRegistrarVenta.setBackground(new java.awt.Color(0, 153, 255));
        botonRegistrarVenta.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonRegistrarVenta.setForeground(new java.awt.Color(0, 0, 0));
        botonRegistrarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/impresoraaa.png"))); // NOI18N
        botonRegistrarVenta.setText("Registrar Venta");
        botonRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRegistrarVentaActionPerformed(evt);
            }
        });
        jPanel1.add(botonRegistrarVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 500, 180, 40));

        jLabel10.setBackground(new java.awt.Color(221, 240, 254));
        jLabel10.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Facturación");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1430, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxProductoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtProductoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoBuscarActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    private void txtClienteBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClienteBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClienteBuscarActionPerformed

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
            txtClienteBuscar.setText("");
            con.close();
        } catch (SQLException e) {
            System.out.println("error al buscar cliente" + e);
        }
    }//GEN-LAST:event_botonBuscarCliente1ActionPerformed

    private void botonRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRegistrarVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonRegistrarVentaActionPerformed

    private void botonBuscarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProducto2ActionPerformed
//       String productoBuscar = txtProductoBuscar.getText().trim();
//        Connection con = conexion.Conexion.conectar();
//        String sql = "SELECT * FROM tb_producto where nombre='" + productoBuscar + "';";
//        Statement st;
//        try {
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            if (rs.next()) {
//                comboBoxProducto.setSelectedItem(rs.getString("nombre") );
//            } else {
//                comboBoxProducto.setSelectedItem("Seleccione Producto:");
//                JOptionPane.showMessageDialog(null, "ElProducto no pude ser encontrado por ese nombre ");
//            }
//            txtClienteBuscar.setText("");
//            con.close();
//        } catch (SQLException e) {
//            System.out.println("error al buscar Producto" + e);
//        }

        String productoBuscar = txtProductoBuscar.getText().trim();
        Connection con = conexion.Conexion.conectar();
        String sql = "SELECT * FROM tb_producto WHERE nombre LIKE ?;";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, productoBuscar + "%"); // Busca productos que empiecen con lo escrito
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                comboBoxProducto.setSelectedItem(rs.getString("nombre"));
            } else {
                comboBoxProducto.setSelectedItem("Seleccione Producto:");
                JOptionPane.showMessageDialog(null, "El producto no pudo ser encontrado con ese nombre.");
            }

            txtProductoBuscar.setText("");
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar producto: " + e);
        }
    }//GEN-LAST:event_botonBuscarProducto2ActionPerformed

    private void botonCalcularCambio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularCambio1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCalcularCambio1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonBuscarCliente1;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonBuscarProducto2;
    private javax.swing.JButton botonCalcularCambio1;
    private javax.swing.JButton botonRegistrarVenta;
    private javax.swing.JComboBox<String> comboBoxCliente;
    private javax.swing.JComboBox<String> comboBoxProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClienteBuscar;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtProductoBuscar;
    private javax.swing.JTextField txtSubTotal;
    private javax.swing.JTextField txtTotalPagar;
    // End of variables declaration//GEN-END:variables
    //metodo para cargar clientes
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

    private void cargarProducto() {
        Connection con = conexion.Conexion.conectar();
        String sql = "SELECT * FROM tb_producto;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            comboBoxProducto.removeAllItems();
            comboBoxProducto.addItem("Seleccione Producto:");
            while (rs.next()) {
                comboBoxProducto.addItem(rs.getString("nombre"));
            }
            con.close();
        } catch (SQLException e) {

        }
    }

}
