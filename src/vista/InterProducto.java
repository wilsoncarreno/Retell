package vista;

import controlador.ControladorProducto;
import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Producto;

public class InterProducto extends javax.swing.JInternalFrame {

    int obtenerIdcategoriaCombo = 0;

    public InterProducto() {
        initComponents();
        this.setSize(408, 448);
        this.setTitle("Nuevo Producto");
        this.CargarComboCategoria();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtCantidad = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nombre = new javax.swing.JLabel();
        cantidad = new javax.swing.JLabel();
        precio = new javax.swing.JLabel();
        descripcion = new javax.swing.JLabel();
        ivaa = new javax.swing.JLabel();
        categoria = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtPrecio = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        botonGuardar = new javax.swing.JButton();
        txtIva = new javax.swing.JTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 240, 254));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(221, 240, 254));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Agregar Nuevo Producto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setToolTipText("");
        jSeparator1.setAlignmentX(0.1F);
        jSeparator1.setAlignmentY(0.1F);
        jSeparator1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 229, 10));

        txtNombre.setBackground(new java.awt.Color(221, 240, 254));
        txtNombre.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(0, 0, 0));
        txtNombre.setBorder(null);
        txtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreMouseEntered(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 229, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setToolTipText("");
        jSeparator2.setAlignmentX(0.1F);
        jSeparator2.setAlignmentY(0.1F);
        jSeparator2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 229, 10));

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
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        jPanel1.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 229, -1));

        jPanel2.setBackground(new java.awt.Color(221, 240, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(221, 240, 254));
        nombre.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/etiquetaa.png"))); // NOI18N
        nombre.setText("Nombre: ");
        nombre.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 104, 30));

        cantidad.setBackground(new java.awt.Color(221, 240, 254));
        cantidad.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        cantidad.setForeground(new java.awt.Color(0, 0, 0));
        cantidad.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        cantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/productocantidadd.png"))); // NOI18N
        cantidad.setText("Cantidad: ");
        jPanel2.add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 100, 30));

        precio.setBackground(new java.awt.Color(221, 240, 254));
        precio.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        precio.setForeground(new java.awt.Color(0, 0, 0));
        precio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        precio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/precioo.png"))); // NOI18N
        precio.setText("Precio: ");
        jPanel2.add(precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 90, 50));

        descripcion.setBackground(new java.awt.Color(221, 240, 254));
        descripcion.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        descripcion.setForeground(new java.awt.Color(0, 0, 0));
        descripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        descripcion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/descripcionproducto.png"))); // NOI18N
        descripcion.setText("Descripcion: ");
        jPanel2.add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 120, 70));

        ivaa.setBackground(new java.awt.Color(221, 240, 254));
        ivaa.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        ivaa.setForeground(new java.awt.Color(0, 0, 0));
        ivaa.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ivaa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ivaicon.png"))); // NOI18N
        ivaa.setText("IVA: ");
        jPanel2.add(ivaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        categoria.setBackground(new java.awt.Color(221, 240, 254));
        categoria.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        categoria.setForeground(new java.awt.Color(0, 0, 0));
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        categoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoriasnueva...png"))); // NOI18N
        categoria.setText("Categoria: ");
        jPanel2.add(categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 120, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 340));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setToolTipText("");
        jSeparator3.setAlignmentX(0.1F);
        jSeparator3.setAlignmentY(0.1F);
        jSeparator3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 229, 10));

        txtPrecio.setBackground(new java.awt.Color(221, 240, 254));
        txtPrecio.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtPrecio.setForeground(new java.awt.Color(0, 0, 0));
        txtPrecio.setBorder(null);
        txtPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtPrecio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPrecioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtPrecioMouseEntered(evt);
            }
        });
        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        jPanel1.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 229, -1));

        txtDescripcion.setBackground(new java.awt.Color(221, 240, 254));
        txtDescripcion.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setBorder(null);
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });
        jPanel1.add(txtDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 229, -1));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setToolTipText("");
        jSeparator4.setAlignmentX(0.1F);
        jSeparator4.setAlignmentY(0.1F);
        jSeparator4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 229, 10));

        jComboBoxCategoria.setBackground(new java.awt.Color(221, 240, 254));
        jComboBoxCategoria.setForeground(new java.awt.Color(0, 0, 0));
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoria:", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 230, -1));

        botonGuardar.setBackground(new java.awt.Color(255, 255, 255));
        botonGuardar.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardaramarillo...png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        txtIva.setBackground(new java.awt.Color(221, 240, 254));
        txtIva.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        txtIva.setForeground(new java.awt.Color(0, 0, 0));
        txtIva.setBorder(null);
        txtIva.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIvaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtIvaMouseEntered(evt);
            }
        });
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        jPanel1.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 90, -1));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setToolTipText("");
        jSeparator5.setAlignmentX(0.1F);
        jSeparator5.setAlignmentY(0.1F);
        jSeparator5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 100, 10));

        jLabel3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("%");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        Producto producto = new Producto();
        ControladorProducto controlProducto = new ControladorProducto();
        String categoria = jComboBoxCategoria.getSelectedItem().toString().trim();
        int iva = 0;

        // Validación de campos existentes
        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del producto");
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

        // Validación mejorada: Verificar que se haya seleccionado una categoría válida
        if (categoria.equalsIgnoreCase("Seleccione Categoria:")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una categoría válida");
            jComboBoxCategoria.requestFocus();
            return;
        }

        // Obtener el idCategoria y validar que sea válido
        int idCategoria = IdCategoria();
        if (idCategoria == 0) {
            JOptionPane.showMessageDialog(null, "La categoría seleccionada no es válida. Seleccione una categoría diferente.");
            jComboBoxCategoria.requestFocus();
            return;
        }

        // Validar cantidad
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

        // Validar precio
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

        // Comprobar si el producto ya existe
        if (controlProducto.existeProducto(txtNombre.getText().trim())) {
            JOptionPane.showMessageDialog(null, "El producto ya existe en la base de datos");
            txtNombre.setBackground(Color.RED);
            txtNombre.requestFocus();
            return;
        }

        try {
            // Establecer detalles del producto
            producto.setNombre(txtNombre.getText().trim());
            producto.setCantidad(cantidad);
            producto.setPrecio(precio);
            producto.setDescripcion(txtDescripcion.getText().trim());
            producto.setPorcentajeIva(iva);
            producto.setIdCategoria(idCategoria);
            producto.setEstado(1);

            // Guardar producto
            if (controlProducto.guardar(producto)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                this.CargarComboCategoria();
                this.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el producto");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el producto: " + e.getMessage());
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void txtNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseClicked
        txtNombre.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtNombreMouseClicked

    private void txtCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseClicked
        txtCantidad.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtCantidadMouseClicked

    private void txtPrecioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseClicked
        txtPrecio.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtPrecioMouseClicked

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        txtNombre.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtCantidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCantidadMouseEntered
        txtCantidad.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtCantidadMouseEntered

    private void txtPrecioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPrecioMouseEntered
        txtPrecio.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtPrecioMouseEntered

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtIvaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIvaMouseEntered
        txtIva.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtIvaMouseEntered

    private void txtIvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIvaMouseClicked
        txtIva.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtIvaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel cantidad;
    private javax.swing.JLabel categoria;
    private javax.swing.JLabel descripcion;
    private javax.swing.JLabel ivaa;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel precio;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    // End of variables declaration//GEN-END:variables
    private void limpiar() {
        txtNombre.setText("");
        txtCantidad.setText("");
        txtPrecio.setText("");
        txtDescripcion.setText("");
        txtIva.setText("");

    }

    private void CargarComboCategoria() {
        Connection cn = conexion.Conexion.conectar();
        String sql = "select * from tb_categoria";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBoxCategoria.removeAllItems();
            jComboBoxCategoria.addItem("Seleccione Categoria");
            while (rs.next()) {
                jComboBoxCategoria.addItem(rs.getString("descripcion"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias" + e.getMessage());
        }
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
                obtenerIdcategoriaCombo = rs.getInt("idCategoria");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el idCategoria");
        }
        return obtenerIdcategoriaCombo;
    }

}
