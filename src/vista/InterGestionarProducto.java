package vista;

import conexion.Conexion;
//import controlador.ControladorCategoria;
import controlador.ControladorProducto;
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
//import modelo.Categoria;
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int idProducto;
    private int obtenerIdCategoriaCombo = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(1155, 639));
        this.setTitle("Gestionar Productos");

        this.cargarTablaProducto();
        this.cargarComboCategoria();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        txtIva = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        label_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Administrar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableProductos.setBackground(new java.awt.Color(221, 240, 254));
        jTableProductos.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jTableProductos.setForeground(new java.awt.Color(0, 0, 0));
        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 400));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1120, 400));

        jPanel2.setBackground(new java.awt.Color(221, 240, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonActualizar.setBackground(new java.awt.Color(0, 153, 255));
        botonActualizar.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonActualizar.setForeground(new java.awt.Color(0, 0, 0));
        botonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/actualizarCategoria.png"))); // NOI18N
        botonActualizar.setText("Actualizar");
        botonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botonActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        botonEliminar.setBackground(new java.awt.Color(255, 153, 51));
        botonEliminar.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonEliminar.setForeground(new java.awt.Color(0, 0, 0));
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar..png"))); // NOI18N
        botonEliminar.setText("Eliminar");
        botonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonEliminar.setMaximumSize(new java.awt.Dimension(104, 224));
        botonEliminar.setMinimumSize(new java.awt.Dimension(104, 224));
        botonEliminar.setPreferredSize(new java.awt.Dimension(103, 23));
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(botonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 107, 28));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 480, 130, 100));

        jPanel3.setBackground(new java.awt.Color(221, 240, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/etiquetaa.png"))); // NOI18N
        jLabel2.setText("Nombre Producto: ");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 150, 30));

        txtNombre.setBackground(new java.awt.Color(221, 240, 254));
        txtNombre.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel3.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 170, 30));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 170, 10));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productocantidadd.png"))); // NOI18N
        jLabel3.setText("Cantidad: ");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 30));

        txtCantidad.setEditable(false);
        txtCantidad.setBackground(new java.awt.Color(221, 240, 254));
        txtCantidad.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(0, 0, 0));
        txtCantidad.setBorder(null);
        txtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCantidadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtCantidadMouseEntered(evt);
            }
        });
        jPanel3.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 180, 30));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 170, 10));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/precioo.png"))); // NOI18N
        jLabel4.setText("Precio: ");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 90, 30));

        txtPrecio.setBackground(new java.awt.Color(221, 240, 254));
        txtPrecio.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setBorder(null);
        txtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPrecioMouseEntered(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel3.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 200, 30));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 200, 10));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descripcionproducto.png"))); // NOI18N
        jLabel5.setText("Descripción: ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 120, 30));

        txtDescripcion.setBackground(new java.awt.Color(221, 240, 254));
        txtDescripcion.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setBorder(null);
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtDescripcionMouseEntered(evt);
            }
        });
        jPanel3.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 200, 30));
        jPanel3.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 200, 10));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ivaicon.png"))); // NOI18N
        jLabel6.setText("IVA: ");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, 70, 40));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoriasnueva...png"))); // NOI18N
        jLabel7.setText("Categoria: ");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, 110, 40));

        jComboBoxCategoria.setBackground(new java.awt.Color(221, 240, 254));
        jComboBoxCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria:", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 230, -1));

        txtIva.setBackground(new java.awt.Color(221, 240, 254));
        txtIva.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtIva.setForeground(new java.awt.Color(0, 0, 0));
        txtIva.setBorder(null);
        txtIva.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIvaMouseEntered(evt);
            }
        });
        jPanel3.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 50, 30));
        jPanel3.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 80, 10));

        jLabel8.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("%");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, 30, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 1010, 140));

        label_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondodefinitivoazulclaro.jpg"))); // NOI18N
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1160, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        Producto producto = new Producto();
        ControladorProducto controlProducto = new ControladorProducto();
        String categoria = jComboBoxCategoria.getSelectedItem().toString().trim();
        int iva = 0;

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete el campo:nombre del producto");
            txtNombre.setBackground(Color.RED);
            txtNombre.requestFocus();
            return;
        }

        if (txtCantidad.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar la cantidad del producto");
            txtCantidad.setBackground(Color.RED);
            txtCantidad.requestFocus();
            return;
        }

        if (txtPrecio.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el precio del producto");
            txtPrecio.setBackground(Color.RED);
            txtPrecio.requestFocus();
            return;
        }
        if (txtIva.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el valor del IVA del producto");
            txtIva.setBackground(Color.RED);
            txtIva.requestFocus();
            return;
        } else {
            try {
                iva = Integer.parseInt(txtIva.getText().trim());
                if (iva < 0) {
                    JOptionPane.showInternalMessageDialog(null, "El valor del IVA no puede ser menor a ¡¡¡CERO!!! (0)");
                    txtIva.setBackground(Color.RED);
                    txtIva.requestFocus();
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El valor del IVA debe ser un número entero");
                txtIva.setBackground(Color.RED);
                txtIva.requestFocus();
                return;
            }
        }

        if (categoria.equalsIgnoreCase("Seleccione Categoria:")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una categoría");
            jComboBoxCategoria.requestFocus();
            return;
        }

        // validar si la cantidad es numerica 
        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText().trim());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número positivo");
                txtCantidad.setBackground(Color.RED);
                txtCantidad.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un número válido sin letras");
            txtCantidad.setBackground(Color.RED);
            txtCantidad.requestFocus();
            return;
        }

        // validar si el precio es numerico
        double precio;
        try {
            String precioTxt = txtPrecio.getText().trim().replace(",", ".");
            precio = Double.parseDouble(precioTxt);
            if (precio <= 0) {
                JOptionPane.showMessageDialog(null, "El precio debe ser un número positivo");
                txtPrecio.setBackground(Color.RED);
                txtPrecio.requestFocus();
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un número válido sin letras");
            txtPrecio.setBackground(Color.RED);
            txtPrecio.requestFocus();
            return;
        }

        
        try {
            // Establecer detalles del producto
            producto.setNombre(txtNombre.getText().trim());
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setDescripcion(txtDescripcion.getText().trim());
            producto.setPorcentajeIva(iva);
            // estableser idCategoria
            this.IdCategoria();
            producto.setIdCategoria(obtenerIdCategoriaCombo);
            producto.setEstado(1);

            //Guardar Producto
            if (controlProducto.actualizar(producto, idProducto)) {
                JOptionPane.showMessageDialog(null, "Registro actualizado");
                //jComboBoxIva.setSelectedItem("Seleccione IVA:");
                this.cargarTablaProducto();
                jComboBoxCategoria.setSelectedItem("Seleccione Categoria");
                this.Limpiar();
                idProducto=0;
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el producto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el producto: " + e.getMessage());
        }

    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        ControladorProducto controlProducto = new ControladorProducto();
        if (idProducto == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un Producto");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar el producto?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (controlProducto.eliminar(idProducto)) {
                    JOptionPane.showMessageDialog(null, "Producto Eliminado");
                    this.cargarTablaProducto();
                    this.cargarComboCategoria();
                    this.Limpiar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error al Eliminar el Producto");
                }
            }
        }


    }//GEN-LAST:event_botonEliminarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        JOptionPane.showMessageDialog(null, "La cantidad no se puede modificar, dirijase a  Producto -> Actualizar Stock");
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        txtNombre.setBackground(new Color(221, 240, 254));

    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtCantidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseEntered
        txtCantidad.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtCantidadMouseEntered

    private void txtPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseEntered
        txtPrecio.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtPrecioMouseEntered

    private void txtDescripcionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtDescripcionMouseEntered
        txtDescripcion.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtDescripcionMouseEntered

    private void txtIvaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIvaMouseEntered
        txtIva.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtIvaMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    public static javax.swing.JTable jTableProductos;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    //metodos para cargar  todas las categorias en el jcombobox
    private void cargarComboCategoria() {
        Connection cn = conexion.Conexion.conectar();
        String sql = "select * from tb_categoria; ";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBoxCategoria.removeAllItems();
            jComboBoxCategoria.addItem("Seleccione Categoria:");
            while (rs.next()) {
                jComboBoxCategoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar productos " + e.getMessage());
        }

    }

    // metodo para mostar todos los productos
    String descripcionCategoria;
    double precio = 0.0;
    int porcentajeIva = 0;
    double IVA = 0;

    private void cargarTablaProducto() {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        // Obtener el modelo existente de la tabla
        DefaultTableModel model = (DefaultTableModel) InterGestionarProducto.jTableProductos.getModel();

        // Limpiar filas y columnas existentes
        model.setRowCount(0);
        model.setColumnCount(0);

        // Definir las columnas
        model.addColumn("N°"); // idProducto
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        model.addColumn("Precio");
        model.addColumn("Descripción");
        model.addColumn("IVA");
        model.addColumn("Categoría");
        model.addColumn("Estado");

        String sql = "SELECT p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion AS categoria, p.estado "
                + "FROM tb_producto AS p "
                + "INNER JOIN tb_categoria AS c ON p.idCategoria = c.idCategoria";

        try {
            con = Conexion.conectar();
            if (con == null) {
                JOptionPane.showMessageDialog(null, "Error: No se pudo conectar a la base de datos");
                return;
            }

            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                double precio = rs.getDouble("precio");
                int porcentajeIva = rs.getInt("porcentajeIva");
                double iva = calcularIva(precio, porcentajeIva);

                Object[] fila = new Object[8];
                fila[0] = rs.getInt("idProducto");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getInt("cantidad");
                fila[3] = String.format("%.2f", rs.getDouble("precio")); // Formatear precio
                fila[4] = rs.getString("descripcion");
                fila[5] = String.format("%.2f", iva); // Formatear IVA
                fila[6] = rs.getString("categoria");
                fila[7] = rs.getBoolean("estado") ? "Activo" : "Inactivo"; // Convertir estado

                model.addRow(fila);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al llenar la tabla de productos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                System.err.println("Error al cerrar los recursos: " + e.getMessage());
            }
        }

        // Listener para clics en la tabla
        InterGestionarProducto.jTableProductos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int filaPoint = InterGestionarProducto.jTableProductos.rowAtPoint(e.getPoint());
                if (filaPoint > -1) {
                    idProducto = (int) model.getValueAt(filaPoint, 0);
                    EnviarDatosProductoSeleccionado(idProducto);
                }
            }
        });
