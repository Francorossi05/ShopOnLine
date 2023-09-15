package shoponline;

public class Cliente {
    private String nombreCompleto;
    private String apellidoPaterno;
    private int numeroDni;
    private String numTelefono;
    private String ubicacion;

    public Cliente(String nombreCompleto, String apellidoPaterno, int numeroDni, String numTelefono, String ubicacion) {
        this.nombreCompleto = nombreCompleto;
        this.apellidoPaterno = apellidoPaterno;
        this.numeroDni = numeroDni;
        this.numTelefono = numTelefono;
        this.ubicacion = ubicacion;
    }

    public String obtenerNombre() {
        return nombreCompleto;
    }

    public String obtenerApellido() {
        return apellidoPaterno;
    }

    public int obtenerNumeroDni() {
        return numeroDni;
    }

    public String obtenerNumTelefono() {
        return numTelefono;
    }

    public String obtenerUbicacion() {
        return ubicacion;
    }
    
    public String mostrarInformacion(){
        String datos = " Nombre: " + this.nombreCompleto + " Apellido: " + this.apellidoPaterno + " DNI: " + this.numeroDni;
        return datos;
    }
}
