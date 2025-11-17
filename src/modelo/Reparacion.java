package modelo;
public class Reparacion {
    private int idReparacion;
    private int idCliente;
    private String fechaContrato;
    private String descripcion;
    private double precioReparacion;    
    public Reparacion(){
        this.idReparacion=0;
        this.idCliente=0;
        this.descripcion="";
        this.precioReparacion=0.0;        
    }
    public int getIdReparacion() {
        return this.idReparacion;
    }
    public void setIdReparacion(int idReparacion) {
        this.idReparacion = idReparacion;
    }
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public double getPrecioReparacion() {
        return precioReparacion;
    }
    public void setPrecioReparacion(double precioReparacion) {
        this.precioReparacion = precioReparacion;
    }
    public String getFechaContrato() {
        return fechaContrato;
    }
    public void setFechaContrato(String fechaContrato) {
        this.fechaContrato = fechaContrato;
    }    
}