//        Connection con = Conexion.conectar();
//        DefaultTableModel model = new DefaultTableModel();
//        String sql = "select p.idProducto, p.nombre, p.cantidad, p.precio, p.descripcion, p.porcentajeIva, c.descripcion, p.estado from tb_producto As p, tb_categoria As c where p.idCategoria=c.idCategoria;";
//        Statement st;
//        try {
//
//            st = con.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//            InterGestionarProducto.jTableProductos = new JTable(model);
//            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTableProductos);
//
//            model.addColumn("N°");//idProducto
//            model.addColumn("Nombre");
//            model.addColumn("Cantidad");
//            model.addColumn("Precio");
//            model.addColumn("Descripcion");
//            model.addColumn("IVA");
//            model.addColumn("Categoria");
//            model.addColumn("estado");
//
//            while (rs.next()) {
//
//                precio = rs.getDouble("precio");
//                porcentajeIva = rs.getInt("porcentajeIva");
//
//                Object fila[] = new Object[8];
//                for (int i = 0; i < 8; i++) {
//                    if (i == 5) {
//                        this.calcularIva(precio, porcentajeIva);
//                        fila[i] = IVA;
//                        rs.getObject(i + 1);
//                    } else {
//                        fila[i] = rs.getObject(i + 1);
//                    }
//
//                }
//                model.addRow(fila);
//
//            }
//            con.close();
//
//        } catch (SQLException e) {
//            System.out.println("Error al Llenar la Tabla Productos");
//
//        }
//        InterGestionarProducto.jTableProductos.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                int filaPoint = InterGestionarProducto.jTableProductos.rowAtPoint(e.getPoint());
//                int columnaPoint = 0;
//                if (filaPoint > -1) {
//                    idProducto = (int) model.getValueAt(filaPoint, columnaPoint);
//                    EnviarDatosProductoSeleccionado(idProducto);
//                }
//
//            }
//        });

    }
    //metodo para calcular iva 

    private double calcularIva(double precio, int iva) {
        double p_iva = iva; // conversión implícita de int a double
        IVA = (precio * p_iva) / 100;
        IVA = Math.round(IVA * 100.0) / 100.0; // redondear a 2 decimales
        return IVA;
    }

    //metodo que envia los datos seleccionados
    public void EnviarDatosProductoSeleccionado(int idProducto) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where idProducto= '" + idProducto + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txtNombre.setText(rs.getString("nombre"));
                txtCantidad.setText(rs.getString("cantidad"));
                txtPrecio.setText(rs.getString("precio"));
                txtDescripcion.setText(rs.getString("descripcion"));
                txtIva.setText(rs.getString("porcentajeIva"));
