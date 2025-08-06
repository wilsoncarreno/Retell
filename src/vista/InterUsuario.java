
package vista;

import controlador.ControladorCliente;
import controlador.ControladorProducto;
import controlador.ControladorUsuario;
import java.awt.Color;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Usuario;

public class InterUsuario extends javax.swing.JInternalFrame {

    Usuario usuario=new Usuario();
    ControladorUsuario controladorUsuario= new ControladorUsuario();
    
    public InterUsuario() {
        initComponents();
        this.setSize(420, 535);
        this.setTitle("Agregar Usuario");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        txtApellido = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtUsuario = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        txtTelefono = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        botonGuardar = new javax.swing.JButton();
        txtContrasena = new javax.swing.JPasswordField();

        jLabel6.setText("jLabel6");

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(221, 240, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(221, 240, 254));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombreetiqueta.png"))); // NOI18N
        jLabel1.setText("Apellido: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 110, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nombreetiqueta.png"))); // NOI18N
        jLabel2.setText("Nombre: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 100, 50));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevoe.png"))); // NOI18N
        jLabel3.setText("Usuario: ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 100, 50));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/seguropassword.png"))); // NOI18N
        jLabel5.setText("Contraseña: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 210, 140, 50));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/directorio-telefonico (1).png"))); // NOI18N
        jLabel4.setText("Telefono: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 110, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 330));

        jLabel7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevoe.png"))); // NOI18N
        jLabel7.setText("Nuevo Cliente ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 150, -1));

        txtNombre.setBackground(new java.awt.Color(221, 240, 254));
        txtNombre.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
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
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 230, 30));

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 230, 10));

        txtApellido.setBackground(new java.awt.Color(221, 240, 254));
        txtApellido.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(0, 0, 0));
        txtApellido.setBorder(null);
        txtApellido.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtApellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtApellidoMouseEntered(evt);
            }
        });
        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 230, 30));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 230, 10));

        txtUsuario.setBackground(new java.awt.Color(221, 240, 254));
        txtUsuario.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        txtUsuario.setBorder(null);
        txtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtUsuarioMouseEntered(evt);
            }
        });
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 230, 30));

        jSeparator3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 230, 10));

        txtTelefono.setBackground(new java.awt.Color(221, 240, 254));
        txtTelefono.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        txtTelefono.setBorder(null);
        txtTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTelefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtTelefonoMouseEntered(evt);
            }
        });
        txtTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, 230, 30));

        jSeparator4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 230, 10));

        jSeparator5.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 230, 10));

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
        jPanel1.add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, -1, -1));

        txtContrasena.setBackground(new java.awt.Color(221, 240, 254));
        txtContrasena.setForeground(new java.awt.Color(0, 0, 0));
        txtContrasena.setBorder(null);
        txtContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContrasenaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 230, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        if (txtNombre.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el Nombre del Usuario");
            txtNombre.setBackground(Color.red);
            txtNombre.requestFocus();
            return;
        }
        if (txtApellido.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el Apellido del Usurio");
            txtApellido.setBackground(Color.red);
            txtApellido.requestFocus();
            return;
        }
        if (txtUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el nombre de usuario");
            txtUsuario.setBackground(Color.red);
            txtUsuario.requestFocus();
            return;
        }
        if (txtContrasena.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar una contrasena para el usuario");
            txtContrasena.setBackground(Color.red);
            txtContrasena.requestFocus();
            return;
        }
        if (txtTelefono.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe Ingresar el numero de telefono");
            txtTelefono.setBackground(Color.red);
            txtTelefono.requestFocus();
            return;
        }
        
        //validar si el cliente existe 
        if (controladorUsuario.ExisteUsuario(txtUsuario.getText().trim())) {
            JOptionPane.showMessageDialog(null, "El Usuario ya existe en la base de datos ingrese otro usuario");
            txtUsuario.setBackground(Color.RED);
            txtUsuario.requestFocus();
            return;
        }

        try {
            usuario.setNombre(txtNombre.getText().trim());
            usuario.setApellido(txtApellido.getText().trim());
            usuario.setUsuario(txtUsuario.getText().trim());
            usuario.setTelefono(txtTelefono.getText().trim());
            usuario.setPassword(txtContrasena.getText().trim());
            usuario.setEstado(1);
            //Guardar Producto
            if (controladorUsuario.Guardar(usuario)) {
                JOptionPane.showMessageDialog(null, "Usuario Guardado");
                this.limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al guardar el Usuario");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrió un error al guardar el Usuario: " + e.getMessage());
        }


    }//GEN-LAST:event_botonGuardarActionPerformed

    private void txtNombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreMouseEntered
        txtNombre.setBackground(new Color(221, 240, 254));     // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreMouseEntered

    private void txtApellidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtApellidoMouseEntered
        txtApellido.setBackground(new Color(221, 240, 254));         // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoMouseEntered

    private void txtUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtUsuarioMouseEntered
        txtUsuario.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtUsuarioMouseEntered

    private void txtTelefonoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTelefonoMouseEntered
        txtTelefono.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtTelefonoMouseEntered

    private void txtContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContrasenaActionPerformed
        txtUsuario.setBackground(new Color(221, 240, 254));
    }//GEN-LAST:event_txtContrasenaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
    private void limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtUsuario.setText("");
        txtTelefono.setText("");
        
        
    }

}
