package vista;

import controlador.ControladorCategoria;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.Categoria;

public class InterCategoria extends javax.swing.JInternalFrame {

    public InterCategoria() {
        initComponents();
        this.setSize(new Dimension(400, 200));
        this.setTitle("Nueva Categoria");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        label_walpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nueva Categoria");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre Categoria:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        txtNombreCategoria.setBackground(new java.awt.Color(221, 240, 254));
        txtNombreCategoria.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        txtNombreCategoria.setForeground(new java.awt.Color(0, 0, 0));
        txtNombreCategoria.setBorder(null);
        txtNombreCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                txtNombreCategoriaMouseEntered(evt);
            }
        });
        txtNombreCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreCategoriaActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombreCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 220, 30));

        botonGuardar.setBackground(new java.awt.Color(102, 204, 255));
        botonGuardar.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonGuardar.setForeground(new java.awt.Color(0, 0, 0));
        botonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar-datos.png"))); // NOI18N
        botonGuardar.setText("Guardar");
        botonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonGuardarMouseEntered(evt);
            }
        });
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 110, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 220, 20));

        label_walpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondodefinitivoazulclaro.jpg"))); // NOI18N
        getContentPane().add(label_walpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 390, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreCategoriaActionPerformed
        botonGuardar.doClick();

    }//GEN-LAST:event_txtNombreCategoriaActionPerformed

    private void txtNombreCategoriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNombreCategoriaMouseEntered
//        txtNombreCategoria.setBackground(new Color(8,22,103));        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreCategoriaMouseEntered

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed

        Categoria categoria = new Categoria();
        ControladorCategoria controlCategoria = new ControladorCategoria();

        //validamos campos vasios
        if (txtNombreCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el Nombre de la Categoria");
        } else {

            if (!controlCategoria.existeCategoria(txtNombreCategoria.getText().trim())) {

                categoria.setDescripcion(txtNombreCategoria.getText().trim());
                categoria.setEstado(1);
                if (controlCategoria.guardar(categoria)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado exitosamente ");
                } else {
                    JOptionPane.showMessageDialog(null, "¡¡¡¡ERROR AL GUARDAR EL REGISTRO!!!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La Categoria ya Existe en la Base de Datos");
            }
        }
        txtNombreCategoria.setText("");
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void botonGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonGuardarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_botonGuardarMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_walpaper;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