//                switch (iva) {
//                    case 0:
//                        jComboBoxIva.setSelectedItem("No Grava IVA");
//                        break;
//                    case 19:
//                        jComboBoxIva.setSelectedItem("19%");
//                        break;
//                    default:
//                        jComboBoxIva.setSelectedItem("Seleccione IVA:");
//                        break;
//                }
                int idCate = rs.getInt("idCategoria");
                jComboBoxCategoria.setSelectedItem(relacionarCategoria(idCate));

            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto" + e.getMessage());
        }
    }

    //metodo para relacionar categorias.
    private String relacionarCategoria(int idCategoria) {

        String sql = "select descripcion from tb_categoria where idCategoria='" + idCategoria + "';";
        Statement st;
        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                descripcionCategoria = rs.getString("descripcion");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener el id de la categoria " + e.getMessage());
        }
        return descripcionCategoria;
    }

//metodo para limpiar producto
    private void Limpiar() {
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        txtIva.setText("");
        jComboBoxCategoria.setSelectedItem("Seleccione Categoria:");

    }

    /*
    metodo para obtener el  idctegoria
     */
    private int IdCategoria() {
        String sql = "select * from tb_categoria where descripcion ='" + this.jComboBoxCategoria.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = conexion.Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIdCategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el idCategoria");
        }
        return obtenerIdCategoriaCombo;
    }

}
