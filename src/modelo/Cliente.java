package modelo;
public class Cliente {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String cedula;
    private String telefono;
    private String direccion;
    private int estado;   
    public Cliente(){        
    }
    public Cliente(int idCliente,String nombre,String apellido, String cedula, String telefono, String direccion, int estado){
        this.idCliente=idCliente;
        this.apellido=apellido;
        this.cedula=cedula;
        this.telefono=telefono;
        this.direccion=direccion;
        this.estado=estado;
    }
    public int getIdCliente(){
        return this.idCliente;
    }
    public void setIdCliente(int idCliente){
        this.idCliente=idCliente;
    }    
    public String getNombre(){
        return this.nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    public String getCedula(){
        return this.cedula;
    }
    public void setCedula(String cedula){
        this.cedula=cedula;
    }
    public String getTelefono(){
        return this.telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public int getEstado(){
        return this.estado;
    }
    public void setEstado(int estado){
        this.estado=estado;
    }  
}
