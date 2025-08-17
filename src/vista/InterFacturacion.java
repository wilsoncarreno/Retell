package vista;

import controlador.ControladorRegistrarVenta;
import controlador.VentaPDF;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.CabeceraVenta;
import modelo.DetalleVenta;

public class InterFacturacion extends javax.swing.JInternalFrame {

    public static JDesktopPane jDesktopPaneMenu;
    private int idProducto = 0;
    private String nombre = "";
    private int cantidadProductoBBD = 0;
    private double precioUnitario = 0.0;
    private int porcentajeIva = 0;

    private int cantidadEntera;//cantidad de productos a comprar
    private double subTotal = 0.0;
    private double descuento = 0.0;
    private double iva = 0.0;
    private double totalPagar = 0.0;

    //variables para calculos globales
    private double subTotalGeneral;
    private double descuentoGeneral;
    private double ivaGeneral;
    private double totalPagarGeneral;
    //fin variables de calculo globales

    private int auxIdDetalle = 1;

    private DefaultTableModel modeloDatosProductos;

    ArrayList<DetalleVenta> listaProducto = new ArrayList<>();
    private DetalleVenta productoDetalleVenta;
    private int idCliente = 0;//idCliente seleccionado

    public InterFacturacion() {
        initComponents();
        this.setSize(1433, 632);
        this.setTitle("Facturacion");
        this.cargarCliente();
        this.cargarProducto();
        this.inicializarTablaProducto();
        txtEfectivo.setEnabled(false);
        this.botonCalcularCambio1.setEnabled(false);

        txtSubTotal.setText("0.0");
        txtDescuento.setText("0.0");
        txtIva.setText("0.0");
        txtTotalPagar.setText("0.0");
    }

    //metodo para inicializar la tabla de los productos
    private void inicializarTablaProducto() {
        modeloDatosProductos = new DefaultTableModel();
        //añadir columnas
        modeloDatosProductos.addColumn("N°");
        modeloDatosProductos.addColumn("Nombre");
        modeloDatosProductos.addColumn("Cantidad");
        modeloDatosProductos.addColumn("Precio Unitario");
        modeloDatosProductos.addColumn("SubTotal");
        modeloDatosProductos.addColumn("Descuento");
        modeloDatosProductos.addColumn("Iva por Unidad");
        modeloDatosProductos.addColumn("Total a Pagar");
        modeloDatosProductos.addColumn("Accion");
        //agregar los datos del modelo a la tabla
        this.tablaProductos.setModel(modeloDatosProductos);
        tablaProductos.setRowHeight(30);

        //metodo para presentar informacion de la tabla 
    }

    private void listatablaProductos() {
        this.modeloDatosProductos.setRowCount(listaProducto.size());
        for (int i = 0; i < listaProducto.size(); i++) {
            this.modeloDatosProductos.setValueAt(i + 1, i, 0);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getNombre(), i, 1);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getCantidad(), i, 2);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getPrecioUnitario(), i, 3);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getSubTotal(), i, 4);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getDescuento(), i, 5);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getIva(), i, 6);
            this.modeloDatosProductos.setValueAt(listaProducto.get(i).getTotalPagar(), i, 7);
            this.modeloDatosProductos.setValueAt("Eliminar", i, 8);
            tablaProductos.setModel(modeloDatosProductos);

        }
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
        botonAgregarProducto = new javax.swing.JButton();
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
        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCantidadMouseEntered(evt);
            }
        });
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

        botonAgregarProducto.setBackground(new java.awt.Color(0, 153, 255));
        botonAgregarProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        botonAgregarProducto.setForeground(new java.awt.Color(0, 0, 0));
        botonAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadiral-carritoo.png"))); // NOI18N
        botonAgregarProducto.setText("Agregar");
        botonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(botonAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 130, 30));

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
        tablaProductos.setAlignmentX(1.0F);
        tablaProductos.setAlignmentY(1.0F);
        tablaProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosMouseClicked(evt);
            }
        });
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
        txtEfectivo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtEfectivoMouseEntered(evt);
            }
        });
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
        txtCantidad.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtProductoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProductoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProductoBuscarActionPerformed

    private void botonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarProductoActionPerformed

        String cantidad = txtCantidad.getText().trim();
        String comboProducto = this.comboBoxProducto.getSelectedItem().toString();
        String comboCliente = this.comboBoxCliente.getSelectedItem().toString();

