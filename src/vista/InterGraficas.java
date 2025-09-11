
package vista;

import javax.swing.JTextField;

import static vista.FrmMenu.jDesktopPaneMenu;



public class InterGraficas extends javax.swing.JInternalFrame {
    
    public static String fecha_inicio="";
    public static String fecha_fin="";

    public InterGraficas() {
        initComponents();
        this.setSize(1086, 635);
        this.setTitle("Historial de Ventas");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        botonGraficarVentas = new javax.swing.JButton();
        jDateChooser_Fecha_Inicio = new com.toedter.calendar.JDateChooser();
        jDateChooser_fecha_final = new com.toedter.calendar.JDateChooser();

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario1.png"))); // NOI18N
        jLabel1.setText("Fecha Final: ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 50));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario1.png"))); // NOI18N
        jLabel2.setText("Fecha Inicio:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 50));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 230, 160));

        jLabel7.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/calendario1.png"))); // NOI18N
        jLabel7.setText("Seleccione Fechas Para Graficar");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 290, -1));

        botonGraficarVentas.setBackground(new java.awt.Color(255, 255, 255));
        botonGraficarVentas.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        botonGraficarVentas.setForeground(new java.awt.Color(0, 0, 0));
        botonGraficarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/barra_grafica.png"))); // NOI18N
        botonGraficarVentas.setText("Graficar Ventas");
        botonGraficarVentas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonGraficarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGraficarVentasActionPerformed(evt);
            }
        });
        jPanel1.add(botonGraficarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 170, 40));

        jDateChooser_Fecha_Inicio.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_Fecha_Inicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jDateChooser_Fecha_Inicio.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooser_Fecha_Inicio.setDateFormatString("yyyy-MM-dd");
        jDateChooser_Fecha_Inicio.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jPanel1.add(jDateChooser_Fecha_Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 170, 30));

        jDateChooser_fecha_final.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_fecha_final.setForeground(new java.awt.Color(0, 0, 0));
        jDateChooser_fecha_final.setDateFormatString("yyyy-MM-dd");
        jDateChooser_fecha_final.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jPanel1.add(jDateChooser_fecha_final, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 170, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGraficarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGraficarVentasActionPerformed
        fecha_inicio=((JTextField)jDateChooser_Fecha_Inicio.getDateEditor().getUiComponent()).getText();
        fecha_fin=((JTextField)jDateChooser_fecha_final.getDateEditor().getUiComponent()).getText();
        
        InterGraficarVentas interGraficarVentas=new InterGraficarVentas();
        jDesktopPaneMenu.add(interGraficarVentas);
        interGraficarVentas.setVisible(true);
        
        
        
    }//GEN-LAST:event_botonGraficarVentasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonGraficarVentas;
    private com.toedter.calendar.JDateChooser jDateChooser_Fecha_Inicio;
    private com.toedter.calendar.JDateChooser jDateChooser_fecha_final;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
   

}
