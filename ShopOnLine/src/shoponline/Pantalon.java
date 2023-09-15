package shoponline;

public class Pantalon extends Producto {
    private int talla;
    private ModeloPantalon modelo;

    public Pantalon(int talla, String descripcion, double costo, ModeloPantalon modelo) {
        super(descripcion, costo);
        this.talla = talla;
        this.modelo = modelo;
        this.costo = calcularCostoTotal(); // El valor que devuelve la función calcularCostoTotal() es el nuevo valor de la variable costo.
    }

    @Override
    public double obtenerCostoTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public enum ModeloPantalon {
        SKINNY(0.15),
        OXFORD(0.25),
        RECTO(0.15);
    
        private double incremento;

        private ModeloPantalon(double incremento) {
            this.incremento = incremento;
        }

        public double obtenerIncremento() {
            return incremento;
        }
    }

    @Override
    public String toString() {
        return super.toString() + " Modelo: " + this.modelo;
    }
    
    public double calcularCostoTotal() {
        double costoCalculado = costo; // Inicializamos con el costo original
    
        if (modelo == ModeloPantalon.OXFORD) {
            costoCalculado += costo * ModeloPantalon.OXFORD.obtenerIncremento(); // Sumamos el incremento
        } else if (modelo == ModeloPantalon.SKINNY) {
            costoCalculado += costo * ModeloPantalon.SKINNY.obtenerIncremento(); // Sumamos el incremento
        } else if (modelo == ModeloPantalon.RECTO) {
            costoCalculado -= costo * ModeloPantalon.RECTO.obtenerIncremento(); // Restamos el descuento
        }
    
        return costoCalculado;
    }
}
