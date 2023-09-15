package shoponline;

public class Remera extends Producto {
    private Talla tamanio;

    public Remera(Talla tamanio, String descripcion, double costo) {
        super(descripcion, costo);
        this.tamanio = tamanio;
        this.costo = calcularCostoTotal(); // El valor que devuelve la función calcularCostoTotal() es el nuevo valor de la variable costo.
    }

    @Override
    public double obtenerCostoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public enum Talla {
        S(1),
        M(0.05),
        L(0.10),
        XL(0.15);
    
        private double factor;

        private Talla(double factor) {
            this.factor = factor;
        }

        public double obtenerFactor() {
            return factor;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Talla: " + this.tamanio; 
    }

    public double calcularCostoTotal() {
        double costoCalculado = costo; // Inicializamos con el costo original
        if (tamanio == Talla.M) {
            costoCalculado += costo * Talla.M.obtenerFactor(); // Sumamos el incremento
        } else if (tamanio == Talla.L) {
            costoCalculado += costo * Talla.L.obtenerFactor();
        } else if (tamanio == Talla.XL) {
            costoCalculado += costo * Talla.XL.obtenerFactor();
        } else {
            costoCalculado = costo * Talla.S.obtenerFactor();
        }
        return costoCalculado;
    }   
}