//         Validar que se haya seleccionado un cliente
        if (!this.estaSeleccionadoCliente(comboCliente)) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un cliente.");
            return;
        }

        // Validar que se haya seleccionado un producto
        if (!this.estaSeleccionadoProducto(comboProducto)) {
//            JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto.");
            return;
        }

        // Validar que la cantidad no esté vacía
        if (cantidad.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese una cantidad.");
            return;
        }

        // Validar que la cantidad sea un número válido
        if (!this.tieneCantidad(cantidad)) {
//            JOptionPane.showMessageDialog(null, "La cantidad ingresada no es válida.");
            return;
        }

        // Validar que la cantidad sea mayor a cero
        if (!this.laCantidadEsMayorAcero(cantidad)) {
//            JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a cero.");
            return;
        }

        // Convertir la cantidad a entero
        try {
            cantidadEntera = Integer.parseInt(cantidad);
        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero válido.");
            return;
        }

        // Validar que la cantidad no supere el stock
        this.datosDelProducto();
        if (cantidadEntera > cantidadProductoBBD) {
            JOptionPane.showMessageDialog(null, "La cantidad supera el stock. CANTIDAD EXISTENTE: " + cantidadProductoBBD);
            return;
        }

        // Calcular subtotal, IVA, descuento y total
        subTotal = precioUnitario * cantidadEntera;
        totalPagar = subTotal + iva + descuento;

        // Redondear decimales
        subTotal = Math.round(subTotal * 100) / 100.0;
        iva = Math.round(iva * 100) / 100.0;
        descuento = Math.round(descuento * 100) / 100.0;
        totalPagar = Math.round(totalPagar * 100) / 100.0;

        // Crear nuevo producto para la lista
        productoDetalleVenta = new DetalleVenta(auxIdDetalle, 1, idProducto, nombre, cantidadEntera, precioUnitario, subTotal, descuento, iva, totalPagar, 1);
        listaProducto.add(productoDetalleVenta);

        // Mostrar mensaje de éxito
        //JOptionPane.showMessageDialog(null, "Producto Agregado");
        auxIdDetalle++;

        // Limpiar campos
        txtCantidad.setText("");
        txtClienteBuscar.setText("");
        txtProductoBuscar.setText("");
        this.listatablaProductos();
        // Recargar combos
        //this.cargarCliente();
        this.cargarProducto();
        this.calcularTotalAPagar();
        txtEfectivo.setEnabled(true);
        this.botonCalcularCambio1.setEnabled(true);


    }//GEN-LAST:event_botonAgregarProductoActionPerformed

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
        CabeceraVenta cabeceraVenta = new CabeceraVenta();
        DetalleVenta detalleVenta = new DetalleVenta();
        ControladorRegistrarVenta controladorRegistrarVenta = new ControladorRegistrarVenta();

        String fechaActual = "";
        Date date = new Date();
        fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);

        if (comboBoxCliente.getSelectedItem().equals("Seleccione Cliente:")) {
            JOptionPane.showMessageDialog(null, "Seleccione un cliente");
            return;
        }
        if (listaProducto.size() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");
            return;
        }
        this.obtenerIdCliente();
        cabeceraVenta.setIdCabeceraVenta(0);
        cabeceraVenta.setIdCliente(idCliente);
        cabeceraVenta.setValorPagar(Double.parseDouble(txtTotalPagar.getText()));
        cabeceraVenta.setFechaVenta(fechaActual);
        cabeceraVenta.setEstado(1);
        if (controladorRegistrarVenta.guardar(cabeceraVenta)) {
            JOptionPane.showMessageDialog(null, "Venta Registrada");
            //generar factura de venta
            VentaPDF pdf= new VentaPDF();
            pdf.datosCliente(idCliente);
            pdf.generarFacturaPDF();
            
            for (DetalleVenta elemento : listaProducto) {
                detalleVenta.setIdDetalleVenta(0);
                detalleVenta.setIdCabeceraVenta(0);
                detalleVenta.setIdProducto(elemento.getIdProducto());
                detalleVenta.setCantidad(elemento.getCantidad());
                detalleVenta.setPrecioUnitario(elemento.getPrecioUnitario());
                detalleVenta.setSubTotal(elemento.getSubTotal());
                detalleVenta.setDescuento(elemento.getDescuento());
                detalleVenta.setIva(elemento.getIva());
                detalleVenta.setTotalPagar(elemento.getTotalPagar());
                detalleVenta.setEstado(1);
                if (controladorRegistrarVenta.guardarDetalle(detalleVenta)) {
//                    System.out.println("Detalle de Venta Registrado");
                    txtSubTotal.setText("0.0");
                    txtDescuento.setText("0.0");
                    txtIva.setText("0.0");
                    txtTotalPagar.setText("0.0");
                    txtEfectivo.setText("");
                    txtCambio.setText("0.0");
                    auxIdDetalle = 1;
                    this.cargarCliente();
                    this.cargarProducto();
                    this.restarStockProductos(elemento.getIdProducto(), elemento.getCantidad());
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto");

        }
        listaProducto.clear();
        listatablaProductos();
    }//GEN-LAST:event_botonRegistrarVentaActionPerformed

    private void botonBuscarProducto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProducto2ActionPerformed
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
        txtEfectivo.setBackground(Color.WHITE);

        // Verificar si txtEfectivo está vacío
        if (txtEfectivo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese la cantidad en efectivo para calcular el cambio");
            txtEfectivo.setBackground(Color.red);
            return;
        }

        // Verificar si txtTotalPagar está vacío
        if (txtTotalPagar.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El total a pagar no puede estar vacío");
            txtTotalPagar.setBackground(Color.red);
            return;
        }

        // Validar que el efectivo sea mayor a 0
        if (!efecticoEsMayorAcero(txtEfectivo.getText().trim())) {
            return; // Detener si el efectivo no es válido
        }

        try {
            double efc = Double.parseDouble(txtEfectivo.getText().trim());
            double top = Double.parseDouble(txtTotalPagar.getText().trim());

            // Verificar si el efectivo es suficiente
            if (efc < top) {
                JOptionPane.showMessageDialog(null, "El monto ingresado en efectivo no es suficiente");
                txtEfectivo.setBackground(Color.red);
                return;
            }

            // Calcular el cambio
            double cambio = efc - top;
            double cambi = Math.round(cambio * 100.0) / 100.0; // Redondear a 2 decimales
            txtCambio.setText(String.valueOf(cambi));
            txtEfectivo.setText(""); // Limpiar el campo de efectivo tras un cálculo exitoso

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar valores numéricos válidos en ambos campos");
            txtEfectivo.setBackground(Color.red);
            txtTotalPagar.setBackground(Color.red);
        }

    }//GEN-LAST:event_botonCalcularCambio1ActionPerformed

    private void txtCantidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseEntered
        txtCantidad.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtCantidadMouseEntered

    private void txtEfectivoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtEfectivoMouseEntered
        txtEfectivo.setBackground(Color.WHITE);
    }//GEN-LAST:event_txtEfectivoMouseEntered

    int idArrayList = 0;
    private void tablaProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosMouseClicked
        int filaPoint = tablaProductos.rowAtPoint(evt.getPoint());
        int columnaPoint = 0;
        if (filaPoint > -1) {
            idArrayList = (int) modeloDatosProductos.getValueAt(filaPoint, columnaPoint);
        }
        int opcion = JOptionPane.showConfirmDialog(null, "¿Eliminar Producto?");
        //opciones de confirmacion (si ==0)(no==1)(cancel==2)(close==-1)
        switch (opcion) {
            case 0: //presione si
                listaProducto.remove(idArrayList - 1);
                this.calcularTotalAPagar();
                this.listatablaProductos();
                break;
            case 1: //presiona no
                break;
            default:
                break;
        }

    }//GEN-LAST:event_tablaProductosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregarProducto;
    private javax.swing.JButton botonBuscarCliente1;
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
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCambio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtClienteBuscar;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtEfectivo;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtProductoBuscar;
    private javax.swing.JTextField txtSubTotal;
    public static javax.swing.JTextField txtTotalPagar;
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

    private boolean estaSeleccionadoCliente(String cliente) {
        boolean respuesta = false;
        if (cliente.equalsIgnoreCase("Seleccione Cliente:")) {
            JOptionPane.showMessageDialog(null, "debe seleccionar un Cliente");
        } else {
            respuesta = true;
        }
        return respuesta;
    }

    private boolean estaSeleccionadoProducto(String producto) {
        boolean respuesta = false;
        if (producto.equalsIgnoreCase("Seleccione Producto:")) {
            JOptionPane.showMessageDialog(null, "debe seleccionar un producto");
        } else {
            respuesta = true;
        }
        return respuesta;
    }

    private boolean tieneCantidad(String cantidad) {
        boolean respuesta = false;
        try {
            Integer.parseInt(cantidad.trim());
            respuesta = true;
            txtCantidad.setText("");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "debe ingresar la cantidad, solo caracteres numericos ");
            txtCantidad.setBackground(Color.red);
            txtCantidad.setText("");
        }
        return respuesta;
    }

    private boolean laCantidadEsMayorAcero(String cantidad) {
        boolean respuesta = false;

        try {
            int valor = Integer.parseInt(cantidad.trim());
            if (valor > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad ingresada debe ser mayor a cero");
                txtCantidad.setBackground(Color.red);
            }
        } catch (NumberFormatException e) {
            // Este catch es por si acaso alguien llama este método con un string inválido
            JOptionPane.showMessageDialog(null, "Cantidad no válida. No se puede verificar si es mayor a cero.");
            txtCantidad.setBackground(Color.red);
        }

        return respuesta;
    }

    private void datosDelProducto() {
        try {
            String sql = "SELECT * FROM tb_producto where nombre= '" + this.comboBoxProducto.getSelectedItem() + "';";
            Connection con = conexion.Conexion.conectar();
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idProducto = rs.getInt("idProducto");
                nombre = rs.getString("nombre");
                cantidadProductoBBD = rs.getInt("cantidad");
                precioUnitario = rs.getDouble("precio");
                porcentajeIva = rs.getInt("porcentajeIva");
                iva = this.calcularIva(precioUnitario, porcentajeIva);//

            }
        } catch (SQLException e) {
            System.out.println("ERROR AL obtener datos del producto");
        }
    }

    private double calcularIva(double precioUnitario, int porcentajeIva) {
        return (porcentajeIva == 0) ? 0.0 : ((double) porcentajeIva / 100) * precioUnitario;
    }

    //metodo para calcular total a pagar todos productos 
    private void calcularTotalAPagar() {
        double subTotalGeneral = 0.0;
        double descuentoGeneral = 0.0;
        double ivaGeneral = 0.0;
        double totalPagarGeneral = 0.0;

        for (DetalleVenta elemento : listaProducto) {
            subTotalGeneral += elemento.getSubTotal();
            descuentoGeneral += elemento.getDescuento();
            ivaGeneral += elemento.getIva();
            totalPagarGeneral += elemento.getTotalPagar();
        }
        //redondear desimales
        subTotalGeneral = (double) Math.round(subTotalGeneral * 100) / 100;
        descuentoGeneral = (double) Math.round(descuentoGeneral * 100) / 100;
        ivaGeneral = (double) Math.round(ivaGeneral * 100) / 100;
        totalPagarGeneral = (double) Math.round(totalPagarGeneral * 100) / 100;

        txtSubTotal.setText(String.valueOf(subTotalGeneral));
        txtDescuento.setText(String.valueOf(descuentoGeneral));
        txtIva.setText(String.valueOf(ivaGeneral));
        txtTotalPagar.setText(String.valueOf(totalPagarGeneral));
    }

    private boolean efecticoEsMayorAcero(String cantidad) {
        boolean respuesta = false;

        try {
            double valor = Double.parseDouble(cantidad.trim()); // Usar double en lugar de int para valores monetarios
            if (valor > 0) {
                respuesta = true;
            } else {
                JOptionPane.showMessageDialog(null, "El efectivo ingresado debe ser mayor a cero");
                txtEfectivo.setBackground(Color.red);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un valor numérico válido");
            txtEfectivo.setBackground(Color.red);
        }

        return respuesta;
    }

    private void obtenerIdCliente() {
        try {
            String sql = "SELECT * FROM tb_cliente where concat(nombre, ' ',apellido) = '" + this.comboBoxCliente.getSelectedItem() + "';";
            Connection con = conexion.Conexion.conectar();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                idCliente = rs.getInt("idCliente");
            }
        } catch (SQLException e) {
            System.out.println("error al obtener el ID del cliente" + e);
        }
    }

    private void restarStockProductos(int idProducto, int cantidad) {
        int cantidadProductoBaseDeDatos=0;
        try {
            Connection con = conexion.Conexion.conectar();
            String sql = "select idProducto, cantidad from tb_producto where idProducto= '" + idProducto + "';";
            Statement st;
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cantidadProductoBaseDeDatos = rs.getInt("cantidad");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("error al restar cantidad 1 " + e);
        }
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement consulta=con.prepareStatement("update tb_producto set cantidad= ? where idProducto = '"+idProducto+"';");
            int  cantidadNueva= cantidadProductoBaseDeDatos - cantidad;
            consulta.setInt(1, cantidadNueva);
            if (consulta.executeUpdate()>0){
                System.out.println("todoBien ");
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("error al restar cantidad 2 " + e);
        }

    }
}
