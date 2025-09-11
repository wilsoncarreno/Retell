/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Reportes;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import java.sql.Connection;

public class FrmMenu extends javax.swing.JFrame  {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FrmMenu.class.getName());

    public static JDesktopPane jDesktopPaneMenu;

    public FrmMenu() {
        initComponents();
        this.setSize(new Dimension(1200, 700));
        this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setTitle(" Menu Retell");

        this.setLayout(null);
        jDesktopPaneMenu = new JDesktopPane();
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        this.jDesktopPaneMenu.setBounds(0, 0, ancho, (alto - 110));
        this.add(jDesktopPaneMenu);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuNuevoUsuario = new javax.swing.JMenuItem();
        menuGestionarUsuarios = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        menuNuevaReparacion = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuNuevoProducto = new javax.swing.JMenuItem();
        menuGestionarProductos = new javax.swing.JMenuItem();
        menuActualizarStock = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuNuevoCliente = new javax.swing.JMenuItem();
        menuGestionarClientes = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuNuevaCategoria = new javax.swing.JMenuItem();
        menuGestionCategoria = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuNuevaVenta = new javax.swing.JMenuItem();
        menuGestionVentas = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuReporteClientes = new javax.swing.JMenuItem();
        menuReporteCategorias = new javax.swing.JMenuItem();
        menuReporteProductos = new javax.swing.JMenuItem();
        menuReporteVentas = new javax.swing.JMenuItem();
        jMenu9 = new javax.swing.JMenu();
        menuVerHistorial = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenu();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem1.setText("jMenuItem1");

        jMenuItem5.setText("jMenuItem5");

        jMenuItem8.setText("jMenuItem8");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jMenu1.setBorder(null);
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/libroDeUsuario...png"))); // NOI18N
        jMenu1.setText("Usuario");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevoUsuario.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar-usuario...png"))); // NOI18N
        menuNuevoUsuario.setText("Nuevo Usuario");
        menuNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menuNuevoUsuario);

        menuGestionarUsuarios.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuGestionarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/la-configuracion-de-privacidad...png"))); // NOI18N
        menuGestionarUsuarios.setText("Gestionar Usuarios");
        menuGestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionarUsuariosActionPerformed(evt);
            }
        });
        jMenu1.add(menuGestionarUsuarios);

        jMenuBar1.add(jMenu1);

        jMenu8.setBorder(null);
        jMenu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/neumaticopinchado...png"))); // NOI18N
        jMenu8.setText("Reparacion");
        jMenu8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu8.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu8.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevaReparacion.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevaReparacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/parches...png"))); // NOI18N
        menuNuevaReparacion.setText("Nueva Reparación");
        menuNuevaReparacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevaReparacionActionPerformed(evt);
            }
        });
        jMenu8.add(menuNuevaReparacion);

        jMenuItem7.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jMenuItem7.setText("Gestionar Reparaciones");
        jMenu8.add(jMenuItem7);

        jMenuBar1.add(jMenu8);

        jMenu2.setBorder(null);
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cadenadesuministro.png"))); // NOI18N
        jMenu2.setText("Producto");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevoProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevoProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo-producto...png"))); // NOI18N
        menuNuevoProducto.setText("Nuevo Producto");
        menuNuevoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoProductoActionPerformed(evt);
            }
        });
        jMenu2.add(menuNuevoProducto);

        menuGestionarProductos.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuGestionarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/la-gestion-del-inventario...png"))); // NOI18N
        menuGestionarProductos.setText("Gestionar Productos");
        menuGestionarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionarProductosActionPerformed(evt);
            }
        });
        jMenu2.add(menuGestionarProductos);

        menuActualizarStock.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuActualizarStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/stock.png"))); // NOI18N
        menuActualizarStock.setText("Actualizar Stock");
        menuActualizarStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActualizarStockActionPerformed(evt);
            }
        });
        jMenu2.add(menuActualizarStock);

        jMenuBar1.add(jMenu2);

        jMenu3.setBorder(null);
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cliente...png"))); // NOI18N
        jMenu3.setText("Cliente");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevoCliente.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevoCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevoCliente.png"))); // NOI18N
        menuNuevoCliente.setText("Nuevo Cliente");
        menuNuevoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevoClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuNuevoCliente);

        menuGestionarClientes.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuGestionarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestioncliente.png"))); // NOI18N
        menuGestionarClientes.setText("Gestionar Clientes");
        menuGestionarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionarClientesActionPerformed(evt);
            }
        });
        jMenu3.add(menuGestionarClientes);

        jMenuBar1.add(jMenu3);

        jMenu4.setBorder(null);
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categorias...png"))); // NOI18N
        jMenu4.setText("Categoria");
        jMenu4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu4.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevaCategoria.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevaCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/categoriasnueva...png"))); // NOI18N
        menuNuevaCategoria.setText("Nueva Categoria");
        menuNuevaCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevaCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(menuNuevaCategoria);

        menuGestionCategoria.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuGestionCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestioncategoria...png"))); // NOI18N
        menuGestionCategoria.setText("Gestionar Categoria");
        menuGestionCategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuGestionCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionCategoriaActionPerformed(evt);
            }
        });
        jMenu4.add(menuGestionCategoria);

        jMenuBar1.add(jMenu4);

        jMenu6.setBorder(null);
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bancaelectronica...png"))); // NOI18N
        jMenu6.setText("Facturar");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu6.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 50));

        menuNuevaVenta.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevaventa.png"))); // NOI18N
        menuNuevaVenta.setText("Nueva Venta");
        menuNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNuevaVentaActionPerformed(evt);
            }
        });
        jMenu6.add(menuNuevaVenta);

        menuGestionVentas.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuGestionVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gestionarventa...png"))); // NOI18N
        menuGestionVentas.setText("Gestionar Ventas");
        menuGestionVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGestionVentasActionPerformed(evt);
            }
        });
        jMenu6.add(menuGestionVentas);

        jMenuBar1.add(jMenu6);

        jMenu7.setBorder(null);
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analisisdedatos...png"))); // NOI18N
        jMenu7.setText("Reportes");
        jMenu7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 50));

        menuReporteClientes.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuReporteClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporteCliente...png"))); // NOI18N
        menuReporteClientes.setText("Reportes Clientes");
        menuReporteClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteClientesActionPerformed(evt);
            }
        });
        jMenu7.add(menuReporteClientes);

        menuReporteCategorias.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuReporteCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reportecategorias...png"))); // NOI18N
        menuReporteCategorias.setText("Reportes Categorias");
        menuReporteCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteCategoriasActionPerformed(evt);
            }
        });
        jMenu7.add(menuReporteCategorias);

        menuReporteProductos.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuReporteProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporteProducto...png"))); // NOI18N
        menuReporteProductos.setText("Reportes Productos");
        menuReporteProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteProductosActionPerformed(evt);
            }
        });
        jMenu7.add(menuReporteProductos);

        menuReporteVentas.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuReporteVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reporteVenta...png"))); // NOI18N
        menuReporteVentas.setText("Reportes Ventas");
        menuReporteVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReporteVentasActionPerformed(evt);
            }
        });
        jMenu7.add(menuReporteVentas);

        jMenuBar1.add(jMenu7);

        jMenu9.setBorder(null);
        jMenu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historialdetransacciones...png"))); // NOI18N
        jMenu9.setText("Historial");
        jMenu9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu9.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        jMenu9.setPreferredSize(new java.awt.Dimension(150, 50));

        menuVerHistorial.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        menuVerHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/historialhistorial...png"))); // NOI18N
        menuVerHistorial.setText("Ver Historial");
        menuVerHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVerHistorialActionPerformed(evt);
            }
        });
        jMenu9.add(menuVerHistorial);

        jMenuBar1.add(jMenu9);

        menuCerrarSesion.setBorder(null);
        menuCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salida...png"))); // NOI18N
        menuCerrarSesion.setText("Cerrar Sesión");
        menuCerrarSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menuCerrarSesion.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 16)); // NOI18N
        menuCerrarSesion.setPreferredSize(new java.awt.Dimension(150, 50));
        jMenuBar1.add(menuCerrarSesion);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuNuevoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoProductoActionPerformed
        InterProducto interProducto = new InterProducto();
        jDesktopPaneMenu.add(interProducto);
        interProducto.setVisible(true);
    }//GEN-LAST:event_menuNuevoProductoActionPerformed

    private void menuGestionarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionarProductosActionPerformed
        InterGestionarProducto interGestionarProducto = new InterGestionarProducto();
        jDesktopPaneMenu.add(interGestionarProducto);
        interGestionarProducto.setVisible(true);
    }//GEN-LAST:event_menuGestionarProductosActionPerformed

    private void menuNuevoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoClienteActionPerformed
        InterCliente interCliente = new InterCliente();
        jDesktopPaneMenu.add(interCliente);
        interCliente.setVisible(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_menuNuevoClienteActionPerformed

    private void menuGestionarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionarClientesActionPerformed
        InterGestionarClientes interGestionarClientes = new InterGestionarClientes();
        jDesktopPaneMenu.add(interGestionarClientes);
        interGestionarClientes.setVisible(true);

    }//GEN-LAST:event_menuGestionarClientesActionPerformed

    private void menuNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevaCategoriaActionPerformed
        InterCategoria interCategoria = new InterCategoria();
        jDesktopPaneMenu.add(interCategoria);
        interCategoria.setVisible(true);
    }//GEN-LAST:event_menuNuevaCategoriaActionPerformed

    private void menuGestionCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionCategoriaActionPerformed
        InterGestionarCategorias interGestionarCategoria = new InterGestionarCategorias();
        jDesktopPaneMenu.add(interGestionarCategoria);
        interGestionarCategoria.setVisible(true);

    }//GEN-LAST:event_menuGestionCategoriaActionPerformed

    private void menuReporteProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteProductosActionPerformed
        Reportes reportes = new Reportes();
        reportes.reportesProductos();
    }//GEN-LAST:event_menuReporteProductosActionPerformed

    private void menuGestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionarUsuariosActionPerformed
        InterGestionarUsuario interGestionarUsuario = new InterGestionarUsuario();
        jDesktopPaneMenu.add(interGestionarUsuario);
        interGestionarUsuario.setVisible(true);
    }//GEN-LAST:event_menuGestionarUsuariosActionPerformed

    private void menuActualizarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActualizarStockActionPerformed
        InterActualizarStock interActuaizarStock = new InterActualizarStock();
        jDesktopPaneMenu.add(interActuaizarStock);
        interActuaizarStock.setVisible(true);
    }//GEN-LAST:event_menuActualizarStockActionPerformed

    private void menuNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevoUsuarioActionPerformed
        InterUsuario interUsuario = new InterUsuario();
        jDesktopPaneMenu.add(interUsuario);
        interUsuario.setVisible(true);
    }//GEN-LAST:event_menuNuevoUsuarioActionPerformed

    private void menuNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevaVentaActionPerformed
        InterFacturacion interFacturacion = new InterFacturacion();
        jDesktopPaneMenu.add(interFacturacion);
        interFacturacion.setVisible(true);
    }//GEN-LAST:event_menuNuevaVentaActionPerformed

    private void menuGestionVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGestionVentasActionPerformed
        InterGestionarVentas interGestionarVenta = new InterGestionarVentas();
        jDesktopPaneMenu.add(interGestionarVenta);
        interGestionarVenta.setVisible(true);
    }//GEN-LAST:event_menuGestionVentasActionPerformed

    private void menuReporteClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteClientesActionPerformed
        Reportes reportes = new Reportes();
        reportes.reportesClientes();


    }//GEN-LAST:event_menuReporteClientesActionPerformed

    private void menuReporteCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteCategoriasActionPerformed
        Reportes reporte = new Reportes();
        reporte.reportesCategorias();
    }//GEN-LAST:event_menuReporteCategoriasActionPerformed

    private void menuReporteVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReporteVentasActionPerformed
        Reportes reporte = new Reportes();
        reporte.reportesVentas();
    }//GEN-LAST:event_menuReporteVentasActionPerformed

    private void menuVerHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVerHistorialActionPerformed
        InterGraficas interGraficas = new InterGraficas();
        jDesktopPaneMenu.add(interGraficas);
        interGraficas.setVisible(true);
    }//GEN-LAST:event_menuVerHistorialActionPerformed

    private void menuNuevaReparacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNuevaReparacionActionPerformed
        InterReparacion interReparacion = new InterReparacion();
        jDesktopPaneMenu.add(interReparacion);
        interReparacion.setVisible(true);
    }//GEN-LAST:event_menuNuevaReparacionActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmMenu().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem menuActualizarStock;
    private javax.swing.JMenu menuCerrarSesion;
    private javax.swing.JMenuItem menuGestionCategoria;
    private javax.swing.JMenuItem menuGestionVentas;
    private javax.swing.JMenuItem menuGestionarClientes;
    private javax.swing.JMenuItem menuGestionarProductos;
    private javax.swing.JMenuItem menuGestionarUsuarios;
    private javax.swing.JMenuItem menuNuevaCategoria;
    private javax.swing.JMenuItem menuNuevaReparacion;
    private javax.swing.JMenuItem menuNuevaVenta;
    private javax.swing.JMenuItem menuNuevoCliente;
    private javax.swing.JMenuItem menuNuevoProducto;
    private javax.swing.JMenuItem menuNuevoUsuario;
    private javax.swing.JMenuItem menuReporteCategorias;
    private javax.swing.JMenuItem menuReporteClientes;
    private javax.swing.JMenuItem menuReporteProductos;
    private javax.swing.JMenuItem menuReporteVentas;
    private javax.swing.JMenuItem menuVerHistorial;
    // End of variables declaration//GEN-END:variables

}
