
package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InterGraficarVentas extends javax.swing.JInternalFrame {
        ArrayList<Integer>listaCantidad=new ArrayList<>();
        ArrayList<String>listaFecha=new ArrayList<>();
        String[] Vector_fechaVenta;
        int [] Vector_status_cantidad;
        
        
        int cantidadResultados =0;
    
            
    public InterGraficarVentas() {
        initComponents();
        this.setSize(779, 633);
        this.setTitle("Historial De Ventas");
        this.MetodoContador();
        Vector_fechaVenta=new String[cantidadResultados];
        Vector_status_cantidad=new int[cantidadResultados];
        this.MetodoAlmacenaDatos();
        
        
        
    }
    private int MetodoContador(){
        try {
            Connection con = conexion.Conexion.conectar();
            PreparedStatement pst=con.prepareStatement("select fechaVenta, count(fechaVenta)as Ventas from tb_cabecera_venta where fechaVenta BETWEEN'"+InterGraficas.fecha_inicio+"'and'"+InterGraficas.fecha_fin+"' group by fechaVenta;");
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                cantidadResultados++;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("eror en "+e);
        }
        return cantidadResultados;
    }
    
    private void MetodoAlmacenaDatos(){
        try {
            Connection con=conexion.Conexion.conectar();
            PreparedStatement pst=con.prepareStatement("select fechaVenta, count(fechaVenta)as Ventas from tb_cabecera_venta where fechaVenta BETWEEN'"+InterGraficas.fecha_inicio+"'and'"+InterGraficas.fecha_fin+"' group by fechaVenta;");
            ResultSet rs=pst.executeQuery();
            int contador=0;
            while(rs.next()){
                Vector_fechaVenta[contador]=rs.getString("fechaVenta");
                listaFecha.add(Vector_fechaVenta[contador]);
                Vector_status_cantidad[contador]=rs.getInt("Ventas");
                listaCantidad.add(Vector_status_cantidad[contador]); 
                contador++;
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("error en "+e);
        }
    }
    
    private int MetodoMayorVenta(ArrayList<Integer> listaCantidad ){
        int mayor=0;
        for (int i=0; i<listaCantidad.size(); i++){
            if (listaCantidad.get(i)>mayor){
                mayor=listaCantidad.get(i);
            }            
        }
        return mayor;
    }
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(221, 240, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto Condensed", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Grafica De Ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 140, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    @Override
    public void paint(Graphics g){
        super.paint(g);
        int mayorVenta= MetodoMayorVenta(listaCantidad);
        int largoNuevoIngreso=0;
        int parametro1=133;
        int parametroFecha=118;
        int parametro3=100; 
        
        for (int i =0; i<listaCantidad.size();i++){
            largoNuevoIngreso=  (listaCantidad.get(i)*500)/mayorVenta;
            if(i==0){
                g.setColor(new Color(140,0,75));
            }else if(i==1){
                g.setColor(new Color(255,0,0));
            }else if(i==2){
                g.setColor(new Color(0,0,0));
            }else if(i==3){
                g.setColor(new Color(183,85,175));
            }else if(i==4){
                g.setColor(new Color(0,85,70));
            }else if(i==5){
                g.setColor(new Color(0,0,255));
            }else if(i==6){
                g.setColor(new Color(255,127,0));
            }else{
                 g.setColor(new Color(204, 26, 224));
            }
            g.fillRect(100, parametro3,largoNuevoIngreso, 40);
            g.drawString(listaFecha.get(i),10 , parametroFecha);
            g.drawString("cantidad: "+listaCantidad.get(i),10, 1);
            parametro1+=50;
            parametroFecha+=50;
            parametro3+=50;
            
        }
        
        
    }

}
