package shoponline;

public class Accesorio extends Producto {
    private double pesoProducto;
    private Metal material;

    public Accesorio(double pesoProducto, Metal material, String descripcion, double costo) {
        super(descripcion, costo);
        this.pesoProducto = pesoProducto;
        this.material = material;
        this.costo = calcularCostoTotal();
    }

    @Override
    public double obtenerCostoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public enum Metal{
        ORO,
        PLATA,
        BRONCE;
    }
    
    @Override
    public String toString() {
        return super.toString() + " Material: " + this.material;
    }
    
    public double calcularCostoTotal() {
       return costo * pesoProducto;
    }
}
