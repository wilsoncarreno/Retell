
package vista;

import conexion.Conexion;
import controlador.ControladorCategoria;
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
import modelo.Categoria;
import modelo.Producto;

public class InterGestionarCategorias extends javax.swing.JInternalFrame {
    
    private int idCategoria;

    public InterGestionarCategorias() {
        initComponents();
        this.setSize(new Dimension(600,400));
        this.setTitle("Gestionar Categorias");
        
        this.cargarTablaCategorias();
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botonActualizar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        label_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Administrar Categorias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableCategorias.setBackground(new java.awt.Color(221, 240, 254));
        jTableCategorias.setFont(new java.awt.Font("Roboto Condensed", 0, 14)); // NOI18N
        jTableCategorias.setForeground(new java.awt.Color(0, 0, 0));
        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableCategorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

        jPanel2.setBackground(new java.awt.Color(221, 240, 254));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(botonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 130, 70));

        jPanel3.setBackground(new java.awt.Color(221, 240, 254));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre Categoria: ");

        txtDescripcion.setBackground(new java.awt.Color(221, 240, 254));
        txtDescripcion.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        txtDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        txtDescripcion.setBorder(null);
        txtDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 86, Short.MAX_VALUE))
                    .addComponent(txtDescripcion))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 210, 100));

        label_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondodefinitivoazulclaro.jpg"))); // NOI18N
        getContentPane().add(label_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonActualizarActionPerformed
        if(!txtDescripcion.getText().isEmpty()){
            Categoria categoria=new Categoria();
            ControladorCategoria controlCategoria= new ControladorCategoria();
            categoria.setDescripcion(txtDescripcion.getText().trim());
            if (controlCategoria.actualizar(categoria, idCategoria)){
                JOptionPane.showMessageDialog(null, "Categoria Actualizada");
                txtDescripcion.setText("");
                this.cargarTablaCategorias();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Actualizada");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione Una Categoria");
        }


        
    }//GEN-LAST:event_botonActualizarActionPerformed

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
       if(!txtDescripcion.getText().isEmpty()){
            Categoria categoria=new Categoria();
            ControladorCategoria controlCategoria= new ControladorCategoria();
            categoria.setDescripcion(txtDescripcion.getText().trim());
            if (controlCategoria.eliminar( idCategoria)){
                JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                txtDescripcion.setText("");
                this.cargarTablaCategorias();
            }else{
                JOptionPane.showMessageDialog(null, "Error al Eliminar Categoria");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Seleccione Una Categoria");
        }
        
        
    }//GEN-LAST:event_botonEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonActualizar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JTable jTableCategorias;
    private javax.swing.JLabel label_wallpaper;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
    //metodos para mostrar todas las categorias 
    private void cargarTablaCategorias(){
        Connection con =Conexion.conectar();
        DefaultTableModel model=new DefaultTableModel();
        String sql="select idCategoria, descripcion, estado from tb_categoria";
        Statement st;
        try{
            
            st=con.createStatement();
            ResultSet rs =st.executeQuery(sql);
            InterGestionarCategorias.jTableCategorias=new JTable(model);
            InterGestionarCategorias.jScrollPane1.setViewportView(InterGestionarCategorias.jTableCategorias);
            
            model.addColumn("idCtegoria");
            model.addColumn("descripcion");
            model.addColumn("estado");
            
            while(rs.next()){
                Object fila[]= new Object[3];
                for(int i=0; i<3;i++){
                    fila[i]=rs.getObject(i+1);
                }
                model.addRow(fila);
                
            }
            con.close();
            
        }catch(SQLException e){
            System.out.println("Error al Llenar la Tabla Categoria, descripcion, estado from tb_categoria");
            
            
        }
        InterGestionarCategorias.jTableCategorias.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int filaPoint=InterGestionarCategorias.jTableCategorias.rowAtPoint(e.getPoint());
                int columnaPoint=0;
                if (filaPoint> -1){
                    idCategoria=(int)model.getValueAt(filaPoint,columnaPoint);
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                }
                
            }
        });
        
    }
    
    public void EnviarDatosCategoriaSeleccionada(int idCategoria){
        try{
            Connection con =Conexion.conectar();
            PreparedStatement pst=con.prepareStatement(
                    "select * from tb_categoria where idCategoria= '"+idCategoria+"'");
            ResultSet rs =pst.executeQuery();
            if (rs.next()){
                txtDescripcion.setText(rs.getString("descripcion"));                    
            }
            con.close();
        }catch(SQLException e){
            System.out.println("Error al Cargar Categoria"); 
        }   
    }

}
